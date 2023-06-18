package iccCricket;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Java {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	public void customWait(WebDriver driver, String xpathExpress) {
		for (int i = 0; i < 20; i++) {
			try {
				driver.findElement(By.xpath(xpathExpress));
				Thread.sleep(3000);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
