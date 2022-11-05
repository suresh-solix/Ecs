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

public class MyFiles_Upload_Forms extends Navigation {
		
	
	static WebDriver driver;
	static Actions actions;
  

	private static Logger log = Logger.getLogger(MyFiles_Upload_Forms.class.getName());
	public static String Home_Page = "https://app.solixecsdev.com/login";
	public MyFiles_Upload_Forms(WebDriver driver) {
		super(driver);
		this.driver = driver;
		//driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS).pageLoadTimeout(60, TimeUnit.SECONDS);
		ATUReports.setWebDriver(driver);
		ATUReports.setTestCaseReqCoverage("MyFiles_Upload_Forms");
		setIndexPageDescription();
		setAuthorInfoForReports();
		log.info("--------------------MyFiles_Upload_Forms--------------------");
		captureScreenShot(ScreenShotsFilePath + "MyFiles_Upload_Forms.png");
	}
	private void setAuthorInfoForReports()
	{
		ATUReports.setAuthorInfo("Mahesh", Utils.getCurrentTime(),"2.0");
	}

	private void setIndexPageDescription()
	{
		ATUReports.indexPageDescription = "MyFiles_Upload_Forms";
	}



		//--------------------------MyFiles_Upload_Forms_Verify_Form_Enabling--------------------------

public static void MyFiles_Upload_Forms_Verify_Form_Enabling()
{

	try
	{

		actions = new Actions(driver);
		Actions act = new Actions(driver);
		Navigation.login();

		driver.get(Home_Page);
		WebDriverWait wait5 = new WebDriverWait(driver, 120);
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(text(),'My Files')])[1]")));
		
		//----Creating Folder----
		click("Plus-Buttom");
		getPageObject("Folder_Create").click();
		sendKeys("ente_folder_name","Form Test");
		click("Ok");		
		WebDriverWait wait222 = new WebDriverWait(driver, 60);
		wait222.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Folder is created successfully.')]")));
		Thread.sleep(2000);
		click("toast_close");
		
		WebElement ele = getPageObject("Folder_Form_Test");
		act.doubleClick(ele).perform();
		
		Thread.sleep(1000);
		click("Plus-Buttom");
		
		WebElement Upoadforms =	driver.findElement(By.xpath("(//span[contains(text(),'Upload Form')])[2]"));
		actions.moveToElement(Upoadforms).perform();
		Thread.sleep(2000);
		WebElement Create = driver.findElement(By.xpath("//span[contains(text(),'Create New')]"));
		Create.click();
		Thread.sleep(1000);
		
		// --Form Creating
		DateFormat dateFormat = new SimpleDateFormat("MMM-dd HH-mm");

		//get current date time with Date()
		Date date = new Date();

		// Now format the date
		String dateFormatted= dateFormat.format(date);

		String single_file_folder_name="Form "+dateFormatted;
		
		sendKeys("Enter_Form_Title",single_file_folder_name);
		Thread.sleep(1000);
		
		sendKeys("Upload_Text_area","Respondent should provide a folder name");
		Thread.sleep(1000);
		getPageObject("Ask_respondent_folder_name").click();
		Thread.sleep(1000);
		getPageObject("Ask_Respondent_Add_Tags").click();
		Thread.sleep(1000);
		DateFormat dateFormat1 = new SimpleDateFormat("MMM-dd HH-mm");

		//get current date time with Date()
		Date date1 = new Date();

		// Now format the date
		String dateFormatted1= dateFormat1.format(date1);

		String single_file_folder_name1="Provide folder name as date and time format "+dateFormatted1;
		sendKeys("Provide_guidlines",single_file_folder_name1);
		click("Form_Next");
		
		//--Form Settings
		click("Foem_Settings_Pencil");
		
		WebElement el11e = getPageObject("Right_Form_Test_click");
		actions.doubleClick(el11e).perform();
		Thread.sleep(2000);
		getPageObject("Create_Folder").click();
		Thread.sleep(1000);
		DateFormat dateFormat11 = new SimpleDateFormat("MMM-dd HH-mm");

		//get current date time with Date()
		Date date11 = new Date();

		// Now format the date
		String dateFormatted11= dateFormat11.format(date11);

		String single_file_folder_name11="Form Test "+dateFormatted11;
		
		sendKeys("Form_space_name",single_file_folder_name11);
		
		Thread.sleep(2000);
		click("Create_button");
		Thread.sleep(2000);
		click("Form_select");
		Thread.sleep(2000);
		click("Generate_Link");
		
		WebDriverWait wait4 = new WebDriverWait(driver, 60);
		wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Successfully submitted the form.')]")));
		Thread.sleep(2000);
		click("toast_close");
		
		click("Copy_Link");
		
		WebElement showLinkIn = driver.findElement(By.className("form-control"));
		String link_text = showLinkIn.getText();
		log.info("Copied link is : "+link_text);
		
