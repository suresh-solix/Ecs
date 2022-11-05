package arca.tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import arca.common.Navigation;
import arca.pages.Account_Settings;
import arca.pages.BusinessPremiumSignup;
import arca.pages.BusinessStandardSignup;
import arca.pages.CollectionsPage;
import arca.pages.CollectionsPageShare;
import arca.pages.DragDropMove;
import arca.pages.DragandDropCopyVersionUpdateExisting;
import arca.pages.DragandDropMoveKeepSeparateVersions;
import arca.pages.DragandDropMoveVersionUpdateExisting;
import arca.pages.DragandDropMoveVersions_Skip;
import arca.pages.ExportMetaData;
import arca.pages.FilePreview;
import arca.pages.Forgot_Password;
import arca.pages.MyFilesComments;
import arca.pages.MyFilesCopy;
import arca.pages.MyFilesDelete;
import arca.pages.MyFilesDownload;
import arca.pages.MyFilesMove;
import arca.pages.MyFilesReminders;
import arca.pages.MyFilesStarred;
import arca.pages.HomePage;
import arca.pages.Signup;
import arca.pages.Signup_Form;
import arca.pages.PermanentDelete;
import arca.pages.PersonalPremiumSignup;
import arca.pages.PersonalSignUp;
import arca.pages.PlusButtonUpload;
import arca.pages.RecentPageCollections;
import arca.pages.RecentPageComments;
import arca.pages.RecentPageCopyMove;
import arca.pages.RecentPageDelete;
import arca.pages.RecentPageShare;
import arca.pages.RecentPageTags;
import arca.pages.Rename;
import arca.pages.Retention;
import arca.pages.RightClickUpload;
import arca.pages.Search;
import arca.pages.ShareDataWithInternalUser;
import arca.pages.ShareLinkWithExternalUser;
import arca.pages.ShareLinkWithInternalUser;
import arca.pages.ShareDataWithExternalUser;
import arca.pages.SourceManager;
import arca.pages.MyFilesTags;
import arca.pages.MyFiles_Collection;
import arca.pages.MyFiles_Collections_Page;
import arca.pages.MyFiles_Details;
import arca.pages.MyFiles_Email_Integration;
import arca.pages.MyFiles_File_Preview;
import arca.pages.MyFiles_List_view;
import arca.pages.MyFiles_Recent_page;
import arca.pages.MyFiles_Reminders;
import arca.pages.MyFiles_Share_User_to_Group;
import arca.pages.MyFiles_Share_with_me_Page;
import arca.pages.MyFiles_Sorting_Files_Folders;
import arca.pages.MyFiles_Upload_Forms;
import arca.pages.MyFiles__PST__Extraction;
import arca.pages.MyFiles_share_Admin_to_Group;
import arca.pages.LegalHold;
import arca.pages.MyFile_Share_User_Admin;
import arca.pages.MyFilesCollections;
import arca.pages.Users;
import arca.pages.Groups;
import atu.testng.reports.ATUReports;
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
import atu.testng.reports.logging.LogAs;
import atu.testng.reports.utils.Utils;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;
import atu.testrecorder.ATUTestRecorder;

@Listeners({ ATUReportsListener.class, ConfigurationListener.class,MethodListener.class })

public class BrowserHandlings{
	
	private static WebDriver driver;
	private static Logger log=Logger.getLogger(BrowserHandlings.class.getName());

	HomePage mb;	
	PersonalSignUp mb1;
	PersonalPremiumSignup mb2;
	BusinessStandardSignup mb3;
	BusinessPremiumSignup mb4;
	Signup mb5;
	RightClickUpload mb6;
	MyFilesStarred mb7;
	MyFilesTags mb8;
	MyFilesComments mb9;
	MyFilesDelete mb10;
	MyFilesDownload mb100;
	MyFilesCopy mb11;
	MyFilesMove mb12;
	RecentPageComments mb13;
	RecentPageTags mb14;
	RecentPageCopyMove mb15;
	ShareDataWithInternalUser mb16;
	MyFilesCollections mb17;
	RecentPageCollections mb18;
	CollectionsPage mb19;
	RecentPageShare mb20;
	RecentPageDelete mb21;
	CollectionsPageShare mb22;
	MyFilesReminders mb23;
	ShareDataWithExternalUser mb24;
	ShareLinkWithExternalUser mb25;
	ShareLinkWithInternalUser mb26;
	ExportMetaData mb27;
	Rename mb28;
	FilePreview mb29;
	DragDropMove mb30;
	DragandDropMoveVersionUpdateExisting mb31;
	DragandDropCopyVersionUpdateExisting mb32;
	DragandDropMoveKeepSeparateVersions mb33;
	DragandDropMoveVersions_Skip mb34;
	MyFiles_Collection mb35;
	MyFile_Share_User_Admin mb36;
	MyFiles_share_Admin_to_Group mb37;
	MyFiles_Share_User_to_Group mb38;
	MyFiles_Reminders mb39;
	MyFiles_File_Preview mb40;
	MyFiles_Recent_page mb41;
	MyFiles__PST__Extraction mb42;
	MyFiles_List_view mb43;
	MyFiles_Collections_Page mb44;
	MyFiles_Share_with_me_Page mb45;
	MyFiles_Sorting_Files_Folders mb46;
	MyFiles_Details mb47;
	MyFiles_Upload_Forms mb48;
	MyFiles_Email_Integration mb49;
	Signup_Form mb50;
	Forgot_Password mb51;
	Account_Settings mb52;
	
	
	
	ATUTestRecorder recorder;
	
	
	
	public void setUp()
	{
		
		try
		{   
		
			
			FirefoxProfile profile = new FirefoxProfile();
            profile.setPreference("network.proxy.type", 0);               
            driver = new FirefoxDriver();
			
			
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
        
	}

	 public void openSpecificBrowser(String browserName) throws MalformedURLException
	 {
		 	String remoteWebDriverUrl="";
		 	if(browserName.toLowerCase().contains("remote"))
		 	{
		 		remoteWebDriverUrl=browserName.substring(browserName.indexOf('.')+1);
		 		browserName=browserName.split("\\.")[0];
		 		System.out.println("remoteWebDriverUrl:"+remoteWebDriverUrl);
		 	}
		 	String chromeDriverExt=".exe";
		 	String typeOfOs=System.getProperty("os.name").toLowerCase();
		 	if(typeOfOs.equals("linux"))
		 	chromeDriverExt="";
		 	
		 	
		 	System.out.println("browserName:"+browserName);
			switch(browserName.toLowerCase())
			{
			
			
				case "firefox":
				driver=new FirefoxDriver();
				break;
				case "chrome":
				
				System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+System.getProperty("file.separator")+"chromedriver"+chromeDriverExt);
				driver = new ChromeDriver();
		       
				
				
		        
		        break;
				case "ie":System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+System.getProperty("file.separator")+"IEDriverServer.exe");
		        //driver = new InternetExplorerDriver();
				driver = new EdgeDriver();
		        break;
				case "remotefirefox":
		        driver = new RemoteWebDriver(new URL(remoteWebDriverUrl),DesiredCapabilities.firefox());
		        break;
				case "remotechrome":
				System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+System.getProperty("file.separator")+"chromedriver.exe");	
			    driver = new RemoteWebDriver(new URL(remoteWebDriverUrl),DesiredCapabilities.chrome());
			    break;
				case "remoteie":
				System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+System.getProperty("file.separator")+"IEDriverServer.exe");
			    driver = new RemoteWebDriver(new URL(remoteWebDriverUrl),DesiredCapabilities.internetExplorer());
		        break;
			}
			
	 }

	
//added by pradeep
   public static String appendText;
   
	@Parameters("browserName")
	@BeforeTest
	public void beforetest(@Optional("browserName") String browserName) throws Exception
	{
		openSpecificBrowser(browserName); 
		DOMConfigurator.configure("log4j.xml");
		System.setProperty("atu.reporter.config", System.getProperty("user.dir") + System.getProperty("file.separator") + "atu.properties");
	  	ATUReports.setWebDriver(driver);
	  	setRunDescription();
	  	ATUReports.setTestCaseReqCoverage("ARCA Home Page");
	  	setAuthorInfoForReports();

		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS).pageLoadTimeout(60, TimeUnit.SECONDS); 
		
	 
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();


	
	}
	
	   private void setAuthorInfoForReports() {
	       ATUReports.setAuthorInfo("ARCA", Utils.getCurrentTime(),"1.0");
	    }
		private void setRunDescription() {
		       ATUReports.currentRunDescription = "Executing Home Page";
		}
		


		
		/*
		 * 
		 * //@Test(enabled=false)
		 * 
		 * @Test(priority= 1) public void Home_Pages_Load() throws Exception { { mb =new
		 * HomePage(driver); mb.HomePage_Load();
		 * 
		 * } }
		 * 
		 * 
		 * 
		 * 
		 * //@Test(enabled=false)
		 * 
		 * @Test(priority = 2) public void personal_signUp() throws Exception { {
		 * 
		 * mb1 = new PersonalSignUp(driver); mb1.individual_personal_signup();
		 * 
		 * } }
		 * 
		 * 
		 * 
		 * //@Test(enabled=false)
		 * 
		 * @Test(priority = 3) public void personal_premium_signup() throws Exception {
		 * {
		 * 
		 * mb2 = new PersonalPremiumSignup(driver);
		 * mb2.individual_personal_premium_signup();
		 * 
		 * } }
		 * 
		 * 
		 * //@Test(enabled=false)
		 * 
		 * @Test(priority = 4) public void business_standard_signup() throws Exception {
		 * {
		 * 
		 * mb3 = new BusinessStandardSignup(driver); mb3.bussiness_standard_signup();
		 * 
		 * } }
		 * 
		 * 
		 * //@Test(enabled=false)
		 * 
		 * @Test(priority = 5) public void business_premium_signup() throws Exception {
		 * {
		 * 
		 * mb4 = new BusinessPremiumSignup(driver); mb4.bussiness_premium_signup();
		 * 
		 * } }
		 * 
		 * 
		 * 
		 * 
		 * 
		 * //@Test(enabled=false)
		 * 
		 * @Test(priority = 6) public void login_page() throws Exception { {
		 * 
		 * mb5 = new Signup(driver); mb5.Signup_ecs();
		 * 
		 * } }
		 * 
		 * 
		 * 
		 * 
		 * //@Test(enabled=false)
		 * 
		 * @Test(priority = 7) public void rightclick_createfolder() throws Exception {
		 * {
		 * 
		 * mb6 = new RightClickUpload(driver);
		 * RightClickUpload.right_click_create_folder();
		 * 
		 * } }
		 * 
		 * 
		
		
		
		// @Test(enabled=false)
		@Test((priority = 8)
		public void rightclick_singlefileupload() throws Exception {
			{

				mb6 = new RightClickUpload(driver);
				RightClickUpload.right_click_single_file_upload();

			}
		}
		
		*/
		
		
		
		
