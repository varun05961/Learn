package Pratice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class autocom {
	public static WebDriver driver;
	
	@BeforeTest
	public void lauchbrowser() {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions cr = new ChromeOptions();
		cr.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(cr);
		driver.get("https://demoqa.com/auto-complete");
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();		
	
		}
	@Test
 public void multiselec() {
		WebElement autocomplete = driver.findElement(By.id("autoCompleteMultipleInput"));
		List<String > data = List.of("yellow","white","green");
		for(String inputdata :data)
		{
			autocomplete.sendKeys(inputdata);
			WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement dropdownoption =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("react-select-2-option-0")));
			dropdownoption.click();
			
		
		}
	}
		@Test
		public void selectsin() throws InterruptedException {
			WebElement auto = driver.findElement(By.id("autoCompleteSingleInput"));
			auto.click();
			auto.sendKeys("white");
		    List<WebElement> value = driver.findElements(By.id("react-select-3-option-0"));
		    for(WebElement element : value)
		    {
		    	String text = element.getText();
		    	if(text.equals("white"))
		    	{
		    		element.click();
		    		
		    	}
		    }
			
					
					Thread.sleep(5000);
			driver.quit();
			
		}
		
	}
		
		
	
	

