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

public class menu {

	public static WebDriver driver;
	
	@BeforeTest
	public void lauchbrowser()
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions cr = new ChromeOptions();
		cr.addArguments("--remote-allow-origins=*");
		driver= new ChromeDriver(cr);
		driver.get("https://demoqa.com/menu#");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		
		
	}
	@Test
	public void menu() throws InterruptedException {
		
		WebElement menu1 = driver.findElement(By.cssSelector("#nav li:nth-child(2)"));
		Actions ac = new Actions(driver);
		ac.moveToElement(menu1).perform();
		
		WebElement menu2 = driver.findElement(By.cssSelector("#nav li:nth-child(2) ul li:nth-child(3)"));
		Actions ac1 = new Actions(driver);
		ac1.moveToElement(menu2).perform();
		
		WebElement menu3 = driver.findElement(By.cssSelector("#nav li:nth-child(2) ul li:nth-child(3) ul li:nth-child(1)"));
		Actions ac2 = new Actions(driver);
		ac2.moveToElement(menu3).perform();
		
	}
		
}
