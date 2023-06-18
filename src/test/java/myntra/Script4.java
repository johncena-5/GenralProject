package myntra;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Script4 {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.myntra.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		String exp ="Mango Man";
		driver.findElement(By.xpath("//input[@class=\"desktop-searchBar\"]")).sendKeys(exp);
		driver.findElement(By.xpath("//a[@class=\"desktop-submit\"]")).click();
		
		
		String act = driver.findElement(By.xpath("//span[@class=\"breadcrumbs-crumb\"]")).getText();
         
		Assert.assertEquals(act, exp);
	}

}
