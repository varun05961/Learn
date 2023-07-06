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

public class Alert {
	public static WebDriver driver;
	
	@BeforeTest
	public void launchBrowser()
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions cr = new ChromeOptions();
		cr.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(cr);
		driver.get("https://demoqa.com/alerts");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();	
	}
	@Test
	public void alert1() {
		driver.findElement(By.id("alertButton")).click();
		driver.switchTo().alert().accept();
		
	}
    @Test(priority = 1)
    public void alert2() throws InterruptedException {
    	driver.findElement(By.id("timerAlertButton")).click();
    	Thread.sleep(6000);
    	driver.switchTo().alert().accept();
    }
    @Test(priority =2)
    public void alert3()
    {
    	driver.findElement(By.id("confirmButton")).click();
    	driver.switchTo().alert().dismiss();
    }
    
    @Test(priority =3)
    public void alert4()
    {
    	
    	String s = "varun";
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("window.scrollBy(0,250)", "");
    	driver.findElement(By.id("promtButton")).click();
    	driver.switchTo().alert().sendKeys(s);
    	driver.switchTo().alert().accept();
    	
    	String matchText = driver.findElement(By.id("promptResult")).getText();
    	if(matchText.contains(s))
    	{
    		
    		System.out.println("text pass");
    		
    	}else
    	{
    		System.out.println("text pass");
    	}
    	}
    	
    }

