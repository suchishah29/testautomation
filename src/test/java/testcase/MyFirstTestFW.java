package testcase;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;

public class MyFirstTestFW extends BaseTest {
	@Test(dataProvider = "testData")
	public static void LoginTest(String username, String password) throws InterruptedException {

		driver.manage().window().maximize();
		driver.get("https://www.zoho.com/");
		System.out.println("login");
		driver.findElement(By.linkText(loc.getProperty("signin_link"))).click();
		Thread.sleep(5000);
		driver.findElement(By.id(loc.getProperty("email_field"))).sendKeys(username);
		driver.findElement(By.id(loc.getProperty("next_button"))).click();
		Thread.sleep(5000);
		driver.findElement(By.id(loc.getProperty("password"))).sendKeys(password);
		driver.findElement(By.xpath(loc.getProperty("sign_in"))).click();

	}
	
	@DataProvider(name="testData")
	public Object[][] tData(){
		return new Object[][] {
			{"suchi.shah29@yahoo.co.in","NewJob@24"},
			{"suchi.shah29@yahoo.com","NewJob@24"}
		};
	}
	}

