package excelreader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelHelper {
	private XSSFSheet sh;
	public ExcelHelper(String fileName, String sheetName)
	{
		try {
			File f = new File(System.getProperty("user.dir") + "\\"+fileName);
			FileInputStream fis = new FileInputStream(f);

			XSSFWorkbook wb = new XSSFWorkbook(fis);
			 sh = wb.getSheet(sheetName);
		} catch (Exception e) {
			
			e.printStackTrace();
		} 

	}
	
	public ArrayList<String> getKeysList()
	{
		ArrayList<String> key = new ArrayList<>();		

		for (int i = 1; i <= sh.getLastRowNum(); i++) {
			XSSFRow row = sh.getRow(i);

			XSSFCell cel = row.getCell(0);
			String k = getCellValueAccordingToCellType(cel);			
			key.add(k);
		}
		return key;
	}
	
	public ArrayList<String> getValuesList()
	{
		ArrayList<String> val = new ArrayList<>();		

		for (int i = 1; i <= sh.getLastRowNum(); i++) {
			XSSFRow row = sh.getRow(i);

			XSSFCell cel = row.getCell(1);
			String v = getCellValueAccordingToCellType(cel);			
			val.add(v);
		}
		return val;
	}
	

	public ArrayList<String> getColumnDataOfMentionedColumnNumber(int colNum)
	{
		ArrayList<String> val = new ArrayList<>();		

		for (int i = 1; i <= sh.getLastRowNum(); i++) {
			XSSFRow row = sh.getRow(i);

			XSSFCell cel = row.getCell(colNum);
			String v = getCellValueAccordingToCellType(cel);			
			val.add(v);
		}
		return val;
	}
	
	public HashMap<String, String> getKeyValuePaireFromExcel()
	{
		HashMap<String, String> data = new HashMap<>();
		for (int i = 1; i <= sh.getLastRowNum(); i++) {
			XSSFRow row = sh.getRow(i);

			XSSFCell cel = row.getCell(0);
			String k = getCellValueAccordingToCellType(cel);			
			cel = row.getCell(1);
			String v = getCellValueAccordingToCellType(cel);
			data.put(k, v);
		}
		return data;
	}
	
	
	
	private static String getCellValueAccordingToCellType(XSSFCell cel)
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