		WebDriverWait wait53453 = new WebDriverWait(driver, 60);
		wait53453.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='Vue-Toastification__toast-body']")));
		
		
		if(getPageObject("starred_toast").getText().contains("Copied successfully."));
		
		String copied_link_text = driver.findElement(By.xpath("(//div[@class='input-group']//input[@type='text'])[2]")).getAttribute("value").toString();

		System.out.println("---------------------Copied link is : "+copied_link_text);
		click("File_share_close");
		
		WebDriverWait wait41 = new WebDriverWait(driver, 60);
		wait41.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Copied successfully.')]")));
		Thread.sleep(1000);
		click("toast_close");
		
		
		Thread.sleep(1000);
		click("Profile_Icon");
		Thread.sleep(2000);
		click("Sign_out");
		Thread.sleep(1000);
		click("Ok");

		WebDriverWait wait35 = new WebDriverWait(driver, 120);
		wait35.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));
		
		Thread.sleep(4000);
		driver.navigate().to(copied_link_text);
		Thread.sleep(3000);
		
		DateFormat dateFormat111 = new SimpleDateFormat("MMM-dd HH-mm");

		//get current date time with Date()
		Date date111 = new Date();

		// Now format the date
		String dateFormatted111= dateFormat111.format(date111);

		String single_file_folder_name111="Form Folder "+dateFormatted111;
		
		sendKeys("Link_Folder_name",single_file_folder_name111);
		
		// Adding Files
		driver.findElement(By.id("ext-upload")).sendKeys("C:\\Users\\1120\\Pictures\\Screenshots\\Download.png");
			
		driver.findElement(By.id("ext-upload")).sendKeys("C:\\Users\\1120\\Pictures\\Screenshots\\New Text.txt");
		
		driver.findElement(By.id("ext-upload")).sendKeys("C:\\Users\\1120\\Pictures\\Screenshots\\Screenshot (133).png");
		Thread.sleep(2000);
		
		// Adding Tags

		getPageObject("Form_Tag1").sendKeys("Tag A");
		getPageObject("Form_Tag2").sendKeys("Tag B");
		getPageObject("Form_Tag3").sendKeys("Tag C");
		Thread.sleep(1000);
		getPageObject("Form_Tag3").click();
		getPageObject("Form_Tag2").click();
		
		List<WebElement> Beforemovedfiles = driver.findElements(By.xpath("//div[@class='font-sm col-form-label elps']"));
		int nooffiles = Beforemovedfiles.size();
		System.out.println("No of Before files " + nooffiles);
		
		Thread.sleep(2000);
		click("Form_Submit");
		Thread.sleep(4000);
		
		getPageObject("Uploaded_successfully").isDisplayed();
		
		List<WebElement> Aftermovedfiles = driver.findElements(By.xpath("//img[@class='mr-1']"));
		int Aftermovedfilestofolder = Aftermovedfiles.size();
		System.out.println("No of After files " + Aftermovedfilestofolder);
		
		if(Aftermovedfilestofolder==3)
		{
			log.info("--------------------------------------------No of  files is  equal to before--------------------------------------------");

			captureScreenShot(ScreenShotsFilePath + "MyFiles_Upload_Forms_Verify_Form_Enabling_success.png");
			Thread.sleep(2000);
			ATUReports.add("MyFiles_Upload_Forms_Verify_Form_Enabling successfully","MyFiles_Upload_Forms_Verify_Form_Enabling",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(2000);
		}
		else
		{
			captureScreenShot(ScreenShotsFilePath + "MyFiles_Upload_Forms_Verify_Form_Enabling_failed.png");
			Thread.sleep(2000);
			ATUReports.add("MyFiles_Upload_Forms_Verify_Form_Enabling failed","MyFiles_Upload_Forms_Verify_Form_Enabling",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(2000);
		}
		

	}
	catch (Exception e)
	{

		System.out.println("errror at: ");
		e.printStackTrace();
		log.error("Error in MyFiles_Upload_Forms_Verify_Form_Enabling",e);	
		//log.fatal(e.getMessage(),e);
		captureScreenShot(ScreenShotsFilePath + "MyFiles_Upload_Forms_Verify_Form_Enabling_failed_Error.png");
		ATUReports.add("MyFiles_Upload_Forms_Verify_Form_Enabling failed","MyFiles_Upload_Forms_Verify_Form_Enabling",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	}
}
		
			
			//-----------------------------MyFiles_Upload_Forms_Verify_Form_Disabling-------------------------------


public static void MyFiles_Upload_Forms_Verify_Form_Disabling()
{

	try
	{

		actions = new Actions(driver);
		Actions act = new Actions(driver);
		Navigation.login();

		driver.get(Home_Page);
		WebDriverWait wait5 = new WebDriverWait(driver, 120);
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(text(),'My Files')])[1]")));
		
		WebElement ele = getPageObject("Folder_Form_Test");
		act.doubleClick(ele).perform();
		
		Thread.sleep(1000);
		click("Plus-Buttom");
		
		WebElement Upoadforms =	driver.findElement(By.xpath("(//span[contains(text(),'Upload Form')])[2]"));
		actions.moveToElement(Upoadforms).perform();
		Thread.sleep(2000);
		WebElement Create = driver.findElement(By.xpath("//span[contains(text(),'Create New')]"));
		Create.click();
		Thread.sleep(1000);
		
		// --Form Creating
				DateFormat dateFormat = new SimpleDateFormat("MMM-dd HH-mm");

				//get current date time with Date()
				Date date = new Date();

				// Now format the date
				String dateFormatted= dateFormat.format(date);

				String single_file_folder_name="Form "+dateFormatted;
				
				sendKeys("Enter_Form_Title",single_file_folder_name);
				Thread.sleep(1000);
				
				sendKeys("Upload_Text_area","Respondent should provide a folder name");
				Thread.sleep(1000);
				getPageObject("Ask_respondent_folder_name").click();
				
				Thread.sleep(1000);
				DateFormat dateFormat1 = new SimpleDateFormat("MMM-dd HH-mm");

				//get current date time with Date()
				Date date1 = new Date();

				// Now format the date
				String dateFormatted1= dateFormat1.format(date1);

				String single_file_folder_name1="Provide folder name as date and time format "+dateFormatted1;
				sendKeys("Provide_guidlines",single_file_folder_name1);
				Thread.sleep(1000);
				getPageObject("Ask_Respondent_Add_Tags").click();
				Thread.sleep(2000);
				getPageObject("Form_Make_Tag").click();
				Thread.sleep(2000);
				click("Form_Next");

		
				//--Form Settings
				click("Foem_Settings_Pencil");
				
				WebElement el11e = getPageObject("Right_Form_Test_click");
				actions.doubleClick(el11e).perform();
				Thread.sleep(2000);
				getPageObject("Create_Folder").click();
				Thread.sleep(1000);
				DateFormat dateFormat11 = new SimpleDateFormat("MMM-dd HH-mm");

				//get current date time with Date()
				Date date11 = new Date();

				// Now format the date
				String dateFormatted11= dateFormat11.format(date11);

				String single_file_folder_name11="Form Test "+dateFormatted11;
				
				sendKeys("Form_space_name",single_file_folder_name11);
				
				Thread.sleep(2000);
				click("Create_button");
				Thread.sleep(2000);
				click("Form_select");
				Thread.sleep(2000);
				click("Generate_Link");
				
				WebDriverWait wait4 = new WebDriverWait(driver, 60);
				wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Successfully submitted the form.')]")));
				Thread.sleep(2000);
				click("toast_close");
				
				click("Copy_Link");
				
				WebElement showLinkIn = driver.findElement(By.className("form-control"));
				String link_text = showLinkIn.getText();
				log.info("Copied link is : "+link_text);
				
				WebDriverWait wait53453 = new WebDriverWait(driver, 60);
				wait53453.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='Vue-Toastification__toast-body']")));
				
				
				if(getPageObject("starred_toast").getText().contains("Copied successfully."));
				
				String copied_link_text = driver.findElement(By.xpath("(//div[@class='input-group']//input[@type='text'])[2]")).getAttribute("value").toString();

				System.out.println("---------------------Copied link is : "+copied_link_text);
				click("File_share_close");
				
				WebDriverWait wait41 = new WebDriverWait(driver, 60);
				wait41.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Copied successfully.')]")));
				Thread.sleep(1000);
				click("toast_close");
				
				
				Thread.sleep(1000);
				click("Profile_Icon");
				Thread.sleep(2000);
				click("Sign_out");
				Thread.sleep(1000);
				click("Ok");

				WebDriverWait wait35 = new WebDriverWait(driver, 120);
				wait35.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));
				
				Thread.sleep(4000);
				driver.navigate().to(copied_link_text);
				Thread.sleep(3000);
				
				DateFormat dateFormat111 = new SimpleDateFormat("MMM-dd HH-mm");

				//get current date time with Date()
				Date date111 = new Date();

				// Now format the date
				String dateFormatted111= dateFormat111.format(date111);

				String single_file_folder_name111="Form Folder "+dateFormatted111;
				
				sendKeys("Link_Folder_name",single_file_folder_name111);
				
				// Adding Files
				driver.findElement(By.id("ext-upload")).sendKeys("C:\\Users\\1120\\Pictures\\Screenshots\\Download.png");
					
				driver.findElement(By.id("ext-upload")).sendKeys("C:\\Users\\1120\\Pictures\\Screenshots\\New Text.txt");
				
				driver.findElement(By.id("ext-upload")).sendKeys("C:\\Users\\1120\\Pictures\\Screenshots\\Screenshot (133).png");
				Thread.sleep(2000);
				
				// Adding Tags

				getPageObject("Form_Tag1").sendKeys("Tag 1");
				getPageObject("Form_Tag2").sendKeys("Tag 2");
				getPageObject("Form_Tag3").sendKeys("Tag 3");
				Thread.sleep(1000);
				getPageObject("Form_Tag3").click();
				getPageObject("Form_Tag2").click();
				
				List<WebElement> Beforemovedfiles = driver.findElements(By.xpath("//div[@class='font-sm col-form-label elps']"));
				int nooffiles = Beforemovedfiles.size();
				System.out.println("No of Before files " + nooffiles);
				
				Thread.sleep(2000);
				click("Form_Submit");
				Thread.sleep(4000);
				
				getPageObject("Uploaded_successfully").isDisplayed();
				
				List<WebElement> Aftermovedfiles = driver.findElements(By.xpath("//img[@class='mr-1']"));
				int Aftermovedfilestofolder = Aftermovedfiles.size();
				System.out.println("No of After files " + Aftermovedfilestofolder);
				
				if(Aftermovedfilestofolder==3)
				{
					log.info("--------------------------------------------No of  files is  equal to before--------------------------------------------");

					captureScreenShot(ScreenShotsFilePath + "MyFiles_Upload_Forms_Verify_Form_Disabling_success.png");
					Thread.sleep(2000);
					ATUReports.add("MyFiles_Upload_Forms_Verify_Form_Disabling successfully","MyFiles_Upload_Forms_Verify_Form_Disabling",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					Thread.sleep(2000);
				}
				else
				{
					captureScreenShot(ScreenShotsFilePath + "MyFiles_Upload_Forms_Verify_Form_Disabling_failed.png");
					Thread.sleep(2000);
					ATUReports.add("MyFiles_Upload_Forms_Verify_Form_Disabling failed","MyFiles_Upload_Forms_Verify_Form_Disabling",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					Thread.sleep(2000);
				}
				
				

}
catch (Exception e)
{

	System.out.println("errror at: ");
	e.printStackTrace();
	log.error("Error in MyFiles_Upload_Forms_Verify_Form_Disabling",e);	
	//log.fatal(e.getMessage(),e);
	captureScreenShot(ScreenShotsFilePath + "MyFiles_Upload_Forms_Verify_Form_Disabling_failed_Error.png");
	ATUReports.add("MyFiles_Upload_Forms_Verify_Form_Disabling failed","MyFiles_Upload_Forms_Verify_Form_Disabling",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
}
}


				//--------------------------------MyFiles_Upload_Forms_Create_Form_By_Deactiving_Link----------------------------


public static void MyFiles_Upload_Forms_Create_Form_By_Deactiving_Link()
{

	try
	{

		actions = new Actions(driver);
		Actions act = new Actions(driver);
		Navigation.login();

		driver.get(Home_Page);
		WebDriverWait wait5 = new WebDriverWait(driver, 120);
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(text(),'My Files')])[1]")));
		
		WebElement ele = getPageObject("Folder_Form_Test");
		act.doubleClick(ele).perform();
		
		Thread.sleep(1000);
		click("Plus-Buttom");
		
		WebElement Upoadforms =	driver.findElement(By.xpath("(//span[contains(text(),'Upload Form')])[2]"));
		actions.moveToElement(Upoadforms).perform();
		Thread.sleep(2000);
		WebElement Create = driver.findElement(By.xpath("//span[contains(text(),'Create New')]"));
		Create.click();
		Thread.sleep(1000);
		
		// --Form Creating
				DateFormat dateFormat = new SimpleDateFormat("MMM-dd HH-mm");

				//get current date time with Date()
				Date date = new Date();

				// Now format the date
				String dateFormatted= dateFormat.format(date);

				String single_file_folder_name="Form "+dateFormatted;
				
				sendKeys("Enter_Form_Title",single_file_folder_name);
				Thread.sleep(1000);
				
				click("Form_Next");
				
		//--Form Settings
				click("Foem_Settings_Pencil");
				
				WebElement el11e = getPageObject("Right_Form_Test_click");
				actions.doubleClick(el11e).perform();
				Thread.sleep(2000);
				getPageObject("Create_Folder").click();
				Thread.sleep(1000);
				DateFormat dateFormat11 = new SimpleDateFormat("MMM-dd HH-mm");

				//get current date time with Date()
				Date date11 = new Date();

				// Now format the date
				String dateFormatted11= dateFormat11.format(date11);

				String single_file_folder_name11="Form Test "+dateFormatted11;
				
				sendKeys("Form_space_name",single_file_folder_name11);
				
				Thread.sleep(2000);
				click("Create_button");
				Thread.sleep(2000);
				click("Form_select");
				Thread.sleep(2000);
				getPageObject("Form_settings_Toggle").click();
				Thread.sleep(2000);
				click("Generate_Link");
				
				WebDriverWait wait4 = new WebDriverWait(driver, 60);
				wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Successfully submitted the form.')]")));
				Thread.sleep(2000);
				click("toast_close");
				
				click("Copy_Link");
				
				WebElement showLinkIn = driver.findElement(By.className("form-control"));
				String link_text = showLinkIn.getText();
				log.info("Copied link is : "+link_text);
				
				WebDriverWait wait53453 = new WebDriverWait(driver, 60);
				wait53453.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='Vue-Toastification__toast-body']")));
				
				
				if(getPageObject("starred_toast").getText().contains("Copied successfully."));
				
				String copied_link_text = driver.findElement(By.xpath("(//div[@class='input-group']//input[@type='text'])[2]")).getAttribute("value").toString();

				System.out.println("---------------------Copied link is : "+copied_link_text);
				click("File_share_close");
				
				WebDriverWait wait41 = new WebDriverWait(driver, 60);
				wait41.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Copied successfully.')]")));
				Thread.sleep(1000);
				click("toast_close");
				
				
				Thread.sleep(1000);
				click("Profile_Icon");
				Thread.sleep(2000);
				click("Sign_out");
				Thread.sleep(1000);
				click("Ok");

				WebDriverWait wait35 = new WebDriverWait(driver, 120);
				wait35.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));
				
				Thread.sleep(4000);
				driver.navigate().to(copied_link_text);
				Thread.sleep(3000);
				getPageObject("Form_Inactive").isDisplayed();
				
				Thread.sleep(2000);
		
				
}
catch (Exception e)
{

	System.out.println("errror at: ");
	e.printStackTrace();
	log.error("Error in MyFiles_Upload_Forms_Create_Form_By_Deactiving_Link",e);	
	//log.fatal(e.getMessage(),e);
	captureScreenShot(ScreenShotsFilePath + "MyFiles_Upload_Forms_Create_Form_By_Deactiving_Link_failed_Error.png");
	ATUReports.add("MyFiles_Upload_Forms_Create_Form_By_Deactiving_Link failed","MyFiles_Upload_Forms_Create_Form_By_Deactiving_Link",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
}
}


			//--------------------------MyFiles_Upload_Forms_Create_Form_By_Giving_Password------------------------



