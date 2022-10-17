package brockenlinks;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BrockenLinksClass3 {
	
	@Test
	public void sampleLiunksMethod()
	{
		
		String baseUrl = "https://demoqa.com/";
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://demoqa.com/links");
		
		List<WebElement> allLinsLocator = driver.findElements(By.tagName("a"));
		
		for (WebElement each:allLinsLocator)
		{
			String actualLink = null;
			String href = each.getAttribute("href");
			if (href!=null && href.contains("https"))
			{
				actualLink = href;
			}
			else
			{
				actualLink = baseUrl +each.getAttribute("id");
			}
			
			System.out.println(actualLink);
			
		}	
		
		
		
	}

}
