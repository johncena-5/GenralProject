package redBus;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Script {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions o = new ChromeOptions();
		o.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(o);
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.id("src")).sendKeys("Bangalore Airport");
		
		driver.findElement(By.xpath("//div[@class=\"sc-gZMcBi grvhsy\"]/child::text[text()='Bangalore Airport']")).click();
		driver.findElement(By.id("dest")).sendKeys("Panjim");
		driver.findElement(By.xpath("//div[@class=\"sc-gZMcBi grvhsy\"]/child::text[text()='Panjim']")).click();
		
		String date = "18";
		driver.findElement(By.xpath("//span[@class=\"DayTiles__CalendarDaysSpan-sc-1xum02u-1 dkWAbH\" and text()='"+date+"']")).click();
		driver.findElement(By.id("search_button")).click();

	}
}
