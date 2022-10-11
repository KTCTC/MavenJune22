package ktctc.FirstMavenProject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FileUploadClass {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://demo.guru99.com/test/upload/");

		driver.findElement(By.id("uploadfile_0")).sendKeys(System.getProperty("user.dir") + "\\env.properties");

		driver.findElement(By.id("terms")).click();

		driver.findElement(By.id("submitbutton")).click();

		 WebDriverWait wt = new WebDriverWait(driver, 5);

		 wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[contains(text(),'1 file ')]")));

		String msg = driver.findElement(By.xpath("//*[contains(text(),'1 file ')]")).getText();

		System.out.println(msg);
		if (msg.equals("1 file\nhas been successfully uploaded.")) {
			System.out.println("File upload test case is passed");
		} else {
			System.out.println("File upload test case is failed");
		}

	}

}
