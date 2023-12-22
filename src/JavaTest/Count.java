package JavaTest;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class Count {
	@Test
	public void main() {
		String filepath = "data.xlsx";
		try {
			FileInputStream inps = new FileInputStream(filepath);
			Workbook workbook = new XSSFWorkbook(inps);
			Sheet sheet = workbook.getSheetAt(0);
			int lastrowno =sheet.getLastRowNum();
			int firstrowno = sheet.getFirstRowNum();
			System.out.println(lastrowno-firstrowno);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
