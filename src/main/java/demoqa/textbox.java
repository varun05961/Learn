package demoqa;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import methods.Elements1;


public class textbox {
	
	public static WebDriver driver;
		
		// TODO Auto-generated method stub
		
	@BeforeTest
	public void lauchbrowser()
		{
		WebDriverManager.chromedriver().setup(); // to access chrome automatically without driver
        ChromeOptions cr = new ChromeOptions();
        cr.addArguments("--remote-allow-origins=*");
        
         driver =new ChromeDriver(cr);
         driver.get("https://demoqa.com/text-box");
         driver.manage().window().maximize();
         driver.manage().deleteAllCookies();
           
		}
	 @Test   // field data entered
         public void handletextbox() throws InterruptedException 
         {
        driver.findElement(Elements1.TXT_Fullname).sendKeys("Varun");
        driver.findElement(Elements1.TXT_Email).sendKeys("test@yopmail.com");
        driver.findElement(Elements1.TXT_Address).sendKeys("ambala1");
        driver.findElement(Elements1.TXT_Permanantaddress).sendKeys("ambala1");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
      
        driver.findElement(Elements1.TXT_submit).click();
        driver.quit();
         
   
		}
	

	}


