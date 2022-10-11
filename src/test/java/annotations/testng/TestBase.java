package annotations.testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class TestBase {
	@BeforeMethod
	public void beforeMethodAnnotation()
	{
		System.out.println("Before Method");
	}

	@AfterMethod
	public void afterMethodAnnotation()
	{
		System.out.println("After Method");
	}
	
	@BeforeClass
	public void beforeClassAnnotation()
	{
		System.out.println("Before class");
	}
	
	@AfterClass
	public void afterClassAnnotation()
	{
		System.out.println("After class");
	}
	
	@BeforeTest
	public void beforeTestAnnotation()
	{
		System.out.println("Before Test");
	}
	@AfterTest
	public void afterTestAnnotation()
	{
		System.out.println("After Test");
	}
	
	@BeforeSuite
	public void beforeSuiteAnnotation()
	{
		System.out.println("Before Suite");
	}
	@AfterSuite
	public void afterSuiteAnnotation()
	{
		System.out.println("After Suite");
	}

}
