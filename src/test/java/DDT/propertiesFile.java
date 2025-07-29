package DDT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class propertiesFile {

	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\Abinaya\\Desktop\\Madhu Selinium docs\\TestData.properties.txt");
	   //create obj fr property file
		Properties prop = new Properties();
		//load all keys
	    prop.load(fis);
	    //get properties
	    String Browser = prop.getProperty("BROWSER");
	    String url = prop.getProperty("URL");
	    String username = prop.getProperty("USERNAME");
	    String password = prop.getProperty("PASSWORD");
	    
	    WebDriver driver = null;
	    
	    if(Browser.equals("Edge"))
	    {
	    	driver = new EdgeDriver();
	    }
	    if(Browser.equals("Chrome"))
	    {
	    	driver = new ChromeDriver();
	    }
	    
	    //Actual script
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	     
	     driver.get(url);
	     driver.findElement(By.id("username")).sendKeys(username);
	     driver.findElement(By.id("inputPassword")).sendKeys(password);
	     driver.findElement(By.xpath("//button[text() ='Sign In']")).click();
	    
	}

}
