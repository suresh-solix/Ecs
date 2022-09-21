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
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import arca.common.Navigation;
import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.reports.utils.Utils;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;


public class MyFile_Share_User_Admin extends Navigation
{
	
	static WebDriver driver;
	static Actions actions;
  

	private static Logger log = Logger.getLogger(MyFile_Share_User_Admin.class.getName());
	public static String Home_Page = "https://app.solixecsdev.com/login";
	public MyFile_Share_User_Admin(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
	//	driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS).pageLoadTimeout(60, TimeUnit.SECONDS);
		ATUReports.setWebDriver(driver);
		ATUReports.setTestCaseReqCoverage("MyFile_Share_User_Admin");
		setIndexPageDescription();
		setAuthorInfoForReports();
		log.info("--------------------MyFile_Share_User_Admin--------------------");
		captureScreenShot(ScreenShotsFilePath + "MyFile_Share_User_Admin.png");
	}
	private void setAuthorInfoForReports()
	{
		ATUReports.setAuthorInfo("Mahesh", Utils.getCurrentTime(),"2.0");
	}

	private void setIndexPageDescription()
	{
		ATUReports.indexPageDescription = "MyFile_Share_User_Admin";
	}



//-------------------------------MyFile_Share_User_Admin_Muti_data_Edit_Permission-------------------------
	
