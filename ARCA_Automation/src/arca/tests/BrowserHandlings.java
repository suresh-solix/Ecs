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
import arca.pages.MyFilesComments;
import arca.pages.MyFilesCopy;
import arca.pages.MyFilesDelete;
import arca.pages.MyFilesDownload;
import arca.pages.MyFilesMove;
import arca.pages.MyFilesReminders;
import arca.pages.MyFilesStarred;
import arca.pages.HomePage;
import arca.pages.Signup;
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
import arca.pages.MyFiles_Reminders;
import arca.pages.MyFiles_Share_User_to_Group;
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
		
	//--------------------------Drag and Drop Move ------------------------------------ 5 TC
		

//		@Test(priority = 64) 
//		public void dDragDropMove_File() throws Exception{
//			{
//				mb30 = new DragDropMove(driver);
//				DragDropMove.DragDropMove_File();
//			}
//
//		} 																				


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
//		@Test(priority =67)
//		public void DragDropMove_multiple_folders() throws Exception {
//			{
//				mb30 = new DragDropMove(driver);
//				DragDropMove.DragDropMove_multiple_Folders();
//			}
//
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


		//--------------------------DragandDropMoveVersionUpdateExisting ---------------------------3 TC
		
		
		
//		  @Test(priority =68)
//		  public void DragandDropMoveVersionUpdateExisting_Multiple_files() throws Exception   {
//			  {
//				  mb31 = new DragandDropMoveVersionUpdateExisting(driver);
//		          DragandDropMoveVersionUpdateExisting.DragandDropMoveVersionUpdateExisting_Multiple_files();
//		      }
//		   }
//		 
//		  
//		  @Test(priority =69)
//		  public void DragandDropMoveVersionUpdateExisting_Multiple_folders() throws Exception   {
//			  {
//				  mb31 = new DragandDropMoveVersionUpdateExisting(driver);
//		          DragandDropMoveVersionUpdateExisting.DragandDropMoveVersionUpdateExisting_Multiple_folders();
//		      }
//		   }
//		  
//		  
//		 @Test(priority =70)
//		  public void DragandDropMoveVersionUpdateExisting_Multi_files_folders() throws Exception   {
//			  {
//				  mb31 = new DragandDropMoveVersionUpdateExisting(driver);
//		          DragandDropMoveVersionUpdateExisting.DragandDropMoveVersionUpdateExisting_Multi_files_folders();
//		      }
//		   }		  
		
		  
		  
		//-----------------------DragandDropCopyVersionUpdateExisting ------------------------------  3 TC
		  
//		 @Test(priority =70)
//		  public void DragandDropCopyVersionUpdateExisting_multiple_files() throws Exception   {
//			  {
//				  mb32 = new DragandDropCopyVersionUpdateExisting(driver);
//				  DragandDropCopyVersionUpdateExisting.DragandDropCopyVersionUpdateExisting_multiple_files();
//		     }		  
//		
//		   }
//		 
//		 @Test(priority =70)
//		  public void DragandDropCopyVersionUpdateExisting_multiple_folders() throws Exception   {
//			  {
//				  mb32 = new DragandDropCopyVersionUpdateExisting(driver);
//				  DragandDropCopyVersionUpdateExisting.DragandDropCopyVersionUpdateExisting_multiple_folders();
//		     }		  
//		
//		   }
//		 
//		 @Test(priority =71)
//		  public void DragandDropCopyVersionUpdateExisting_multiple_files_folders() throws Exception   {
//			  {
//				  mb32 = new DragandDropCopyVersionUpdateExisting(driver);
//				  DragandDropCopyVersionUpdateExisting.DragandDropCopyVersionUpdateExisting_multiple_files_folders();
//		     }		  
//		
//		   }
		  
		  
		  
	//------------------------------ DragandDropMoveKeepSeparateVersions - ---------------------------- 3 TC
		
//		 @Test(priority =71)
//		  public void DragandDropMoveKeepSeparateVersions_Files() throws Exception   {
//			  {
//				  mb33 = new DragandDropMoveKeepSeparateVersions(driver);
//				  DragandDropMoveKeepSeparateVersions.DragandDropMoveKeepSeparateVersions_multiple_Files();
//		     }		  
//		 
//		   }
//		
//		 @Test(priority =72)
//		  public void DragandDropMoveKeepSeparateVersions_multiple_Folders() throws Exception   {
//			  {
//				  mb33 = new DragandDropMoveKeepSeparateVersions(driver);
//				  DragandDropMoveKeepSeparateVersions.DragandDropMoveKeepSeparateVersions_multiple_Folders();
//		     }		  
//		 
//		   }
//		
//		 @Test(priority =73)
//		  public void DragandDropMoveKeepSeparateVersions_multiple_Files_Folders() throws Exception   {
//			  {
//				  mb33 = new DragandDropMoveKeepSeparateVersions(driver);
//				  DragandDropMoveKeepSeparateVersions.DragandDropMoveKeepSeparateVersions_multiple_Files_Folders();
//		     }		  
//		 
//		   }
		 
		 
		 
	//--------------------------------- DragandDropMoveVersions_Skip --------------------------------------
		 
		 
