package brockenlinks;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

import javax.net.ssl.HttpsURLConnection;

import org.testng.annotations.Test;

public class BrockenLinkClass {

	@Test
	public void sampleLink() throws IOException
	{
		
		String link = "https://demoqa.com/links";
		
		URL url = new URL(link);
		URLConnection urlConn = url.openConnection();
		HttpsURLConnection http = (HttpsURLConnection)urlConn;
		http.setConnectTimeout(15000);
		
		http.connect();
		
		int code = http.getResponseCode();
		String msg = http.getResponseMessage();
		
		System.out.println(code);
		System.out.println(msg);
		
		
	}

}
