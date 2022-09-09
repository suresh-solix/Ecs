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


public class DragandDropMoveVersionUpdateExisting extends Navigation {
	
	static WebDriver driver;
	static Actions actions;


	private static Logger log = Logger.getLogger(DragandDropMoveVersionUpdateExisting.class.getName());
	public static String Home_Page = "https://app.solixecsdev.com/login";
	public DragandDropMoveVersionUpdateExisting(WebDriver driver) {
		super(driver);
		this.driver = driver;
		//driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS).pageLoadTimeout(60, TimeUnit.SECONDS);
		ATUReports.setWebDriver(driver);
		ATUReports.setTestCaseReqCoverage("DragandDropMoveVersionUpdateExisting");
		setIndexPageDescription();
		setAuthorInfoForReports();
		log.info("--------------------DragandDropMoveVersionUpdateExisting--------------------");
		captureScreenShot(ScreenShotsFilePath + "DragandDropMoveVersionUpdateExisting.png");
	}
	private void setAuthorInfoForReports() {
		ATUReports.setAuthorInfo("Mahesh", Utils.getCurrentTime(),"2.0");
	}

	private void setIndexPageDescription() {
		ATUReports.indexPageDescription = "DragandDropMoveVersionUpdateExisting";
	}




	//--------------------------------DragandDropCopy Multiple_files-------------------------------

