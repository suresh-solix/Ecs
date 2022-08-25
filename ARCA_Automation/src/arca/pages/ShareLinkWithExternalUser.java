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
import java.util.Set;

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



public class ShareLinkWithExternalUser extends Navigation {

	static WebDriver driver;
	static Actions actions;

	private static Logger log = Logger.getLogger(ShareLinkWithExternalUser.class.getName());
	public static String Home_Page = "https://app.solixecsdev.com/login";
	public ShareLinkWithExternalUser(WebDriver driver) {
		super(driver);
		this.driver = driver;
		//driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS).pageLoadTimeout(60, TimeUnit.SECONDS);
		ATUReports.setWebDriver(driver);
		ATUReports.setTestCaseReqCoverage("Share");
		setIndexPageDescription();
		setAuthorInfoForReports();
		log.info("--------------------Share--------------------");
		captureScreenShot(ScreenShotsFilePath + "Share.png");
	}

	private void setAuthorInfoForReports() {
		ATUReports.setAuthorInfo("Mahesh", Utils.getCurrentTime(),"2.0");
	}

	private void setIndexPageDescription() {
		ATUReports.indexPageDescription = "Share";
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


	

	//-------------------------------------------------------Folder link internal sharing(Share +) with edit permission-------------------------------------------------------


	public static void share_folder_link_with_external_user()
	{

		try
		{
			
			actions = new Actions(driver);
			
			
			driver.get(Home_Page);
			 
			WebDriverWait wait3121238 = new WebDriverWait(driver, 60);
			wait3121238.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='nav-item b-nav-dropdown dropdown avatar ']")));
			
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
				if(selected_folder_name.contains("Share data with link"))
				{
					
					actions.doubleClick(each_folder1.get(i)).perform();
					Thread.sleep(2000);

					break;
					
					
				}
				
			}

			
			click("first_folder_infolder");
			//Thread.sleep(1000);
			String first_folder_name=getPageObject("first_folder_infolder").getText();
			log.info("first folder name--->"+first_folder_name);
			//Thread.sleep(1000);
			
			click("second_folder_infolder");
			//Thread.sleep(1000);
			//JsClick("selected_folder_checkbox");
			String second_folder_name=getPageObject("second_folder_infolder").getText();
			log.info("second folder name--->"+second_folder_name);
			//Thread.sleep(1000);
			
			
			click("third_folder_infolder");
			//Thread.sleep(1000);
			//JsClick("selected_folder_checkbox");
			String third_folder_name=getPageObject("third_folder_infolder").getText();
			log.info("third folder name--->"+third_folder_name);
			//Thread.sleep(1000);
		
			
			

			click("first_file_infolder");
			//Thread.sleep(1000);
			//JsClick("selected_file_checkbox");
			String first_file_name=getPageObject("first_file_infolder").getText();
			log.info("third folder name--->"+first_file_name);
			//Thread.sleep(1000);
			
			
			click("second_file_infolder");
			//Thread.sleep(1000);
			//JsClick("selected_file_checkbox");
			String second_file_name=getPageObject("second_file_infolder").getText();
			log.info("third folder name--->"+second_file_name);
			//Thread.sleep(1000);
			
			
			click("third_file_infolder");
			//Thread.sleep(1000);
			//JsClick("selected_file_checkbox");
			String third_file_name=getPageObject("third_file_infolder").getText();
			log.info("third folder name--->"+third_file_name);
			//Thread.sleep(1000);
			


			click("myfiles_breadcrumb");
			


			WebDriverWait wait3122 = new WebDriverWait(driver, 60);
			wait3122.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[contains(text(),'Folders')]")));
			Thread.sleep(2000);
			
			WebElement all_folders11 = getPageObject("folder_names");
			List<WebElement> each_folder11=all_folders11.findElements(By.tagName("div"));

			for(int i=0;i<each_folder11.size();i++)
			{


				WebElement each_div =each_folder11.get(i);
				String selected_folder_name = each_div.getText();
				//log.info("--------------------"+selected_file_folder_name);
				if(selected_folder_name.contains("Share data with link"))
				{
					
					actions.contextClick(each_folder11.get(i)).perform();
					Thread.sleep(2000);
					WebElement hoverTo = getPageObject("external_share_text");     
					System.out.println("after hoverTo");
					actions.moveToElement(hoverTo).build().perform();
					Thread.sleep(2000);
					
					click("external_link_sharing");
					Thread.sleep(2000);

					break;
					
					
				}
				
			}
			
			WebDriverWait wait31222 = new WebDriverWait(driver, 60);
			wait31222.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Create external sharing link')]")));

			DateFormat dateFormat = new SimpleDateFormat("MMM-dd HH-mm");

			//get current date time with Date()
			Date date = new Date();

			// Now format the date
			String dateFormatted= dateFormat.format(date);
			
			String external_link_share_name="External link share "+dateFormatted;
			
			String external_link_share_password="Test@123";

			sendKeys("external_link_sharing_name",external_link_share_name);
			sendKeys("external_link_sharing_password",external_link_share_password);
			sendKeys("external_link_sharing_reenter_password",external_link_share_password);
			
			Thread.sleep(2000);
			
			click("external_link_sharing_generate_link");
			
			
			
			WebDriverWait wait3 = new WebDriverWait(driver, 60);
			wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='Vue-Toastification__container bottom-left']")));
			
			
			
