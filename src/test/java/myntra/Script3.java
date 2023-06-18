package myntra;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Script3 {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.myntra.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		WebElement ele = driver.findElement(By.xpath("//a[@data-group=\"men\"]"));
		Actions a = new Actions(driver);
		a.moveToElement(ele).perform();
		
		
		driver.findElement(By.xpath("//a[.='Jackets' and @href=\"/men-jackets\"]")).click();
		
		WebElement drop = driver.findElement(By.xpath("//div[@class=\"sort-sortBy\"]"));
         a.moveToElement(drop).perform();
         
         driver.findElement(By.xpath("//ul[@class=\"sort-list\"]/descendant::label[.='Customer Rating']")).click();
		
	}

}
