package testng;

import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelRead1 {
	public static void main(String[] args) throws IOException {

		XSSFWorkbook workbook = new XSSFWorkbook("./data/credentials.xlsx");
		XSSFSheet sheet = workbook.getSheetAt(0);
		XSSFRow row2 = sheet.getRow(0);
		int row= sheet.getLastRowNum();
		int lastCellNum = row2.getLastCellNum();
		System.out.println(row);
		System.out.println(lastCellNum);
		for (int i = 0; i <= row; i++) {
			System.out.println(sheet.getRow(i).getCell(i).getStringCellValue());
			
		}


		
		workbook.close();

	}

}