public static void MyFiles_Upload_Forms_Create_Form_By_Giving_Password()
{

	try
	{

		actions = new Actions(driver);
		Actions act = new Actions(driver);
		Navigation.login();

		driver.get(Home_Page);
		WebDriverWait wait5 = new WebDriverWait(driver, 120);
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(text(),'My Files')])[1]")));
		
		WebElement ele = getPageObject("Folder_Form_Test");
		act.doubleClick(ele).perform();
		

		Thread.sleep(1000);
		click("Plus-Buttom");
		
		WebElement Upoadforms =	driver.findElement(By.xpath("(//span[contains(text(),'Upload Form')])[2]"));
		actions.moveToElement(Upoadforms).perform();
		Thread.sleep(2000);
		WebElement Create = driver.findElement(By.xpath("//span[contains(text(),'Create New')]"));
		Create.click();
		Thread.sleep(1000);
		
		// --Form Creating
				DateFormat dateFormat = new SimpleDateFormat("MMM-dd HH-mm");

				//get current date time with Date()
				Date date = new Date();

				// Now format the date
				String dateFormatted= dateFormat.format(date);

				String single_file_folder_name="Form "+dateFormatted;
				
				sendKeys("Enter_Form_Title",single_file_folder_name);
				Thread.sleep(1000);
				
				click("Form_Next");
				
		//--Form Settings
				click("Foem_Settings_Pencil");
				
				WebElement el11e = getPageObject("Right_Form_Test_click");
				actions.doubleClick(el11e).perform();
				Thread.sleep(2000);
				getPageObject("Create_Folder").click();
				Thread.sleep(1000);
				DateFormat dateFormat11 = new SimpleDateFormat("MMM-dd HH-mm");

				//get current date time with Date()
				Date date11 = new Date();

				// Now format the date
				String dateFormatted11= dateFormat11.format(date11);

				String single_file_folder_name11="Form Test "+dateFormatted11;
				
				sendKeys("Form_space_name",single_file_folder_name11);
				
				Thread.sleep(2000);
				click("Create_button");
				Thread.sleep(2000);
				click("Form_select");
				Thread.sleep(2000);
				sendKeys("Form_setting_Password","Test@123");
				Thread.sleep(2000);
				click("Generate_Link");
				
				WebDriverWait wait4 = new WebDriverWait(driver, 60);
				wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Successfully submitted the form.')]")));
				Thread.sleep(2000);
				click("toast_close");
				
				click("Copy_Link");
				
				WebElement showLinkIn = driver.findElement(By.className("form-control"));
				String link_text = showLinkIn.getText();
				log.info("Copied link is : "+link_text);
				
				WebDriverWait wait53453 = new WebDriverWait(driver, 60);
				wait53453.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='Vue-Toastification__toast-body']")));
				
				
				if(getPageObject("starred_toast").getText().contains("Copied successfully."));
				
				String copied_link_text = driver.findElement(By.xpath("(//div[@class='input-group']//input[@type='text'])[2]")).getAttribute("value").toString();

				System.out.println("---------------------Copied link is : "+copied_link_text);
				click("File_share_close");
				
				WebDriverWait wait41 = new WebDriverWait(driver, 60);
				wait41.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Copied successfully.')]")));
				Thread.sleep(1000);
				click("toast_close");
				
				
				Thread.sleep(1000);
				click("Profile_Icon");
				Thread.sleep(2000);
				click("Sign_out");
				Thread.sleep(1000);
				click("Ok");

				WebDriverWait wait35 = new WebDriverWait(driver, 120);
				wait35.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));
				
				Thread.sleep(2000);
				driver.navigate().to(copied_link_text);
				
				sendKeys("Form_setting_Password","Test@123");
				Thread.sleep(2000);
				click("Form_Submit");
				
				// Adding Files
				Thread.sleep(2000);
				driver.findElement(By.id("ext-upload")).sendKeys("C:\\Users\\1120\\Pictures\\Screenshots\\Download.png");
					
				driver.findElement(By.id("ext-upload")).sendKeys("C:\\Users\\1120\\Pictures\\Screenshots\\New Text.txt");
				
				driver.findElement(By.id("ext-upload")).sendKeys("C:\\Users\\1120\\Pictures\\Screenshots\\Screenshot (133).png");
				Thread.sleep(2000);
				
				click("Form_Submit");
				Thread.sleep(2000);
				
				getPageObject("Uploaded_successfully").isDisplayed();
				Thread.sleep(1000);
				driver.navigate().back();
				
				Navigation.login();

				driver.get(Home_Page);
				WebDriverWait wait51 = new WebDriverWait(driver, 120);
				wait51.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(text(),'My Files')])[1]")));
				
				WebElement ele1 = getPageObject("Folder_Form_Test");
				act.doubleClick(ele1).perform();
				
				WebElement ele2 = getPageObject("Form_Test_4th_folder_click");
				act.doubleClick(ele2).perform();
				
				Thread.sleep(5000);
				
				Thread.sleep(1000);
				click("Profile_Icon");
				Thread.sleep(2000);
				click("Sign_out");
				Thread.sleep(1000);
				click("Ok");

				WebDriverWait wait351 = new WebDriverWait(driver, 120);
				wait351.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));
				
				
}
catch (Exception e)
{

	System.out.println("errror at: ");
	e.printStackTrace();
	log.error("Error in MyFiles_Upload_Forms_Create_Form_By_Giving_Password",e);	
	//log.fatal(e.getMessage(),e);
	captureScreenShot(ScreenShotsFilePath + "MyFiles_Upload_Forms_Create_Form_By_Giving_Password_failed_Error.png");
	ATUReports.add("MyFiles_Upload_Forms_Create_Form_By_Giving_Password failed","MyFiles_Upload_Forms_Create_Form_By_Giving_Password",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
}
}

		
				//------------------------------MyFiles_Upload_Forms_Create_Form_By_Giving_Expiry_Date----------------------------


