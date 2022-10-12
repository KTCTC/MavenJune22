package dependent;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Dependent {
	
	
	@Test 
	public void verifyUserCanLoginToApplicationWithValidCredentials()
	{
		System.out.println(" verify User Can Login To Application With Valid Credentials");
		Assert.assertTrue(true);
		
	}
	
	@Test (dependsOnMethods = {"verifyUserCanLoginToApplicationWithValidCredentials"})
	public void verifyUserCanSendEmail()
	{
		System.out.println("Youser can send email");
		Assert.assertTrue(false);
	}
	
	@Test(dependsOnMethods = {"verifyUserCanSendEmail"})
	public void verifyUserCanSeeSentEmailInSentBox()
	{
		System.out.println("verify User Can See Sent Email In SentBox");
	}

}
