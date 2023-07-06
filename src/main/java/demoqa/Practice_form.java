package demoqa;

import java.time.Duration;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Practice_form {
	
	final static Logger logger = LogManager.getLogger(Practice_form.class);
	public static WebDriver driver;

	@BeforeTest
	public static void launchBrowser() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions cr = new ChromeOptions();
		cr.addArguments("--remote-allow-origins=*");
		cr.addArguments("--force-device-scale-factor=0.5");
		driver = new ChromeDriver(cr);
		driver.get("https://demoqa.com/automation-practice-form");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

	}
	
	@Test(priority = 1)
	public static void enterdata() throws InterruptedException
	{
		driver.findElement(By.id("firstName")).sendKeys("Varun");
		driver.findElement(By.id("lastName")).sendKeys("Sharma");
		driver.findElement(By.id("userEmail")).sendKeys("varun05961@yopmail.com");
		
		logger.info("FNAME Element input is working ");
		logger.info("Last name is verified");
	    
	}
		
		@Test(priority = 2)
		public static void Phonenumber()
		{
			driver.findElement(By.id("userNumber")).sendKeys("8828525255");
			logger.info("Phonenumber is verified ");
		}
		
		
	
	@Test (priority = 3)
	public static void subject_dropdown() throws InterruptedException
	{
	
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement ele = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".subjects-auto-complete__value-container input")));
		ele.sendKeys("Hindi");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='react-select-2-option-0']")).click();
		ele.sendKeys("English");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='react-select-2-option-0']")).click();
	}
	
 	@Test (priority = 4)
	public static void dropdown() throws InterruptedException  {
		driver.findElement(By.id("state")).click();
		driver.findElement(By.id("react-select-3-option-2")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("city")).click();
		driver.findElement(By.id("react-select-4-option-1")).click();
		System.out.println("passed");
		
		
		}
	@Test (priority = 5)
	public static void gender()
	{
		WebElement element = driver.findElement(By.id("gender-radio-1"));
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().build().perform();
		System.out.println("passed");
		
		}
	
	@Test (priority = 6)
	public static void  upload_image() throws InterruptedException
	{
	 WebElement uploadimage = driver.findElement(By.id("uploadPicture"));
	 Thread.sleep(5000);
	 
	 uploadimage.sendKeys(new java.io.File("C:\\Users\\VARUN\\Downloads\\2.jpg").getAbsolutePath());
	 Thread.sleep(5000);
			 
	
	}
	
	@Test (priority = 7)
	public static void hobbies()
	{
		
		WebElement element = driver.findElement(By.id("hobbies-checkbox-3"));
		Actions action = new Actions(driver);
		action.moveToElement(element).click().build().perform();
		System.out.println("Passed");
		
		
	}
	
	@Test(priority = 8)
	public static void address() {
		
		driver.findElement(By.id("currentAddress")).sendKeys("Ambala");
	}
	
	@Test (priority = 9)
	public static void datepicker() {
		WebElement element = driver.findElement(By.className("react-datepicker-wrapper"));
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().build().perform();

		Select month = new Select(driver.findElement(By.className("react-datepicker__month-select")));
		month.selectByIndex(0); // or use can also use select by value

		Select year = new Select(driver.findElement(By.className("react-datepicker__year-select")));
		year.selectByIndex(0);

		List<WebElement> day = driver.findElements(By.className("react-datepicker__day"));
		
		for (WebElement myday : day) {
			if (myday.getText()== "5")
			{
			myday.click();
			break;
			}
	}
	}
	
	@Test (priority = 8)
	public static void submit() {
		driver.findElement(By.id("submit")).click();
	}

}
