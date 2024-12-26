package testcase;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MakeMyTrip {

	public static WebDriver driver;

	@Test
	public void openBrowser() throws IOException, InterruptedException {
		ChromeOptions opt = new ChromeOptions();
		driver = new ChromeDriver();// base
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		String fromcity = "Bengaluru";
		String tocity = "New Delhi";

		driver.get("https://www.makemytrip.com/flights/");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[@class='commonModal__close']")).click();
		Thread.sleep(5000);

		driver.findElement(By.xpath("//input[@id='fromCity']")).click();
		driver.findElement(By.xpath("//input[@id='fromCity']")).sendKeys(fromcity);
		List<WebElement> locations = driver.findElements(By.xpath("//li[@role='option']//p//span//span"));
		for (WebElement location : locations) {
			if (location.getAttribute("value").contains(fromcity)) {
				location.click();
				break;
			}
		}
		driver.findElement(By.xpath("//input[@id='toCity']")).sendKeys(tocity);
		List<WebElement> tolocations = driver.findElements(By.xpath("//li[@role='option']//p//span//span"));
		for (WebElement location : tolocations) {
			if (location.getAttribute("value").contains(tocity)) {
				System.out.println(location.getAttribute("value"));
				location.click();
				break;
			}
		}
		driver.findElement(By.xpath("//a[class(contains(),'primaryBtn')]")).click();

	}
}
