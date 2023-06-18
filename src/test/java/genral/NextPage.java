package genral;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NextPage {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String searchQuery = "laptop"; // Replace with your search query
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//button[@class=\"_2KpZ6l _2doB4z\"]")).click();
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys(searchQuery);
		driver.findElement(By.xpath("//button[@class=\"L0Z3Pu\"]")).click();
		
		
		 WebElement nextPageLink = driver.findElement(By.xpath("//a[@class='_1LKTO3']"));

//		 try {
		 while (nextPageLink.isDisplayed()) {	
	            // Perform your desired actions on the current page

	            // Navigate to the next page
			 nextPageLink.click();
			 driver.navigate().refresh();

	            // Wait for the page to load before checking for the "Next" button again
	            // You can use a suitable wait mechanism here

			 Thread.sleep(3000);
	            // Find the "Next" button element again
			// nextPageLink = driver.findElement(By.xpath("//a[@class='_1LKTO3'][contains(text(),'Next')]"));
			 nextPageLink.click();
		 }
//		 }catch(Exception e) {
//			 
//		 }
	}

}
