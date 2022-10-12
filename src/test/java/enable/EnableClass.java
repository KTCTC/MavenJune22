package enable;

import org.testng.annotations.Test;

public class EnableClass {
	
	@Test (enabled = false)
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
