package screencapture;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ScreenCapClass {
	
	
	@Test
	public void captureScreenOfApplication() throws IOException
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://demoqa.com/webtables");
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		
		File capFile = ts.getScreenshotAs(OutputType.FILE);
		
		File actImage = new File(System.getProperty("user.dir")+"\\abcd.png");
		
		FileUtils.copyFile(capFile, actImage);
	}

}
