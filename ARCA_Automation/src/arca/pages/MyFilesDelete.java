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



public class MyFilesDelete extends Navigation {

	static WebDriver driver;
	static Actions actions;

	private static Logger log = Logger.getLogger(MyFilesDelete.class.getName());
	public static String Home_Page = "https://app.solixecsdev.com/login";

	public MyFilesDelete(WebDriver driver) {
		super(driver);
		this.driver = driver;
		//driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS).pageLoadTimeout(60, TimeUnit.SECONDS);
		ATUReports.setWebDriver(driver);
		ATUReports.setTestCaseReqCoverage("Delete Files");
		setIndexPageDescription();
		setAuthorInfoForReports();
		log.info("--------------------Delete Files--------------------");
		captureScreenShot(ScreenShotsFilePath + "delete_files.png");
	}

	private void setAuthorInfoForReports() {
		ATUReports.setAuthorInfo("Mahesh", Utils.getCurrentTime(),"2.0");
	}

	private void setIndexPageDescription() {
		ATUReports.indexPageDescription = "Delete Files";
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

	

	
	//-------------------------------------------------------Mul File Delete-------------------------------------------------------

	

	public static void mul_file_delete() throws Exception
	{

		try
		{
			actions = new Actions(driver);
			
			//Navigation.login();
			driver.get(Home_Page);
			
			WebDriverWait wait312123 = new WebDriverWait(driver, 60);
			wait312123.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[contains(text(),'Folders')]")));
			
			
			click("profile_icon");
			
			click("sing_out");
			
			
			WebDriverWait wait35123 = new WebDriverWait(driver, 60);
			wait35123.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));
			
			
			
			Navigation.login();
		   
			WebDriverWait wait3121235 = new WebDriverWait(driver, 60);
			wait3121235.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[contains(text(),'Folders')]")));
			
			


	WebElement all_folders1 = getPageObject("folder_names");
	List<WebElement> each_folder1=all_folders1.findElements(By.tagName("div"));

	for(int i=0;i<each_folder1.size();i++)
	{


		WebElement each_div =each_folder1.get(i);
		String selected_folder_name = each_div.getText();
		//log.info("--------------------"+selected_file_folder_name);
		if(selected_folder_name.contains("Delete Restore"))
		{
			
			actions.doubleClick(each_folder1.get(i)).perform();
			Thread.sleep(2000);

			break;
			
			
		}
		
	}

	
	WebDriverWait wait4 = new WebDriverWait(driver, 120);
	wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[contains(text(),'All Files')]")));
	
	
	String all_files=getPageObject("all_selected_files").getText();
	log.info("------------------");
	log.info(all_files);
	log.info("------------------");
	click("first_file_infolder");
	JsClick("selected_file_checkbox");
	//Thread.sleep(1000);
	click("second_file_infolder");
	//Thread.sleep(1000);
	JsClick("selected_file_checkbox");
	//Thread.sleep(1000);
	click("third_file_infolder");
	//Thread.sleep(1000);
	JsClick("selected_file_checkbox");
	//Thread.sleep(1000);
	
	

	WebElement elementLocator1 = getPageObject("first_file_infolder");
	actions.contextClick(elementLocator1).perform();
	Thread.sleep(2000);
	click("file_move_to_trash");
	
	
	WebDriverWait wait3 = new WebDriverWait(driver, 60);
	wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Successfully moved to trash')]")));
	
	

	
		//---------------Mul Files Delete Cofirmation------------------
		click("toast_close");
		
		click("trash");
		
		WebDriverWait wait41 = new WebDriverWait(driver, 120);
		wait41.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[contains(text(),'All Files')]")));
		
		
		String all_trash_files=getPageObject("all_selected_files").getText();
		log.info("------------------");
		log.info(all_trash_files);
		log.info("------------------");
		
		
		assertEquals(all_files,all_trash_files);
		if(all_files==all_trash_files);
		
		
		log.info("--------------------------------------------file Successfully moved to trash--------------------------------------------");
		Thread.sleep(2000);

		captureScreenShot(ScreenShotsFilePath + "files_moved_to_trash.png");
		Thread.sleep(2000);
		
		ATUReports.add("files moved to trash","files moved to trash",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		
		
	


	


		}
		catch (Exception e) {

			System.out.println("errror at: ");
			e.printStackTrace();
			log.error("Error in deleting files.",e);	
			//log.fatal(e.getMessage(),e);
			captureScreenShot(ScreenShotsFilePath + "files_delete_Error.png");
			ATUReports.add("Files delete failed","Files delete failed",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}



	}

	

	//-------------------------------------------------------Mul Files Restore-------------------------------------------------------

	

	public static void mul_files_restore() throws Exception
	{

		try
		{
			actions = new Actions(driver);
			
			
			String all_trash_files=getPageObject("all_selected_files").getText();
			log.info("------------------");
			log.info(all_trash_files);
			log.info("------------------");
			
	click("first_file_infolder");
	JsClick("selected_file_checkbox");
	//Thread.sleep(1000);
	click("second_file_infolder");
	//Thread.sleep(1000);
	JsClick("selected_file_checkbox");
	//Thread.sleep(1000);
	click("third_file_infolder");
	//Thread.sleep(1000);
	JsClick("selected_file_checkbox");
	//Thread.sleep(1000);
	
	

	WebElement elementLocator1 = getPageObject("first_file_infolder");
	actions.contextClick(elementLocator1).perform();
	Thread.sleep(3000);
	click("right_click_restore");

	
	WebDriverWait wait222 = new WebDriverWait(driver, 60);
	wait222.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='Vue-Toastification__toast-body']")));


	//--------Restore confirmation-----------
	if(getPageObject("starred_toast").getText().contains("File(s) restored successfully"))
	{
	
		//---------------Mul Files Delete Cofirmation------------------
		click("toast_close");
		
		click("goto_myfiles");
		
		WebDriverWait wait41 = new WebDriverWait(driver, 120);
		wait41.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[contains(text(),'All Files')]")));
		

		WebElement all_folders1 = getPageObject("folder_names");
		List<WebElement> each_folder1=all_folders1.findElements(By.tagName("div"));

		for(int i=0;i<each_folder1.size();i++)
		{


			WebElement each_div =each_folder1.get(i);
			String selected_folder_name = each_div.getText();
			//log.info("--------------------"+selected_file_folder_name);
			if(selected_folder_name.contains("Delete Restore"))
			{
				
				actions.doubleClick(each_folder1.get(i)).perform();
				Thread.sleep(2000);

				break;
				
				
			}
			
		}

		
		WebDriverWait wait3121235 = new WebDriverWait(driver, 60);
		wait3121235.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[contains(text(),'Folders')]")));
		
		
		
		String all_files=getPageObject("all_selected_files").getText();
		log.info("------------------");
		log.info(all_files);
		log.info("------------------");
		
		
		assertEquals(all_trash_files,all_files);
		if(all_trash_files==all_files);
		
		
		log.info("--------------------------------------------files Successfully restored--------------------------------------------");
		Thread.sleep(2000);

		captureScreenShot(ScreenShotsFilePath + "files_restored.png");
		Thread.sleep(2000);
		
		ATUReports.add("files restored","files restored",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		
		
	}


	
	

	


		}
		catch (Exception e) {

			System.out.println("errror at: ");
			e.printStackTrace();
			log.error("Error in files restore.",e);	
			//log.fatal(e.getMessage(),e);
			captureScreenShot(ScreenShotsFilePath + "files_restore_Error.png");
			ATUReports.add("files restore failed","files restore failed",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}



	}


	
	
	
	

	//-------------------------------------------------------Mul Folders Delete-------------------------------------------------------

	

	public static void mul_folders_delete() throws Exception
	{

		try
		{
			actions = new Actions(driver);
			
			//Navigation.login();
			driver.get(Home_Page);
			
			WebDriverWait wait312123 = new WebDriverWait(driver, 60);
			wait312123.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[contains(text(),'Folders')]")));
			

			WebElement all_folders1 = getPageObject("folder_names");
			List<WebElement> each_folder1=all_folders1.findElements(By.tagName("div"));

			for(int i=0;i<each_folder1.size();i++)
			{


				WebElement each_div =each_folder1.get(i);
				String selected_folder_name = each_div.getText();
				//log.info("--------------------"+selected_file_folder_name);
				if(selected_folder_name.contains("Delete Restore"))
				{
					
					actions.doubleClick(each_folder1.get(i)).perform();
					Thread.sleep(2000);

					break;
					
					
				}
				
			}

			
			WebDriverWait wait4 = new WebDriverWait(driver, 120);
			wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[contains(text(),'All Files')]")));
			
	
	String all_folders=getPageObject("all_selected_folders").getText();
	log.info("------------------");
	log.info(all_folders);
	log.info("------------------");
	click("first_folder_infolder");
	JsClick("selected_folder_checkbox");
	//Thread.sleep(1000);
	click("second_folder_infolder");
	//Thread.sleep(1000);
	JsClick("selected_folder_checkbox");
	//Thread.sleep(1000);
	click("third_folder_infolder");
	//Thread.sleep(1000);
	JsClick("selected_folder_checkbox");
	//Thread.sleep(1000);
	
	
	

	WebElement elementLocator1 = getPageObject("first_folder_infolder");
	actions.contextClick(elementLocator1).perform();
	Thread.sleep(2000);
	click("file_move_to_trash");
	
	WebDriverWait wait222 = new WebDriverWait(driver, 60);
			wait222.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='Vue-Toastification__toast-body']")));


	if(getPageObject("starred_toast").getText().contains("Successfully moved to trash"))
	{
	
		//---------------Mul Files Delete Cofirmation------------------
		click("toast_close");
			
		click("trash");
		
		WebDriverWait wait41 = new WebDriverWait(driver, 120);
		wait41.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[contains(text(),'Folders')]")));
		
		
		String all_trash_folders=getPageObject("all_selected_folders").getText();
		log.info("------------------");
		log.info(all_trash_folders);
		log.info("------------------");
		
		
		assertEquals(all_folders,all_trash_folders);
		if(all_folders==all_trash_folders);
		
		
		log.info("--------------------------------------------folders Successfully moved to trash--------------------------------------------");
		Thread.sleep(2000);

		captureScreenShot(ScreenShotsFilePath + "folders_moved_to_trash.png");
		Thread.sleep(2000);
		
		ATUReports.add("folders moved to trash","folders moved to trash",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		
		
	}




		}
		catch (Exception e) {

			System.out.println("errror at: ");
			e.printStackTrace();
			log.error("Error in deleting folders.",e);	
			//log.fatal(e.getMessage(),e);
			captureScreenShot(ScreenShotsFilePath + "folders_delete_Error.png");
			ATUReports.add("folders delete failed","folders delete failed",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}



	}

	

	//-------------------------------------------------------Mul Folders Restore-------------------------------------------------------

	

	public static void mul_folders_restore() throws Exception
	{

		try
		{
			actions = new Actions(driver);
			//Navigation.login();
			
			driver.get(Home_Page);
			
			WebDriverWait wait312123 = new WebDriverWait(driver, 60);
			wait312123.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[contains(text(),'Folders')]")));
			
			
			click("trash"); 
			
			WebDriverWait wait41 = new WebDriverWait(driver, 120);
			wait41.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[contains(text(),'Folders')]")));
			
			
			String all_trash_folders=getPageObject("all_selected_folders").getText();
			log.info("------------------");
			log.info(all_trash_folders);
			log.info("------------------");
			
			
			click("first_folder_infolder");
			//Thread.sleep(1000);
			JsClick("trash_selected_folder_checkbox");
			//Thread.sleep(1000);
			click("second_folder_infolder");
			//Thread.sleep(1000);
			JsClick("trash_selected_folder_checkbox");
			//Thread.sleep(1000);
			click("third_folder_infolder");
			//Thread.sleep(1000);
			JsClick("trash_selected_folder_checkbox");
			//Thread.sleep(1000);
			
	
	

	WebElement elementLocator1 = getPageObject("first_folder_infolder");
	actions.contextClick(elementLocator1).perform();
	Thread.sleep(2000);
	click("right_click_restore");
	
	
	WebDriverWait wait222 = new WebDriverWait(driver, 60);
			wait222.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='Vue-Toastification__toast-body']")));

	
	

	//--------Restore confirmation-----------
	if(getPageObject("starred_toast").getText().contains("Folder(s) restored successfully"))
	{
	
		//---------------Mul Files Delete Cofirmation------------------
		click("toast_close");
		
		click("goto_myfiles");
		
		WebDriverWait wait413 = new WebDriverWait(driver, 120);
		wait413.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[contains(text(),'All Files')]")));
		

		WebElement all_folders1 = getPageObject("folder_names");
		List<WebElement> each_folder1=all_folders1.findElements(By.tagName("div"));

		for(int i=0;i<each_folder1.size();i++)
		{


			WebElement each_div =each_folder1.get(i);
			String selected_folder_name = each_div.getText();
			//log.info("--------------------"+selected_file_folder_name);
			if(selected_folder_name.contains("Delete Restore"))
			{
				
				actions.doubleClick(each_folder1.get(i)).perform();
				Thread.sleep(2000);

				break;
				
				
			}
			
		}

		WebDriverWait wait3121236 = new WebDriverWait(driver, 60);
		wait3121236.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[contains(text(),'Folders')]")));
		
		

		
		String all_folders=getPageObject("all_selected_folders").getText();
		log.info("------------------");
		log.info(all_folders);
		log.info("------------------");
		
		
		assertEquals(all_trash_folders,all_folders);
		if(all_trash_folders==all_folders);
		
		
		log.info("--------------------------------------------folders Successfully restored--------------------------------------------");
		Thread.sleep(2000);

		captureScreenShot(ScreenShotsFilePath + "folders_restored.png");
		Thread.sleep(2000);
		
		ATUReports.add("folders restored","folders restored",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		
		
	}


	

	


		}
		catch (Exception e) {

			System.out.println("errror at: ");
			e.printStackTrace();
			log.error("Error in folders restore.",e);	
			//log.fatal(e.getMessage(),e);
			captureScreenShot(ScreenShotsFilePath + "folders_restore_Error.png");
			ATUReports.add("folders restore failed","folders restore failed",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}



	}


	
	

	
	//-------------------------------------------------------Mul File and folders Delete-------------------------------------------------------

	

	public static void mul_files_folders_delete() throws Exception
	{

		try
		{
			actions = new Actions(driver);
			
			
			
			


	WebElement all_folders1 = getPageObject("folder_names");
	List<WebElement> each_folder1=all_folders1.findElements(By.tagName("div"));

	for(int i=0;i<each_folder1.size();i++)
	{


		WebElement each_div =each_folder1.get(i);
		String selected_folder_name = each_div.getText();
		//log.info("--------------------"+selected_file_folder_name);
		if(selected_folder_name.contains("Delete Restore"))
		{
			
			actions.doubleClick(each_folder1.get(i)).perform();
			Thread.sleep(2000);

			break;
			
			
		}
		
	}

	
	WebDriverWait wait4 = new WebDriverWait(driver, 120);
	wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[contains(text(),'All Files')]")));
	
	
	String all_files=getPageObject("all_selected_files").getText();
	log.info("------------------");
	log.info(all_files);
	log.info("------------------");
	click("first_file_infolder");
	JsClick("selected_file_checkbox");
	//Thread.sleep(1000);
	click("second_file_infolder");
	//Thread.sleep(1000);
	JsClick("selected_file_checkbox");
	//Thread.sleep(1000);
	click("third_file_infolder");
	//Thread.sleep(1000);
	JsClick("selected_file_checkbox");
	//Thread.sleep(1000);
	
	
	
	String all_folders=getPageObject("all_selected_folders").getText();
	log.info("------------------");
	log.info(all_folders);
	log.info("------------------");
	click("first_folder_infolder");
	JsClick("selected_folder_checkbox");
	//Thread.sleep(1000);
	click("second_folder_infolder");
	//Thread.sleep(1000);
	JsClick("selected_folder_checkbox");
	//Thread.sleep(1000);
	click("third_folder_infolder");
	//Thread.sleep(1000);
	JsClick("selected_folder_checkbox");
	//Thread.sleep(1000);
	

	WebElement elementLocator1 = getPageObject("first_file_infolder");
	actions.contextClick(elementLocator1).perform();
	Thread.sleep(2000);
	click("file_move_to_trash");
	
	WebDriverWait wait222 = new WebDriverWait(driver, 60);
			wait222.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='Vue-Toastification__toast-body']")));

	
	

	if(getPageObject("starred_toast").getText().contains("Successfully moved to trash"))
	{
	
		//---------------Mul Files Delete Cofirmation------------------
		click("toast_close");
		
		click("trash");
		
		WebDriverWait wait41 = new WebDriverWait(driver, 120);
		wait41.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[contains(text(),'All Files')]")));
		
		
		String all_trash_files=getPageObject("all_selected_files").getText();
		log.info("------------------");
		log.info(all_trash_files);
		log.info("------------------");
		
		
		assertEquals(all_files,all_trash_files);
		if(all_files==all_trash_files);
		
		
		String all_trash_folders=getPageObject("all_selected_folders").getText();
		log.info("------------------");
		log.info(all_trash_folders);
		log.info("------------------");
		
		
		assertEquals(all_folders,all_trash_folders);
		if(all_folders==all_trash_folders);
		
		
		log.info("--------------------------------------------files and folders Successfully moved to trash--------------------------------------------");
		Thread.sleep(2000);

		captureScreenShot(ScreenShotsFilePath + "files_folders_moved_to_trash.png");
		Thread.sleep(2000);
		
		ATUReports.add("files and folders moved to trash","files and folders moved to trash",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		
		
	}




		}
		catch (Exception e) {

			System.out.println("errror at: ");
			e.printStackTrace();
			log.error("Error in deleting files and folders.",e);	
			//log.fatal(e.getMessage(),e);
			captureScreenShot(ScreenShotsFilePath + "files_folders_delete_Error.png");
			ATUReports.add("Files and folders delete failed","Files and folders delete failed",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}



	}

	

	//-------------------------------------------------------Mul Files Restore-------------------------------------------------------

	

	public static void mul_files_folders_restore() throws Exception
	{

		try
		{
			actions = new Actions(driver);
			
			/*
			driver.get(Home_Page);
			
			sendKeys("login_username","ravovov767@onzmail.com");
			sendKeys("login_password","Test@123");
			click("login_button");
			log.info("login success");
			*/
			
			driver.get(Home_Page);
			WebDriverWait wait312123 = new WebDriverWait(driver, 60);
			wait312123.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[contains(text(),'Folders')]")));
			
			
			
			click("trash");

			WebDriverWait wait4 = new WebDriverWait(driver, 120);
			wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[contains(text(),'All Files')]")));
			
			String all_trash_files=getPageObject("all_selected_files").getText();
			log.info("------------------");
			log.info(all_trash_files);
			log.info("------------------");
			
	click("first_file_infolder");
	JsClick("selected_file_checkbox");
	//Thread.sleep(1000);
	click("second_file_infolder");
	//Thread.sleep(1000);
	JsClick("selected_file_checkbox");
	//Thread.sleep(1000);
	click("third_file_infolder");
	//Thread.sleep(1000);
	JsClick("selected_file_checkbox");
	//Thread.sleep(1000);
	
	
	
	
	String all_trash_folders=getPageObject("all_selected_folders").getText();
	log.info("------------------");
	log.info(all_trash_folders);
	log.info("------------------");
	
	
	click("first_folder_infolder");
	//Thread.sleep(1000);
	JsClick("trash_selected_folder_checkbox");
	//Thread.sleep(1000);
	click("second_folder_infolder");
	//Thread.sleep(1000);
	JsClick("trash_selected_folder_checkbox");
	//Thread.sleep(1000);
	click("third_folder_infolder");
	//Thread.sleep(1000);
	JsClick("trash_selected_folder_checkbox");
	//Thread.sleep(1000);
	
	

	WebElement elementLocator1 = getPageObject("first_file_infolder");
	actions.contextClick(elementLocator1).perform();
	Thread.sleep(2000);
	click("right_click_restore");
	
		WebDriverWait wait222 = new WebDriverWait(driver, 60);
			wait222.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='Vue-Toastification__toast-body']")));

	

	//--------Restore confirmation-----------
	if(getPageObject("starred_toast").getText().contains("File(s) restored successfully"))
	{
	
		//---------------Mul Files Delete Cofirmation------------------
		click("toast_close");
		
		click("goto_myfiles");
		
		WebDriverWait wait41 = new WebDriverWait(driver, 120);
		wait41.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[contains(text(),'All Files')]")));
		

		WebElement all_folders1 = getPageObject("folder_names");
		List<WebElement> each_folder1=all_folders1.findElements(By.tagName("div"));

		for(int i=0;i<each_folder1.size();i++)
		{


			WebElement each_div =each_folder1.get(i);
			String selected_folder_name = each_div.getText();
			//log.info("--------------------"+selected_file_folder_name);
			if(selected_folder_name.contains("Delete Restore"))
			{
				
				actions.doubleClick(each_folder1.get(i)).perform();
				Thread.sleep(2000);

				break;
				
				
			}
			
		}

		WebDriverWait wait3121239 = new WebDriverWait(driver, 60);
		wait3121239.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[contains(text(),'Folders')]")));
		
		

		
		String all_files=getPageObject("all_selected_files").getText();
		log.info("------------------");
		log.info(all_files);
		log.info("------------------");
		
		
		assertEquals(all_trash_files,all_files);
		if(all_trash_files==all_files);
		
		
		String all_folders=getPageObject("all_selected_folders").getText();
		log.info("------------------");
		log.info(all_folders);
		log.info("------------------");
		
		
		assertEquals(all_trash_folders,all_folders);
		if(all_trash_folders==all_folders);
		
		
		
		log.info("--------------------------------------------files Successfully restored--------------------------------------------");
		Thread.sleep(2000);

		captureScreenShot(ScreenShotsFilePath + "files_restored.png");
		Thread.sleep(2000);
		
		ATUReports.add("files restored","files restored",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		
		
	}




	


		}
		catch (Exception e) {

			System.out.println("errror at: ");
			e.printStackTrace();
			log.error("Error in files restore.",e);	
			//log.fatal(e.getMessage(),e);
			captureScreenShot(ScreenShotsFilePath + "files_restore_Error.png");
			ATUReports.add("files restore failed","files restore failed",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
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





