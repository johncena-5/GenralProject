package genral;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Olympic {

	public static void main(String[] args) {
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://olympics.com/en/olympic-games/tokyo-2020/medals");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		List<WebElement> country = driver.findElements(By.xpath("//span[@data-cy=\"country-name\"]"));
		
		List<WebElement> gold = driver.findElements(By.xpath("//div[@title=\"Gold\"]"));
		
		List<WebElement> silver = driver.findElements(By.xpath("//div[@title=\"Silver\"]"));

		List<WebElement> bronze = driver.findElements(By.xpath("//div[@title=\"Bronze\"]"));

		for(int i=0;i<country.size();i++) {
			
		String c = country.get(i).getText();
		String g = gold.get(i).getText();
		String s = silver.get(i).getText();
		String b = bronze.get(i).getText();
		
		System.out.println("CountryName"+" "+c+" Gold "+" "+g+" Silver"+" "+s+" Bronze"+" "+b);
		}
	}
}
