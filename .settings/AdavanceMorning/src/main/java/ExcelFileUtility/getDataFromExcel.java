package ExcelFileUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class getDataFromExcel {

	public String getdatafromexcel(String Sheetname,int rowNum,int cellNum) throws IOException {
		
		FileInputStream fis = new FileInputStream("./TestData/TestScriptData.xlsx");
	    Workbook wb = WorkbookFactory.create(fis);
	    String data = wb.getSheet(Sheetname).getRow(rowNum).getCell(cellNum).getStringCellValue();
	    wb.close();
	    return data;
		
	    
	
	}

}