public static void MyFiles_Upload_Forms_Create_Form_By_Giving_Expiry_Date()
{

	try
	{

		actions = new Actions(driver);
		Actions act = new Actions(driver);
		Navigation.login();

		driver.get(Home_Page);
		WebDriverWait wait5 = new WebDriverWait(driver, 120);
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(text(),'My Files')])[1]")));
		
		WebElement ele = getPageObject("Folder_Form_Test");
		act.doubleClick(ele).perform();
		

		Thread.sleep(1000);
		click("Plus-Buttom");
		
		WebElement Upoadforms =	driver.findElement(By.xpath("(//span[contains(text(),'Upload Form')])[2]"));
		actions.moveToElement(Upoadforms).perform();
		Thread.sleep(2000);
		WebElement Create = driver.findElement(By.xpath("//span[contains(text(),'Create New')]"));
		Create.click();
		Thread.sleep(1000);
		
		// --Form Creating
				DateFormat dateFormat = new SimpleDateFormat("MMM-dd HH-mm");

				//get current date time with Date()
				Date date = new Date();

				// Now format the date
				String dateFormatted= dateFormat.format(date);

				String single_file_folder_name="Form "+dateFormatted;
				
				sendKeys("Enter_Form_Title",single_file_folder_name);
				Thread.sleep(1000);
				
				click("Form_Next");
				
		//--Form Settings
				click("Foem_Settings_Pencil");
				
				WebElement el11e = getPageObject("Right_Form_Test_click");
				actions.doubleClick(el11e).perform();
				Thread.sleep(2000);
				getPageObject("Create_Folder").click();
				Thread.sleep(1000);
				DateFormat dateFormat11 = new SimpleDateFormat("MMM-dd HH-mm");

				//get current date time with Date()
				Date date11 = new Date();

				// Now format the date
				String dateFormatted11= dateFormat11.format(date11);

				String single_file_folder_name11="Form Test "+dateFormatted11;
				
				sendKeys("Form_space_name",single_file_folder_name11);
				
				Thread.sleep(2000);
				click("Create_button");
				Thread.sleep(2000);
				click("Form_select");
				Thread.sleep(2000);
				click("Form_setting_date");
				Thread.sleep(2000);
				click("Form_Today_Date");
				Thread.sleep(2000);
				click("Generate_Link");
				
				WebDriverWait wait4 = new WebDriverWait(driver, 60);
				wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Successfully submitted the form.')]")));
				Thread.sleep(2000);
				click("toast_close");
				
				click("Copy_Link");
				
				WebElement showLinkIn = driver.findElement(By.className("form-control"));
				String link_text = showLinkIn.getText();
				log.info("Copied link is : "+link_text);
				
				WebDriverWait wait53453 = new WebDriverWait(driver, 60);
				wait53453.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='Vue-Toastification__toast-body']")));
				
				
				if(getPageObject("starred_toast").getText().contains("Copied successfully."));
				
				String copied_link_text = driver.findElement(By.xpath("(//div[@class='input-group']//input[@type='text'])[2]")).getAttribute("value").toString();

				System.out.println("---------------------Copied link is : "+copied_link_text);
				click("File_share_close");
				
				WebDriverWait wait41 = new WebDriverWait(driver, 60);
				wait41.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Copied successfully.')]")));
				Thread.sleep(1000);
				click("toast_close");
				
				
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
	log.error("Error in MyFiles_Upload_Forms_Create_Form_By_Giving_Expiry_Date",e);	
	//log.fatal(e.getMessage(),e);
	captureScreenShot(ScreenShotsFilePath + "MyFiles_Upload_Forms_Create_Form_By_Giving_Expiry_Date_failed_Error.png");
	ATUReports.add("MyFiles_Upload_Forms_Create_Form_By_Giving_Expiry_Date failed","MyFiles_Upload_Forms_Create_Form_By_Giving_Expiry_Date",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
}
}

		
			//---------------------------MyFiles_Upload_Forms_Deactivating_Link_From_Existing_Forms_Page-------------------------------