//		// @Test(enabled=false)
//		
//		
//				@Test(priority = 9)
//				public void addcomments_tofolder() throws Exception {
//					{
//						mb9 = new MyFilesComments(driver);
//						MyFilesComments.add_comments_to_folder();
//						
//					}
//				}
//				
//				@Test(priority = 10)
//				public void editcomments_tofolder() throws Exception {
//					{
//
//						
//						MyFilesComments.edit_comments_to_folder();
//						
//
//					}
//				}
//				
//				
//				@Test(priority = 11)
//				public void deletecomments_tofolder() throws Exception {
//					{
//
//						
//						MyFilesComments.delete_comments_to_folder();
//						
//				
//
//					}
//				}
//				
//				
//				//----------------Commented-------------
//				
//				
//				@Test(priority = 12)
//				public void addcomments_tofile() throws Exception {
//					{
//						mb9 = new MyFilesComments(driver);
//						MyFilesComments.add_comments_to_file();
//		
//
//					}
//				}
//
//				@Test(priority = 13)
//				public void editcomments_tofile() throws Exception {
//					{
//
//						MyFilesComments.edit_comments_to_file();
//
//					}
//				}
//				
//				
//				@Test(priority = 14)
//				public void deletecomments_tofile() throws Exception {
//					{
//
//						MyFilesComments.delete_comments_to_file();
//
//					}
//				}
//				
//		
//		
//			
//		
//		
//		// @Test(enabled=false)
//		@Test(priority = 15)
//		public void add_tags_multiple_folders() throws Exception {
//			{
//
//				mb8 = new MyFilesTags(driver);
//				MyFilesTags.add_tag_multiple_folders();
//		
//
//			}
//		}
//		
//		
//		// @Test(enabled=false)
//				@Test(priority = 16)
//				public void remove_tags_multiple_folders() throws Exception {
//					{
//
//						//Multiple tag remove functionality is removed
//						//MyFilesTags.remove_tag_multiple_folders();
//				
//
//					}
//				}
//				
//				
//		
//		
//				// @Test(enabled=false)
//				@Test(priority = 17)
//				public void add_tags_multiple_files() throws Exception {
//					{
//						mb8 = new MyFilesTags(driver);
//						MyFilesTags.add_tag_multiple_files();
//
//					}
//				}
//				
//				
//				// @Test(enabled=false)
//				@Test(priority = 18)
//				public void remove_tags_multiple_files() throws Exception {
//					{
//
//						//Multiple tag remove functionality is removed
//						//MyFilesTags.remove_tag_multiple_files();
//
//					}
//				}
//				
//				
//				@Test(priority = 19)
//				public void multiple_files_folders_addtags() throws Exception {
//					{
//						//mb8 = new MyFilesTags(driver);
//						MyFilesTags.add_tag_multiple_folders_files();
//					
//					}
//				}
//				
//				
//				
//				 
//				
//				
//				@Test(priority = 20)
//				public void multiple_files_folders_removetags() throws Exception {
//					{
//						//Multiple tag remove functionality is removed
//						//MyFilesTags.remove_tag_multiple_folders_files();
//					}
//				}
//				
//		
//				
//	
//			
//				@Test(priority = 21)
//				public void multiple_files_copy() throws Exception {
//					{
//						mb11 = new MyFilesCopy(driver);
//						MyFilesCopy.multiple_files_copy();
//						
//					}
//				}
//				
//				
//				
//				@Test(priority = 22)
//				public void multiple_folders_copy() throws Exception {
//					{
//						
//						MyFilesCopy.multiple_folders_copy();
//						
//					}
//				}
//				
//				
//				
//				@Test(priority = 23)
//				public void multiple_files_folders_copy() throws Exception {
//					{
//						
//						MyFilesCopy.multiple_files_folders_copy();
//						
//					}
//				}
//				
//				
//				
//				
//				
//		@Test(priority = 24)
//		public void multiple_files_move() throws Exception {
//			{
//				mb12 = new MyFilesMove(driver);
//				MyFilesMove.multiple_files_move();
//				
//			}
//		}
//		
//		@Test(priority = 25)
//		public void multiple_folders_move() throws Exception {
//			{
//				
//				MyFilesMove.multiple_folders_move();
//				
//			}
//		}
//
//		@Test(priority = 26)
//		public void multiple_file_folders_move() throws Exception {
//			{
//				
//				MyFilesMove.multiple_files_folders_move();
//				
//			}
//		}
//		
//		
//		
//		
//				@Test(priority = 27)
//				public void myfiles_collection() throws Exception {
//					{
//						mb17 = new MyFilesCollections(driver);
//						MyFilesCollections.add_files_to_collection();
//						//MyFilesCollections.add_files_to_collection(); //Need to write edit 
//						//MyFilesCollections.add_files_to_collection(); //Need to write delete
//						
//					}
//				}
//	
//		 
//		
//				
//		@Test(priority = 28)
//		public void sharefile_with_user_editpermission() throws Exception {
//			{
//				mb16 = new ShareDataWithInternalUser(driver);
//				ShareDataWithInternalUser.share_data_with_user_edit_permission();
//				ShareDataWithInternalUser.share_data_with_user_edit_permission_confirmation();
//				
//				
//			}
//		}	
//		
//		
//		@Test(priority = 29)
//		public void sharefile_with_user_commenterpermission() throws Exception {
//			{
//				//mb16 = new ShareDataWithInternalUser(driver);
//				ShareDataWithInternalUser.share_data_with_user_commenter_permission();
//				ShareDataWithInternalUser.share_data_with_user_commenter_permission_confirmation();
//				
//				
//			}
//		}
//		
//		
//		@Test(priority = 30)
//		public void sharefile_with_user_viewpermission() throws Exception {
//			{
//				
//				ShareDataWithInternalUser.share_data_with_user_view_permission();
//				ShareDataWithInternalUser.share_data_with_user_view_permission_confirmation();
//				
//				
//			}
//		}
//			
//		@Test(priority = 31)
//		public void sharefile_with_user_previewpermission() throws Exception {
//			{
//				
//				ShareDataWithInternalUser.share_data_with_user_preview_permission();
//				ShareDataWithInternalUser.share_data_with_user_preview_permission_confirmation();
//				
//				
//			}
//		}
//
//
//		@Test(priority = 32)
//		public void sharefile_with_user_uploadpermission() throws Exception {
//			{
//				
//				ShareDataWithInternalUser.share_data_with_user_upload_permission();
//				ShareDataWithInternalUser.share_data_with_user_upload_permission_confirmation();
//				
//			}
//		}
//		
//		@Test(priority = 33)
//		public void sharefile_with_user_remove_permission() throws Exception {
//			{
//				
//				ShareDataWithInternalUser.share_data_with_user_remove_permission();
//				
//				
//			}
//		}
//		
//		
//		
//		
//		
//		// @Test(enabled=false)
//		@Test(priority = 34)
//		public void delete_files() throws Exception {
//			{
//
//				mb10 = new MyFilesDelete(driver);
//				MyFilesDelete.mul_file_delete();
//
//			}
//		}
//		
//		
//		
//		
//		@Test(priority = 35)
//		public void restore__mul_files() throws Exception {
//			{
//
//				
//				MyFilesDelete.mul_files_restore();
//			
//			}
//		}
//		
//		
//	
//		@Test(priority = 36)
//		public void delete_mul_folders() throws Exception {
//			{
//				
//				MyFilesDelete.mul_folders_delete();
//
//			}
//		}
//		 
//		
//		@Test(priority = 37)
//		public void restore_mul_folders() throws Exception {
//			{
//				
//				MyFilesDelete.mul_folders_restore();
//
//			}
//		}
//		
//		
//		@Test(priority = 38)
//		public void delete_files_folders() throws Exception {
//			{
//				
//				MyFilesDelete.mul_files_folders_delete();
//
//			}
//		}
//		
//		
//		@Test(priority = 39)
//		public void restore_files_folders() throws Exception {
//			{
//
//				MyFilesDelete.mul_files_folders_restore();
//
//			}
//		}
//		
//		
//		
//		
//		@Test(priority = 40)
//		public void files_download() throws Exception {
//			{
//
//				mb100 = new MyFilesDownload(driver);
//				MyFilesDownload.mul_file_download();
//
//			}
//		}
//		
//		
//		@Test(priority = 41)
//		public void folders_download() throws Exception {
//			{
//
//				MyFilesDownload.mul_folders_download();
//
//			}
//		}
//		
//		
//		@Test(priority = 42)
//		public void files_folders_download() throws Exception {
//			{
//
//				MyFilesDownload.mul_files_folders_download();
//
//			}
//		}
//		
//		
//		
//		
//		
//		@Test(priority = 43)
//		public void files_reminder() throws Exception {
//			{
//				mb23 = new MyFilesReminders(driver);
//				MyFilesReminders.file_reminder();
//				
//
//			}
//		}
//		
//		
//		@Test(priority = 44)
//		public void folder_reminder() throws Exception {
//			{
//				
//				MyFilesReminders.folder_reminder();
//
//			}
//		}
//		
//		
//		
//		
//		
//		
//		
//		@Test(priority = 45)
//		public void Share_data_with_external_user_edit_permission() throws Exception {
//			{
//				mb24 = new ShareDataWithExternalUser(driver);
//				ShareDataWithExternalUser.share_data_with_external_user_edit_permission();
//				ShareDataWithExternalUser.share_data_with_user_edit_permission_confirmation();
//			
//				
//
//			}
//		}
//		
//		
//		@Test(priority = 46)
//		public void Share_data_with_external_user_commenter_permission() throws Exception {
//			{
//				
//				ShareDataWithExternalUser.share_data_with_user_commenter_permission();
//				ShareDataWithExternalUser.share_data_with_user_commenter_permission_confirmation();
//				
//				
//
//			}
//		}
//			
//		@Test(priority = 47)
//		public void Share_data_with_external_user_view_permission() throws Exception {
//			{
//				
//				ShareDataWithExternalUser.share_data_with_user_view_permission();
//				ShareDataWithExternalUser.share_data_with_user_view_permission_confirmation();
//			
//
//			}
//		}
//			
//		@Test(priority = 48)
//		public void Share_data_with_external_user_preview_permission() throws Exception {
//			{
//				
//				ShareDataWithExternalUser.share_data_with_user_preview_permission();
//				ShareDataWithExternalUser.share_data_with_user_preview_permission_confirmation();
//				
//				
//
//			}
//		}
//			
//		@Test(priority = 49)
//		public void Share_data_with_external_user_upload_permission() throws Exception {
//			{
//				
//				ShareDataWithExternalUser.share_data_with_user_upload_permission();
//				ShareDataWithExternalUser.share_data_with_user_upload_permission_confirmation();
//				
//
//			}
//		}
//		
//		@Test(priority = 50)
//		public void Share_data_with_external_user_remove_permission() throws Exception {
//			{
//				//mb24 = new ShareDataWithExternalUser(driver);
//				ShareDataWithExternalUser.share_data_with_user_remove_permission();
//				
//
//			}
//		}
//			
//			
//		
//		
//		@Test(priority = 51)
//		public void Share_link_with_external_user() throws Exception {
//			{
//				mb25 = new ShareLinkWithExternalUser(driver);
//				ShareLinkWithExternalUser.share_folder_link_with_external_user();
//				//ShareLinkWithExternalUser.shared_existing_link_edit();
//			
//				//ShareLinkWithExternalUser.shared_existing_link_delete();
//
//			}
//		}
//		
//		
//		@Test(priority = 52)
//		public void Share_link_with_external_user_download() throws Exception {
//			{
//				
//				
//				ShareLinkWithExternalUser.share_folder_with_download_permission();
//				
//			}
//		}
//		
//		
//		@Test(priority = 53)
//		public void Share_inactive_link_with_external_user() throws Exception {
//			{
//				
//				ShareLinkWithExternalUser.inactive_share_folder();
//				
//
//			}
//		}
//		
//		
//		
//		
//		
//		@Test(priority = 54)
//		public void Share_link_with_user_edit() throws Exception {
//			{
//				mb26 = new ShareLinkWithInternalUser(driver);
//				ShareLinkWithInternalUser.share_folder_link_with_user_edit_permission();
//				ShareLinkWithInternalUser.share_data_with_user_edit_permission_confirmation();
//				
//			}
//		}
//		
//		
//		@Test(priority = 55)
//		public void Share_link_with_user_commenter() throws Exception {
//			{
//				
//				ShareLinkWithInternalUser.share_data_with_user_commenter_permission();
//				ShareLinkWithInternalUser.share_data_with_user_commenter_permission_confirmation();
//				
//			}
//		}
//		
//		@Test(priority = 56)
//		public void Share_link_with_user_view() throws Exception {
//			{
//				
//				
//				ShareLinkWithInternalUser.share_data_with_user_view_permission();
//				ShareLinkWithInternalUser.share_data_with_user_view_permission_confirmation();
//				
//			}
//		}
//		 
//		@Test(priority = 57)
//		public void Share_link_with_user_preview() throws Exception {
//			{
//				
//				
//			
//				ShareLinkWithInternalUser.share_data_with_user_preview_permission();
//				ShareLinkWithInternalUser.share_data_with_user_preview_permission_confirmation();
//				
//			}
//		}
//		
//		
//		@Test(priority = 58)
//		public void Share_link_with_user_upload() throws Exception {
//			{
//				
//				
//			
//				ShareLinkWithInternalUser.share_data_with_user_upload_permission();
//				ShareLinkWithInternalUser.share_data_with_user_upload_permission_confirmation();
//			}
//		}
//		 
//		 
//		 
//		 
//		
//		
//		@Test(priority = 59)
//		public void folder_export_metadata() throws Exception {
//			{
//				mb27 = new ExportMetaData(driver);
//				ExportMetaData.folder_export_metadata_myfiles();
//			
//			}
//		}
//		
//		
//		
//		@Test(priority = 60)
//		public void file_rename() throws Exception {
//			{
//				mb28 = new Rename(driver);
//				Rename.rename_file();
//				
//			
//			}
//		}
//		
//		@Test(priority = 61)
//		public void folder_rename() throws Exception {
//			{
//				
//				Rename.rename_folder();
//			
//			}
//		}
//		
//		
//		@Test(priority = 62)
//		public void file_preview() throws Exception {
//			{
//				mb29 = new FilePreview(driver);
//				FilePreview.file_preveiw();
//
//			
//			}
//		}
		
		
		//======================================================================================
		//--------------------------Drag and Drop Move ------------------------------------ 5 TC


