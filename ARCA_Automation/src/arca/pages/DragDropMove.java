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
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import arca.common.Navigation;
import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.reports.utils.Utils;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;


public class DragDropMove extends Navigation {

	static WebDriver driver;
	static Actions actions;
  

	private static Logger log = Logger.getLogger(DragDropMove.class.getName());
	public static String Home_Page = "https://app.solixecsdev.com/login";
	public DragDropMove(WebDriver driver) {
		super(driver);
		this.driver = driver;
		//driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS).pageLoadTimeout(60, TimeUnit.SECONDS);
		ATUReports.setWebDriver(driver);
		ATUReports.setTestCaseReqCoverage("DragDropMove");
		setIndexPageDescription();
		setAuthorInfoForReports();
		log.info("--------------------DragDropMove--------------------");
		captureScreenShot(ScreenShotsFilePath + "DragDropMove.png");
	}
	private void setAuthorInfoForReports() {
		ATUReports.setAuthorInfo("Mahesh", Utils.getCurrentTime(),"2.0");
	}

	private void setIndexPageDescription() {
		ATUReports.indexPageDescription = "DragDropMove";
	}



	//------------------------------------------------DragDropMove Files ---------------------------------------------

	public static void DragDropMove_File()
	{

		try
		{

			actions = new Actions(driver);

	//		Navigation.login();

			driver.get(Home_Page);
			WebDriverWait wait5 = new WebDriverWait(driver, 120);
			wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));

			Thread.sleep(3000);
			//WebElement ele = driver.findElement(By.xpath("//div[contains(text(),'Drag and Drop Move')]")); 
			WebElement ele = getPageObject("drag_and_drop_move");

			Actions act = new Actions(driver);
			act.doubleClick(ele).perform();

			WebElement el = getPageObject("Folder-DragDrop");
			act.doubleClick(el).perform();

			Thread.sleep(3000);
			click("Plus-Buttom");

			driver.findElement(By.xpath("(//span[contains(text(),'New Folder')])[2]")).click();

			DateFormat dateFormat = new SimpleDateFormat("MMM-dd HH-mm");

			//get current date time with Date()
			Date date = new Date();

			// Now format the date
			String dateFormatted= dateFormat.format(date);

			String single_file_folder_name="single-file "+dateFormatted;
			sendKeys("Create-FolderName",single_file_folder_name);
			click("Ok");
			Thread.sleep(3000);

			List<WebElement> Beforemovedfiles = driver.findElements(By.xpath("//*[@class='files-footer']"));
			int nooffiles = Beforemovedfiles.size();
			System.out.println("No of files Before Moved" + nooffiles);

			WebElement close = driver.findElement(By.xpath("//div[contains(text(),'Folder is created successfully')]"));
			close.click();
			Thread.sleep(2000);
			WebElement drag = driver.findElement(By.xpath("(//div[@class='fileName'])[1]"));
			WebElement drop = driver.findElement(By.xpath("//div[contains(text(),'"+single_file_folder_name+"')]"));

			Actions ac = new Actions(driver);
			ac.dragAndDrop(drag, drop).build().perform();

			Thread.sleep(3000);
			click("Cancel");
			WebDriverWait wait222 = new WebDriverWait(driver, 60);
			wait222.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Successfully moved')]")));
			Thread.sleep(2000);

			click("toast_close");

			Thread.sleep(4000);
			act.doubleClick(drop).perform();
			Thread.sleep(4000);

