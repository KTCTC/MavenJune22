package priority;

import org.testng.annotations.Test;

public class PriorityInTestNG {
	@Test(priority = 10)
	public void Z()
	{
		System.out.println("z");
	}

	@Test (priority =  1, dependsOnMethods = {"Z"})
	public void h()
	{
		System.out.println("H");
	}
	@Test (priority = 10)
	public void A()
	{
		System.out.println("A");
	}
	
}