//		@Test(priority = 64) 
//		public void dDragDropMove_File() throws Exception{
//			{
//				mb30 = new DragDropMove(driver);
//				DragDropMove.DragDropMove_File();
//			}
//
//		} 																				
//
//
//		@Test(priority = 65) public void DragDropMove_Folder() throws Exception { 
//			{
//				mb30 = new DragDropMove(driver);
//				DragDropMove.DragDropMove_Folder();
//			}
//
//		}
//
//
//
//		@Test(priority = 66) 
//		public void DragDropMove_multiple_files() throws Exception {
//			{
//				mb30 = new DragDropMove(driver); 
//				DragDropMove.DragDropMove_multiple_files();
//			}
//		}
//
//
//		@Test(priority =67)
//		public void DragDropMove_multiple_folders() throws Exception {
//			{
//				mb30 = new DragDropMove(driver);
//				DragDropMove.DragDropMove_multiple_Folders();
//			}
//		}																					
//
//
//		@Test(priority =63)
//		public void DragDropMove_multiple_Data() throws Exception { 
//			{ 
//				mb30 = new DragDropMove(driver);
//				DragDropMove.DragDropMove_multiple_Data();
//			}
//
//		}
//
//
//		//-----------------------DragandDropCopyVersionUpdateExisting ------------------------------  3 TC
//
//		@Test(priority =68)
//		public void DragandDropCopyVersionUpdateExisting_multiple_files() throws Exception   {
//			{
//				mb32 = new DragandDropCopyVersionUpdateExisting(driver);
//				DragandDropCopyVersionUpdateExisting.DragandDropCopyVersionUpdateExisting_multiple_files();
//			}		  
//
//		}
//
//		@Test(priority =69)
//		public void DragandDropCopyVersionUpdateExisting_multiple_folders() throws Exception   {
//			{
//				mb32 = new DragandDropCopyVersionUpdateExisting(driver);
//				DragandDropCopyVersionUpdateExisting.DragandDropCopyVersionUpdateExisting_multiple_folders();
//			}		  
//
//		}
//
//		@Test(priority =70)
//		public void DragandDropCopyVersionUpdateExisting_multiple_files_folders() throws Exception   {
//			{
//				mb32 = new DragandDropCopyVersionUpdateExisting(driver);
//				DragandDropCopyVersionUpdateExisting.DragandDropCopyVersionUpdateExisting_multiple_files_folders();
//			}		  
//
//		}
//
//
//		//--------------------------DragandDropMoveVersionUpdateExisting ---------------------------3 TC
//
//
//
//		@Test(priority =71)
//		public void DragandDropMoveVersionUpdateExisting_Multiple_files() throws Exception   {
//			{
//				mb31 = new DragandDropMoveVersionUpdateExisting(driver);
//				DragandDropMoveVersionUpdateExisting.DragandDropMoveVersionUpdateExisting_Multiple_files();
//			}
//		}
//
//
//		@Test(priority =72)
//		public void DragandDropMoveVersionUpdateExisting_Multiple_folders() throws Exception   {
//			{
//				mb31 = new DragandDropMoveVersionUpdateExisting(driver);
//				DragandDropMoveVersionUpdateExisting.DragandDropMoveVersionUpdateExisting_Multiple_folders();
//			}
//		}
//
//
//		@Test(priority =73)
//		public void DragandDropMoveVersionUpdateExisting_Multi_files_folders() throws Exception   {
//			{
//				mb31 = new DragandDropMoveVersionUpdateExisting(driver);
//				DragandDropMoveVersionUpdateExisting.DragandDropMoveVersionUpdateExisting_Multi_files_folders();
//			}
//		}		  
//
//
//
//
//		//------------------------------ DragandDropMoveKeepSeparateVersions - ---------------------------- 3 TC
//
//		@Test(priority =74)
//		public void DragandDropMoveKeepSeparateVersions_Files() throws Exception   {
//			{
//				mb33 = new DragandDropMoveKeepSeparateVersions(driver);
//				DragandDropMoveKeepSeparateVersions.DragandDropMoveKeepSeparateVersions_multiple_Files();
//			}		  
//
//		}
//
//		@Test(priority =75)
//		public void DragandDropMoveKeepSeparateVersions_multiple_Folders() throws Exception   {
//			{
//				mb33 = new DragandDropMoveKeepSeparateVersions(driver);
//				DragandDropMoveKeepSeparateVersions.DragandDropMoveKeepSeparateVersions_multiple_Folders();
//			}		  
//
//		}
//
//		@Test(priority =76)
//		public void DragandDropMoveKeepSeparateVersions_multiple_Files_Folders() throws Exception   {
//			{
//				mb33 = new DragandDropMoveKeepSeparateVersions(driver);
//				DragandDropMoveKeepSeparateVersions.DragandDropMoveKeepSeparateVersions_multiple_Files_Folders();
//			}		  
//
//		}
//
//
//
//		//--------------------------------- DragandDropMoveVersions_Skip --------------------------------------
//
//
//		@Test(priority =77)
//		public void DragandDropMoveVersions_Skip_Files() throws Exception   {
//			{
//				mb34 = new DragandDropMoveVersions_Skip(driver);
//				DragandDropMoveVersions_Skip.DragandDropMoveVersions_Skip_Files();
//			}		  
//		}
//
//
//
//		@Test(priority =78)
//		public void DragandDropMoveVersions_Skip_Folders() throws Exception   {
//			{
//				mb34 = new DragandDropMoveVersions_Skip(driver);
//				DragandDropMoveVersions_Skip.DragandDropMoveVersions_Skip_Folders();
//			}		  
//		}
//
//
//
//
//		//-------------------------MyFiles_Collection----------------------
//
//
//		@Test(priority =79)
//		public void MyFiles_Collection() throws Exception   {
//			{
//				mb35 = new MyFiles_Collection(driver);
//				MyFiles_Collection.MyFiles_Collection();
//			}		  
//		}
//
//
//		@Test(priority =80)
//		public void MyFiles_Collections_Restriction() throws Exception   {
//			{
//				mb35 = new MyFiles_Collection(driver);
//				MyFiles_Collection.MyFiles_Collections_Restriction();
//			}		  
//
//		}
//
//
//
//		//--------------------------MyFile_Share_User_Admin-------------------------------
//
//
//		@Test(priority =81)
//		public void MyFile_Share_User_Admin_Muti_data_Edit_Permission() throws Exception   {
//			{
//				mb36 = new MyFile_Share_User_Admin(driver);
//				MyFile_Share_User_Admin.MyFile_Share_User_Admin_Muti_data_Edit_Permission();
//				MyFile_Share_User_Admin. MyFile_Share_User_Admin_Muti_data_Edit_Permission_confirmation();
//			}		  
//		}
//
//
//		@Test(priority =82)
//		public void MyFile_Share_User_Admin_Muti__commenter_permission() throws Exception   {
//			{
//				mb36 = new MyFile_Share_User_Admin(driver);
//				MyFile_Share_User_Admin.MyFile_Share_User_Admin_Muti__commenter_permission();
//				MyFile_Share_User_Admin.MyFile_Share_User_Admin_Muti__commenter_permission_Confirmation();
//			}		  
//		}
//
//
//
//		@Test(priority =83)
//		public void MyFile_Share_User_Admin_Muti__View_permission() throws Exception   {
//			{
//				mb36 = new MyFile_Share_User_Admin(driver);
//				MyFile_Share_User_Admin.MyFile_Share_User_Admin_Muti__View_permission();
//				MyFile_Share_User_Admin.MyFile_Share_User_Admin_Muti__View_permission_Confirmation();
//			}
//		}
//
//		@Test(priority =84)
//		public void MyFile_Share_User_Admin_Muti_Preview_Permission() throws Exception   {
//			{
//				mb36 = new MyFile_Share_User_Admin(driver);
//				MyFile_Share_User_Admin.MyFile_Share_User_Admin_Muti_Preview_Permission();
//				MyFile_Share_User_Admin.MyFile_Share_User_Admin_Muti_Preview_Permission_Confirmation();	  
//			}
//		}
//
//
//		@Test(priority =85)
//		public void MyFile_Share_User_Admin_Muti_Upload_Permission() throws Exception   {
//			{
//				mb36 = new MyFile_Share_User_Admin(driver);
//				MyFile_Share_User_Admin.MyFile_Share_User_Admin_Muti_Upload_Permission();
//				MyFile_Share_User_Admin.MyFile_Share_User_Admin_Muti_Upload_Permission_Confirmation();
//			}
//		}
//
//
//		@Test(priority =86)
//		public void MyFile_Share_User_Admin_Remove_Files_Folders() throws Exception   {
//			{
//				mb36 = new MyFile_Share_User_Admin(driver);
//				MyFile_Share_User_Admin.MyFile_Share_User_Admin_Remove_Files_Folders();
//			}	 
//		}
//
//
//
//
//
//		//----------------------------MyFiles_share_Admin_to_Group-------------------------------
//
//		@Test(priority =87)
//		public void MyFiles_share_Admin_to_Group_Edit_Permission() throws Exception   {
//			{
//				mb37 = new MyFiles_share_Admin_to_Group(driver);
//				MyFiles_share_Admin_to_Group.MyFiles_share_Admin_to_Group_Edit_Permission();
//			}	 
//		}
//
//		@Test(priority =88)
//		public void MyFiles_share_Admin_to_Group_Commenter_Permission() throws Exception   {
//			{
//				mb37 = new MyFiles_share_Admin_to_Group(driver);
//				MyFiles_share_Admin_to_Group.MyFiles_share_Admin_to_Group_Commenter_Permission();
//			}	 
//		}
//
//
//		@Test(priority =89)
//		public void MyFiles_share_Admin_to_Group_View_Permission() throws Exception   {
//			{
//				mb37 = new MyFiles_share_Admin_to_Group(driver);
//				MyFiles_share_Admin_to_Group.MyFiles_share_Admin_to_Group_View_Permission();
//			}	 
//		}
//
//
//		@Test(priority =90)
//		public void MyFiles_share_Admin_to_Group_Preview_Permission() throws Exception   {
//			{
//				mb37 = new MyFiles_share_Admin_to_Group(driver);
//				MyFiles_share_Admin_to_Group.MyFiles_share_Admin_to_Group_Preview_Permission();
//			}	 
//		}
//
//
//		@Test(priority =91)
//		public void MyFiles_share_Admin_to_Group_Upload_Permission() throws Exception   {
//			{
//				mb37 = new MyFiles_share_Admin_to_Group(driver);
//				MyFiles_share_Admin_to_Group.MyFiles_share_Admin_to_Group_Upload_Permission();
//			}	 
//		}
//
//
//		@Test(priority =92)
//		public void MyFiles_share_Admin_to_Group_Remove_Files_And_Folders() throws Exception   {
//			{
//				mb37 = new MyFiles_share_Admin_to_Group(driver);
//				MyFiles_share_Admin_to_Group.MyFiles_share_Admin_to_Group_Remove_Files_And_Folders();
//			}	 
//		}
//
//
//
//
//		//--------------------------------MyFiles_Share_User_to_Group---------------------------
//
//
//		@Test(priority =93)
//		public void MyFiles_share_User_to_Group_Edit_Permission() throws Exception   {
//			{
//				mb38 = new MyFiles_Share_User_to_Group(driver);
//				MyFiles_Share_User_to_Group.MyFiles_share_User_to_Group_Edit_Permission();
//			}	 
//		}
//
//		@Test(priority =94)
//		public void MyFiles_share_User_to_Group_Commenter_Permission() throws Exception   {
//			{
//				mb38 = new MyFiles_Share_User_to_Group(driver);
//				MyFiles_Share_User_to_Group.MyFiles_share_User_to_Group_Commenter_Permission();
//			}	 
//		}
//
//		@Test(priority =95)
//		public void MyFiles_share_User_to_Group_View_Permission() throws Exception   {
//			{
//				mb38 = new MyFiles_Share_User_to_Group(driver);
//				MyFiles_Share_User_to_Group.MyFiles_share_User_to_Group_View_Permission();
//			}	 
//		}
//
//
//		@Test(priority =96)
//		public void MyFiles_share_User_to_Group_Preview_Permission() throws Exception   {
//			{
//				mb38 = new MyFiles_Share_User_to_Group(driver);
//				MyFiles_Share_User_to_Group.MyFiles_share_User_to_Group_Preview_Permission();
//			}	 
//		}
//
//
//		@Test(priority =97)
//		public void MyFiles_share_User_to_Group_Upload_Permission() throws Exception   {
//			{
//				mb38 = new MyFiles_Share_User_to_Group(driver);
//				MyFiles_Share_User_to_Group.MyFiles_share_User_to_Group_Upload_Permission();
//			}	 
//		}
//
//
//		@Test(priority =98)
//		public void MyFiles_share_User_to_Group_Remove_Files_And_Folders() throws Exception   {
//			{
//				mb38 = new MyFiles_Share_User_to_Group(driver);
//				MyFiles_Share_User_to_Group.MyFiles_share_User_to_Group_Remove_Files_And_Folders();
//			}	 
//		}
//
//
//
//		//----------------------------------MyFiles_Reminders-----------------------------------------------
//
//		@Test(priority =99)
//		public void MyFiles_Reminders_Files() throws Exception   {
//			{
//				mb39 = new MyFiles_Reminders(driver);
//				MyFiles_Reminders.MyFiles_Reminders_Files();
//				MyFiles_Reminders.MyFiles_Reminders_Files_Edit();
//				MyFiles_Reminders.MyFiles_Reminders_Files_Bell_Icon();
//				MyFiles_Reminders.MyFiles_Reminders_Delete();
//			}
//		}
//
//		@Test(priority =100)
//		public void MyFiles_Reminders_Folders() throws Exception   {
//			{
//				mb39 = new MyFiles_Reminders(driver);
//				MyFiles_Reminders.MyFiles_Reminders_Folders();
//				MyFiles_Reminders.MyFiles_Reminders_Folders_Edit();
//				MyFiles_Reminders.MyFiles_Reminders_Folder_Bell_Icon();
//				MyFiles_Reminders.MyFiles_Reminders_Folder_Delete();
//			}
//		}
//
//
//		//----------------------------------------MyFiles_File_Preview----------------------------------
//
//
//		@Test(priority =101)
//		public void MyFiles_File_Preview_Right_and_Left_Naviation() throws Exception   {
//			{
//				mb40 = new MyFiles_File_Preview(driver);
//				MyFiles_File_Preview.MyFiles_File_Preview_Right_and_Left_Naviation();
//			}
//		}
//
//		@Test(priority =102)
//		public void MyFiles_File_Preview_Download() throws Exception   {
//			{
//				mb40 = new MyFiles_File_Preview(driver);
//				MyFiles_File_Preview.MyFiles_File_Preview_Download();		
//			}
//		}
//
//		@Test(priority =103)
//		public void MyFiles_File_Preview_Share_to_Internal_User() throws Exception   {
//			{
//				mb40 = new MyFiles_File_Preview(driver);
//				MyFiles_File_Preview.MyFiles_File_Preview_Share_to_Internal_User();		
//			}
//		}
//
//		@Test(priority =104)
//		public void File_Preview_Share_to_group() throws Exception   {
//			{
//				mb40 = new MyFiles_File_Preview(driver);
//				MyFiles_File_Preview.File_Preview_Share_to_group();		
//			}
//		}
//
//		@Test(priority =105)
//		public void File_Preview_Share_with_link_to_Internal_User() throws Exception   {
//			{
//				mb40 = new MyFiles_File_Preview(driver);
//				MyFiles_File_Preview.File_Preview_Share_with_link_to_Internal_User();		
//			}
//		}
//
//		@Test(priority =106)
//		public void File_Preview_Copy() throws Exception   {
//			{
//				mb40 = new MyFiles_File_Preview(driver);
//				MyFiles_File_Preview.File_Preview_Copy();		
//			}
//		}
//
//		@Test(priority =107)
//		public void File_Preview_Move() throws Exception   {
//			{
//				mb40 = new MyFiles_File_Preview(driver);
//				MyFiles_File_Preview.File_Preview_Move();		   				
//			}
//		}
//
//		@Test(priority =108)
//		public void File_Preview_Check_Versions() throws Exception   {
//			{
//				mb40 = new MyFiles_File_Preview(driver);
//				MyFiles_File_Preview.File_Preview_Check_Versions();	
//			}
//		}
//
//		@Test(priority =109)
//		public void File_Preview_Add_Comment() throws Exception   {
//			{
//				mb40 = new MyFiles_File_Preview(driver);
//				MyFiles_File_Preview.File_Preview_Add_Comment();	
//			}
//		}
//
//		@Test(priority =110)
//		public void File_Preview_Add_Tag() throws Exception   {
//			{
//				mb40 = new MyFiles_File_Preview(driver);
//				MyFiles_File_Preview.File_Preview_Add_Tag();
//			}
//		}
//
//		@Test(priority =111)
//		public void File_Preview_Rename() throws Exception   {
//			{
//				mb40 = new MyFiles_File_Preview(driver);
//				MyFiles_File_Preview.File_Preview_Rename();
//			}
//		}
//
//		
//		//-----------------------------MyFiles_Recent_page----------------------------------
//
//		@Test(priority =112)
//		public void MyFiles_Recent_page_Share_multiple_files_to_user() throws Exception   {
//			{
//				mb41 = new MyFiles_Recent_page (driver);
//				MyFiles_Recent_page.MyFiles_Recent_page_Share_multiple_files_to_user();						
//			}
//		}
//
//		@Test(priority =113)
//		public void MyFiles_Recent_page_Share_multiple_files_to_Group() throws Exception   {
//			{
//				mb41 = new MyFiles_Recent_page (driver);
//				MyFiles_Recent_page.MyFiles_Recent_page_Share_multiple_files_to_Group();	 						
//			}
//		}
//
//		@Test(priority =114)
//		public void MyFiles_Recent_Share_file_with_internal_user_with_permissions() throws Exception   {
//			{
//				mb41 = new MyFiles_Recent_page (driver);
//				MyFiles_Recent_page.MyFiles_Recent_Share_file_with_internal_user_with_permissions(); 						
//			}
//		}
//
//
//		@Test(priority =115)
//		public void MyFiles_Recent_Page_Add_comment_to_file() throws Exception   {
//			{
//				mb41 = new MyFiles_Recent_page (driver);
//				MyFiles_Recent_page.MyFiles_Recent_Page_Add_comment_to_file(); 	 						
//			}
//		}
//
//
//		@Test(priority =116)
//		public void MyFiles_Recent_Page_Add_tags_to_multiple_files() throws Exception   {
//			{
//				mb41 = new MyFiles_Recent_page (driver);
//				MyFiles_Recent_page.MyFiles_Recent_Page_Add_tags_to_multiple_files();
//			}
//		}
//
//		@Test(priority =117)
//		public void MyFiles_Recent_Page_Add_multiple_files_to_collection() throws Exception   {
//			{
//				mb41 = new MyFiles_Recent_page (driver);
//				MyFiles_Recent_page.MyFiles_Recent_Page_Add_multiple_files_to_collection();
//			}
//		}
//
//		@Test(priority =118)
//		public void MyFiles_Recent_Page_Multiple_files_copy() throws Exception   {
//			{
//				mb41 = new MyFiles_Recent_page (driver);
//				MyFiles_Recent_page.MyFiles_Recent_Page_Multiple_files_copy();
//			}
//		}
//
//		@Test(priority =119)
//		public void MyFiles_Recent_Page_Multiple_files_Download() throws Exception   {
//			{
//				mb41 = new MyFiles_Recent_page (driver);
//				MyFiles_Recent_page.MyFiles_Recent_Page_Multiple_files_Download();
//			}
//		}		
//
////				 @Test(priority =120)
////				 public void MyFiles_Recent_Page_Add_comment_to_file() throws Exception   {
////				   {
////				     mb41 = new MyFiles_Recent_page (driver);
////				     MyFiles_Recent_page.MyFiles_Recent_Page_Add_comment_to_file();
////				   }
////				   }
//
//		@Test(priority =121)
//		public void MyFiles_Recent_Page_Add_reminder_to_file() throws Exception   {
//			{
//				mb41 = new MyFiles_Recent_page (driver);
//				MyFiles_Recent_page.MyFiles_Recent_Page_Add_reminder_to_file();
//			}
//		}
//
//		@Test(priority =122)
//		public void MyFiles_Recent_Page_File_rename() throws Exception   {
//			{
//				mb41 = new MyFiles_Recent_page (driver);
//				MyFiles_Recent_page.MyFiles_Recent_Page_File_rename();
//			}
//		}
//
//		@Test(priority =123)
//		public void MyFiles_Recent_Page_File_view_versions() throws Exception   {
//			{
//				mb41 = new MyFiles_Recent_page (driver);
//				MyFiles_Recent_page.MyFiles_Recent_Page_File_view_versions();
//			}
//		}
//
//		@Test(priority =124)
//		public void MyFiles_Recent_Page_Multiple_Files_trash() throws Exception   {
//			{
//				mb41 = new MyFiles_Recent_page (driver);
//				MyFiles_Recent_page.MyFiles_Recent_Page_Multiple_Files_trash();
//			}
//		}	
//
//		@Test(priority =125)
//		public void MyFiles_Recent_Page_File_Preview() throws Exception   {
//			{
//				mb41 = new MyFiles_Recent_page (driver);
//				MyFiles_Recent_page.MyFiles_Recent_Page_File_Preview();
//			}
//		}
//
//		@Test(priority =126)
//		public void MyFiles_Recent_Page_Right_and_Left_Naviation() throws Exception   {
//			{
//				mb41 = new MyFiles_Recent_page (driver);
//				MyFiles_Recent_page.MyFiles_Recent_Page_Right_and_Left_Naviation();
//			}
//		}
//
//		@Test(priority =127)
//		public void MyFiles_Recent_Page_File_Preview_Download() throws Exception   {
//			{
//				mb41 = new MyFiles_Recent_page (driver);
//				MyFiles_Recent_page.MyFiles_Recent_Page_File_Preview_Download();
//			}
//		}
//
//		@Test(priority =128)
//		public void MyFiles_Recent_Page_Share_to_Internal_User() throws Exception   {
//			{
//				mb41 = new MyFiles_Recent_page (driver);
//				MyFiles_Recent_page.MyFiles_Recent_Page_Share_to_Internal_User();
//			}
//		}
//
//		@Test(priority =129)
//		public void MyFiles_Recent_Page_Share_to_Group() throws Exception   {
//			{
//				mb41 = new MyFiles_Recent_page (driver);
//				MyFiles_Recent_page.MyFiles_Recent_Page_Share_to_Group();
//			}
//		}
//
//		@Test(priority =130)
//		public void MyFiles_Recent_Page_Share_with_link_to_Internal_User() throws Exception   {
//			{
//				mb41 = new MyFiles_Recent_page (driver);
//				MyFiles_Recent_page.MyFiles_Recent_Page_Share_with_link_to_Internal_User();		
//			}}
//
//
//		@Test(priority =131)
//		public void MyFiles_Recent_Page_Copy() throws Exception   {
//			{
//				mb41 = new MyFiles_Recent_page (driver);
//				MyFiles_Recent_page.MyFiles_Recent_Page_Copy();
//			}}
//
//		@Test(priority =132)
//		public void MyFiles_Recent_Page_Copy_Check_Versions() throws Exception   {
//			{
//				mb41 = new MyFiles_Recent_page (driver);
//				MyFiles_Recent_page.MyFiles_Recent_Page_Copy_Check_Versions();						
//			}}
//
//		@Test(priority =133)
//		public void MyFiles_Recent_Page_Add_Edit_Delete_Comments() throws Exception   {
//			{
//				mb41 = new MyFiles_Recent_page (driver);
//				MyFiles_Recent_page.MyFiles_Recent_Page_Add_Edit_Delete_Comments();
//			}}
//
//		@Test(priority =134)
//		public void MyFiles_Recent_Page_Tag_Add_Edit_Delete() throws Exception   {
//			{
//				mb41 = new MyFiles_Recent_page (driver);
//				MyFiles_Recent_page.MyFiles_Recent_Page_Tag_Add_Edit_Delete();
//			}
//		}
//
//		@Test(priority =135)
//		public void MyFiles_Recent_Page_Rename() throws Exception   {
//			{
//				mb41 = new MyFiles_Recent_page (driver);
//				MyFiles_Recent_page.MyFiles_Recent_Page_Rename();
//			}
//		}
//
//		@Test(priority =136)
//		public void MyFiles_Recent_Page_Add_File_to_Collection() throws Exception   {
//			{
//				mb41 = new MyFiles_Recent_page (driver);
//				MyFiles_Recent_page.MyFiles_Recent_Page_Add_File_to_Collection();
//			}
//		}

		
		 //------------------------MyFiles__PST__Extraction-------------------------------
		 
