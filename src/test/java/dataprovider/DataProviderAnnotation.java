package dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderAnnotation {
	
	
	@Test(dataProvider = "studentNames")
	public void addStudentInSystem(String name)
	{
		System.out.println(name);
	}
	
	@DataProvider (name = "studentNames")
	public String[] getName()
	{
		String[] names = {"Sandip", "Amol", "Rohan", "Vaishali"};
		
		return names;
	}
	
	
	@Test (dataProvider = "studentInfo" )
	public void enterNewStudentsInCollage(String name, String surname, String div)
	{
		System.out.println(name);
		System.out.println(surname);
		System.out.println(div);
	}
	
	@DataProvider(name = "studentInfo")
	public String[][] getDetailsOfUser()
	{
		String[][] arr = {{"Amol", "Patil", "A"},{"Salman", "Khan", "B"}};
		
		return arr;
	}
	
	
	

}
