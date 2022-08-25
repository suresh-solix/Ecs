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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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



public class FilePreview extends Navigation {

	static WebDriver driver;
	static Actions actions;

	private static Logger log = Logger.getLogger(FilePreview.class.getName());
	public static String Home_Page = "https://app.solixecsdev.com/";
	
	
	public FilePreview(WebDriver driver) {
		super(driver);
		this.driver = driver;
		//driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS).pageLoadTimeout(60, TimeUnit.SECONDS);
		ATUReports.setWebDriver(driver);
		ATUReports.setTestCaseReqCoverage("PreviewRightClickOptions");
		setIndexPageDescription();
		setAuthorInfoForReports();
		log.info("--------------------PreviewRightClickOptions--------------------");
		captureScreenShot(ScreenShotsFilePath + "PreviewRightClickOptions.png");
	}

	private void setAuthorInfoForReports() {
		ATUReports.setAuthorInfo("Sneha", Utils.getCurrentTime(),"2.0");
	}

	private void setIndexPageDescription() {
		ATUReports.indexPageDescription = "PreviewRightClickOptions";
	}

	/*
	public class signupData
	{

		private String email;
		private String first_name;
		private String last_name;
		private String password;

		public signupData(String email, String first_name, String last_name,String password) throws IOException 
			{
		setEmail(email);
		setFirst_name(first_name);
		setLast_name(last_name);
		setPassword(password);	
			}


		public String getEmail() {
			return email;
		}


		public void setEmail(String email) {
			this.email = email;
		}


		public String getFirst_name() {
			return first_name;
		}


		public void setFirst_name(String first_name) {
			this.first_name = first_name;
		}


		public String getLast_name() {
			return last_name;
		}


		public void setLast_name(String last_name) {
			this.last_name = last_name;
		}


		public String getPassword() {
			return password;
		}


		public void setPassword(String password) {
			this.password = password;
		}

	}

*/
	
	

	//------------------------------------------------------- Preview -------------------------------------------------------


	public static void file_preveiw() throws Exception
	{

		try
		{
			
			actions = new Actions(driver);
			
			driver.get(Home_Page);
			//Navigation.login();
			
			
			
			// -----------------  Preview of the file ---------------------
			
			
			Thread.sleep(500);
			WebElement elementLocator = getPageObject("first_file_infolder");
			Thread.sleep(500);
			actions.contextClick(elementLocator).perform();
			Thread.sleep(2000);
			actions.moveToElement(getPageObject("click_preview")).perform();
			Thread.sleep(2000);
		    click("click_preview");
		    
		    
			
		    
		    WebDriverWait wait16 = new WebDriverWait(driver, 120);
			wait16.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'E-Sign')]")));
			Thread.sleep(2000);
			//string preview_search = (By.xpath("//span[contains(text(), ' Search')]"));
		
			
			
			if(driver.findElement(By.xpath("//div[contains(text(),'E-Sign')]")).isDisplayed())
					{
			//preview_search.isDisplayed();
				 //driver.findElement(By.xpath("//span[contains(text(), ' Search')]")).isDisplayed(); {
			 

					log.info("-------------------Preview loaded successfully--------------------------------------------");

				captureScreenShot(ScreenShotsFilePath + "preview_loaded_successfully.png");
				Thread.sleep(2000);

				ATUReports.add("Preview is loaded successfully", "File preview is successful", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			}

		else
		{

			log.error("Error in loading the Preview");	
			captureScreenShot(ScreenShotsFilePath + "Error_in_loading_preview.png");
			Thread.sleep(2000);
			ATUReports.add("Error in loading the Preview","Error in adding files to collection",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			
		}
		}


	
			
				
				
			


		


		
			
		catch (Exception e) {

			System.out.println("errror at: ");
			e.printStackTrace();
			log.error("Error in previewing the File");	
			captureScreenShot(ScreenShotsFilePath + "error_in_adding_files_to_collection.png");
			ATUReports.add("Error in adding files to collection","Error in adding files to collection",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
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
