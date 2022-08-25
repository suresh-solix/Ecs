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

			Navigation.login();

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
			
			WebElement close = driver.findElement(By.xpath("//*[@class='Vue-Toastification__close-button']"));
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
				
				
				log.info("--------------------------------------------No of moved files is equal to before--------------------------------------------");
				
				captureScreenShot(ScreenShotsFilePath + "single_files_drag_drop_move_success.png");
				Thread.sleep(2000);
				ATUReports.add("single file drag and drop move successfully","single file drag and drop",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}
			else
			{
				
				captureScreenShot(ScreenShotsFilePath + "single_files_drag_drop_move_failed.png");
				Thread.sleep(2000);
				ATUReports.add("single file drag and drop move failed","single file drag and drop",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}
			

		}
		catch (Exception e) {

			System.out.println("errror at: ");
			e.printStackTrace();
			log.error("Error in DragDropMove single file",e);	
			//log.fatal(e.getMessage(),e);
			captureScreenShot(ScreenShotsFilePath + "DragDropMove single file_failed_Error.png");
			ATUReports.add("DragDropMove single file failed","DragDropMove single file",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}

	}



//------------------------------------------------DragDropMove Folder ---------------------------------------------

	public static void DragDropMove_Folder()
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
			
			String single_folder_folder_name="single-folder_move "+dateFormatted;
			sendKeys("Create-FolderName",single_folder_folder_name);
			click("Ok");
			Thread.sleep(3000);
			
			List<WebElement> BeforemovedFolders = driver.findElements(By.xpath("//*[@class='folder-article']"));
			int nooffolder = BeforemovedFolders.size();
			System.out.println("No of Folders Before-Moved" + nooffolder);
			
			WebElement close = driver.findElement(By.xpath("//*[@class='Vue-Toastification__close-button']"));
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
			if(nooffolder!=Aftermovedfolderstofolder)
			{
				
				
				log.info("--------------------------------------------No of moved folders is equal to before--------------------------------------------");
				
				captureScreenShot(ScreenShotsFilePath + "single_folder_drag_drop_move_success.png");
				Thread.sleep(2000);
				ATUReports.add("single_folder drag and drop move successfully","single_folder drag and drop",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}

		}
		catch (Exception e) {

			System.out.println("errror at: ");
			e.printStackTrace();
			log.error("Error in DragDropMove single_folder",e);	
			//log.fatal(e.getMessage(),e);
			captureScreenShot(ScreenShotsFilePath + "DragDropMove single_folder_failed_Error.png");
			ATUReports.add("DragDropMove single_folder failed","DragDropMove single_folder",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
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
		
		WebElement close = driver.findElement(By.xpath("//*[@class='Vue-Toastification__close-button']"));
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
		if(nooffiles!=Aftermovedfilestofolder)
		{
			
			
			log.info("--------------------------------------------No of moved multiple_files is equal to before--------------------------------------------");
			
			captureScreenShot(ScreenShotsFilePath + "multiple_files_drag_drop_move_success.png");
			Thread.sleep(2000);
			ATUReports.add("Multiple_files drag and drop move successfully","Multiple_files drag and drop",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(2000);
		}
			
		

	}
	catch (Exception e) {

		System.out.println("errror at: ");
		e.printStackTrace();
		log.error("Error in DragDropMove Multiple files",e);	
		//log.fatal(e.getMessage(),e);
		captureScreenShot(ScreenShotsFilePath + "DragDropMove Multiple files_failed_Error.png");
		ATUReports.add("DragDropMove Multiple files failed","DragDropMove Multiple files",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	}

}




//------------------------------------------------DragDropMove multiple_Folders ---------------------------------------------

	public static void DragDropMove_multiple_Folders()
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
			
			String multiple_folder_folder_name="multiple-folder_move "+dateFormatted;
			sendKeys("Create-FolderName",multiple_folder_folder_name);
			click("Ok");
			Thread.sleep(2000);
			
			List<WebElement> Beforemovedfolders = driver.findElements(By.xpath("//*[@class='folder-article']"));
			int noofFolders = Beforemovedfolders.size();
			System.out.println("No of Folders Before-Moved" + noofFolders);
			
			Thread.sleep(3000);
			WebElement close = driver.findElement(By.xpath("//button[@aria-label='close'][@class='Vue-Toastification__close-button']"));
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
			if(Aftermovedfolderstofolder==2)
			{
				
				
				log.info("--------------------------------------------No of moved multiple_folders is equal to before--------------------------------------------");
				
				captureScreenShot(ScreenShotsFilePath + "multiple_Folders_drag_drop_move_success.png");
				Thread.sleep(2000);
				ATUReports.add("multiple_Folders drag and drop move successfully","multiple_Folders drag and drop",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}

			else
			{
				captureScreenShot(ScreenShotsFilePath + "multiple_Folders_drag_drop_move_failed.png");
				Thread.sleep(2000);
				ATUReports.add("multiple_Folders drag and drop move failed","multiple_Folders drag and drop",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}

		}
		catch (Exception e) {

			System.out.println("errror at: ");
			e.printStackTrace();
			log.error("Error in DragDropMove multiple_Folders",e);	
			//log.fatal(e.getMessage(),e);
			captureScreenShot(ScreenShotsFilePath + "DragDropMove multiple_Folders_failed_Error.png");
			ATUReports.add("DragDropMove multiple_Folders failed","DragDropMove multiple_Folders",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
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

			List<WebElement> Beforemovedfiles = driver.findElements(By.xpath("//*[@class='files-footer']"));
			int nooffiles = Beforemovedfiles.size();
			System.out.println("No of data Before-Moved" + nooffiles);

			WebElement close = driver.findElement(By.xpath("//*[@class='Vue-Toastification__close-button']"));
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
			
			List<WebElement> Aftermovedfiles = driver.findElements(By.xpath("//*[@class='files-footer']"));
			int Aftermovedfilestofolder = Aftermovedfiles.size();
			System.out.println("No of data Moved" + Aftermovedfilestofolder);
			if(nooffiles!=Aftermovedfilestofolder)
			{
				log.info("--------------------------------------------No of moved multi_data is equal to before--------------------------------------------");

				captureScreenShot(ScreenShotsFilePath + "multiple_data_drag_drop_move_success.png");
				Thread.sleep(2000);
				ATUReports.add("Multiple data drag and drop move successfully","Multiple data drag and drop",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}

			

		}
		catch (Exception e) {

			System.out.println("errror at: ");
			e.printStackTrace();
			log.error("Error in DragDropMove multiple_data",e);	
			//log.fatal(e.getMessage(),e);
			captureScreenShot(ScreenShotsFilePath + "DragDropMove multiple_data_failed_Error.png");
			ATUReports.add("DragDropMove multiple_data failed","DragDropMove multiple_data",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}

	}
}	

		