public static void MyFiles_Upload_Forms_Deactivating_Link_From_Existing_Forms_Page()
{

	try
	{

		actions = new Actions(driver);
		Actions act = new Actions(driver);
		Navigation.login();

		driver.get(Home_Page);
		WebDriverWait wait5 = new WebDriverWait(driver, 120);
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(text(),'My Files')])[1]")));
		
		WebElement ele = getPageObject("Folder_Form_Test");
		act.doubleClick(ele).perform();
		

		Thread.sleep(1000);
		click("Plus-Buttom");
		
		WebElement Upoadforms =	driver.findElement(By.xpath("(//span[contains(text(),'Upload Form')])[2]"));
		actions.moveToElement(Upoadforms).perform();
		Thread.sleep(2000);
		WebElement Create = getPageObject("Form_Test_use_existing");
		Create.click();
		Thread.sleep(1000);
		
		getPageObject("Deactive_toggle").click();
		Thread.sleep(3000);
		
		WebDriverWait wait41 = new WebDriverWait(driver, 60);
		wait41.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Updated the form status successfully.')]")));
		Thread.sleep(1000);
		click("toast_close");
		
		Thread.sleep(2000);
		click("Inactive");
		Thread.sleep(2000);
		getPageObject("Inactive_pencil_click").click();
		Thread.sleep(1000);
		click("URl");
		
		click("Copy_Link");
		
		WebElement showLinkIn = driver.findElement(By.className("form-control"));
		String link_text = showLinkIn.getText();
		log.info("Copied link is : "+link_text);
		
		WebDriverWait wait53453 = new WebDriverWait(driver, 60);
		wait53453.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='Vue-Toastification__toast-body']")));
		
		
		if(getPageObject("starred_toast").getText().contains("Copied successfully."));
		
		String copied_link_text = driver.findElement(By.xpath("(//div[@class='input-group']//input[@type='text'])[2]")).getAttribute("value").toString();

		System.out.println("---------------------Copied link is : "+copied_link_text);
		click("File_share_close");
		
		WebDriverWait wait411 = new WebDriverWait(driver, 60);
		wait411.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Copied successfully.')]")));
		Thread.sleep(1000);
		click("toast_close");
		
		
		Thread.sleep(1000);
		click("Profile_Icon");
		Thread.sleep(2000);
		click("Sign_out");
		Thread.sleep(1000);
		click("Ok");

		WebDriverWait wait35 = new WebDriverWait(driver, 120);
		wait35.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));
		
		driver.navigate().to(copied_link_text);
		Thread.sleep(3000);
		getPageObject("Form_Inactive").isDisplayed();
		
		Thread.sleep(1000);
		driver.navigate().back();
		Thread.sleep(3000);
		driver.navigate().refresh();
}
catch (Exception e)
{

	System.out.println("errror at: ");
	e.printStackTrace();
	log.error("Error in MyFiles_Upload_Forms_Deactivating_Link_From_Existing_Forms_Page",e);	
	//log.fatal(e.getMessage(),e);
	captureScreenShot(ScreenShotsFilePath + "MyFiles_Upload_Forms_Deactivating_Link_From_Existing_Forms_Page_failed_Error.png");
	ATUReports.add("MyFiles_Upload_Forms_Deactivating_Link_From_Existing_Forms_Page failed","MyFiles_Upload_Forms_Deactivating_Link_From_Existing_Forms_Page",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
}
}

		
		//-----------------------------MyFiles_Upload_Forms_Activating_Link_From_Existing_Forms_Page----------------------------------


