package demoqa;

import java.time.Duration;

import javax.lang.model.util.Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.netty.handler.timeout.TimeoutException;
import methods.Elements1;

public class Test1 {


		// TODO Auto-generated method stub
		public static String name = "Varun";
		public static WebDriver driver;

		// Global veriable
		public static String empName = "Aman";

		// Instance variable static int b=20;
		@BeforeTest
		public void launchBrowser() {
			WebDriverManager.chromedriver().setup();
			ChromeOptions cr = new ChromeOptions();
			cr.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(cr);

			driver.get("https://demoqa.com/elements");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();

		}

		@Test(priority = 0)
		public void handleTextBox() throws InterruptedException {
			try {
				// local variable int a=10;

				// Click on Element Icon to expand the menu
				driver.findElement(By.cssSelector(".element-group:first-child")).click();
				Thread.sleep(2000);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
				// Locate text option in the menu
				driver.findElement(By.cssSelector(".left-pannel.element-group:first-child li:first-child")).click();

				// driver.findElement(By.id("userName")).sendKeys(empName);

				// Java Abstraction or Page object pattern
				   driver.findElement(Elements1.TXT_Fullname).sendKeys("Varun");
			        driver.findElement(Elements1.TXT_Email).sendKeys("test@yopmail.com");
			        driver.findElement(Elements1.TXT_Address).sendKeys("ambala");
			        driver.findElement(Elements1.TXT_Permanantaddress).sendKeys("ambala");
			         
				System.out.println("Done");
				driver.quit();
			} catch (NoSuchElementException e) {
				System.out.println("Unable to locate element" + e);
			} catch (TimeoutException e) {
				// TODO: handle exception
			}
		

	}

}
