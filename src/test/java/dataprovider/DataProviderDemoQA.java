package dataprovider;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import excelreader.ExcelHelper;

public class DataProviderDemoQA {

	WebDriver driver;

	@BeforeClass
	public void beforeClassAnno() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://demoqa.com/webtables");
	}

	@Test (dataProvider =  "uData")
	public void addUsersToTheSystem(String name, String surname, String email, String age, String sal, String dept) {

		driver.findElement(By.id("addNewRecordButton")).click();
		driver.findElement(By.id("firstName")).sendKeys(name);
		driver.findElement(By.id("lastName")).sendKeys(surname);
		driver.findElement(By.id("userEmail")).sendKeys(email);
		driver.findElement(By.id("age")).sendKeys(age);
		driver.findElement(By.id("salary")).sendKeys(sal);
		driver.findElement(By.id("department")).sendKeys(dept);
		driver.findElement(By.id("submit")).submit();

	}

	@DataProvider (name = "uData")
	public String[][] getUserData() {
		
		ExcelHelper exHelp = new ExcelHelper("KT.xlsx", "KTCTC");
		ArrayList<String> fname = exHelp.getColumnDataOfMentionedColumnNumber(0);
		
		
		String[][] data = { { "Amol", "Patil", "amol@patil.com", "22", "45678", "IT" },
				{ "Rajkumar", "Rao", "raj@rao.com", "32", "55678", "Finance" } };

		return data;
	}

}
