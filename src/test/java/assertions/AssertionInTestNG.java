package assertions;

import org.testng.Assert;
import org.testng.annotations.Test;

import annotations.testng.TestBase;

public class AssertionInTestNG {
	
	TestBase obj;
	
	@Test
	public void verifyUserCanLoginToApplicationWithValidCredentials()
	{
		System.out.println(" verify User Can Login To Application With Valid Credentials");
		boolean flag = false;
		
		Assert.assertFalse(flag, "Deleted user is still displyed");
		
		Assert.assertTrue(flag, "User profile name is not displayed");
		
		System.out.println("Sample line of code");
		
	}

	@Test
	public void verifyUserCanNOtLoginToApplicationWithInvalidCredentials()
	{
		System.out.println("verify User Can NOt Login To Application With Invalid Credentials");
		
		String cntSharPrice = "456.34";
		
		Assert.assertNotEquals(cntSharPrice, "33.3");
		
		Assert.assertEquals(cntSharPrice, "456.334");
		
		String msg = "Invalid Credentioals";
		
		Assert.assertEquals(msg, "Invalid Credentioals", "Invalid credential message is not displayed as per expected");
		
		System.out.println("After equality assertion");
	
	}
	
	@Test
	public void sampleAssertionTestCase()
	{
		Assert.assertNull(obj, "Object is initialized somewhere");
		Assert.assertNotNull(obj, "Object is not initialized somewhere");
		System.out.println("After null asserrtion");
	}
	
	
	
}
