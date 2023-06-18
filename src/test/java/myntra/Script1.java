package myntra;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Script1 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.myntra.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement ele = driver.findElement(By.xpath("//a[@data-group=\"home-&-living\"]"));
		Actions a = new Actions(driver);
		a.moveToElement(ele).perform();
		
		List<WebElement> data = driver.findElements(By.xpath("//div[@data-group=\"home-&-living\"]/descendant::ul[position()=3]/child::li"));

		for (WebElement web : data) {
		System.out.println(web.getText());
		}

	}

}
