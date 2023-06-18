package iccCricket;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Google {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		

		driver.findElement(By.id("APjFqb")).sendKeys("java");
		
		List<WebElement> list = driver.findElements(By.xpath("//ul[@jsname=\"bw4e9b\"]/child::li/descendant::div[@class=\"wM6W7d\"]"));
	    for (WebElement web: list) {
			if(web.getText().contains("java compiler")) {
				web.click();
			}
		}
	    
	    
	}

}