//		 @Test(priority =137)
//		 public void MyFiles__PST__Extraction_Admin_Account() throws Exception   {
//		   {
//		     mb42 = new MyFiles__PST__Extraction (driver);
//		     MyFiles__PST__Extraction.MyFiles__PST__Extraction_Admin_Account();
//		     MyFiles__PST__Extraction.MyFiles__PST__Extraction_Admin_Account_Console();
//		   }
//		 }
//		 
//		 @Test(priority =138)
//		 public void MyFiles__PST__Extraction_User_Account() throws Exception   {
//		   {
//		     mb42 = new MyFiles__PST__Extraction (driver);
//		     MyFiles__PST__Extraction.MyFiles__PST__Extraction_User_Account();
//		     MyFiles__PST__Extraction.MyFiles__PST__Extraction_Guest_User_Account();
//		   
//		   }
//		 }
//		 
		 
		//------------------------MyFiles_List_view-----------------------
		 
//		 @Test(priority =139)
//		 public void MyFiles_List_view() throws Exception   {
//		   {
//		     mb43 = new MyFiles_List_view (driver);
//			 MyFiles_List_view.MyFiles_List_view();	   
//			
//		   }
//		 }
//		
//		 @Test(priority =140)
//		 public void MyFiles_List_view_Share_User() throws Exception   {
//		   {
//		     mb43 = new MyFiles_List_view (driver);
//			 MyFiles_List_view.MyFiles_List_view_Share_User();
//		   }
//		 }
//		
//		 @Test(priority =141)
//		 public void MyFiles_List_view_Add_comment_to_file() throws Exception   {
//		   {
//		     mb43 = new MyFiles_List_view (driver);			 
//		     MyFiles_List_view.MyFiles_List_view_Add_comment_to_file();			
//		   }
//		 }
//		
//		 @Test(priority =142)
//		 public void MyFiles_List_view_Add_comment_to_folder() throws Exception   {
//		   {
//		     mb43 = new MyFiles_List_view (driver);
//		     MyFiles_List_view.MyFiles_List_view_Add_comment_to_folder();
//		   }
//		 }
		
