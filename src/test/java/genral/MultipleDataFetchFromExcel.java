package genral;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class MultipleDataFetchFromExcel {

	public static void main(String[] args) throws Throwable {

		FileInputStream fis = new FileInputStream("./general.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet1");
		int lastrow = sh.getLastRowNum();
		//int lastcell = sh.getRow(0).getLastCellNum();
		DataFormatter df = new DataFormatter();

		for (int i = 0; i <= lastrow; i++) {
		Row row = sh.getRow(i);
			for (int j = 0; j <= row.getLastCellNum(); j++) {

				System.out.print(df.formatCellValue(sh.getRow(i).getCell(j))+"  ");

			}
			System.out.print("\n");
		}
	}
}
