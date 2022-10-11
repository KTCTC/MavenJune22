package excelreader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader3 {

	public static void main(String[] args) throws IOException {

		File f = new File(System.getProperty("user.dir") + "\\KT.xlsx");
		FileInputStream fis = new FileInputStream(f);
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh = wb.getSheet("KTCTC");
		
		int a = sh.getLastRowNum();
		System.out.println(a);
		
		int b = sh.getPhysicalNumberOfRows();
		System.out.println(b);
		
		for (int i=0; i<=a;i++)
		{
			XSSFRow row = sh.getRow(i);
			
			XSSFCell cel = row.getCell(1);
			String data = cel.getStringCellValue();
			System.out.println(data);
		}
		
		
		
		
		for (int i=0;i<b;i++)
		{
			System.out.println(sh.getRow(i).getCell(1).getStringCellValue());
			
		}
		

	}

}
