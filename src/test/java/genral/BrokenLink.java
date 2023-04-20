package genral;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLink {
	
	@Test
	public void broken() throws IOException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.cricbuzz.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		List<WebElement> listoflink = driver.findElements(By.tagName("a"));
		ArrayList<String> brokenlink = new ArrayList<>();
		ArrayList<String> validlink = new ArrayList<>();
		
		for (WebElement  web : listoflink) {
			
			String link = web.getAttribute("href");
			
			if(link!=null) {
				if(link.contains("http")) {
					
					validlink.add(link);
				}else {
					brokenlink.add(link);
				}
			}else {
				brokenlink.add(link);
			}
		}
		
		for (String obj : validlink) {
			
			URL url = new URL(obj);
			URLConnection urlCon = url.openConnection();
			HttpURLConnection httpurl = (HttpURLConnection)urlCon;
			int Code = httpurl.getResponseCode();
			String Msg = httpurl.getResponseMessage();
			if(Code>400) {
				
				brokenlink.add(Msg+" "+Code);
			}	
		}
		System.out.println(validlink.size());
		System.out.println(brokenlink.size());
		System.out.println(listoflink.size());
	}
}