//		 @Test(priority =143)
//		 public void MyFiles_List_view_Add_Tags_to_multiple_files_folders() throws Exception   {
//		   {
//		     mb43 = new MyFiles_List_view (driver);
//			 MyFiles_List_view.MyFiles_List_view_Add_Tags_to_multiple_files_folders();
//		   }
//		 }
		 
//		 @Test(priority =144)
//		 public void MyFiles_List_view_Add_multiple_files_to_collection() throws Exception   {
//		   {
//		     mb43 = new MyFiles_List_view (driver);
//		     MyFiles_List_view.MyFiles_List_view_Add_multiple_files_to_collection();			  
//		     }
//		 }
		
//		 @Test(priority =145)
//		 public void MyFiles_List_view_Multiple_files_and_folders_copy() throws Exception   {
//		   {
//		     mb43 = new MyFiles_List_view (driver);
//		     MyFiles_List_view.MyFiles_List_view_Multiple_files_and_folders_copy();			  
//		     }
//		 }
		
//		 @Test(priority =146)
//		 public void MyFiles_List_view_Multiple_files_and_folders_Move() throws Exception   {
//		   {
//		     mb43 = new MyFiles_List_view (driver);
//		     MyFiles_List_view.MyFiles_List_view_Multiple_files_and_folders_Move();			  
//		     }
//		 }
		
		
//		 @Test(priority =147)
//		 public void MyFiles_List_view_Multipe_Files_Download() throws Exception   {
//		   {
//		     mb43 = new MyFiles_List_view (driver);
//		     MyFiles_List_view.MyFiles_List_view_Multipe_Files_Download();			  
//		     }
//		 }
//		
//		 @Test(priority =148)
//		 public void MyFiles_List_view_Multipe_Folders_Download() throws Exception   {
//		   {
//		     mb43 = new MyFiles_List_view (driver);
//		     MyFiles_List_view.MyFiles_List_view_Multipe_Folders_Download();			  
//		     }
//		 }
		
//		 @Test(priority =149)
//		 public void MyFiles_List_view_Add_Remainder_File() throws Exception   {
//		   {
//		     mb43 = new MyFiles_List_view (driver);
//		     MyFiles_List_view.MyFiles_List_view_Add_Remainder_File();			  
//		     }
//		 }
//		
//		 @Test(priority =150)
//		 public void MyFiles_List_view_Add_Remainder_Folder() throws Exception   {
//		   {
//		     mb43 = new MyFiles_List_view (driver);
//		     MyFiles_List_view.MyFiles_List_view_Add_Remainder_Folder();			  
//		     }
//		 }
		
//		 @Test(priority =151)
//		 public void MyFiles_List_view_File_view_versions() throws Exception   {
//		   {
//		     mb43 = new MyFiles_List_view (driver);
//		     MyFiles_List_view.MyFiles_List_view_File_view_versions();			  
//		     }
//		 }
		
//		 @Test(priority =152)
//		 public void MyFiles_List_view_Multiple_Trash_Files() throws Exception   {
//		   {
//		     mb43 = new MyFiles_List_view (driver);
//		     MyFiles_List_view.MyFiles_List_view_Multiple_Trash_Files();			  
//		     }
//		 }
		
//		 @Test(priority =153)
//		 public void MyFiles_List_view_Multiple_Trash_Folders() throws Exception   {
//		   {
//		     mb43 = new MyFiles_List_view (driver);
//		     MyFiles_List_view.MyFiles_List_view_Multiple_Trash_Folders();			  
//		     }
//		 }
		
		
		//---------------------MyFiles_Collections_Page-------------------------------------
		
		
//		 @Test(priority =154)
//		 public void MyFiles_Collections_Page_Create_collections() throws Exception   {
//		   {
//		     mb44 = new MyFiles_Collections_Page (driver);
//		     MyFiles_Collections_Page.MyFiles_Collections_Page_Create_collections();			  
//		     }
//		 }
		
		
//		 @Test(priority =155)
//		 public void MyFiles_Collections_Page_Add_Files_To_Collections() throws Exception   {
//		   {
//		     mb44 = new MyFiles_Collections_Page (driver);
//		     MyFiles_Collections_Page.MyFiles_Collections_Page_Add_Files_To_Collections();			  
//		     }
//		 }
		
//		 @Test(priority =156)
//		 public void MyFiles_Collections_Page_Edit_Rename_collections() throws Exception   {
//		   {
//		     mb44 = new MyFiles_Collections_Page (driver);
//		     MyFiles_Collections_Page.MyFiles_Collections_Page_Edit_Rename_collections();			  
//		     }
//		 }
		
//		 @Test(priority =157)
//		 public void MyFiles_Collections_Page_Add_Files_And_View_Collections() throws Exception   {
//		   {
//		     mb44 = new MyFiles_Collections_Page (driver);
//		     MyFiles_Collections_Page.MyFiles_Collections_Page_Add_Files_And_View_Collections();			  
//		     }
//		 }
		
//		 @Test(priority =158)
//		 public void MyFiles_Collections_Page_Download_collections() throws Exception   {
//		   {
//		     mb44 = new MyFiles_Collections_Page (driver);
//		     MyFiles_Collections_Page.MyFiles_Collections_Page_Download_collections();			  
//		     }
//		 }
		
//		 @Test(priority =159)
//		 public void MyFiles_Collections_Page_Export_Metedata_in_list_view() throws Exception   {
//		   {
//		     mb44 = new MyFiles_Collections_Page (driver);
//		     MyFiles_Collections_Page.MyFiles_Collections_Page_Export_Metedata_in_list_view();			  
//		     }
//		 }
		
		
//		 @Test(priority =160)
//		 public void MyFiles_Collections_Page_Export_Metedata_in_View_collections() throws Exception   {
//		   {
//		     mb44 = new MyFiles_Collections_Page (driver);
//		     MyFiles_Collections_Page.MyFiles_Collections_Page_Export_Metedata_in_View_collections();			  
//		     }
//		 }
		
//		 @Test(priority =161)
//		 public void MyFiles_Collections_Page_Share_Multiple_files_To_User() throws Exception   {
//		   {
//		     mb44 = new MyFiles_Collections_Page (driver);
//		     MyFiles_Collections_Page.MyFiles_Collections_Page_Share_Multiple_files_To_User();			  
//		     }
//		 }
		
//		 @Test(priority =162)
//		 public void MyFiles_Collections_Page_Share_Add_comment_to_file() throws Exception   {
//		   {
//		     mb44 = new MyFiles_Collections_Page (driver);
//		     MyFiles_Collections_Page.MyFiles_Collections_Page_Share_Add_comment_to_file();			  
//		     }
//		 }
		
//		 @Test(priority =163)
//		 public void MyFiles_Collections_Page_Share_Add_Tags_to_multiple_files() throws Exception   {
//		   {
//		     mb44 = new MyFiles_Collections_Page (driver);
//		     MyFiles_Collections_Page.MyFiles_Collections_Page_Share_Add_Tags_to_multiple_files();			  
//		     }
//		 }
		
//		 @Test(priority =164)
//		 public void MyFiles_Collections_Page_Share_Add_Tags_to_multiple_files() throws Exception   {
//		   {
//		     mb44 = new MyFiles_Collections_Page (driver);
//		     MyFiles_Collections_Page.MyFiles_Collections_Page_Share_Add_Tags_to_multiple_files();			  
//		     }
//		 }
		 
//		 @Test(priority =165)
//		 public void MyFiles_Collections_Page_Multiple_files_Download() throws Exception   {
//		   {
//		     mb44 = new MyFiles_Collections_Page (driver);
//		     MyFiles_Collections_Page.MyFiles_Collections_Page_Multiple_files_Download();			  
//		     }
//		 }
		 
//		 @Test(priority =166)
//		 public void MyFiles_Collections_Page_Add_Remainder_To_File() throws Exception   {
//		   {
//		     mb44 = new MyFiles_Collections_Page (driver);
//		     MyFiles_Collections_Page.MyFiles_Collections_Page_Add_Remainder_To_File();			  
//		     }
//		 }
		
//		 @Test(priority =167)
//		 public void MyFiles_Collections_Page_File_Rename() throws Exception   {
//		   {
//		     mb44 = new MyFiles_Collections_Page (driver);
//		     MyFiles_Collections_Page.MyFiles_Collections_Page_File_Rename();			  
//		     }
//		 }
		
//		 @Test(priority =168)
//		 public void MyFiles_Collections_Page_File_View_Versions() throws Exception   {
//		   {
//		     mb44 = new MyFiles_Collections_Page (driver);
//		     MyFiles_Collections_Page.MyFiles_Collections_Page_File_View_Versions();			  
//		     }
//		 }
		
