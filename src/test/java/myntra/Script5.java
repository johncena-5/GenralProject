package myntra;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Script5 {

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
		
		List<WebElement> list = driver
				.findElements(By.xpath("//ul[@class=\"results-base\"]/child::li[@class=\"product-base\"]"));
		for (int i = 0; i < list.size(); i++) {
			if (i == 0 || i == 1 || i == 4 || i == 5) {
				list.get(i).click();
				
			}
		}

	}

}