	public static void DragandDropMoveVersionUpdateExisting_Multiple_files()
	{

		try
		{

			actions = new Actions(driver);

			Navigation.login();

			driver.get(Home_Page);
			WebDriverWait wait5 = new WebDriverWait(driver, 120);
			wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
			Thread.sleep(3000);
			//Double click on element
			WebElement ele = getPageObject("Versions_Folder");

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

			int j =nooffiles-1;
			WebElement drag = driver.findElement(By.xpath("(//div[@class='fileName'])["+j+"]"));
			WebElement drop = driver.findElement(By.xpath("//div[contains(text(),'Move File Versions')]"));

			Actions ac = new Actions(driver);
			ac.dragAndDrop(drag, drop).build().perform();
			Thread.sleep(5000);
			click("Update_Existing");
			Thread.sleep(3000);
			click("Cancel");
			WebDriverWait wait222 = new WebDriverWait(driver, 60);
			wait222.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Successfully moved')]")));
			Thread.sleep(2000);


			click("toast_close");

			Thread.sleep(4000);
			act.doubleClick(drop).perform();

			List<WebElement> Aftermovedfiles = driver.findElements(By.xpath("//*[@class='files-footer']"));
			int Aftermovedfilestofolder = Aftermovedfiles.size();
			System.out.println("No of files Moved" + Aftermovedfilestofolder);

			if(Aftermovedfilestofolder==6)
			{


				log.info("--------------------------No of moved files is equal to before------------------------------");

				captureScreenShot(ScreenShotsFilePath + "DragandDropMoveVersionUpdateExisting_Multiple_files_success.png");
				Thread.sleep(2000);
				ATUReports.add("DragandDropMoveVersionUpdateExisting_Multiple_files successfully","DragandDropMoveVersionUpdateExisting_Multiple_files",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}
			else 
			{
				captureScreenShot(ScreenShotsFilePath + "DragandDropMoveVersionUpdateExisting_Multiple_files_failed.png");
				Thread.sleep(2000);
				ATUReports.add("DragandDropMoveVersionUpdateExisting_Multiple_files failed","DragandDropMoveVersionUpdateExisting_Multiple_files",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}

			for(int i=1; i<=Aftermovedfilestofolder; i++)
			{
				WebElement right=	driver.findElement(By.xpath("(//div[@class='files-info'])["+i+"]"));
				actions.contextClick(right).perform();
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
			log.error("Error in DragandDropMoveVersionUpdateExisting_Multiple_files",e);	
			//log.fatal(e.getMessage(),e);
			captureScreenShot(ScreenShotsFilePath + "DragandDropMoveVersionUpdateExisting_Multiple_files_failed_Error.png");
			ATUReports.add("DragandDropMoveVersionUpdateExisting_Multiple_files failed","DragandDropMoveVersionUpdateExisting_Multiple_files",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}
	}





	//--------------------------------------DragandDropMoveVersionUpdateExisting_Multiple_folders---------------------------


	public static void DragandDropMoveVersionUpdateExisting_Multiple_folders()
	{

		try
		{

			actions = new Actions(driver);

	//   	Navigation.login();

			driver.get(Home_Page);
			WebDriverWait wait5 = new WebDriverWait(driver, 120);
			wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
			Thread.sleep(3000);
			//Double click on element
			WebElement ele = getPageObject("Versions_Folder");

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

			Thread.sleep(5000);

			int j =nooffolders-1; 
			WebElement drag =driver.findElement(By.xpath("(//div[@class='folder-name'])["+j+"]"));
			WebElement drop =driver.findElement(By.xpath("//div[contains(text(),'Move File Versions')]"));

			Actions ac = new Actions(driver); ac.dragAndDrop(drag,drop).build().perform();
			Thread.sleep(3000); 
			click("Update_Existing");
			click("Cancel");
			WebDriverWait wait222 = new WebDriverWait(driver, 60);
			wait222.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Successfully moved')]")));
			Thread.sleep(2000);


			click("toast_close");
			Thread.sleep(4000); 
			act.doubleClick(drop).perform();
			List<WebElement> Aftermovedfolders =driver.findElements(By.xpath("//*[@class='folder-article']"));
			int	Aftermovedfolderstofolder = Aftermovedfolders .size();
			System.out.println("No of folders Moved" + Aftermovedfolderstofolder);

			if(Aftermovedfolderstofolder==6)
			{


				log.info("--------------------------No of moved folders is equal to before------------------------------");

				captureScreenShot(ScreenShotsFilePath +"DragandDropMoveVersionUpdateExisting_Multiple_folders_success.png");
				Thread.sleep(2000);
				ATUReports.add("DragandDropMoveVersionUpdateExisting_Multiple_folders successfully","DragandDropMoveVersionUpdateExisting_Multiple_folders",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
				Thread.sleep(2000); 
			}
			else 
			{
				captureScreenShot(ScreenShotsFilePath + "DragandDropMoveVersionUpdateExisting_Multiple_folders_failed.png");
				Thread.sleep(2000);
				ATUReports.add("DragandDropMoveVersionUpdateExisting_Multiple_folders failed","DragandDropMoveVersionUpdateExisting_Multiple_folders",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}

			for(int i=1; i<=Aftermovedfolderstofolder; i++)
			{
				WebElement el = driver.findElement(By.xpath("(//div[@class='folder-name'])["+i+"]"));
				act.doubleClick(el).perform();
				List<WebElement> Aftermovedfolders1 =driver.findElements(By.xpath("//div[@class='files-info']"));
				int	Aftermovedfolderstofolder1 = Aftermovedfolders1.size();
				for(int k=1; k<=Aftermovedfolderstofolder1; k++)
				{

					WebElement right=	driver.findElement(By.xpath("(//div[@class='files-info'])["+k+"]"));
					actions.contextClick(right).perform();
					Thread.sleep(2000);
					driver.findElement(By.xpath("(//a[@id='menuPopover']//span[contains(text(),'View Versions')])["+k+"]")).click();
					// click("View_Versions");
					driver.findElement(By.xpath("//b[contains(text(),'Current Version')]")).isDisplayed();
					Thread.sleep(2000);
					click("view_Version_close");
					Thread.sleep(2000);

				}
				driver.findElement(By.xpath("(//*[contains(text(),' Move File Versions ')])[1]")).click();
			}

		}
		catch (Exception e) {

			System.out.println("errror at: ");
			e.printStackTrace();
			log.error("Error in DragandDropMoveVersionUpdateExisting_Multiple_folders",e);	
			//log.fatal(e.getMessage(),e);
			captureScreenShot(ScreenShotsFilePath + "DragandDropMoveVersionUpdateExisting_Multiple_folders_failed_Error.png");
			ATUReports.add("DragandDropMoveVersionUpdateExisting_Multiple_folders failed","DragandDropMoveVersionUpdateExisting_Multiple_folders",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}
	}






	//---------------------------------------DragandDropMoveVersionUpdateExisting_Multi_files_folders------------------------------------------------


	public static void DragandDropMoveVersionUpdateExisting_Multi_files_folders()
	{

		try
		{

			actions = new Actions(driver);

	//		Navigation.login();

			driver.get(Home_Page);
			WebDriverWait wait5 = new WebDriverWait(driver, 120);
			wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
			Thread.sleep(3000);
			//Double click on element
			WebElement ele = getPageObject("Versions_Folder");

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
			System.out.println("No of Multi_files Before Moved" + nooffiles);
			click("select_all_files");

			for(int i=2; i<=nooffiles-1; i++)
			{
				driver.findElement(By.xpath("(//div[@class='files']//*[@type='checkbox'])["+i+"]")).click();
			}
			Thread.sleep(5000);

			int j =noofMulti_folders-1; 
			WebElement drag =driver.findElement(By.xpath("(//div[@class='folder-name'])["+j+"]"));
			WebElement drop =driver.findElement(By.xpath("//div[contains(text(),' Move File Versions ')]"));

			Actions ac = new Actions(driver);
			ac.dragAndDrop(drag,drop).build().perform();
			Thread.sleep(3000); 

			click("Update_Existing");
			Thread.sleep(3000); 
			click("Cancel");
			WebDriverWait wait222 = new WebDriverWait(driver, 60);
			wait222.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Successfully moved')]"))); 
			Thread.sleep(2000);
			click("toast_close");

			Thread.sleep(4000); 
			act.doubleClick(drop).perform();

			List<WebElement> AftermovedMulti_folders =driver.findElements(By.xpath("//*[@class='folder-article']"));
			int	AftermovedMulti_folderstofolder = AftermovedMulti_folders.size();
			System.out.println("No of Multi_folders Moved" + AftermovedMulti_folderstofolder);

			if(AftermovedMulti_folderstofolder==6) 
			{
				log.info("--------------------------No of moved Multi_folders is equal to before------------------------------");

				captureScreenShot(ScreenShotsFilePath +"DragandDropMoveVersionUpdateExisting_Multi_folders_success.png");
				Thread.sleep(2000);
				ATUReports.add("DragandDropMoveVersionUpdateExisting_Multi_folders successfully","DragandDropMoveVersionUpdateExisting_Multi_folders",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}
			else 
			{
				captureScreenShot(ScreenShotsFilePath + "DragandDropMoveVersionUpdateExisting_Multi_folders_failed.png");
				Thread.sleep(2000);
				ATUReports.add("DragandDropMoveVersionUpdateExisting_Multi_folders failed","DragandDropMoveVersionUpdateExisting_Multi_folders",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}

			List<WebElement> AftermovedMulti_files1 =driver.findElements(By.xpath("(//div[@class='files-info'])"));
			int	AftermovedMulti_files11 = AftermovedMulti_files1.size();
			System.out.println("No of Multi_files Moved" + AftermovedMulti_files11);

			if(AftermovedMulti_files11==6) 
			{
				log.info("--------------------------No of moved Multi_files is equal to before------------------------------");

				captureScreenShot(ScreenShotsFilePath +"DragandDropMoveVersionUpdateExisting_Multi_files_success.png");
				Thread.sleep(2000);
				ATUReports.add("DragandDropMoveVersionUpdateExisting_Multi_files successfully","DragandDropMoveVersionUpdateExisting_Multi_files",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}
			else 
			{
				captureScreenShot(ScreenShotsFilePath + "DragandDropMoveVersionUpdateExisting_Multi_files_failed.png");
				Thread.sleep(2000);
				ATUReports.add("DragandDropMoveVersionUpdateExisting_Multi_files failed","DragandDropMoveVersionUpdateExisting_Multi_files",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}

			for(int i=1; i<=AftermovedMulti_files11; i++)
			{
				//driver.findElement(By.xpath("//div[@class='folder-name']")).click();
				WebElement right=	driver.findElement(By.xpath("(//div[@class='files-info'])["+i+"]"));
				actions.contextClick(right).perform();
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//a[@id='menuPopover']//span[contains(text(),'View Versions')])["+i+"]")).click();
				// click("View_Versions");
				driver.findElement(By.xpath("//b[contains(text(),'Current Version')]")).isDisplayed();
				Thread.sleep(2000);
				click("view_Version_close");
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

					WebElement right=	driver.findElement(By.xpath("(//div[@class='files-info'])["+k+"]"));
					actions.contextClick(right).perform();
					Thread.sleep(2000);
					driver.findElement(By.xpath("(//a[@id='menuPopover']//span[contains(text(),'View Versions')])["+k+"]")).click();
					// click("View_Versions");
					driver.findElement(By.xpath("//b[contains(text(),'Current Version')]")).isDisplayed();
					Thread.sleep(2000);
					click("view_Version_close");
					Thread.sleep(2000);

				}
				driver.findElement(By.xpath("(//*[contains(text(),' Move File Versions ')])[1]")).click();
			}
			Thread.sleep(1000);
			click("Profile_Icon");
			Thread.sleep(1000);
			click("Sign_out");
			Thread.sleep(1000);
			click("Ok");

			WebDriverWait wait35 = new WebDriverWait(driver, 60);
			wait35.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));
		}
		catch (Exception e) {

			System.out.println("errror at: ");
			e.printStackTrace();
			log.error("Error in DragandDropMoveVersionUpdateExisting_Multi_files_folders",e);	
			//log.fatal(e.getMessage(),e);
			captureScreenShot(ScreenShotsFilePath + "DragandDropMoveVersionUpdateExisting_Multi_files_folders_failed_Error.png");
			ATUReports.add("DragandDropMoveVersionUpdateExisting_Multi_files_folders failed","DragandDropMoveVersionUpdateExisting_Multi_files_folders",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}
	}
}