public static void MyFiles_Upload_Forms_Activating_Link_From_Existing_Forms_Page()
{

	try
	{

		actions = new Actions(driver);
		Actions act = new Actions(driver);
		Navigation.login();

		driver.get(Home_Page);
		WebDriverWait wait5 = new WebDriverWait(driver, 120);
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(text(),'My Files')])[1]")));
		
		WebElement ele = getPageObject("Folder_Form_Test");
		act.doubleClick(ele).perform();
		

		Thread.sleep(1000);
		click("Plus-Buttom");
		
		WebElement Upoadforms =	driver.findElement(By.xpath("(//span[contains(text(),'Upload Form')])[2]"));
		actions.moveToElement(Upoadforms).perform();
		Thread.sleep(2000);
		WebElement Create = getPageObject("Form_Test_use_existing");
		Create.click();
		Thread.sleep(2000);
		click("Inactive");
		getPageObject("Inactive_Toggle_Button").click();
		Thread.sleep(3000);
		
		WebDriverWait wait41 = new WebDriverWait(driver, 60);
		wait41.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Updated the form status successfully.')]")));
		Thread.sleep(1000);
		click("toast_close");
		
		Thread.sleep(2000);
		getPageObject("Exiciting_Form_Active").click();
		Thread.sleep(2000);
		getPageObject("Inactive_pencil_click").click();
		Thread.sleep(1000);
		click("URl");
		
		click("Copy_Link");
		
		WebElement showLinkIn = driver.findElement(By.className("form-control"));
		String link_text = showLinkIn.getText();
		log.info("Copied link is : "+link_text);
		
		WebDriverWait wait53453 = new WebDriverWait(driver, 60);
		wait53453.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='Vue-Toastification__toast-body']")));
		
		
		if(getPageObject("starred_toast").getText().contains("Copied successfully."));
		
		String copied_link_text = driver.findElement(By.xpath("(//div[@class='input-group']//input[@type='text'])[2]")).getAttribute("value").toString();

		System.out.println("---------------------Copied link is : "+copied_link_text);
		click("File_share_close");
		
		WebDriverWait wait411 = new WebDriverWait(driver, 60);
		wait411.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Copied successfully.')]")));
		Thread.sleep(1000);
		click("toast_close");
		
		
		Thread.sleep(1000);
		click("Profile_Icon");
		Thread.sleep(2000);
		click("Sign_out");
		Thread.sleep(1000);
		click("Ok");

		WebDriverWait wait35 = new WebDriverWait(driver, 120);
		wait35.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));
		
		driver.navigate().to(copied_link_text);
		Thread.sleep(3000);
		getPageObject("Form_name").isDisplayed();
		
		Thread.sleep(1000);
		driver.navigate().back();
		Thread.sleep(3000);
		driver.navigate().refresh();	
}
catch (Exception e)
{

	System.out.println("errror at: ");
	e.printStackTrace();
	log.error("Error in MyFiles_Upload_Forms_Activating_Link_From_Existing_Forms_Page",e);	
	//log.fatal(e.getMessage(),e);
	captureScreenShot(ScreenShotsFilePath + "MyFiles_Upload_Forms_Activating_Link_From_Existing_Forms_Page_failed_Error.png");
	ATUReports.add("MyFiles_Upload_Forms_Activating_Link_From_Existing_Forms_Page failed","MyFiles_Upload_Forms_Activating_Link_From_Existing_Forms_Page",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
}
}

		
		//--------------------------------MyFiles_Upload_Forms_Edit_Form_And_Change_The_Name----------------------------------



