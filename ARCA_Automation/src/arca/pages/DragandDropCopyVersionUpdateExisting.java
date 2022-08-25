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

public class DragandDropCopyVersionUpdateExisting extends Navigation{

	static WebDriver driver;
	static Actions actions;
  

	private static Logger log = Logger.getLogger(DragandDropCopyVersionUpdateExisting.class.getName());
	public static String Home_Page = "https://app.solixecsdev.com/login";
	public DragandDropCopyVersionUpdateExisting(WebDriver driver) {
		super(driver);
		this.driver = driver;
		//driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS).pageLoadTimeout(60, TimeUnit.SECONDS);
		ATUReports.setWebDriver(driver);
		ATUReports.setTestCaseReqCoverage("DragandDropCopyVersionUpdateExisting");
		setIndexPageDescription();
		setAuthorInfoForReports();
		log.info("--------------------DragandDropCopyVersionUpdateExisting--------------------");
		captureScreenShot(ScreenShotsFilePath + "DragandDropCopyVersionUpdateExisting.png");
	}
	private void setAuthorInfoForReports() {
		ATUReports.setAuthorInfo("Mahesh", Utils.getCurrentTime(),"2.0");
	}

	private void setIndexPageDescription() {
		ATUReports.indexPageDescription = "DragandDropCopyVersionUpdateExisting";
	}






		//--------------------------DragandDropCopyVersionUpdateExisting_multiple_files-----------------------------


	public static void DragandDropCopyVersionUpdateExisting_multiple_files() 
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
			WebElement ele = getPageObject("Copy_Versions_Test"); 
			Actions act = new Actions(driver);
			act.doubleClick(ele).perform();

			List<WebElement> Beforemovedfiles = driver.findElements(By.xpath("//*[@class='files-footer']"));
			int nooffiles = Beforemovedfiles.size();
			System.out.println("No of files Before Moved" + nooffiles);
			click("select_all_files");

			for(int i=2; i<=nooffiles-1; i++)
			{
				driver.findElement(By.xpath("(//div[@class='files']//*[@type='checkbox'])["+i+"]")).click();

			}
			int j=nooffiles-1;
			WebElement right=	driver.findElement(By.xpath("(//div[@class='files-info'])["+j+"]"));
			actions.contextClick(right).perform();
			click("file_right_click_copy_move");
			//Thread.sleep(3000);
			WebElement el =driver.findElement(By.xpath("//*[@class='cp-list-item']//span[contains(text(),'My Files')]"));
			act.doubleClick(el).perform();
			//Thread.sleep(3000);
			WebElement el1 =driver.findElement(By.xpath("//*[@class='cp-list-item']//span[contains(text(),'Copy Versions Test')]"));
			act.doubleClick(el1).perform();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@class='cp-item-sec1']//span[contains(text(),'Copy Files Versions')]")).click();

			driver.findElement(By.xpath("//div[@class='ftr-cp-rt']//button[contains(text(),'Copy')]")).click();
			Thread.sleep(3000);
			click("Update_Existing");

			Thread.sleep(3000);
			click("Copy_icon_Cancel");
			WebDriverWait wait222 = new WebDriverWait(driver, 60);
			wait222.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Successfully copied')]")));
			Thread.sleep(2000);
			click("toast_close");

			Thread.sleep(4000);
			WebElement drop =getPageObject("Copy_file_version");
			act.doubleClick(drop).perform();
			List<WebElement> Aftermovedfiles = driver.findElements(By.xpath("//*[@class='files-footer']"));
			int Aftermovedfilestofolder = Aftermovedfiles.size();
			System.out.println("No of files Moved" + Aftermovedfilestofolder);
			if(nooffiles==Aftermovedfilestofolder)
			{


				log.info("--------------------------No of moved files is equal to before------------------------------");

				captureScreenShot(ScreenShotsFilePath + "DragandDropCopyVersionUpdateExisting_multiple_files_success.png");
				Thread.sleep(2000);
				ATUReports.add("DragandDropCopyVersionUpdateExisting_multiple_files successfully","DragandDropCopyVersionUpdateExisting_multiple_files",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}


			for(int i=1; i<=Aftermovedfilestofolder; i++)
			{
				WebElement right1=	driver.findElement(By.xpath("(//div[@class='files-info'])["+i+"]"));
				actions.contextClick(right1).perform();
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//a[@id='menuPopover']//span[contains(text(),'View Versions')])["+i+"]")).click();
				// click("View_Versions");
				driver.findElement(By.xpath("//b[contains(text(),'Current Version')]")).isDisplayed();
				Thread.sleep(2000);
				click("view_Version_close");
				Thread.sleep(2000);
			}

		}
		catch (Exception e) {

			System.out.println("errror at: ");
			e.printStackTrace();
			log.error("Error in DragandDropCopyVersionUpdateExisting_multiple_files",e);	
			//log.fatal(e.getMessage(),e);
			captureScreenShot(ScreenShotsFilePath + "DragandDropCopyVersionUpdateExisting_multiple_files_failed_Error.png");
			ATUReports.add("DragandDropCopyVersionUpdateExisting_multiple_files failed","DragandDropCopyVersionUpdateExisting_multiple_files",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}

	}





         //--------------------------DragandDropCopyVersionUpdateExisting_multiple_folders-----------------------------

