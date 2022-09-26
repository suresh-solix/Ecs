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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import arca.common.Navigation;
import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.reports.utils.Utils;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;

public class MyFiles_Collections_Page extends Navigation{
	
	static WebDriver driver;
	static Actions actions;
  

	private static Logger log = Logger.getLogger(MyFiles_Collections_Page.class.getName());
	public static String Home_Page = "https://app.solixecsdev.com/login";
	public MyFiles_Collections_Page(WebDriver driver) {
		super(driver);
		this.driver = driver;
		//driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS).pageLoadTimeout(60, TimeUnit.SECONDS);
		ATUReports.setWebDriver(driver);
		ATUReports.setTestCaseReqCoverage("MyFiles_Collections_Page");
		setIndexPageDescription();
		setAuthorInfoForReports();
		log.info("--------------------MyFiles_Collections_Page--------------------");
		captureScreenShot(ScreenShotsFilePath + "MyFiles_Collections_Page.png");
	}
	private void setAuthorInfoForReports() {
		ATUReports.setAuthorInfo("Mahesh", Utils.getCurrentTime(),"2.0");
	}

	private void setIndexPageDescription() {
		ATUReports.indexPageDescription = "MyFiles_Collections_Page";
	}


		//---------------------------MyFiles_Collections_Page_Create_collections-------------------------------

public static void MyFiles_Collections_Page_Create_collections()
{

	try
	{

		actions = new Actions(driver);
		Actions act = new Actions(driver);

		Navigation.login();

		driver.get(Home_Page);
		WebDriverWait wait5 = new WebDriverWait(driver, 120);
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
		Thread.sleep(1000);

		getPageObject("sidebar_collections").click();
		Thread.sleep(1000);
		click("Plus-Buttom");
		Thread.sleep(1000);

		DateFormat dateFormat = new SimpleDateFormat("MMM-dd HH-mm");

		//get current date time with Date()
		Date date = new Date();

		// Now format the date
		String dateFormatted= dateFormat.format(date);

		String single_file_folder_name="Collection "+dateFormatted;
		
		sendKeys("Create-FolderName",single_file_folder_name);
		Thread.sleep(1000);
		click("Save");
		Thread.sleep(2000);
		
		WebDriverWait wait222 = new WebDriverWait(driver, 60);
		wait222.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Created new collection successfully')]")));
		Thread.sleep(1000);
		click("toast_close");
		
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
		log.error("Error in MyFiles_Collections_Page_Create_collections",e);	
		//log.fatal(e.getMessage(),e);
		captureScreenShot(ScreenShotsFilePath + "MyFiles_Collections_Page_Create_collections_failed_Error.png");
		ATUReports.add("MyFiles_Collections_Page_Create_collections failed","MyFiles_Collections_Page_Create_collections",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	}
}


//---------------------------MyFiles_Collections_Page_Add_Files_To_Collections-------------------------------

public static void MyFiles_Collections_Page_Add_Files_To_Collections()
{

try
{

	actions = new Actions(driver);
	Actions act = new Actions(driver);

	Navigation.login();

	driver.get(Home_Page);
	WebDriverWait wait5 = new WebDriverWait(driver, 120);
	wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
	Thread.sleep(1000);

	getPageObject("sidebar_collections").click();
	Thread.sleep(1000);
	getPageObject("Collections_3dots").click();
	Thread.sleep(1000);
	click("collecctions_Add");
	Thread.sleep(1000);

	
	List<WebElement> Beforemovedfiles = driver.findElements(By.xpath("//div[@class='files-info']"));
	int nooffiles = Beforemovedfiles.size();
	System.out.println("No of files Before Moved" + nooffiles);
	
	getPageObject("file_one").click();

	WebDriverWait wait222 = new WebDriverWait(driver, 60);
	wait222.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='row flitm-list cursor-pointer py-2 my-1'])[1]"))).click();
	Thread.sleep(1000);
	click("Add_collections");
	click("collections_close");
	Thread.sleep(1000);
	WebDriverWait wait2221 = new WebDriverWait(driver, 60);
	wait2221.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Added file(s) to the collection successfully!!')]")));
	Thread.sleep(2000);
	click("toast_close");
	
	
	List<WebElement> Aftermovedfiles = driver.findElements(By.xpath("//div[@class='files-info']"));
	int Aftermovedfilestofolder = Aftermovedfiles.size();
	System.out.println("No of files After " + Aftermovedfilestofolder);
	
	if(Aftermovedfilestofolder==2)
	{


		log.info("--------------------------No of  files is  equal to before------------------------------");

		captureScreenShot(ScreenShotsFilePath + "MyFiles_Collections_Page_Create_collections_success.png");
		Thread.sleep(2000);
		ATUReports.add("MyFiles_Collections_Page_Create_collections successfully","MyFiles_Collections_Page_Create_collections",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		Thread.sleep(2000);
	}

	else 
	{
		captureScreenShot(ScreenShotsFilePath + "MyFiles_Collections_Page_Create_collections_failed.png");
		Thread.sleep(2000);
		ATUReports.add("MyFiles_Collections_Page_Create_collections failed","MyFiles_Collections_Page_Create_collections",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		Thread.sleep(2000);
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
	log.error("Error in MyFiles_Collections_Page_Create_collections",e);	
	//log.fatal(e.getMessage(),e);
	captureScreenShot(ScreenShotsFilePath + "MyFiles_Collections_Page_Create_collections_failed_Error.png");
	ATUReports.add("MyFiles_Collections_Page_Create_collections failed","MyFiles_Collections_Page_Create_collections",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
}
}

		//--------------------MyFiles_Collections_Page_Edit_Rename_collections-----------------------

public static void MyFiles_Collections_Page_Edit_Rename_collections()
{

try
{

	actions = new Actions(driver);
	Actions act = new Actions(driver);

	Navigation.login();

	driver.get(Home_Page);
	WebDriverWait wait5 = new WebDriverWait(driver, 120);
	wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
	Thread.sleep(1000);
	
	getPageObject("sidebar_collections").click();
		
	Thread.sleep(1000);
	getPageObject("Collections_3dots").click();
	Thread.sleep(1000);
	click("Edit_Rename");
	Thread.sleep(1000);
	getPageObject("collections_name_textarea").clear();

	DateFormat dateFormat = new SimpleDateFormat("dd HH-mm");

	//get current date time with Date()
	Date date = new Date();

	// Now format the date
	String dateFormatted= dateFormat.format(date);
	
	String collection_name = "Collection-Rename "+dateFormatted;
	
	sendKeys("collections_name_textarea",collection_name);
	click("Save");
	
	WebDriverWait wait114 = new WebDriverWait(driver, 60);
	wait114.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Collection name has been changed successfully')]")));
	Thread.sleep(2000);
	click("toast_close");
	
	String file2 =driver.findElement(By.xpath("(//div[@class='collection-file-info']//div[@class='fileName'])[1]")).getText();
	System.out.println(file2);
	
	if(collection_name.equals(file2))
	{


		log.info("--------------------------File Name is collection Name------------------------------");

		captureScreenShot(ScreenShotsFilePath + "MyFiles_Collections_Page_Edit_Rename_collections_success.png");
		Thread.sleep(2000);
		ATUReports.add("MyFiles_Collections_Page_Edit_Rename_collections successfully","MyFiles_Collections_Page_Edit_Rename_collections",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		Thread.sleep(2000);
	}

	else 
	{
		captureScreenShot(ScreenShotsFilePath + "MyFiles_Collections_Page_Edit_Rename_collections_failed.png");
		Thread.sleep(2000);
		ATUReports.add("MyFiles_Collections_Page_Edit_Rename_collections failed","MyFiles_Collections_Page_Edit_Rename_collections",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		Thread.sleep(2000);
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
	log.error("Error in MyFiles_Collections_Page_Edit_Rename_collections",e);	
	//log.fatal(e.getMessage(),e);
	captureScreenShot(ScreenShotsFilePath + "MyFiles_Collections_Page_Edit_Rename_collections_failed_Error.png");
	ATUReports.add("MyFiles_Collections_Page_Edit_Rename_collections failed","MyFiles_Collections_Page_Edit_Rename_collections",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
}
}

		//--------------------MyFiles_Collections_Page_Add_Files_And_View_Collections--------------------------

public static void MyFiles_Collections_Page_Add_Files_And_View_Collections()
{

try
{

	actions = new Actions(driver);
	Actions act = new Actions(driver);

	Navigation.login();

	driver.get(Home_Page);
	WebDriverWait wait5 = new WebDriverWait(driver, 120);
	wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
	Thread.sleep(1000);

	getPageObject("sidebar_collections").click();
	Thread.sleep(1000);
	getPageObject("View").click();
	
	List<WebElement> Beforemovedfiles = driver.findElements(By.xpath("//div[@class='files-info']"));
	int nooffiles = Beforemovedfiles.size();
	System.out.println("No of files Before " + nooffiles);
	
	Thread.sleep(1000);
	click("Plus-Buttom");
	getPageObject("File_sec").click();
	WebDriverWait wait222 = new WebDriverWait(driver, 60);
	wait222.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='row flitm-list cursor-pointer py-2 my-1'])[4]"))).click();
	Thread.sleep(1000);
	click("Add_collections");
	click("collections_close");
	Thread.sleep(1000);
	WebDriverWait wait2221 = new WebDriverWait(driver, 60);
	wait2221.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Added file(s) to the collection successfully!!')]")));
	Thread.sleep(2000);
	click("toast_close");
	
	
	List<WebElement> Aftermovedfiles = driver.findElements(By.xpath("//div[@class='files-info']"));
	int Aftermovedfilestofolder = Aftermovedfiles.size();
	System.out.println("No of files After " + Aftermovedfilestofolder);
	
	if(Aftermovedfilestofolder==4)
	{
		log.info("--------------------------No of  files is  equal to before------------------------------");

		captureScreenShot(ScreenShotsFilePath + "MyFiles_Collections_Page_Add_Files_And_View_Collections_success.png");
		Thread.sleep(2000);
		ATUReports.add("MyFiles_Collections_Page_Add_Files_And_View_Collections successfully","MyFiles_Collections_Page_Add_Files_And_View_Collections",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		Thread.sleep(2000);
	}

	else 
	{
		captureScreenShot(ScreenShotsFilePath + "MyFiles_Collections_Page_Add_Files_And_View_Collections_failed.png");
		Thread.sleep(2000);
		ATUReports.add("MyFiles_Collections_Page_Add_Files_And_View_Collections failed","MyFiles_Collections_Page_Add_Files_And_View_Collections",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		Thread.sleep(2000);
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
	log.error("Error in MyFiles_Collections_Page_Add_Files_And_View_Collections",e);	
	//log.fatal(e.getMessage(),e);
	captureScreenShot(ScreenShotsFilePath + "MyFiles_Collections_Page_Add_Files_And_View_Collections_failed_Error.png");
	ATUReports.add("MyFiles_Collections_Page_Add_Files_And_View_Collections failed","MyFiles_Collections_Page_Add_Files_And_View_Collections",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
}
}

		//-----------------------MyFiles_Collections_Page_Download_collections-------------------------

public static void MyFiles_Collections_Page_Download_collections()
{

try
{

	actions = new Actions(driver);
	Actions act = new Actions(driver);

	Navigation.login();

	driver.get(Home_Page);
	WebDriverWait wait5 = new WebDriverWait(driver, 120);
	wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
	Thread.sleep(1000);

	getPageObject("sidebar_collections").click();
	Thread.sleep(1000);
	getPageObject("Collections_3dots").click();
	Thread.sleep(1000);
	click("Collections_Download");
	Thread.sleep(1000);
	
	Thread.sleep(1000);
	WebDriverWait wait2221 = new WebDriverWait(driver, 60);
	wait2221.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Depending on the file/folder size, download might take some time.')]")));
	Thread.sleep(2000);
	click("toast_close");
	Thread.sleep(2000);
	getPageObject("View").click();
	Thread.sleep(1000);
	getPageObject("Collections_View_Download").click();
	WebDriverWait wait22211 = new WebDriverWait(driver, 60);
	wait22211.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Depending on the file/folder size, download might take some time.')]")));
	Thread.sleep(2000);
	click("toast_close");
	
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
	log.error("Error in MyFiles_Collections_Page_Download_collections",e);	
	//log.fatal(e.getMessage(),e);
	captureScreenShot(ScreenShotsFilePath + "MyFiles_Collections_Page_Download_collections_failed_Error.png");
	ATUReports.add("MyFiles_Collections_Page_Download_collections failed","MyFiles_Collections_Page_Download_collections",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
}
}

		//-----------------------MyFiles_Collections_Page_Export_Metedata_in_list_view--------------------

public static void MyFiles_Collections_Page_Export_Metedata_in_list_view()
{

try
{

	actions = new Actions(driver);
	Actions act = new Actions(driver);

	Navigation.login();

	driver.get(Home_Page);
	WebDriverWait wait5 = new WebDriverWait(driver, 120);
	wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
	Thread.sleep(1000);
	// Folder Creating
	click("Plus-Buttom");
	getPageObject("collection_folder").click();
//	click("collection_folder");
	sendKeys("ente_folder_name","Export MetaData ListView");
	click("Ok");		
	WebDriverWait wait22211 = new WebDriverWait(driver, 60);
	wait22211.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Folder is created successfully')]")));
	Thread.sleep(2000);
	click("toast_close");
	
	// Collections
	getPageObject("sidebar_collections").click();
	Thread.sleep(1000);
	getPageObject("Collections_3dots").click();
	Thread.sleep(1000);
	click("Collection_Metadata");
	Thread.sleep(1000);
	
	WebElement el =driver.findElement(By.xpath("//*[@class='cp-list-item']//span[contains(text(),'My Files')]"));
	act.doubleClick(el).perform();
	
	WebElement el1 =driver.findElement(By.xpath("//*[@class='cp-list-item']//span[contains(text(),'Export MetaData ListView')]"));
	act.doubleClick(el1).perform();
	
	getPageObject("Folder_Create").click();
	Thread.sleep(2000);
	
	DateFormat dateFormat = new SimpleDateFormat("MMM-dd HH-mm");

	//get current date time with Date()
	Date date = new Date();

	// Now format the date
	String dateFormatted= dateFormat.format(date);

	String name= "Metadata"+dateFormatted;

	log.info("Creating  name: "+name);

	sendKeys("Create_Folder_name",name);
	Thread.sleep(2000);
	click("Create_button");
	click("Ok");
	Thread.sleep(2000);
	WebDriverWait wait351 = new WebDriverWait(driver, 60);
	wait351.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='Vue-Toastification__toast-body']")));
	Thread.sleep(1000);
	click("toast_close");  
	getPageObject("Menu_MyFiles").click();
	Thread.sleep(1000);
	WebElement el11 = getPageObject("Collection_metadata_folder");
	act.doubleClick(el11).perform();
	Thread.sleep(1000);
	getPageObject("Collection_CSV_file").isDisplayed();
	
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
	log.error("Error in MyFiles_Collections_Page_Export_Metedata_in_list_view",e);	
	//log.fatal(e.getMessage(),e);
	captureScreenShot(ScreenShotsFilePath + "MyFiles_Collections_Page_Export_Metedata_in_list_view_failed_Error.png");
	ATUReports.add("MyFiles_Collections_Page_Export_Metedata_in_list_view failed","MyFiles_Collections_Page_Export_Metedata_in_list_view",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
}
}

		//----------------------MyFiles_Collections_Page_Export_Metedata_in_View_collections-------------------------

public static void MyFiles_Collections_Page_Export_Metedata_in_View_collections()
{

try
{

	actions = new Actions(driver);
	Actions act = new Actions(driver);

	Navigation.login();

	driver.get(Home_Page);
	WebDriverWait wait5 = new WebDriverWait(driver, 120);
	wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
	Thread.sleep(1000);
	
	// Collections
	getPageObject("sidebar_collections").click();
	Thread.sleep(1000);
	getPageObject("Collections_3dots").click();
	Thread.sleep(1000);
	click("Collection_Metadata");
	Thread.sleep(1000);
	
	WebElement el =driver.findElement(By.xpath("//*[@class='cp-list-item']//span[contains(text(),'My Files')]"));
	act.doubleClick(el).perform();
	
	WebElement el1 =driver.findElement(By.xpath("//*[@class='cp-list-item']//span[contains(text(),'Export MetaData ListView')]"));
	act.doubleClick(el1).perform();
	
	getPageObject("Export_folder").click();
	
	click("Ok");
	Thread.sleep(2000);
	WebDriverWait wait351 = new WebDriverWait(driver, 60);
	wait351.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='Vue-Toastification__toast-body']")));
	click("toast_close");  
	Thread.sleep(1000);
	
	getPageObject("Collections_3dots").click();
	Thread.sleep(1000);
	click("Collection_Metadata");
	Thread.sleep(1000);
	
	WebElement el11 =driver.findElement(By.xpath("//*[@class='cp-list-item']//span[contains(text(),'My Files')]"));
	act.doubleClick(el11).perform();
	Thread.sleep(1000);
	WebElement el111 =driver.findElement(By.xpath("//*[@class='cp-list-item']//span[contains(text(),'Export MetaData ListView')]"));
	act.doubleClick(el111).perform();
	Thread.sleep(1000);
	WebElement el12 =getPageObject("Export_folder");
	act.doubleClick(el111).perform();
	Thread.sleep(2000);
	getPageObject("Csv_file").isDisplayed();
	
	click("Ok");
	Thread.sleep(2000);
	WebDriverWait wait3511 = new WebDriverWait(driver, 60);
	wait3511.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='Vue-Toastification__toast-body']")));
	click("toast_close");  
	
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
	log.error("Error in MyFiles_Collections_Page_Export_Metedata_in_list_view",e);	
	//log.fatal(e.getMessage(),e);
	captureScreenShot(ScreenShotsFilePath + "MyFiles_Collections_Page_Export_Metedata_in_list_view_failed_Error.png");
	ATUReports.add("MyFiles_Collections_Page_Export_Metedata_in_list_view failed","MyFiles_Collections_Page_Export_Metedata_in_list_view",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
}
}

		//----------------------MyFiles_Collections_Page_Share_Multiple_files_To_User----------------------

public static void MyFiles_Collections_Page_Share_Multiple_files_To_User()
{

try
{

	actions = new Actions(driver);
	Actions act = new Actions(driver);

	Navigation.login();

	driver.get(Home_Page);
	WebDriverWait wait5 = new WebDriverWait(driver, 120);
	wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
	Thread.sleep(1000);
	
	// Collections
	getPageObject("sidebar_collections").click();
	Thread.sleep(1000);
	getPageObject("View").click();
	Thread.sleep(1000);
	
	List<WebElement> Beforemovedfiles = driver.findElements(By.xpath("//*[@class='files-footer']"));
	int nooffiles = Beforemovedfiles.size();
	System.out.println("No of files Before " + nooffiles);
	
	click("select_all_files");
	Thread.sleep(1000);
	WebElement right=	driver.findElement(By.xpath("(//div[@class='files-info'])[2]"));
	actions.contextClick(right).perform();
	click("Share");
	Thread.sleep(2000);

	WebElement noUserOr = driver.findElement(By.xpath("//input[@placeholder='Search Users or Groups']"));
	noUserOr.sendKeys("li");


	WebDriverWait wait31 = new WebDriverWait(driver, 60);
	wait31.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='multiselect__content']/li[1]")));

	getPageObject("search_result_first_element").click(); 
	Thread.sleep(2000);
	click("share_button");
	Thread.sleep(1000);
	click("share_button");

	WebDriverWait wait222 = new WebDriverWait(driver, 60);
	wait222.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Shared successfully.']")));
	Thread.sleep(2000);
	click("toast_close");
    Thread.sleep(1000);
	click("Profile_Icon");
	Thread.sleep(1000);
	click("Sign_out");
	Thread.sleep(1000);
	click("Ok");
	
	WebDriverWait wait35 = new WebDriverWait(driver, 60);
	wait35.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));
	
	Navigation.other_user_in_same_tenant();

	WebDriverWait wait51 = new WebDriverWait(driver, 120);
	wait51.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
	click("shared_with_me");
	
	List<WebElement> Aftermovedfiles = driver.findElements(By.xpath("//*[@class='files-footer']"));
	int Aftermovedfilestofolder = Aftermovedfiles.size();
	System.out.println("No of files After " + Aftermovedfilestofolder);
	
	if(Aftermovedfilestofolder==nooffiles)
	{


		log.info("--------------------------No of Shared Files is  equal to before ------------------------------");

		captureScreenShot(ScreenShotsFilePath +"MyFiles_Collections_Page_Share_Multiple_files_To_User_success.png");
		Thread.sleep(2000);
		ATUReports.add("MyFiles_Collections_Page_Share_Multiple_files_To_User successfully","MyFiles_Collections_Page_Share_Multiple_files_To_User",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
		Thread.sleep(2000); 
	}
	else 
	{
		captureScreenShot(ScreenShotsFilePath + "MyFiles_Collections_Page_Share_Multiple_files_To_User_failed.png");
		Thread.sleep(2000);
		ATUReports.add("MyFiles_Collections_Page_Share_Multiple_files_To_User failed","MyFiles_Collections_Page_Share_Multiple_files_To_User",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		Thread.sleep(2000);
	}
	click("Profile_Icon");
	Thread.sleep(1000);
	click("Sign_out");
	Thread.sleep(1000);
	click("Ok");
	
	WebDriverWait wait351 = new WebDriverWait(driver, 60);
	wait351.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));

	Navigation.login();

	
	WebDriverWait wait511 = new WebDriverWait(driver, 120);
	wait511.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
	Thread.sleep(1000);
	
	// Collections
	getPageObject("sidebar_collections").click();
	Thread.sleep(1000);
	getPageObject("View").click();
	Thread.sleep(1000);
	
	List<WebElement> Beforemovedfiles1 = driver.findElements(By.xpath("//*[@class='files-footer']"));
	int nooffiles1 = Beforemovedfiles1.size();
	System.out.println("No of files Before Delete" + nooffiles1);
	
	click("select_all_files");
	Thread.sleep(1000);
	WebElement right1=	driver.findElement(By.xpath("(//div[@class='files-info'])[2]"));
	actions.contextClick(right1).perform();
	click("Share");
	Thread.sleep(2000);
	
	WebElement ela =driver.findElement(By.xpath("(//select[@class='custom-select form-control custom-select'])[2]"));
	Select DD = new Select(ela);
	DD.selectByVisibleText("Remove");

	Thread.sleep(2000);
	click("share_button");
	Thread.sleep(1000);
//	click("share_button");

	WebDriverWait wait2221 = new WebDriverWait(driver, 60);
	wait2221.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Shared successfully.']")));
	Thread.sleep(2000);
	click("toast_close");
	Thread.sleep(1000);
	click("Profile_Icon");
	Thread.sleep(1000);
	click("Sign_out");
	Thread.sleep(1000);
	click("Ok");
	
	WebDriverWait wait3511 = new WebDriverWait(driver, 60);
	wait3511.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));

}
catch (Exception e) {

	System.out.println("errror at: ");
	e.printStackTrace();
	log.error("Error in MyFiles_Collections_Page_Share_Multiple_files_To_User",e);	
	//log.fatal(e.getMessage(),e);
	captureScreenShot(ScreenShotsFilePath + "MyFiles_Collections_Page_Share_Multiple_files_To_User_failed_Error.png");
	ATUReports.add("MyFiles_Collections_Page_Share_Multiple_files_To_User failed","MyFiles_Collections_Page_Share_Multiple_files_To_User",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
}
}

		//-------------------MyFiles_Collections_Page_Share_Add_comment_to_file-----------------------

public static void MyFiles_Collections_Page_Share_Add_comment_to_file()
{

try
{

	actions = new Actions(driver);
	Actions act = new Actions(driver);

	Navigation.login();

	driver.get(Home_Page);
	WebDriverWait wait5 = new WebDriverWait(driver, 120);
	wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
	Thread.sleep(1000);
	
	getPageObject("sidebar_collections").click();
	Thread.sleep(1000);
	getPageObject("View").click();
	Thread.sleep(1000);
	click("select_all_files");
	Thread.sleep(1000);
	WebElement right=	driver.findElement(By.xpath("(//div[@class='files-info'])[1]"));
	actions.contextClick(right).perform();
	Thread.sleep(1000);
	click("Add_View_Tags");
	Thread.sleep(1000);
	sendKeys("Add_Tag","Collections-Testing-1");
	click("Save");
	WebDriverWait wait511 = new WebDriverWait(driver, 60);
	wait511.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Updated the tags successfully')]")));
	Thread.sleep(1000);
	click("toast_close");
	Thread.sleep(1000);
	
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
	log.error("Error in MyFiles_Collections_Page_Share_Add_comment_to_file",e);	
	//log.fatal(e.getMessage(),e);
	captureScreenShot(ScreenShotsFilePath + "MyFiles_Collections_Page_Share_Add_comment_to_file_failed_Error.png");
	ATUReports.add("MyFiles_Collections_Page_Share_Add_comment_to_file failed","MyFiles_Collections_Page_Share_Add_comment_to_file",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
}
}

		//-----------------------MyFiles_Collections_Page_Share_Add_Tags_to_multiple_files---------------------------

public static void MyFiles_Collections_Page_Share_Add_Tags_to_multiple_files()
{

try
{

	actions = new Actions(driver);
	Actions act = new Actions(driver);

	Navigation.login();

	driver.get(Home_Page);
	WebDriverWait wait5 = new WebDriverWait(driver, 120);
	wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
	Thread.sleep(1000);
	
	getPageObject("sidebar_collections").click();
	Thread.sleep(1000);
	getPageObject("View").click();
	Thread.sleep(1000);
	
	WebElement right=	driver.findElement(By.xpath("(//div[@class='files-info'])[1]"));
	actions.contextClick(right).perform();
	Thread.sleep(1000);
	click("right_click_add_tag");
	Thread.sleep(1000);
	sendKeys("Add_Tag","Collections Tag");
	click("Save");
	WebDriverWait wait511 = new WebDriverWait(driver, 60);
	wait511.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Updated the tags successfully.')]")));
	Thread.sleep(1000);
	click("toast_close");
	Thread.sleep(1000);
	getPageObject("First-File").click();
	Thread.sleep(1000);
	click("collection_view_Details");
	
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
	log.error("Error in MyFiles_Collections_Page_Share_Add_Tags_to_multiple_files",e);	
	//log.fatal(e.getMessage(),e);
	captureScreenShot(ScreenShotsFilePath + "MyFiles_Collections_Page_Share_Add_Tags_to_multiple_files_failed_Error.png");
	ATUReports.add("MyFiles_Collections_Page_Share_Add_Tags_to_multiple_files failed","MyFiles_Collections_Page_Share_Add_Tags_to_multiple_files",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
}
}

		//---------------------------MyFiles_Collections_Page_Multiple_files_Download----------------------

public static void MyFiles_Collections_Page_Multiple_files_Download()
{

try
{

	actions = new Actions(driver);
	Actions act = new Actions(driver);

	Navigation.login();

	driver.get(Home_Page);
	WebDriverWait wait5 = new WebDriverWait(driver, 120);
	wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
	Thread.sleep(1000);
	
	getPageObject("sidebar_collections").click();
	Thread.sleep(1000);
	getPageObject("View").click();
	Thread.sleep(1000);
	
	WebElement right=	driver.findElement(By.xpath("(//div[@class='files-info'])[1]"));
	actions.contextClick(right).perform();
	Thread.sleep(1000);
	click("Downloads");
	Thread.sleep(1000);		
	
	WebDriverWait wait511 = new WebDriverWait(driver, 60);
	wait511.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Depending on the file/folder size, download might take some time.')]")));
	Thread.sleep(1000);
	click("toast_close");
	
	Thread.sleep(3000);
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
	log.error("Error in MyFiles_Collections_Page_Multiple_files_Download",e);	
	//log.fatal(e.getMessage(),e);
	captureScreenShot(ScreenShotsFilePath + "MyFiles_Collections_Page_Multiple_files_Download_failed_Error.png");
	ATUReports.add("MyFiles_Collections_Page_Multiple_files_Download failed","MyFiles_Collections_Page_Multiple_files_Download",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
}
}

		//------------------MyFiles_Collections_Page_Add_Remainder_To_File--------------------

public static void MyFiles_Collections_Page_Add_Remainder_To_File()
{

try
{

	actions = new Actions(driver);
	Actions act = new Actions(driver);

	Navigation.login();

	driver.get(Home_Page);
	WebDriverWait wait5 = new WebDriverWait(driver, 120);
	wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
	Thread.sleep(1000);
	
	getPageObject("sidebar_collections").click();
	Thread.sleep(1000);
	getPageObject("View").click();
	Thread.sleep(1000);
	
	WebElement right=	driver.findElement(By.xpath("(//div[@class='files-info'])[2]"));
	actions.contextClick(right).perform();
	Thread.sleep(1000);
	click("Add_Remainders");
	DateFormat dateFormat = new SimpleDateFormat("MMM-dd HH-mm");

	//get current date time with Date()
	Date date = new Date();

	// Now format the date
	String dateFormatted= dateFormat.format(date);

	String reminder_name= "Collections Remainder "+dateFormatted;

	log.info("Creating reminder name: "+reminder_name);

	sendKeys("reminder_name",reminder_name);

	click("date_picker");
	Thread.sleep(2000);
	click("pick_today_next_date");
	Thread.sleep(2000);
	click("active_hours");
	Thread.sleep(2000);
	click("active_minutes");
	Thread.sleep(2000);
	click("frequency_period_icon");
	Thread.sleep(2000);
	select("frequency_period_dropdown","visibletext","Daily");
	Thread.sleep(2000);
	click("create_reminder_button");

	WebDriverWait wait22 = new WebDriverWait(driver, 60);
	wait22.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Reminder added successfully.')]")));
	Thread.sleep(2000);
	click("toast_close");
	Thread.sleep(1000);
	click("toast_close");
	Thread.sleep(2000);
	getPageObject("Remainder_file_icon").isDisplayed();
	
	Thread.sleep(2000);
	click("Profile_Icon");
	Thread.sleep(1000);
	click("Sign_out");
	Thread.sleep(1000);
	click("Ok");
	
	WebDriverWait wait35 = new WebDriverWait(driver, 120);
	wait35.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));

	
}
catch (Exception e) {

	System.out.println("errror at: ");
	e.printStackTrace();
	log.error("Error in MyFiles_Collections_Page_Add_Remainder_To_File",e);	
	//log.fatal(e.getMessage(),e);
	captureScreenShot(ScreenShotsFilePath + "MyFiles_Collections_Page_Add_Remainder_To_File_failed_Error.png");
	ATUReports.add("MyFiles_Collections_Page_Add_Remainder_To_File failed","MyFiles_Collections_Page_Add_Remainder_To_File",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
}
}

		//------------------------MyFiles_Collections_Page_File_Rename------------------
public static void MyFiles_Collections_Page_File_Rename()
{

try
{

	actions = new Actions(driver);
	Actions act = new Actions(driver);

	Navigation.login();

	driver.get(Home_Page);
	WebDriverWait wait5 = new WebDriverWait(driver, 120);
	wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
	Thread.sleep(1000);
	
	getPageObject("sidebar_collections").click();
	Thread.sleep(1000);
	getPageObject("View").click();
	Thread.sleep(1000);
	
	String file1 =driver.findElement(By.xpath("(//div[@class='fileName'])[2]")).getText();
	System.out.println(file1);
	
	WebElement right=	driver.findElement(By.xpath("(//div[@class='files-info'])[2]"));
	actions.contextClick(right).perform();
	Thread.sleep(1000);
	click("File_Rename");
	getPageObject("rename_file_textarea").clear();
	sendKeys("Rename_input","Collections");
	click("Save");
	Thread.sleep(1000);
	
	WebDriverWait wait22 = new WebDriverWait(driver, 60);
	wait22.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'EmailBackupWizard_kmulti Renamed to Collections.')]")));
	Thread.sleep(1000);
	click("toast_close");
	
	String file2 =driver.findElement(By.xpath("(//div[@class='fileName'])[2]")).getText();
	System.out.println(file2);
	
	if(!file1.equals(file2))
	{


		log.info("--------------------------No of  file name is not equal to before------------------------------");

		captureScreenShot(ScreenShotsFilePath + "MyFiles_Collections_Page_File_Rename_success.png");
		Thread.sleep(2000);
		ATUReports.add("MyFiles_Collections_Page_File_Rename successfully","MyFiles_Collections_Page_File_Rename",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		Thread.sleep(2000);
	}

	else 
	{
		captureScreenShot(ScreenShotsFilePath + "MyFiles_Collections_Page_File_Rename_failed.png");
		Thread.sleep(2000);
		ATUReports.add("MyFiles_Collections_Page_File_Rename failed","MyFiles_Collections_Page_File_Rename",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		Thread.sleep(2000);
	}
	Thread.sleep(1000);

	
	Thread.sleep(2000);
	click("Profile_Icon");
	Thread.sleep(1000);
	click("Sign_out");
	Thread.sleep(1000);
	click("Ok");
	
	WebDriverWait wait35 = new WebDriverWait(driver, 120);
	wait35.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));

	
}
catch (Exception e) {

	System.out.println("errror at: ");
	e.printStackTrace();
	log.error("Error in MyFiles_Collections_Page_File_Rename",e);	
	//log.fatal(e.getMessage(),e);
	captureScreenShot(ScreenShotsFilePath + "MyFiles_Collections_Page_File_Rename_failed_Error.png");
	ATUReports.add("MyFiles_Collections_Page_File_Rename failed","MyFiles_Collections_Page_File_Rename",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
}
}

		//-------------------MyFiles_Collections_Page_File_View_Versions-------------------

public static void MyFiles_Collections_Page_File_View_Versions()
{

try
{

	actions = new Actions(driver);
	Actions act = new Actions(driver);

	Navigation.login();

	driver.get(Home_Page);
	WebDriverWait wait5 = new WebDriverWait(driver, 120);
	wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
	Thread.sleep(1000);
	
	getPageObject("sidebar_collections").click();
	Thread.sleep(1000);
	getPageObject("View").click();
	Thread.sleep(1000);
	
	List<WebElement> Beforemovedfiles = driver.findElements(By.xpath("//*[@class='files-footer']"));
	int nooffiles = Beforemovedfiles.size();
	System.out.println("No of files Before Moved" + nooffiles);
	

	
	for(int i=1; i<=nooffiles; i++)
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

	Thread.sleep(2000);
	click("Profile_Icon");
	Thread.sleep(1000);
	click("Sign_out");
	Thread.sleep(1000);
	click("Ok");
	
	WebDriverWait wait35 = new WebDriverWait(driver, 120);
	wait35.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));

	
}
catch (Exception e) {

	System.out.println("errror at: ");
	e.printStackTrace();
	log.error("Error in MyFiles_Collections_Page_File_View_Versions",e);	
	//log.fatal(e.getMessage(),e);
	captureScreenShot(ScreenShotsFilePath + "MyFiles_Collections_Page_File_View_Versions_failed_Error.png");
	ATUReports.add("MyFiles_Collections_Page_File_View_Versions failed","MyFiles_Collections_Page_File_View_Versions",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
}
}
		//--------------------MyFiles_Collections_Page_Multipl_Files_Trash------------------------

public static void MyFiles_Collections_Page_Multipl_Files_Trash()
{

try
{

	actions = new Actions(driver);
	Actions act = new Actions(driver);

	Navigation.login();

	driver.get(Home_Page);
	WebDriverWait wait5 = new WebDriverWait(driver, 120);
	wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
	Thread.sleep(1000);
	
	getPageObject("sidebar_collections").click();
	Thread.sleep(1000);
	getPageObject("View").click();
	Thread.sleep(1000);
	
	List<WebElement> Beforemovedfiles = driver.findElements(By.xpath("//*[@class='files-footer']"));
	int nooffiles = Beforemovedfiles.size();
	System.out.println("No of files Before " + nooffiles);
	click("select_all_files");
	
	Thread.sleep(1000);
	getPageObject("Remove_from_collection").click();
	click("folder_ok_button");
	
	WebDriverWait wait22 = new WebDriverWait(driver, 60);
	wait22.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Removed file(s) from collection successfully.')]")));
	Thread.sleep(1000);
	click("toast_close");
	
	List<WebElement> Aftermovedfiles = driver.findElements(By.xpath("//*[@class='files-footer']"));
	int Aftermovedfilestofolder = Aftermovedfiles.size();
	System.out.println("No of files After " + Aftermovedfilestofolder);
	
	if(nooffiles!=Aftermovedfilestofolder)
	{
		log.info("--------------------------No of  files is equal to before------------------------------");

		captureScreenShot(ScreenShotsFilePath + "MyFiles_Collections_Page_Multipl_Files_Trash_success.png");
		Thread.sleep(2000);
		ATUReports.add("MyFiles_Collections_Page_Multipl_Files_Trash successfully","MyFiles_Collections_Page_Multipl_Files_Trash",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		Thread.sleep(2000);
	}
	else
	{
		captureScreenShot(ScreenShotsFilePath + "MyFiles_Collections_Page_Multipl_Files_Trash_failed.png");
		Thread.sleep(2000);
		ATUReports.add("MyFiles_Collections_Page_Multipl_Files_Trash failed","MyFiles_Collections_Page_Multipl_Files_Trash",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		Thread.sleep(2000);
	}

	
	Thread.sleep(2000);
	click("Profile_Icon");
	Thread.sleep(1000);
	click("Sign_out");
	Thread.sleep(1000);
	click("Ok");
	
	WebDriverWait wait35 = new WebDriverWait(driver, 120);
	wait35.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));

	
}
catch (Exception e) {

	System.out.println("errror at: ");
	e.printStackTrace();
	log.error("Error in MyFiles_Collections_Page_Multipl_Files_Trash",e);	
	//log.fatal(e.getMessage(),e);
	captureScreenShot(ScreenShotsFilePath + "MyFiles_Collections_Page_Multipl_Files_Trash_failed_Error.png");
	ATUReports.add("MyFiles_Collections_Page_Multipl_Files_Trash failed","MyFiles_Collections_Page_Multipl_Files_Trash",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
}
}


		//----------------------MyFiles_Collections_Page_Remove_Collections--------------------------

public static void MyFiles_Collections_Page_Remove_Collections()
{

try
{

	actions = new Actions(driver);
	Actions act = new Actions(driver);

	Navigation.login();

	driver.get(Home_Page);
	WebDriverWait wait5 = new WebDriverWait(driver, 120);
	wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
	Thread.sleep(1000);

	getPageObject("sidebar_collections").click();
	Thread.sleep(1000);
	getPageObject("Collections_3dots").click();
	Thread.sleep(1000);
	getPageObject("Collections_Dropdown_Remove").click();
	Thread.sleep(1000);
	click("Ok");
	
	WebDriverWait wait22211 = new WebDriverWait(driver, 60);
	wait22211.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Deleted collection successfully.')]")));
	Thread.sleep(2000);
	click("toast_close");
	
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
	log.error("Error in MyFiles_Collections_Page_Remove_Collections",e);	
	//log.fatal(e.getMessage(),e);
	captureScreenShot(ScreenShotsFilePath + "MyFiles_Collections_Page_Remove_Collections_failed_Error.png");
	ATUReports.add("MyFiles_Collections_Page_Remove_Collections failed","MyFiles_Collections_Page_Remove_Collections",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
}
}
}