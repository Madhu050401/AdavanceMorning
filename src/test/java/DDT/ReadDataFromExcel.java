package DDT;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadDataFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\Abinaya\\Desktop\\Madhu Selinium docs\\Datawb.xlsx");
	    Workbook wb = WorkbookFactory.create(fis);
	    Sheet sh = wb.getSheet("Campaign");
	    Row r = sh.getRow(1);
	    String campname = r.getCell(2).getStringCellValue();
	    String size = r.getCell(3).getStringCellValue();
	    
	    
	    
	   /* FileInputStream fis = new FileInputStream("C:\\Users\\Abinaya\\Desktop\\Madhu Selinium docs\\Datawb.xlsx");
	    Workbook wb = WorkbookFactory.create(fis);
	    Sheet sh = wb.getSheet("Login");
	    Row r = sh.getRow(1);
	    String url = r.getCell(0).getStringCellValue();
	    String user = r.getCell(1).getStringCellValue();
	    String pass = r.getCell(2).toString();
	    wb.close();
	    System.out.println(url);
	    
	    //Actual script
	    WebDriver driver = new ChromeDriver();
	     driver.manage().window().maximize();
	     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	     
	     driver.get(url);
	     driver.findElement(By.id("email")).sendKeys(user);
	     driver.findElement(By.id("pass")).sendKeys(pass);*/

	}

}