public static void DragandDropCopyVersionUpdateExisting_multiple_folders() 
{

	try
	{

		actions = new Actions(driver);

//		Navigation.login();

		driver.get(Home_Page);
		WebDriverWait wait5 = new WebDriverWait(driver, 120);
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
		Thread.sleep(3000);
		WebElement ele = getPageObject("Copy_Versions_Test"); 
		Actions act = new Actions(driver);
		act.doubleClick(ele).perform();

		List<WebElement> Beforemovedfolders = driver.findElements(By.xpath("//article[@class='folder-article']"));
		int nooffolders = Beforemovedfolders.size();
		System.out.println("No of folders Before Moved" + nooffolders);
		driver.findElement(By.xpath("//a[@title='Sort Order']")).click();
		click("select_all_folders");

		for(int i=2; i<=nooffolders-1; i++)
		{
			driver.findElement(By.xpath("(//div[@class='folder']//*[@type='checkbox'])["+i+"]")).click();
		}
		int j=nooffolders-1;
		WebElement right=	driver.findElement(By.xpath("(//div[@class='folder-name'])["+j+"]"));
		actions.contextClick(right).perform();
		click("file_right_click_copy_move");
		//Thread.sleep(3000);
		WebElement el =driver.findElement(By.xpath("//*[@class='cp-list-item']//span[contains(text(),'My Files')]"));
		act.doubleClick(el).perform();
		//Thread.sleep(3000);
		WebElement el1 =driver.findElement(By.xpath("//*[@class='cp-list-item']//span[contains(text(),'Copy Versions Test')]"));
		act.doubleClick(el1).perform();
		Thread.sleep(3000);
		WebElement el2 =driver.findElement(By.xpath("//*[@class='cp-item-sec1']//span[contains(text(),'Copy Files Versions')]"));
		act.doubleClick(el2).perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='ftr-cp-rt']//button[contains(text(),'Copy')]")).click();
		Thread.sleep(3000);
		click("Update_Existing");

		Thread.sleep(3000);
		click("Copy_icon_Cancel");
		WebDriverWait wait222 = new WebDriverWait(driver, 60);
		wait222.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Successfully copied')]")));
		Thread.sleep(2000);
		click("toast_close");

		Thread.sleep(4000);
		WebElement drop =getPageObject("Copy_file_version");
		act.doubleClick(drop).perform();
		List<WebElement> Aftermovedfolders = driver.findElements(By.xpath("//div[@class='folder-name']"));
		int Aftermovedfolderstofolder = Aftermovedfolders.size();
		System.out.println("No of folders Moved" + Aftermovedfolderstofolder);
		if(nooffolders==Aftermovedfolderstofolder)
		{


			log.info("--------------------------No of moved folders is equal to before------------------------------");

			captureScreenShot(ScreenShotsFilePath + "DragandDropCopyVersionUpdateExisting_multiple_folders_success.png");
			Thread.sleep(2000);
			ATUReports.add("DragandDropCopyVersionUpdateExisting_multiple_folders successfully","DragandDropCopyVersionUpdateExisting_multiple_folders",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(2000);
		}

		for(int i=1; i<=Aftermovedfolderstofolder; i++)
		{
			WebElement el11 = driver.findElement(By.xpath("(//div[@class='folder-name'])["+i+"]"));
			act.doubleClick(el11).perform();
			List<WebElement> Aftermovedfolders1 =driver.findElements(By.xpath("//div[@class='files-info']"));
			int	Aftermovedfolderstofolder1 = Aftermovedfolders1.size();
		for(int k=1; k<=Aftermovedfolderstofolder1; k++)
		{
			
			WebElement right1=	driver.findElement(By.xpath("(//div[@class='files-info'])["+k+"]"));
			actions.contextClick(right1).perform();
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//a[@id='menuPopover']//span[contains(text(),'View Versions')])["+k+"]")).click();
			// click("View_Versions");
			driver.findElement(By.xpath("//b[contains(text(),'Current Version')]")).isDisplayed();
			Thread.sleep(2000);
			click("view_Version_close");
			Thread.sleep(2000);
			
		}
		driver.findElement(By.xpath("(//*[contains(text(),'Copy Files Versions')])[1]")).click();
		}


	}
	catch (Exception e) {

		System.out.println("errror at: ");
		e.printStackTrace();
		log.error("Error in DragandDropCopyVersionUpdateExisting_multiple_folders",e);	
		//log.fatal(e.getMessage(),e);
		captureScreenShot(ScreenShotsFilePath + "DragandDropCopyVersionUpdateExisting_multiple_folders_failed_Error.png");
		ATUReports.add("DragandDropCopyVersionUpdateExisting_multiple_folders failed","DragandDropCopyVersionUpdateExisting_multiple_folders",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	}

}




//----------------------------------------DragandDropCopyVersionUpdateExisting_multiple_files_folders-----------------------------------

public static void DragandDropCopyVersionUpdateExisting_multiple_files_folders() 
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
		WebElement ele = getPageObject("Copy_Versions_Test"); 
		Actions act = new Actions(driver);
		act.doubleClick(ele).perform();

		List<WebElement> BeforemovedMulti_folders = driver.findElements(By.xpath("//article[@class='folder-article']"));
		int noofMulti_folders = BeforemovedMulti_folders.size();
		System.out.println("No of Multi_folders Before Moved" + noofMulti_folders);
		driver.findElement(By.xpath("//a[@title='Sort Order']")).click();
		click("select_all_folders");
		//click("select_all_files");

		for(int i=2; i<=noofMulti_folders-1; i++)
		{
			driver.findElement(By.xpath("(//div[@class='folder']//*[@type='checkbox'])["+i+"]")).click();
		}

		List<WebElement> Beforemovedfiles = driver.findElements(By.xpath("//*[@class='files-footer']"));
		int nooffiles = Beforemovedfiles.size();
		System.out.println("No of files Before Moved" + nooffiles);
		click("select_all_files");

		for(int i=2; i<=nooffiles-1; i++)
		{
			driver.findElement(By.xpath("(//div[@class='files']//*[@type='checkbox'])["+i+"]")).click();
		}
		int j = nooffiles-1;
		WebElement right=	driver.findElement(By.xpath("(//div[@class='files-info'])["+j+"]"));
		actions.contextClick(right).perform();
		click("file_right_click_copy_move");
		WebElement el2 =driver.findElement(By.xpath("//*[@class='cp-list-item']//span[contains(text(),'My Files')]"));
		act.doubleClick(el2).perform();
		//Thread.sleep(3000);
		WebElement ele3 =driver.findElement(By.xpath("//*[@class='cp-list-item']//span[contains(text(),'Copy Versions Test')]"));
		act.doubleClick(ele3).perform();
		driver.findElement(By.xpath("//*[@class='cp-item-sec1']//span[contains(text(),'Copy Files Versions')]")).click();

		driver.findElement(By.xpath("//div[@class='ftr-cp-rt']//button[contains(text(),'Copy')]")).click();
		Thread.sleep(3000);
		click("Update_Existing");

		Thread.sleep(3000);
		click("Copy_icon_Cancel");
		WebDriverWait wait222 = new WebDriverWait(driver, 60);
		wait222.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Successfully copied')]")));
		Thread.sleep(2000);
		click("toast_close");

		WebElement drop =getPageObject("Copy_file_version");
		act.doubleClick(drop).perform();

		List<WebElement> AftermovedMulti_folders =driver.findElements(By.xpath("//*[@class='folder-article']"));
		int	AftermovedMulti_folderstofolder = AftermovedMulti_folders.size();
		System.out.println("No of Multi_folders Moved" + AftermovedMulti_folderstofolder);

		if(noofMulti_folders==AftermovedMulti_folderstofolder) 
		{


			log.info("--------------------------No of moved Multi_files_folders is equal to before------------------------------");

			captureScreenShot(ScreenShotsFilePath +"DragandDropCopy_Multi_files_folders_success.png");
			Thread.sleep(2000);
			ATUReports.add("DragandDropCopy_Multi_files_folders successfully","DragandDropCopy_Multi_files_folders",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(2000);
		}

		for(int i=1; i<=AftermovedMulti_folderstofolder; i++)
		{
			WebElement el = driver.findElement(By.xpath("(//div[@class='folder-name'])["+i+"]"));
			act.doubleClick(el).perform();
			List<WebElement> Aftermovedfolders1 =driver.findElements(By.xpath("//div[@class='files-info']"));
			int	Aftermovedfolderstofolder1 = Aftermovedfolders1.size();
			for(int k=1; k<=Aftermovedfolderstofolder1; k++)
			{

				WebElement right1=	driver.findElement(By.xpath("(//div[@class='files-info'])["+k+"]"));
				actions.contextClick(right1).perform();
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//a[@id='menuPopover']//span[contains(text(),'View Versions')])["+k+"]")).click();
				// click("View_Versions");
				driver.findElement(By.xpath("//b[contains(text(),'Current Version')]")).isDisplayed();
				Thread.sleep(2000);
				click("view_Version_close");
				Thread.sleep(2000);

			}
			driver.findElement(By.xpath("//a//div[contains(text(),'Copy Files Versions')] ")).click();
		}

		List<WebElement> AftermovedMulti_files =driver.findElements(By.xpath("(//div[@class='files-info'])"));
		int	AftermovedMulti_files1 = AftermovedMulti_files.size();
		System.out.println("No of Multi_files Moved" + AftermovedMulti_files);

		for(int i=1; i<=AftermovedMulti_files1; i++)
		{
			//	driver.findElement(By.xpath("//div[@class='folder-name']")).click();
			WebElement right1=	driver.findElement(By.xpath("(//div[@class='files-info'])["+i+"]"));
			actions.contextClick(right1).perform();
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//a[@id='menuPopover']//span[contains(text(),'View Versions')])["+i+"]")).click();
			// click("View_Versions");
			driver.findElement(By.xpath("//b[contains(text(),'Current Version')]")).isDisplayed();
			Thread.sleep(2000);
			click("view_Version_close");
			Thread.sleep(2000);
		}

	}
	catch (Exception e) {

		System.out.println("errror at: ");
		e.printStackTrace();
		log.error("Error in DragandDropCopyVersionUpdateExisting_multiple_files_folders",e);	
		//log.fatal(e.getMessage(),e);
		captureScreenShot(ScreenShotsFilePath + "DragandDropCopyVersionUpdateExisting_multiple_files_folders_failed_Error.png");
		ATUReports.add("DragandDropCopyVersionUpdateExisting_multiple_files_folders failed","DragandDropCopyVersionUpdateExisting_multiple_files_folders",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	}

}

}















