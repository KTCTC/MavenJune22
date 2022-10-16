package screencapture;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SampleClass {
	WebDriver driver;
	@BeforeClass
	public void beforeClassAnno() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");
		 driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://demo.guru99.com/test/upload/");
	}
	
	@Test (priority = 1)
	public void verifyUserCanUploadFileSuccessFully() {
		

		driver.findElement(By.id("uploadfile_0")).sendKeys(System.getProperty("user.dir") + "\\env.properties");

		driver.findElement(By.id("terms")).click();

		driver.findElement(By.id("submitbutton")).click();

		 WebDriverWait wt = new WebDriverWait(driver, 5);

		 wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[contains(text(),'1 file ')]")));

		String msg = driver.findElement(By.xpath("//*[contains(text(),'1 file ')]")).getText();         
		
		Assert.assertEquals(msg, "1 file\nhas been successfully uploaded");		
		

	}
	
	@Test (priority = 2)
	public void verifyUserCanLoginToFacebook()
	{
		driver.get("https://www.facebook.com/");
		Assert.assertTrue(false);
		
	}
	
	@AfterMethod
	public void afterMEthodAnnotation(ITestResult result) throws IOException
	{
		
		if (result.getStatus()==ITestResult.SUCCESS)
		{
			System.out.println("No need to take screen shot for Passed testcase");
		}
		else if (result.getStatus()==ITestResult.FAILURE)
		{
			TakesScreenshot ts = (TakesScreenshot)driver;
			
			File capFile = ts.getScreenshotAs(OutputType.FILE);
			
			File actImage = new File(System.getProperty("user.dir")+"\\"+result.getName()+".png");
			
			FileUtils.copyFile(capFile, actImage);
		}
		else
		{
			System.out.println("No need to take screen shot for skipped testcase");
		}
		
	}

}
