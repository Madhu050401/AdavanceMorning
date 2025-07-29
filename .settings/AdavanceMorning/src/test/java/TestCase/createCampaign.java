package TestCase;

import static org.testng.Assert.assertTrue;

import java.io.IOException;



import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import BaseClass.baseClass;
import ExcelFileUtility.getDataFromExcel;
import JavaFileUtility.javaUtility;
import POM.CampaignPage;
import POM.HomePage;
import POM.LoginPage;
import PropertiesFileUtility.getDataFromPropertiesFile;
import WebdriverUtility.webdriverUtility;

@Listeners(ListenersUtility.ListenersImplementation.class)


public class createCampaign extends baseClass{

	
	@Test(groups = "Smoke")
	public  void  createcampaign() throws IOException, EncryptedDocumentException, InterruptedException {
		
		getDataFromExcel eutil = new getDataFromExcel();
		webdriverUtility wutil= new webdriverUtility();
		javaUtility jutil = new javaUtility();
		
		
		driver.manage().window().maximize();
		wutil.waitForPageToload(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Read Data from Excel
		String campname = eutil.getdatafromexcel("Campaign", 1, 2);
		String size = eutil.getdatafromexcel("Campaign", 1, 3);
		
		//click on create Campaign button
		HomePage hp = new HomePage(driver);
		hp.getCreatecampaign().click();
		
		//enter mandatory fields
		CampaignPage cp = new CampaignPage(driver);
		cp.getCampaignName().sendKeys(campname + jutil.getRandomNumber());
		cp.getTargetsizeTF().sendKeys(size);
		cp.getCreatecampaignsubmitBtn().click();
		
		//validation
		Thread.sleep(4000);

		WebElement toast = driver.findElement(By.xpath("//div[@role='alert']"));
		Thread.sleep(2000);

		wutil.waitforVisibilityofElement(driver, toast);
		String msg = toast.getText();
		
		Assert.assertTrue(msg.contains(campname));
		
		driver.findElement(By.xpath("//button[@arialabel='close']")).click();

		
		/*if(msg.contains(campname)) {
		System.out.println("campaign is created");
		}
		else{
		System.out.println("campaign not created");
		}
		driver.findElement(By.xpath("//button[@aria-label='close']")).click();*/
		
		
		/*getDataFromPropertiesFile putil = new getDataFromPropertiesFile();
		String Browser = putil.getdatafrompropertiesfile("BROWSER"); 
		String Url = putil.getdatafrompropertiesfile("URL");
		String Username = putil.getdatafrompropertiesfile("USERNAME"); 
		String Password= putil.getdatafrompropertiesfile("PASSWORD");*/
		
		//getDataFromExcel eutil = new getDataFromExcel();
		//String campname = eutil.getdatafromexcel("Campaign", 1, 2);
		//String size = eutil.getdatafromexcel("Campaign", 1, 3);

		//webdriverUtility wutil = new webdriverUtility(); 
		
		//WebDriver driver = new EdgeDriver();
		//driver.manage().window().maximize();
		//wutil.waitForPageToload(driver);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Login To NINZA CRM
		
		     /* driver.get(Url);
		      LoginPage lp = new LoginPage(driver);
		      lp.getUN().sendKeys(Username);
		      lp.getPW().sendKeys(Password);
		      lp.getLoginbtn().click();*/
		
				/* driver.get("http://49.249.28.218:8098/");
				driver.findElement(By.id("username")).sendKeys("Username");
				driver.findElement(By.id("inputPassword")).sendKeys("Password");
				driver.findElement(By.xpath("//button[text() ='Sign In']")).click();*/
				
				//javaUtility jutil = new javaUtility();
				
				//driver.findElement(By.xpath("//span[text()='Create Campaign']")).click();
				
				//Click on create campaign
				
				//HomePage hp = new HomePage(driver);
				//hp.getCreatecampaign().click();
				
				//enter mandatory fields
				/*CampaignPage cp = new CampaignPage(driver);
				cp.getCampaignName().sendKeys(campname+ jutil.getRandomNumber());
				cp.getTargetsizeTF().sendKeys(size);
				cp.getCreatecampaignsubmitBtn().click();*/
				
				/*driver.findElement(By.name("campaignName")).sendKeys(campname+ jutil.getRandomNumber());
				WebElement target = driver.findElement(By.name("targetSize"));
				target.clear();
				target.sendKeys(size);
				driver.findElement(By.xpath("//button[text()='Create Campaign']")).click(); */
				
				//validation
				/*WebElement toast = driver.findElement(By.xpath("//div[@role='alert']"));
				wutil.waitforVisibilityofElement(driver, toast);
				String msg = toast.getText();
				if(msg.contains(campname)) {
				System.out.println("campaign is created");
				}
				else{
				System.out.println("campaign not created");
				}
				driver.findElement(By.xpath("//button[@aria-label='close']")).click();*/
				
				
				//logout
				//hp.getUserIcon().click();
				//hp.getLogoutBtn().click();
				
				/* WebElement icon = driver.findElement(By.xpath("//div[@class='user-icon']"));
				wutil.mouseHoverOnWebElement(driver, icon);
				
				
				WebElement logout = driver.findElement(By.xpath("//div[@class='dropdown-item logout']"));
				 // act.moveToElement(logout).click().perform();
				wutil.clickonWebElement(driver, logout);*/

		
		/* //Login To NINZA CRM
		driver.get("http://49.249.28.218:8098/");
		driver.findElement(By.id("username")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[text() ='Sign In']")).click();
		
		//Create Campaign
		driver.findElement(By.xpath("//span[text()='Create Campaign']")).click();
		driver.findElement(By.name("campaignName")).sendKeys("Bay6");
		WebElement target = driver.findElement(By.name("targetSize"));
		target.clear();
		target.sendKeys("10");
		driver.findElement(By.xpath("//button[text()='Create Campaign']")).click();
		
		//Validation
		WebElement toast = driver.findElement(By.xpath("//div[@role='alert']")); 
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(toast));
		String msg = toast.getText();
		
		if(msg.contains("Bay6")) {
			System.out.println("Campign Created");
		}
		else {
			System.out.println("Campign failed");
		}
		driver.findElement(By.xpath("//button[@aria-label='close']")).click();
		
		//Logout
		WebElement icon = driver.findElement(By.xpath("//div[@class='user-icon']"));
		Actions act = new Actions(driver);
		act.moveToElement(icon).perform();
		WebElement logout = driver.findElement(By.xpath("//div[@class='dropdown-item logout']"));
		act.moveToElement(logout).click().perform(); */
		
		

	}
}