public static void MyFiles_Upload_Forms_Edit_Form_And_Change_The_Name()
{

	try
	{

		actions = new Actions(driver);
		Actions act = new Actions(driver);
		Navigation.login();

		driver.get(Home_Page);
		WebDriverWait wait5 = new WebDriverWait(driver, 120);
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(text(),'My Files')])[1]")));
		
		WebElement ele = getPageObject("Folder_Form_Test");
		act.doubleClick(ele).perform();
		
		Thread.sleep(1000);
		click("Plus-Buttom");
		
		WebElement Upoadforms =	driver.findElement(By.xpath("(//span[contains(text(),'Upload Form')])[2]"));
		actions.moveToElement(Upoadforms).perform();
		Thread.sleep(2000);
		WebElement Create = getPageObject("Form_Test_use_existing");
		Create.click();
		Thread.sleep(2000);
		getPageObject("Inactive_pencil_click").click();
		Thread.sleep(2000);
		getPageObject("Enter_Form_Title").clear();
		Thread.sleep(2000);
		
		// Date and Time
		DateFormat dateFormat111 = new SimpleDateFormat("MMM-dd HH-mm");

		//get current date time with Date()
		Date date111 = new Date();

		// Now format the date
		String dateFormatted111= dateFormat111.format(date111);

		String single_file_folder_name111="Edited Form "+dateFormatted111;
		
		sendKeys("Enter_Form_Title",single_file_folder_name111);
		Thread.sleep(2000);
		click("Form_Next");
		Thread.sleep(1000);
		click("Form_Update");
		
		WebDriverWait wait41 = new WebDriverWait(driver, 60);
		wait41.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Updated the form status successfully.')]")));
		Thread.sleep(1000);
		click("toast_close");
		
		Thread.sleep(2000);
		getPageObject("Inactive_pencil_click").click();
		Thread.sleep(1000);
		click("URl");
		
		click("Copy_Link");
		
		WebElement showLinkIn = driver.findElement(By.className("form-control"));
		String link_text = showLinkIn.getText();
		log.info("Copied link is : "+link_text);
		
		WebDriverWait wait53453 = new WebDriverWait(driver, 60);
		wait53453.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='Vue-Toastification__toast-body']")));
		
		
		if(getPageObject("starred_toast").getText().contains("Copied successfully."));
		
		String copied_link_text = driver.findElement(By.xpath("(//div[@class='input-group']//input[@type='text'])[2]")).getAttribute("value").toString();

		System.out.println("---------------------Copied link is : "+copied_link_text);
		click("File_share_close");
		
		WebDriverWait wait411 = new WebDriverWait(driver, 60);
		wait411.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Copied successfully.')]")));
		Thread.sleep(1000);
		click("toast_close");
		
		
		Thread.sleep(1000);
		click("Profile_Icon");
		Thread.sleep(2000);
		click("Sign_out");
		Thread.sleep(1000);
		click("Ok");

		WebDriverWait wait35 = new WebDriverWait(driver, 120);
		wait35.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));
		
		driver.navigate().to(copied_link_text);
		Thread.sleep(3000);
		getPageObject("Form_name").isDisplayed();
		
		Thread.sleep(1000);
		driver.navigate().back();
		Thread.sleep(3000);
		driver.navigate().refresh();
	
}
catch (Exception e)
{

	System.out.println("errror at: ");
	e.printStackTrace();
	log.error("Error in MyFiles_Upload_Forms_Edit_Form_And_Change_The_Name",e);	
	//log.fatal(e.getMessage(),e);
	captureScreenShot(ScreenShotsFilePath + "MyFiles_Upload_Forms_Edit_Form_And_Change_The_Name_failed_Error.png");
	ATUReports.add("MyFiles_Upload_Forms_Edit_Form_And_Change_The_Name failed","MyFiles_Upload_Forms_Edit_Form_And_Change_The_Name",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
}
}

	
			//--------------------------MyFiles_Upload_Forms_Deleted_The_Form_From_Active_List-------------------------------



