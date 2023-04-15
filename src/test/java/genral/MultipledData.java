package genral;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class MultipledData {
	
	@Test
	public void demo() throws EncryptedDocumentException, IOException {
		
		FileInputStream fis = new FileInputStream("./src/test/resources/general.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis);
		
		Sheet sh = wb.getSheet("Sheet1");
		
		int count = sh.getLastRowNum();
		
		HashMap<String, String> map = new HashMap<>();
		
		for(int i=0; i<=count;i++) {
			
			String key = sh.getRow(i).getCell(0).getStringCellValue();
			
			String value = sh.getRow(i).getCell(1).getStringCellValue();
			
			map.put(key, value);
			
		}
		
		for (Entry<String, String> m : map.entrySet()) {
			
			String key = m.getKey();
			String value = m.getValue();
			System.out.println(key+"  "+value);
		}
		
	}

}
