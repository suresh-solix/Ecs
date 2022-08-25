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
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import arca.common.Navigation;
import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.reports.utils.Utils;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;



public class ExportMetaData extends Navigation {

	static WebDriver driver;
	static Actions actions;

	private static Logger log = Logger.getLogger(ExportMetaData.class.getName());
	public static String Home_Page = "https://app.solixecsdev.com/login";
	public ExportMetaData(WebDriver driver) {
		super(driver);
		this.driver = driver;
		//driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS).pageLoadTimeout(60, TimeUnit.SECONDS);
		ATUReports.setWebDriver(driver);
		ATUReports.setTestCaseReqCoverage("Share");
		setIndexPageDescription();
		setAuthorInfoForReports();
		log.info("--------------------Share--------------------");
		captureScreenShot(ScreenShotsFilePath + "Share.png");
	}

	private void setAuthorInfoForReports() {
		ATUReports.setAuthorInfo("Mahesh", Utils.getCurrentTime(),"2.0");
	}

	private void setIndexPageDescription() {
		ATUReports.indexPageDescription = "Share";
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



	//------------------------------------------------------- inactive folder share-------------------------------------------------------


	public static void folder_export_metadata_myfiles()
	{

		try
		{
			actions = new Actions(driver);
			
			
			driver.get(Home_Page);
			
			click("profile_icon");
			Thread.sleep(1000);
			click("sing_out");
			WebDriverWait wait35123 = new WebDriverWait(driver, 60);
			wait35123.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));
			
			Navigation.login();
			
			

			WebDriverWait wait3122 = new WebDriverWait(driver, 60);
			wait3122.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[contains(text(),'Folders')]")));
			Thread.sleep(2000);
			
			
			
			String export_meta_data_folder_name = "Export Metadata";

			WebElement all_folders1 = getPageObject("folder_names");
			List<WebElement> each_folder1=all_folders1.findElements(By.tagName("div"));

			for(int i=0;i<each_folder1.size();i++)
			{


				WebElement each_div =each_folder1.get(i);
				String selected_folder_name = each_div.getText();
				//log.info("--------------------"+selected_file_folder_name);
				if(selected_folder_name.contains("Export Metadata"))
				{
					
					actions.contextClick(each_folder1.get(i)).perform();
					Thread.sleep(2000);

					break;
					
					
				}
				
			}

			
			
			click("export_meta_data");
			Thread.sleep(2000);
			
			

			actions.doubleClick(getPageObject("export_metadata_popup_myfiles")).perform();
			
			
			Thread.sleep(3000);
			
			

			WebElement copy_move_popup_all_files_folders = getPageObject("copy_move_popup_all_files_folders");
			List<WebElement> each_file_folder=copy_move_popup_all_files_folders.findElements(By.tagName("div"));

			for(int i=0;i<each_file_folder.size();i++)
			{


				WebElement each_div =each_file_folder.get(i);
				String selected_file_folder_name = each_div.getText();
				//log.info("--------------------"+selected_file_folder_name);
				if(selected_file_folder_name.equals(export_meta_data_folder_name))
				
				{
					
					
					
					actions.doubleClick(each_file_folder.get(i)).perform();
					//each_file_folder.get(i).click();
					Thread.sleep(3000);
					
					

					click("export_metadata_popup_create_folder_icon");

					WebDriverWait wait2 = new WebDriverWait(driver, 60);
					wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Create')]")));
					
					
					DateFormat dateFormat = new SimpleDateFormat("MMM-dd HH-mm");

					//get current date time with Date()
					Date date = new Date();

					// Now format the date
					String dateFormatted= dateFormat.format(date);
					
					String export_metadata_folder_name="Export metadata "+dateFormatted;
					sendKeys("export_metadata_popup_create_folder_textarea",export_metadata_folder_name);
					
					click("export_metadata_popup_create_folder_button");
					
					Thread.sleep(2000);
					
					click("export_metadata_ok_button");
					
					WebDriverWait wait222 = new WebDriverWait(driver, 60);
					wait222.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='Vue-Toastification__toast-body']")));

 
					if(getPageObject("starred_toast").getText().equals("Your report is preparing download soon you can check in /home/Export Metadata"))
					
					
					Thread.sleep(2000);
					click("toast_close");
					log.info("Toast closed");
					
					Thread.sleep(5000);
					
					
					WebElement export_meta_folder = getPageObject("folder_names");
					List<WebElement> each_folder11=export_meta_folder.findElements(By.tagName("div"));

					for(int j=0;j<each_folder11.size();j++)
					{


						WebElement each_div2 =each_folder11.get(j);
						String selected_folder_name = each_div2.getText();
						//log.info("--------------------"+selected_file_folder_name);
						if(selected_folder_name.equals(export_metadata_folder_name))
						{
							
							actions.doubleClick(each_folder11.get(j)).perform();
							Thread.sleep(2000);
							
							WebDriverWait wait1 = new WebDriverWait(driver, 60);
							wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='files']/div/div[1]")));
							Thread.sleep(2000);

							break;
							
							
						}
						
					}

					
					
					break;
					
					
				}
				
			}
		
			

			
				
				log.info("--------------------------------------------Metadata for folder generated successfully--------------------------------------------");
				
				captureScreenShot(ScreenShotsFilePath + "metadata_for_folder_generated_successfully.png");
				Thread.sleep(2000);
				ATUReports.add("Metadata for folder generated successfully","Metadata for folder generated successfully",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			
			
			
		}
		
		

		catch (Exception e) {

			System.out.println("errror at: ");
			e.printStackTrace();
			log.error("Error in generating metadata for folder",e);	
			//log.fatal(e.getMessage(),e);
			captureScreenShot(ScreenShotsFilePath + "failed_to_generate_metadata_for_folder.png");
			ATUReports.add("failed to generate metadata for folder","failed to generate metadata for folder",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
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
