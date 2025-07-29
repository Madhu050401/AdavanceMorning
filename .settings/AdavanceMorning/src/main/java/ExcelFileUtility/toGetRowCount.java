package ExcelFileUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class toGetRowCount {

	public int togetrowcount(String Sheetname) throws IOException
	{
		FileInputStream fis = new FileInputStream("./TestData/TestingData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int rowcount = wb.getSheet(Sheetname).getLastRowNum();
		wb.close();
		return rowcount;
	}
	}


