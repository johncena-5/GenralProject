package genral;

import java.util.List;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FetchAllProductList {

	public static void main(String[] args) {
		
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
		
		
		try {
		 // Replace with the desired number of pages to scrape
		for (; ; ) {
			List<WebElement> nameXPath = driver.findElements(By.xpath("//div[@class='_4rR01T']"));
			List<WebElement> priceXPath = driver.findElements(By.xpath("//div[@class='_30jeq3 _1_WHN1']"));
		   
		    for (int i = 0; i < nameXPath.size(); i++) {
		        String name = nameXPath.get(i).getText();
		        
		        String price = priceXPath.get(i).getText();
		        

		        // Store or process the data as required
		        // Example: Print the name and price
		        System.out.println("Product Name: " + name);
		        System.out.println("Price: " + price);
		        System.out.println();
		    }

		     WebElement e = driver.findElement(By.xpath("(//div[@class=\"_1AtVbE col-12-12\"])[26]"));
		     JavascriptExecutor js = (JavascriptExecutor)driver;
			    js.executeScript("arguments[0].scrollIntoView(true);", e);
		    // Navigate to the next page if available
		    
		    WebElement nextPageLink = driver.findElement(By.xpath("//a[@class='_1LKTO3']"));
		   
		    if(nextPageLink.isDisplayed()) {
		    	nextPageLink.click();
		    }
		   
		    
		}
		}catch(Exception e) {
			
		}

		
	}

}
