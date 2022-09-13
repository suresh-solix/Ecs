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


public class MyFiles_Share_User_to_Group extends Navigation {
	
	static WebDriver driver;
	static Actions actions;
  

	private static Logger log = Logger.getLogger(MyFiles_Share_User_to_Group.class.getName());
	public static String Home_Page = "https://app.solixecsdev.com/login";
	public MyFiles_Share_User_to_Group(WebDriver driver) {
		super(driver);
		this.driver = driver;
		//driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS).pageLoadTimeout(60, TimeUnit.SECONDS);
		ATUReports.setWebDriver(driver);
		ATUReports.setTestCaseReqCoverage("MyFiles_Share_User_to_Group");
		setIndexPageDescription();
		setAuthorInfoForReports();
		log.info("--------------------MyFiles_Share_User_to_Group--------------------");
		captureScreenShot(ScreenShotsFilePath + "MyFiles_Share_User_to_Group.png");
	}
	private void setAuthorInfoForReports() {
		ATUReports.setAuthorInfo("Mahesh", Utils.getCurrentTime(),"2.0");
	}

	private void setIndexPageDescription() {
		ATUReports.indexPageDescription = "MyFiles_Share_User_to_Group";
	}





//--------------------------------------MyFiles_share_User_to_Group_Edit_Permission----------------------------------


