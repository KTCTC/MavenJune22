package invocation;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Invocation {
	
	int count=0;
	
	@Test  (invocationCount = 5)
	public void verifyUserCanLoginToApplicationWithValidCredentials()
	{
		count++;
		System.out.println(" verify User Can Login To Application With Valid Credentials");
		Assert.assertTrue(true);
		if (count==3)
		{
			Assert.assertTrue(false);
		}
		
	}

}
