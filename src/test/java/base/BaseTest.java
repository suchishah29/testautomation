package base;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public static WebDriver driver;
	public static Properties prop = new Properties();
	public static Properties loc = new Properties();

	public static FileReader fr1, fr2;

	@BeforeMethod
	public void setup() throws IOException {
		if (driver == null) {
			System.out.println(System.getProperty("user.dir"));
			fr1 = new FileReader(
					System.getProperty("user.dir") + "\\src\\test\\resources\\configfiles\\config.properties");
			fr2 = new FileReader(
					System.getProperty("user.dir") + "\\src\\test\\resources\\configfiles\\locators.properties");

			prop.load(fr1);
			loc.load(fr2);

		}
		if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();// base
			driver = new ChromeDriver();// base
			driver.get(prop.getProperty("testurl"));// properties
		} else if (prop.getProperty("browser").equalsIgnoreCase("firefox")) {
			WebDriverManager.chromedriver().setup();// base
			driver = new FirefoxDriver();// base
			driver.get(prop.getProperty("testurl"));// properties

		}

	}

	@AfterSuite
	public void tearDown() {
		driver.quit();
		System.out.println("Driver is closed");

	}
}
