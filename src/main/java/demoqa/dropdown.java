package demoqa;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class dropdown {
	
	
		public static WebDriver driver;
		
		@BeforeTest
		public void lauchbrowser()
		{
			WebDriverManager.chromedriver().setup();
			ChromeOptions cr = new ChromeOptions();
			cr.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(cr);
			driver.get("https://demoqa.com/automation-practice-form");
			//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();	
		
		}
	@Test
		public void drop() throws InterruptedException
		{
		     JavascriptExecutor js = (JavascriptExecutor) driver;
    	     js.executeScript("window.scrollBy(0,250)", "");
    		driver.findElement(By.id("state")).sendKeys("Haryana");
			Thread.sleep(5000);
			driver.findElement(By.id("city")).sendKeys("Karnal");
		}

}
