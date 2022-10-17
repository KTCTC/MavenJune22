package brockenlinks;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BrockenLinksClass4 {
	
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
			printLinksStstusCode(actualLink);
			
		}	
		
		
		
	}
	
	public static void printLinksStstusCode(String link)
	{
		int code = 0;
		String msg = null;
		try {
			URL url = new URL(link);
			URLConnection urlConn = url.openConnection();
			HttpsURLConnection http = (HttpsURLConnection)urlConn;
			http.setConnectTimeout(15000);
			
			http.connect();
			
			code = http.getResponseCode();
			msg = http.getResponseMessage();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(code);
		System.out.println(msg);
	}

}
