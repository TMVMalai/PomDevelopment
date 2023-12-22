package JavaTest;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class Reader {
	@Test
	public void main() {
		String file = "data.xlsx";
		try {
			FileInputStream inputStream = new FileInputStream(file);
			Workbook workbook = new XSSFWorkbook(inputStream);
			Sheet sheet = workbook.getSheetAt(0);
			Row row = sheet.getRow(1);
			Cell cell = row.getCell(0);
			if(cell.getCellType()==CellType.STRING) {
				System.out.println(cell.getStringCellValue());
			}
			else {
				System.out.println(cell.getNumericCellValue());
			}
			workbook.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
