package annotations.testng;


import org.testng.annotations.Test;

public class AnnotationInTestNG extends TestBase{	
	
	
	@Test
	public void verifyUserCanNOtLoginToApplicationWithInvalidCredentials()
	{
		System.out.println("verify User Can NOt Login To Application With Invalid Credentials");
	}
	
	@Test
	public void verifyUserCanLoginToApplicationWithValidCredentials()
	{
		System.out.println(" verify User Can Login To Application With Valid Credentials");
		
	}
	
	
}
