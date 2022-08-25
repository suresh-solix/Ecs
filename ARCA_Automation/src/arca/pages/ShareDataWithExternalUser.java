package arca.pages;

import static org.testng.Assert.assertEquals;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import arca.common.Navigation;
import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.reports.utils.Utils;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;



public class ShareDataWithExternalUser extends Navigation {

	static WebDriver driver;
	static Actions actions;

	private static Logger log = Logger.getLogger(ShareDataWithExternalUser.class.getName());
	public static String Home_Page = "https://app.solixecsdev.com/login";
	public ShareDataWithExternalUser(WebDriver driver) {
		super(driver);
		this.driver = driver;
		//driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS).pageLoadTimeout(60, TimeUnit.SECONDS);
		ATUReports.setWebDriver(driver);
		ATUReports.setTestCaseReqCoverage("Share with external user");
		setIndexPageDescription();
		setAuthorInfoForReports();
		log.info("--------------------Share with external user--------------------");
		captureScreenShot(ScreenShotsFilePath + "Share_with_external_user.png");
	}

	private void setAuthorInfoForReports() {
		ATUReports.setAuthorInfo("Mahesh", Utils.getCurrentTime(),"2.0");
	}

	private void setIndexPageDescription() {
		ATUReports.indexPageDescription = "Share with external user";
	}

	/*
	public class signupData
	{

		private String email;
		private String first_name;
		private String last_name;
		private String password;

		public signupData(String email, String first_name, String last_name,String password) throws IOException 
			{
		setEmail(email);
		setFirst_name(first_name);
		setLast_name(last_name);
		setPassword(password);	
			}


		public String getEmail() {
			return email;
		}


		public void setEmail(String email) {
			this.email = email;
		}


		public String getFirst_name() {
			return first_name;
		}


		public void setFirst_name(String first_name) {
			this.first_name = first_name;
		}


		public String getLast_name() {
			return last_name;
		}


		public void setLast_name(String last_name) {
			this.last_name = last_name;
		}


		public String getPassword() {
			return password;
		}


		public void setPassword(String password) {
			this.password = password;
		}

	}


	 */


	

	//-------------------------------------------------------multiple Files folders share with edit permission-------------------------------------------------------


	public static void share_data_with_external_user_edit_permission()
	{

		try
		{
			
			actions = new Actions(driver);
			
			driver.get(Home_Page);
			//Navigation.login();
			 
			WebDriverWait wait312123 = new WebDriverWait(driver, 60);
			wait312123.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[contains(text(),'Folders')]")));
			 
			

			WebElement all_folders1 = getPageObject("folder_names");
			List<WebElement> each_folder1=all_folders1.findElements(By.tagName("div"));

			for(int i=0;i<each_folder1.size();i++)
			{


				WebElement each_div =each_folder1.get(i);
				String selected_folder_name = each_div.getText();
				//log.info("--------------------"+selected_file_folder_name);
				if(selected_folder_name.contains("Guest User Share Data"))
				{
					
					actions.doubleClick(each_folder1.get(i)).perform();
					Thread.sleep(2000);

					break;
					
					
				}
				
			}
			WebDriverWait wait3121237 = new WebDriverWait(driver, 60);
			wait3121237.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[contains(text(),'Folders')]")));
			 
			
			click("first_folder_infolder");
			//Thread.sleep(1000);
			JsClick("selected_folder_checkbox");
			String first_folder_name=getPageObject("first_folder_infolder").getText();
			log.info("first folder name--->"+first_folder_name);
			//Thread.sleep(1000);
			
			
			click("second_folder_infolder");
			//Thread.sleep(1000);
			JsClick("selected_folder_checkbox");
			String second_folder_name=getPageObject("second_folder_infolder").getText();
			log.info("second folder name--->"+second_folder_name);
			//Thread.sleep(1000);
			
			
			click("third_folder_infolder");
			//Thread.sleep(1000);
			JsClick("selected_folder_checkbox");
			String third_folder_name=getPageObject("third_folder_infolder").getText();
			log.info("third folder name--->"+third_folder_name);
			//Thread.sleep(1000);
			
		
			
			click("first_file_infolder");
			//Thread.sleep(1000);
			JsClick("selected_file_checkbox");
			String first_file_name=getPageObject("first_file_infolder").getText();
			log.info("third folder name--->"+first_file_name);
			//Thread.sleep(1000);
			
			
			click("second_file_infolder");
			//Thread.sleep(1000);
			JsClick("selected_file_checkbox");
			String second_file_name=getPageObject("second_file_infolder").getText();
			log.info("third folder name--->"+second_file_name);
			//Thread.sleep(1000);
			
			
			click("third_file_infolder");
			//Thread.sleep(1000);
			JsClick("selected_file_checkbox");
			String third_file_name=getPageObject("third_file_infolder").getText();
			log.info("third folder name--->"+third_file_name);
			//Thread.sleep(1000);
			
			
			
 

			WebElement elementLocator = getPageObject("first_file_infolder");
			actions.contextClick(elementLocator).perform();
			Thread.sleep(2000);
			
			WebElement external_guest_user = getPageObject("external_sharing");
			actions.moveToElement(external_guest_user).perform(); 
			
			Thread.sleep(1000);
			
			
			click("guest_user_account");
			WebDriverWait wait31 = new WebDriverWait(driver, 60);
			wait31.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Share with guest accounts')]")));
			
			
			
		
			
			Thread.sleep(2000);
			WebElement noUserOr = getPageObject("external_guest_user_text_field");
			noUserOr.sendKeys("p");
			
			
			WebDriverWait wait313 = new WebDriverWait(driver, 60);
			wait313.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='multiselect__content']/li[1]")));
			
			
			
			getPageObject("search_result_first_element").click(); 
			Thread.sleep(2000);
			click("share_button");
			//Thread.sleep(1000);
			//click("share_button");
			
			 
			WebDriverWait wait53453 = new WebDriverWait(driver, 60);
			wait53453.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='Vue-Toastification__toast-body']")));

			
			String toast_text=getPageObject("starred_toast").getText();
			log.info("Toast text is ---->"+toast_text);
			
			if(getPageObject("starred_toast").getText().contains("Successfully shared"));
			
			Thread.sleep(2000);
			click("toast_close");
			log.info("Toast closed");
	
			
			click("profile_icon");
			
