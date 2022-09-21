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

public class DragandDropMoveVersions_Skip extends Navigation {
	
	static WebDriver driver;
	static Actions actions;
  

	private static Logger log = Logger.getLogger(DragandDropMoveVersions_Skip.class.getName());
	public static String Home_Page = "https://app.solixecsdev.com/login";
	public DragandDropMoveVersions_Skip(WebDriver driver) {
		super(driver);
		this.driver = driver;
		//driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS).pageLoadTimeout(60, TimeUnit.SECONDS);
		ATUReports.setWebDriver(driver);
		ATUReports.setTestCaseReqCoverage("DragandDropMoveVersions_Skip");
		setIndexPageDescription();
		setAuthorInfoForReports();
		log.info("--------------------DragandDropMoveVersions_Skip--------------------");
		captureScreenShot(ScreenShotsFilePath + "DragandDropMoveVersions_Skip.png");
	}
	private void setAuthorInfoForReports() {
		ATUReports.setAuthorInfo("Mahesh", Utils.getCurrentTime(),"2.0");
	}

	private void setIndexPageDescription() {
		ATUReports.indexPageDescription = "DragandDropMoveVersions_Skip";
	}



//------------------------------------------------DragandDropMoveVersions_Skip_Files ---------------------------------------------

	public static void DragandDropMoveVersions_Skip_Files() 
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
			WebElement ele = getPageObject("Move_Skip_Test");

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
			WebElement drop = driver.findElement(By.xpath("//div[contains(text(),'Skip Data')]"));

			Actions ac = new Actions(driver);
			ac.dragAndDrop(drag, drop).build().perform();
			Thread.sleep(5000);
			click("Skip");
			
			Thread.sleep(2000);
			act.doubleClick(drop).perform();
			Thread.sleep(4000);
			
			List<WebElement> Aftermovedfiles = driver.findElements(By.xpath("//*[@class='files-footer']"));
			int Aftermovedfilestofolder = Aftermovedfiles.size();
			System.out.println("No of files Skip" + Aftermovedfilestofolder);
			
			if(Aftermovedfilestofolder==2)
			{


				log.info("--------------------------No of moved files is Not equal to before------------------------------");

				captureScreenShot(ScreenShotsFilePath + "DragandDropMoveVersions_Skip_Files_success.png");
				Thread.sleep(2000);
				ATUReports.add("DragandDropMoveVersions_Skip_Files successfully","DragandDropMoveVersions_Skip_Files",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}

			else 
			{
				captureScreenShot(ScreenShotsFilePath + "DragandDropMoveVersions_Skip_Files_failed.png");
				Thread.sleep(2000);
				ATUReports.add("DragandDropMoveVersions_Skip_Files failed","DragandDropMoveVersions_Skip_Files",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}
			

		}
		catch (Exception e) {

			System.out.println("errror at: ");
			e.printStackTrace();
			log.error("Error in DragandDropMoveVersions_Skip_Files",e);	
			//log.fatal(e.getMessage(),e);
			captureScreenShot(ScreenShotsFilePath + "DragandDropMoveVersions_Skip_Files_failed_Error.png");
			ATUReports.add("DragandDropMoveVersions_Skip_Files failed","DragandDropMoveVersions_Skip_Files",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}

	}

	


//------------------------------------------------DragandDropMoveVersions_Skip_Folders ---------------------------------------------

	public static void DragandDropMoveVersions_Skip_Folders()
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
			WebElement ele = getPageObject("Move_Skip_Test");

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
			WebElement drop =driver.findElement(By.xpath("//div[contains(text(),'Skip Data')]"));

			Actions ac = new Actions(driver); ac.dragAndDrop(drag,drop).build().perform();
			Thread.sleep(3000); 
			click("Skip");
			
			Thread.sleep(4000); 
			act.doubleClick(drop).perform();
			List<WebElement> Aftermovedfolders =driver.findElements(By.xpath("//*[@class='folder-article']"));
			int	Aftermovedfolderstofolder = Aftermovedfolders .size();
			System.out.println("No of folders Skip" + Aftermovedfolderstofolder);

			if(Aftermovedfolderstofolder==2)
			{
				
			log.info("--------------------------No of moved folders is Not equal to before------------------------------");

			captureScreenShot(ScreenShotsFilePath +"DragandDropMoveVersions_Skip_Folderss_success.png");
			Thread.sleep(2000);
			ATUReports.add("DragandDropMoveVersions_Skip_Folders successfully","DragandDropMoveVersions_Skip_Folders",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
			Thread.sleep(2000); 
			}
			else 
			{
				captureScreenShot(ScreenShotsFilePath + "DragandDropMoveVersions_Skip_Folders_failed.png");
				Thread.sleep(2000);
				ATUReports.add("DragandDropMoveVersions_Skip_Folders failed","DragandDropMoveVersions_Skip_Folders",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}
			click("Profile_Icon");
			Thread.sleep(1000);
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
			log.error("Error in DragandDropMoveVersions_Skip_Folders",e);	
			//log.fatal(e.getMessage(),e);
			captureScreenShot(ScreenShotsFilePath + "DragandDropMoveVersions_Skip_Folders_failed_Error.png");
			ATUReports.add("DragandDropMoveVersions_Skip_Folders failed","DragandDropMoveVersions_Skip_Folders",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}

	}
}
