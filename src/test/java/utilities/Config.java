package utilities;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Config {

	static WebDriver driver;
	
	private static Properties prop;
	
	static {
		try{
			String filePath = "./src/test/resources/testdata/configurations.properties";
			FileInputStream fs = new FileInputStream(filePath);								
			prop = new Properties();												
			prop.load(fs);																	
			fs.close();   																	
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String getProperty(String key) {
		return prop.getProperty(key);
	} 
	
	public static void highlightAreaWithJavascript(WebElement element, WebDriver driver) throws InterruptedException {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border= '3px solid red'", element);
		Thread.sleep(2000);
	}

}