//		 @Test(priority =74)
//		  public void DragandDropMoveVersions_Skip_Files() throws Exception   {
//			  {
//				  mb34 = new DragandDropMoveVersions_Skip(driver);
//				  DragandDropMoveVersions_Skip.DragandDropMoveVersions_Skip_Files();
//		     }		  
//		 
//		   }
//		 
//		 
//		 
//		 @Test(priority =75)
//		  public void DragandDropMoveVersions_Skip_Folders() throws Exception   {
//			  {
//				  mb34 = new DragandDropMoveVersions_Skip(driver);
//				  DragandDropMoveVersions_Skip.DragandDropMoveVersions_Skip_Folders();
//		     }		  
//		 
//		   }
		 
		 
		
		 
	//-------------------------MyFiles_Collection----------------------
		
		 
//		 @Test(priority =76)
//		  public void MyFiles_Collection() throws Exception   {
//			  {
//				  mb35 = new MyFiles_Collection(driver);
//				  MyFiles_Collection.MyFiles_Collection();
//		     }		  
//		 }
//		
//		 
//		@Test(priority =77)
//		  public void MyFiles_Collections_Restriction() throws Exception   {
//			  {
//				  mb35 = new MyFiles_Collection(driver);
//				  MyFiles_Collection.MyFiles_Collections_Restriction();
//		     }		  
//		 
//		   }
		 
		 
		
	//--------------------------MyFile_Share_User_Admin-------------------------------
		 
		
//		@Test(priority =78)
//		public void MyFile_Share_User_Admin_Muti_data_Edit_Permission() throws Exception   {
//			{
//				mb36 = new MyFile_Share_User_Admin(driver);
//				MyFile_Share_User_Admin.MyFile_Share_User_Admin_Muti_data_Edit_Permission();
//				MyFile_Share_User_Admin. MyFile_Share_User_Admin_Muti_data_Edit_Permission_confirmation();
//			}		  
//		}
//
//
//		@Test(priority =79)
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
//		@Test(priority =80)
//		public void MyFile_Share_User_Admin_Muti__View_permission() throws Exception   {
//			{
//				mb36 = new MyFile_Share_User_Admin(driver);
//				MyFile_Share_User_Admin.MyFile_Share_User_Admin_Muti__View_permission();
//				MyFile_Share_User_Admin.MyFile_Share_User_Admin_Muti__View_permission_Confirmation();
//			}
//		}
//
//		@Test(priority =81)
//		public void MyFile_Share_User_Admin_Muti_Preview_Permission() throws Exception   {
//			{
//				mb36 = new MyFile_Share_User_Admin(driver);
//				MyFile_Share_User_Admin.MyFile_Share_User_Admin_Muti_Preview_Permission();
//				MyFile_Share_User_Admin.MyFile_Share_User_Admin_Muti_Preview_Permission_Confirmation();	  
//			}
//		}
//
//
//		@Test(priority =82)
//		public void MyFile_Share_User_Admin_Muti_Upload_Permission() throws Exception   {
//			{
//				mb36 = new MyFile_Share_User_Admin(driver);
//				MyFile_Share_User_Admin.MyFile_Share_User_Admin_Muti_Upload_Permission();
//				MyFile_Share_User_Admin.MyFile_Share_User_Admin_Muti_Upload_Permission_Confirmation();
//			}
//		}
//
//
//		@Test(priority =83)
//		public void MyFile_Share_User_Admin_Remove_Files_Folders() throws Exception   {
//			{
//				mb36 = new MyFile_Share_User_Admin(driver);
//				MyFile_Share_User_Admin.MyFile_Share_User_Admin_Remove_Files_Folders();
//			}	 
//		}
//

		
		
		
		//----------------------------MyFiles_share_Admin_to_Group-------------------------------
		
