package JavaTest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class NewExcelData {
	@Test
public void excelWritter() throws IOException {
		
		
		try(XSSFWorkbook file = new XSSFWorkbook()){
			Sheet sheet1 = file.createSheet("Sheet1");
			Object[][] data= {
					{"Name","Age","Email"},
					{"John Doe",30,"john@test.com"},
					{"Jane Doe",28,"jane@test.com"},
					{"Boby Smith",35,"jack@example.com"},
					{"Swapnil",37,"swapnil@example.com"}
			};
			int rowNum =0;
			for(Object[] RowData:data) {
				Row row = sheet1.createRow(rowNum++);
				int cloumnNum =0;
						for(Object field :RowData) {
							Cell cell = row.createCell(cloumnNum++);
							if(field instanceof String) {
								cell.setCellValue((String)field);
							}
							else if(field instanceof Integer) {
								cell.setCellValue((int)field);
							}
						}
			}
			try(FileOutputStream outputstream = new FileOutputStream("data.xlsx")){
				file.write(outputstream);
			}
			System.out.println("Data Successfully Written Successfully");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
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
