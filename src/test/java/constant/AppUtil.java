package constant;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class AppUtil {
public static WebDriver driver;
public static Properties config;
@BeforeTest
public void setup() throws Throwable{
	config =new Properties();
	config.load(new FileInputStream("D:\\selinium_practice\\DDT_Project\\PropertyFiles\\Login.properties"));
	if(config.getProperty("Browser").equalsIgnoreCase("Chrome"))
	{ 
		System.setProperty("webdriver.chrome.driver", "D://chromedriver.exe");
		driver = new ChromeDriver();
	}
	else if(config.getProperty("Browser").equalsIgnoreCase("Firefox"))
	{
		driver =new FirefoxDriver();
	}
	else
	{
		System.out.println("Both are not matching");
	}	
	
}
@AfterTest
public void teardown() {
	driver.close();
}
}