			List<WebElement> Aftermovedfiles = driver.findElements(By.xpath("//*[@class='files-footer']"));
			int Aftermovedfilestofolder = Aftermovedfiles.size();
			System.out.println("No of files Moved" + Aftermovedfilestofolder);
			if(Aftermovedfilestofolder==1)
			{


				log.info("--------------------------------------------No of moved files is not equal to before--------------------------------------------");

				captureScreenShot(ScreenShotsFilePath + "DragDropMove_File_success.png");
				Thread.sleep(2000);
				ATUReports.add("DragDropMove_File successfully","DragDropMove_File",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}
			else
			{

				captureScreenShot(ScreenShotsFilePath + "DragDropMove_File_failed.png");
				Thread.sleep(2000);
				ATUReports.add("DragDropMove_File failed","DragDropMove_File",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}

		}
		catch (Exception e) {

			System.out.println("errror at: ");
			e.printStackTrace();
			log.error("Error in DragDropMove single file",e);	
			//log.fatal(e.getMessage(),e);
			captureScreenShot(ScreenShotsFilePath + "DragDropMove_single_file_failed_Error.png");
			ATUReports.add("DragDropMove single file failed","DragDropMove single file",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}

	}



	//------------------------------------------------DragDropMove Folder ---------------------------------------------

	public static void DragDropMove_Folder()
	{

		try
		{

			actions = new Actions(driver);

			//		Navigation.login();

			driver.get(Home_Page);
			WebDriverWait wait5 = new WebDriverWait(driver, 120);
			wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
			//Double click on element
			Thread.sleep(3000);
			WebElement ele = driver.findElement(By.xpath("//div[contains(text(),'Drag and Drop Move')]")); 
			Actions act = new Actions(driver);
			act.doubleClick(ele).perform();

			WebElement el = getPageObject("Folder-DragDrop");
			act.doubleClick(el).perform();

			Thread.sleep(3000);
			click("Plus-Buttom");
			driver.findElement(By.xpath("(//span[contains(text(),'New Folder')])[2]")).click();

			DateFormat dateFormat = new SimpleDateFormat("MMM-dd HH-mm");

			//get current date time with Date()
			Date date = new Date();

			// Now format the date
			String dateFormatted= dateFormat.format(date);

			String single_folder_folder_name="single-folder_move "+dateFormatted;
			sendKeys("Create-FolderName",single_folder_folder_name);
			click("Ok");
			Thread.sleep(3000);

			List<WebElement> BeforemovedFolders = driver.findElements(By.xpath("//*[@class='folder-article']"));
			int nooffolder = BeforemovedFolders.size();
			System.out.println("No of Folders Before-Moved" + nooffolder);

			WebElement close = driver.findElement(By.xpath("//div[contains(text(),'Folder is created successfully')]"));
			close.click();
			Thread.sleep(2000);
			WebElement drag = driver.findElement(By.xpath("(//div[@class='folder-name'])[2]"));
			WebElement drop = driver.findElement(By.xpath("//div[contains(text(),'"+single_folder_folder_name+"')]"));

			Actions ac = new Actions(driver);
			ac.dragAndDrop(drag, drop).build().perform();

			Thread.sleep(3000);
			click("Cancel");
			WebDriverWait wait222 = new WebDriverWait(driver, 60);
			wait222.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Successfully moved')]")));
			Thread.sleep(2000);

			click("toast_close");

			Thread.sleep(4000);
			act.doubleClick(drop).perform();
			Thread.sleep(4000);

			List<WebElement> Aftermovedfolders = driver.findElements(By.xpath("//*[@class='folder-article']"));
			int Aftermovedfolderstofolder = Aftermovedfolders.size();
			System.out.println("No of Folder Moved" + Aftermovedfolderstofolder);
			if(Aftermovedfolderstofolder==1)
			{
				log.info("--------------------------------------------No of moved folders is not equal to before--------------------------------------------");

				captureScreenShot(ScreenShotsFilePath + "DragDropMove_Folder_success.png");
				Thread.sleep(2000);
				ATUReports.add("DragDropMove_Folder successfully","DragDropMove_Folder",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}
			else
			{

				captureScreenShot(ScreenShotsFilePath + "DragDropMove_Folder_failed.png");
				Thread.sleep(2000);
				ATUReports.add("DragDropMove_Folder failed","DragDropMove_Folder",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}

		}
		catch (Exception e) {

			System.out.println("errror at: ");
			e.printStackTrace();
			log.error("Error in DragDropMove_Folder",e);	
			//log.fatal(e.getMessage(),e);
			captureScreenShot(ScreenShotsFilePath + "DragDropMove_Folder_failed_Error.png");
			ATUReports.add("DragDropMove_Folder failed","DragDropMove_Folder",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}

	}



	//------------------------------------------------DragDropMove multiple_files ---------------------------------------------

	public static void DragDropMove_multiple_files()
	{

		try
		{

			actions = new Actions(driver);

			//		Navigation.login();

			driver.get(Home_Page);
			WebDriverWait wait5 = new WebDriverWait(driver, 120);
			wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
			//Double click on element
			Thread.sleep(3000);
			WebElement ele = driver.findElement(By.xpath("//div[contains(text(),'Drag and Drop Move')]")); 
			Actions act = new Actions(driver);
			act.doubleClick(ele).perform();

			WebElement el = getPageObject("Folder-DragDrop");
			act.doubleClick(el).perform();

			Thread.sleep(3000);
			click("Plus-Buttom");
			driver.findElement(By.xpath("(//span[contains(text(),'New Folder')])[2]")).click();

			DateFormat dateFormat = new SimpleDateFormat("MMM-dd HH-mm");

			//get current date time with Date()
			Date date = new Date();

			// Now format the date
			String dateFormatted= dateFormat.format(date);

			String multiple_file_folder_name="multiple-file "+dateFormatted;
			sendKeys("Create-FolderName",multiple_file_folder_name);
			click("Ok");
			Thread.sleep(3000);

			List<WebElement> Beforemovedfiles = driver.findElements(By.xpath("//*[@class='files-footer']"));
			int nooffiles = Beforemovedfiles.size();
			System.out.println("No of files Before-Moved" + nooffiles);

			WebElement close = driver.findElement(By.xpath("//div[contains(text(),'Folder is created successfully')]"));
			close.click();
			Thread.sleep(2000);
			click("select_all_files");
			WebElement drag = driver.findElement(By.xpath("(//div[@class='fileName'])[1]"));
			WebElement drop = driver.findElement(By.xpath("//div[contains(text(),'"+multiple_file_folder_name+"')]"));

			//Actions ac = new Actions(driver);
			act.dragAndDrop(drag, drop).build().perform();

			Thread.sleep(3000);
			click("Cancel");
			WebDriverWait wait222 = new WebDriverWait(driver, 60);
			wait222.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Successfully moved')]")));
			Thread.sleep(2000);

			click("toast_close");

			Thread.sleep(4000);
			act.doubleClick(drop).perform();
			Thread.sleep(4000);

			List<WebElement> Aftermovedfiles = driver.findElements(By.xpath("//*[@class='files-footer']"));
			int Aftermovedfilestofolder = Aftermovedfiles.size();
			System.out.println("No of files Moved" + Aftermovedfilestofolder);

			if(Aftermovedfilestofolder==nooffiles)
			{
				log.info("--------------------------------------------No of moved multiple_files is equal to before--------------------------------------------");

				captureScreenShot(ScreenShotsFilePath + "mDragDropMove_multiple_files_success.png");
				Thread.sleep(2000);
				ATUReports.add("DragDropMove_multiple_files successfully","DragDropMove_multiple_files",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}
			else
			{

				captureScreenShot(ScreenShotsFilePath + "DragDropMove_multiple_files_failed.png");
				Thread.sleep(2000);
				ATUReports.add("DragDropMove_multiple_files failed","DragDropMove_multiple_files",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}


		}
		catch (Exception e) {

			System.out.println("errror at: ");
			e.printStackTrace();
			log.error("Error in DragDropMove_multiple_files",e);	
			//log.fatal(e.getMessage(),e);
			captureScreenShot(ScreenShotsFilePath + "DragDropMove_multiple_files_failed_Error.png");
			ATUReports.add("DragDropMove_multiple_files failed","DragDropMove_multiple_files",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}

	}




	//------------------------------------------------DragDropMove multiple_Folders ---------------------------------------------

	public static void DragDropMove_multiple_Folders()
	{

		try
		{

			actions = new Actions(driver);

			//			Navigation.login();

			driver.get(Home_Page);
			WebDriverWait wait5 = new WebDriverWait(driver, 120);
			wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
			//Double click on element
			Thread.sleep(3000);
			WebElement ele = driver.findElement(By.xpath("//div[contains(text(),'Drag and Drop Move')]")); 
			Actions act = new Actions(driver);
			act.doubleClick(ele).perform();

			WebElement el = getPageObject("Folder-DragDrop");
			act.doubleClick(el).perform();

			Thread.sleep(3000);
			click("Plus-Buttom");
			driver.findElement(By.xpath("(//span[contains(text(),'New Folder')])[2]")).click();

			DateFormat dateFormat = new SimpleDateFormat("MMM-dd HH-mm");

			//get current date time with Date()
			Date date = new Date();

			// Now format the date
			String dateFormatted= dateFormat.format(date);

			String multiple_folder_folder_name="multiple-folder_move "+dateFormatted;
			sendKeys("Create-FolderName",multiple_folder_folder_name);
			click("Ok");
			Thread.sleep(2000);

			List<WebElement> Beforemovedfolders = driver.findElements(By.xpath("//*[@class='folder-article']"));
			int noofFolders = Beforemovedfolders.size();
			System.out.println("No of Folders Before-Moved" + noofFolders);

			Thread.sleep(3000);
			WebElement close = driver.findElement(By.xpath("//div[contains(text(),'Folder is created successfully')]"));
			close.click();
			Thread.sleep(3000);
			//click("select_all_folders");
			driver.findElement(By.xpath("(//label[@class='custom-control-label'])[1]")).click();
			driver.findElement(By.xpath("(//div[@class='check-box checked'])[1]")).click();

			WebElement drag = driver.findElement(By.xpath("(//div[@class='folder-name'])[2]"));
			WebElement drop = driver.findElement(By.xpath("//div[contains(text(),'"+multiple_folder_folder_name+"')]"));

			Actions ac = new Actions(driver);
			ac.dragAndDrop(drag, drop).build().perform();

			Thread.sleep(3000);
			click("Cancel");
			WebDriverWait wait222 = new WebDriverWait(driver, 60);
			wait222.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Successfully moved')]")));
			Thread.sleep(2000);

			click("toast_close");

			Thread.sleep(2000);
			act.doubleClick(drop).perform();

			List<WebElement> Aftermovedfolders = driver.findElements(By.xpath("//*[@class='folder-article']"));
			int Aftermovedfolderstofolder = Aftermovedfolders.size();
			System.out.println("No of Folders Moved" + Aftermovedfolderstofolder);

			if(Aftermovedfolderstofolder==7)
			{
				log.info("--------------------------------------------No of moved multiple_folders is not equal to before--------------------------------------------");

				captureScreenShot(ScreenShotsFilePath + "DragDropMove_multiple_Folders_success.png");
				Thread.sleep(2000);
				ATUReports.add("DragDropMove_multiple_Folders successfully","DragDropMove_multiple_Folders",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}

			else
			{
				captureScreenShot(ScreenShotsFilePath + "DragDropMove_multiple_Folders_failed.png");
				Thread.sleep(2000);
				ATUReports.add("DragDropMove_multiple_Folders failed","DragDropMove_multiple_Folders",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}

			Thread.sleep(2000);
			click("Profile_Icon");
			Thread.sleep(1000);
			click("Sign_out");
			Thread.sleep(1000);
			click("Ok");
			Thread.sleep(3000);

			WebDriverWait wait35 = new WebDriverWait(driver, 60);
			wait35.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));

		}
		catch (Exception e) {

			System.out.println("errror at: ");
			e.printStackTrace();
			log.error("Error in DragDropMove_multiple_Folders",e);	
			//log.fatal(e.getMessage(),e);
			captureScreenShot(ScreenShotsFilePath + "DragDropMove_multiple_Folders_failed_Error.png");
			ATUReports.add("DragDropMove_multiple_Folders failed","DragDropMove_multiple_Folders",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}

	}


	//------------------------------------------------DragDropMove multiple_Data ---------------------------------------------

	public static void DragDropMove_multiple_Data()
	{

		try
		{
			actions = new Actions(driver);

			Navigation.login();

			driver.get(Home_Page);
			WebDriverWait wait5 = new WebDriverWait(driver, 120);
			wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
			//Double click on element
			Thread.sleep(3000);
			WebElement ele = driver.findElement(By.xpath("//div[contains(text(),'Drag and Drop Move')]")); 
			Actions act = new Actions(driver);
			act.doubleClick(ele).perform();

			Thread.sleep(3000);
			click("Plus-Buttom");
			driver.findElement(By.xpath("(//span[contains(text(),'New Folder')])[2]")).click();

			DateFormat dateFormat = new SimpleDateFormat("MMM-dd HH-mm");

			//get current date time with Date()
			Date date = new Date();

			// Now format the date
			String dateFormatted= dateFormat.format(date);

			String multiple_data_folder_name="multiple-Data_move "+dateFormatted;
			sendKeys("Create-FolderName",multiple_data_folder_name);
			click("Ok");
			Thread.sleep(3000);


			List<WebElement> Beforemovedfolders = driver.findElements(By.xpath("//*[@class='folder-article']"));
			int nooffolders = Beforemovedfolders.size();
			System.out.println("No of folders Before-Moved" + nooffolders);

			List<WebElement> Beforemovedfiles = driver.findElements(By.xpath("//*[@class='files-footer']"));
			int nooffiles = Beforemovedfiles.size();
			System.out.println("No of files Before-Moved" + nooffiles);

			WebElement close = driver.findElement(By.xpath("//div[contains(text(),'Folder is created successfully')]"));
			close.click();
			Thread.sleep(2000);
			click("select_all_folders");
			click("select_all_files");
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//div[@class='check-box checked'])[1]")).click();

			WebElement drag = driver.findElement(By.xpath("(//div[@class='folder-name'])[2]"));
			WebElement drop = driver.findElement(By.xpath("//div[contains(text(),'"+multiple_data_folder_name+"')]"));

			Actions ac = new Actions(driver);
			ac.dragAndDrop(drag, drop).build().perform();

			Thread.sleep(3000);
			click("Cancel");
			WebDriverWait wait222 = new WebDriverWait(driver, 60);
			wait222.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Successfully moved')]")));
			Thread.sleep(2000);

			click("toast_close");
			Thread.sleep(4000);
			act.doubleClick(drop).perform();
			Thread.sleep(4000);

			List<WebElement> Aftermovedfolders =driver.findElements(By.xpath("//*[@class='folder-article']"));
			int	Aftermovedfolderstofolder = Aftermovedfolders .size();
			System.out.println("No of folders Moved" + Aftermovedfolderstofolder);

			if(Aftermovedfolderstofolder==5)
			{
				log.info("--------------------------No of Folders Moved is  not equal to before------------------------------");

				captureScreenShot(ScreenShotsFilePath +"DragDropMove_multiple_Data_success.png");
				Thread.sleep(2000);
				ATUReports.add("DragDropMove_multiple_Data successfully","DragDropMove_multiple_Data",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
				Thread.sleep(2000); 
			}
			else 
			{
				captureScreenShot(ScreenShotsFilePath + "DragDropMove_multiple_Data_failed.png");
				Thread.sleep(2000);
				ATUReports.add("DragDropMove_multiple_Data failed","DragDropMove_multiple_Data",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}


			List<WebElement> Aftermovedfiles = driver.findElements(By.xpath("//*[@class='files-footer']"));
			int Aftermovedfilestofolder = Aftermovedfiles.size();
			System.out.println("No of Files Moved" + Aftermovedfilestofolder);

			if(Aftermovedfilestofolder==5)
			{
				log.info("--------------------------------------------No of moved files is  equal to before--------------------------------------------");

				captureScreenShot(ScreenShotsFilePath + "DragDropMove_multiple_Data_success.png");
				Thread.sleep(2000);
				ATUReports.add("DragDropMove_multiple_Data successfully","DragDropMove_multiple_Data",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}
			else
			{
				captureScreenShot(ScreenShotsFilePath + "DragDropMove_multiple_Data_failed.png");
				Thread.sleep(2000);
				ATUReports.add("DragDropMove_multiple_Data failed","DragDropMove_multiple_Data",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}


		}
		catch (Exception e) {

			System.out.println("errror at: ");
			e.printStackTrace();
			log.error("Error in DragDropMove_multiple_Data",e);	
			//log.fatal(e.getMessage(),e);
			captureScreenShot(ScreenShotsFilePath + "DragDropMove_multiple_Data_failed_Error.png");
			ATUReports.add("DragDropMove_multiple_Data failed","DragDropMove_multiple_Data",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}

	}
}	



