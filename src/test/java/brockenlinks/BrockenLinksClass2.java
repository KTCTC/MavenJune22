package brockenlinks;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BrockenLinksClass2 {
	
	@Test
	public void sampleLiunksMethod()
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://demoqa.com/links");
		
		List<WebElement> allLinsLocator = driver.findElements(By.tagName("a"));
		
		System.out.println(allLinsLocator.size());
		
		//allLinsLocator.get(9).click(); clicking on 10th link on page
		
		
	}

}
