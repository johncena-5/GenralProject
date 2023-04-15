package genral;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NormalTest {
	
	@Test(dataProvider = "demoTest")
	public void demo(String faculty, String subject) {
		
		System.out.println(faculty+" "+subject);
		
	}
	
	@DataProvider
	public Object[][] demoTest() throws EncryptedDocumentException, IOException {
		
		FileInputStream fis = new FileInputStream("./src/test/resources/general.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis);
		
		Sheet sh = wb.getSheet("Sheet1");
		
		int row = sh.getLastRowNum()+1;
		
		int cell = sh.getRow(0).getLastCellNum();
		
		Object[][] obj = new Object[row][cell];
		
		for(int i=0;i<row;i++) {
			for(int j=0; j<cell;j++) {
				
				obj [i] [j] = sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return obj;		
	}
}
