package propertiesfile;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.Config;

public class GoogleTranslateTest2 {

	WebDriver driver;
	JavascriptExecutor js;
	ExtentReports report;
	ExtentTest test;
	
	
	@BeforeClass
	public void setup() throws InterruptedException {
		report = ExtentFactory.getInstance();
		test = report.startTest("Translate Copy");
		
		System.setProperty(Config.getProperty("driverType"), Config.getProperty("driverPath"));
		driver = new ChromeDriver();
		test.log(LogStatus.INFO, "Browser started");
		driver.manage().window().maximize();
		test.log(LogStatus.INFO, "Window maximized");
		js = (JavascriptExecutor) driver;
		js.executeScript("window.location = '" + Config.getProperty("url") + "';");
		test.log(LogStatus.INFO, "Web application opened");
	}
	
	@Test
	public void test() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver,5);
		WebElement textInput = driver.findElement(By.id("source"));
		WebElement searchButton = driver.findElement(By.id("gt-submit"));
		WebElement dropDown = driver.findElement(By.id("gt-tl-gms"));
		
		
		Config.highlightAreaWithJavascript(textInput, driver);
		textInput.sendKeys("Hello");
		test.log(LogStatus.INFO, "Text input");
		
		Config.highlightAreaWithJavascript(dropDown, driver);
		dropDown.click();
		
		WebElement toLanguage = driver.findElement(By.xpath("//div[.='Zulu']"));
		wait.until(ExpectedConditions.visibilityOf(toLanguage));
		Config.highlightAreaWithJavascript(toLanguage, driver);
		toLanguage.click();
		Config.highlightAreaWithJavascript(toLanguage, driver);
		
		
		Config.highlightAreaWithJavascript(searchButton, driver);
		searchButton.click();
		
		WebElement translation = driver.findElement(By.id("gt-res-dir-ctr"));
		Config.highlightAreaWithJavascript(translation, driver);
		
		test.log(LogStatus.PASS, "Test passed");
		
		

	}
	
	@AfterClass
	public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
		report.endTest(test);
		report.flush();
		
	}

}
