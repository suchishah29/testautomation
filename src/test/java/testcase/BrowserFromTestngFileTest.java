package testcase;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.core.pattern.EqualsIgnoreCaseReplacementConverter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFromTestngFileTest extends BaseTest {

	public static WebDriver driver;

	@Test
	public void openBrowser() throws IOException {
//		WebDriverManager.chromedriver().setup();// base
		driver = new ChromeDriver();// base

		driver.get("https://www.zoho.com/");
		driver.navigate().back();
		String w1=driver.getWindowHandle();
		Assert.assertTrue(false);
		
		Set<String> windowIDs=driver.getWindowHandles();
		List<String> windowIdList= new ArrayList(windowIDs);
		for (String window:windowIdList) {
			driver.switchTo().window(window).getTitle();
		}
		String url= driver.findElement(By.tagName("a")).getAttribute("href");
		URL link = new URL(url);

		try {
			HttpURLConnection
			httpcon = (HttpURLConnection) link.openConnection();
			if(httpcon.getResponseCode()>400) {
				
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
//		driver.findElement(By.xpath(null));
//		List<WebElement> products = driver.findElements(By.xpath(null));
//		products.size();
//		for(WebElement product : products) {
//			if(product.getText().equals("expected name")) {
//				product.click();
//				break;
//			}
//		}
//		
////		jquery select dropdown
//		
//	} 
//	public static void selectChoiceValues(WebDriver driver,String... value) {
//		List<WebElement> choiceList=driver.findElements(By.xpath(""));
//		if(!value[0].equalsIgnoreCase("all")){
//			for(WebElement item:choiceList) {
//			String text=item.getText();{
//				for(String val:value) {
//					if(text.equals(val)) {
//						item.click();
//						break;
//					}
//				}
//			}
//		}
//		}else {
//			for(WebElement item:choiceList) {
//				item.click();
//			}
//		}
	}

}
