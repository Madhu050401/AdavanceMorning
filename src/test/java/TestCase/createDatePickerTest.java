package TestCase;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import BaseClass.baseClass;
import ExcelFileUtility.getDataFromExcel;
import JavaFileUtility.javaUtility;
import POM.CampaignPage;
import POM.HomePage;
import PropertiesFileUtility.getDataFromPropertiesFile;
import WebdriverUtility.webdriverUtility;

@Listeners(ListenersUtility.ListenersImplementation.class)

public class createDatePickerTest extends baseClass{
	@Test

	public void createDatePicker() throws InterruptedException, IOException {
		
		getDataFromExcel eutil = new getDataFromExcel();
		webdriverUtility wutil= new webdriverUtility();
		javaUtility jutil = new javaUtility();
		
		driver.manage().window().maximize();
		wutil.waitForPageToload(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Read Data from Excel
		String campname = eutil.getdatafromexcel("Campaign", 1, 2);
		String size = eutil.getdatafromexcel("Campaign", 1, 3);
		
		int ran = jutil.getRandomNumber();
		String expectedate = jutil.togetRequired(30);
		
		//click on create Campaign button
		HomePage hp = new HomePage(driver);
		hp.getCreatecampaign().click();
		
		
		
		//enter mandatory fields
		CampaignPage cp = new CampaignPage(driver);
		cp.getCampaignName().sendKeys(campname+ ran);
		cp.getTargetsizeTF().sendKeys(size);
		
		wutil.passinput(driver, cp.getExpectedclosedate(), jutil.togetRequired(30));
		
		cp.getCreatecampaignsubmitBtn().click();
		
		//validation
		//Thread.sleep(2000);
				WebElement toast = driver.findElement(By.xpath("//div[@role='alert']"));
				wutil.waitforVisibilityofElement(driver, toast);
				String msg = toast.getText();
				if(msg.contains(campname)) {
				System.out.println("campaign is created");
				}
				else{
				System.out.println("campaign not created");
				

				}
				driver.findElement(By.xpath("//button[@aria-label='close']")).click();
		
		
		
		
		/*getDataFromPropertiesFile putil = new getDataFromPropertiesFile();
		String Browser = putil.getdatafrompropertiesfile("BROWSER"); 
		String Url = putil.getdatafrompropertiesfile("URL");
		String Username = putil.getdatafrompropertiesfile("USERNAME"); 
		String Password= putil.getdatafrompropertiesfile("PASSWORD");
		
		getDataFromExcel eutil = new getDataFromExcel();
		String campname = eutil.getdatafromexcel("Campaign", 1, 2);
		String size = eutil.getdatafromexcel("Campaign", 1, 3);

		webdriverUtility wutil = new webdriverUtility(); 
		
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		wutil.waitForPageToload(driver);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Login To NINZA CRM
				driver.get("http://49.249.28.218:8098/");
				driver.findElement(By.id("username")).sendKeys("Username");
				driver.findElement(By.id("inputPassword")).sendKeys("Password");
				driver.findElement(By.xpath("//button[text() ='Sign In']")).click();
				
				javaUtility jutil = new javaUtility();
				
				Date date = new Date();
				SimpleDateFormat sim = new SimpleDateFormat("MM-dd-YYYY");
				String currentdate = sim.format(date);
				
				Calendar cal = sim.getCalendar(); 
				cal.add(Calendar.DAY_OF_MONTH, 30);
				String datarequired = sim.format(cal.getTime());
				
				driver.findElement(By.xpath("//span[text()='Create Campaign']")).click();
				driver.findElement(By.name("campaignName")).sendKeys(campname+ jutil.getRandomNumber());
				WebElement target = driver.findElement(By.name("targetSize"));
				target.clear();
				target.sendKeys(size);
				
				WebElement closedate = driver.findElement(By.name("expectedCloseDate")); 
				wutil.mouseHoverOnWebElement(driver, closedate);
				
driver.findElement(By.xpath("//button[text()='Create Campaign']")).click();
				
				//validation
				WebElement toast = driver.findElement(By.xpath("//div[@role='alert']"));
				wutil.waitforVisibilityofElement(driver, toast);
				String msg = toast.getText();
				if(msg.contains(campname)) {
				System.out.println("campaign is created");
				}
				else{
				System.out.println("campaign not created");
				}
				driver.findElement(By.xpath("//button[@aria-label='close']")).click();
				
				//logout
				WebElement icon = driver.findElement(By.xpath("//div[@class='user-icon']"));
				wutil.mouseHoverOnWebElement(driver, icon);
				
				
				WebElement logout = driver.findElement(By.xpath("//div[@class='dropdown-item logout']"));
				 // act.moveToElement(logout).click().perform();
				wutil.clickonWebElement(driver, logout);*/


		/* //Login To NINZA CRM
		driver.get("http://49.249.28.218:8098/");
		driver.findElement(By.id("username")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[text() ='Sign In']")).click();
		
		Random random = new Random();
		int randomcount = random.nextInt(10000);
		
		Date date = new Date();
		SimpleDateFormat sim = new SimpleDateFormat("MM-dd-YYYY");
		String currentdate = sim.format(date);
		
		Calendar cal = sim.getCalendar(); 
		cal.add(Calendar.DAY_OF_MONTH, 30);
		String datarequired = sim.format(cal.getTime());
		
		//Create Campaign
		driver.findElement(By.xpath("//span[text()='Create Campaign']")).click();
		driver.findElement(By.name("campaignName")).sendKeys("Bay"+randomcount);
		driver.findElement(By.name("campaignStatus")).sendKeys("Processed");
		WebElement target = driver.findElement(By.name("targetSize"));
		target.clear();
		target.sendKeys("10");
		
		WebElement closedate = driver.findElement(By.name("expectedCloseDate"));
		Actions act = new Actions(driver);
		act.click(closedate).sendKeys(datarequired).perform();
		
driver.findElement(By.xpath("//button[text()='Create Campaign']")).click();
		
		//Validation
		WebElement toast = driver.findElement(By.xpath("//div[@role='alert']")); 
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(toast));
		String msg = toast.getText();
		
		if(msg.contains("Bay"+randomcount)) {
			System.out.println("Campign Created");
		}
		else {
			System.out.println("Campign failed");
		}
		driver.findElement(By.xpath("//button[@aria-label='close']")).click(); */
	}

		
		
	

}
