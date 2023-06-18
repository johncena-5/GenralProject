package genral;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//button[@class=\"_2KpZ6l _2doB4z\"]")).click();
		driver.findElement(By.name("q")).sendKeys("toys");
		driver.findElement(By.xpath("//button[@class=\"L0Z3Pu\"]")).submit();
		LinkedHashSet<String> set = new LinkedHashSet<>();
        List<WebElement> e = driver.findElements(By.xpath("//div[@class=\"_4ddWXP\"]/descendant::div[@class=\"_30jeq3\"]"));
	    for(int i=0;i<e.size();i++) {
	    	set.add(e.get(i).getText());
	    }
	   
	    
	}
}
