package Pratice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class toottipho {
	
	public static WebDriver driver;
	
	@BeforeTest
	public void launchbrowser()
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions cr = new ChromeOptions();
		cr.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(cr);
		driver.get("https://demoqa.com/tool-tips");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();	
	}
   @Test
   public void hover()
   {
	   WebElement ele= driver.findElement(By.id("toolTipButton"));
	   Actions action = new Actions(driver);
	   action.moveToElement(ele).perform();
	   
	   String text = driver.findElement(By.className("tooltip-inner")).getText();
	   System.out.println(text);
	   
   }
}