//		 @Test(priority =169)
//		 public void MyFiles_Collections_Page_Multipl_Files_Trash() throws Exception   {
//		   {
//		     mb44 = new MyFiles_Collections_Page (driver);
//		     MyFiles_Collections_Page.MyFiles_Collections_Page_Multipl_Files_Trash();			  
//		     }
//		 }
		
//		 @Test(priority =170)
//		 public void MyFiles_Collections_Page_Remove_Collections() throws Exception   {
//		   {
//		     mb44 = new MyFiles_Collections_Page (driver);
//		     MyFiles_Collections_Page.MyFiles_Collections_Page_Remove_Collections();			  
//		     }
//		 }
		
		
		//--------------------------MyFiles_Share_with_me_Page------------------------------
		 
//		 @Test(priority =171)
//		 public void MyFiles_Share_with_me_Page_Share_multiple_Files_and_Folder() throws Exception   {
//		   {
//		     mb45 = new MyFiles_Share_with_me_Page (driver);
//		     MyFiles_Share_with_me_Page.MyFiles_Share_with_me_Page_Share_multiple_Files_and_Folder();			  
//		     }
//		 } 
//		 
//		 @Test(priority =172)
//		 public void MyFiles_Share_with_me_Page_Share_Add_comment_File_Folder() throws Exception   {
//		   {
//		     mb45 = new MyFiles_Share_with_me_Page (driver);
//		     MyFiles_Share_with_me_Page.MyFiles_Share_with_me_Page_Share_Add_comment_File_Folder();			  
//		     }
//		 } 
//		 
//		 @Test(priority =173)
//		 public void MyFiles_Share_with_me_Page_Add_Tag_Multiple_files_Folders() throws Exception   {
//		   {
//		     mb45 = new MyFiles_Share_with_me_Page (driver);
//		     MyFiles_Share_with_me_Page.MyFiles_Share_with_me_Page_Add_Tag_Multiple_files_Folders();			  
//		     }
//		 } 
//		
//		 @Test(priority =174)
//		 public void MyFiles_Share_with_me_Page_Add_multiple_Files_To_Collections() throws Exception   {
//		   {
//		     mb45 = new MyFiles_Share_with_me_Page (driver);
//		     MyFiles_Share_with_me_Page.MyFiles_Share_with_me_Page_Add_multiple_Files_To_Collections();			  
//		     }
//		 } 
		
		//---------Not completed----------------
		
//		 @Test(priority =175)
//		 public void MyFiles_Share_with_me_Page_Guest_Account_Sharing() throws Exception   {
//		   {
//		     mb45 = new MyFiles_Share_with_me_Page (driver);
//		     MyFiles_Share_with_me_Page.MyFiles_Share_with_me_Page_Guest_Account_Sharing();			  
//		     }
//		 } 
//		
//		 @Test(priority =176)
//		 public void MyFiles_Share_with_me_Page_Share_file_via_link() throws Exception   {
//		   {
//		     mb45 = new MyFiles_Share_with_me_Page (driver);
//		     MyFiles_Share_with_me_Page.MyFiles_Share_with_me_Page_Share_file_via_link();			  
//		     }
//		 } 
//		
//		 @Test(priority =177)
//		 public void MyFiles_Share_with_me_Page_Share_Folder_via_link() throws Exception   {
//		   {
//		     mb45 = new MyFiles_Share_with_me_Page (driver);
//		     MyFiles_Share_with_me_Page.MyFiles_Share_with_me_Page_Share_Folder_via_link();			  	
//		     }
//		 } 
	//	------------------------------------------------------------------------------------------------
		
//		 @Test(priority =178)
//		 public void MyFiles_Share_with_me_Page_Multiple_files_and_folders_copy() throws Exception   {
//		   {
//		     mb45 = new MyFiles_Share_with_me_Page (driver);
//		     MyFiles_Share_with_me_Page.MyFiles_Share_with_me_Page_Multiple_files_and_folders_copy();			  
//		     }
//		 } 
//		
//		 @Test(priority =179)
//		 public void MyFiles_Share_with_me_Page_Multiple_files_Download() throws Exception   {
//		   {
//		     mb45 = new MyFiles_Share_with_me_Page (driver);
//		     MyFiles_Share_with_me_Page.MyFiles_Share_with_me_Page_Multiple_files_Download();			  
//		     }
//		 }
//		
//		 @Test(priority =180)
//		 public void MyFiles_Share_with_me_Page_Multiple_folders_Download() throws Exception   {
//		   {
//		     mb45 = new MyFiles_Share_with_me_Page (driver);
//		     MyFiles_Share_with_me_Page.MyFiles_Share_with_me_Page_Multiple_folders_Download();			  
//		     }
//		 }
//		
//		 @Test(priority =181)
//		 public void MyFiles_Share_with_me_Page_Add_Remainder_Files_Folders() throws Exception   {
//		   {
//		     mb45 = new MyFiles_Share_with_me_Page (driver);
//		     MyFiles_Share_with_me_Page.MyFiles_Share_with_me_Page_Add_Remainder_Files_Folders();			  
//		     }
//		 }
		
//		 @Test(priority =182)
//		 public void MyFiles_Share_with_me_Page_Rename_File_Folder() throws Exception   {
//		   {
//		     mb45 = new MyFiles_Share_with_me_Page (driver);
//		     MyFiles_Share_with_me_Page.MyFiles_Share_with_me_Page_Rename_File_Folder();			  
//		     }
//		 }
		
//		 @Test(priority =183)
//		 public void MyFiles_Share_with_me_Page_File_view_versions() throws Exception   {
//		   {
//		     mb45 = new MyFiles_Share_with_me_Page (driver);
//		     MyFiles_Share_with_me_Page.MyFiles_Share_with_me_Page_File_view_versions();			  
//		     }
//		}
		
//		 @Test(priority =184)
//		 public void MyFiles_Share_with_me_Page_Multiple_files_folders_Trash() throws Exception   {
//		   {
//		     mb45 = new MyFiles_Share_with_me_Page (driver);
//		     MyFiles_Share_with_me_Page.MyFiles_Share_with_me_Page_Multiple_files_folders_Trash();			  
//		     }
//		 }
		
//		 @Test(priority =185)
//		 public void MyFiles_Share_with_me_Page_User_Multiple_files_copy() throws Exception   {
//		   {
//		     mb45 = new MyFiles_Share_with_me_Page (driver);
//		     MyFiles_Share_with_me_Page.MyFiles_Share_with_me_Page_User_Multiple_files_copy();			  
//		     }
//		 }
		
//		 @Test(priority =186)
//		 public void MyFiles_Share_with_me_Page_User_Multiple_folders_copy() throws Exception   {
//		   {
//		     mb45 = new MyFiles_Share_with_me_Page (driver);
//		     MyFiles_Share_with_me_Page.MyFiles_Share_with_me_Page_User_Multiple_folders_copy();			  
//		     }
//		 }
		
//		 @Test(priority =187)
//		 public void MyFiles_Share_with_me_Page_Multiple_Files_Folders_Copy() throws Exception   {
//		   {
//		     mb45 = new MyFiles_Share_with_me_Page (driver);
//		     MyFiles_Share_with_me_Page.MyFiles_Share_with_me_Page_Multiple_Files_Folders_Copy();			  
//		     }
//		 }
		
//		 @Test(priority =188)
//		 public void MyFiles_Share_with_me_Page_Multiple_Files_Move() throws Exception   {
//		   {
//		     mb45 = new MyFiles_Share_with_me_Page (driver);
//		     MyFiles_Share_with_me_Page.MyFiles_Share_with_me_Page_Multiple_Files_Move();			  
//		     }
//		 }
		 
//		 @Test(priority =189)
//		 public void MyFiles_Share_with_me_Page_Multiple_Folders_move() throws Exception   {
//		   {
//		     mb45 = new MyFiles_Share_with_me_Page (driver);
//		     MyFiles_Share_with_me_Page.MyFiles_Share_with_me_Page_Multiple_Folders_move();			  
//		     }
//		 }
//		 
//		 @Test(priority =190)
//		 public void MyFiles_Share_with_me_Page_Multiple_Files_Folders_Move() throws Exception   {
//		   {
//		     mb45 = new MyFiles_Share_with_me_Page (driver);
//		     MyFiles_Share_with_me_Page.MyFiles_Share_with_me_Page_Multiple_Files_Folders_Move();			  
//		     }
//		 }
//		 
		 		 
//		 @Test(priority =191)
//		 public void MyFiles_Share_with_me_Page_Drag_Drop_Multiple_Files_Move() throws Exception   {
//		   {
//		     mb45 = new MyFiles_Share_with_me_Page (driver);
//		     MyFiles_Share_with_me_Page.MyFiles_Share_with_me_Page_Drag_Drop_Multiple_Files_Move();			  
//		     }
//		 }
//		 
//		 @Test(priority =192)
//		 public void MyFiles_Share_with_me_Page_Drag_Drop_Multiple_Folders_Move() throws Exception   {
//		   {
//		     mb45 = new MyFiles_Share_with_me_Page (driver);
//		     MyFiles_Share_with_me_Page.MyFiles_Share_with_me_Page_Drag_Drop_Multiple_Folders_Move();			  
//		     }
//		 }
//		 
//		 @Test(priority =193)
//		 public void MyFiles_Share_with_me_Page_Drag_Drop_Multiple_Files_Folders() throws Exception   {
//		   {
//		     mb45 = new MyFiles_Share_with_me_Page (driver);
//		     MyFiles_Share_with_me_Page.MyFiles_Share_with_me_Page_Drag_Drop_Multiple_Files_Folders();			  
//		     }
//		 }
		
		//------------------------------------MyFiles_Share_with_me_Page----------------------------------------------------
		
//		 @Test(priority =194)
//		 public void MyFiles_Share_with_me_Page_File_Preview() throws Exception   {
//		   {
//		     mb45 = new MyFiles_Share_with_me_Page (driver);
//		     MyFiles_Share_with_me_Page.MyFiles_Share_with_me_Page_File_Preview();			  
//		     }
//		 }
//		
//		 @Test(priority =195)
//		 public void MyFiles_Share_with_me_Page_File_Preview_Right_and_Left_Naviation() throws Exception   {
//		   {
//		     mb45 = new MyFiles_Share_with_me_Page (driver);
//		     MyFiles_Share_with_me_Page.MyFiles_Share_with_me_Page_File_Preview_Right_and_Left_Naviation();			  
//		     }
//		 }
//		
//		 @Test(priority =196)
//		 public void MyFiles_Share_with_me_Page_File_Preview_Download() throws Exception   {
//		   {
//		     mb45 = new MyFiles_Share_with_me_Page (driver);
//		     MyFiles_Share_with_me_Page.MyFiles_Share_with_me_Page_File_Preview_Download();			  
//		     }
//		 }
//		
//		
//		 @Test(priority =197)
//		 public void MyFiles_Share_with_me_Page_File_Preview_Share_to_Internal_User() throws Exception   {
//		   {
//		     mb45 = new MyFiles_Share_with_me_Page (driver);
//		     MyFiles_Share_with_me_Page.MyFiles_Share_with_me_Page_File_Preview_Share_to_Internal_User();			  
//		     }
//		 }
//		 
//		 @Test(priority =198)
//		 public void MyFiles_Share_with_me_Page_File_Preview_Share_to_Group() throws Exception   {
//		   {
//		     mb45 = new MyFiles_Share_with_me_Page (driver);
//		     MyFiles_Share_with_me_Page.MyFiles_Share_with_me_Page_File_Preview_Share_to_Group();			  
//		     }
//		 }
//		 
//		 @Test(priority =199)
//		 public void MyFiles_Share_with_me_Page_File_Preview_Share_with_link_to_Internal_User() throws Exception   {
//		   {
//		     mb45 = new MyFiles_Share_with_me_Page (driver);
//		     MyFiles_Share_with_me_Page.MyFiles_Share_with_me_Page_File_Preview_Share_with_link_to_Internal_User();			  //not completed
//		     }
//		 }
//		 
//		 
//		 @Test(priority =200)
//		 public void MyFiles_Share_with_me_Page_File_Preview_Copy() throws Exception   {
//		   {
//		     mb45 = new MyFiles_Share_with_me_Page (driver);
//		     MyFiles_Share_with_me_Page.MyFiles_Share_with_me_Page_File_Preview_Copy();			  
//		     }
//		 }
		 
