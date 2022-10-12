package assertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import annotations.testng.TestBase;

public class SoftAssertionInTestNG {
	
	TestBase obj;
	

	
	@Test
	public void verifyUserCanLoginToApplicationWithValidCredentials()
	{
		SoftAssert sAssert = new SoftAssert();
		System.out.println(" verify User Can Login To Application With Valid Credentials");
		boolean flag = false;		
		sAssert.assertFalse(flag, "Deleted user is still displyed");		
		sAssert.assertTrue(flag, "User profile name is not displayed");
		System.out.println("Sample line of code");	
		sAssert.assertAll();
		
	}

	@Test
	public void verifyUserCanNOtLoginToApplicationWithInvalidCredentials()
	{
		SoftAssert sAssert = new SoftAssert();
		System.out.println("verify User Can NOt Login To Application With Invalid Credentials");
		
		String cntSharPrice = "456.34";
		
		sAssert.assertNotEquals(cntSharPrice, "33.3");
		
		sAssert.assertEquals(cntSharPrice, "456.5634");
		
		String msg = "Invalid Credentioals";
		
		sAssert.assertEquals(msg, "Invalid Credentioals", "Invalid credential message is not displayed as per expected");
		
		System.out.println("After equality assertion");
		sAssert.assertAll();
	}
	
	@Test
	public void sampleAssertionTestCase()
	{
		SoftAssert sAssert = new SoftAssert();
		sAssert.assertNull(obj, "Object is initialized somewhere");
		sAssert.assertNotNull(obj, "Object is not initialized somewhere");
		System.out.println("After null asserrtion");
		sAssert.assertAll();
	}
	
	
	
}
