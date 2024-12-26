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

public class AssesmnetTest {

	public static WebDriver driver;

	@Test
	public void openBrowser() throws IOException, InterruptedException {
		ChromeOptions opt = new ChromeOptions();
		driver = new ChromeDriver();// base
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://d3pv22lioo8876.cloudfront.net/tiptop/");
		String name = "Suchi";
		String pwd = "password";
		// 1. Verify that the text input element is disabled in the form
		boolean isdiabled = driver.findElement(By.xpath("//form//input[@name='my-disabled']")).isEnabled();
		Assert.assertEquals(isdiabled, false);
		
		// 2. Verify that the text input with value 'Readonly input' is in readonly state by using 2 xpaths
		WebElement element = driver.findElement(By.name("my-readonly"));

		// this will tell whether the field is editable or not
		System.out.println("Is text field non-editable: " + element.getAttribute("readonly"));
		
		// 3. Verify that the dropdown field to select color is having 8 elements
		WebElement selectDropDown = driver.findElement(By.name("my-select"));
		Select clrDropdown = new Select(selectDropDown);
		List<WebElement> clrValues = clrDropdown.getOptions();
		for (WebElement clrValue : clrValues) {
			System.out.println("Color Dropdown Value " + clrValue.getAttribute("value"));
		}
		Assert.assertEquals(8, clrValues.size());
		WebElement option = clrDropdown. getFirstSelectedOption();
		String defaultItem = option. getText().toLowerCase()  ;		

		// 4. Verify that the submit button is disabled when no data is entered in Name field
		if (driver.findElement(By.id("my-name-id")).isEnabled() == false) {
			Assert.assertEquals(false, driver.findElement(By.id("submit-form")).isEnabled());
		}
		
        //5.Verify that the submit button enabled when both Name and Password field is entered

		driver.findElement(By.id("my-name-id")).sendKeys(name);
		driver.findElement(By.id("my-password-id")).sendKeys(pwd);
		Assert.assertEquals(true, driver.findElement(By.id("submit-form")).isEnabled());
		
       //6. Verify that on submit of 'Submit' button the page shows 'Received' text
		driver.findElement(By.id("submit-form")).click();
		Thread.sleep(5000);

		Assert.assertEquals("Received!", driver.findElement(By.id("message")).getText());
		
		// 7.Verify that on submit of form all the data passed to the URL
		String url = driver.getCurrentUrl();

		Assert.assertEquals(true, url.contains(name));
		Assert.assertEquals(true, url.contains(pwd));
		Assert.assertEquals(true, url.contains(defaultItem));

	}
}
