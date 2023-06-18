package myntra;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Script {

	public static void main(String[] args) {
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.myntra.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		WebElement ele = driver.findElement(By.xpath("//a[@data-group=\"home-&-living\"]"));
		Actions a = new Actions(driver);
		a.moveToElement(ele).perform();
		
		String link = "Bath Robes";
		driver.findElement(By.xpath("//a[.='"+link+"']")).click();

	}

}
