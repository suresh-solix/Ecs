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


public class MyFiles_Collection extends Navigation {

	static WebDriver driver;
	static Actions actions;
  

	private static Logger log = Logger.getLogger(MyFiles_Collection.class.getName());
	public static String Home_Page = "https://app.solixecsdev.com/login";
	public MyFiles_Collection(WebDriver driver) {
		super(driver);
		this.driver = driver;
		//driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS).pageLoadTimeout(60, TimeUnit.SECONDS);
		ATUReports.setWebDriver(driver);
		ATUReports.setTestCaseReqCoverage("MyFiles_Collection");
		setIndexPageDescription();
		setAuthorInfoForReports();
		log.info("--------------------MyFiles_Collection--------------------");
		captureScreenShot(ScreenShotsFilePath + "MyFiles_Collection.png");
	}
	private void setAuthorInfoForReports() {
		ATUReports.setAuthorInfo("Mahesh", Utils.getCurrentTime(),"2.0");
	}

	private void setIndexPageDescription() {
		ATUReports.indexPageDescription = "MyFiles_Collection";
	}




  //---------------------------------------MyFiles_Collection----------------------------
public static void MyFiles_Collection()
{

	try
	{

		actions = new Actions(driver);

		Navigation.login();

		driver.get(Home_Page);
		WebDriverWait wait5 = new WebDriverWait(driver, 120);
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
		
		List<WebElement> Beforemovedfiles = driver.findElements(By.xpath("//*[@class='files-footer']"));
		int nooffiles = Beforemovedfiles.size();
 //		System.out.println("No of files Before Moved" + nooffiles);
		click("select_all_files");

		for(int i=2; i<=nooffiles-1; i++)
		{
			driver.findElement(By.xpath("(//div[@class='files']//*[@type='checkbox'])["+i+"]")).click();
		}
		
		int j=nooffiles-1;
		WebElement right=	driver.findElement(By.xpath("(//div[@class='files-info'])["+j+"]"));
		actions.contextClick(right).perform();
		WebElement Addtocollections =	driver.findElement(By.xpath("(//span[contains(text(),'Add to Collection')])["+j+"]"));
		actions.moveToElement(Addtocollections).perform();
		Thread.sleep(2000);
		
		WebElement Create = driver.findElement(By.xpath("(//*[contains(text(),'Create New Collection')])"));
		Create.click();
		Thread.sleep(2000);
		DateFormat dateFormat = new SimpleDateFormat("MMM-dd HH-mm");

		//get current date time with Date()
		Date date = new Date();

		// Now format the date
		String dateFormatted= dateFormat.format(date);
		
		String collection_folder_name="collection "+dateFormatted;
		sendKeys("collections_name_textarea",collection_folder_name);
		
		click("Save");
		Thread.sleep(2000);
		WebElement close = driver.findElement(By.xpath("//*[@class='Vue-Toastification__close-button']"));
		close.click();
		Thread.sleep(2000);
		click("collections");
		Thread.sleep(2000);
		click("views");
		Thread.sleep(2000);
		
	}
	catch (Exception e) {

		System.out.println("errror at: ");
		e.printStackTrace();
		log.error("Error in MyFiles_Collection",e);	
		//log.fatal(e.getMessage(),e);
		captureScreenShot(ScreenShotsFilePath + "MyFiles_Collection_failed_Error.png");
		ATUReports.add("MyFiles_Collection failed","MyFiles_Collection",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	}

}
}
		