	public static void MyFile_Share_User_Admin_Muti_data_Edit_Permission() 
	{

		try
		{

			actions = new Actions(driver);

			Navigation.other_user_in_same_tenant();
			
			driver.get(Home_Page);
			WebDriverWait wait5 = new WebDriverWait(driver, 120);
			wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
			Thread.sleep(2000);
			//Double click on element
			WebElement ele = getPageObject("Share_User_Admin"); 
			Actions act = new Actions(driver);
			act.doubleClick(ele).perform();
			
			//Double click on element
			WebElement ele1 = getPageObject("Files_And_Folders"); 
			act.doubleClick(ele1).perform();
			click("select_all_folders");
			click("select_all_files");
			WebElement right=	driver.findElement(By.xpath("//div[@class='files-info']"));
			actions.contextClick(right).perform();
			click("Share");
			Thread.sleep(2000);
			
			WebElement noUserOr = driver.findElement(By.xpath("//input[@placeholder='Search Users or Groups']"));
			noUserOr.sendKeys("v");
			
			
			WebDriverWait wait31 = new WebDriverWait(driver, 60);
			wait31.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='multiselect__content']/li[1]")));
				
			getPageObject("search_result_first_element").click(); 
			Thread.sleep(2000);
			click("share_button");
			Thread.sleep(1000);
			click("share_button");
					
			WebDriverWait wait222 = new WebDriverWait(driver, 60);
			wait222.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Shared Successfully')]")));
			Thread.sleep(2000);
			click("toast_close");
			
			Thread.sleep(5000);
			click("Profile_Icon");
			Thread.sleep(2000);
			click("Sign_out");
			Thread.sleep(1000);
			click("Ok");
			Thread.sleep(4000);
			
			WebDriverWait wait35 = new WebDriverWait(driver, 120);
			wait35.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));
			
			Navigation.login();
			Thread.sleep(2000);
			driver.get(Home_Page);
			
			WebDriverWait wait6 = new WebDriverWait(driver, 120);
			wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
			
			click("shared_with_me");
			
			List<WebElement> Aftermovedfolders =driver.findElements(By.xpath("//*[@class='folder-article']"));
			int	Aftermovedfolderstofolder = Aftermovedfolders .size();
			System.out.println("No of folders Shared" + Aftermovedfolderstofolder);

			if(Aftermovedfolderstofolder==3)
			{


			log.info("--------------------------No of Shared folders is  equal to before------------------------------");

			captureScreenShot(ScreenShotsFilePath +"MyFile_Share_User_Admin_Muti_data_Edit_Permission_success.png");
			Thread.sleep(2000);
			ATUReports.add("MyFile_Share_User_Admin_Muti_data_Edit_Permission successfully","MyFile_Share_User_Admin_Muti_data_Edit_Permission",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
			Thread.sleep(2000); 
			}
			else 
			{
				captureScreenShot(ScreenShotsFilePath + "MyFile_Share_User_Admin_Muti_data_Edit_Permission_failed.png");
				Thread.sleep(2000);
				ATUReports.add("MyFile_Share_User_Admin_Muti_data_Edit_Permission failed","MyFile_Share_User_Admin_Muti_data_Edit_Permission",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}

			
			List<WebElement> Aftermovedfiles2 = driver.findElements(By.xpath("//*[@class='files-footer']"));
			int Aftermovedfiles1 = Aftermovedfiles2.size();
			System.out.println("No of files Shared" + Aftermovedfiles1);
			if(Aftermovedfiles1==3)
			{


				log.info("--------------------------No of Shared files is  equal to before------------------------------");

				captureScreenShot(ScreenShotsFilePath + "MyFile_Share_User_Admin_Muti_data_Edit_Permission_success.png");
				Thread.sleep(2000);
				ATUReports.add("MyFile_Share_User_Admin_Muti_data_Edit_Permission successfully","MyFile_Share_User_Admin_Muti_data_Edit_Permission",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}

			else 
			{
				captureScreenShot(ScreenShotsFilePath + "MyFile_Share_User_Admin_Muti_data_Edit_Permission_failed.png");
				Thread.sleep(2000);
				ATUReports.add("MyFile_Share_User_Admin_Muti_data_Edit_Permission_Files failed","MyFile_Share_User_Admin_Muti_data_Edit_Permission",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}

			
		}
		catch (Exception e)
		{

			System.out.println("errror at: ");
			e.printStackTrace();
			log.error("Error in MyFile_Share_User_Admin_Muti_data_Edit_Permission",e);	
			//log.fatal(e.getMessage(),e);
			captureScreenShot(ScreenShotsFilePath + "MyFile_Share_User_Admin_Muti_data_Edit_Permission_failed_Error.png");
			ATUReports.add("MyFile_Share_User_Admin_Muti_data_Edit_Permission failed","MyFile_Share_User_Admin_Muti_data_Edit_Permission",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}

	}

	//-------------------------------------------------------MyFile_Share_User_Admin_Muti_data_Edit_Permission_confirmation-------------------------------------------------------


	public static void MyFile_Share_User_Admin_Muti_data_Edit_Permission_confirmation()
	{

		try
		{
			click("first_folder_infolder");
			WebElement elementLocator2 = getPageObject("first_folder_infolder");
			actions.doubleClick(elementLocator2).perform();

			WebDriverWait wait312 = new WebDriverWait(driver, 60);
			wait312.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[contains(text(),'Folders')]")));
			Thread.sleep(2000);

			WebElement elementLocator1 = getPageObject("first_folder_infolder");
			actions.contextClick(elementLocator1).perform();

			Thread.sleep(2000);

			WebElement shared_folder_right_click_options = driver.findElement(By.xpath("//div[@class='folder']/div[@class='row'][1]/following-sibling::div/ul"));
			List<WebElement> each_folder_li_tag=shared_folder_right_click_options.findElements(By.tagName("li"));

			for(int i=0;i<each_folder_li_tag.size();i++)
			{

				WebElement li =each_folder_li_tag.get(i);

				String each_li = each_folder_li_tag.get(i).getText();
				log.info("Shared folder right click options "+each_li);

				if(each_li.contains("Share +") || each_li.contains("Add/View Comment") || each_li.contains("Add/View Tags") || each_li.contains("External Sharing") || each_li.contains("Copy / Move") || each_li.contains("Download") || each_li.contains("Add Reminders") || each_li.contains("Rename") || each_li.contains("Export Metadata") || each_li.contains("Trash"))
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


			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ESCAPE);
			robot.keyRelease(KeyEvent.VK_ESCAPE);
			Thread.sleep(2000);	

			//			click("share_breadcrumb");

			WebDriverWait wait3122 = new WebDriverWait(driver, 60);
			wait3122.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[contains(text(),'Folders')]")));

			WebElement elementLocator9 = getPageObject("share_first_file");
			actions.contextClick(elementLocator9).perform();
			Thread.sleep(2000);


			WebElement shared_file_right_click_options1 = driver.findElement(By.xpath("//div[@class='files']/div[2][@class='context-list']/ul"));
			List<WebElement> each_file_li_tag1=shared_file_right_click_options1.findElements(By.tagName("li"));

			for(int i=0;i<each_file_li_tag1.size();i++)
			{

				WebElement li =each_file_li_tag1.get(i);
				String each_li = each_file_li_tag1.get(i).getText();
				log.info("Shared file right click options "+each_li);

				if( each_li.contains("Preview") || each_li.contains("Share +") || each_li.contains("Add/View Comment") || each_li.contains("Add/View Tags") || each_li.contains("Add to Collection") || each_li.contains("External Sharing") || each_li.contains("Copy / Move") || each_li.contains("Download") || each_li.contains("Add Reminders") || each_li.contains("Rename") || each_li.contains("View Versions") || each_li.contains("Trash"))
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
			{

				log.info("--------------------------------------------Folders and files shared with edit permission successfully--------------------------------------------");

				captureScreenShot(ScreenShotsFilePath + "folders_files_shared_with_edit_permission_successfully.png");
				Thread.sleep(2000);
				ATUReports.add("Folders and files shared with edit permissions successfully","Multiple files folders shared with edit permissions successfully",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}
			Thread.sleep(1000);
			click("Profile_Icon");
			Thread.sleep(2000);
			click("Sign_out");
			Thread.sleep(1000);
			click("Ok");
			Thread.sleep(4000);
			
			WebDriverWait wait35 = new WebDriverWait(driver, 120);
			wait35.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));
			

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
			



	//---------------------------------MyFile_Share_User_Admin_Muti__commenter_permission------------------
	
	public static void MyFile_Share_User_Admin_Muti__commenter_permission() 
	{

		try
		{

			actions = new Actions(driver);

			Navigation.other_user_in_same_tenant();

			driver.get(Home_Page);
			WebDriverWait wait5 = new WebDriverWait(driver, 120);
			wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
			//Double click on element
			WebElement ele = getPageObject("Share_User_Admin"); 
			Actions act = new Actions(driver);
			act.doubleClick(ele).perform();
			//Double click on element

			WebElement ele11 = getPageObject("Files_And_Folders"); 
			act.doubleClick(ele11).perform();
			click("select_all_folders");
			click("select_all_files");
			WebElement right=	driver.findElement(By.xpath("//div[@class='files-info']"));
			actions.contextClick(right).perform();
			click("Share");
			Thread.sleep(2000);
//			WebElement ela =driver.findElement(By.xpath("(//select[@class='custom-select form-control custom-select'])[2]"));
//			Select DD = new Select(ela);
//			DD.selectByVisibleText("View");

			select("shared_user_popup_dropdown","visibletext","Commenter");
			Thread.sleep(2000);

			click("share_button");
			Thread.sleep(2000);
			WebDriverWait wait222 = new WebDriverWait(driver, 60);
			wait222.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Shared Successfully')]")));
			Thread.sleep(2000);
			click("toast_close");

			Thread.sleep(3000);
			click("Profile_Icon");
			Thread.sleep(1000);
			click("Sign_out");
			click("Ok");
	//		Thread.sleep(4000);
			WebDriverWait wait35 = new WebDriverWait(driver, 120);
			wait35.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));

			Navigation.login();

			driver.get(Home_Page);

			WebDriverWait wait6 = new WebDriverWait(driver, 120);
			wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));

			click("shared_with_me");
			
			List<WebElement> Aftermovedfolders =driver.findElements(By.xpath("//*[@class='folder-article']"));
			int	Aftermovedfolderstofolder = Aftermovedfolders .size();
			System.out.println("No of folders Shared" + Aftermovedfolderstofolder);
			
			if(Aftermovedfolderstofolder==3)
			{


			log.info("--------------------------No of Shared folders is  equal to before------------------------------");

			captureScreenShot(ScreenShotsFilePath +"MyFile_Share_User_Admin_Muti__commenter_permission_success.png");
			Thread.sleep(2000);
			ATUReports.add("MyFile_Share_User_Admin_Muti__commenter_permission successfully","MyFile_Share_User_Admin_Muti__commenter_permission",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
			Thread.sleep(2000); 
			}
			else 
			{
				captureScreenShot(ScreenShotsFilePath + "MyFile_Share_User_Admin_Muti__commenter_permission_failed.png");
				Thread.sleep(2000);
				ATUReports.add("MyFile_Share_User_Admin_Muti__commenter_permission failed","MyFile_Share_User_Admin_Muti__commenter_permission",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}

			
			List<WebElement> Aftermovedfiles2 = driver.findElements(By.xpath("//*[@class='files-footer']"));
			int Aftermovedfiles1 = Aftermovedfiles2.size();
			System.out.println("No of files Shared" + Aftermovedfiles1);
			if(Aftermovedfiles1==3)
			{


				log.info("--------------------------No of Shared files is  equal to before------------------------------");

				captureScreenShot(ScreenShotsFilePath + "MyFile_Share_User_Admin_Muti__commenter_permission_success.png");
				Thread.sleep(2000);
				ATUReports.add("MyFile_Share_User_Admin_Muti__commenter_permission successfully","MyFile_Share_User_Admin_Muti__commenter_permission",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}

			else 
			{
				captureScreenShot(ScreenShotsFilePath + "MyFile_Share_User_Admin_Muti__commenter_permission_failed.png");
				Thread.sleep(2000);
				ATUReports.add("MyFile_Share_User_Admin_Muti__commenter_permission failed","MyFile_Share_User_Admin_Muti__commenter_permission",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}
	}
		catch (Exception e)
		{

			System.out.println("errror at: ");
			e.printStackTrace();
			log.error("Error in MyFile_Share_User_Admin_Muti__commenter_permission",e);	
			//log.fatal(e.getMessage(),e);
			captureScreenShot(ScreenShotsFilePath + "MyFile_Share_User_Admin_Muti__commenter_permission_failed_Error.png");
			ATUReports.add("MyFile_Share_User_Admin_Muti__commenter_permission failed","MyFile_Share_User_Admin_Muti__commenter_permission",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}
	}

	//---------------------------------MyFile_Share_User_Admin_Muti__commenter_permission_Confirmation------------------
	
	public static void MyFile_Share_User_Admin_Muti__commenter_permission_Confirmation()
	{

		try
		{
			actions = new Actions(driver);

			WebElement elementLocator2 = getPageObject("first_folder_infolder");
			actions.doubleClick(elementLocator2).perform();

			WebDriverWait wait312 = new WebDriverWait(driver, 60);
			wait312.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[contains(text(),'Folders')]")));
			Thread.sleep(2000);

			WebElement elementLocator1 = getPageObject("first_folder_infolder");
			actions.contextClick(elementLocator1).perform();



			WebDriverWait wait3133 = new WebDriverWait(driver, 60);
			wait3133.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Add/View Comment')]")));
			Thread.sleep(2000);



			WebElement shared_folder_right_click_options = driver.findElement(By.xpath("//div[@class='folder']/div[2][@class='context-list']/ul"));
			List<WebElement> each_folder_li_tag=shared_folder_right_click_options.findElements(By.tagName("li"));

			for(int i=0;i<each_folder_li_tag.size();i++)
			{

				WebElement li =each_folder_li_tag.get(i);

				String each_li = each_folder_li_tag.get(i).getText();
				log.info("Shared folder right click options "+each_li);

				if(each_li.contains("Add/View Comment") || each_li.contains("Add/View Tags") || each_li.contains("Copy / Move") || each_li.contains("Download")  || each_li.contains("Export Metadata"))
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

			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ESCAPE);
			robot.keyRelease(KeyEvent.VK_ESCAPE);
			Thread.sleep(2000);	

			WebElement elementLocator22 = getPageObject("share_first_file");
			actions.contextClick(elementLocator22).perform();
			Thread.sleep(2000);


			WebElement shared_file_right_click_options = driver.findElement(By.xpath("//div[@class='files']/div[@class='row'][1]/following-sibling::div/ul"));
			List<WebElement> each_file_li_tag=shared_file_right_click_options.findElements(By.tagName("li"));

			for(int i=0;i<each_file_li_tag.size();i++)
			{

				WebElement li =each_file_li_tag.get(i);

				String each_li = each_file_li_tag.get(i).getText();
				log.info("Shared folder right click options "+each_li);

				if( each_li.contains("Preview") || each_li.contains("Add/View Comment") || each_li.contains("Add/View Tags")  || each_li.contains("Copy / Move") || each_li.contains("Add to Collection") || each_li.contains("Download"))
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

			{
			log.info("--------------------------------------------Folders and files shared with commenter permission successfully--------------------------------------------");

			captureScreenShot(ScreenShotsFilePath + "folders_files_shared_with_commenter_permission_successfully.png");
			Thread.sleep(2000);
			ATUReports.add("Folders and files shared with commenter permissions successfully","Multiple files folders shared with commenter permissions successfully",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(2000);
	    	}
			Thread.sleep(1000);
			click("Profile_Icon");
			Thread.sleep(2000);
			click("Sign_out");
			Thread.sleep(1000);
			click("Ok");
	//		Thread.sleep(4000);
			WebDriverWait wait35 = new WebDriverWait(driver, 120);
			wait35.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));

			
			
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

	
    //--------------------------------MyFile_Share_User_Admin_Muti__View_permission-------------------------------------


	public static void MyFile_Share_User_Admin_Muti__View_permission() 
	{

		try
		{

			actions = new Actions(driver);

			Navigation.other_user_in_same_tenant();

			driver.get(Home_Page);
			WebDriverWait wait5 = new WebDriverWait(driver, 120);
			wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
			//Double click on element
			WebElement ele = getPageObject("Share_User_Admin"); 
			Actions act = new Actions(driver);
			act.doubleClick(ele).perform();
			//Double click on element

			WebElement ele11 = getPageObject("Files_And_Folders"); 
			act.doubleClick(ele11).perform();
			click("select_all_folders");
			click("select_all_files");
			WebElement right=	driver.findElement(By.xpath("//div[@class='files-info']"));
			actions.contextClick(right).perform();
			click("Share");

			WebElement ela =driver.findElement(By.xpath("(//select[@class='custom-select form-control custom-select'])[2]"));
			Select DD = new Select(ela);
			DD.selectByVisibleText("View");

			Thread.sleep(2000);
			click("share_button");
			//		Thread.sleep(1000);
			//		click("share_button");

			WebDriverWait wait222 = new WebDriverWait(driver, 60);
			wait222.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Shared Successfully')]")));
			Thread.sleep(2000);
			click("toast_close");

			Thread.sleep(2000);
			click("Profile_Icon");
			click("Sign_out");
			click("Ok");
			WebDriverWait wait35 = new WebDriverWait(driver, 120);
			wait35.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));

			Navigation.login();

			driver.get(Home_Page);

			WebDriverWait wait6 = new WebDriverWait(driver, 120);
			wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));

			click("shared_with_me");

			List<WebElement> Aftermovedfolders =driver.findElements(By.xpath("//*[@class='folder-article']"));
			int	Aftermovedfolderstofolder = Aftermovedfolders .size();
			System.out.println("No of folders Shared" + Aftermovedfolderstofolder);

			if(Aftermovedfolderstofolder==3)
			{


				log.info("--------------------------No of Shared folders is  equal to before------------------------------");

				captureScreenShot(ScreenShotsFilePath +"MyFile_Share_User_Admin_Muti__View_permission_success.png");
				Thread.sleep(2000);
				ATUReports.add("MyFile_Share_User_Admin_Muti__View_permission successfully","MyFile_Share_User_Admin_Muti__View_permission",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
				Thread.sleep(2000); 
			}
			else 
			{
				captureScreenShot(ScreenShotsFilePath + "MyFile_Share_User_Admin_Muti__View_permission_failed.png");
				Thread.sleep(2000);
				ATUReports.add("MyFile_Share_User_Admin_Muti__View_permission failed","MyFile_Share_User_Admin_Muti__View_permission",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}


			List<WebElement> Aftermovedfiles2 = driver.findElements(By.xpath("//*[@class='files-footer']"));
			int Aftermovedfiles1 = Aftermovedfiles2.size();
			System.out.println("No of files Shared" + Aftermovedfiles1);
			if(Aftermovedfiles1==3)
			{


				log.info("--------------------------No of Shared files is  equal to before------------------------------");

				captureScreenShot(ScreenShotsFilePath + "MyFile_Share_User_Admin_Muti__View_permission_success.png");
				Thread.sleep(2000);
				ATUReports.add("MyFile_Share_User_Admin_Muti__View_permission successfully","MyFile_Share_User_Admin_Muti__View_permission",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}

			else 
			{
				captureScreenShot(ScreenShotsFilePath + "MyFile_Share_User_Admin_Muti__View_permission_failed.png");
				Thread.sleep(2000);
				ATUReports.add("MyFile_Share_User_Admin_Muti_View_permission failed","MyFile_Share_User_Admin_Muti_View_permission",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}



		}
		catch (Exception e)
		{

			System.out.println("errror at: ");
			e.printStackTrace();
			log.error("Error in MyFile_Share_User_Admin_Muti__View_permission",e);	
			//log.fatal(e.getMessage(),e);
			captureScreenShot(ScreenShotsFilePath + "MyFile_Share_User_Admin_Muti__View_permission_failed_Error.png");
			ATUReports.add("MyFile_Share_User_Admin_Muti__View_permission failed","MyFile_Share_User_Admin_Muti__View_permission",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}
	}

	//-------------------------MyFile_Share_User_Admin_Muti__View_permission_Confirmation-----------------------

	public static void MyFile_Share_User_Admin_Muti__View_permission_Confirmation()
	{

		try
		{
			actions = new Actions(driver);


			WebElement elementLocator2 = getPageObject("first_folder_infolder");
			actions.doubleClick(elementLocator2).perform();

			WebDriverWait wait312 = new WebDriverWait(driver, 60);
			wait312.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[contains(text(),'Folders')]")));
			Thread.sleep(2000);

			WebElement elementLocator1 = getPageObject("first_folder_infolder");
			actions.contextClick(elementLocator1).perform();



			WebDriverWait wait3133 = new WebDriverWait(driver, 60);
			wait3133.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Add/View Comment')]")));
			Thread.sleep(2000);



			WebElement shared_folder_right_click_options = driver.findElement(By.xpath("//div[@class='folder']/div[2][@class='context-list']/ul"));
			List<WebElement> each_folder_li_tag=shared_folder_right_click_options.findElements(By.tagName("li"));

			for(int i=0;i<each_folder_li_tag.size();i++)
			{

				WebElement li =each_folder_li_tag.get(i);

				String each_li = each_folder_li_tag.get(i).getText();
				log.info("Shared folder right click options "+each_li);

				if(each_li.contains("Add/View Comment") || each_li.contains("Copy") || each_li.contains("Download") || each_li.contains("Export Metadata") )
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

			Robot robot1 = new Robot();
			robot1.keyPress(KeyEvent.VK_ESCAPE);
			robot1.keyRelease(KeyEvent.VK_ESCAPE);
			Thread.sleep(2000);	

			WebElement elementLocator22 = getPageObject("share_first_file");
			actions.contextClick(elementLocator22).perform();
			Thread.sleep(2000);


			WebElement shared_file_right_click_options = driver.findElement(By.xpath("//div[@class='files']/div[@class='row'][1]/following-sibling::div/ul"));
			List<WebElement> each_file_li_tag=shared_file_right_click_options.findElements(By.tagName("li"));

			for(int i=0;i<each_file_li_tag.size();i++)
			{

				WebElement li =each_file_li_tag.get(i);

				String each_li = each_file_li_tag.get(i).getText();
				log.info("Shared folder right click options "+each_li);

				if(each_li.contains("Preview") || each_li.contains("Add/View Comment") || each_li.contains("Copy") || each_li.contains("Add to Collection") || each_li.contains("Download"))
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

			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ESCAPE);
			robot.keyRelease(KeyEvent.VK_ESCAPE);
			Thread.sleep(2000);	

			log.info("-------------Plus button display Assert execution started------------------");


			Boolean checkPlusButtonPresence = getPageObject("share_first_file").isDisplayed();

			Assert.assertTrue(checkPlusButtonPresence);
			log.info("-------------Plus button display Assert execution ended------------------");

			{

				log.info("--------------------------------------------Folders and files shared with view permission successfully--------------------------------------------");

				captureScreenShot(ScreenShotsFilePath + "folders_files_shared_with_view_permission_successfully.png");
				Thread.sleep(2000);
				ATUReports.add("Folders and files shared with view permissions successfully","Multiple files folders shared with view permissions successfully",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}
			Thread.sleep(1000);
			click("Profile_Icon");
			Thread.sleep(2000);
			click("Sign_out");
			Thread.sleep(1000);
			click("Ok");
			Thread.sleep(4000);
			
			WebDriverWait wait35 = new WebDriverWait(driver, 120);
			wait35.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));



		}

		catch (Exception e) {

			System.out.println("errror at: ");
			e.printStackTrace();
			log.error("Error in sharing files and folders with view permission",e);	
			//log.fatal(e.getMessage(),e);
			captureScreenShot(ScreenShotsFilePath + "folders_files_share_view_permission_failed_Error.png");
			ATUReports.add("Folders and files share with view permission failed","Folders and files share with view permission failed",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}

	}


	//--------------------------------MyFile_Share_User_Admin_Muti_Preview_Permission--------------------------

	public static void MyFile_Share_User_Admin_Muti_Preview_Permission() 
	{

		try
		{

			actions = new Actions(driver);

			Navigation.other_user_in_same_tenant();

			driver.get(Home_Page);
			WebDriverWait wait5 = new WebDriverWait(driver, 120);
			wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
			//Double click on element
			WebElement ele = getPageObject("Share_User_Admin"); 
			Actions act = new Actions(driver);
			act.doubleClick(ele).perform();
			//Double click on element

			WebElement ele1 = getPageObject("Files_And_Folders"); 
			act.doubleClick(ele1).perform();
			click("select_all_folders");
			click("select_all_files");
			WebElement right=	driver.findElement(By.xpath("//div[@class='files-info']"));
			actions.contextClick(right).perform();
			click("Share");
			Thread.sleep(2000);

			WebElement ela =driver.findElement(By.xpath("(//select[@class='custom-select form-control custom-select'])[2]"));
			Select DD = new Select(ela);
			DD.selectByVisibleText("Preview");

			Thread.sleep(2000);
			click("share_button");
			Thread.sleep(1000);

			WebDriverWait wait222 = new WebDriverWait(driver, 60);
			wait222.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Shared Successfully')]")));
			Thread.sleep(2000);
			click("toast_close");

			Thread.sleep(2000);
			click("Profile_Icon");
			Thread.sleep(1000);
			click("Sign_out");
			click("Ok");
			
			
			WebDriverWait wait35 = new WebDriverWait(driver, 120);
			wait35.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));

			Navigation.login();

			driver.get(Home_Page);

			WebDriverWait wait6 = new WebDriverWait(driver, 120);
			wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));

			click("shared_with_me");
			List<WebElement> Aftermovedfolders =driver.findElements(By.xpath("//*[@class='folder-article']"));
			int	Aftermovedfolderstofolder = Aftermovedfolders .size();
			System.out.println("No of folders Shared" + Aftermovedfolderstofolder);

			if(Aftermovedfolderstofolder==3)
			{


				log.info("--------------------------No of Shared folders is  equal to before------------------------------");

				captureScreenShot(ScreenShotsFilePath +"MyFile_Share_User_Admin_Muti_Preview_Permission_success.png");
				Thread.sleep(2000);
				ATUReports.add("MyFile_Share_User_Admin_Muti_Preview_Permission successfully","MyFile_Share_User_Admin_Muti_Preview_Permission",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
				Thread.sleep(2000); 
			}
			else 
			{
				captureScreenShot(ScreenShotsFilePath + "MyFile_Share_User_Admin_Muti_Preview_Permission_failed.png");
				Thread.sleep(2000);
				ATUReports.add("MyFile_Share_User_Admin_Muti_Preview_Permission failed","MyFile_Share_User_Admin_Muti_Preview_Permission",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}


			List<WebElement> Aftermovedfiles2 = driver.findElements(By.xpath("//*[@class='files-footer']"));
			int Aftermovedfiles1 = Aftermovedfiles2.size();
			System.out.println("No of files Shared" + Aftermovedfiles1);
			if(Aftermovedfiles1==3)
			{


				log.info("--------------------------No of Shared files is  equal to before------------------------------");

				captureScreenShot(ScreenShotsFilePath + "MyFile_Share_User_Admin_Muti_Preview_Permission_success.png");
				Thread.sleep(2000);
				ATUReports.add("MyFile_Share_User_Admin_Muti_Preview_Permission successfully","MyFile_Share_User_Admin_Muti_Preview_Permission",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}

			else 
			{
				captureScreenShot(ScreenShotsFilePath + "MyFile_Share_User_Admin_Muti_Preview_Permission_failed.png");
				Thread.sleep(2000);
				ATUReports.add("MyFile_Share_User_Admin_Muti_Preview_Permission failed","MyFile_Share_User_Admin_Muti_Preview_Permission",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}


		}
		catch (Exception e)
		{

			System.out.println("errror at: ");
			e.printStackTrace();
			log.error("Error in MyFile_Share_User_Admin_Muti_Preview_Permission",e);	
			//log.fatal(e.getMessage(),e);
			captureScreenShot(ScreenShotsFilePath + "MyFile_Share_User_Admin_Muti_Preview_Permission_failed_Error.png");
			ATUReports.add("MyFile_Share_User_Admin_Muti_Preview_Permission failed","MyFile_Share_User_Admin_Muti_Preview_Permission",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}
	}

	//---------------------------------------MyFile_Share_User_Admin_Muti_Preview_Permission_Confirmation--------------------------

	public static void MyFile_Share_User_Admin_Muti_Preview_Permission_Confirmation()
	{

		try
		{
			actions = new Actions(driver);

			WebElement elementLocator2 = getPageObject("first_folder_infolder");
			actions.doubleClick(elementLocator2).perform();

			WebDriverWait wait312 = new WebDriverWait(driver, 60);
			wait312.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[contains(text(),'Folders')]")));
			Thread.sleep(2000);

			WebElement elementLocator1 = getPageObject("first_folder_infolder");
			actions.contextClick(elementLocator1).perform();



			WebDriverWait wait3133 = new WebDriverWait(driver, 60);
			wait3133.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Add/View Comment')]")));
			Thread.sleep(2000);



			WebElement shared_folder_right_click_options = driver.findElement(By.xpath("//div[@class='folder']/div[2][@class='context-list']/ul"));
			List<WebElement> each_folder_li_tag=shared_folder_right_click_options.findElements(By.tagName("li"));

			for(int i=0;i<each_folder_li_tag.size();i++)
			{

				WebElement li =each_folder_li_tag.get(i);

				String each_li = each_folder_li_tag.get(i).getText();
				log.info("Shared folder right click options "+each_li);

				if(each_li.equals("Add/View Comment") || each_li.contains("Export Metadata") )
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

			Robot robot2 = new Robot();
			robot2.keyPress(KeyEvent.VK_ESCAPE);
			robot2.keyRelease(KeyEvent.VK_ESCAPE);
			Thread.sleep(2000);	

			WebElement elementLocator22 = getPageObject("share_first_file");
			actions.contextClick(elementLocator22).perform();
			Thread.sleep(2000);


			WebElement shared_file_right_click_options = driver.findElement(By.xpath("//div[@class='files']/div[@class='row'][1]/following-sibling::div/ul"));
			List<WebElement> each_file_li_tag=shared_file_right_click_options.findElements(By.tagName("li"));

			for(int i=0;i<each_file_li_tag.size();i++)
			{

				WebElement li =each_file_li_tag.get(i);

				String each_li = each_file_li_tag.get(i).getText();
				log.info("Shared file right click options "+each_li);

				if(each_li.equals("Preview") || each_li.equals("Add/View Comment") || each_li.equals("Add to Collection"))
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

			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ESCAPE);
			robot.keyRelease(KeyEvent.VK_ESCAPE);
			Thread.sleep(2000);	

			log.info("-------------Plus button display Assert execution started------------------");


			Boolean checkPlusButtonPresence = getPageObject("share_first_file").isDisplayed();

			Assert.assertTrue(checkPlusButtonPresence);
			log.info("-------------Plus button display Assert execution ended------------------");

			{	
				log.info("--------------------------------------------Folders and files shared with preview permission successfully--------------------------------------------");

				captureScreenShot(ScreenShotsFilePath + "folders_files_shared_with_preview_permission_successfully.png");
				Thread.sleep(2000);
				ATUReports.add("Folders and files shared with preview permissions successfully","Multiple files folders shared with preview permissions successfully",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}
			Thread.sleep(1000);
			click("Profile_Icon");
			Thread.sleep(2000);
			click("Sign_out");
			Thread.sleep(1000);
			click("Ok");
			Thread.sleep(4000);
			
			WebDriverWait wait35 = new WebDriverWait(driver, 120);
			wait35.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));


		}

		catch (Exception e) {

			System.out.println("errror at: ");
			e.printStackTrace();
			log.error("Error in sharing files and folders with preview permission",e);	
			//log.fatal(e.getMessage(),e);
			captureScreenShot(ScreenShotsFilePath + "folders_files_share_preview_permission_failed_Error.png");
			ATUReports.add("Folders and files share with preview permission failed","Folders and files share with preview permission failed",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}

	}

	//--------------------------------------------MyFile_Share_User_Admin_Muti_Upload_Permission---------------------------------

	public static void MyFile_Share_User_Admin_Muti_Upload_Permission() 
	{

		try
		{

			actions = new Actions(driver);

			Navigation.other_user_in_same_tenant();

			driver.get(Home_Page);
			WebDriverWait wait5 = new WebDriverWait(driver, 120);
			wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
			//Double click on element
			WebElement ele = getPageObject("Share_User_Admin"); 
			Actions act = new Actions(driver);
			act.doubleClick(ele).perform();
			//Double click on element

			WebElement ele1 = getPageObject("Files_And_Folders"); 
			act.doubleClick(ele1).perform();
			click("select_all_folders");
			click("select_all_files");
			WebElement right=	driver.findElement(By.xpath("//div[@class='files-info']"));
			actions.contextClick(right).perform();
			click("Share");
			Thread.sleep(2000);

			WebElement ela =driver.findElement(By.xpath("(//select[@class='custom-select form-control custom-select'])[2]"));
			Select DD = new Select(ela);
			DD.selectByVisibleText("Upload");

			Thread.sleep(2000);
			click("share_button");
			Thread.sleep(1000);


			WebDriverWait wait222 = new WebDriverWait(driver, 60);
			wait222.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Shared Successfully')]")));
			Thread.sleep(2000);
			click("toast_close");

			Thread.sleep(2000);
			click("Profile_Icon");
			Thread.sleep(1000);
			click("Sign_out");
			click("Ok");
			Thread.sleep(4000);
			WebDriverWait wait35 = new WebDriverWait(driver, 120);
			wait35.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));

			Navigation.login();

			driver.get(Home_Page);

			WebDriverWait wait6 = new WebDriverWait(driver, 120);
			wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));

			click("shared_with_me");

			List<WebElement> Aftermovedfolders =driver.findElements(By.xpath("//*[@class='folder-article']"));
			int	Aftermovedfolderstofolder = Aftermovedfolders .size();
			System.out.println("No of folders Shared" + Aftermovedfolderstofolder);

			if(Aftermovedfolderstofolder==3)
			{


				log.info("--------------------------No of Shared folders is  equal to before------------------------------");

				captureScreenShot(ScreenShotsFilePath +"MyFile_Share_User_Admin_Muti_Upload_Permission_success.png");
				Thread.sleep(2000);
				ATUReports.add("MyFile_Share_User_Admin_Muti_Upload_Permission successfully","MyFile_Share_User_Admin_Muti_Upload_Permission",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
				Thread.sleep(2000); 
			}
			else 
			{
				captureScreenShot(ScreenShotsFilePath + "MyFile_Share_User_Admin_Muti_Upload_Permission_failed.png");
				Thread.sleep(2000);
				ATUReports.add("MyFile_Share_User_Admin_Muti_Upload_Permission failed","MyFile_Share_User_Admin_Muti_Upload_Permission",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}


			List<WebElement> Aftermovedfiles2 = driver.findElements(By.xpath("//*[@class='files-footer']"));
			int Aftermovedfiles1 = Aftermovedfiles2.size();
			System.out.println("No of files Shared" + Aftermovedfiles1);
			if(Aftermovedfiles1==3)
			{


				log.info("--------------------------No of Shared files is  equal to before------------------------------");

				captureScreenShot(ScreenShotsFilePath + "MyFile_Share_User_Admin_Muti_Upload_Permission_success.png");
				Thread.sleep(2000);
				ATUReports.add("MyFile_Share_User_Admin_Muti_Upload_Permission successfully","MyFile_Share_User_Admin_Muti_Upload_Permission",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}

			else 
			{
				captureScreenShot(ScreenShotsFilePath + "MyFile_Share_User_Admin_Muti_Upload_Permission_failed.png");
				Thread.sleep(2000);
				ATUReports.add("MyFile_Share_User_Admin_Muti_Upload_Permission failed","MyFile_Share_User_Admin_Muti_Upload_Permission",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}


		}
		catch (Exception e)
		{

			System.out.println("errror at: ");
			e.printStackTrace();
			log.error("Error in MyFile_Share_User_Admin_Muti_Upload_Permission",e);	
			//log.fatal(e.getMessage(),e);
			captureScreenShot(ScreenShotsFilePath + "MyFile_Share_User_Admin_Muti_Upload_Permission_failed_Error.png");
			ATUReports.add("MyFile_Share_User_Admin_Muti_Upload_Permission failed","MyFile_Share_User_Admin_Muti_Upload_Permission",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}
	}



	//------------------------------------MyFile_Share_User_Admin_Muti_Upload_Permission_Confirmation------------------------------------------


	public static void MyFile_Share_User_Admin_Muti_Upload_Permission_Confirmation()
	{

		try
		{

			actions = new Actions(driver);


			WebDriverWait wait312123 = new WebDriverWait(driver, 60);
			wait312123.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[contains(text(),'Folders')]")));

			WebElement elementLocator2 = getPageObject("first_folder_infolder");
			actions.doubleClick(elementLocator2).perform();

			WebDriverWait wait312 = new WebDriverWait(driver, 60);
			wait312.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[contains(text(),'Folders')]")));


			WebElement elementLocator1 = getPageObject("first_folder_infolder");
			actions.contextClick(elementLocator1).perform();



			WebDriverWait wait3133 = new WebDriverWait(driver, 60);
			wait3133.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Add/View Tags')]")));
			Thread.sleep(2000);



			WebElement shared_folder_right_click_options = driver.findElement(By.xpath("//div[@class='folder']/div[2][@class='context-list']/ul"));
			List<WebElement> each_folder_li_tag=shared_folder_right_click_options.findElements(By.tagName("li"));

			for(int i=0;i<each_folder_li_tag.size();i++)
			{

				WebElement li =each_folder_li_tag.get(i);

				String each_li = each_folder_li_tag.get(i).getText();
				log.info("Shared folder right click options "+each_li);

				if(each_li.equals("Add/View Tags") || each_li.contains("Export Metadata") )
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

			Robot robot3 = new Robot();
			robot3.keyPress(KeyEvent.VK_ESCAPE);
			robot3.keyRelease(KeyEvent.VK_ESCAPE);
			Thread.sleep(2000);	

			WebElement elementLocator22 = getPageObject("share_first_file");
			actions.contextClick(elementLocator22).perform();
			Thread.sleep(2000);


			WebElement shared_file_right_click_options = driver.findElement(By.xpath("//div[@class='files']/div[@class='row'][1]/following-sibling::div/ul"));
			List<WebElement> each_file_li_tag=shared_file_right_click_options.findElements(By.tagName("li"));

			for(int i=0;i<each_file_li_tag.size();i++)
			{

				WebElement li =each_file_li_tag.get(i);

				String each_li = each_file_li_tag.get(i).getText();
				log.info("Shared folder right click options "+each_li);

				if(each_li.equals("Add/View Tags") || each_li.equals("Add to Collection"))
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

			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ESCAPE);
			robot.keyRelease(KeyEvent.VK_ESCAPE);
			Thread.sleep(2000);	

			{
				log.info("--------------------------------------------Folders and files shared with upload permission successfully--------------------------------------------");

				captureScreenShot(ScreenShotsFilePath + "folders_files_shared_with_upload_permission_successfully.png");
				Thread.sleep(2000);
				ATUReports.add("Folders and files shared with upload permissions successfully","Multiple files folders shared with upload permissions successfully",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}
			Thread.sleep(1000);
			click("Profile_Icon");
			Thread.sleep(2000);
			click("Sign_out");
			Thread.sleep(1000);
			click("Ok");
			Thread.sleep(4000);
			
			WebDriverWait wait35 = new WebDriverWait(driver, 120);
			wait35.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));
		}
		catch (Exception e) {

			System.out.println("errror at: ");
			e.printStackTrace();
			log.error("Error in sharing files and folders with upload permission",e);	
			//log.fatal(e.getMessage(),e);
			captureScreenShot(ScreenShotsFilePath + "folders_files_share_upload_permission_failed_Error.png");
			ATUReports.add("Folders and files share with upload permission failed","Folders and files share with upload permission failed",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}
	}



	//--------------------------------MyFile_Share_User_Admin_Remove_Files_Folders-----------------------------------

	public static void MyFile_Share_User_Admin_Remove_Files_Folders() 
	{

		try
		{

			actions = new Actions(driver);

			Navigation.other_user_in_same_tenant();

			driver.get(Home_Page);
			WebDriverWait wait5 = new WebDriverWait(driver, 120);
			wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
			//Double click on element
			WebElement ele = getPageObject("Share_User_Admin"); 
			Actions act = new Actions(driver);
			act.doubleClick(ele).perform();
			//Double click on element

			WebElement ele1 = getPageObject("Files_And_Folders"); 
			act.doubleClick(ele1).perform();
			click("select_all_folders");
			click("select_all_files");
			WebElement right=	driver.findElement(By.xpath("//div[@class='files-info']"));
			actions.contextClick(right).perform();
			click("Share");
			Thread.sleep(2000);

			WebElement ela =driver.findElement(By.xpath("(//select[@class='custom-select form-control custom-select'])[2]"));
			Select DD = new Select(ela);
			DD.selectByVisibleText("Remove");

			Thread.sleep(2000);
			click("share_button");
			Thread.sleep(1000);


			WebDriverWait wait222 = new WebDriverWait(driver, 60);
			wait222.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Shared Successfully')]")));
			Thread.sleep(2000);
			click("toast_close");

			Thread.sleep(2000);
			click("Profile_Icon");
			Thread.sleep(1000);
			click("Sign_out");
			click("Ok");
			Thread.sleep(4000);
			
			WebDriverWait wait35 = new WebDriverWait(driver, 120);
			wait35.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));

			Navigation.login();

			driver.get(Home_Page);

			WebDriverWait wait6 = new WebDriverWait(driver, 120);
			wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));

			click("shared_with_me");


			List<WebElement> Aftermovedfolders =driver.findElements(By.xpath("//*[@class='folder-article']"));
			int	Aftermovedfolderstofolder = Aftermovedfolders .size();
			System.out.println("No of folders Shared" + Aftermovedfolderstofolder);

			if(Aftermovedfolderstofolder==0)
			{


				log.info("--------------------------No of Shared folders is  equal to before------------------------------");

				captureScreenShot(ScreenShotsFilePath +"MyFile_Share_User_Admin_Remove_Files_Folders_success.png");
				Thread.sleep(2000);
				ATUReports.add("MyFile_Share_User_Admin_Remove_Files_Folders successfully","MyFile_Share_User_Admin_Remove_Files_Folders",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
				Thread.sleep(2000); 
			}
			else 
			{
				captureScreenShot(ScreenShotsFilePath + "MyFile_Share_User_Admin_Remove_Files_Folders_failed.png");
				Thread.sleep(2000);
				ATUReports.add("MyFile_Share_User_Admin_Remove_Files_Folders failed","MyFile_Share_User_Admin_Remove_Files_Folders",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}


			List<WebElement> Aftermovedfiles2 = driver.findElements(By.xpath("//*[@class='files-footer']"));
			int Aftermovedfiles1 = Aftermovedfiles2.size();
			System.out.println("No of files Shared" + Aftermovedfiles1);
			if(Aftermovedfiles1==0)
			{


				log.info("--------------------------No of Shared files is  equal to before------------------------------");

				captureScreenShot(ScreenShotsFilePath + "MyFile_Share_User_Admin_Remove_Files_Folders_success.png");
				Thread.sleep(2000);
				ATUReports.add("MyFile_Share_User_Admin_Remove_Files_Folders successfully","MyFile_Share_User_Admin_Remove_Files_Folders",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}

			else 
			{
				captureScreenShot(ScreenShotsFilePath + "MyFile_Share_User_Admin_Remove_Files_Folders_failed.png");
				Thread.sleep(2000);
				ATUReports.add("MyFile_Share_User_Admin_Remove_Files_Folders failed","MyFile_Share_User_Admin_Remove_Files_Folders",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}
			Thread.sleep(2000);
			click("Profile_Icon");
			Thread.sleep(1000);
			click("Sign_out");
			Thread.sleep(1000);
			click("Ok");
			Thread.sleep(4000);
			
			WebDriverWait wait351 = new WebDriverWait(driver, 120);
			wait351.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));


		}
		catch (Exception e)
		{

			System.out.println("errror at: ");
			e.printStackTrace();
			log.error("Error in MyFile_Share_User_Admin_Remove_Files_Folders",e);	
			//log.fatal(e.getMessage(),e);
			captureScreenShot(ScreenShotsFilePath + "MyFile_Share_User_Admin_Remove_Files_Folders_failed_Error.png");
			ATUReports.add("MyFile_Share_User_Admin_Remove_Files_Folders failed","MyFile_Share_User_Admin_Remove_Files_Folders",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}
	}
}



