package demoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class slide_bar {
	
	public static WebDriver driver;
	
	@BeforeTest
	public void launchbrowser()
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions cr = new ChromeOptions();
		cr.addArguments("--remote-allow-origins=*");
		cr.addArguments("--force-device-scale-factor=0.5");
		driver = new ChromeDriver(cr);
		driver.get("https://demoqa.com/progress-bar");
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();	
	}
	@Test
	public void slidebar() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		String progressbar = "arguments[0].setAttribute('style','width: 75%');";
		
		js.executeScript(progressbar, driver.findElement(By.id("startStopButton")));
	}
		
	}


