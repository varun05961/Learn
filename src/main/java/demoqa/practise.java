package demoqa;

import java.awt.AWTException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
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
import io.netty.handler.timeout.TimeoutException;

public class practise {
	
	public static WebDriver driver;

	@BeforeTest
	public void launchBrowser() throws InterruptedException {
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

	@Test (priority = 1)
	public void enterData() throws InterruptedException {
		try {

			List<String> formData = new ArrayList<>();
			formData.add(0, "Nitin");
			formData.add(1, "Singh");
			formData.add(2, "Nitin@gmail.com");
			formData.add(3, "8557037939");
			formData.add(4, "SBP Sec 116 Mohali");
			driver.findElement(By.id("firstName")).sendKeys(formData.get(0));
			driver.findElement(By.id("lastName")).sendKeys(formData.get(1));
			driver.findElement(By.id("userEmail")).sendKeys(formData.get(2));
			driver.findElement(By.id("userNumber")).sendKeys(formData.get(3));
			driver.findElement(By.id("currentAddress")).sendKeys(formData.get(4));

		} catch (NoSuchElementException e) {
			System.out.println("Unable to locate element" + e);
		} catch (TimeoutException e) {
			e.printStackTrace();

		}
	}

	@Test (priority = 2)
	public void subject_autosuggestion_dropdown() throws InterruptedException, AWTException {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			WebElement ele = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".subjects-auto-complete__value-container input")));
			ele.sendKeys("English");
			Thread.sleep(1000);

			driver.findElement(By.xpath("//div[@id='react-select-2-option-0']")).click();

		} catch (NoSuchElementException e) {
			System.out.println("Unable to locate element" + e);
		} catch (TimeoutException e) {
			e.printStackTrace();

		}
	}

	@Test (priority = 3)
	public void selectGender() {
		try {
			WebElement element = driver.findElement(By.id("gender-radio-1"));
			Actions actions = new Actions(driver);
			actions.moveToElement(element).click().build().perform();
		} catch (NoSuchElementException e) {
			System.out.println("Unable to locate element" + e);
		} catch (TimeoutException e) {
			e.printStackTrace();

		}
	}

	@Test (priority = 4)
	public void selectDate() {
		try {
			WebElement element = driver.findElement(By.className("react-datepicker-wrapper"));
			Actions actions = new Actions(driver);
			actions.moveToElement(element).click().build().perform();

			Select month = new Select(driver.findElement(By.className("react-datepicker__month-select")));
			month.selectByIndex(0);

			Select year = new Select(driver.findElement(By.className("react-datepicker__year-select")));
			year.selectByIndex(0);

			List<WebElement> day = driver.findElements(By.className("react-datepicker__day"));

			for (WebElement myday : day) {
				myday.click();
				break;
			}

		} catch (NoSuchElementException e) {
			System.out.println("Unable to locate element" + e);
		} catch (TimeoutException e) {
			e.printStackTrace();

		}
	}

	@Test (priority = 5)
	public void selectHobbies() {
		try {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,250)");
			// If you dont use the scroldown code , it is opening the google ad
			WebElement element = driver.findElement(By.id("hobbies-checkbox-2"));
			Actions actions = new Actions(driver);
			actions.moveToElement(element).click().build().perform();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		} catch (NoSuchElementException e) {
			System.out.println("Unable to locate element" + e);
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
	}

	@Test (priority = 6)
	public void selectState() {
		try {
			WebElement element = driver.findElement(By.id("state"));
			Actions actions = new Actions(driver);
			actions.moveToElement(element).click().build().perform();

			WebElement se = driver.findElement(By.id("react-select-3-option-0"));
			se.click();

		} catch (NoSuchElementException e) {
			System.out.println("Unable to locate element" + e);
		} catch (TimeoutException e) {
			e.printStackTrace();

		}
	}

	@Test(dependsOnMethods = { "selectState" }) 
	public void selectcity() {
		try {
			driver.findElement(By.id("city")).click();
			WebElement se = driver.findElement(By.id("react-select-4-option-1"));
			se.click();
		} catch (NoSuchElementException e) {
			System.out.println("Unable to locate element" + e);
		} catch (TimeoutException e) {
			e.printStackTrace();

		}
	}

	@Test (priority = 8)
	public void uploadImage() throws InterruptedException {
		try {
			WebElement UploadImg = driver.findElement(By.id("uploadPicture"));
			Thread.sleep(3000);
			UploadImg.sendKeys(new java.io.File("C:\\Users\\VARUN\\Documents\\hello.jpg").getAbsolutePath());
			Thread.sleep(3000);
	} 
		 catch (NoSuchElementException e) {
			System.out.println("Unable to locate element" + e);
		} catch (InterruptedException e) {
			e.printStackTrace();

	}
	}

	@Test (priority = 9)
	public void clickSubmit() {
		try {
		//	JavascriptExecutor js = (JavascriptExecutor) driver;
	    //  js.executeScript("window.scrollBy(0,250)", "");
			WebElement element = driver.findElement(By.id("submit"));
			Actions actions = new Actions(driver);
			actions.moveToElement(element).click().build().perform();
			
		} catch (NoSuchElementException e) {
			System.out.println("Unable to locate element" + e);
		} catch (TimeoutException e) {
			e.printStackTrace();

		}
	}
}