public static void MyFiles_Upload_Forms_Deleted_The_Form_From_Active_List()
{

	try
	{

		actions = new Actions(driver);
		Actions act = new Actions(driver);
		Navigation.login();

		driver.get(Home_Page);
		WebDriverWait wait5 = new WebDriverWait(driver, 120);
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(text(),'My Files')])[1]")));
		
		WebElement ele = getPageObject("Folder_Form_Test");
		act.doubleClick(ele).perform();
		
		Thread.sleep(1000);
		click("Plus-Buttom");
		
		WebElement Upoadforms =	driver.findElement(By.xpath("(//span[contains(text(),'Upload Form')])[2]"));
		actions.moveToElement(Upoadforms).perform();
		Thread.sleep(2000);
		WebElement Create = getPageObject("Form_Test_use_existing");
		Create.click();
		Thread.sleep(2000);
		
		List<WebElement> BeforeRows = driver.findElements(By.xpath("//tr[@role='row']"));
		int noofRows = BeforeRows.size();
		System.out.println("No of Rows Before " + noofRows);
		
		getPageObject("Existing_Forms_Trash").click();
		Thread.sleep(2000);
		click("Trash_Delete");
		
		WebDriverWait wait411 = new WebDriverWait(driver, 60);
		wait411.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Deleted the form successfully.')]")));
		Thread.sleep(1000);
		click("toast_close");
		
		List<WebElement> AfterRows = driver.findElements(By.xpath("//tr[@role='row']"));
		int noofRows1 = AfterRows.size();
		System.out.println("No of Rows After " + noofRows1);
		
		click("view_Version_close");
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
	log.error("Error in MyFiles_Upload_Forms_Deleted_The_Form_From_Active_List",e);	
	//log.fatal(e.getMessage(),e);
	captureScreenShot(ScreenShotsFilePath + "MyFiles_Upload_Forms_Deleted_The_Form_From_Active_List_failed_Error.png");
	ATUReports.add("MyFiles_Upload_Forms_Deleted_The_Form_From_Active_List failed","MyFiles_Upload_Forms_Deleted_The_Form_From_Active_List",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
}
}


		//--------------------------MyFiles_Upload_Forms_Verify_Active_And_Inactive-------------------------------


public static void MyFiles_Upload_Forms_Verify_Active_And_Inactive()
{

	try
	{

		actions = new Actions(driver);
		Actions act = new Actions(driver);
		Navigation.login();

		driver.get(Home_Page);
		WebDriverWait wait5 = new WebDriverWait(driver, 120);
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(text(),'My Files')])[1]")));
		
		WebElement ele = getPageObject("Folder_Form_Test");
		act.doubleClick(ele).perform();
		
		Thread.sleep(1000);
		click("Plus-Buttom");
		
		WebElement Upoadforms =	driver.findElement(By.xpath("(//span[contains(text(),'Upload Form')])[2]"));
		actions.moveToElement(Upoadforms).perform();
		Thread.sleep(2000);
		WebElement Create = getPageObject("Form_Test_use_existing");
		Create.click();
		Thread.sleep(2000);
		getPageObject("Active_Toggle3").click();
		
		WebDriverWait wait411 = new WebDriverWait(driver, 60);
		wait411.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Updated the form status successfully.')]")));
		Thread.sleep(1000);
		click("toast_close");
		
		Thread.sleep(2000);
		getPageObject("Active_Toggle2").click();
		
		WebDriverWait wait41 = new WebDriverWait(driver, 60);
		wait41.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Updated the form status successfully.')]")));
		Thread.sleep(1000);
		click("toast_close");
		
		click("view_Version_close");
		Thread.sleep(1000);
		click("Profile_Icon");
		Thread.sleep(2000);
		click("Sign_out");
		Thread.sleep(1000);
		click("Ok");
}
catch (Exception e)
{

	System.out.println("errror at: ");
	e.printStackTrace();
	log.error("Error in MyFiles_Upload_Forms_Verify_Active_And_Inactive",e);	
	//log.fatal(e.getMessage(),e);
	captureScreenShot(ScreenShotsFilePath + "MyFiles_Upload_Forms_Verify_Active_And_Inactive_failed_Error.png");
	ATUReports.add("MyFiles_Upload_Forms_Verify_Active_And_Inactive failed","MyFiles_Upload_Forms_Verify_Active_And_Inactive",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
}
}
}


























