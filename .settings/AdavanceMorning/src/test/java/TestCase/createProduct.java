package TestCase;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import ExcelFileUtility.getDataFromExcel;
import JavaFileUtility.javaUtility;
import POM.HomePage;
import POM.LoginPage;
import POM.ProductPage;
import PropertiesFileUtility.getDataFromPropertiesFile;
import WebdriverUtility.webdriverUtility;

public class createProduct {

	public static void main(String[] args) throws IOException{
		
		
		getDataFromPropertiesFile putil = new getDataFromPropertiesFile();
		String Browser = putil.getdatafrompropertiesfile("BROWSER"); 
		String Url = putil.getdatafrompropertiesfile("URL");
		String Username = putil.getdatafrompropertiesfile("USERNAME"); 
		String Password= putil.getdatafrompropertiesfile("PASSWORD");
		
		getDataFromExcel eutil = new getDataFromExcel();
		String pname = eutil.getdatafromexcel("Product", 1, 2);
		String psize = eutil.getdatafromexcel("Product", 1, 3);
		String pprize = eutil.getdatafromexcel("Product", 1, 4);


		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Login To NINZA CRM
		
		 driver.get(Url);
	      LoginPage lp = new LoginPage(driver);
	      lp.getUN().sendKeys(Username);
	      lp.getPW().sendKeys(Password);
	      lp.getLoginbtn().click();
	      
		/*driver.get("http://49.249.28.218:8098/");
		driver.findElement(By.id("username")).sendKeys("Username");
		driver.findElement(By.id("inputPassword")).sendKeys("Password");
		driver.findElement(By.xpath("//button[text() ='Sign In']")).click();*/
		
		javaUtility jutil = new javaUtility();
		
		//Click on create Product
		
		HomePage hp = new HomePage(driver);
		hp.getProducts().click();
		
		
		
		//enter mandatory fields
		ProductPage pp = new ProductPage(driver);
		pp.getCreateProd().click();
		pp.getProductName().sendKeys(pname+jutil.getRandomNumber());
		
		WebElement categorydropdown=pp.getProductCategory();
		//Dropdown1 
		webdriverUtility wutil = new webdriverUtility();
		wutil.select(categorydropdown, "Electricals");
		
		//driver.findElement(By.name("productName")).sendKeys(pname+jutil.getRandomNumber());
		
		
		WebElement quantity=pp.getQuantity();
		quantity.clear(); 
		quantity.sendKeys(psize);
		
		WebElement price=pp.getPrice();
		quantity.clear(); 
		price.sendKeys(pprize);
		
		//DropDown2 
		WebElement vendordropdown=pp.getVendorId();
		wutil.select(vendordropdown, "VID_007");
		
		
		driver.findElement(By.xpath("//button[contains(text(),'Add')]")).click();
		
		
	    
		  //Validation
		  		WebElement toast = driver.findElement(By.className("Toastify__toast-body")); 
		  		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		  		wait.until(ExpectedConditions.visibilityOf(toast));
		  		String msg = toast.getText();
		  		
		  		if(msg.contains("Light")) {
		  			System.out.println("Product Created");
		  		}
		  		else {
		  			System.out.println("Product failed");
		  		}
		  		hp.getToastmsg().click();
		  		//driver.findElement(By.xpath("//button[@aria-label='close']")).click();
		  		
		  	//logout
				hp.getUserIcon().click();
				hp.getLogoutBtn().click();






		/* //Create product
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.className("material-icons")).click();
		driver.findElement(By.name("productName")).sendKeys("Light");
		
		WebElement quantity = driver.findElement(By.name("quantity"));
		quantity.clear();
		quantity.sendKeys("2");
		
		WebElement price = driver.findElement(By.name("price"));
		price.clear();
		price.sendKeys("100");
		
		WebElement cat = driver.findElement(By.name("productCategory")); 
	    Select sel = new Select(cat);
	    sel.selectByIndex(2);
	    
	    WebElement ven = driver.findElement(By.name("vendorId")); 
	    Select sel1 = new Select(ven);
	    sel1.selectByIndex(1);
	    
	    driver.findElement(By.xpath("//button[@type = 'submit']")).click();
	    
	  //Validation
	  		WebElement toast = driver.findElement(By.className("Toastify__toast-body")); 
	  		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	  		wait.until(ExpectedConditions.visibilityOf(toast));
	  		String msg = toast.getText();
	  		
	  		if(msg.contains("Light")) {
	  			System.out.println("Product Created");
	  		}
	  		else {
	  			System.out.println("Product failed");
	  		}
	  		driver.findElement(By.xpath("//button[@aria-label='close']")).click(); */
	    
	    
	} 

}
