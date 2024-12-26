package utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import base.BaseTest;

public class testUtils extends BaseTest{
	public  void getScreenshot() throws IOException {
		System.out.println("Drivet"+driver);
		Date currentdate = new Date();
		String screenshotFileName= currentdate.toString().replace(" ", "-").replace(":", "-");
		File screenshotfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotfile, new File(".//screenshot"+screenshotFileName+".png"));
		
	}

}
