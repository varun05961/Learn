package demoqa;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class webtables {
	
	public static WebDriver driver;
	@BeforeTest
	public void launchBroswer() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions cr = new ChromeOptions();
		cr.addArguments("--remote-allow-origins=*");
		
		driver = new ChromeDriver(cr);
		driver.get("https://demoqa.com/webtables");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		
		Thread.sleep(2000);
		
	}
	
	@Test
	public void addNewRecordButton () {
		
		
		
		
		driver.findElement(By.id("addNewRecordButton")).click();
		
		List<String> i = new ArrayList<>();
		i.add(0, "Anshul");
		i.add(1, "Shukla");
		i.add(2, "anshul@mailinator.com");
		i.add(3, "29");
		i.add(4, "1000,0000,00");
		i.add(5, "SOFTWARE I.T");
		
		driver.findElement(By.id("firstName")).sendKeys(i.get(0));
		driver.findElement(By.id("lastName")).sendKeys(i.get(1));
		driver.findElement(By.id("userEmail")).sendKeys(i.get(2));
		driver.findElement(By.id("age")).sendKeys(i.get(3));
		driver.findElement(By.id("salary")).sendKeys(i.get(4));
		driver.findElement(By.id("department")).sendKeys(i.get(5));
		driver.findElement(By.id("submit")).click();
		}
		
	}


