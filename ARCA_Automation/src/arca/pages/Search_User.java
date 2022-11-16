package arca.pages;

import static org.testng.Assert.assertEquals;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.text.DateFormatter;

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

public class Search_User extends Navigation{
	
	static WebDriver driver;
	static Actions actions;
  

	private static Logger log = Logger.getLogger(Search_User.class.getName());
	public static String Home_Page = "https://app.solixecsdev.com/login";
	public Search_User(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
	//	driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS).pageLoadTimeout(60, TimeUnit.SECONDS);
		ATUReports.setWebDriver(driver);
		ATUReports.setTestCaseReqCoverage("Search_User");
		setIndexPageDescription();
		setAuthorInfoForReports();
		log.info("--------------------Search_User--------------------");
		captureScreenShot(ScreenShotsFilePath + "Search_User.png");
	}
	private void setAuthorInfoForReports()
	{
		ATUReports.setAuthorInfo("Mahesh", Utils.getCurrentTime(),"2.0");
	}

	private void setIndexPageDescription()
	{
		ATUReports.indexPageDescription = "Search_User";
	}

	
	
	
			//------------------------------Search_with_Keyword-------------------------------
	
	
	public static void Search_with_Keyword() 
	{

		try
		{

			actions = new Actions(driver);

			Navigation.login();

			driver.get(Home_Page);
			WebDriverWait wait5 = new WebDriverWait(driver, 120);
			wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
			Thread.sleep(2000);
			
			getPageObject("Search_ECS").click();
			sendKeys("Search_ECS","sample");
			//Enter Key
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
			
			List<WebElement> Beforefolders = driver.findElements(By.xpath("//article[@class='folder-article']"));
			int nooffiles = Beforefolders.size();
			System.out.println("No of Folders " + nooffiles);
			
			List<WebElement> Beforefiles = driver.findElements(By.xpath("//*[@class='files-footer']"));
			int nooffiles1 = Beforefiles.size();
			System.out.println("No of files " + nooffiles1);
			
			WebElement all_folders1 = getPageObject("folder_names");
			List<WebElement> each_folder1=all_folders1.findElements(By.tagName("div"));

			for(int i=0;i<each_folder1.size();i++)
			{
				WebElement each_div =each_folder1.get(i);
				String selected_folder_name = each_div.getText();
				//log.info("--------------------"+selected_folder_name);
				//if(selected_folder_name.contains("Add Mul files copy"))
				if(selected_folder_name.equals("Add Mul files copy"))
				{
					
					actions.doubleClick(each_folder1.get(i)).perform();
					Thread.sleep(2000);

					break;
					
				}
			 }
				
	
			Thread.sleep(3000);
		}

		catch (Exception e)
		{

			System.out.println("errror at: ");
			e.printStackTrace();
			log.error("Error in Search_with_Keyword",e);	
			//log.fatal(e.getMessage(),e);
			captureScreenShot(ScreenShotsFilePath + "Search_with_Keyword_failed_Error.png");
			ATUReports.add("Search_with_Keyword failed","Search_with_Keyword",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}
	}

	
				//---------------------------Search_with_content_Search----------------------------
	
	
public static void Search_with_content_Search() 
{

	try
	{

		actions = new Actions(driver);

		Navigation.login();

		driver.get(Home_Page);
		WebDriverWait wait5 = new WebDriverWait(driver, 120);
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
		Thread.sleep(2000);
		
		getPageObject("Search_ECS").click();
		sendKeys("Search_ECS","ECS");
		//Enter Key
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
	//	click("file_name");
		WebElement right=	getPageObject("file_name");
		actions.contextClick(right).perform();
		click("click_preview");
		Thread.sleep(3000);
		click("Preview_Search");
		sendKeys("Previous_search_dropdown","ECS");
				//Enter Key
				Robot r1 = new Robot();
				r1.keyPress(KeyEvent.VK_ENTER);
				r1.keyRelease(KeyEvent.VK_ENTER);
		
	}

	catch (Exception e)
	{

		System.out.println("errror at: ");
		e.printStackTrace();
		log.error("Error in Search_with_content_Search",e);	
		//log.fatal(e.getMessage(),e);
		captureScreenShot(ScreenShotsFilePath + "Search_with_content_Search_failed_Error.png");
		ATUReports.add("Search_with_content_Search failed","Search_with_content_Search",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	}
}


	
			//------------------------------Advanced_Search_in_Name_Field------------------------------
	
	
public static void Advanced_Search_in_Name_Field() 
{

	try
	{

		actions = new Actions(driver);

		Navigation.login();

		driver.get(Home_Page);
		WebDriverWait wait5 = new WebDriverWait(driver, 120);
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
		Thread.sleep(2000);
		
		getPageObject("search_Dropdown").click();
		
	
	//	getPageObject("Advance_Search_name").click();
		String sa ="sample";
		
		sendKeys("Advance_Search_name",sa);
		Thread.sleep(1000);
		
		Actions at = new Actions(driver);
		at.sendKeys(Keys.PAGE_DOWN).build().perform();
		Thread.sleep(1000);
		
		getPageObject("Advance_Button_Search").click();
		
		List<WebElement> Beforefolders = driver.findElements(By.xpath("//article[@class='folder-article']"));
		int nooffiles = Beforefolders.size();
		System.out.println("No of Folders " + nooffiles);
		
		List<WebElement> Beforefiles = driver.findElements(By.xpath("//*[@class='files-footer']"));
		int nooffiles1 = Beforefiles.size();
		System.out.println("No of files " + nooffiles1);
		
		WebElement all_folders1 = getPageObject("Folder_names");
		List<WebElement> each_folder1=all_folders1.findElements(By.tagName("div"));

		for(int i=0;i<each_folder1.size();i++)
		{
			WebElement each_div =each_folder1.get(i);
			String selected_folder_name = each_div.getText();
			//log.info("--------------------"+selected_folder_name);
			//if(selected_folder_name.contains("Add Mul files copy"))
			if(selected_folder_name.equals("Folders"))
			{
				
				actions.doubleClick(each_folder1.get(i)).perform();
				Thread.sleep(2000);

				break;
				
			}
		 }
	
		Thread.sleep(3000);
		WebElement all_files = getPageObject("Folder_names");
		List<WebElement> each_file1=all_files.findElements(By.tagName("div"));

		for(int i=0;i<each_file1.size();i++)
		{
			WebElement each_div =each_file1.get(i);
			String selected_file_name = each_div.getText();
			//log.info("--------------------"+selected_folder_name);
			//if(selected_folder_name.contains("Add Mul files copy"))
			if(selected_file_name.equals("Files"))
			{
				
				actions.doubleClick(each_file1.get(i)).perform();
				Thread.sleep(2000);

				break;
				
			}
		 }
		
	}

	catch (Exception e)
	{

		System.out.println("errror at: ");
		e.printStackTrace();
		log.error("Error in Advanced_Search_in_Name_Field",e);	
		//log.fatal(e.getMessage(),e);
		captureScreenShot(ScreenShotsFilePath + "Advanced_Search_in_Name_Field_failed_Error.png");
		ATUReports.add("Advanced_Search_in_Name_Field failed","Advanced_Search_in_Name_Field",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	}
}

	
			//----------------------------Advanced_Search_in_Word_search-------------------------------
	
	
public static void Advanced_Search_in_Word_search() 
{

	try
	{

		actions = new Actions(driver);

		Navigation.login();

		driver.get(Home_Page);
		WebDriverWait wait5 = new WebDriverWait(driver, 120);
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
		Thread.sleep(2000);
		
		getPageObject("search_Dropdown").click();

		String sa ="sample";
		
		sendKeys("Advance_search_Has_the_words",sa);
		Thread.sleep(1000);
		
		Actions at = new Actions(driver);
		at.sendKeys(Keys.PAGE_DOWN).build().perform();
		Thread.sleep(1000);
		
		getPageObject("Advance_Button_Search").click();
		
		// Total  Files Count
		List<WebElement> Beforefiles = driver.findElements(By.xpath("//*[@class='files-footer']"));
		int nooffiles1 = Beforefiles.size();
		System.out.println("No of files " + nooffiles1);
		
		WebElement right1=	driver.findElement(By.xpath("(//div[@class='files-info'])[2]"));
		actions.contextClick(right1).perform();
		
		Thread.sleep(2000);
		click("click_preview");
		
		for(int i=0; i<=nooffiles1; i++)
		{
			
			Thread.sleep(1000);
			click("Arrow_Right");
		}
		Thread.sleep(1000);
		click("Left_Back");
		Thread.sleep(1000);
		click("Profile_Icon");
		Thread.sleep(2000);
		click("Sign_out");
		Thread.sleep(1000);
		click("Ok");

		WebDriverWait wait35 = new WebDriverWait(driver, 120);
		wait35.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));

		
	}

	catch (Exception e)
	{

		System.out.println("errror at: ");
		e.printStackTrace();
		log.error("Error in Advanced_Search_in_Word_search",e);	
		//log.fatal(e.getMessage(),e);
		captureScreenShot(ScreenShotsFilePath + "Advanced_Search_in_Word_search_failed_Error.png");
		ATUReports.add("Advanced_Search_in_Word_search failed","Advanced_Search_in_Word_search",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	}
}


		//--------------------------Advanced_Search_Tags_Files_and_Folders----------------------------------

public static void Advanced_Search_Tags_Files_and_Folders() 
{

	try
	{

		actions = new Actions(driver);

		Navigation.login();

		driver.get(Home_Page);
		WebDriverWait wait5 = new WebDriverWait(driver, 120);
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
		Thread.sleep(2000);
		
		// Folder Tag Name
		WebElement right1=	getPageObject("Folder_sample");
		actions.contextClick(right1).perform();
		click("right_click_add_tag");
		sendKeys("Add_Tag","Test");
		click("Tag_save_button");
		Thread.sleep(1000);
		WebDriverWait wait5111 = new WebDriverWait(driver, 60);
		wait5111.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Updated the tags successfully.')]")));
		Thread.sleep(1000);
		click("toast_close");
		Thread.sleep(4000);
		
		// File Tag Name
		WebElement right11=	getPageObject("Folder_sample");
		actions.doubleClick(right11).perform();
		WebElement right111=	getPageObject("Folder_sample");
		actions.contextClick(right111).perform();
		click("right_click_add_tag");
		sendKeys("Add_Tag","Test");
		click("Tag_save_button");
		Thread.sleep(1000);
		WebDriverWait wait511 = new WebDriverWait(driver, 60);
		wait5111.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Updated the tags successfully.')]")));
		Thread.sleep(1000);
		click("toast_close");
		
		getPageObject("search_Dropdown").click();

		String sa ="sample";
		sendKeys("Advance_search_Tag_as",sa);
		Thread.sleep(1000);
		
		Actions at = new Actions(driver);
		at.sendKeys(Keys.PAGE_DOWN).build().perform();
		Thread.sleep(1000);
		getPageObject("Advance_Button_Search").click();
		click("sorting_view_details");
		Thread.sleep(2000);
		
		
		
		
	}

	catch (Exception e)
	{

		System.out.println("errror at: ");
		e.printStackTrace();
		log.error("Error in Advanced_Search_Tags_Files_and_Folders",e);	
		//log.fatal(e.getMessage(),e);
		captureScreenShot(ScreenShotsFilePath + "Advanced_Search_Tags_Files_and_Folders_failed_Error.png");
		ATUReports.add("Advanced_Search_Tags_Files_and_Folders failed","Advanced_Search_Tags_Files_and_Folders",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	}
}

		//------------------------------Advanced_Search_Photos_and_Images----------------------------------

public static void Advanced_Search_Photos_and_Images() 
{

	try
	{

		actions = new Actions(driver);

		Navigation.login();

		driver.get(Home_Page);
		WebDriverWait wait5 = new WebDriverWait(driver, 120);
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
		Thread.sleep(2000);
		getPageObject("search_Dropdown").click();
		Thread.sleep(1000);
		getPageObject("Advane_search_File_type").click();
		Thread.sleep(2000);
		click("advance_photos_images");
		Thread.sleep(2000);
		getPageObject("Advane_search_File_type").click();
		getPageObject("Advance_Button_Search").click();
		Thread.sleep(3000);
		
		List<WebElement> files = driver.findElements(By.xpath("//div[@class='fileName']"));
		int Files1 = files.size();
		System.out.println("No of files " + Files1);

		java.util.Iterator<WebElement> i = files.iterator();
		while(i.hasNext())
		{
		    WebElement row = i.next();
		    String alltext = row.getText();
		    
		    if(alltext.contains(".gif") || alltext.contains(".png")||alltext.contains(".jpeg")||alltext.contains(".jpg")||alltext.contains(".bmp")||alltext.contains(".tiff")||alltext.contains(".tif")||alltext.contains(".psd")||alltext.contains(".eps")||alltext.contains(".indd")||alltext.contains(".cr2")||alltext.contains(".crw")||alltext.contains(".nef")||alltext.contains(".pef")||alltext.contains(".ai")||alltext.contains(".ico")||alltext.contains(".svg"))
		    	{
		    		System.out.println("File comparision is satisfy :"+alltext);
					Thread.sleep(1000);
					ATUReports.add("alltext successfull","alltext",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

		    	}
		    else
		    	{
		    		System.out.println("not satisfying the conditon :"+alltext);
					Thread.sleep(1000);
					ATUReports.add("alltext successfull","alltext",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

		    	}
		}		
		
	}	
	catch (Exception e)
	{

		System.out.println("errror at: ");
		e.printStackTrace();
		log.error("Error in Advanced_Search_Photos_and_Images",e);	
		//log.fatal(e.getMessage(),e);
		captureScreenShot(ScreenShotsFilePath + "Advanced_Search_Photos_and_Images_failed_Error.png");
		ATUReports.add("Advanced_Search_Photos_and_Images failed","Advanced_Search_Photos_and_Images",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	}
}

			//----------------------------Advanced_Search_Pdf_files---------------------------

public static void Advanced_Search_Pdf_files() 
{

	try
	{

		actions = new Actions(driver);

		Navigation.login();

		driver.get(Home_Page);
		WebDriverWait wait5 = new WebDriverWait(driver, 120);
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
		Thread.sleep(2000);
		
		getPageObject("search_Dropdown").click();
		Thread.sleep(1000);
		getPageObject("Advane_search_File_type").click();
		Thread.sleep(2000);
		click("advance_Pdfs");
		Thread.sleep(2000);
		getPageObject("Advane_search_File_type").click();
		Thread.sleep(1000);
		getPageObject("Advance_Button_Search").click();
		Thread.sleep(3000);
		
		List<WebElement> files = driver.findElements(By.xpath("//div[@class='fileName']"));
		int Files1 = files.size();
		System.out.println("No of files " + Files1);
		
		java.util.Iterator<WebElement> i = files.iterator();
		while(i.hasNext())
		{
		    WebElement row = i.next();
		    String alltext = row.getText();
		    
		    if(alltext.contains(".pdf") )
		    	{
		    		System.out.println("File comparision is satisfy :"+alltext);
					Thread.sleep(1000);
					ATUReports.add("alltext successfull","alltext",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

		    	}
		    else
		    	{
		    		System.out.println("not satisfying the conditon :"+alltext);
					Thread.sleep(1000);
					ATUReports.add("alltext failed","alltext",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

		    	}
		}		
		
	}

	catch (Exception e)
	{

		System.out.println("errror at: ");
		e.printStackTrace();
		log.error("Error in Advanced_Search_Pdf_files",e);	
		//log.fatal(e.getMessage(),e);
		captureScreenShot(ScreenShotsFilePath + "Advanced_Search_Pdf_files_failed_Error.png");
		ATUReports.add("Advanced_Search_Pdf_files failed","Advanced_Search_in_Name_Field",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	}
}


			//----------------------------------Advanced_Search_Dockments_Files-----------------------------------


public static void Advanced_Search_Dockments_Files() 
{

	try
	{

		actions = new Actions(driver);

		Navigation.login();

		driver.get(Home_Page);
		WebDriverWait wait5 = new WebDriverWait(driver, 120);
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
		Thread.sleep(2000);
		
		getPageObject("search_Dropdown").click();
		Thread.sleep(1000);
		getPageObject("Advane_search_File_type").click();
		Thread.sleep(2000);
		click("advance_Dockments");
		Thread.sleep(2000);
		getPageObject("Advane_search_File_type").click();
		Thread.sleep(1000);
		getPageObject("Advance_Button_Search").click();
		Thread.sleep(3000);
		
		List<WebElement> files = driver.findElements(By.xpath("//div[@class='fileName']"));
		int Files1 = files.size();
		System.out.println("No of files " + Files1);
		
		java.util.Iterator<WebElement> i = files.iterator();
		while(i.hasNext())
		{
		    WebElement row = i.next();
		    String alltext = row.getText();
		    
		    if(alltext.contains(".doc")||alltext.contains(".docx")||alltext.contains(".odt")||alltext.contains(".rtf")||alltext.contains(".tex")||alltext.contains(".txt")||alltext.contains(".wpd"))
		    	{
		    		System.out.println("File comparision is satisfy : "+alltext);
					Thread.sleep(1000);
					ATUReports.add("alltext successfull","alltext",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

		    	}
		    else
		    	{
		    		System.out.println("not satisfying the conditon : "+alltext);
					Thread.sleep(1000);
					ATUReports.add("alltext failed","alltext",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

		    	}
		}		

		
	}

	catch (Exception e)
	{

		System.out.println("errror at: ");
		e.printStackTrace();
		log.error("Error in Advanced_Search_Dockments_Files",e);	
		//log.fatal(e.getMessage(),e);
		captureScreenShot(ScreenShotsFilePath + "Advanced_Search_Dockments_Files_failed_Error.png");
		ATUReports.add("Advanced_Search_Dockments_Files failed","Advanced_Search_Dockments_Files",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	}
}



			//----------------------------------Advanced_Search_Spreadsheets_Files-----------------------------------


public static void Advanced_Search_Spreadsheets_Files() 
{

	try
	{

		actions = new Actions(driver);

		Navigation.login();

		driver.get(Home_Page);
		WebDriverWait wait5 = new WebDriverWait(driver, 120);
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
		Thread.sleep(2000);
		
		getPageObject("search_Dropdown").click();
		Thread.sleep(1000);
		getPageObject("Advane_search_File_type").click();
		Thread.sleep(2000);
		click("advance_spreadsheets");
		Thread.sleep(2000);
		getPageObject("Advane_search_File_type").click();
		Thread.sleep(1000);
		getPageObject("Advance_Button_Search").click();
		Thread.sleep(3000);
		
		List<WebElement> files = driver.findElements(By.xpath("//div[@class='fileName']"));
		int Files1 = files.size();
		System.out.println("No of files " + Files1);
		
		java.util.Iterator<WebElement> i = files.iterator();
		while(i.hasNext())
		{
		    WebElement row = i.next();
		    String alltext = row.getText();
		    
		    if(alltext.contains(".ods")||alltext.contains(".xls")||alltext.contains(".xlsm")||alltext.contains(".xlsx")||alltext.contains(".csv"))
		    	{
		    		System.out.println("File comparision is satisfy : "+alltext);
					Thread.sleep(1000);
					ATUReports.add("alltext successfull","alltext",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		    	}
		    else
		    	{
		    		System.out.println("not satisfying the conditon : "+alltext);
					Thread.sleep(1000);
					ATUReports.add("alltext failed","alltext",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		    	}
		}		

		
	}

	catch (Exception e)
	{

		System.out.println("errror at: ");
		e.printStackTrace();
		log.error("Error in Advanced_Search_Spreadsheets_Files",e);	
		//log.fatal(e.getMessage(),e);
		captureScreenShot(ScreenShotsFilePath + "Advanced_Search_Spreadsheets_Files_failed_Error.png");
		ATUReports.add("Advanced_Search_Spreadsheets_Files failed","Advanced_Search_Spreadsheets_Files",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	}
}


//----------------------------------Advanced_Search_Presentation_Files-----------------------------------


public static void Advanced_Search_Presentation_Files() 
{

	try
	{

		actions = new Actions(driver);

		Navigation.login();

		driver.get(Home_Page);
		WebDriverWait wait5 = new WebDriverWait(driver, 120);
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
		Thread.sleep(2000);
		
		getPageObject("search_Dropdown").click();
		Thread.sleep(1000);
		getPageObject("Advane_search_File_type").click();
		Thread.sleep(2000);
		click("advance_Presentations");
		Thread.sleep(2000);
		getPageObject("Advane_search_File_type").click();
		Thread.sleep(1000);
		getPageObject("Advance_Button_Search").click();
		Thread.sleep(3000);
		
		List<WebElement> files = driver.findElements(By.xpath("//div[@class='fileName']"));
		int Files1 = files.size();
		System.out.println("No of files " + Files1);
		
		java.util.Iterator<WebElement> i = files.iterator();
		while(i.hasNext())
		{
		    WebElement row = i.next();
		    String alltext = row.getText();
		    
		    if(alltext.contains(".key")||alltext.contains(".odp")||alltext.contains(".pps")||alltext.contains(".ppt")||alltext.contains(".pptx"))
		    	{
		    		System.out.println("File comparision is satisfy : "+alltext);
					Thread.sleep(1000);
					ATUReports.add("alltext successfull","alltext",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		    	}
		    else
		    	{
		    		System.out.println("not satisfying the conditon : "+alltext);
					Thread.sleep(1000);
					ATUReports.add("alltext failed","alltext",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		    	}
		}		

		
	}

	catch (Exception e)
	{

		System.out.println("errror at: ");
		e.printStackTrace();
		log.error("Error in Advanced_Search_Presentation_Files",e);	
		//log.fatal(e.getMessage(),e);
		captureScreenShot(ScreenShotsFilePath + "Advanced_Search_Presentation_Files_failed_Error.png");
		ATUReports.add("Advanced_Search_Presentation_Files failed","Advanced_Search_Presentation_Files",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	}
}



//----------------------------------Advanced_Search_Audio_Files-----------------------------------


public static void Advanced_Search_Audio_Files() 
{

	try
	{

		actions = new Actions(driver);

		Navigation.login();

		driver.get(Home_Page);
		WebDriverWait wait5 = new WebDriverWait(driver, 120);
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
		Thread.sleep(2000);
		
		getPageObject("search_Dropdown").click();
		Thread.sleep(1000);
		getPageObject("Advane_search_File_type").click();
		Thread.sleep(2000);
		click("advance_Audio");
		Thread.sleep(2000);
		getPageObject("Advane_search_File_type").click();
		Thread.sleep(1000);
		getPageObject("Advance_Button_Search").click();
		Thread.sleep(3000);
		
		List<WebElement> files = driver.findElements(By.xpath("//div[@class='fileName']"));
		int Files1 = files.size();
		System.out.println("No of files " + Files1);
		
		java.util.Iterator<WebElement> i = files.iterator();
		while(i.hasNext())
		{
		    WebElement row = i.next();
		    String alltext = row.getText();
		    
		    if(alltext.contains(".aif")||alltext.contains(".cda")||alltext.contains(".mid")||alltext.contains(".midi")||alltext.contains(".mp3")||alltext.contains(".mpa")||alltext.contains(".ogg")||alltext.contains(".wav")||alltext.contains(".wma")||alltext.contains(".wpl"))
		    	{
		    		System.out.println("File comparision is satisfy : "+alltext);
					Thread.sleep(1000);
					ATUReports.add("alltext successfull","alltext",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		    	}
		    else
		    	{
		    		System.out.println("not satisfying the conditon : "+alltext);
					Thread.sleep(1000);
					ATUReports.add("alltext failed","alltext",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		    	}
		}		

		
	}

	catch (Exception e)
	{

		System.out.println("errror at: ");
		e.printStackTrace();
		log.error("Error in Advanced_Search_Audio_Files",e);	
		//log.fatal(e.getMessage(),e);
		captureScreenShot(ScreenShotsFilePath + "Advanced_Search_Audio_Files_failed_Error.png");
		ATUReports.add("Advanced_Search_Audio_Files failed","Advanced_Search_Audio_Files",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	}
}


//----------------------------------Advanced_Search_video_Files-----------------------------------


public static void Advanced_Search_video_Files() 
{

	try
	{

		actions = new Actions(driver);

		Navigation.login();

		driver.get(Home_Page);
		WebDriverWait wait5 = new WebDriverWait(driver, 120);
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
		Thread.sleep(2000);
		
		getPageObject("search_Dropdown").click();
		Thread.sleep(1000);
		getPageObject("Advane_search_File_type").click();
		Thread.sleep(2000);
		click("advance_Video");
		Thread.sleep(2000);
		getPageObject("Advane_search_File_type").click();
		Thread.sleep(1000);
		getPageObject("Advance_Button_Search").click();
		Thread.sleep(3000);
		
		List<WebElement> files = driver.findElements(By.xpath("//div[@class='fileName']"));
		int Files1 = files.size();
		System.out.println("No of files " + Files1);
		
		java.util.Iterator<WebElement> i = files.iterator();
		while(i.hasNext())
		{
		    WebElement row = i.next();
		    String alltext = row.getText();
		    
		    if(alltext.contains(".avi")||alltext.contains(".3g2")||alltext.contains(".3gp")||alltext.contains(".flv")||alltext.contains(".h264")||alltext.contains(".m4v")||alltext.contains(".mkv")||alltext.contains(".mov")||alltext.contains(".mp4")||alltext.contains(".mpg")||alltext.contains(".mpeg")||alltext.contains(".rm")||alltext.contains(".swf")||alltext.contains(".vob")||alltext.contains(".wmv")) 
		    	{
		    		System.out.println("File comparision is satisfy : "+alltext);
					Thread.sleep(1000);
					ATUReports.add("alltext successfull","alltext",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		    	}
		    else
		    	{
		    		System.out.println("not satisfying the conditon : "+alltext);
					Thread.sleep(1000);
					ATUReports.add("alltext failed","alltext",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		    	}
		}		

		
	}

	catch (Exception e)
	{

		System.out.println("errror at: ");
		e.printStackTrace();
		log.error("Error in Advanced_Search_video_Files",e);	
		//log.fatal(e.getMessage(),e);
		captureScreenShot(ScreenShotsFilePath + "Advanced_Search_video_Files_failed_Error.png");
		ATUReports.add("Advanced_Search_video_Files failed","Advanced_Search_video_Files",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	}
}
}