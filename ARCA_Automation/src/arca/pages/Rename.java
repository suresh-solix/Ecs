
package arca.pages;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import arca.common.Navigation;
import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.reports.utils.Utils;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;



public class Rename extends Navigation {

	static WebDriver driver;
	static Actions actions;

	private static Logger log = Logger.getLogger(Rename.class.getName());
	public static String Home_Page = "https://app.solixecsdev.com/";
	
	
	public Rename(WebDriver driver) {
		super(driver);
		this.driver = driver;
		//driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS).pageLoadTimeout(60, TimeUnit.SECONDS);
		ATUReports.setWebDriver(driver);
		ATUReports.setTestCaseReqCoverage("Rename");
		setIndexPageDescription();
		setAuthorInfoForReports();
		log.info("--------------------Rename--------------------");
		captureScreenShot(ScreenShotsFilePath + "Rename.png");
	}

	private void setAuthorInfoForReports() {
		ATUReports.setAuthorInfo("Sneha", Utils.getCurrentTime(),"2.0");
	}

	private void setIndexPageDescription() {
		ATUReports.indexPageDescription = "Rename";
	}


	
	

	//------------------------------------------------------- Rename  -------------------------------------------------------


	public static void rename_file() throws Exception
	{

		try
		{
			
			actions = new Actions(driver);
			
			driver.get(Home_Page);
			//Navigation.login();
			
			DateFormat dateFormat = new SimpleDateFormat("MMM-dd HH-mm");

			//get current date time with Date()
			Date date = new Date();

			// Now format the date
			String dateFormatted= dateFormat.format(date);
			
			
			WebElement all_folders1 = getPageObject("folder_names");
			List<WebElement> each_folder1=all_folders1.findElements(By.tagName("div"));

			for(int i=0;i<each_folder1.size();i++)
			{


				WebElement each_div =each_folder1.get(i);
				String selected_folder_name = each_div.getText();
				//log.info("--------------------"+selected_file_folder_name);
				if(selected_folder_name.contains("Rename"))
				{
					
					actions.doubleClick(each_folder1.get(i)).perform();
					Thread.sleep(2000);

					break;
					
					
				}
				
			}
			
			Thread.sleep(2000);
			
	
			
			WebElement elementLocator = getPageObject("first_file_infolder");
			String before_file_renamed = getPageObject("first_file_infolder").getText();
			log.info("Before file rename : "+before_file_renamed);
			Thread.sleep(2000);
			actions.contextClick(elementLocator).perform();
			Thread.sleep(2000);
			
		    click("click_file_rename");
		    Thread.sleep(2000);
		    
		    
		    getPageObject("rename_file_textarea").clear();
		 
		    Thread.sleep(1000);
			sendKeys("rename_file_textarea","file Renamed "+dateFormatted);
			Thread.sleep(2000);
		
			
			
					
			//Thread.sleep(2000);
		
			click("rename_save_button");
			 Thread.sleep(2000);
			 
			 WebDriverWait wait222 = new WebDriverWait(driver, 60);
			wait222.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='Vue-Toastification__container bottom-left']")));
			
				Thread.sleep(2000);
				click("toast_close");
			 
			 String after_file_renamed = getPageObject("first_file_infolder").getText();
			 log.info("After file rename : "+after_file_renamed);
			 if(!before_file_renamed.equals(after_file_renamed))
				{
					
					
					Thread.sleep(2000);
					log.info("File renamed successfully");
					captureScreenShot(ScreenShotsFilePath + "file_renamed_successfully.png");
					Thread.sleep(2000);
					ATUReports.add("File is renamed successfully",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					Thread.sleep(2000);
					} 
					else {
					Thread.sleep(2000);
					log.info("File is not renamed successfully");
					captureScreenShot(ScreenShotsFilePath + "file_renamed_successfully.png");
					Thread.sleep(2000);
					ATUReports.add("File is not renamed successfully",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					Thread.sleep(2000);
					
				}
				
			 
		}

		
			
		catch (Exception e) {

			System.out.println("errror at: ");
			e.printStackTrace();
			log.error("Error in renaming the File");	
			captureScreenShot(ScreenShotsFilePath + "error_in_renaming_the_file.png");
			ATUReports.add("Error in renaming","Error in renaming the file",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}

	}




	//-------------------------------------------- Rename for Folder ---------------------------------------------------------------------------------------------
	

	public static void rename_folder() throws Exception
	{

		try
		{
			
			actions = new Actions(driver);
			
			//Navigation.login();
			
			DateFormat dateFormat = new SimpleDateFormat("MMM-dd HH-mm");

			//get current date time with Date()
			Date date = new Date();

			// Now format the date
			String dateFormatted= dateFormat.format(date);
					
			
			/*
			WebElement all_folders1 = getPageObject("folder_names");
			List<WebElement> each_folder1=all_folders1.findElements(By.tagName("div"));

			for(int i=0;i<each_folder1.size();i++)
			{


				WebElement each_div =each_folder1.get(i);
				String selected_folder_name = each_div.getText();
				//log.info("--------------------"+selected_file_folder_name);
				if(selected_folder_name.contains("Rename"))
				{
					
					actions.doubleClick(each_folder1.get(i)).perform();
					Thread.sleep(2000);

					break;
					
					
				}
				
			}
			
			Thread.sleep(2000);
			*/
			
			WebElement elementLocator = getPageObject("first_folder_infolder");
			String before_folder_renamed = getPageObject("first_folder_infolder").getText();
			log.info("Before folder renamed : "+before_folder_renamed);
			Thread.sleep(1000);
			

			
			actions.contextClick(elementLocator).perform();
			Thread.sleep(2000);
			actions.moveToElement(getPageObject("click_folder_rename")).perform();
			Thread.sleep(1000);
		    click("click_folder_rename");
		    Thread.sleep(2000);
		    
		    
		    getPageObject("rename_folder_textarea").clear();
		 
		    Thread.sleep(1000);
		    sendKeys("rename_folder_textarea","folder Renamed "+dateFormatted);
			Thread.sleep(1000);
			
			click("rename_save_button");
			Thread.sleep(2000);
			 
			WebDriverWait wait222 = new WebDriverWait(driver, 60);
			wait222.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='Vue-Toastification__container bottom-left']")));

			Thread.sleep(2000);
			click("toast_close");
			 
			 String after_folder_renamed = getPageObject("first_folder_infolder").getText();
			 log.info("After folder rename : "+after_folder_renamed);
			 if(!before_folder_renamed.equals(after_folder_renamed))
				{
					
					
					Thread.sleep(2000);
					log.info("Folder renamed successfully");
					captureScreenShot(ScreenShotsFilePath + "folder_renamed_successfully.png");
					Thread.sleep(2000);
					ATUReports.add("Folder is renamed successfully",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					Thread.sleep(2000);
					} 
					else {
					Thread.sleep(2000);
					log.info("Folder is not renamed successfully");
					captureScreenShot(ScreenShotsFilePath + "folder_rename_failed.png");
					Thread.sleep(2000);
					ATUReports.add("Folder is not renamed successfully",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					Thread.sleep(2000);
					
				}
				
			 
		

			  
		}

		
			
		catch (Exception e) {

			System.out.println("errror at: ");
			e.printStackTrace();
			log.error("Error in renaming");	
			captureScreenShot(ScreenShotsFilePath + "error_in_renaming.png");
			ATUReports.add("Error in renaming","Error in renaming",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			
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


	




	