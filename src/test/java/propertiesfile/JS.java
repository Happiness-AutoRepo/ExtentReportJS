package propertiesfile;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class JS {

	WebDriver driver;
	JavascriptExecutor js;

	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/Marat Metoff/Documents/Libraries/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		js = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void f() {
		js.executeScript("window.location = 'http://www.amazon.com';");
		System.out.println(js.executeScript("return window.innerHeight;"));
		System.out.println(js.executeScript("return window.innerWidth;"));
		//js.executeScript("window.scrollBy(0,1900);");										   // scrolling for a certain amount of pixels	
		
		WebElement element = driver.findElement(By.partialLinkText("Sell on Amazon"));         // scrolling particular element into view
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		
	}

	@AfterTest
	public void afterTest() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}
}
