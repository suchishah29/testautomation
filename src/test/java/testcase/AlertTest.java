package testcase;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.google.common.base.Function;

import base.BaseTest;

public class AlertTest extends BaseTest {

	public static WebDriver driver;

	@Test
	public void openBrowser() throws IOException {
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disbale-notificatons");
//		WebDriverManager.chromedriver().setup();// base
		driver = new ChromeDriver();// base
WebDriver driver= new ChromeDriver();
		driver.get("https://www.zoho.com/");
		driver.navigate().back();
		String w1=driver.getWindowHandle();
		driver.switchTo().alert().accept();
//	implicitnwait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
//	explicit wait	
		WebDriverWait wait1= new  WebDriverWait(driver,Duration.ofSeconds(200));
		WebElement el1= driver.findElement(By.xpath(""));
		wait1.until(ExpectedConditions.visibilityOf(el1));
//		fluent wait

		
		Wait<WebDriver> wait2 = new FluentWait<WebDriver>( driver)
				.withTimeout(Duration.ofSeconds(2000))
				.pollingEvery(Duration.ofSeconds(200))
				.ignoring(Exception.class);

				WebElement foo=wait2.until(new Function<WebDriver, WebElement>() {
				public WebElement applyy(WebDriver driver) {
				return driver.findElement(By.id("foo"));
				}

				@Override
				public WebElement apply(WebDriver input) {
					// TODO Auto-generated method stub
					return null;
				}
				});
	}

}
