package demoqa;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class praframe {
	
	public static WebDriver driver;
	
	@BeforeTest
	public void lauch_browser()
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions cr = new ChromeOptions();
		cr.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(cr);
		driver.get("https://demoqa.com/alertsWindows");
	//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
	}
	
    @Test
    public void frame() throws InterruptedException {
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("window.scrollBy(0,250)", "");
    	driver.findElement(By.cssSelector(".element-group:nth-child(3) .btn.btn-light:nth-child(4)")).click();
    	
    	WebElement frame1 = driver.findElement(By.id("frame1"));
    	driver.switchTo().frame(frame1);
    	WebElement frame1text = driver.findElement(By.tagName("body"));
    	String frame = frame1text.getText();
    	System.out.println(frame);
    	Thread.sleep(5000);
    	
    	
    	
		driver.switchTo().frame(0);
    	WebElement frame2 = driver.findElement(By.id("body"));
    	String frametext = frame2.getText();
    	System.out.println(frametext);
    	
    	
    }
    
}
