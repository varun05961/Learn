package Pratice;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class accordia {

	public static WebDriver driver;
	
	@BeforeTest
	public void launch_browser()
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions cr = new ChromeOptions();
		cr.addArguments("--remote-allow-orgins=*");
		
		driver = new ChromeDriver (cr);
		driver.get("https://demoqa.com/accordian");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		}
	
	@Test
	public void accor()
	{
				
			List<WebElement> accodian = driver.findElements(By.className("card"));
			Actions actions = new Actions(driver);
			Iterator<WebElement> iterator = accodian.iterator();
			while (iterator.hasNext()) {
	            WebElement element = iterator.next();
	            actions.click(element).perform();
			}
			
			
		
}
		
			
}
