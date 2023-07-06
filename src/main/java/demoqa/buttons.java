package demoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class buttons {
	public static WebDriver driver;

	@BeforeTest
    public void launchBroswer() {
	WebDriverManager.chromedriver().setup();
	ChromeOptions cr = new ChromeOptions();
	cr.addArguments("---remote-allow-origins=*");
	
	driver = new ChromeDriver(cr);
	driver.get("https://demoqa.com/buttons");
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
}

@Test (priority = 1)
public void doubleclick() throws InterruptedException {
	WebElement ele = driver.findElement(By.id("doubleClickBtn"));
	Actions actions = new Actions(driver);
	actions.moveToElement(ele).doubleClick().build().perform();
	Thread.sleep(5000);
	
}

@Test (priority = 2)
public void rightclick() throws InterruptedException {
	WebElement ele = driver.findElement(By.id("rightClickBtn"));
	Actions actions = new Actions(driver);
	actions.moveToElement(ele).contextClick().build().perform();
	Thread.sleep(5000);
}
@Test (priority = 3)
public void Click() {
   WebElement ele = driver.findElement(By.cssSelector(".mt-4:nth-child(3) .btn.btn-primary"));
   Actions actions = new Actions (driver);
   actions.moveToElement(ele).click().build().perform();

}
}
