package testcase;

import java.io.File;
import java.io.IOException;
import java.sql.Driver;
import java.sql.Time;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import base.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenshotCpaturing extends BaseTest {
@Test
	public static  void runningSS() throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://google.com");
		// full page ss
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File trg = new File(".\\screenshot\\home.png");
		FileUtils.copyFile(src, trg);
		
		// portion of page
		WebElement searchbox = driver.findElement(By.xpath("//img[@alt='Google']"));
		FileUtils.copyFile( searchbox.getScreenshotAs(OutputType.FILE),new File(".\\screenshot\\partial.png"));
	}

}
