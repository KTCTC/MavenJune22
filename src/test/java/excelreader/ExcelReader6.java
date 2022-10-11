package excelreader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader6 {

	public static void main(String[] args) throws IOException {

		File f = new File(System.getProperty("user.dir") + "\\KT.xlsx");
		FileInputStream fis = new FileInputStream(f);

		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh = wb.getSheet("KTCTC");

		int a = sh.getLastRowNum();

		for (int i = 1; i <= a; i++) {
			XSSFRow row = sh.getRow(i);

			XSSFCell cel = row.getCell(0);
			String k = getCellValueAccordingToCellType(cel);			
			cel = row.getCell(1);
			String v = getCellValueAccordingToCellType(cel);
			System.out.print(k+"=");
			System.out.print(v);
			System.out.println();

		}

	}
	
	
	public static String getCellValueAccordingToCellType(XSSFCell cel)
	{
		Object data = null;
		switch (cel.getCellType()) {
		case STRING:
			data = cel.getStringCellValue();
			break;
		case BOOLEAN:
			data = cel.getBooleanCellValue();
			break;
		case NUMERIC:
			data = cel.getNumericCellValue();
			break;

		default:
			System.out.println("Unexpected cell Type");
			break;
		}
		
		return data.toString();
	}

}
