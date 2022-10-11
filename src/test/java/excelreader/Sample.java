package excelreader;

import java.util.ArrayList;
import java.util.HashMap;

public class Sample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExcelHelper excelHelper = new ExcelHelper("KT.xlsx", "KTCTC");
		
		ArrayList<String> val = excelHelper.getColumnDataOfMentionedColumnNumber(1);
		System.out.println(val);
		
		System.out.println(excelHelper.getColumnDataOfMentionedColumnNumber(0));
		
		HashMap<String, String> data = excelHelper.getKeyValuePaireFromExcel();
		System.out.println(data);
		System.out.println(data.get("Surname"));

	}

}
