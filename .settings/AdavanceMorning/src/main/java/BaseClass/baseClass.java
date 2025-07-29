package BaseClass;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import POM.HomePage;
import POM.LoginPage;
import PropertiesFileUtility.getDataFromPropertiesFile;

public class baseClass {
	public WebDriver driver = null;
	public static WebDriver sdriver = null;

	public getDataFromPropertiesFile putil = new getDataFromPropertiesFile();
	
	@BeforeSuite(groups = {"Smoke","Regression"})
	public void beforesuite() {
	Reporter.log("DB Connectivity open",true);
	}
	
	@BeforeTest(groups = {"Smoke","Regression"})
	public void beforetest() {
	System.out.println("preconditions");
	}
	
	@BeforeClass(groups = {"Smoke","Regression"})
	public void beforeclass() throws IOException {
		
	String BROWSER = putil.getdatafrompropertiesfile("BROWSER");
	if(BROWSER.equals("Edge")) {
	driver= new EdgeDriver();
	}
	else if(BROWSER.equals("Chrome")) {
	driver= new ChromeDriver();
	}
	else if(BROWSER.equals("Firefox")) {
	driver= new FirefoxDriver();
	}
	System.out.println("lauching Browser");
	driver.manage().window().maximize();
	}
	
	@BeforeMethod(groups = {"Smoke","Regression"})
	public void beforeMethod() throws IOException {
		String Browser = putil.getdatafrompropertiesfile("BROWSER");
		String Url = putil.getdatafrompropertiesfile("URL");
		String Username = putil.getdatafrompropertiesfile("USERNAME");
		String Password= putil.getdatafrompropertiesfile("PASSWORD");
		
	    driver.get(Url);
		LoginPage lp = new LoginPage(driver);
		lp.getUN().sendKeys(Username);
		lp.getPW().sendKeys(Password);
		lp.getLoginbtn().click();
		System.out.println("LOGIN DONE");
		}
	
		@AfterMethod(groups = {"Smoke","Regression"})
		public void aftermethod() {
		HomePage hp = new HomePage(driver);
		hp.getUserIcon().click();
		hp.getLogoutBtn().click();
		System.out.println("LOGOUT DONE");
			}
		
		@AfterClass(groups = {"Smoke","Regression"})
		public void afterClass() {
		 driver.quit();
		 System.out.println("closing browser");
				}
		@AfterTest(groups = {"Smoke","Regression"}) 
		public void aftertest() {
		System.out.println("POST CONDITIONS");
		}
		@AfterSuite(groups = {"Smoke","Regression"})
		public void afterSuite() {
		System.out.println("closeDB Connectivity");
		}
	}