			click("sing_out");
			Thread.sleep(2000);
			WebDriverWait wait35123 = new WebDriverWait(driver, 60);
			wait35123.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));
			
			
			
			Navigation.external_guest_user();
			WebDriverWait wait3121231 = new WebDriverWait(driver, 60);
			wait3121231.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[contains(text(),'Folders')]")));
			 

			click("first_folder_infolder");
			//Thread.sleep(1000);
			String share_first_folder_name=getPageObject("first_folder_infolder").getText();
			log.info("first folder name--->"+share_first_folder_name);
			//Thread.sleep(1000);
			
			
			click("second_folder_infolder");
			//Thread.sleep(1000);
			String share_second_folder_name=getPageObject("second_folder_infolder").getText();
			log.info("second folder name--->"+share_second_folder_name);
			//Thread.sleep(1000);
			
			
			click("third_folder_infolder");
			//Thread.sleep(1000);
			String share_third_folder_name=getPageObject("third_folder_infolder").getText();
			log.info("third folder name--->"+share_third_folder_name);
			//Thread.sleep(1000);
			
			String all_shared_folders=share_first_folder_name+share_second_folder_name+share_third_folder_name;
			
			
			
			
			click("share_first_file");
			//Thread.sleep(1000);
			String share_first_file_name=getPageObject("share_first_file").getText();
			log.info("first file name--->"+share_first_file_name);
			//Thread.sleep(1000);
			
			
			click("share_second_file");
			//Thread.sleep(1000);
			String share_second_file_name=getPageObject("share_second_file").getText();
			log.info("second file name--->"+share_second_file_name);
			//Thread.sleep(1000);
			
			
			click("share_third_file");
			//Thread.sleep(1000);
			String share_third_file_name=getPageObject("share_third_file").getText();
			log.info("third file name--->"+share_third_file_name);
			//Thread.sleep(1000);
			
			String all_shared_files=share_first_file_name+share_second_file_name+share_third_file_name;
			
			
			
			if(all_shared_folders.contains(share_first_folder_name))
			{
				log.info("First folder shared");
				ATUReports.add("First folder shared successfully","First folder shared successfully",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				
				
			}
			else
			{
				ATUReports.add("First folder share failed","First folder share failed",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				
			}
			
			if(all_shared_folders.contains(share_second_folder_name))
			{
				log.info("second folder shared");
				ATUReports.add("second folder shared successfully","second folder shared successfully",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				
				
			}
			else
			{
				ATUReports.add("second folder share failed","second folder share failed",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				
			}
				
			
			if(all_shared_folders.contains(share_third_folder_name))
			{
				log.info("Third folder shared");
				ATUReports.add("Third folder shared successfully","Third folder shared successfully",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				
				
			}
			else
			{
				ATUReports.add("Third folder share failed","Third folder share failed",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				
			}
			
			log.info("first folder name--->"+share_first_file_name);
			log.info("first folder name--->"+all_shared_files);
						
			if(all_shared_files.contains(share_first_file_name))
			{
				log.info("First file shared");
				ATUReports.add("First file shared successfully","First file shared successfully",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				
				
			}
			else
			{
				ATUReports.add("First file share failed","First file share failed",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				
			}
			
			if(all_shared_files.contains(share_second_file_name))
			{
				log.info("Second file shared");
				ATUReports.add("Second file shared successfully","Second file shared successfully",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				
				
			}
			else
			{
				ATUReports.add("Second file share failed","Second file share failed",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				
			}
			
			if(all_shared_files.contains(share_third_file_name))
			{
				log.info("Third file shared");
				ATUReports.add("Third file shared successfully","Third file shared successfully",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				
				
			}
			else
			{
				ATUReports.add("Third file share failed","Third file share failed",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				
			}
			
			
			log.info("--------------------------------------------Folders and files shared successfully--------------------------------------------");
			
			captureScreenShot(ScreenShotsFilePath + "folders_files_shared_successfully.png");
			Thread.sleep(2000);
			ATUReports.add("Folders and files shared successfully","Multiple files folders shared successfully",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(2000);
		


		}
		
		

		catch (Exception e) {

			System.out.println("errror at: ");
			e.printStackTrace();
			log.error("Error in sharing files and folders",e);	
			//log.fatal(e.getMessage(),e);
			captureScreenShot(ScreenShotsFilePath + "folders_files_share_failed_Error.png");
			ATUReports.add("Folders and files share failed","Folders and files share",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}

	}
	
	//-------------------------------------------------------multiple Files folders share with edit permissions confirmation-------------------------------------------------------


		public static void share_data_with_user_edit_permission_confirmation()
		{

			try
			{

				//Navigation.external_guest_user();
				
				
				
				WebElement elementLocator1 = driver.findElement(By.xpath("//div[@class='folder']/div[@class='row'][1]/div[1]/div"));
				
				
				//WebElement elementLocator1 = getPageObject("first_folder_infolder");
				actions.contextClick(elementLocator1).perform();
				
				
				Thread.sleep(2000);
				
				
				
				//WebElement shared_folder_right_click_options = driver.findElement(By.xpath("//div[@class='folder']/div/div[@class='context-list']/ul"));
				WebElement shared_folder_right_click_options = driver.findElement(By.xpath("//div[@class='folder']/div[@class='row'][1]/following-sibling::div/ul"));
				List<WebElement> each_folder_li_tag=shared_folder_right_click_options.findElements(By.tagName("li"));

				for(int i=0;i<each_folder_li_tag.size();i++)
				{

					WebElement li =each_folder_li_tag.get(i);

					String each_li = each_folder_li_tag.get(i).getText();
					log.info("Shared folder right click options "+each_li);
					
					if(each_li.contains("Add/View Comment") || each_li.contains("Add/View Tags") || each_li.contains("Copy / Move") || each_li.contains("Download") || each_li.contains("Rename") || each_li.contains("Export Metadata") || each_li.contains("Trash"))
						{
						log.info("folder right click option exist");
						Thread.sleep(2000);
						
					}
					else
					{
						log.info("folder right click option does not exist");
						ATUReports.add("folder right click option failed","folder right click option",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						
					}
					
				}
				
				
				/*
				String share_folder_expected_right_click_options = "Share + Add/View Comment Add/View Tags Download Trash";
				String folder_right_click_options = getPageObject("shared_folder_edit_right_click_options").getText();
				
				
				if(share_folder_expected_right_click_options==folder_right_click_options);
				*/
				Robot robot = new Robot();
				robot.keyPress(KeyEvent.VK_ESCAPE);
				robot.keyRelease(KeyEvent.VK_ESCAPE);
				Thread.sleep(2000);	
				
				WebElement elementLocator9 = getPageObject("share_first_file");
				actions.contextClick(elementLocator9).perform();
				Thread.sleep(2000);

				
				
				

				//WebElement shared_file_right_click_options = driver.findElement(By.xpath("//div[@class='files']/div/div[@class='context-list']/ul"));
				
				WebElement shared_file_right_click_options = driver.findElement(By.xpath("//div[@class='files']/div[@class='row'][1]/following-sibling::div/ul"));
				
				List<WebElement> each_file_li_tag=shared_file_right_click_options.findElements(By.tagName("li"));
				
				for(int i=0;i<each_file_li_tag.size();i++)
				{

					WebElement li =each_file_li_tag.get(i);

					String each_li = each_file_li_tag.get(i).getText();
					log.info("Shared folder right click options "+each_li);
					
					if(each_li.contains("Preview") || each_li.contains("Add/View Comment") || each_li.contains("Add/View Tags") || each_li.contains("Copy / Move") || each_li.contains("Download") || each_li.contains("Rename") || each_li.contains("View Versions") || each_li.contains("Trash"))
					{
						log.info("file right click option exist");
						Thread.sleep(2000);
						
					}
					else
					{
						log.info("file right click option does not exist");
						ATUReports.add("folder right click option failed","folder right click option",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						
					}
					
				}
				
				
				/*
				String share_file_expected_right_click_options = "Preview Share + Add/View Comment Add/View Tags Add to Collection Download View Versions Trash";
				String file_right_click_options = getPageObject("shared_file_edit_right_click_options").getText();
				
				
				if(share_file_expected_right_click_options==file_right_click_options);
				*/
				
					
					//if a folder shared with edit permissions within the shared folder, user should be able to create a new folder
					
					//click("shared_with_me");
					
					
					/*
					actions.doubleClick(getPageObject("first_folder_infolder")).perform();
					
					
					
					
					
					
					click("plus_button_in_sharewithme_page");
					Thread.sleep(2000);
					
					
					click("share_page_plusbutton_newfolder");
					
					

					DateFormat dateFormat = new SimpleDateFormat("MMM-dd HH-mm");

					//get current date time with Date()
					Date date = new Date();

					// Now format the date
					String dateFormatted= dateFormat.format(date);
					
					String folder_in_shared_folder="in shared fldr plusbutton "+dateFormatted;
					sendKeys("folder_name_input_field",folder_in_shared_folder);
					click("folder_ok_button");
					
					
					WebDriverWait wait2225 = new WebDriverWait(driver, 60);
					wait2225.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='Vue-Toastification__toast-body']")));

					String toast_text=getPageObject("starred_toast").getText();
					
					if(toast_text=="Folder Created Successfully");
					
					log.info("Folder Created Successfully using plus button");
					
					Thread.sleep(2000);
					click("toast_close");
					log.info("Toast closed");
					

					//-------------Right click folder create

					WebElement elementLocator = getPageObject("home_allfiles");
					actions.contextClick(elementLocator).perform();
					Thread.sleep(2000);
					

					
					click("share_page_rightclick_newfolder");
					Thread.sleep(2000);
					
					
					
					String rightclick_in_shared_folder="in shared fldr rightclick"+dateFormatted;
					sendKeys("folder_name_input_field",rightclick_in_shared_folder);
					click("folder_ok_button");
					
					
					WebDriverWait wait2227 = new WebDriverWait(driver, 60);
					wait2227.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='Vue-Toastification__toast-body']")));

					String toast_text_rightclick=getPageObject("starred_toast").getText();
					
					if(toast_text_rightclick=="Folder Created Successfully");
					
					log.info("Folder Created Successfully using right click option");
					
					Thread.sleep(2000);
					click("toast_close");
					log.info("Toast closed");
					*/
					
					
				
					log.info("--------------------------------------------Folders and files shared with edit permission right click options successfully--------------------------------------------");
					
					captureScreenShot(ScreenShotsFilePath + "folders_files_shared_with_edit_permission_successfully.png");
					Thread.sleep(2000);
					ATUReports.add("Folders and files shared with edit permissions successfully","Multiple files folders shared with edit permissions successfully",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					Thread.sleep(2000);
				
				
				
			}
			
			

			catch (Exception e) {

				System.out.println("errror at: ");
				e.printStackTrace();
				log.error("Error in sharing files and folders with edit permission",e);	
				//log.fatal(e.getMessage(),e);
				captureScreenShot(ScreenShotsFilePath + "folders_files_share_edit_permission_failed_Error.png");
				ATUReports.add("Folders and files share with edit permission failed","Folders and files share",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}

		}
		
		
		


		//-------------------------------------------------------multiple Files folders share with commenter permission-------------------------------------------------------


		public static void share_data_with_user_commenter_permission()
		{

			try
			{
				
				actions = new Actions(driver);
				
				
				//driver.get(Home_Page);
				
				click("profile_icon");
				
				click("sing_out");
				Thread.sleep(2000);
				WebDriverWait wait35123 = new WebDriverWait(driver, 60);
				wait35123.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Login')]")));
				
				

				Navigation.login();
			 
				WebDriverWait wait312123 = new WebDriverWait(driver, 60);
				wait312123.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[contains(text(),'Folders')]")));
				
				

			WebElement all_folders1 = getPageObject("folder_names");
			List<WebElement> each_folder1=all_folders1.findElements(By.tagName("div"));

			for(int i=0;i<each_folder1.size();i++)
			{


				WebElement each_div =each_folder1.get(i);
				String selected_folder_name = each_div.getText();
				//log.info("--------------------"+selected_file_folder_name);
				if(selected_folder_name.contains("Guest User Share Data"))
				{
					
					actions.doubleClick(each_folder1.get(i)).perform();
					Thread.sleep(2000);

					break;
					
					
				}
				
			}
			WebDriverWait wait3121236 = new WebDriverWait(driver, 60);
			wait3121236.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[contains(text(),'Folders')]")));
			 
			
			click("first_folder_infolder");
			//Thread.sleep(1000);
			JsClick("selected_folder_checkbox");
			String first_folder_name=getPageObject("first_folder_infolder").getText();
			log.info("first folder name--->"+first_folder_name);
			//Thread.sleep(1000);
			
			
			click("second_folder_infolder");
			//Thread.sleep(1000);
			JsClick("selected_folder_checkbox");
			String second_folder_name=getPageObject("second_folder_infolder").getText();
			log.info("second folder name--->"+second_folder_name);
			//Thread.sleep(1000);
			
			
			click("third_folder_infolder");
			//Thread.sleep(1000);
			JsClick("selected_folder_checkbox");
			String third_folder_name=getPageObject("third_folder_infolder").getText();
			log.info("third folder name--->"+third_folder_name);
			//Thread.sleep(1000);
			
		
			click("first_file_infolder");
			//Thread.sleep(1000);
			JsClick("selected_file_checkbox");
			String first_file_name=getPageObject("first_file_infolder").getText();
			log.info("third folder name--->"+first_file_name);
			//Thread.sleep(1000);
			
			
			click("second_file_infolder");
			//Thread.sleep(1000);
			JsClick("selected_file_checkbox");
			String second_file_name=getPageObject("second_file_infolder").getText();
			log.info("third folder name--->"+second_file_name);
			//Thread.sleep(1000);
			
			
			click("third_file_infolder");
			//Thread.sleep(1000);
			JsClick("selected_file_checkbox");
			String third_file_name=getPageObject("third_file_infolder").getText();
			log.info("third folder name--->"+third_file_name);
			//Thread.sleep(1000);
			
			
 

			WebElement elementLocator = getPageObject("first_file_infolder");
			actions.contextClick(elementLocator).perform();
			Thread.sleep(2000);
			
			WebElement external_guest_user = getPageObject("external_sharing");
			actions.moveToElement(external_guest_user).perform(); 
			
			Thread.sleep(1000);
			
			
			click("guest_user_account");
			WebDriverWait wait31 = new WebDriverWait(driver, 60);
			wait31.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Share with guest accounts')]")));
		
				
				
				
				/*
				click("share_user_or_group_field");
				Thread.sleep(2000);
				sendKeys("share_user_or_group_field","t");
				Thread.sleep(2000);
				
				first_folder_myfiles=//div[@class='folder']/div[@class='row']/div[1]/div/div/article/div/div[@class='media-body']
						second_folder_myfiles=//div[@class='folder']/div[@class='row']/div[2]/div/div/article/div/div[@class='media-body']
						third_folder_myfiles=//div[@class='folder']/div[@class='row']/div[3]/div/div/article/div/div[@class='media-body']
				
				*/
				
				
				
				/*
				WebElement my_element = new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='multiselect']")));

				my_element.click();
				my_element.sendKeys("t");

				
				WebDriverWait wait31 = new WebDriverWait(driver, 60);
				wait31.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='multiselect__content']/li[1]")));
				
				
				
				getPageObject("search_result_first_element").click(); 
				Thread.sleep(2000);
				*/
				
				
				
				select("shared_user_popup_dropdown","visibletext","Commenter");
				Thread.sleep(2000);
				
				click("share_button");
				//Thread.sleep(1000);
				//click("share_button");
				
				WebDriverWait wait2226 = new WebDriverWait(driver, 60);
				wait2226.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='Vue-Toastification__toast-body']")));

				if(getPageObject("starred_toast").getText().contains("Successfully shared"));
				
				Thread.sleep(2000);
				click("toast_close");
				log.info("Toast closed");
				
				
				
				
					
				
				/*
			    ChromeOptions options = new ChromeOptions();
			    options.addArguments("incognito");
			    DesiredCapabilities cap = DesiredCapabilities.chrome();
			    cap.setCapability(ChromeOptions.CAPABILITY, options);
			    driver = new ChromeDriver(cap);
			    driver.manage().window().maximize();
			    
			    
				Robot robot = new Robot();
				robot.keyPress(KeyEvent.VK_ALT);
				robot.keyPress(KeyEvent.VK_TAB);
				robot.keyRelease(KeyEvent.VK_ALT);
				robot.keyRelease(KeyEvent.VK_TAB);
			    */
			    
			    
				/*
				 WebDriver driver = new ChromeDriver();
				 new Navigation(driver);
				 driver.manage().window().maximize();

				driver.get(Home_Page);
				*/
				click("profile_icon");
				
				click("sing_out");
				
				Thread.sleep(2000);
				WebDriverWait wait35 = new WebDriverWait(driver, 60);
				wait35.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));
				
				
				Navigation.external_guest_user();
				WebDriverWait wait3121233 = new WebDriverWait(driver, 60);
				wait3121233.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[contains(text(),'Folders')]")));
				 
				

				click("first_folder_infolder");
				//Thread.sleep(1000);
				String share_first_folder_name=getPageObject("first_folder_infolder").getText();
				log.info("first folder name--->"+share_first_folder_name);
				//Thread.sleep(1000);
				
				
				click("second_folder_infolder");
				//Thread.sleep(1000);
				String share_second_folder_name=getPageObject("second_folder_infolder").getText();
				log.info("second folder name--->"+share_second_folder_name);
				//Thread.sleep(1000);
				
				
				click("third_folder_infolder");
				//Thread.sleep(1000);
				String share_third_folder_name=getPageObject("third_folder_infolder").getText();
				log.info("third folder name--->"+share_third_folder_name);
				//Thread.sleep(1000);
				
				String all_shared_folders=share_first_folder_name+share_second_folder_name+share_third_folder_name;
				
				
				
				
				click("share_first_file");
				//Thread.sleep(1000);
				String share_first_file_name=getPageObject("share_first_file").getText();
				log.info("first file name--->"+share_first_file_name);
				//Thread.sleep(1000);
				
				
				click("share_second_file");
				//Thread.sleep(1000);
				String share_second_file_name=getPageObject("share_second_file").getText();
				log.info("second file name--->"+share_second_file_name);
				//Thread.sleep(1000);
				
				
				click("share_third_file");
				//Thread.sleep(1000);
				String share_third_file_name=getPageObject("share_third_file").getText();
				log.info("third file name--->"+share_third_file_name);
				//Thread.sleep(1000);
				
				String all_shared_files=share_first_file_name+share_second_file_name+share_third_file_name;
				
				
				
				
				if(all_shared_folders.contains(first_folder_name))
				{
					log.info("First folder shared");
					ATUReports.add("First folder shared successfully","First folder shared successfully",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					
					
				}
				else
				{
					ATUReports.add("First folder share failed","First folder share failed",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					
				}
					
				if(all_shared_folders.contains(second_folder_name))
				{
					log.info("Second folder shared");
					ATUReports.add("Second folder shared successfully","Second folder shared successfully",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					
					
				}
				else
				{
					ATUReports.add("Second folder share failed","Second folder share failed",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					
				}
				
				if(all_shared_folders.contains(third_folder_name))
				{
					log.info("Third folder shared");
					ATUReports.add("Third folder shared successfully","Third folder shared successfully",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					
					
				}
				else
				{
					ATUReports.add("Third folder share failed","Third folder share failed",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					
				}
				
				log.info("first folder name--->"+share_first_file_name);
				log.info("first folder name--->"+all_shared_files);
							
				if(all_shared_files.contains(share_first_file_name))
				{
					log.info("First file shared");
					ATUReports.add("First file shared successfully","First file shared successfully",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					
					
				}
				else
				{
					ATUReports.add("First file share failed","First file share failed",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					
				}
				
				if(all_shared_files.contains(share_second_file_name))
				{
					log.info("Second file shared");
					ATUReports.add("Second file shared successfully","Second file shared successfully",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					
					
				}
				else
				{
					ATUReports.add("Second file share failed","Second file share failed",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					
				}
				
				if(all_shared_files.contains(share_third_file_name))
				{
					log.info("Third file shared");
					ATUReports.add("Third file shared successfully","Third file shared successfully",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					
					
				}
				else
				{
					ATUReports.add("Third file share failed","Third file share failed",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					
				}
				
				
				log.info("--------------------------------------------Folders and files shared with commenter permission successfully--------------------------------------------");
				
				captureScreenShot(ScreenShotsFilePath + "folders_files_shared_with_commenter_permission_successfully.png");
				Thread.sleep(2000);
				ATUReports.add("Folders and files shared with commenter permission successfully","Multiple files folders shared with commenter permission successfully",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			


			}
			
			

			catch (Exception e) {

				System.out.println("errror at: ");
				e.printStackTrace();
				log.error("Error in sharing files and folders with commenter permission",e);	
				//log.fatal(e.getMessage(),e);
				captureScreenShot(ScreenShotsFilePath + "folders_files_share_with_commenter_permission_failed_Error.png");
				ATUReports.add("Folders and files share with commenter permission failed","Folders and files share with commenter permission failed",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}

		}
		
		//-------------------------------------------------------multiple Files folders share with commenter permissions confirmation-------------------------------------------------------


			public static void share_data_with_user_commenter_permission_confirmation()
			{

				try
				{
					
					
					
					actions = new Actions(driver);
					
					

					
					
					
					WebElement elementLocator1 = driver.findElement(By.xpath("//div[@class='folder']/div[@class='row'][1]/div[1]/div"));
					
					
					//WebElement elementLocator1 = getPageObject("first_folder_infolder");
					actions.contextClick(elementLocator1).perform();
					
					
					Thread.sleep(2000);
					
					
					
					//WebElement shared_folder_right_click_options = driver.findElement(By.xpath("//div[@class='folder']/div/div[@class='context-list']/ul"));
					WebElement shared_folder_right_click_options = driver.findElement(By.xpath("//div[@class='folder']/div[@class='row'][1]/following-sibling::div/ul"));
					List<WebElement> each_folder_li_tag=shared_folder_right_click_options.findElements(By.tagName("li"));

					for(int i=0;i<each_folder_li_tag.size();i++)
					{

						WebElement li =each_folder_li_tag.get(i);

						String each_li = each_folder_li_tag.get(i).getText();
						log.info("Shared folder right click options "+each_li);
						
						if(each_li.contains("Add/View Comment") || each_li.contains("Add/View Tags") || each_li.contains("Copy / Move") || each_li.contains("Download") || each_li.contains("Export Metadata"))
						{
							log.info("folder right click option exist");
							Thread.sleep(2000);
							
						}
						else
						{
							log.info("folder right click option does not exist");
							ATUReports.add("folder right click option failed","folder right click option",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							
						}
						
					}
					
					
					/*
					String share_folder_expected_right_click_options = "Share + Add/View Comment Add/View Tags Download Trash";
					String folder_right_click_options = getPageObject("shared_folder_edit_right_click_options").getText();
					
					
					if(share_folder_expected_right_click_options==folder_right_click_options);
					*/
					Robot robot = new Robot();
					robot.keyPress(KeyEvent.VK_ESCAPE);
					robot.keyRelease(KeyEvent.VK_ESCAPE);
					Thread.sleep(2000);	
					
					WebElement elementLocator22 = getPageObject("share_first_file");
					actions.contextClick(elementLocator22).perform();
					Thread.sleep(2000);

					
					
					

					//WebElement shared_file_right_click_options = driver.findElement(By.xpath("//div[@class='files']/div/div[@class='context-list']/ul"));
					WebElement shared_file_right_click_options = driver.findElement(By.xpath("//div[@class='files']/div[@class='row'][1]/following-sibling::div/ul"));
					
					List<WebElement> each_file_li_tag=shared_file_right_click_options.findElements(By.tagName("li"));
					
					for(int i=0;i<each_file_li_tag.size();i++)
					{

						WebElement li =each_file_li_tag.get(i);

						String each_li = each_file_li_tag.get(i).getText();
						log.info("Shared folder right click options "+each_li);
						
						if(each_li.contains("Preview") || each_li.contains("Add/View Comment") || each_li.contains("Add/View Tags")  || each_li.contains("Copy / Move") || each_li.contains("Download"))
						{
							log.info("file right click option exist");
							Thread.sleep(2000);
							
						}
						else
						{
							log.info("file right click option does not exist");
							ATUReports.add("folder right click option failed","folder right click option",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							
						}
						
					}
					
					
					/*
					String share_file_expected_right_click_options = "Preview Share + Add/View Comment Add/View Tags Add to Collection Download View Versions Trash";
					String file_right_click_options = getPageObject("shared_file_edit_right_click_options").getText();
					
					
					if(share_file_expected_right_click_options==file_right_click_options);
					*/
					
						
						//if a folder shared with edit permissions within the shared folder, user should be able to create a new folder
						
						//click("shared_with_me");
					
					/*
						actions.doubleClick(getPageObject("first_folder_infolder")).perform();
						
						
						WebElement elementLocator = getPageObject("home_allfiles");
						actions.contextClick(elementLocator).perform();
						Thread.sleep(2000);
						
						click("share_page_rightclick_newfolder");
						
						

						DateFormat dateFormat = new SimpleDateFormat("MMM-dd HH-mm");

						//get current date time with Date()
						Date date = new Date();

						// Now format the date
						String dateFormatted= dateFormat.format(date);
						
						String folder_in_shared_folder="in shared fldr "+dateFormatted;
						sendKeys("folder_name_input_field",folder_in_shared_folder);
						click("folder_ok_button");
						
						
						WebDriverWait wait2228 = new WebDriverWait(driver, 60);
						wait2228.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='Vue-Toastification__toast-body']")));

						String toast_text=getPageObject("starred_toast").getText();
						
						if(toast_text=="Folder Created Successfully");
						
						log.info("Folder Created Successfully");
						
						Thread.sleep(2000);
						click("toast_close");
						log.info("Toast closed");
						*/
						
						log.info("--------------------------------------------Folders and files shared with commenter  permission right click options successfully--------------------------------------------");
						
						captureScreenShot(ScreenShotsFilePath + "folders_files_shared_with_commenter_permission_successfully.png");
						Thread.sleep(2000);
						ATUReports.add("Folders and files shared with commenter permissions successfully","Multiple files folders shared with commenter permissions successfully",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						Thread.sleep(2000);
					
					
					
				}
				
				

				catch (Exception e) {

					System.out.println("errror at: ");
					e.printStackTrace();
					log.error("Error in sharing files and folders with commenter permission",e);	
					//log.fatal(e.getMessage(),e);
					captureScreenShot(ScreenShotsFilePath + "folders_files_share_commenter_permission_failed_Error.png");
					ATUReports.add("Folders and files share with commenter permission failed","Folders and files share with commenter permission failed",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}

			}
			
			

			
			
			


			//-------------------------------------------------------multiple Files folders share with view permission-------------------------------------------------------


			public static void share_data_with_user_view_permission()
			{

				try
				{
					
					actions = new Actions(driver);
					
					
					//driver.get(Home_Page);
					
					click("profile_icon");
					
					click("sing_out");
					
					WebDriverWait wait = new WebDriverWait(driver, 60);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Login')]")));

					
					

					Navigation.login();
					WebDriverWait wait312123 = new WebDriverWait(driver, 60);
					wait312123.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[contains(text(),'Folders')]")));
					
					
			

			WebElement all_folders1 = getPageObject("folder_names");
			List<WebElement> each_folder1=all_folders1.findElements(By.tagName("div"));

			for(int i=0;i<each_folder1.size();i++)
			{


				WebElement each_div =each_folder1.get(i);
				String selected_folder_name = each_div.getText();
				//log.info("--------------------"+selected_file_folder_name);
				if(selected_folder_name.contains("Guest User Share Data"))
				{
					
					actions.doubleClick(each_folder1.get(i)).perform();
					Thread.sleep(2000);

					break;
					
					
				}
				
			}
			WebDriverWait wait3121235 = new WebDriverWait(driver, 60);
			wait3121235.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[contains(text(),'Folders')]")));
			 
			
			click("first_folder_infolder");
			//Thread.sleep(1000);
			JsClick("selected_folder_checkbox");
			String first_folder_name=getPageObject("first_folder_infolder").getText();
			log.info("first folder name--->"+first_folder_name);
			//Thread.sleep(1000);
			
			
			click("second_folder_infolder");
			//Thread.sleep(1000);
			JsClick("selected_folder_checkbox");
			String second_folder_name=getPageObject("second_folder_infolder").getText();
			log.info("second folder name--->"+second_folder_name);
			//Thread.sleep(1000);
			
			
			click("third_folder_infolder");
			//Thread.sleep(1000);
			JsClick("selected_folder_checkbox");
			String third_folder_name=getPageObject("third_folder_infolder").getText();
			log.info("third folder name--->"+third_folder_name);
			//Thread.sleep(1000);
			
		
			click("first_file_infolder");
			//Thread.sleep(1000);
			JsClick("selected_file_checkbox");
			String first_file_name=getPageObject("first_file_infolder").getText();
			log.info("third folder name--->"+first_file_name);
			//Thread.sleep(1000);
			
			
			click("second_file_infolder");
			//Thread.sleep(1000);
			JsClick("selected_file_checkbox");
			String second_file_name=getPageObject("second_file_infolder").getText();
			log.info("third folder name--->"+second_file_name);
			//Thread.sleep(1000);
			
			
			click("third_file_infolder");
			//Thread.sleep(1000);
			JsClick("selected_file_checkbox");
			String third_file_name=getPageObject("third_file_infolder").getText();
			log.info("third folder name--->"+third_file_name);
			//Thread.sleep(1000);
			
			
			
 

			WebElement elementLocator = getPageObject("first_file_infolder");
			actions.contextClick(elementLocator).perform();
			Thread.sleep(2000);
			
			WebElement external_guest_user = getPageObject("external_sharing");
			actions.moveToElement(external_guest_user).perform(); 
			
			Thread.sleep(1000);
			
			
			click("guest_user_account");
			WebDriverWait wait31 = new WebDriverWait(driver, 60);
			wait31.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Share with guest accounts')]")));
		
					/*
					click("share_user_or_group_field");
					Thread.sleep(2000);
					sendKeys("share_user_or_group_field","t");
					Thread.sleep(2000);
					
					first_folder_myfiles=//div[@class='folder']/div[@class='row']/div[1]/div/div/article/div/div[@class='media-body']
							second_folder_myfiles=//div[@class='folder']/div[@class='row']/div[2]/div/div/article/div/div[@class='media-body']
							third_folder_myfiles=//div[@class='folder']/div[@class='row']/div[3]/div/div/article/div/div[@class='media-body']
					
					*/
					
					
					
					/*
					WebElement my_element = new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='multiselect']")));

					my_element.click();
					my_element.sendKeys("t");

					
					WebDriverWait wait31 = new WebDriverWait(driver, 60);
					wait31.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='multiselect__content']/li[1]")));
					
					
					
					getPageObject("search_result_first_element").click(); 
					Thread.sleep(2000);
					*/
					
					
					
					select("shared_user_popup_dropdown","visibletext","View");
					Thread.sleep(2000);
					
					click("share_button");
					//Thread.sleep(1000);
					//click("share_button");
					
					WebDriverWait wait2229 = new WebDriverWait(driver, 60);
					wait2229.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='Vue-Toastification__toast-body']")));

					if(getPageObject("starred_toast").getText().contains("Successfully shared"));
					
					Thread.sleep(2000);
					click("toast_close");
					log.info("Toast closed");
					
					
					
					
						
					
					/*
				    ChromeOptions options = new ChromeOptions();
				    options.addArguments("incognito");
				    DesiredCapabilities cap = DesiredCapabilities.chrome();
				    cap.setCapability(ChromeOptions.CAPABILITY, options);
				    driver = new ChromeDriver(cap);
				    driver.manage().window().maximize();
				    
				    
					Robot robot = new Robot();
					robot.keyPress(KeyEvent.VK_ALT);
					robot.keyPress(KeyEvent.VK_TAB);
					robot.keyRelease(KeyEvent.VK_ALT);
					robot.keyRelease(KeyEvent.VK_TAB);
				    */
				    
				    
					/*
					 WebDriver driver = new ChromeDriver();
					 new Navigation(driver);
					 driver.manage().window().maximize();

					driver.get(Home_Page);
					*/
					click("profile_icon");
					
					click("sing_out");
					Thread.sleep(2000);
					WebDriverWait wait35 = new WebDriverWait(driver, 60);
					wait35.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));
					
					
					Navigation.external_guest_user();
					WebDriverWait wait31212351 = new WebDriverWait(driver, 60);
					wait31212351.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[contains(text(),'Folders')]")));
					
					

					click("first_folder_infolder");
					//Thread.sleep(1000);
					String share_first_folder_name=getPageObject("first_folder_infolder").getText();
					log.info("first folder name--->"+share_first_folder_name);
					//Thread.sleep(1000);
					
					
					click("second_folder_infolder");
					//Thread.sleep(1000);
					String share_second_folder_name=getPageObject("second_folder_infolder").getText();
					log.info("second folder name--->"+share_second_folder_name);
					//Thread.sleep(1000);
					
					
					click("third_folder_infolder");
					//Thread.sleep(1000);
					String share_third_folder_name=getPageObject("third_folder_infolder").getText();
					log.info("third folder name--->"+share_third_folder_name);
					//Thread.sleep(1000);
					
					String all_shared_folders=share_first_folder_name+share_second_folder_name+share_third_folder_name;
					
					
					
					
					click("share_first_file");
					//Thread.sleep(1000);
					String share_first_file_name=getPageObject("share_first_file").getText();
					log.info("first file name--->"+share_first_file_name);
					//Thread.sleep(1000);
					
					
					click("share_second_file");
					//Thread.sleep(1000);
					String share_second_file_name=getPageObject("share_second_file").getText();
					log.info("second file name--->"+share_second_file_name);
					//Thread.sleep(1000);
					
					
					click("share_third_file");
					//Thread.sleep(1000);
					String share_third_file_name=getPageObject("share_third_file").getText();
					log.info("third file name--->"+share_third_file_name);
					//Thread.sleep(1000);
					
					String all_shared_files=share_first_file_name+share_second_file_name+share_third_file_name;
					
					
					
					
					if(all_shared_folders.contains(first_folder_name))
					{
						log.info("First folder shared");
						ATUReports.add("First folder shared successfully","First folder shared successfully",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						
						
					}
					else
					{
						ATUReports.add("First folder share failed","First folder share failed",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						
					}
						
					if(all_shared_folders.contains(second_folder_name))
					{
						log.info("Second folder shared");
						ATUReports.add("Second folder shared successfully","Second folder shared successfully",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						
						
					}
					else
					{
						ATUReports.add("Second folder share failed","Second folder share failed",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						
					}
					
					if(all_shared_folders.contains(third_folder_name))
					{
						log.info("Third folder shared");
						ATUReports.add("Third folder shared successfully","Third folder shared successfully",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						
						
					}
					else
					{
						ATUReports.add("Third folder share failed","Third folder share failed",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						
					}
					
					log.info("first folder name--->"+share_first_file_name);
					log.info("first folder name--->"+all_shared_files);
								
					if(all_shared_files.contains(share_first_file_name))
					{
						log.info("First file shared");
						ATUReports.add("First file shared successfully","First file shared successfully",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						
						
					}
					else
					{
						ATUReports.add("First file share failed","First file share failed",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						
					}
					
					if(all_shared_files.contains(share_second_file_name))
					{
						log.info("Second file shared");
						ATUReports.add("Second file shared successfully","Second file shared successfully",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						
						
					}
					else
					{
						ATUReports.add("Second file share failed","Second file share failed",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						
					}
					
					if(all_shared_files.contains(share_third_file_name))
					{
						log.info("Third file shared");
						ATUReports.add("Third file shared successfully","Third file shared successfully",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						
						
					}
					else
					{
						ATUReports.add("Third file share failed","Third file share failed",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						
					}
					
					
					log.info("--------------------------------------------Folders and files shared with view permission successfully--------------------------------------------");
					
					captureScreenShot(ScreenShotsFilePath + "folders_files_shared_successfully.png");
					Thread.sleep(2000);
					ATUReports.add("Folders and files shared with view permission successfully","Multiple files folders shared with view permission successfully",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					Thread.sleep(2000);
				


				}
				
				

				catch (Exception e) {

					System.out.println("errror at: ");
					e.printStackTrace();
					log.error("Error in sharing files and folders with view permission",e);	
					//log.fatal(e.getMessage(),e);
					captureScreenShot(ScreenShotsFilePath + "folders_files_share_with_view_permission_failed_Error.png");
					ATUReports.add("Folders and files share with view permission failed","Folders and files share with view permission failed",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}

			}
			
			//-------------------------------------------------------multiple Files folders share with View permissions confirmation-------------------------------------------------------


				public static void share_data_with_user_view_permission_confirmation()
				{

					try
					{
						
						
						
						actions = new Actions(driver);
						
						

						
						WebElement elementLocator1 = driver.findElement(By.xpath("//div[@class='folder']/div[@class='row'][1]/div[1]/div"));
						
						
						//WebElement elementLocator1 = getPageObject("first_folder_infolder");
						actions.contextClick(elementLocator1).perform();
						
						
					
						Thread.sleep(2000);
						
						
						
						//WebElement shared_folder_right_click_options = driver.findElement(By.xpath("//div[@class='folder']/div/div[@class='context-list']/ul"));
						WebElement shared_folder_right_click_options = driver.findElement(By.xpath("//div[@class='folder']/div[@class='row'][1]/following-sibling::div/ul"));
						List<WebElement> each_folder_li_tag=shared_folder_right_click_options.findElements(By.tagName("li"));

						for(int i=0;i<each_folder_li_tag.size();i++)
						{

							WebElement li =each_folder_li_tag.get(i);

							String each_li = each_folder_li_tag.get(i).getText();
							log.info("Shared folder right click options "+each_li);
							
							if(each_li.contains("Add/View Comment") || each_li.contains("Copy / Move")  || each_li.contains("Download") || each_li.contains("Export Metadata"))
							{
								log.info("folder right click option exist");
								Thread.sleep(2000);
								
							}
							else
							{
								log.info("folder right click option does not exist");
								ATUReports.add("folder right click option failed","folder right click option",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								
							}
							
						}
						
						
						/*
						String share_folder_expected_right_click_options = "Share + Add/View Comment Add/View Tags Download Trash";
						String folder_right_click_options = getPageObject("shared_folder_edit_right_click_options").getText();
						
						
						if(share_folder_expected_right_click_options==folder_right_click_options);
						*/
						
						Robot robot = new Robot();
						robot.keyPress(KeyEvent.VK_ESCAPE);
						robot.keyRelease(KeyEvent.VK_ESCAPE);
						Thread.sleep(2000);	
						
						WebElement elementLocator22 = getPageObject("share_first_file");
						actions.contextClick(elementLocator22).perform();
						Thread.sleep(2000);

						
						
						

						//WebElement shared_file_right_click_options = driver.findElement(By.xpath("//div[@class='files']/div/div[@class='context-list']/ul"));
						WebElement shared_file_right_click_options = driver.findElement(By.xpath("//div[@class='files']/div[@class='row'][1]/following-sibling::div/ul"));
						
						List<WebElement> each_file_li_tag=shared_file_right_click_options.findElements(By.tagName("li"));
						
						for(int i=0;i<each_file_li_tag.size();i++)
						{

							WebElement li =each_file_li_tag.get(i);

							String each_li = each_file_li_tag.get(i).getText();
							log.info("Shared folder right click options "+each_li);
							
							if(each_li.contains("Preview") || each_li.contains("Add/View Comment") || each_li.contains("Copy / Move")  || each_li.contains("Download"))
							{
								log.info("file right click option exist");
								Thread.sleep(2000);
								
							}
							else
							{
								log.info("file right click option does not exist");
								ATUReports.add("folder right click option failed","folder right click option",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								
							}
							
						}
						
						
						/*
						String share_file_expected_right_click_options = "Preview Share + Add/View Comment Add/View Tags Add to Collection Download View Versions Trash";
						String file_right_click_options = getPageObject("shared_file_edit_right_click_options").getText();
						
						
						if(share_file_expected_right_click_options==file_right_click_options);
						*/
						
							
							//if a folder shared with edit permissions within the shared folder, user should be able to create a new folder
							
							//click("shared_with_me");
						
						log.info("--------------------------------------------Folders and files shared with view permission right click options successfully--------------------------------------------");
						
						
								ATUReports.add("Folders and files shared with view permissions successfuly","Multiple files folders shared with view permissions successfuly",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								
							
						
						
						
					}
					
					

					catch (Exception e) {

						System.out.println("errror at: ");
						e.printStackTrace();
						log.error("Error in sharing files and folders with view permission",e);	
						//log.fatal(e.getMessage(),e);
						captureScreenShot(ScreenShotsFilePath + "folders_files_share_view_permission_failed_Error.png");
						ATUReports.add("Folders and files share with view permission failed","Folders and files share",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}

				}
				


				//-------------------------------------------------------multiple Files folders share with preview permission-------------------------------------------------------


				public static void share_data_with_user_preview_permission()
				{

					try
					{
						
						actions = new Actions(driver);
						
						click("profile_icon");
						
						click("sing_out");
						Thread.sleep(2000);
						WebDriverWait wait35123 = new WebDriverWait(driver, 60);
						wait35123.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Login')]")));
						

						Navigation.login();
			 
						WebDriverWait wait312123 = new WebDriverWait(driver, 60);
						wait312123.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[contains(text(),'Folders')]")));
						
						

			WebElement all_folders1 = getPageObject("folder_names");
			List<WebElement> each_folder1=all_folders1.findElements(By.tagName("div"));

			for(int i=0;i<each_folder1.size();i++)
			{


				WebElement each_div =each_folder1.get(i);
				String selected_folder_name = each_div.getText();
				//log.info("--------------------"+selected_file_folder_name);
				if(selected_folder_name.contains("Guest User Share Data"))
				{
					
					actions.doubleClick(each_folder1.get(i)).perform();
					Thread.sleep(2000);

					break;
					
					
				}
				
			}

			WebDriverWait wait31212311 = new WebDriverWait(driver, 60);
			wait31212311.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[contains(text(),'Folders')]")));
			 
			click("first_folder_infolder");
			//Thread.sleep(1000);
			JsClick("selected_folder_checkbox");
			String first_folder_name=getPageObject("first_folder_infolder").getText();
			log.info("first folder name--->"+first_folder_name);
			//Thread.sleep(1000);
			
			
			click("second_folder_infolder");
			//Thread.sleep(1000);
			JsClick("selected_folder_checkbox");
			String second_folder_name=getPageObject("second_folder_infolder").getText();
			log.info("second folder name--->"+second_folder_name);
			//Thread.sleep(1000);
			
			
			click("third_folder_infolder");
			//Thread.sleep(1000);
			JsClick("selected_folder_checkbox");
			String third_folder_name=getPageObject("third_folder_infolder").getText();
			log.info("third folder name--->"+third_folder_name);
			//Thread.sleep(1000);
			
		
			click("first_file_infolder");
			//Thread.sleep(1000);
			JsClick("selected_file_checkbox");
			String first_file_name=getPageObject("first_file_infolder").getText();
			log.info("third folder name--->"+first_file_name);
			//Thread.sleep(1000);
			
			
			click("second_file_infolder");
			//Thread.sleep(1000);
			JsClick("selected_file_checkbox");
			String second_file_name=getPageObject("second_file_infolder").getText();
			log.info("third folder name--->"+second_file_name);
			//Thread.sleep(1000);
			
			
			click("third_file_infolder");
			//Thread.sleep(1000);
			JsClick("selected_file_checkbox");
			String third_file_name=getPageObject("third_file_infolder").getText();
			log.info("third folder name--->"+third_file_name);
			//Thread.sleep(1000);
			
			
			
 

			WebElement elementLocator = getPageObject("first_file_infolder");
			actions.contextClick(elementLocator).perform();
			Thread.sleep(2000);
			
			WebElement external_guest_user = getPageObject("external_sharing");
			actions.moveToElement(external_guest_user).perform(); 
			
			Thread.sleep(1000);
			
			
			click("guest_user_account");
			WebDriverWait wait31 = new WebDriverWait(driver, 60);
			wait31.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Share with guest accounts')]")));
			

						
						
						
						select("shared_user_popup_dropdown","visibletext","Preview");
						Thread.sleep(2000);
						
						click("share_button");
						//Thread.sleep(1000);
						//click("share_button");
						
						WebDriverWait wait2230 = new WebDriverWait(driver, 60);
						wait2230.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='Vue-Toastification__toast-body']")));

						if(getPageObject("starred_toast").getText().contains("Successfully shared"));
						
						Thread.sleep(2000);
						click("toast_close");
						log.info("Toast closed");
						
						
						
						
						click("profile_icon");
						
						click("sing_out");
						
						WebDriverWait wait35 = new WebDriverWait(driver, 60);
						wait35.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));
						
						Navigation.external_guest_user();
						WebDriverWait wait31212312 = new WebDriverWait(driver, 60);
						wait31212312.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[contains(text(),'Folders')]")));
						 

						click("first_folder_infolder");
						//Thread.sleep(1000);
						String share_first_folder_name=getPageObject("first_folder_infolder").getText();
						log.info("first folder name--->"+share_first_folder_name);
						//Thread.sleep(1000);
						
						
						click("second_folder_infolder");
						//Thread.sleep(1000);
						String share_second_folder_name=getPageObject("second_folder_infolder").getText();
						log.info("second folder name--->"+share_second_folder_name);
						//Thread.sleep(1000);
						
						
						click("third_folder_infolder");
						//Thread.sleep(1000);
						String share_third_folder_name=getPageObject("third_folder_infolder").getText();
						log.info("third folder name--->"+share_third_folder_name);
						//Thread.sleep(1000);
						
						String all_shared_folders=share_first_folder_name+share_second_folder_name+share_third_folder_name;
						
						
						
						
						click("share_first_file");
						//Thread.sleep(1000);
						String share_first_file_name=getPageObject("share_first_file").getText();
						log.info("first file name--->"+share_first_file_name);
						//Thread.sleep(1000);
						
						
						click("share_second_file");
						//Thread.sleep(1000);
						String share_second_file_name=getPageObject("share_second_file").getText();
						log.info("second file name--->"+share_second_file_name);
						//Thread.sleep(1000);
						
						
						click("share_third_file");
						//Thread.sleep(1000);
						String share_third_file_name=getPageObject("share_third_file").getText();
						log.info("third file name--->"+share_third_file_name);
						//Thread.sleep(1000);
						
						String all_shared_files=share_first_file_name+share_second_file_name+share_third_file_name;
						
						
						
						
						if(all_shared_folders.contains(first_folder_name))
						{
							log.info("First folder shared");
							ATUReports.add("First folder shared successfully","First folder shared successfully",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							
							
						}
						else
						{
							ATUReports.add("First folder share failed","First folder share failed",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							
						}
							
						if(all_shared_folders.contains(second_folder_name))
						{
							log.info("Second folder shared");
							ATUReports.add("Second folder shared successfully","Second folder shared successfully",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							
							
						}
						else
						{
							ATUReports.add("Second folder share failed","Second folder share failed",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							
						}
						
						if(all_shared_folders.contains(third_folder_name))
						{
							log.info("Third folder shared");
							ATUReports.add("Third folder shared successfully","Third folder shared successfully",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							
							
						}
						else
						{
							ATUReports.add("Third folder share failed","Third folder share failed",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							
						}
						
						log.info("first folder name--->"+share_first_file_name);
						log.info("first folder name--->"+all_shared_files);
									
						if(all_shared_files.contains(share_first_file_name))
						{
							log.info("First file shared");
							ATUReports.add("First file shared successfully","First file shared successfully",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							
							
						}
						else
						{
							ATUReports.add("First file share failed","First file share failed",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							
						}
						
						if(all_shared_files.contains(share_second_file_name))
						{
							log.info("Second file shared");
							ATUReports.add("Second file shared successfully","Second file shared successfully",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							
							
						}
						else
						{
							ATUReports.add("Second file share failed","Second file share failed",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							
						}
						
						if(all_shared_files.contains(share_third_file_name))
						{
							log.info("Third file shared");
							ATUReports.add("Third file shared successfully","Third file shared successfully",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							
							
						}
						else
						{
							ATUReports.add("Third file share failed","Third file share failed",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							
						}
						
						
						log.info("--------------------------------------------Folders and files shared with preview permission successfully--------------------------------------------");
						
						captureScreenShot(ScreenShotsFilePath + "folders_files_shared_successfully.png");
						Thread.sleep(2000);
						ATUReports.add("Folders and files shared with preview permission successfully","Multiple files folders shared with preview permission successfully",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						Thread.sleep(2000);
					


					}
					
					

					catch (Exception e) {

						System.out.println("errror at: ");
						e.printStackTrace();
						log.error("Error in sharing files and folders with preview permission",e);	
						//log.fatal(e.getMessage(),e);
						captureScreenShot(ScreenShotsFilePath + "folders_files_share_with_preview_permission_failed_Error.png");
						ATUReports.add("Folders and files share with preview permission failed","Folders and files share with preview permission failed",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}

				}
				
				//-------------------------------------------------------multiple Files folders share with preiew permissions confirmation-------------------------------------------------------


					public static void share_data_with_user_preview_permission_confirmation()
					{

						try
						{
							
							
							
							actions = new Actions(driver);
							
							

							
							
							
							WebElement elementLocator1 = driver.findElement(By.xpath("//div[@class='folder']/div[@class='row'][1]/div[1]/div"));
							
							
							//WebElement elementLocator1 = getPageObject("first_folder_infolder");
							actions.contextClick(elementLocator1).perform();
							
							
							Thread.sleep(2000);
							
							
							
							//WebElement shared_folder_right_click_options = driver.findElement(By.xpath("//div[@class='folder']/div/div[@class='context-list']/ul"));
							WebElement shared_folder_right_click_options = driver.findElement(By.xpath("//div[@class='folder']/div[@class='row'][1]/following-sibling::div/ul"));
							List<WebElement> each_folder_li_tag=shared_folder_right_click_options.findElements(By.tagName("li"));

							for(int i=0;i<each_folder_li_tag.size();i++)
							{

								WebElement li =each_folder_li_tag.get(i);

								String each_li = each_folder_li_tag.get(i).getText();
								log.info("Shared folder right click options "+each_li);
								
								if(each_li.contains("Add/View Comment") || each_li.contains("Export Metadata"))
								{
									log.info("folder right click option exist");
									Thread.sleep(2000);
									
								}
								else
								{
									log.info("folder right click option does not exist");
									ATUReports.add("folder right click option failed","folder right click option",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									
								}
								
							}
							
							
							/*
							String share_folder_expected_right_click_options = "Share + Add/View Comment Add/View Tags Download Trash";
							String folder_right_click_options = getPageObject("shared_folder_edit_right_click_options").getText();
							
							
							if(share_folder_expected_right_click_options==folder_right_click_options);
							*/
							Robot robot = new Robot();
							robot.keyPress(KeyEvent.VK_ESCAPE);
							robot.keyRelease(KeyEvent.VK_ESCAPE);
							Thread.sleep(2000);	
							
							WebElement elementLocator22 = getPageObject("share_first_file");
							actions.contextClick(elementLocator22).perform();
							Thread.sleep(2000);

							
							
							

							//WebElement shared_file_right_click_options = driver.findElement(By.xpath("//div[@class='files']/div/div[@class='context-list']/ul"));
							WebElement shared_file_right_click_options = driver.findElement(By.xpath("//div[@class='files']/div[@class='row'][1]/following-sibling::div/ul"));
							
							List<WebElement> each_file_li_tag=shared_file_right_click_options.findElements(By.tagName("li"));
							
							for(int i=0;i<each_file_li_tag.size();i++)
							{

								WebElement li =each_file_li_tag.get(i);

								String each_li = each_file_li_tag.get(i).getText();
								log.info("Shared folder right click options "+each_li);
								
								if(each_li.contains("Preview") || each_li.contains("Add/View Comment"))
								{
									log.info("file right click option exist");
									Thread.sleep(2000);
									
								}
								else
								{
									log.info("file right click option does not exist");
									ATUReports.add("folder right click option failed","folder right click option",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									
								}
								
							}
							
							
							/*
							String share_file_expected_right_click_options = "Preview Share + Add/View Comment Add/View Tags Add to Collection Download View Versions Trash";
							String file_right_click_options = getPageObject("shared_file_edit_right_click_options").getText();
							
							
							if(share_file_expected_right_click_options==file_right_click_options);
							*/
							
								
								//if a folder shared with edit permissions within the shared folder, user should be able to create a new folder
								
							log.info("--------------------------------------------Folders and files shared with preview permission right click options successfully--------------------------------------------");
							
							
									ATUReports.add("Folders and files shared with preview permissions succesfully","Multiple files folders shared with preview permissions succesfully",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									
								
							
							
							
						}
						
						

						catch (Exception e) {

							System.out.println("errror at: ");
							e.printStackTrace();
							log.error("Error in sharing files and folders with preview permission",e);	
							//log.fatal(e.getMessage(),e);
							captureScreenShot(ScreenShotsFilePath + "folders_files_share_preview_permission_failed_Error.png");
							ATUReports.add("Folders and files share with preview permission failed","Folders and files share",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						}

					}
								


					//-------------------------------------------------------multiple Files folders share with upload permission-------------------------------------------------------


					public static void share_data_with_user_upload_permission()
					{

						try
						{
							
							actions = new Actions(driver);
							
							
							click("profile_icon");
							
							click("sing_out");
							
							WebDriverWait wait35123 = new WebDriverWait(driver, 60);
							wait35123.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Login')]")));
							
							
							Navigation.login();
							 
							WebDriverWait wait312123 = new WebDriverWait(driver, 60);
							wait312123.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[contains(text(),'Folders')]")));
							
							

							WebElement all_folders1 = getPageObject("folder_names");
							List<WebElement> each_folder1=all_folders1.findElements(By.tagName("div"));

							for(int i=0;i<each_folder1.size();i++)
							{


								WebElement each_div =each_folder1.get(i);
								String selected_folder_name = each_div.getText();
								//log.info("--------------------"+selected_file_folder_name);
								if(selected_folder_name.contains("Guest User Share Data"))
								{
									
									actions.doubleClick(each_folder1.get(i)).perform();
									Thread.sleep(2000);

									break;
									
									
								}
								
							}
							WebDriverWait wait31212313 = new WebDriverWait(driver, 60);
							wait31212313.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[contains(text(),'Folders')]")));
							 
							
							click("first_folder_infolder");
							//Thread.sleep(1000);
							JsClick("selected_folder_checkbox");
							String first_folder_name=getPageObject("first_folder_infolder").getText();
							log.info("first folder name--->"+first_folder_name);
							//Thread.sleep(1000);
							
							
							click("second_folder_infolder");
							//Thread.sleep(1000);
							JsClick("selected_folder_checkbox");
							String second_folder_name=getPageObject("second_folder_infolder").getText();
							log.info("second folder name--->"+second_folder_name);
							//Thread.sleep(1000);
							
							
							click("third_folder_infolder");
							//Thread.sleep(1000);
							JsClick("selected_folder_checkbox");
							String third_folder_name=getPageObject("third_folder_infolder").getText();
							log.info("third folder name--->"+third_folder_name);
							//Thread.sleep(1000);
							
						
							click("first_file_infolder");
							//Thread.sleep(1000);
							JsClick("selected_file_checkbox");
							String first_file_name=getPageObject("first_file_infolder").getText();
							log.info("third folder name--->"+first_file_name);
							//Thread.sleep(1000);
							
							
							click("second_file_infolder");
							//Thread.sleep(1000);
							JsClick("selected_file_checkbox");
							String second_file_name=getPageObject("second_file_infolder").getText();
							log.info("third folder name--->"+second_file_name);
							//Thread.sleep(1000);
							
							
							click("third_file_infolder");
							//Thread.sleep(1000);
							JsClick("selected_file_checkbox");
							String third_file_name=getPageObject("third_file_infolder").getText();
							log.info("third folder name--->"+third_file_name);
							//Thread.sleep(1000);
							
				 

							WebElement elementLocator = getPageObject("first_file_infolder");
							actions.contextClick(elementLocator).perform();
							Thread.sleep(2000);
							
							WebElement external_guest_user = getPageObject("external_sharing");
							actions.moveToElement(external_guest_user).perform(); 
							
							Thread.sleep(1000);
							
							
							click("guest_user_account");
							WebDriverWait wait31 = new WebDriverWait(driver, 60);
							wait31.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Share with guest accounts')]")));
							
							
							
							
							
							select("shared_user_popup_dropdown","visibletext","Upload");
							Thread.sleep(2000);
							
							click("share_button");
							//Thread.sleep(1000);
							//click("share_button");
							
							WebDriverWait wait2231 = new WebDriverWait(driver, 60);
							wait2231.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='Vue-Toastification__toast-body']")));

							if(getPageObject("starred_toast").getText().contains("Successfully shared"));
							
							Thread.sleep(2000);
							click("toast_close");
							log.info("Toast closed");
							
							
							click("profile_icon");
							
							click("sing_out");
							
							WebDriverWait wait35 = new WebDriverWait(driver, 60);
							wait35.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));
							
							
							Navigation.external_guest_user();

							WebDriverWait wait31212314 = new WebDriverWait(driver, 60);
							wait31212314.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[contains(text(),'Folders')]")));
							 
							click("first_folder_infolder");
							//Thread.sleep(1000);
							String share_first_folder_name=getPageObject("first_folder_infolder").getText();
							log.info("first folder name--->"+share_first_folder_name);
							//Thread.sleep(1000);
							
							
							click("second_folder_infolder");
							//Thread.sleep(1000);
							String share_second_folder_name=getPageObject("second_folder_infolder").getText();
							log.info("second folder name--->"+share_second_folder_name);
							//Thread.sleep(1000);
							
							
							click("third_folder_infolder");
							//Thread.sleep(1000);
							String share_third_folder_name=getPageObject("third_folder_infolder").getText();
							log.info("third folder name--->"+share_third_folder_name);
							//Thread.sleep(1000);
							
							String all_shared_folders=share_first_folder_name+share_second_folder_name+share_third_folder_name;
							
							
							
							
							click("share_first_file");
							//Thread.sleep(1000);
							String share_first_file_name=getPageObject("share_first_file").getText();
							log.info("first file name--->"+share_first_file_name);
							//Thread.sleep(1000);
							
							
							click("share_second_file");
							//Thread.sleep(1000);
							String share_second_file_name=getPageObject("share_second_file").getText();
							log.info("second file name--->"+share_second_file_name);
							//Thread.sleep(1000);
							
							
							click("share_third_file");
							//Thread.sleep(1000);
							String share_third_file_name=getPageObject("share_third_file").getText();
							log.info("third file name--->"+share_third_file_name);
							//Thread.sleep(1000);
							
							String all_shared_files=share_first_file_name+share_second_file_name+share_third_file_name;
							
							
							
							
							if(all_shared_folders.contains(first_folder_name))
							{
								log.info("First folder shared");
								ATUReports.add("First folder shared successfully","First folder shared successfully",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								
								
							}
							else
							{
								ATUReports.add("First folder share failed","First folder share failed",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								
							}
								
							if(all_shared_folders.contains(second_folder_name))
							{
								log.info("Second folder shared");
								ATUReports.add("Second folder shared successfully","Second folder shared successfully",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								
								
							}
							else
							{
								ATUReports.add("Second folder share failed","Second folder share failed",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								
							}
							
							if(all_shared_folders.contains(third_folder_name))
							{
								log.info("Third folder shared");
								ATUReports.add("Third folder shared successfully","Third folder shared successfully",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								
								
							}
							else
							{
								ATUReports.add("Third folder share failed","Third folder share failed",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								
							}
							
							log.info("first folder name--->"+share_first_file_name);
							log.info("first folder name--->"+all_shared_files);
										
							if(all_shared_files.contains(share_first_file_name))
							{
								log.info("First file shared");
								ATUReports.add("First file shared successfully","First file shared successfully",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								
								
							}
							else
							{
								ATUReports.add("First file share failed","First file share failed",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								
							}
							
							if(all_shared_files.contains(share_second_file_name))
							{
								log.info("Second file shared");
								ATUReports.add("Second file shared successfully","Second file shared successfully",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								
								
							}
							else
							{
								ATUReports.add("Second file share failed","Second file share failed",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								
							}
							
							if(all_shared_files.contains(share_third_file_name))
							{
								log.info("Third file shared");
								ATUReports.add("Third file shared successfully","Third file shared successfully",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								
								
							}
							else
							{
								ATUReports.add("Third file share failed","Third file share failed",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								
							}
							
							
							log.info("--------------------------------------------Folders and files shared with upload permission successfully--------------------------------------------");
							
							captureScreenShot(ScreenShotsFilePath + "folders_files_shared_successfully.png");
							Thread.sleep(2000);
							ATUReports.add("Folders and files shared with upload permission successfully","Multiple files folders shared with upload permission successfully",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							
						


						}
						
						

						catch (Exception e) {

							System.out.println("errror at: ");
							e.printStackTrace();
							log.error("Error in sharing files and folders with upload permission",e);	
							//log.fatal(e.getMessage(),e);
							captureScreenShot(ScreenShotsFilePath + "folders_files_share_with_upload_permission_failed_Error.png");
							ATUReports.add("Folders and files share with upload permission failed","Folders and files share with upload permission failed",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						}

					}
					
					//-------------------------------------------------------multiple Files folders share with Upload permissions confirmation-------------------------------------------------------


						public static void share_data_with_user_upload_permission_confirmation()
						{

							try
							{
								
								
								actions = new Actions(driver);
								
								

								
								
								
								WebElement elementLocator1 = driver.findElement(By.xpath("//div[@class='folder']/div[@class='row'][1]/div[1]/div"));
								
								
								//WebElement elementLocator1 = getPageObject("first_folder_infolder");
								actions.contextClick(elementLocator1).perform();
								
								
								Thread.sleep(2000);
								
								
								
								//WebElement shared_folder_right_click_options = driver.findElement(By.xpath("//div[@class='folder']/div/div[@class='context-list']/ul"));
								WebElement shared_folder_right_click_options = driver.findElement(By.xpath("//div[@class='folder']/div[@class='row'][1]/following-sibling::div/ul"));
								List<WebElement> each_folder_li_tag=shared_folder_right_click_options.findElements(By.tagName("li"));

								for(int i=0;i<each_folder_li_tag.size();i++)
								{

									WebElement li =each_folder_li_tag.get(i);

									String each_li = each_folder_li_tag.get(i).getText();
									log.info("Shared folder right click options "+each_li);
									
									if(each_li.contains("Add/View Tags") || each_li.contains("Export Metadata"))
									{
										log.info("folder right click option exist");
										Thread.sleep(2000);
										
									}
									else
									{
										log.info("folder right click option does not exist");
										ATUReports.add("folder right click option failed","folder right click option",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										
									}
									
								}
								
								
								/*
								String share_folder_expected_right_click_options = "Share + Add/View Comment Add/View Tags Download Trash";
								String folder_right_click_options = getPageObject("shared_folder_edit_right_click_options").getText();
								
								
								if(share_folder_expected_right_click_options==folder_right_click_options);
								*/
								
								Robot robot = new Robot();
								robot.keyPress(KeyEvent.VK_ESCAPE);
								robot.keyRelease(KeyEvent.VK_ESCAPE);
								Thread.sleep(2000);	
								
								WebElement elementLocator22 = getPageObject("share_first_file");
								actions.contextClick(elementLocator22).perform();
								Thread.sleep(2000);

								
								
								

								//WebElement shared_file_right_click_options = driver.findElement(By.xpath("//div[@class='files']/div/div[@class='context-list']/ul"));
								WebElement shared_file_right_click_options = driver.findElement(By.xpath("//div[@class='files']/div[@class='row'][1]/following-sibling::div/ul"));
								
								List<WebElement> each_file_li_tag=shared_file_right_click_options.findElements(By.tagName("li"));
								
								for(int i=0;i<each_file_li_tag.size();i++)
								{

									WebElement li =each_file_li_tag.get(i);

									String each_li = each_file_li_tag.get(i).getText();
									log.info("Shared folder right click options "+each_li);
									
									if(each_li.contains("Add/View Tags"))
									{
										log.info("file right click option exist");
										Thread.sleep(2000);
										
									}
									else
									{
										log.info("file right click option does not exist");
										ATUReports.add("folder right click option failed","folder right click option",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										
									}
									
								}
								
								
								/*
								String share_file_expected_right_click_options = "Preview Share + Add/View Comment Add/View Tags Add to Collection Download View Versions Trash";
								String file_right_click_options = getPageObject("shared_file_edit_right_click_options").getText();
								
								
								if(share_file_expected_right_click_options==file_right_click_options);
								*/
								
									
									//if a folder shared with edit permissions within the shared folder, user should be able to create a new folder
									
								log.info("--------------------------------------------Folders and files shared with upload permission right click options successfully--------------------------------------------");
								
								
										ATUReports.add("Folders and files shared with upload permissions succesfully","Multiple files folders shared with upload permissions succesfully",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										
									
								
								
							}
							
							

							catch (Exception e) {

								System.out.println("errror at: ");
								e.printStackTrace();
								log.error("Error in sharing files and folders with upload permission",e);	
								//log.fatal(e.getMessage(),e);
								captureScreenShot(ScreenShotsFilePath + "folders_files_share_upload_permission_failed_Error.png");
								ATUReports.add("Folders and files share with upload permission failed","Folders and files share",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							}

						}
											


						//-------------------------------------------------------multiple Files folders share with remove permission-------------------------------------------------------


						public static void share_data_with_user_remove_permission()
						{

							try
							{
								
								actions = new Actions(driver);
								
								
								
								click("profile_icon");
								
								click("sing_out");
								
								WebDriverWait wait35123 = new WebDriverWait(driver, 60);
								wait35123.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Login')]")));
								
								
								Navigation.login();
								 
								WebDriverWait wait312123 = new WebDriverWait(driver, 60);
								wait312123.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[contains(text(),'Folders')]")));
								
								

								WebElement all_folders1 = getPageObject("folder_names");
								List<WebElement> each_folder1=all_folders1.findElements(By.tagName("div"));

								for(int i=0;i<each_folder1.size();i++)
								{


									WebElement each_div =each_folder1.get(i);
									String selected_folder_name = each_div.getText();
									//log.info("--------------------"+selected_file_folder_name);
									if(selected_folder_name.contains("Guest User Share Data"))
									{
										
										actions.doubleClick(each_folder1.get(i)).perform();
										Thread.sleep(2000);

										break;
										
										
									}
									
								}
								WebDriverWait wait31212315= new WebDriverWait(driver, 60);
								wait31212315.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[contains(text(),'Folders')]")));
								 
								
								click("first_folder_infolder");
								//Thread.sleep(1000);
								JsClick("selected_folder_checkbox");
								String first_folder_name=getPageObject("first_folder_infolder").getText();
								log.info("first folder name--->"+first_folder_name);
								//Thread.sleep(1000);
								
								
								click("second_folder_infolder");
								//Thread.sleep(1000);
								JsClick("selected_folder_checkbox");
								String second_folder_name=getPageObject("second_folder_infolder").getText();
								log.info("second folder name--->"+second_folder_name);
								//Thread.sleep(1000);
								
								
								click("third_folder_infolder");
								//Thread.sleep(1000);
								JsClick("selected_folder_checkbox");
								String third_folder_name=getPageObject("third_folder_infolder").getText();
								log.info("third folder name--->"+third_folder_name);
								//Thread.sleep(1000);
								
							
								click("first_file_infolder");
								//Thread.sleep(1000);
								JsClick("selected_file_checkbox");
								String first_file_name=getPageObject("first_file_infolder").getText();
								log.info("third folder name--->"+first_file_name);
								//Thread.sleep(1000);
								
								
								click("second_file_infolder");
								//Thread.sleep(1000);
								JsClick("selected_file_checkbox");
								String second_file_name=getPageObject("second_file_infolder").getText();
								log.info("third folder name--->"+second_file_name);
								//Thread.sleep(1000);
								
								
								click("third_file_infolder");
								//Thread.sleep(1000);
								JsClick("selected_file_checkbox");
								String third_file_name=getPageObject("third_file_infolder").getText();
								log.info("third folder name--->"+third_file_name);
								//Thread.sleep(1000);
								
					 

								WebElement elementLocator = getPageObject("first_file_infolder");
								actions.contextClick(elementLocator).perform();
								Thread.sleep(2000);
								
								WebElement external_guest_user = getPageObject("external_sharing");
								actions.moveToElement(external_guest_user).perform(); 
								
								Thread.sleep(1000);
								
								
								click("guest_user_account");
								WebDriverWait wait31 = new WebDriverWait(driver, 60);
								wait31.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Share with guest accounts')]")));
								
								
								
								
								
								select("shared_user_popup_dropdown","visibletext","Remove");
								Thread.sleep(2000);
								
								click("share_button");
								//Thread.sleep(1000);
								//click("share_button");
								
								WebDriverWait wait2231 = new WebDriverWait(driver, 60);
								wait2231.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='Vue-Toastification__toast-body']")));

								if(getPageObject("starred_toast").getText().contains("Successfully shared"));
								
								Thread.sleep(2000);
								click("toast_close");
								log.info("Toast closed");
								
								
								
								
									
								
								
								click("profile_icon");
								
								click("sing_out");
								Thread.sleep(2000);
								
								WebDriverWait wait35 = new WebDriverWait(driver, 60);
								wait35.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));
								
								
								Navigation.external_guest_user();
								
								WebDriverWait wait351113 = new WebDriverWait(driver, 60);
								wait351113.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'No content to show')]")));
								
								if(getPageObject("remove_share_no_content_text").isDisplayed())
								{
									log.info("--------------------------------------------Folders and files share removed successfully--------------------------------------------");
									
									captureScreenShot(ScreenShotsFilePath + "folders_files_shared_removed_successfully.png");
									Thread.sleep(2000);
									ATUReports.add("Folders and files share removed successfully","Multiple files folders share removed successfully",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									
									
								}
								
								
								
								
							


							}
							
							

							catch (Exception e) {

								System.out.println("errror at: ");
								e.printStackTrace();
								log.error("Error in sharing files and folders share remove",e);	
								//log.fatal(e.getMessage(),e);
								captureScreenShot(ScreenShotsFilePath + "folders_files_share_remove_failed_Error.png");
								ATUReports.add("Share remove failed","Share remove failed",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								}

						}
						
									
					
					

	public static void captureScreenShot(String filePath) {
		File scrFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File(filePath));
			log.info("Generating Screenshot at : " + filePath);
		} catch (IOException e) {

			log.info("Generating error in captureScreenshot method");
			e.printStackTrace();

		}
	}





}