	public static void MyFiles_share_User_to_Group_Edit_Permission() 
	{

		try
		{

			actions = new Actions(driver);

			Navigation.other_user_in_same_tenant();

			driver.get(Home_Page);
			WebDriverWait wait5 = new WebDriverWait(driver, 120);
			wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
			//Double click on element
			WebElement ele = getPageObject("MyFiles_Share_User_to_Group"); 
			Actions act = new Actions(driver);
			act.doubleClick(ele).perform();
			//Double click on element

			WebElement ele1 = getPageObject("Files_And_Folders"); 
			act.doubleClick(ele1).perform();

			String file1 =driver.findElement(By.xpath("(//*[@class='fileName'])[1]")).getText();
			System.out.println(file1);

			String folder1 =driver.findElement(By.xpath("(//*[contains(text(),'fol 1')]) [2]")).getText();
			System.out.println(folder1);

			click("select_all_folders");
			click("select_all_files");
			WebElement right=	driver.findElement(By.xpath("//div[@class='files-info']"));
			actions.contextClick(right).perform();
			click("Share");


			WebElement noUserOr = driver.findElement(By.xpath("//input[@placeholder='Search Users or Groups']"));
			noUserOr.sendKeys("T");


			WebDriverWait wait31 = new WebDriverWait(driver, 60);
			wait31.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='multiselect__content']/li[1]")));

			getPageObject("search_result_first_element").click(); 
			Thread.sleep(2000);
			click("share_button");
			Thread.sleep(1000);
			click("share_button");

			WebDriverWait wait222 = new WebDriverWait(driver, 60);
			wait222.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Shared Successfully')]")));
			Thread.sleep(2000);
			click("toast_close");

			Thread.sleep(2000);
			click("Profile_Icon");
			Thread.sleep(1000);
			click("Sign_Out");
			click("Ok");
			Thread.sleep(5000);

			Navigation.login();

			WebDriverWait wait51 = new WebDriverWait(driver, 120);
			wait51.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));

			click("Profile_Icon");
			Thread.sleep(1000);
			click("Admin_Console");
			Thread.sleep(1000);
			click("Users_&_Groups");
			Thread.sleep(1000);
			click("Admin_Group");
			Thread.sleep(1000);
			click("Group_3dots");
			Thread.sleep(1000);
			click("View_Group");
			click("Content_Access");
			Thread.sleep(2000);

			Actions at = new Actions(driver);
			at.sendKeys(Keys.PAGE_DOWN).build().perform();

			Thread.sleep(1000);

			String file2 =driver.findElement(By.xpath("//div[contains(text(),'Sample 1.docx')]")).getText();
			System.out.println(file2);

			String folder2 =driver.findElement(By.xpath("//*[contains(text(),'fol 1')]")).getText();
			System.out.println(folder2);

			if(file1.equals(file2))
			{


				log.info("--------------------------No of Shared Files Folders is  equal to before------------------------------");

				captureScreenShot(ScreenShotsFilePath +"MyFiles_share_User_to_Group_Edit_Permission_success.png");
				Thread.sleep(2000);
				ATUReports.add("MyFiles_share_User_to_Group_Edit_Permission successfully","MyFiles_share_User_to_Group_Edit_Permission",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
				Thread.sleep(2000); 
			}
			else 
			{
				captureScreenShot(ScreenShotsFilePath + "MyFiles_share_User_to_Group_Edit_Permissionn_failed.png");
				Thread.sleep(2000);
				ATUReports.add("MyFiles_share_User_to_Group_Edit_Permission failed","MyFiles_share_User_to_Group_Edit_Permission",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}

			if(folder1.equals(folder2))
			{


				log.info("--------------------------No of Shared Files Folders is  equal to before------------------------------");

				captureScreenShot(ScreenShotsFilePath + "MyFiles_share_User_to_Group_Edit_Permission_success.png");
				Thread.sleep(2000);
				ATUReports.add("MyFiles_share_User_to_Group_Edit_Permission successfully","MyFiles_share_User_to_Group_Edit_Permission",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}

			else 
			{
				captureScreenShot(ScreenShotsFilePath + "MyFiles_share_User_to_Group_Edit_Permission_failed.png");
				Thread.sleep(2000);
				ATUReports.add("MyFiles_share_User_to_Group_Edit_Permission failed","MyFiles_share_User_to_Group_Edit_Permission",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}

			click("Profile_Icon");
			Thread.sleep(1000);
			click("My_Files");

			click("shared_with_me");

			String file3 =driver.findElement(By.xpath("//div[contains(text(),'Sample 1.docx')]")).getText();
			System.out.println(file3);

			String folder3 =driver.findElement(By.xpath("//div[contains(text(),'fol 1')]")).getText();
			System.out.println(folder3);

			if(file1.equals(file3))
			{


				log.info("--------------------------No of Shared Files Folders is  equal to before------------------------------");

				captureScreenShot(ScreenShotsFilePath +"MyFiles_share_User_to_Group_Edit_Permission_success.png");
				Thread.sleep(2000);
				ATUReports.add("MyFiles_share_User_to_Group_Edit_Permission successfully","MyFiles_share_User_to_Group_Edit_Permission",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
				Thread.sleep(2000); 
			}
			else 
			{
				captureScreenShot(ScreenShotsFilePath + "MyFiles_share_User_to_Group_Edit_Permission_failed.png");
				Thread.sleep(2000);
				ATUReports.add("MyFiles_share_User_to_Group_Edit_Permission failed","MyFiles_share_User_to_Group_Edit_Permission",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}

			if(folder1.equals(folder3))
			{


				log.info("--------------------------No of Shared Files Folders is  equal to before------------------------------");

				captureScreenShot(ScreenShotsFilePath + "MyFiles_share_User_to_Group_Edit_Permission_success.png");
				Thread.sleep(2000);
				ATUReports.add("MyFiles_share_User_to_Group_Edit_Permission successfully","MyFiles_share_User_to_Group_Edit_Permission",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}

			else 
			{
				captureScreenShot(ScreenShotsFilePath + "MyFiles_share_User_to_Group_Edit_Permission_failed.png");
				Thread.sleep(2000);
				ATUReports.add("MyFiles_share_User_to_Group_Edit_Permission failed","MyFiles_share_User_to_Group_Edit_Permission",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}

			WebElement ele11 = getPageObject("fol_1"); 
			act.doubleClick(ele11).perform();
			Thread.sleep(1000);

			WebElement right1=	driver.findElement(By.xpath("//div[contains(text(),'fol 2')]"));
			actions.contextClick(right1).perform();

			WebElement shared_folder_right_click_options = driver.findElement(By.xpath("//div[@class='folder']/div[@class='row'][1]/following-sibling::div/ul"));
			List<WebElement> each_folder_li_tag=shared_folder_right_click_options.findElements(By.tagName("li"));


			for(int i=0;i<each_folder_li_tag.size();i++)
			{
				WebElement shared_folder_right_click_options1 =each_folder_li_tag.get(i);
				String each_li = each_folder_li_tag.get(i).getText();
				log.info("Shared folder right click options "+each_li);

				if(each_li.contains("Share +") || each_li.contains("Add/View Comment") || each_li.contains("Add/View Tags") || each_li.contains("External Sharing") || each_li.contains("Copy / Move") || each_li.contains("Download") || each_li.contains("Add Reminders") || each_li.contains("Rename") || each_li.contains("Export Metadata") || each_li.contains("Trash"))
				{
					log.info("folder right click option exist");
					Thread.sleep(2000);

				}
				else
				{
					log.info("folder right click option does not exist");
					ATUReports.add("folder right click option failed","folder right click option",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}
			} 

			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ESCAPE);
			robot.keyRelease(KeyEvent.VK_ESCAPE);
			Thread.sleep(2000);	

			WebDriverWait wait3122 = new WebDriverWait(driver, 60);
			wait3122.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[contains(text(),'Folders')]")));

			WebElement elementLocator9 = getPageObject("share_first_file");
			actions.contextClick(elementLocator9).perform();
			Thread.sleep(2000);

			WebElement shared_file_right_click_options = driver.findElement(By.xpath("//div[@class='files']/div[2][@class='context-list']/ul"));
			List<WebElement> each_file_li_tag=shared_file_right_click_options.findElements(By.tagName("li"));

			for(int i=0;i<each_file_li_tag.size();i++)
			{

				WebElement li =each_file_li_tag.get(i);
				String each_li = each_file_li_tag.get(i).getText();
				log.info("Shared file right click options "+each_li);

				if( each_li.contains("Preview") || each_li.contains("Share +") || each_li.contains("Add/View Comment") || each_li.contains("Add/View Tags") || each_li.contains("Add to Collection") || each_li.contains("External Sharing") || each_li.contains("Copy / Move") || each_li.contains("Download") || each_li.contains("Add Reminders") || each_li.contains("Rename") || each_li.contains("View Versions") || each_li.contains("Trash"))
				{
					log.info("file right click option exist");
					Thread.sleep(2000);

				}
				else
				{
					log.info("file right click option does not exist");
					ATUReports.add("folder right click option failed","folder right click option",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}
			}
			Thread.sleep(1000);
			click("Profile_Icon");
			click("Sign_out");
			click("Ok");
			Thread.sleep(4000);

			Navigation.other_user_in_same_tenant();

			WebDriverWait wait511 = new WebDriverWait(driver, 120);
			wait511.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
			click("shared_with_me");

			WebElement ele111 = getPageObject("fol_1"); 
			act.doubleClick(ele111).perform();
			Thread.sleep(1000);

			WebElement right11=	driver.findElement(By.xpath("//div[contains(text(),'fol 2')]"));
			actions.contextClick(right11).perform();

			WebElement shared_folder_right_click_options1 = driver.findElement(By.xpath("//div[@class='folder']/div[@class='row'][1]/following-sibling::div/ul"));
			List<WebElement> each_folder_li_tag1=shared_folder_right_click_options1.findElements(By.tagName("li"));


			for(int i=0;i<each_folder_li_tag1.size();i++)
			{
				WebElement shared_folder_right_click_options11 =each_folder_li_tag1.get(i);
				String each_li = each_folder_li_tag1.get(i).getText();
				log.info("Shared folder right click options "+each_li);

				if(each_li.contains("Share +") || each_li.contains("Add/View Comment") || each_li.contains("Add/View Tags") || each_li.contains("External Sharing") || each_li.contains("Copy / Move") || each_li.contains("Download") || each_li.contains("Add Reminders") || each_li.contains("Rename") || each_li.contains("Export Metadata") || each_li.contains("Trash"))
				{
					log.info("folder right click option exist");
					Thread.sleep(2000);

				}
				else
				{
					log.info("folder right click option does not exist");
					ATUReports.add("folder right click option failed","folder right click option",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}
			} 

			Robot robot1 = new Robot();
			robot1.keyPress(KeyEvent.VK_ESCAPE);
			robot1.keyRelease(KeyEvent.VK_ESCAPE);
			Thread.sleep(2000);	

			WebDriverWait wait31221 = new WebDriverWait(driver, 60);
			wait31221.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[contains(text(),'Folders')]")));

			WebElement elementLocator91 = getPageObject("share_first_file");
			actions.contextClick(elementLocator91).perform();
			Thread.sleep(2000);

			WebElement shared_file_right_click_options1 = driver.findElement(By.xpath("//div[@class='files']/div[2][@class='context-list']/ul"));
			List<WebElement> each_file_li_tag1=shared_file_right_click_options1.findElements(By.tagName("li"));

			for(int i=0;i<each_file_li_tag1.size();i++)
			{

				WebElement li =each_file_li_tag1.get(i);
				String each_li = each_file_li_tag1.get(i).getText();
				log.info("Shared file right click options "+each_li);

				if( each_li.contains("Preview") || each_li.contains("Share +") || each_li.contains("Add/View Comment") || each_li.contains("Add/View Tags") || each_li.contains("Add to Collection") || each_li.contains("External Sharing") || each_li.contains("Copy / Move") || each_li.contains("Download") || each_li.contains("Add Reminders") || each_li.contains("Rename") || each_li.contains("View Versions") || each_li.contains("Trash"))
				{
					log.info("file right click option exist");
					Thread.sleep(2000);

				}
				else
				{
					log.info("file right click option does not exist");
					ATUReports.add("folder right click option failed","folder right click option",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}
			}
			Thread.sleep(2000);
			click("Profile_Icon");
			Thread.sleep(1000);
			click("Sign_out");
			click("Ok");
			Thread.sleep(4000);

		}
		catch (Exception e)
		{

			System.out.println("errror at: ");
			e.printStackTrace();
			log.error("Error in MyFiles_share_User_to_Group_Edit_Permission",e);	
			//log.fatal(e.getMessage(),e);
			captureScreenShot(ScreenShotsFilePath + "MyFiles_share_User_to_Group_Edit_Permission_Error.png");
			ATUReports.add("MyFiles_share_User_to_Group_Edit_Permission failed","MyFiles_share_User_to_Group_Edit_Permission",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}
	}



	//----------------------------------------MyFiles_share_User_to_Group_Commenter_Permission-----------------------------

	public static void MyFiles_share_User_to_Group_Commenter_Permission() 
	{

		try
		{

			actions = new Actions(driver);

			Navigation.other_user_in_same_tenant();

			driver.get(Home_Page);
			WebDriverWait wait5 = new WebDriverWait(driver, 120);
			wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
			//Double click on element
			WebElement ele = getPageObject("MyFiles_Share_User_to_Group"); 
			Actions act = new Actions(driver);
			act.doubleClick(ele).perform();
			//Double click on element

			WebElement ele1 = getPageObject("Files_And_Folders"); 
			act.doubleClick(ele1).perform();

			String file1 =driver.findElement(By.xpath("(//*[@class='fileName'])[1]")).getText();
			System.out.println(file1);

			String folder1 =driver.findElement(By.xpath("(//*[contains(text(),'fol 1')]) [2]")).getText();
			System.out.println(folder1);

			click("select_all_folders");
			click("select_all_files");
			WebElement right=	driver.findElement(By.xpath("//div[@class='files-info']"));
			actions.contextClick(right).perform();
			click("Share");

			select("shared_user_popup_dropdown","visibletext","Commenter");
			Thread.sleep(2000);
			click("share_button");
			Thread.sleep(1000);

			WebDriverWait wait222 = new WebDriverWait(driver, 60);
			wait222.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Shared Successfully')]")));
			Thread.sleep(2000);
			click("toast_close");

			Thread.sleep(2000);
			click("Profile_Icon");
			Thread.sleep(1000);
			click("Sign_Out");
			click("Ok");
			Thread.sleep(5000);

			Navigation.login();

			WebDriverWait wait51 = new WebDriverWait(driver, 120);
			wait51.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));

			click("Profile_Icon");
			Thread.sleep(1000);
			click("Admin_Console");
			Thread.sleep(1000);
			click("Users_&_Groups");
			Thread.sleep(1000);
			click("Admin_Group");
			Thread.sleep(1000);
			click("Group_3dots");
			Thread.sleep(1000);
			click("View_Group");
			click("Content_Access");
			Thread.sleep(1000);

			Actions at = new Actions(driver);
			at.sendKeys(Keys.PAGE_DOWN).build().perform();

			Thread.sleep(1000);

			String file2 =driver.findElement(By.xpath("//div[contains(text(),'Sample 1.docx')]")).getText();
			System.out.println(file2);

			String folder2 =driver.findElement(By.xpath("//*[contains(text(),'fol 1')]")).getText();
			System.out.println(folder2);

			if(file1.equals(file2))
			{


				log.info("--------------------------No of Shared Files Folders is  equal to before------------------------------");

				captureScreenShot(ScreenShotsFilePath +"MyFiles_share_User_to_Group_Commenter_Permission_success.png");
				Thread.sleep(2000);
				ATUReports.add("MyFiles_share_User_to_Group_Commenter_Permission successfully","MyFiles_share_User_to_Group_Commenter_Permission",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
				Thread.sleep(2000); 
			}
			else 
			{
				captureScreenShot(ScreenShotsFilePath + "MyFiles_share_User_to_Group_Commenter_Permission_failed.png");
				Thread.sleep(2000);
				ATUReports.add("MyFiles_share_User_to_Group_Commenter_Permission failed","MyFiles_share_User_to_Group_Commenter_Permission",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}

			if(folder1.equals(folder2))
			{


				log.info("--------------------------No of Shared Files Folders is  equal to before------------------------------");

				captureScreenShot(ScreenShotsFilePath + "MyFiles_share_User_to_Group_Commenter_Permission_success.png");
				Thread.sleep(2000);
				ATUReports.add("MyFiles_share_User_to_Group_Commenter_Permission successfully","MyFiles_share_User_to_Group_Commenter_Permission",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}

			else 
			{
				captureScreenShot(ScreenShotsFilePath + "MyFiles_share_User_to_Group_Commenter_Permission_failed.png");
				Thread.sleep(2000);
				ATUReports.add("MyFiles_share_User_to_Group_Commenter_Permission failed","MyFiles_share_User_to_Group_Commenter_Permission",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}

			click("Profile_Icon");
			Thread.sleep(1000);
			click("My_Files");

			click("shared_with_me");

			String file3 =driver.findElement(By.xpath("//div[contains(text(),'Sample 1.docx')]")).getText();
			System.out.println(file3);

			String folder3 =driver.findElement(By.xpath("//div[contains(text(),'fol 1')]")).getText();
			System.out.println(folder3);

			if(file1.equals(file3))
			{


				log.info("--------------------------No of Shared Files Folders is  equal to before------------------------------");

				captureScreenShot(ScreenShotsFilePath +"MyFiles_share_User_to_Group_Commenter_Permission_success.png");
				Thread.sleep(2000);
				ATUReports.add("MyFiles_share_User_to_Group_Commenter_Permission successfully","MyFiles_share_User_to_Group_Commenter_Permission",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
				Thread.sleep(2000); 
			}
			else 
			{
				captureScreenShot(ScreenShotsFilePath + "MyFiles_share_User_to_Group_Commenter_Permission_failed.png");
				Thread.sleep(2000);
				ATUReports.add("MyFiles_share_User_to_Group_Commenter_Permission failed","MyFiles_share_User_to_Group_Commenter_Permission",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}

			if(folder1.equals(folder3))
			{


				log.info("--------------------------No of Shared Files Folders is  equal to before------------------------------");

				captureScreenShot(ScreenShotsFilePath + "MyFiles_share_User_to_Group_Commenter_Permission_success.png");
				Thread.sleep(2000);
				ATUReports.add("MyFiles_share_User_to_Group_Commenter_Permission successfully","MyFiles_share_User_to_Group_Commenter_Permission",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}

			else 
			{
				captureScreenShot(ScreenShotsFilePath + "MyFiles_share_User_to_Group_Commenter_Permission_failed.png");
				Thread.sleep(2000);
				ATUReports.add("MyFiles_share_User_to_Group_Commenter_Permission failed","MyFiles_share_User_to_Group_Commenter_Permission",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}

			WebElement ele11 = getPageObject("fol_1"); 
			act.doubleClick(ele11).perform();
			Thread.sleep(1000);

			WebElement right1=	driver.findElement(By.xpath("//div[contains(text(),'fol 2')]"));
			actions.contextClick(right1).perform();

			WebElement shared_folder_right_click_options = driver.findElement(By.xpath("//div[@class='folder']/div[@class='row'][1]/following-sibling::div/ul"));
			List<WebElement> each_folder_li_tag=shared_folder_right_click_options.findElements(By.tagName("li"));


			for(int i=0;i<each_folder_li_tag.size();i++)
			{
				WebElement shared_folder_right_click_options1 =each_folder_li_tag.get(i);
				String each_li = each_folder_li_tag.get(i).getText();
				log.info("Shared folder right click options "+each_li);

				if(each_li.contains("Share +") || each_li.contains("Add/View Comment") || each_li.contains("Add/View Tags") || each_li.contains("External Sharing") || each_li.contains("Copy / Move") || each_li.contains("Download") || each_li.contains("Add Reminders") || each_li.contains("Rename") || each_li.contains("Export Metadata") || each_li.contains("Trash"))
				{
					log.info("folder right click option exist");
					Thread.sleep(2000);

				}
				else
				{
					log.info("folder right click option does not exist");
					ATUReports.add("folder right click option failed","folder right click option",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}
			} 

			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ESCAPE);
			robot.keyRelease(KeyEvent.VK_ESCAPE);
			Thread.sleep(2000);	

			WebDriverWait wait3122 = new WebDriverWait(driver, 60);
			wait3122.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[contains(text(),'Folders')]")));

			WebElement elementLocator9 = getPageObject("share_first_file");
			actions.contextClick(elementLocator9).perform();
			Thread.sleep(2000);

			WebElement shared_file_right_click_options = driver.findElement(By.xpath("//div[@class='files']/div[2][@class='context-list']/ul"));
			List<WebElement> each_file_li_tag=shared_file_right_click_options.findElements(By.tagName("li"));

			for(int i=0;i<each_file_li_tag.size();i++)
			{

				WebElement li =each_file_li_tag.get(i);
				String each_li = each_file_li_tag.get(i).getText();
				log.info("Shared file right click options "+each_li);

				if( each_li.contains("Preview") || each_li.contains("Share +") || each_li.contains("Add/View Comment") || each_li.contains("Add/View Tags") || each_li.contains("Add to Collection") || each_li.contains("External Sharing") || each_li.contains("Copy / Move") || each_li.contains("Download") || each_li.contains("Add Reminders") || each_li.contains("Rename") || each_li.contains("View Versions") || each_li.contains("Trash"))
				{
					log.info("file right click option exist");
					Thread.sleep(2000);

				}
				else
				{
					log.info("file right click option does not exist");
					ATUReports.add("folder right click option failed","folder right click option",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}
			}
			Thread.sleep(1000);
			click("Profile_Icon");
			Thread.sleep(1000);
			click("Sign_out");
			Thread.sleep(1000);
			click("Ok");
			Thread.sleep(4000);

			Navigation.other_user_in_same_tenant();

			WebDriverWait wait511 = new WebDriverWait(driver, 120);
			wait511.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
			click("shared_with_me");

			WebElement ele111 = getPageObject("fol_1"); 
			act.doubleClick(ele111).perform();
			Thread.sleep(1000);

			WebElement right11=	driver.findElement(By.xpath("//div[contains(text(),'fol 2')]"));
			actions.contextClick(right11).perform();

			WebElement shared_folder_right_click_options1 = driver.findElement(By.xpath("//div[@class='folder']/div[@class='row'][1]/following-sibling::div/ul"));
			List<WebElement> each_folder_li_tag1=shared_folder_right_click_options1.findElements(By.tagName("li"));


			for(int i=0;i<each_folder_li_tag1.size();i++)
			{
				WebElement shared_folder_right_click_options11 =each_folder_li_tag1.get(i);
				String each_li = each_folder_li_tag1.get(i).getText();
				log.info("Shared folder right click options "+each_li);

				if(each_li.contains("Share +") || each_li.contains("Add/View Comment") || each_li.contains("Add/View Tags") || each_li.contains("External Sharing") || each_li.contains("Copy / Move") || each_li.contains("Download") || each_li.contains("Add Reminders") || each_li.contains("Rename") || each_li.contains("Export Metadata") || each_li.contains("Trash"))
				{
					log.info("folder right click option exist");
					Thread.sleep(2000);

				}
				else
				{
					log.info("folder right click option does not exist");
					ATUReports.add("folder right click option failed","folder right click option",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}
			} 

			Robot robot1 = new Robot();
			robot1.keyPress(KeyEvent.VK_ESCAPE);
			robot1.keyRelease(KeyEvent.VK_ESCAPE);
			Thread.sleep(2000);	

			WebDriverWait wait31221 = new WebDriverWait(driver, 60);
			wait31221.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[contains(text(),'Folders')]")));

			WebElement elementLocator91 = getPageObject("share_first_file");
			actions.contextClick(elementLocator91).perform();
			Thread.sleep(2000);

			WebElement shared_file_right_click_options1 = driver.findElement(By.xpath("//div[@class='files']/div[2][@class='context-list']/ul"));
			List<WebElement> each_file_li_tag1=shared_file_right_click_options1.findElements(By.tagName("li"));

			for(int i=0;i<each_file_li_tag1.size();i++)
			{

				WebElement li =each_file_li_tag1.get(i);
				String each_li = each_file_li_tag1.get(i).getText();
				log.info("Shared file right click options "+each_li);

				if( each_li.contains("Preview") || each_li.contains("Share +") || each_li.contains("Add/View Comment") || each_li.contains("Add/View Tags") || each_li.contains("Add to Collection") || each_li.contains("External Sharing") || each_li.contains("Copy / Move") || each_li.contains("Download") || each_li.contains("Add Reminders") || each_li.contains("Rename") || each_li.contains("View Versions") || each_li.contains("Trash"))
				{
					log.info("file right click option exist");
					Thread.sleep(2000);

				}
				else
				{
					log.info("file right click option does not exist");
					ATUReports.add("folder right click option failed","folder right click option",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}
			}
			Thread.sleep(1000);
			click("Profile_Icon");
			Thread.sleep(1000);
			click("Sign_out");
			Thread.sleep(1000);
			click("Ok");
			Thread.sleep(4000);

		}
		catch (Exception e)
		{

			System.out.println("errror at: ");
			e.printStackTrace();
			log.error("Error in MyFiles_share_User_to_Group_Commenter_Permission",e);	
			//log.fatal(e.getMessage(),e);
			captureScreenShot(ScreenShotsFilePath + "MyFiles_share_User_to_Group_Commenter_Permission_Error.png");
			ATUReports.add("MyFiles_share_User_to_Group_Commenter_Permission failed","MyFiles_share_User_to_Group_Commenter_Permission",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}
	}



	
	//-----------------------------------MyFiles_share_User_to_Group_View_Permission-------------------------------------


	public static void MyFiles_share_User_to_Group_View_Permission() 
	{

		try
		{

			actions = new Actions(driver);

			Navigation.other_user_in_same_tenant();

			driver.get(Home_Page);
			WebDriverWait wait5 = new WebDriverWait(driver, 120);
			wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
			//Double click on element
			WebElement ele = getPageObject("MyFiles_Share_User_to_Group"); 
			Actions act = new Actions(driver);
			act.doubleClick(ele).perform();
			//Double click on element

			WebElement ele1 = getPageObject("Files_And_Folders"); 
			act.doubleClick(ele1).perform();

			String file1 =driver.findElement(By.xpath("(//*[@class='fileName'])[1]")).getText();
			System.out.println(file1);

			String folder1 =driver.findElement(By.xpath("(//*[contains(text(),'fol 1')]) [2]")).getText();
			System.out.println(folder1);

			click("select_all_folders");
			click("select_all_files");
			WebElement right=	driver.findElement(By.xpath("//div[@class='files-info']"));
			actions.contextClick(right).perform();
			click("Share");
			Thread.sleep(2000);

	
			select("shared_user_popup_dropdown","visibletext","View");
			Thread.sleep(2000);
			click("share_button");
			Thread.sleep(1000);

			WebDriverWait wait222 = new WebDriverWait(driver, 60);
			wait222.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Shared Successfully')]")));
			Thread.sleep(2000);
			click("toast_close");

			Thread.sleep(2000);
			click("Profile_Icon");
			Thread.sleep(1000);
			click("Sign_Out");
			click("Ok");
			Thread.sleep(5000);

			Navigation.login();

			WebDriverWait wait51 = new WebDriverWait(driver, 120);
			wait51.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));

			click("Profile_Icon");
			Thread.sleep(1000);
			click("Admin_Console");
			Thread.sleep(1000);
			click("Users_&_Groups");
			Thread.sleep(1000);
			click("Admin_Group");
			Thread.sleep(1000);
			click("Group_3dots");
			Thread.sleep(1000);
			click("View_Group");
			click("Content_Access");
			Thread.sleep(1000);

			Actions at = new Actions(driver);
			at.sendKeys(Keys.PAGE_DOWN).build().perform();

			Thread.sleep(1000);

			String file2 =driver.findElement(By.xpath("//div[contains(text(),'Sample 1.docx')]")).getText();
			System.out.println(file2);

			String folder2 =driver.findElement(By.xpath("//*[contains(text(),'fol 1')]")).getText();
			System.out.println(folder2);

			if(file1.equals(file2))
			{


				log.info("--------------------------No of Shared Files Folders is  equal to before------------------------------");

				captureScreenShot(ScreenShotsFilePath +"MyFiles_share_User_to_Group_View_Permission_success.png");
				Thread.sleep(2000);
				ATUReports.add("MyFiles_share_User_to_Group_View_Permission successfully","MyFiles_share_User_to_Group_View_Permission",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
				Thread.sleep(2000); 
			}
			else 
			{
				captureScreenShot(ScreenShotsFilePath + "MyFiles_share_User_to_Group_View_Permission_failed.png");
				Thread.sleep(2000);
				ATUReports.add("MyFiles_share_User_to_Group_View_Permission failed","MyFiles_share_User_to_Group_View_Permission",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}

			if(folder1.equals(folder2))
			{


				log.info("--------------------------No of Shared Files Folders is  equal to before------------------------------");

				captureScreenShot(ScreenShotsFilePath + "MyFiles_share_User_to_Group_View_Permission_success.png");
				Thread.sleep(2000);
				ATUReports.add("MyFiles_share_User_to_Group_View_Permission successfully","MyFiles_share_User_to_Group_View_Permission",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}

			else 
			{
				captureScreenShot(ScreenShotsFilePath + "MyFiles_share_User_to_Group_View_Permission_failed.png");
				Thread.sleep(2000);
				ATUReports.add("MyFiles_share_User_to_Group_View_Permission failed","MyFiles_share_User_to_Group_View_Permission",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}

			click("Profile_Icon");
			Thread.sleep(1000);
			click("My_Files");

			click("shared_with_me");

			String file3 =driver.findElement(By.xpath("//div[contains(text(),'Sample 1.docx')]")).getText();
			System.out.println(file3);

			String folder3 =driver.findElement(By.xpath("//div[contains(text(),'fol 1')]")).getText();
			System.out.println(folder3);

			if(file1.equals(file3))
			{


				log.info("--------------------------No of Shared Files Folders is  equal to before------------------------------");

				captureScreenShot(ScreenShotsFilePath +"MyFiles_share_User_to_Group_View_Permission_success.png");
				Thread.sleep(2000);
				ATUReports.add("MyFiles_share_User_to_Group_View_Permission successfully","MyFiles_share_User_to_Group_View_Permission",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
				Thread.sleep(2000); 
			}
			else 
			{
				captureScreenShot(ScreenShotsFilePath + "MyFiles_share_User_to_Group_View_Permission_failed.png");
				Thread.sleep(2000);
				ATUReports.add("MyFiles_share_User_to_Group_View_Permission failed","MyFiles_share_User_to_Group_View_Permission",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}

			if(folder1.equals(folder3))
			{


				log.info("--------------------------No of Shared Files Folders is  equal to before------------------------------");

				captureScreenShot(ScreenShotsFilePath + "MyFiles_share_User_to_Group_View_Permission_success.png");
				Thread.sleep(2000);
				ATUReports.add("MyFiles_share_User_to_Group_View_Permission successfully","MyFiles_share_User_to_Group_View_Permission",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}

			else 
			{
				captureScreenShot(ScreenShotsFilePath + "MyFiles_share_User_to_Group_View_Permission_failed.png");
				Thread.sleep(2000);
				ATUReports.add("MyFiles_share_User_to_Group_View_Permission failed","MyFiles_share_User_to_Group_View_Permission",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}

			WebElement ele11 = getPageObject("fol_1"); 
			act.doubleClick(ele11).perform();
			Thread.sleep(1000);

			WebElement right1=	driver.findElement(By.xpath("//div[contains(text(),'fol 2')]"));
			actions.contextClick(right1).perform();

			WebElement shared_folder_right_click_options = driver.findElement(By.xpath("//div[@class='folder']/div[@class='row'][1]/following-sibling::div/ul"));
			List<WebElement> each_folder_li_tag=shared_folder_right_click_options.findElements(By.tagName("li"));


			for(int i=0;i<each_folder_li_tag.size();i++)
			{
				WebElement shared_folder_right_click_options1 =each_folder_li_tag.get(i);
				String each_li = each_folder_li_tag.get(i).getText();
				log.info("Shared folder right click options "+each_li);

				if(each_li.contains("Share +") || each_li.contains("Add/View Comment") || each_li.contains("Add/View Tags") || each_li.contains("External Sharing") || each_li.contains("Copy / Move") || each_li.contains("Download") || each_li.contains("Add Reminders") || each_li.contains("Rename") || each_li.contains("Export Metadata") || each_li.contains("Trash"))
				{
					log.info("folder right click option exist");
					Thread.sleep(2000);

				}
				else
				{
					log.info("folder right click option does not exist");
					ATUReports.add("folder right click option failed","folder right click option",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}
			} 

			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ESCAPE);
			robot.keyRelease(KeyEvent.VK_ESCAPE);
			Thread.sleep(2000);	

			WebDriverWait wait3122 = new WebDriverWait(driver, 60);
			wait3122.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[contains(text(),'Folders')]")));

			WebElement elementLocator9 = getPageObject("share_first_file");
			actions.contextClick(elementLocator9).perform();
			Thread.sleep(2000);

			WebElement shared_file_right_click_options = driver.findElement(By.xpath("//div[@class='files']/div[2][@class='context-list']/ul"));
			List<WebElement> each_file_li_tag=shared_file_right_click_options.findElements(By.tagName("li"));

			for(int i=0;i<each_file_li_tag.size();i++)
			{

				WebElement li =each_file_li_tag.get(i);
				String each_li = each_file_li_tag.get(i).getText();
				log.info("Shared file right click options "+each_li);

				if( each_li.contains("Preview") || each_li.contains("Share +") || each_li.contains("Add/View Comment") || each_li.contains("Add/View Tags") || each_li.contains("Add to Collection") || each_li.contains("External Sharing") || each_li.contains("Copy / Move") || each_li.contains("Download") || each_li.contains("Add Reminders") || each_li.contains("Rename") || each_li.contains("View Versions") || each_li.contains("Trash"))
				{
					log.info("file right click option exist");
					Thread.sleep(2000);

				}
				else
				{
					log.info("file right click option does not exist");
					ATUReports.add("folder right click option failed","folder right click option",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}
			}
			Thread.sleep(1000);
			click("Profile_Icon");
			Thread.sleep(1000);
			click("Sign_out");
			click("Ok");
			Thread.sleep(4000);

			Navigation.other_user_in_same_tenant();

			WebDriverWait wait511 = new WebDriverWait(driver, 120);
			wait511.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
			click("shared_with_me");

			WebElement ele111 = getPageObject("fol_1"); 
			act.doubleClick(ele111).perform();
			Thread.sleep(1000);

			WebElement right11=	driver.findElement(By.xpath("//div[contains(text(),'fol 2')]"));
			actions.contextClick(right11).perform();

			WebElement shared_folder_right_click_options1 = driver.findElement(By.xpath("//div[@class='folder']/div[@class='row'][1]/following-sibling::div/ul"));
			List<WebElement> each_folder_li_tag1=shared_folder_right_click_options1.findElements(By.tagName("li"));


			for(int i=0;i<each_folder_li_tag1.size();i++)
			{
				WebElement shared_folder_right_click_options11 =each_folder_li_tag1.get(i);
				String each_li = each_folder_li_tag1.get(i).getText();
				log.info("Shared folder right click options "+each_li);

				if(each_li.contains("Share +") || each_li.contains("Add/View Comment") || each_li.contains("Add/View Tags") || each_li.contains("External Sharing") || each_li.contains("Copy / Move") || each_li.contains("Download") || each_li.contains("Add Reminders") || each_li.contains("Rename") || each_li.contains("Export Metadata") || each_li.contains("Trash"))
				{
					log.info("folder right click option exist");
					Thread.sleep(2000);

				}
				else
				{
					log.info("folder right click option does not exist");
					ATUReports.add("folder right click option failed","folder right click option",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}
			} 

			Robot robot1 = new Robot();
			robot1.keyPress(KeyEvent.VK_ESCAPE);
			robot1.keyRelease(KeyEvent.VK_ESCAPE);
			Thread.sleep(2000);	

			WebDriverWait wait31221 = new WebDriverWait(driver, 60);
			wait31221.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[contains(text(),'Folders')]")));

			WebElement elementLocator91 = getPageObject("share_first_file");
			actions.contextClick(elementLocator91).perform();
			Thread.sleep(2000);

			WebElement shared_file_right_click_options1 = driver.findElement(By.xpath("//div[@class='files']/div[2][@class='context-list']/ul"));
			List<WebElement> each_file_li_tag1=shared_file_right_click_options1.findElements(By.tagName("li"));

			for(int i=0;i<each_file_li_tag1.size();i++)
			{

				WebElement li =each_file_li_tag1.get(i);
				String each_li = each_file_li_tag1.get(i).getText();
				log.info("Shared file right click options "+each_li);

				if( each_li.contains("Preview") || each_li.contains("Share +") || each_li.contains("Add/View Comment") || each_li.contains("Add/View Tags") || each_li.contains("Add to Collection") || each_li.contains("External Sharing") || each_li.contains("Copy / Move") || each_li.contains("Download") || each_li.contains("Add Reminders") || each_li.contains("Rename") || each_li.contains("View Versions") || each_li.contains("Trash"))
				{
					log.info("file right click option exist");
					Thread.sleep(2000);

				}
				else
				{
					log.info("file right click option does not exist");
					ATUReports.add("folder right click option failed","folder right click option",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}
			}
			Thread.sleep(1000);
			click("Profile_Icon");
			Thread.sleep(1000);
			click("Sign_out");
			click("Ok");
			Thread.sleep(4000);

		}
		catch (Exception e)
		{

			System.out.println("errror at: ");
			e.printStackTrace();
			log.error("Error in MyFiles_share_User_to_Group_View_Permission",e);	
			//log.fatal(e.getMessage(),e);
			captureScreenShot(ScreenShotsFilePath + "MyFiles_share_User_to_Group_View_Permission_Error.png");
			ATUReports.add("MyFiles_share_User_to_Group_View_Permission failed","MyFiles_share_User_to_Group_View_Permission",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}
	}




		//-----------------------------------MyFiles_share_User_to_Group_Preview_Permission---------------------------------------
	


	public static void MyFiles_share_User_to_Group_Preview_Permission() 
	{

		try
		{

			actions = new Actions(driver);

			Navigation.other_user_in_same_tenant();

			driver.get(Home_Page);
			WebDriverWait wait5 = new WebDriverWait(driver, 120);
			wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
			//Double click on element
			WebElement ele = getPageObject("MyFiles_Share_User_to_Group"); 
			Actions act = new Actions(driver);
			act.doubleClick(ele).perform();
			//Double click on element

			WebElement ele1 = getPageObject("Files_And_Folders"); 
			act.doubleClick(ele1).perform();

			String file1 =driver.findElement(By.xpath("(//*[@class='fileName'])[1]")).getText();
			System.out.println(file1);

			String folder1 =driver.findElement(By.xpath("(//*[contains(text(),'fol 1')]) [2]")).getText();
			System.out.println(folder1);

			click("select_all_folders");
			click("select_all_files");
			WebElement right=	driver.findElement(By.xpath("//div[@class='files-info']"));
			actions.contextClick(right).perform();
			click("Share");
			Thread.sleep(2000);

			select("shared_user_popup_dropdown","visibletext","Preview");
			Thread.sleep(2000);
			click("share_button");
			Thread.sleep(1000);

			WebDriverWait wait222 = new WebDriverWait(driver, 60);
			wait222.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Shared Successfully')]")));
			Thread.sleep(2000);
			click("toast_close");

			Thread.sleep(2000);
			click("Profile_Icon");
			Thread.sleep(1000);
			click("Sign_Out");
			click("Ok");
			Thread.sleep(5000);

			Navigation.login();

			WebDriverWait wait51 = new WebDriverWait(driver, 120);
			wait51.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));

			click("Profile_Icon");
			Thread.sleep(1000);
			click("Admin_Console");
			Thread.sleep(1000);
			click("Users_&_Groups");
			Thread.sleep(1000);
			click("Admin_Group");
			Thread.sleep(1000);
			click("Group_3dots");
			Thread.sleep(1000);
			click("View_Group");
			click("Content_Access");
			Thread.sleep(1000);

			Actions at = new Actions(driver);
			at.sendKeys(Keys.PAGE_DOWN).build().perform();

			Thread.sleep(1000);

			String file2 =driver.findElement(By.xpath("//div[contains(text(),'Sample 1.docx')]")).getText();
			System.out.println(file2);

			String folder2 =driver.findElement(By.xpath("//*[contains(text(),'fol 1')]")).getText();
			System.out.println(folder2);

			if(file1.equals(file2))
			{


				log.info("--------------------------No of Shared Files Folders is  equal to before------------------------------");

				captureScreenShot(ScreenShotsFilePath +"MyFiles_share_User_to_Group_Preview_Permission_success.png");
				Thread.sleep(2000);
				ATUReports.add("MyFiles_share_User_to_Group_Preview_Permission successfully","MyFiles_share_User_to_Group_Preview_Permission",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
				Thread.sleep(2000); 
			}
			else 
			{
				captureScreenShot(ScreenShotsFilePath + "MyFiles_share_User_to_Group_Preview_Permission_failed.png");
				Thread.sleep(2000);
				ATUReports.add("MyFiles_share_User_to_Group_Preview_Permission failed","MyFiles_share_User_to_Group_Preview_Permission",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}

			if(folder1.equals(folder2))
			{


				log.info("--------------------------No of Shared Files Folders is  equal to before------------------------------");

				captureScreenShot(ScreenShotsFilePath + "MyFiles_share_User_to_Group_Preview_Permission_success.png");
				Thread.sleep(2000);
				ATUReports.add("MyFiles_share_User_to_Group_Preview_Permission successfully","MyFiles_share_User_to_Group_Preview_Permission",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}

			else 
			{
				captureScreenShot(ScreenShotsFilePath + "MyFiles_share_User_to_Group_Preview_Permission_failed.png");
				Thread.sleep(2000);
				ATUReports.add("MyFiles_share_User_to_Group_Preview_Permission failed","MyFiles_share_User_to_Group_Preview_Permission",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}

			click("Profile_Icon");
			Thread.sleep(1000);
			click("My_Files");

			click("shared_with_me");

			String file3 =driver.findElement(By.xpath("//div[contains(text(),'Sample 1.docx')]")).getText();
			System.out.println(file3);

			String folder3 =driver.findElement(By.xpath("//div[contains(text(),'fol 1')]")).getText();
			System.out.println(folder3);

			if(file1.equals(file3))
			{


				log.info("--------------------------No of Shared Files Folders is  equal to before------------------------------");

				captureScreenShot(ScreenShotsFilePath +"MyFiles_share_User_to_Group_Preview_Permission_success.png");
				Thread.sleep(2000);
				ATUReports.add("MyFiles_share_User_to_Group_Preview_Permission successfully","MyFiles_share_User_to_Group_Preview_Permission",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
				Thread.sleep(2000); 
			}
			else 
			{
				captureScreenShot(ScreenShotsFilePath + "MyFiles_share_User_to_Group_Preview_Permission_failed.png");
				Thread.sleep(2000);
				ATUReports.add("MyFiles_share_User_to_Group_Preview_Permission failed","MyFiles_share_User_to_Group_Preview_Permission",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}

			if(folder1.equals(folder3))
			{


				log.info("--------------------------No of Shared Files Folders is  equal to before------------------------------");

				captureScreenShot(ScreenShotsFilePath + "MyFiles_share_User_to_Group_Preview_Permission_success.png");
				Thread.sleep(2000);
				ATUReports.add("MyFiles_share_User_to_Group_Preview_Permission successfully","MyFiles_share_User_to_Group_Preview_Permission",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}

			else 
			{
				captureScreenShot(ScreenShotsFilePath + "MyFiles_share_User_to_Group_Preview_Permission_failed.png");
				Thread.sleep(2000);
				ATUReports.add("MyFiles_share_User_to_Group_Preview_Permission failed","MyFiles_share_User_to_Group_Preview_Permission",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}

			WebElement ele11 = getPageObject("fol_1"); 
			act.doubleClick(ele11).perform();
			Thread.sleep(1000);

			WebElement right1=	driver.findElement(By.xpath("//div[contains(text(),'fol 2')]"));
			actions.contextClick(right1).perform();

			WebElement shared_folder_right_click_options = driver.findElement(By.xpath("//div[@class='folder']/div[@class='row'][1]/following-sibling::div/ul"));
			List<WebElement> each_folder_li_tag=shared_folder_right_click_options.findElements(By.tagName("li"));


			for(int i=0;i<each_folder_li_tag.size();i++)
			{
				WebElement shared_folder_right_click_options1 =each_folder_li_tag.get(i);
				String each_li = each_folder_li_tag.get(i).getText();
				log.info("Shared folder right click options "+each_li);

				if(each_li.contains("Share +") || each_li.contains("Add/View Comment") || each_li.contains("Add/View Tags") || each_li.contains("External Sharing") || each_li.contains("Copy / Move") || each_li.contains("Download") || each_li.contains("Add Reminders") || each_li.contains("Rename") || each_li.contains("Export Metadata") || each_li.contains("Trash"))
				{
					log.info("folder right click option exist");
					Thread.sleep(2000);

				}
				else
				{
					log.info("folder right click option does not exist");
					ATUReports.add("folder right click option failed","folder right click option",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}
			} 

			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ESCAPE);
			robot.keyRelease(KeyEvent.VK_ESCAPE);
			Thread.sleep(2000);	

			WebDriverWait wait3122 = new WebDriverWait(driver, 60);
			wait3122.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[contains(text(),'Folders')]")));

			WebElement elementLocator9 = getPageObject("share_first_file");
			actions.contextClick(elementLocator9).perform();
			Thread.sleep(2000);

			WebElement shared_file_right_click_options = driver.findElement(By.xpath("//div[@class='files']/div[2][@class='context-list']/ul"));
			List<WebElement> each_file_li_tag=shared_file_right_click_options.findElements(By.tagName("li"));

			for(int i=0;i<each_file_li_tag.size();i++)
			{

				WebElement li =each_file_li_tag.get(i);
				String each_li = each_file_li_tag.get(i).getText();
				log.info("Shared file right click options "+each_li);

				if( each_li.contains("Preview") || each_li.contains("Share +") || each_li.contains("Add/View Comment") || each_li.contains("Add/View Tags") || each_li.contains("Add to Collection") || each_li.contains("External Sharing") || each_li.contains("Copy / Move") || each_li.contains("Download") || each_li.contains("Add Reminders") || each_li.contains("Rename") || each_li.contains("View Versions") || each_li.contains("Trash"))
				{
					log.info("file right click option exist");
					Thread.sleep(2000);

				}
				else
				{
					log.info("file right click option does not exist");
					ATUReports.add("folder right click option failed","folder right click option",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}
			}
			Thread.sleep(1000);
			click("Profile_Icon");
			Thread.sleep(1000);
			click("Sign_out");
			click("Ok");
			Thread.sleep(4000);

			Navigation.other_user_in_same_tenant();

			WebDriverWait wait511 = new WebDriverWait(driver, 120);
			wait511.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
			click("shared_with_me");

			WebElement ele111 = getPageObject("fol_1"); 
			act.doubleClick(ele111).perform();
			Thread.sleep(1000);

			WebElement right11=	driver.findElement(By.xpath("//div[contains(text(),'fol 2')]"));
			actions.contextClick(right11).perform();

			WebElement shared_folder_right_click_options1 = driver.findElement(By.xpath("//div[@class='folder']/div[@class='row'][1]/following-sibling::div/ul"));
			List<WebElement> each_folder_li_tag1=shared_folder_right_click_options1.findElements(By.tagName("li"));


			for(int i=0;i<each_folder_li_tag1.size();i++)
			{
				WebElement shared_folder_right_click_options11 =each_folder_li_tag1.get(i);
				String each_li = each_folder_li_tag1.get(i).getText();
				log.info("Shared folder right click options "+each_li);

				if(each_li.contains("Share +") || each_li.contains("Add/View Comment") || each_li.contains("Add/View Tags") || each_li.contains("External Sharing") || each_li.contains("Copy / Move") || each_li.contains("Download") || each_li.contains("Add Reminders") || each_li.contains("Rename") || each_li.contains("Export Metadata") || each_li.contains("Trash"))
				{
					log.info("folder right click option exist");
					Thread.sleep(2000);

				}
				else
				{
					log.info("folder right click option does not exist");
					ATUReports.add("folder right click option failed","folder right click option",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}
			} 

			Robot robot1 = new Robot();
			robot1.keyPress(KeyEvent.VK_ESCAPE);
			robot1.keyRelease(KeyEvent.VK_ESCAPE);
			Thread.sleep(2000);	

			WebDriverWait wait31221 = new WebDriverWait(driver, 60);
			wait31221.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[contains(text(),'Folders')]")));

			WebElement elementLocator91 = getPageObject("share_first_file");
			actions.contextClick(elementLocator91).perform();
			Thread.sleep(2000);

			WebElement shared_file_right_click_options1 = driver.findElement(By.xpath("//div[@class='files']/div[2][@class='context-list']/ul"));
			List<WebElement> each_file_li_tag1=shared_file_right_click_options1.findElements(By.tagName("li"));

			for(int i=0;i<each_file_li_tag1.size();i++)
			{

				WebElement li =each_file_li_tag1.get(i);
				String each_li = each_file_li_tag1.get(i).getText();
				log.info("Shared file right click options "+each_li);

				if( each_li.contains("Preview") || each_li.contains("Share +") || each_li.contains("Add/View Comment") || each_li.contains("Add/View Tags") || each_li.contains("Add to Collection") || each_li.contains("External Sharing") || each_li.contains("Copy / Move") || each_li.contains("Download") || each_li.contains("Add Reminders") || each_li.contains("Rename") || each_li.contains("View Versions") || each_li.contains("Trash"))
				{
					log.info("file right click option exist");
					Thread.sleep(2000);

				}
				else
				{
					log.info("file right click option does not exist");
					ATUReports.add("folder right click option failed","folder right click option",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}
			}
			Thread.sleep(1000);
			click("Profile_Icon");
			Thread.sleep(1000);
			click("Sign_out");
			click("Ok");
			Thread.sleep(4000);

		}
		catch (Exception e)
		{

			System.out.println("errror at: ");
			e.printStackTrace();
			log.error("Error in MyFiles_share_User_to_Group_Preview_Permission",e);	
			//log.fatal(e.getMessage(),e);
			captureScreenShot(ScreenShotsFilePath + "MyFiles_share_User_to_Group_Preview_Permission_Error.png");
			ATUReports.add("MyFiles_share_User_to_Group_Preview_Permission failed","MyFiles_share_User_to_Group_Preview_Permission",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}
	}



	//------------------------------------MyFiles_share_User_to_Group_Upload_Permission--------------------------------------


	public static void MyFiles_share_User_to_Group_Upload_Permission() 
	{

		try
		{

			actions = new Actions(driver);

			Navigation.other_user_in_same_tenant();

			driver.get(Home_Page);
			WebDriverWait wait5 = new WebDriverWait(driver, 120);
			wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
			//Double click on element
			WebElement ele = getPageObject("MyFiles_Share_User_to_Group"); 
			Actions act = new Actions(driver);
			act.doubleClick(ele).perform();
			//Double click on element

			WebElement ele1 = getPageObject("Files_And_Folders"); 
			act.doubleClick(ele1).perform();

			String file1 =driver.findElement(By.xpath("(//*[@class='fileName'])[1]")).getText();
			System.out.println(file1);

			String folder1 =driver.findElement(By.xpath("(//*[contains(text(),'fol 1')]) [2]")).getText();
			System.out.println(folder1);

			click("select_all_folders");
			click("select_all_files");
			WebElement right=	driver.findElement(By.xpath("//div[@class='files-info']"));
			actions.contextClick(right).perform();
			click("Share");
			Thread.sleep(2000);
			
//			WebElement noUserOr = driver.findElement(By.xpath("//input[@placeholder='Search Users or Groups']"));
//			noUserOr.sendKeys("T");
//
//
//			WebDriverWait wait31 = new WebDriverWait(driver, 60);
//			wait31.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='multiselect__content']/li[1]")));

			
			select("shared_user_popup_dropdown","visibletext","Upload");
			Thread.sleep(2000);
			click("share_button");
			Thread.sleep(1000);
		
			WebDriverWait wait222 = new WebDriverWait(driver, 60);
			wait222.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Shared Successfully')]")));
			Thread.sleep(2000);
			click("toast_close");

			Thread.sleep(2000);
			click("Profile_Icon");
			Thread.sleep(1000);
			click("Sign_Out");
			click("Ok");
			Thread.sleep(5000);
			
			Navigation.login();

			WebDriverWait wait51 = new WebDriverWait(driver, 120);
			wait51.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
			
			click("Profile_Icon");
			Thread.sleep(1000);
			click("Admin_Console");
			Thread.sleep(1000);
			click("Users_&_Groups");
			Thread.sleep(1000);
			click("Admin_Group");
			Thread.sleep(1000);
			click("Group_3dots");
			Thread.sleep(1000);
			click("View_Group");
			click("Content_Access");
			Thread.sleep(1000);

			Actions at = new Actions(driver);
			at.sendKeys(Keys.PAGE_DOWN).build().perform();

			Thread.sleep(1000);

			String file2 =driver.findElement(By.xpath("//div[contains(text(),'Sample 1.docx')]")).getText();
			System.out.println(file2);

			String folder2 =driver.findElement(By.xpath("//*[contains(text(),'fol 1')]")).getText();
			System.out.println(folder2);
			
			if(file1.equals(file2))
			{


				log.info("--------------------------No of Shared Files Folders is  equal to before------------------------------");

				captureScreenShot(ScreenShotsFilePath +"MyFiles_share_User_to_Group_Upload_Permission_success.png");
				Thread.sleep(2000);
				ATUReports.add("MyFiles_share_User_to_Group_Upload_Permission successfully","MyFiles_share_User_to_Group_Upload_Permission",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
				Thread.sleep(2000); 
			}
			else 
			{
				captureScreenShot(ScreenShotsFilePath + "MyFiles_share_User_to_Group_Upload_Permission_failed.png");
				Thread.sleep(2000);
				ATUReports.add("MyFiles_share_User_to_Group_Upload_Permission failed","MyFiles_share_User_to_Group_Upload_Permission",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}

			if(folder1.equals(folder2))
			{


				log.info("--------------------------No of Shared Files Folders is  equal to before------------------------------");

				captureScreenShot(ScreenShotsFilePath + "MyFiles_share_User_to_Group_Upload_Permission_success.png");
				Thread.sleep(2000);
				ATUReports.add("MyFiles_share_User_to_Group_Upload_Permission successfully","MyFiles_share_User_to_Group_Upload_Permission",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}

			else 
			{
				captureScreenShot(ScreenShotsFilePath + "MyFiles_share_User_to_Group_Upload_Permission_failed.png");
				Thread.sleep(2000);
				ATUReports.add("MyFiles_share_User_to_Group_Upload_Permission failed","MyFiles_share_User_to_Group_Upload_Permission",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}
			
			click("Profile_Icon");
			Thread.sleep(1000);
			click("My_Files");
			
			click("shared_with_me");
			
			String file3 =driver.findElement(By.xpath("//div[contains(text(),'Sample 1.docx')]")).getText();
			System.out.println(file3);

			String folder3 =driver.findElement(By.xpath("//div[contains(text(),'fol 1')]")).getText();
			System.out.println(folder3);
			
			if(file1.equals(file3))
			{


				log.info("--------------------------No of Shared Files Folders is  equal to before------------------------------");

				captureScreenShot(ScreenShotsFilePath +"MyFiles_share_User_to_Group_Upload_Permission_success.png");
				Thread.sleep(2000);
				ATUReports.add("MyFiles_share_User_to_Group_Upload_Permission successfully","MyFiles_share_User_to_Group_Upload_Permission",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
				Thread.sleep(2000); 
			}
			else 
			{
				captureScreenShot(ScreenShotsFilePath + "MyFiles_share_User_to_Group_Upload_Permission_failed.png");
				Thread.sleep(2000);
				ATUReports.add("MyFiles_share_User_to_Group_Upload_Permission failed","MyFiles_share_User_to_Group_Upload_Permission",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}

			if(folder1.equals(folder3))
			{


				log.info("--------------------------No of Shared Files Folders is  equal to before------------------------------");

				captureScreenShot(ScreenShotsFilePath + "MyFiles_share_User_to_Group_Upload_Permission_success.png");
				Thread.sleep(2000);
				ATUReports.add("MyFiles_share_User_to_Group_Upload_Permission successfully","MyFiles_share_User_to_Group_Upload_Permission",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}

			else 
			{
				captureScreenShot(ScreenShotsFilePath + "MyFiles_share_User_to_Group_Upload_Permission_failed.png");
				Thread.sleep(2000);
				ATUReports.add("MyFiles_share_User_to_Group_Upload_Permission failed","MyFiles_share_User_to_Group_Upload_Permission",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}
			
			WebElement ele11 = getPageObject("fol_1"); 
			act.doubleClick(ele11).perform();
			Thread.sleep(1000);

			WebElement right1=	driver.findElement(By.xpath("//div[contains(text(),'fol 2')]"));
			actions.contextClick(right1).perform();

			WebElement shared_folder_right_click_options = driver.findElement(By.xpath("//div[@class='folder']/div[@class='row'][1]/following-sibling::div/ul"));
			List<WebElement> each_folder_li_tag=shared_folder_right_click_options.findElements(By.tagName("li"));


			for(int i=0;i<each_folder_li_tag.size();i++)
			{
				WebElement shared_folder_right_click_options1 =each_folder_li_tag.get(i);
				String each_li = each_folder_li_tag.get(i).getText();
				log.info("Shared folder right click options "+each_li);

				if(each_li.contains("Share +") || each_li.contains("Add/View Comment") || each_li.contains("Add/View Tags") || each_li.contains("External Sharing") || each_li.contains("Copy / Move") || each_li.contains("Download") || each_li.contains("Add Reminders") || each_li.contains("Rename") || each_li.contains("Export Metadata") || each_li.contains("Trash"))
				{
					log.info("folder right click option exist");
					Thread.sleep(2000);

				}
				else
				{
					log.info("folder right click option does not exist");
					ATUReports.add("folder right click option failed","folder right click option",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}
			} 

			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ESCAPE);
			robot.keyRelease(KeyEvent.VK_ESCAPE);
			Thread.sleep(2000);	

			WebDriverWait wait3122 = new WebDriverWait(driver, 60);
			wait3122.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[contains(text(),'Folders')]")));

			WebElement elementLocator9 = getPageObject("share_first_file");
			actions.contextClick(elementLocator9).perform();
			Thread.sleep(2000);

			WebElement shared_file_right_click_options = driver.findElement(By.xpath("//div[@class='files']/div[2][@class='context-list']/ul"));
			List<WebElement> each_file_li_tag=shared_file_right_click_options.findElements(By.tagName("li"));

			for(int i=0;i<each_file_li_tag.size();i++)
			{

				WebElement li =each_file_li_tag.get(i);
				String each_li = each_file_li_tag.get(i).getText();
				log.info("Shared file right click options "+each_li);

				if( each_li.contains("Preview") || each_li.contains("Share +") || each_li.contains("Add/View Comment") || each_li.contains("Add/View Tags") || each_li.contains("Add to Collection") || each_li.contains("External Sharing") || each_li.contains("Copy / Move") || each_li.contains("Download") || each_li.contains("Add Reminders") || each_li.contains("Rename") || each_li.contains("View Versions") || each_li.contains("Trash"))
				{
					log.info("file right click option exist");
					Thread.sleep(2000);

				}
				else
				{
					log.info("file right click option does not exist");
					ATUReports.add("folder right click option failed","folder right click option",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}
			}
			Thread.sleep(1000);
			click("Profile_Icon");
			Thread.sleep(1000);
			click("Sign_out");
			click("Ok");
			Thread.sleep(4000);

			Navigation.other_user_in_same_tenant();

			WebDriverWait wait511 = new WebDriverWait(driver, 120);
			wait511.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
			click("shared_with_me");

			WebElement ele111 = getPageObject("fol_1"); 
			act.doubleClick(ele111).perform();
			Thread.sleep(1000);

			WebElement right11=	driver.findElement(By.xpath("//div[contains(text(),'fol 2')]"));
			actions.contextClick(right11).perform();

			WebElement shared_folder_right_click_options1 = driver.findElement(By.xpath("//div[@class='folder']/div[@class='row'][1]/following-sibling::div/ul"));
			List<WebElement> each_folder_li_tag1=shared_folder_right_click_options1.findElements(By.tagName("li"));


			for(int i=0;i<each_folder_li_tag1.size();i++)
			{
				WebElement shared_folder_right_click_options11 =each_folder_li_tag1.get(i);
				String each_li = each_folder_li_tag1.get(i).getText();
				log.info("Shared folder right click options "+each_li);

				if(each_li.contains("Share +") || each_li.contains("Add/View Comment") || each_li.contains("Add/View Tags") || each_li.contains("External Sharing") || each_li.contains("Copy / Move") || each_li.contains("Download") || each_li.contains("Add Reminders") || each_li.contains("Rename") || each_li.contains("Export Metadata") || each_li.contains("Trash"))
				{
					log.info("folder right click option exist");
					Thread.sleep(2000);

				}
				else
				{
					log.info("folder right click option does not exist");
					ATUReports.add("folder right click option failed","folder right click option",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}
			} 

			Robot robot1 = new Robot();
			robot1.keyPress(KeyEvent.VK_ESCAPE);
			robot1.keyRelease(KeyEvent.VK_ESCAPE);
			Thread.sleep(2000);	

			WebDriverWait wait31221 = new WebDriverWait(driver, 60);
			wait31221.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[contains(text(),'Folders')]")));

			WebElement elementLocator91 = getPageObject("share_first_file");
			actions.contextClick(elementLocator91).perform();
			Thread.sleep(2000);

			WebElement shared_file_right_click_options1 = driver.findElement(By.xpath("//div[@class='files']/div[2][@class='context-list']/ul"));
			List<WebElement> each_file_li_tag1=shared_file_right_click_options1.findElements(By.tagName("li"));

			for(int i=0;i<each_file_li_tag1.size();i++)
			{

				WebElement li =each_file_li_tag1.get(i);
				String each_li = each_file_li_tag1.get(i).getText();
				log.info("Shared file right click options "+each_li);

				if( each_li.contains("Preview") || each_li.contains("Share +") || each_li.contains("Add/View Comment") || each_li.contains("Add/View Tags") || each_li.contains("Add to Collection") || each_li.contains("External Sharing") || each_li.contains("Copy / Move") || each_li.contains("Download") || each_li.contains("Add Reminders") || each_li.contains("Rename") || each_li.contains("View Versions") || each_li.contains("Trash"))
				{
					log.info("file right click option exist");
					Thread.sleep(2000);

				}
				else
				{
					log.info("file right click option does not exist");
					ATUReports.add("folder right click option failed","folder right click option",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}
			}

			click("Profile_Icon");
			Thread.sleep(1000);
			click("Sign_out");
			click("Ok");
			Thread.sleep(4000);

		}
		catch (Exception e)
		{

			System.out.println("errror at: ");
			e.printStackTrace();
			log.error("Error in MyFiles_share_User_to_Group_Upload_Permission",e);	
			//log.fatal(e.getMessage(),e);
			captureScreenShot(ScreenShotsFilePath + "MyFiles_share_User_to_Group_Upload_Permission_Error.png");
			ATUReports.add("MyFiles_share_User_to_Group_Upload_Permission failed","MyFiles_share_User_to_Group_Upload_Permission",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}
	}



	//--------------------------------MyFiles_share_User_to_Group_Remove_Files_And_Folders-------------------------------------


	public static void MyFiles_share_User_to_Group_Remove_Files_And_Folders() 
	{

		try
		{

			actions = new Actions(driver);

			Navigation.other_user_in_same_tenant();

			driver.get(Home_Page);
			WebDriverWait wait5 = new WebDriverWait(driver, 120);
			wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
			//Double click on element
			WebElement ele = getPageObject("MyFiles_Share_User_to_Group"); 
			Actions act = new Actions(driver);
			act.doubleClick(ele).perform();
			//Double click on element

			WebElement ele1 = getPageObject("Files_And_Folders"); 
			act.doubleClick(ele1).perform();

			String file1 =driver.findElement(By.xpath("(//*[@class='fileName'])[1]")).getText();
			System.out.println(file1);

			String folder1 =driver.findElement(By.xpath("(//*[contains(text(),'fol 1')]) [2]")).getText();
			System.out.println(folder1);

			click("select_all_folders");
			click("select_all_files");
			WebElement right=	driver.findElement(By.xpath("//div[@class='files-info']"));
			actions.contextClick(right).perform();
			click("Share");
			Thread.sleep(2000);

			select("shared_user_popup_dropdown","visibletext","Remove");
			Thread.sleep(2000);
			click("share_button");
			Thread.sleep(1000);

			WebDriverWait wait222 = new WebDriverWait(driver, 60);
			wait222.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Shared Successfully')]")));
			Thread.sleep(2000);
			click("toast_close");
			Thread.sleep(2000);
			click("shared_with_me");

			List<WebElement> Aftermovedfolders =driver.findElements(By.xpath("//*[@class='folder-article']"));
			int	Aftermovedfolderstofolder = Aftermovedfolders .size();
			System.out.println("No of folders Shared" + Aftermovedfolderstofolder);

			if(Aftermovedfolderstofolder==0)
			{


				log.info("--------------------------No of Shared folders is  equal to before------------------------------");

				captureScreenShot(ScreenShotsFilePath +"MyFiles_share_Admin_to_Group_Remove_Files_And_Folders_success.png");
				Thread.sleep(2000);
				ATUReports.add("MyFiles_share_Admin_to_Group_Remove_Files_And_Folders successfully","MyFiles_share_Admin_to_Group_Remove_Files_And_Folders",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
				Thread.sleep(2000); 
			}
			else 
			{
				captureScreenShot(ScreenShotsFilePath + "MyFiles_share_Admin_to_Group_Remove_Files_And_Folders_failed.png");
				Thread.sleep(2000);
				ATUReports.add("MyFiles_share_Admin_to_Group_Remove_Files_And_Folders failed","MyFiles_share_Admin_to_Group_Remove_Files_And_Folders",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}


			List<WebElement> Aftermovedfiles2 = driver.findElements(By.xpath("//*[@class='files-footer']"));
			int Aftermovedfiles1 = Aftermovedfiles2.size();
			System.out.println("No of files Shared" + Aftermovedfiles1);
			if(Aftermovedfiles1==0)
			{


				log.info("--------------------------No of Shared files is  equal to before------------------------------");

				captureScreenShot(ScreenShotsFilePath + "MyFiles_share_Admin_to_Group_Remove_Files_And_Folders_success.png");
				Thread.sleep(2000);
				ATUReports.add("MyFiles_share_Admin_to_Group_Remove_Files_And_Folders successfully","MyFiles_share_Admin_to_Group_Remove_Files_And_Folders",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}

			else 
			{
				captureScreenShot(ScreenShotsFilePath + "MyFiles_share_Admin_to_Group_Remove_Files_And_Folders_failed.png");
				Thread.sleep(2000);
				ATUReports.add("MyFiles_share_Admin_to_Group_Remove_Files_And_Folders failed","MyFiles_share_Admin_to_Group_Remove_Files_And_Folders",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}
			click("Profile_Icon");
			Thread.sleep(1000);
			click("Sign_out");
			click("Ok");
			Thread.sleep(5000);

			Navigation.login();
			click("Profile_Icon");
			Thread.sleep(1000);
			click("Admin_Console");
			Thread.sleep(1000);
			click("Users_&_Groups");
			Thread.sleep(1000);
			click("Admin_Group");
			Thread.sleep(1000);
			click("Group_3dots");
			Thread.sleep(1000);
			click("View_Group");
			click("Content_Access");
			Thread.sleep(2000);

			Actions at = new Actions(driver);
			at.sendKeys(Keys.PAGE_DOWN).build().perform();

			List<WebElement> Aftermovedfolders1 =driver.findElements(By.xpath("//*[@class='folder-article']"));
			int	Aftermovedfolderstofolder1 = Aftermovedfolders1 .size();
			System.out.println("No of folders Shared" + Aftermovedfolderstofolder1);

			if(Aftermovedfolderstofolder1==0)
			{


				log.info("--------------------------No of Shared folders is  equal to before------------------------------");

				captureScreenShot(ScreenShotsFilePath +"MyFiles_share_Admin_to_Group_Remove_Files_And_Folders_success.png");
				Thread.sleep(2000);
				ATUReports.add("MyFiles_share_Admin_to_Group_Remove_Files_And_Folders successfully","MyFiles_share_Admin_to_Group_Remove_Files_And_Folders",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
				Thread.sleep(2000); 
			}
			else 
			{
				captureScreenShot(ScreenShotsFilePath + "MyFiles_share_Admin_to_Group_Remove_Files_And_Folders_failed.png");
				Thread.sleep(2000);
				ATUReports.add("MyFiles_share_Admin_to_Group_Remove_Files_And_Folders failed","MyFiles_share_Admin_to_Group_Remove_Files_And_Folders",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}


			List<WebElement> Aftermovedfiles21 = driver.findElements(By.xpath("//*[@class='files-footer']"));
			int Aftermovedfiles11 = Aftermovedfiles21.size();
			System.out.println("No of files Shared" + Aftermovedfiles11);
			if(Aftermovedfiles11==0)
			{


				log.info("--------------------------No of Shared files is  equal to before------------------------------");

				captureScreenShot(ScreenShotsFilePath + "MyFiles_share_Admin_to_Group_Remove_Files_And_Folders_success.png");
				Thread.sleep(2000);
				ATUReports.add("MyFiles_share_Admin_to_Group_Remove_Files_And_Folders successfully","MyFiles_share_Admin_to_Group_Remove_Files_And_Folders",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}

			else 
			{
				captureScreenShot(ScreenShotsFilePath + "MyFiles_share_Admin_to_Group_Remove_Files_And_Folders_failed.png");
				Thread.sleep(2000);
				ATUReports.add("MyFiles_share_Admin_to_Group_Remove_Files_And_Folders failed","MyFiles_share_Admin_to_Group_Remove_Files_And_Folders",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}

			click("Profile_Icon");
			click("My_Files");
			Thread.sleep(1000);
			click("shared_with_me");

			List<WebElement> Aftermovedfolders11 =driver.findElements(By.xpath("//*[@class='folder-article']"));
			int	Aftermovedfolderstofolder11 = Aftermovedfolders11 .size();
			System.out.println("No of folders Shared" + Aftermovedfolderstofolder11);

			if(Aftermovedfolderstofolder11==0)
			{


				log.info("--------------------------No of Shared folders is  equal to before------------------------------");

				captureScreenShot(ScreenShotsFilePath +"MyFiles_share_Admin_to_Group_Remove_Files_And_Folders_success.png");
				Thread.sleep(2000);
				ATUReports.add("MyFiles_share_Admin_to_Group_Remove_Files_And_Folders successfully","MyFiles_share_Admin_to_Group_Remove_Files_And_Folders",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
				Thread.sleep(2000); 
			}
			else 
			{
				captureScreenShot(ScreenShotsFilePath + "MyFiles_share_Admin_to_Group_Remove_Files_And_Folders_failed.png");
				Thread.sleep(2000);
				ATUReports.add("MyFiles_share_Admin_to_Group_Remove_Files_And_Folders failed","MyFiles_share_Admin_to_Group_Remove_Files_And_Folders",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}


			List<WebElement> Aftermovedfiles211 = driver.findElements(By.xpath("//*[@class='files-footer']"));
			int Aftermovedfiles111 = Aftermovedfiles211.size();
			System.out.println("No of files Shared" + Aftermovedfiles111);
			if(Aftermovedfiles111==0)
			{


				log.info("--------------------------No of Shared files is  equal to before------------------------------");

				captureScreenShot(ScreenShotsFilePath + "MyFiles_share_Admin_to_Group_Remove_Files_And_Folders_success.png");
				Thread.sleep(2000);
				ATUReports.add("MyFiles_share_Admin_to_Group_Remove_Files_And_Folders successfully","MyFiles_share_Admin_to_Group_Remove_Files_And_Folders",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}

			else 
			{
				captureScreenShot(ScreenShotsFilePath + "MyFiles_share_Admin_to_Group_Remove_Files_And_Folders_failed.png");
				Thread.sleep(2000);
				ATUReports.add("MyFiles_share_Admin_to_Group_Remove_Files_And_Folders failed","MyFiles_share_Admin_to_Group_Remove_Files_And_Folders",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}

			Thread.sleep(2000);
			click("Profile_Icon");
			Thread.sleep(1000);
			click("Sign_out");
			Thread.sleep(1000);
			click("Ok");
			Thread.sleep(4000);
			WebDriverWait wait35 = new WebDriverWait(driver, 120);
			wait35.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));

		}
		catch (Exception e)
		{

			System.out.println("errror at: ");
			e.printStackTrace();
			log.error("Error in MyFiles_share_Admin_to_Group_Remove_Files_And_Folders",e);	
			//log.fatal(e.getMessage(),e);
			captureScreenShot(ScreenShotsFilePath + "MyFiles_share_Admin_to_Group_Remove_Files_And_Folders_Error.png");
			ATUReports.add("MyFiles_share_Admin_to_Group_Remove_Files_And_Folders failed","MyFiles_share_Admin_to_Group_Remove_Files_And_Folders",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}
	}}


 