//		@Test(priority =84)
//		  public void MyFiles_share_Admin_to_Group_Edit_Permission() throws Exception   {
//			  {
//				  mb37 = new MyFiles_share_Admin_to_Group(driver);
//				  MyFiles_share_Admin_to_Group.MyFiles_share_Admin_to_Group_Edit_Permission();
//		     }	 
//		 }
//		
//		@Test(priority =85)
//		  public void MyFiles_share_Admin_to_Group_Commenter_Permission() throws Exception   {
//			  {
//				  mb37 = new MyFiles_share_Admin_to_Group(driver);
//				  MyFiles_share_Admin_to_Group.MyFiles_share_Admin_to_Group_Commenter_Permission();
//		     }	 
//		 }
//		
//		
//		@Test(priority =86)
//		  public void MyFiles_share_Admin_to_Group_View_Permission() throws Exception   {
//			  {
//				  mb37 = new MyFiles_share_Admin_to_Group(driver);
//				  MyFiles_share_Admin_to_Group.MyFiles_share_Admin_to_Group_View_Permission();
//		     }	 
//		 }
//		
//		
//		@Test(priority =87)
//		  public void MyFiles_share_Admin_to_Group_Preview_Permission() throws Exception   {
//			  {
//				  mb37 = new MyFiles_share_Admin_to_Group(driver);
//				  MyFiles_share_Admin_to_Group.MyFiles_share_Admin_to_Group_Preview_Permission();
//		     }	 
//		 }
//		
//		
//		@Test(priority =88)
//		  public void MyFiles_share_Admin_to_Group_Upload_Permission() throws Exception   {
//			  {
//				  mb37 = new MyFiles_share_Admin_to_Group(driver);
//				  MyFiles_share_Admin_to_Group.MyFiles_share_Admin_to_Group_Upload_Permission();
//		     }	 
//		 }
//		
//		
//		@Test(priority =89)
//		  public void MyFiles_share_Admin_to_Group_Remove_Files_And_Folders() throws Exception   {
//			  {
//				  mb37 = new MyFiles_share_Admin_to_Group(driver);
//				  MyFiles_share_Admin_to_Group.MyFiles_share_Admin_to_Group_Remove_Files_And_Folders();
//		     }	 
//		 }
//		
		
		
	
		//--------------------------------MyFiles_Share_User_to_Group---------------------------
		
		
//		@Test(priority =90)
//		  public void MyFiles_share_User_to_Group_Edit_Permission() throws Exception   {
//			  {
//				  mb38 = new MyFiles_Share_User_to_Group(driver);
//				  MyFiles_Share_User_to_Group.MyFiles_share_User_to_Group_Edit_Permission();
//		     }	 
//		 }
//		
//		@Test(priority =91)
//		  public void MyFiles_share_User_to_Group_Commenter_Permission() throws Exception   {
//			  {
//				  mb38 = new MyFiles_Share_User_to_Group(driver);
//				  MyFiles_Share_User_to_Group.MyFiles_share_User_to_Group_Commenter_Permission();
//		     }	 
//		 }
//		
//		@Test(priority =92)
//		  public void MyFiles_share_User_to_Group_View_Permission() throws Exception   {
//			  {
//				  mb38 = new MyFiles_Share_User_to_Group(driver);
//				  MyFiles_Share_User_to_Group.MyFiles_share_User_to_Group_View_Permission();
//		     }	 
//		 }
//		
//		
//		@Test(priority =93)
//		  public void MyFiles_share_User_to_Group_Preview_Permission() throws Exception   {
//			  {
//				  mb38 = new MyFiles_Share_User_to_Group(driver);
//				  MyFiles_Share_User_to_Group.MyFiles_share_User_to_Group_Preview_Permission();
//		     }	 
//		 }
//		
//		
//		@Test(priority =94)
//		  public void MyFiles_share_User_to_Group_Upload_Permission() throws Exception   {
//			  {
//				  mb38 = new MyFiles_Share_User_to_Group(driver);
//				  MyFiles_Share_User_to_Group.MyFiles_share_User_to_Group_Upload_Permission();
//		     }	 
//		 }
//		
//		
//		@Test(priority =95)
//		  public void MyFiles_share_User_to_Group_Remove_Files_And_Folders() throws Exception   {
//			  {
//				  mb38 = new MyFiles_Share_User_to_Group(driver);
//				  MyFiles_Share_User_to_Group.MyFiles_share_User_to_Group_Remove_Files_And_Folders();
//		     }	 
//		 }
		
		
		
		//----------------------------------MyFiles_Reminders-----------------------------------------------
		
		@Test(priority =96)
		  public void MyFiles_Reminders_Files() throws Exception   {
			  {
				  mb39 = new MyFiles_Reminders(driver);
	         	  MyFiles_Reminders.MyFiles_Reminders_Files();
				  MyFiles_Reminders.MyFiles_Reminders_Files_Edit();
		     	  MyFiles_Reminders.MyFiles_Reminders_Files_Bell_Icon();
				  MyFiles_Reminders.MyFiles_Reminders_Delete();
			  }
		 }
		
		@Test(priority =97)
		  public void MyFiles_Reminders_Folders() throws Exception   {
			  {
				  mb39 = new MyFiles_Reminders(driver);
	         	  MyFiles_Reminders.MyFiles_Reminders_Folders();
				  MyFiles_Reminders.MyFiles_Reminders_Folders_Edit();
		     	  MyFiles_Reminders.MyFiles_Reminders_Folder_Bell_Icon();
				  MyFiles_Reminders.MyFiles_Reminders_Folder_Delete();
			  }
		 }
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
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