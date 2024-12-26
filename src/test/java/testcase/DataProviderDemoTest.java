package testcase;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemoTest {

	@Test(dataProvider = "dataset")
	public void testDataProvider(String usernmae, String passeword) {
		System.out.println(usernmae);
		System.out.println(passeword);

	}

	@DataProvider
	public Object dataset() {
		Object[][] dataset = new Object[4][2];
		dataset[0][0] = "user1";
		dataset[0][1] = "pass1";

		dataset[1][0] = "user1";
		dataset[1][1] = "pass1";

		dataset[2][0] = "user1";
		dataset[2][1] = "pass1";

		dataset[3][0] = "user1";
		dataset[3][1] = "pass1";
		return dataset;
	}
	
	@DataProvider
	public Object create() {
		Object[][] dataset = new Object[4][2];
		dataset[0][0] = "user1";
		dataset[0][1] = "pass1";

		dataset[1][0] = "user1";
		dataset[1][1] = "pass1";

		dataset[2][0] = "user1";
		dataset[2][1] = "pass1";

		dataset[3][0] = "user1";
		dataset[3][1] = "pass1";
		return dataset;
	}
}