//		 @Test(priority =201)
//		 public void MyFiles_Share_with_me_Page_File_Preview_Move() throws Exception   {
//		   {
//		     mb45 = new MyFiles_Share_with_me_Page (driver);
//		     MyFiles_Share_with_me_Page.MyFiles_Share_with_me_Page_File_Preview_Move();			  
//		     }
//		 }
		 
//		 @Test(priority =202)
//		 public void MyFiles_Share_with_me_Page_File_Preview_Cheak_Versions() throws Exception   {
//		   {
//		     mb45 = new MyFiles_Share_with_me_Page (driver);
//		     MyFiles_Share_with_me_Page.MyFiles_Share_with_me_Page_File_Preview_Cheak_Versions();			  
//		     }
//		 }
		
		
		
		
				// ------------------------MyFiles_Sorting_Files_Folders---------------
		 
		 
//		 @Test(priority =203)
//		 public void MyFiles_Sorting_Files_Folders_AZ_Grid_view() throws Exception   {
//		   {
//		     mb46 = new MyFiles_Sorting_Files_Folders (driver);
//		     MyFiles_Sorting_Files_Folders.MyFiles_Sorting_Files_Folders_AZ_Grid_view();			  
//		     }
//		 }
//		 
//		 
//		 @Test(priority =204)
//		 public void MyFiles_Sorting_Files_Folders_ZA_Grid_view() throws Exception   {
//		   {
//		     mb46 = new MyFiles_Sorting_Files_Folders (driver);
//		     MyFiles_Sorting_Files_Folders.MyFiles_Sorting_Files_Folders_ZA_Grid_view();			  
//		     }
//		 }
		
//		 @Test(priority =205)
//		 public void MyFiles_Sorting_Files_Folders_AZ_List_view() throws Exception   {
//		   {
//		     mb46 = new MyFiles_Sorting_Files_Folders (driver);
//		     MyFiles_Sorting_Files_Folders.MyFiles_Sorting_Files_Folders_AZ_List_view();			  
//		     }
//		 }
		
//		 @Test(priority =206)
//		 public void MyFiles_Sorting_Files_Folders_ZA_List_view() throws Exception   {
//		   {
//		     mb46 = new MyFiles_Sorting_Files_Folders (driver);
//		     MyFiles_Sorting_Files_Folders.MyFiles_Sorting_Files_Folders_ZA_List_view();			  
//		     }
//		 }
		
//		 @Test(priority =207)
//		 public void MyFiles_Sort_Files_Folders_Recent_Old_NewData_Grid_view() throws Exception   {
//		   {
//		     mb46 = new MyFiles_Sorting_Files_Folders (driver);
//		     MyFiles_Sorting_Files_Folders.MyFiles_Sort_Files_Folders_Recent_Old_NewData_Grid_view();			  
//		     }
//		 }
		
//		 @Test(priority =208)
//		 public void MyFiles_Sort_Files_Folders_Recent_Old_NewData_List_view() throws Exception   {
//		   {
//		     mb46 = new MyFiles_Sorting_Files_Folders (driver);
//		     MyFiles_Sorting_Files_Folders.MyFiles_Sort_Files_Folders_Recent_Old_NewData_List_view();			  
//		     }
//		 }
		
		
		//------------------------------------MyFiles_Details---------------------------------------
		
		
//		 @Test(priority =209)
//		 public void MyFiles_Details_List_view_File() throws Exception   {
//		   {
//		     mb47 = new MyFiles_Details (driver);
//		     MyFiles_Details.MyFiles_Details_List_view_File();			  
//		     }
//		 }
		
		
//		 @Test(priority =210)
//		 public void MyFiles_Details_List_Grid_File() throws Exception   {
//		   {
//		     mb47 = new MyFiles_Details (driver);
//		     MyFiles_Details.MyFiles_Details_List_Grid_File();			  
//		     }
//		 }
		
//		 @Test(priority =211)
//		 public void MyFiles_Details_List_view_Folder() throws Exception   {
//		   {
//		     mb47 = new MyFiles_Details (driver);
//		     MyFiles_Details.MyFiles_Details_List_view_Folder();			  
//		     }
//		 }
		
//		 @Test(priority =212)
//		 public void MyFiles_Details_List_Grid_Folder() throws Exception   {
//		   {
//		     mb47 = new MyFiles_Details (driver);
//		     MyFiles_Details.MyFiles_Details_List_Grid_Folder();			  
//		     }
//		 }
		
		
		//----------------------------MyFiles_Upload_Forms----------------------------------------------
		
//		 @Test(priority =213)
//		 public void MyFiles_Upload_Forms_Verify_Form_Enabling() throws Exception   {
//		   {
//		     mb48 = new MyFiles_Upload_Forms (driver);
//		     MyFiles_Upload_Forms.MyFiles_Upload_Forms_Verify_Form_Enabling();			  
//		     }
//		 }
//		
//		
//		 @Test(priority =214)
//		 public void MyFiles_Upload_Forms_Verify_Form_Disabling() throws Exception   {
//		   {
//		     mb48 = new MyFiles_Upload_Forms (driver);
//		     MyFiles_Upload_Forms.MyFiles_Upload_Forms_Verify_Form_Disabling();			  
//		     }
//		 }
//		
//		
//		 @Test(priority =215)
//		 public void MyFiles_Upload_Forms_Create_Form_By_Deactiving_Link() throws Exception   {
//		   {
//		     mb48 = new MyFiles_Upload_Forms (driver);
//		     MyFiles_Upload_Forms.MyFiles_Upload_Forms_Create_Form_By_Deactiving_Link();			  
//		     }
//		 }
//		
//		
//		 @Test(priority =216)
//		 public void MyFiles_Upload_Forms_Create_Form_By_Giving_Password() throws Exception   {
//		   {
//		     mb48 = new MyFiles_Upload_Forms (driver);
//		     MyFiles_Upload_Forms.MyFiles_Upload_Forms_Create_Form_By_Giving_Password();			  // final is pending
//		     }
//		 }
//		
//		 @Test(priority =217)
//		 public void MyFiles_Upload_Forms_Create_Form_By_Giving_Expiry_Date() throws Exception   {
//		   {
//		     mb48 = new MyFiles_Upload_Forms (driver);
//		     MyFiles_Upload_Forms.MyFiles_Upload_Forms_Create_Form_By_Giving_Expiry_Date();			  
//		     }
//		 }
//		 
//		 @Test(priority =218)
//		 public void MyFiles_Upload_Forms_Deactivating_Link_From_Existing_Forms_Page() throws Exception   {
//		   {
//		     mb48 = new MyFiles_Upload_Forms (driver);
//		     MyFiles_Upload_Forms.MyFiles_Upload_Forms_Deactivating_Link_From_Existing_Forms_Page();			  
//		     }
//		 }
//		 		 
//		 @Test(priority =219)
//		 public void MyFiles_Upload_Forms_Activating_Link_From_Existing_Forms_Page() throws Exception   {
//		   {
//		     mb48 = new MyFiles_Upload_Forms (driver);
//		     MyFiles_Upload_Forms.MyFiles_Upload_Forms_Activating_Link_From_Existing_Forms_Page();			  
//		     }
//		 }
//		 		 
//		 @Test(priority =220)
//		 public void MyFiles_Upload_Forms_Edit_Form_And_Change_The_Name() throws Exception   {
//		   {
//		     mb48 = new MyFiles_Upload_Forms (driver);
//		     MyFiles_Upload_Forms.MyFiles_Upload_Forms_Edit_Form_And_Change_The_Name();			  
//		     }
//		 }
//		 		 
//		 @Test(priority =221)
//		 public void MyFiles_Upload_Forms_Deleted_The_Form_From_Active_List() throws Exception   {
//		   {
//		     mb48 = new MyFiles_Upload_Forms (driver);
//		     MyFiles_Upload_Forms.MyFiles_Upload_Forms_Deleted_The_Form_From_Active_List();			  
//		     }
//		 }
//		 
//		 
//		 @Test(priority =222)
//		 public void MyFiles_Upload_Forms_Verify_Active_And_Inactive() throws Exception   {
//		   {
//		     mb48 = new MyFiles_Upload_Forms (driver);
//		     MyFiles_Upload_Forms.MyFiles_Upload_Forms_Verify_Active_And_Inactive();			  
//		     }
//		 }
		 
		 
		 
				//---------------------------MyFiles_Email_Integration--------------------------------    Pending
		 
		 

//		 @Test(priority =223)
//		 public void MyFiles_Email_Integration_Admin_account_Add_Email_Integration() throws Exception   {
//		   {
//		     mb49 = new MyFiles_Email_Integration (driver);
//		     MyFiles_Email_Integration.MyFiles_Email_Integration_Admin_account_Add_Email_Integration();			  
//		     }
//		 }
//		 
//		 
//		 @Test(priority =224)
//		 public void MyFiles_Email_Integration_Admin_account_Edit_Email_Integration() throws Exception   {
//		   {
//		     mb49 = new MyFiles_Email_Integration (driver);
//		     MyFiles_Email_Integration.MyFiles_Email_Integration_Admin_account_Edit_Email_Integration();			  
//		     }
//		 }
//		 
//		 
//		 @Test(priority =225)
//		 public void MyFiles_Email_Integration_Admin_account_Delete_Email_Integration() throws Exception   {
//		   {
//		     mb49 = new MyFiles_Email_Integration (driver);
//		     MyFiles_Email_Integration.MyFiles_Email_Integration_Admin_account_Delete_Email_Integration();			  
//		     }
//		 }
//		 
//		@Test(priority =226)
//		 public void MyFiles_Email_Integration_User_account_Add_Email_Integration() throws Exception   {
//		   {
//		     mb49 = new MyFiles_Email_Integration (driver);
//		     MyFiles_Email_Integration.MyFiles_Email_Integration_User_account_Delete_Email_Integration();			  
//		     }
//		 }
//		
//		 @Test(priority =227)
//		 public void MyFiles_Email_Integration_User_account_Edit_Email_Integration() throws Exception   {
//		   {
//		     mb49 = new MyFiles_Email_Integration (driver);
//		     MyFiles_Email_Integration.MyFiles_Email_Integration_User_account_Add_Email_Integration();			  
//		     }
//		 }
//		 
//		 
//		 @Test(priority =228)
//		 public void MyFiles_Email_Integration_User_account_Delete_Email_Integration() throws Exception   {
//		   {
//		     mb49 = new MyFiles_Email_Integration (driver);
//		     MyFiles_Email_Integration.MyFiles_Email_Integration_User_account_Delete_Email_Integration();			  
//		     }
//		 }
		 
		 
		
				//---------------------------------Signup_Form--------------------------------
		
//		 @Test(priority =229)
//		 public void Signup_Form_Delete_Old_Email() throws Exception   {
//		   {
//		     mb50 = new Signup_Form (driver);
//		     Signup_Form.Signup_Form_Delete_Old_Email();			  
//		     }
//		 }
		
//		 @Test(priority =230)
//		 public void Signup_Form_Copy_New_Mail() throws Exception   {
//		   {
//		     mb50 = new Signup_Form (driver);
//		     Signup_Form.Signup_Form_Copy_New_Mail();			  
//		     }
//		 }
		
//		 @Test(priority =231)
//		 public void Signup_Form_Fill_Signup_Form() throws Exception   {
//		   {
//		     mb50 = new Signup_Form (driver);
//		     Signup_Form.Signup_Form_Fill_Signup_Form();			  
//		     }
//		 }
		
//		 @Test(priority =232)
//		 public void Signup_Default_Storage_Monthly_billing_free_trial() throws Exception   {
//		   {
//		     mb50 = new Signup_Form (driver);
//		     Signup_Form.Signup_Default_Storage_Monthly_billing_free_trial();			  
//		     }
//		 }
		 
		 
//		 @Test(priority =233)
//		 public void Signup_Default_Storage_Yearly_billing_free_trial() throws Exception   {
//		   {
//		     mb50 = new Signup_Form (driver);
//		     Signup_Form.Signup_Default_Storage_Yearly_billing_free_trial();			  
//		     }
//		 }
		 
		 @Test(priority =234)
		 public void Signup_Default_Storage_Monthly_billing_Credit_card_payment() throws Exception   {
		   {
		     mb50 = new Signup_Form (driver);
		     Signup_Form.Signup_Default_Storage_Monthly_billing_Credit_card_payment();			  
		     }
		 }
		 
		 
		 
		 
		 
		 
		 
		 
		
		//------------------------------Forgot_Password------------------------------
		 
		 
