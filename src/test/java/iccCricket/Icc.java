package iccCricket;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Icc {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.icc-cricket.com/rankings/mens/player-rankings/test/batting");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		boolean image = driver.findElement(By.xpath("//span[@class=\"icn icn-logo-mrf-rankings\"]")).isDisplayed();
		Assert.assertTrue(image);

		List<WebElement> player = driver
				.findElements(By.xpath("//tr[@class=\"table-body\" or @class=\"rankings-block__banner\"]"));

		for (WebElement web : player) {
			System.out.println(web.getText());

		}
        
		driver.findElement(By.xpath("//div[.='Filter by Year']/preceding-sibling::div")).click();
		
		String year = "2020";
		driver.findElement(By.xpath("//li[.='  "+year+" ']")).click();
		

	}
}
