package excelreader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	public static void main(String[] args) throws IOException {

		File f = new File(System.getProperty("user.dir") + "\\KT.xlsx");
		FileInputStream fis = new FileInputStream(f);
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh = wb.getSheet("KTCTC");
		
		XSSFRow row = sh.getRow(3);
		
		XSSFCell cel = row.getCell(1);
		String data = cel.getStringCellValue();
		System.out.println(data);
		
		String dd = sh.getRow(0).getCell(1).getStringCellValue();
		System.out.println(dd);
		

	}

}