//		 @Test(priority =231)
//		 public void Forgot_Password_Signup_and_Forgot_Password() throws Exception   {
//		   {
//		     mb51 = new Forgot_Password (driver);
//		     Forgot_Password.Forgot_Password_Signup_and_Forgot_Password();			  
//		     }
//		 }
		 
		 
//		 @Test(priority =232)
//		 public void Forgot_Password_Signup_and_Forgot_Password() throws Exception   {
//		   {
//		     mb51 = new Forgot_Password (driver);
//		     Forgot_Password.Forgot_Password_Signup_and_Forgot_Password();			  
//		     }
//		 }
		 
		 
//		 @Test(priority =233)
//		 public void Forgot_Password_Signup_and_Forgot_Password() throws Exception   {
//		   {
//		     mb51 = new Forgot_Password (driver);
//		     Forgot_Password.Forgot_Password_Signup_and_Forgot_Password();			  
//		     }
//		 }
		 
		 
		 //----------------------------------Account_Settings------------------------------------
		 
		
//		 @Test(priority =234)
//		 public void Forgot_Password_Signup_and_Forgot_Password() throws Exception   {
//		   {
//		     mb51 = new Forgot_Password (driver);
//		     Forgot_Password.Forgot_Password_Signup_and_Forgot_Password();			  
//		     }
//		 }
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		 
		 
		//----------------------Recent----------------		
//		@Test(priority = 32)
//				public void recent_page_comment_add() throws Exception {
//					{
//						mb13 = new RecentPageComments(driver);
//						RecentPageComments.add_comments_to_file_recent();
//
//						
//					}
//				}	
//		
//		
//		@Test(priority = 32)
//		public void recent_page_comment_edit() throws Exception {
//			{
//				mb13 = new RecentPageComments(driver);
//				RecentPageComments.edit_comments_to_file_recent();
//
//				
//			}
//		}	
//		
//		
//		@Test(priority = 32)
//		public void recent_page_comment_delete() throws Exception {
//			{
//				mb13 = new RecentPageComments(driver);
//				RecentPageComments.delete_comments_to_file_recent();
//				
//			}
//		}	
//		
//		
//	
//
//				@Test(priority = 33)
//				public void recent_page_tags_add() throws Exception {
//					{
//						mb14 = new RecentPageTags(driver);
//						RecentPageTags.add_tag_multiple_files_recent();
//						
//						
//					}
//				}	
//				
//				
//				@Test(priority = 34)
//				public void recent_page_tags_remove() throws Exception {
//					{
//					
//						RecentPageTags.remove_tag_multiple_files_recent();
//						
//					}
//				}	
//				
//			
//		@Test(priority = 35)
//		public void recent_page_tags_copy() throws Exception {
//			{
//				mb15 = new RecentPageCopyMove(driver);
//				RecentPageCopyMove.recent_page_multiple_files_copy();
//				
//				
//			}
//		}	
//		
//		
//		
//		@Test(priority = 35)
//		public void recent_page_move() throws Exception {
//			{
//				mb15 = new RecentPageCopyMove(driver);
//				
//				RecentPageCopyMove.recent_page_multiple_files_move();
//				
//			}
//		}	
//		
//		
//		
//		
//		
//		@Test(priority = 37)
//		public void recent_page_collections() throws Exception {
//			{
//				mb18 = new RecentPageCollections(driver);
//				RecentPageCollections.add_files_to_collection();
//
//			}
//			}
//
//		
//		@Test(priority = 39)
//		public void recent_page_share() throws Exception {
//			{
//				mb20 = new RecentPageShare(driver);
//				RecentPageShare.share_data_with_user_edit_permission();
//				//RecentPageShare.share_data_with_user_edit_permission_confirmation();
//				
//			}
//		}	
//			
//		@Test(priority = 40)
//		public void recent_page_trash() throws Exception {
//			{
//				mb21 = new RecentPageDelete(driver);
//				RecentPageDelete.mul_file_delete_recent();
//				
//			}
//		}
//		
//	//----------------------Recent-End----------------		
//	
//		
//		
//		
//		
//		
//		//----------------------Collections-Start----------------		
//		
//		@Test(priority = 38)
//		public void collections_page() throws Exception {
//			{
//				mb19 = new CollectionsPage(driver);
//				CollectionsPage.add_files_to_collection();
//
//				
//			}
//		}	
//		
//		
//		
//		
//		@Test(priority = 41)
//		public void Collections_page_share() throws Exception {
//			{
//				mb22 = new CollectionsPageShare(driver);
//				CollectionsPageShare.share_data_with_user_edit_permission();
//				CollectionsPageShare.share_data_with_user_edit_permission_confirmation();
//				
//			}
//		}
		//----------------------Collections-End----------------	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		


		/*	
		//@Test(enabled=false)
		@Test(priority = 9)
		public void rightclick_bulkfileupload() throws Exception {
			{


				RightClickUpload.right_click_bulk_file_upload();

			}
		}



		//@Test(enabled=false)
		@Test(priority = 10)
		public void rightclick_folderupload() throws Exception {
			{


				RightClickUpload.right_click_folder_upload();

			}
		}






		//@Test(enabled=false)
		@Test(priority = 11)
		public void plusbutton_fileupload() throws Exception {
			{
				mb7 = new PlusButtonUpload(driver);
				PlusButtonUpload.plus_button_create_folder();


			}
		}



		//@Test(enabled=false)
		@Test(priority = 12)
		public void plusbutton_singlefileupload() throws Exception {
			{


				PlusButtonUpload.plus_button_single_file_upload();

			}
		}	

		//@Test(enabled=false)
		@Test(priority = 13)
		public void plusbutton_bulkfileupload() throws Exception {
			{



				PlusButtonUpload.plus_button_bulk_file_upload();

			}
		}



		//@Test(enabled=false)
		@Test(priority = 14)
		public void plusbutton_folderupload() throws Exception {
			{


				PlusButtonUpload.plus_button_folder_upload();



			}
		}


		
		

		


		//@Test(enabled=false)
		@Test(priority = 23)
		public void foldersearch() throws Exception {
			{

				
				mb12 = new Search(driver);

				Search.folder_search();


			}
		}

	
		@Test(priority = 24)
		public void filesearch() throws Exception {
			{


				Search.file_search();

			}
		}



		@Test(priority = 25)
		public void foldertagsearch() throws Exception {
			{


				Search.folder_tag_search();

			}
		}

		@Test(priority = 26)
		public void filetagsearch() throws Exception {
			{

				Search.file_tag_search();

			}
		}



		@Test(priority = 27)
		public void filetypesearch_photosimages() throws Exception {
			{

				Search.file_type_search_photos_images();

			}
		}

		@Test(priority = 28)
		public void filetypesearch_pdf() throws Exception {
			{

				Search.file_type_search_pdf();

			}
		}


		@Test(priority = 29)
		public void filetypesearch_documents() throws Exception {
			{

				Search.file_type_search_documents();

			}
		}

*/

		/*

		//@Test(enabled=false, retryAnalyzer=Retry.class)
		@Test(priority = 30)
		public void add_LegalHold() throws Exception {
			{
				
				
				//DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH-mm-ss");
				 // Date date = new Date();
				  
				 // recorder = new ATUTestRecorder("D:\\eclipse-workspace\\ARCA_Automation\\TCRecord","add_LegalHold-"+dateFormat.format(date),false);
				  
				 // recorder.start(); 
				  
				
				
				mb13 = new LegalHold(driver);

				//LegalHold.add_legal_hold();
				

			    
			}
		}

		

		@Test(priority = 31)
		public void search_LegalHold() throws Exception {
			{

				//LegalHold.search_legal_hold();

			}
		}

		@Test(priority = 32)
		public void view_LegalHold() throws Exception {
			{

				LegalHold.view_legal_hold();

			}
		}


		@Test(priority = 33)
		public void removeapply_LegalHold() throws Exception {
			{

				LegalHold.user_remove_apply_hold();

			}
		}


		@Test(priority = 34)
		public void edit_LegalHold() throws Exception {
			{

				
				LegalHold.edit_legal_hold();

			}
		}



		@Test(priority = 35)
		public void delete_LegalHold() throws Exception {
			{

				LegalHold.delete_legal_hold();
				
				recorder.stop();
				Thread.sleep(5000);
			}
		}

		*/
		
		/*

		@Test(priority = 36)
		public void add_retention() throws Exception {
			{
				DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH-mm-ss");
				  Date date = new Date();
				  
				  recorder = new ATUTestRecorder("D:\\eclipse-workspace\\ARCA_Automation\\TCRecord","add_retention-"+dateFormat.format(date),false);
				  
				  recorder.start();  

				mb14 = new Retention(driver);

				Retention.add_retention();


			}
		}


		@Test(priority = 36)
		public void search_retention() throws Exception {
			{

				Retention.search_retention();

			}
		}

		@Test(priority = 37)
		public void view_retention() throws Exception {
			{

				Retention.view_retention();

			}
		}


		@Test(priority = 38)
		public void apply_retention() throws Exception {
			{

				//Retention.apply_retention();

			}
		}



		@Test(priority = 39)
		public void edit_retention() throws Exception {
			{

				Retention.edit_retention();

			}
		}

		@Test(priority = 40)
		public void retire_retention() throws Exception {
			{

				Retention.retire_retention();
				recorder.stop();

			}
		}


		
		@Test(priority = 41)
		public void adding_user() throws Exception {
			{
				  
				login_cred();
				mb15 = new Users(driver);

				//Users.add_user();
				

			}
		}
		
		@Test(priority = 42)
		public void SearchUser() throws Exception {
			{
				  
				
				
				Users.search_user();
			

			}
		}
		
		@Test(priority = 43)
		public void ViewUser() throws Exception {
			{
				
				
				Users.view_user();
				

			}
		}
		
		
		@Test(priority = 44)
		public void EditUser() throws Exception {
			{
				  
			
				Users.edit_user();
				

			}
		}
		
		@Test(priority = 45)
		public void SuspendUser() throws Exception {
			{
				  
				
				Users.suspend_user();

			}
		}
		
		@Test(priority = 46)
		public void ResumeUser() throws Exception {
			{
				  
				
				Users.resume_user();

			}
		}
		


		
	@Test(priority = 41)
		public void adding_group() throws Exception {
			{
				  
				login_cred();
				
				mb16 = new Groups(driver);

				Groups.add_group();
				//Groups.add_user_to_group();
				//Groups.view_group();
				Groups.edit_group();
				Groups.delete_group();
				

			}
		}

	
	@Test(priority = 42)
	public void adding_group() throws Exception {
		{
			  
			login_cred();
			
			mb17 = new SourceManager(driver);

			SourceManager.add_source();
			
			

		}
	}



	


		//@Test(enabled=false)
		@Test(priority = 15)
		public void delet_a_folder() throws Exception {
			{

				mb8 = new DeleteFiles(driver);
				DeleteFiles.folder_delete();

			}
		}


		
		//@Test(enabled=false)
				@Test(priority = 16)
				public void delete_a_file() throws Exception {
					{

					
						DeleteFiles.file_delete();

					}
				}
*/

				/*

		//@Test(enabled=false)
		@Test(priority = 17)
		public void Permanent_FileDelete() throws Exception {
			{


				mb10 = new PermanentDelete(driver);
				PermanentDelete.permanent_file_delete();

			}
		}

		//@Test(enabled=false)
				@Test(priority = 17)
				public void Permanent_FolderDelete() throws Exception {
					{


						PermanentDelete.permanent_folder_delete();

					}
				}

		 */

	@AfterClass
   public void after() throws Exception
   {
   	driver.close();
   	driver.quit();
   	log.info("Browser Closing");
   	log.info("Driver Closing");
   }

  

}