			if(getPageObject("starred_toast").getText().equals("Share link generated successfully"));
			Thread.sleep(2000);
			click("toast_close");
			
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement Element = getPageObjectByCssSelector("last_shared_link");
			js.executeScript("arguments[0].scrollIntoView();", Element);
			
			String copied_link_text = getPageObjectByCssSelector("last_shared_link").getAttribute("href").toString();
			log.info("Copied link is new-----------------: "+copied_link_text);
			
			
			
			Thread.sleep(1000);
			click("toast_close");
			
			WebDriverWait wait3233 = new WebDriverWait(driver, 60);
			wait3233.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='b-avatar badge-light rounded-circle']")));

			
			click("profile_icon");
			Thread.sleep(1000);
			click("sing_out");
			Thread.sleep(2000);
			WebDriverWait wait323 = new WebDriverWait(driver, 60);
			wait323.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='username']")));

			
			
			
			driver.navigate().to(copied_link_text);
			WebDriverWait wait32311 = new WebDriverWait(driver, 60);
			wait32311.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
			//driver.findElement(By.name("password")).sendKeys(external_link_share_password);
			getPageObjectByName("share_link_password_field").sendKeys(external_link_share_password);
			click("folder_ok_button");
			
			WebDriverWait wait311 = new WebDriverWait(driver, 60);
			wait311.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='folder']")));
			Thread.sleep(2000);
			
			String shared_url_breadcrumb_text=getPageObject("share_url_breadcrumb").getText();
			log.info("Share breadcrumb text is: "+shared_url_breadcrumb_text);
			String selected_folder_name_is= "Share data with link";
			
			if(shared_url_breadcrumb_text.equals(selected_folder_name_is))
			{
				log.info("Breadcrumb is matching with folder name");
				ATUReports.add("Folder shared with link successfully","Folder shared with link successfully",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				
				
			}
			else
			{
				ATUReports.add("Folder share with link failed","Folder share with link failed",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				
			}
			
			
			
			
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
			
			//String all_shared_folders=share_first_folder_name+share_second_folder_name+share_third_folder_name;
			
			
			
			
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
			
			

			if(share_first_folder_name.equals(first_folder_name))
			{
				log.info("First folder shared");
				ATUReports.add("First folder shared successfully","First folder shared successfully",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				
				
			}
			else
			{
				ATUReports.add("First folder share failed","First folder share failed",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				
			}
				
			if(share_second_folder_name.equals(second_folder_name))
			{
				log.info("Second folder shared");
				ATUReports.add("Second folder shared successfully","Second folder shared successfully",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				
				
			}
			else
			{
				ATUReports.add("Second folder share failed","Second folder share failed",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				
			}
			
			if(share_third_folder_name.equals(third_folder_name))
			{
				log.info("Third folder shared");
				ATUReports.add("Third folder shared successfully","Third folder shared successfully",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				
				
			}
			else
			{
				ATUReports.add("Third folder share failed","Third folder share failed",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				
			}
			
			//log.info("first folder name--->"+share_first_file_name);
			//log.info("first folder name--->"+all_shared_files);
						
			if(first_file_name.equals(share_first_file_name))
			{
				log.info("First file shared");
				ATUReports.add("First file shared successfully","First file shared successfully",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				
				
			}
			else
			{
				ATUReports.add("First file share failed","First file share failed",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				
			}
			
			if(second_file_name.equals(share_second_file_name))
			{
				log.info("Second file shared");
				ATUReports.add("Second file shared successfully","Second file shared successfully",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				
				
			}
			else
			{
				ATUReports.add("Second file share failed","Second file share failed",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				
			}
			
			if(third_file_name.equals(share_third_file_name))
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
	
	//------------------------------------------------------- folder share with edit permissions confirmation-------------------------------------------------------


	public static void shared_existing_link_edit()
	{

		try
		{
			actions = new Actions(driver);
			
			Navigation.login();
			
			

			WebDriverWait wait3122 = new WebDriverWait(driver, 60);
			wait3122.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[contains(text(),'Folders')]")));
			Thread.sleep(2000);
			
			WebElement all_folders11 = getPageObject("folder_names");
			List<WebElement> each_folder11=all_folders11.findElements(By.tagName("div"));

			for(int i=0;i<each_folder11.size();i++)
			{


				WebElement each_div =each_folder11.get(i);
				String selected_folder_name = each_div.getText();
				//log.info("--------------------"+selected_file_folder_name);
				if(selected_folder_name.contains("Share data with link"))
				{
					
					actions.contextClick(each_folder11.get(i)).perform();
					Thread.sleep(2000);
					WebElement hoverTo = getPageObject("external_share_text");     
					System.out.println("after hoverTo");
					actions.moveToElement(hoverTo).build().perform();
					Thread.sleep(2000);
					
					click("external_link_sharing");
					Thread.sleep(2000);

					break;
					
					
				}
				
			}
			
			WebDriverWait wait31222 = new WebDriverWait(driver, 60);
			wait31222.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Create external sharing link')]")));

			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement Element = getPageObjectByCssSelector("last_shared_link");
			js.executeScript("arguments[0].scrollIntoView();", Element);
			
			
			getPageObjectByCssSelector("share_link_edit").click();
			log.info("-------Clicked on edit");
			Thread.sleep(2000);
			
			
			js.executeScript("window.scrollTo(0, Math.max(document.documentElement.scrollHeight, document.body.scrollHeight, document.documentElement.clientHeight));");
			Thread.sleep(20000);
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			WebElement Element1 = getPageObjectByCssSelector("external_link_sharing_name");
			js1.executeScript("arguments[0].scrollIntoView(true);", Element1);
			
			getPageObjectByName("external_link_edit_toggle_bar").click();
			click("tag_save_button");
			WebDriverWait wait3 = new WebDriverWait(driver, 60);
			wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='Vue-Toastification__container bottom-left']")));
			
			
			
			if(getPageObject("starred_toast").getText().equals("External share link deleted successfully"));
			Thread.sleep(1000);
			click("toast_close");
			
			
			
				
				
			
				log.info("--------------------------------------------Folders and files shared with edit permission successfully--------------------------------------------");
				
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
	
	

	//------------------------------------------------------- folder share with download permission-------------------------------------------------------


	public static void share_folder_with_download_permission()
	{

		try
		{
			actions = new Actions(driver);
			
			Navigation.login();
			
			

			WebDriverWait wait3122 = new WebDriverWait(driver, 60);
			wait3122.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[contains(text(),'Folders')]")));
			Thread.sleep(2000);
			
			WebElement all_folders11 = getPageObject("folder_names");
			List<WebElement> each_folder11=all_folders11.findElements(By.tagName("div"));

			for(int i=0;i<each_folder11.size();i++)
			{


				WebElement each_div =each_folder11.get(i);
				String selected_folder_name = each_div.getText();
				//log.info("--------------------"+selected_file_folder_name);
				if(selected_folder_name.contains("Share data with link"))
				{
					
					actions.contextClick(each_folder11.get(i)).perform();
					Thread.sleep(2000);
					WebElement hoverTo = getPageObject("external_share_text");     
					System.out.println("after hoverTo");
					actions.moveToElement(hoverTo).build().perform();
					Thread.sleep(2000);
					
					click("external_link_sharing");
					Thread.sleep(2000);

					break;
					
					
				}
				
			}
			

			WebDriverWait wait31222 = new WebDriverWait(driver, 60);
			wait31222.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Create external sharing link')]")));

			DateFormat dateFormat = new SimpleDateFormat("MMM-dd HH-mm");

			//get current date time with Date()
			Date date = new Date();

			// Now format the date
			String dateFormatted= dateFormat.format(date);
			
			String external_link_share_name="External link share download "+dateFormatted;
			
			String external_link_share_password="Test@123";
			
			
			sendKeys("external_link_sharing_name",external_link_share_name);
			sendKeys("external_link_sharing_password",external_link_share_password);
			sendKeys("external_link_sharing_reenter_password",external_link_share_password);
			click("external_link_download_enable");
			Thread.sleep(2000);
			
			click("external_link_sharing_generate_link");
			
			
			
			WebDriverWait wait3 = new WebDriverWait(driver, 60);
			wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='Vue-Toastification__container bottom-left']")));
			
			
			
			if(getPageObject("starred_toast").getText().equals("Share link generated successfully"));
			Thread.sleep(2000);
			click("toast_close");
			
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement Element = getPageObjectByCssSelector("last_shared_link");
			js.executeScript("arguments[0].scrollIntoView();", Element);
			
			String copied_link_text = getPageObjectByCssSelector("last_shared_link").getAttribute("href").toString();
			log.info("Copied link is new-----------------: "+copied_link_text);
			
			
			
			Thread.sleep(1000);
			click("toast_close");
			
			WebDriverWait wait3233 = new WebDriverWait(driver, 60);
			wait3233.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='b-avatar badge-light rounded-circle']")));

			
			click("profile_icon");
			Thread.sleep(1000);
			click("sing_out");
			Thread.sleep(2000);
			WebDriverWait wait323 = new WebDriverWait(driver, 60);
			wait323.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='username']")));

			
			
			
			driver.navigate().to(copied_link_text);
			WebDriverWait wait32311 = new WebDriverWait(driver, 60);
			wait32311.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
			//driver.findElement(By.name("password")).sendKeys(external_link_share_password);
			getPageObjectByName("share_link_password_field").sendKeys(external_link_share_password);
			click("folder_ok_button");
			
			WebDriverWait wait311 = new WebDriverWait(driver, 60);
			wait311.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='folder']")));
			Thread.sleep(2000);
			
			String shared_url_breadcrumb_text=getPageObject("share_url_breadcrumb").getText();
			log.info("Share breadcrumb text is: "+shared_url_breadcrumb_text);
			Assert.assertEquals(shared_url_breadcrumb_text, "Share data with link");
			

			WebElement elementLocator1 =  getPageObject("first_folder_infolder");
			
			
			actions.contextClick(elementLocator1).perform();
			
			Thread.sleep(1000);
			
			
			
				log.info("folder right click option has download text");
				Thread.sleep(2000);
				
				//-----Folder download confirmation
				driver.findElement(By.xpath("//div[@class='folder']/div[2][@class='context-list']/ul/li[1]")).click();
				log.info("Clicked on folder download");
				
				
				WebDriverWait wait333 = new WebDriverWait(driver, 60);
				wait333.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='Vue-Toastification__toast-body']")));
				
				
				log.info("----->Folder download toast displayed");
				
				String folder_download_toast_message = getPageObject("starred_toast").getText();
				
				log.info("----->Folder download toast text:-"+folder_download_toast_message);
				
				//if(getPageObject("starred_toast").getText().contains("Depending on the file/folder size, download might take some time."));
				Assert.assertEquals(folder_download_toast_message, "Depending on the file/folder size, download might take some time.");
				
				click("toast_close");

				//----File right click option exist confirmation
				WebElement elementLocator2 =  getPageObject("first_file_infolder");
				
				
				actions.contextClick(elementLocator2).perform();
				
				Thread.sleep(1000);
				
				
				WebElement shared_folder_right_click_options = driver.findElement(By.xpath("//div[@class='files']/div[2][@class='context-list']/ul"));
				List<WebElement> each_folder_li_tag=shared_folder_right_click_options.findElements(By.tagName("li"));

				for(int i=0;i<each_folder_li_tag.size();i++)
				{

					WebElement li =each_folder_li_tag.get(i);

					String each_li = each_folder_li_tag.get(i).getText();
					log.info("Shared file right click options "+each_li);
					
					if(each_li.equals("Preview") || each_li.equals("Download"))
					{
						log.info("File right click option exist");
						Thread.sleep(2000);
						
						
					}
					else
					{
						log.info("Shared file right click option doesn't exist");
						ATUReports.add("Shared file right click option doesn't exist","Shared file right click option doesn't exist",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						
					}
					
				}
				
				
				

				//-----File download confirmation
				driver.findElement(By.xpath("//div[@class='files']/div[2][@class='context-list']/ul/li[2]")).click();
				log.info("Clicked on file download");
				WebDriverWait wait334 = new WebDriverWait(driver, 60);
				wait334.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='Vue-Toastification__toast-body']")));
				log.info("----->File download toast displayed");
				
				String file_download_toast_message = getPageObject("starred_toast").getText();
				
				log.info("----->File download toast text:-"+file_download_toast_message);
				
				//if(getPageObject("starred_toast").getText().contains("Depending on the file/folder size, download might take some time."));
				Assert.assertEquals(file_download_toast_message, "Depending on the file/folder size, download might take some time.");
				
				click("toast_close");

				
				
				
				log.info("--------------------------------------------Folders and files shared with edit permission successfully--------------------------------------------");
				
				captureScreenShot(ScreenShotsFilePath + "folders_files_shared_with_download_permission_successfully.png");
				Thread.sleep(2000);
				ATUReports.add("Folders and files shared with download permissions successfully","Multiple files folders shared with download permissions successfully",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			
			
			
		}
		
		

		catch (Exception e) {

			System.out.println("errror at: ");
			e.printStackTrace();
			log.error("Error in sharing files and folders with download permission",e);	
			//log.fatal(e.getMessage(),e);
			captureScreenShot(ScreenShotsFilePath + "folders_files_share_download_permission_failed_Error.png");
			ATUReports.add("Folders and files share with download permission failed","Folders and files share",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}

	}



	//------------------------------------------------------- inactive folder share-------------------------------------------------------


	public static void inactive_share_folder()
	{

		try
		{
			actions = new Actions(driver);
			
			Navigation.login();
			
			

			WebDriverWait wait3122 = new WebDriverWait(driver, 60);
			wait3122.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[contains(text(),'Folders')]")));
			
			
			WebElement all_folders11 = getPageObject("folder_names");
			List<WebElement> each_folder11=all_folders11.findElements(By.tagName("div"));

			for(int i=0;i<each_folder11.size();i++)
			{


				WebElement each_div =each_folder11.get(i);
				String selected_folder_name = each_div.getText();
				//log.info("--------------------"+selected_file_folder_name);
				if(selected_folder_name.contains("Share data with link"))
				{
					
					actions.contextClick(each_folder11.get(i)).perform();
					Thread.sleep(2000);
					WebElement hoverTo = getPageObject("external_share_text");     
					System.out.println("after hoverTo");
					actions.moveToElement(hoverTo).build().perform();
					Thread.sleep(2000);
					
					click("external_link_sharing");
					Thread.sleep(2000);

					break;
					
					
				}
				
			}
			

			WebDriverWait wait31222 = new WebDriverWait(driver, 60);
			wait31222.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Create external sharing link')]")));

			DateFormat dateFormat = new SimpleDateFormat("MMM-dd HH-mm");

			//get current date time with Date()
			Date date = new Date();

			// Now format the date
			String dateFormatted= dateFormat.format(date);
			
			String external_link_share_name="External inactive link share "+dateFormatted;
			
			String external_link_share_password="Test@123";
			
			
			sendKeys("external_link_sharing_name",external_link_share_name);
			sendKeys("external_link_sharing_password",external_link_share_password);
			sendKeys("external_link_sharing_reenter_password",external_link_share_password);
			click("external_link_download_enable");
			click("last_shared_link_inactive_toggle");
			Thread.sleep(2000);
			
			click("external_link_sharing_generate_link");
			
			
			
			WebDriverWait wait3 = new WebDriverWait(driver, 60);
			wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='Vue-Toastification__container bottom-left']")));
			
			
			
			if(getPageObject("starred_toast").getText().equals("Share link generated successfully"));
			Thread.sleep(2000);
			click("toast_close");
			
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement Element = getPageObjectByCssSelector("last_shared_link");
			js.executeScript("arguments[0].scrollIntoView();", Element);
			
			String copied_link_text = getPageObjectByCssSelector("last_shared_link").getAttribute("href").toString();
			log.info("Copied link is new-----------------: "+copied_link_text);
			
			
			
			Thread.sleep(1000);
			click("toast_close");
			
			WebDriverWait wait3233 = new WebDriverWait(driver, 60);
			wait3233.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='b-avatar badge-light rounded-circle']")));

			
			click("profile_icon");
			Thread.sleep(1000);
			click("sing_out");
			Thread.sleep(2000);
			WebDriverWait wait323 = new WebDriverWait(driver, 60);
			wait323.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='username']")));

			
			
			
			driver.navigate().to(copied_link_text);
			WebDriverWait wait331 = new WebDriverWait(driver, 60);
			wait331.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='Vue-Toastification__container bottom-left']")));
			
			

			if(getPageObject("starred_toast").getText().equals("Invalid share link"));
			Thread.sleep(2000);
			click("toast_close");
			
			
				
				
				log.info("--------------------------------------------Folders and files shared with edit permission successfully--------------------------------------------");
				
				captureScreenShot(ScreenShotsFilePath + "folders_files_shared_with_download_permission_successfully.png");
				Thread.sleep(2000);
				ATUReports.add("Folders and files shared with download permissions successfully","Multiple files folders shared with download permissions successfully",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			
			
			
		}
		
		

		catch (Exception e) {

			System.out.println("errror at: ");
			e.printStackTrace();
			log.error("Error in sharing files and folders with download permission",e);	
			//log.fatal(e.getMessage(),e);
			captureScreenShot(ScreenShotsFilePath + "folders_files_share_download_permission_failed_Error.png");
			ATUReports.add("Folders and files share with download permission failed","Folders and files share",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}

	}


		
	//------------------------------------------------------- folder share link delete------------------------------------------------------

	

		public static void shared_existing_link_delete()
		{

			try
			{
				actions = new Actions(driver);
				
				JavascriptExecutor js = (JavascriptExecutor) driver;
				WebElement Element = driver.findElement(By.cssSelector(".bi-trash"));
				js.executeScript("arguments[0].scrollIntoView();", Element);
				Thread.sleep(2000);
			
				driver.findElement(By.cssSelector(".bi-trash")).click();
				WebDriverWait wait31224 = new WebDriverWait(driver, 60);
				wait31224.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'OK')]")));

				driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();
				
				WebDriverWait wait3 = new WebDriverWait(driver, 60);
				wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='Vue-Toastification__container bottom-left']")));
				
				
				
				if(getPageObject("starred_toast").getText().equals("External share link deleted successfully"));
				Thread.sleep(1000);
				click("toast_close");
				
				
				
					
					
				
					log.info("--------------------------------------------Folders and files shared with edit permission successfully--------------------------------------------");
					
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
