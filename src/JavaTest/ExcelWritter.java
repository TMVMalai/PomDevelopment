package JavaTest;

import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelWritter {
	
	@Test
	public void excelWritter() throws IOException {
		
		
		try(XSSFWorkbook file = new XSSFWorkbook()){
			Sheet sheet1 = file.createSheet("Sheet1");
			
		}
		
	}

}
