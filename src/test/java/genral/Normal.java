package genral;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(genral.ListnerImpleClass.class)
public class Normal {

	static WebDriver sdriver;
	@Test
	public void demo() {

		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.icc-cricket.com/rankings/mens/player-rankings/test/batting");
		driver.manage().window().maximize();
		sdriver=driver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		List<WebElement> list = driver.findElements(
				By.xpath("//table[contains(@class,\"table\")]/descendant::a[contains(@href,\"/rankings/mens\")]"));// 101
		List<WebElement> rating = driver
				.findElements(By.xpath("//td[@class=\"table-body__cell rating\" or @class=\"u-text-left\"]"));// 100
		List<WebElement> country = driver.findElements(
				By.xpath("//span[contains(@class,\"table-body__\") or contains(@class,\"rankings-block__b\")]"));
		int j = 0;
		Assert.fail();
		for (int i = 1; i < list.size(); i++) {

			String fulllist = list.get(i).getText();
			if (j < 100) {
				String rat = rating.get(j).getText();
				String cou = country.get(j).getText();
				System.out
						.print(" players name " + fulllist + " " + " country name " + cou + " ratings " + rat + " \n");
				j++;
			}
		}
	}
}
