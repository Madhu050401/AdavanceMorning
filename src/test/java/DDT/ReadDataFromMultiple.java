package DDT;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromMultiple {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./TestData/TestingData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet1");
		int rowcount = sh.getLastRowNum();
		System.out.println(rowcount);
		for(int row=1;row<=rowcount;row++)
		{
			String productname = sh.getRow(row).getCell(0).getStringCellValue();
			String product = sh.getRow(row).getCell(1).getStringCellValue();
			
			System.out.println(productname + "==" + product);
			
		}

	}

}
