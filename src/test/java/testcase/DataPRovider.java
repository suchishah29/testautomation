package testcase;

import org.testng.annotations.Test;

public class DataPRovider {
	@Test(dataProvider = "dataset",dataProviderClass = DataProviderDemoTest.class)
	public void testDataProvider(String usernmae, String passeword) {
		System.out.println(usernmae);
		System.out.println(passeword);

	}
	
	@Test(dataProvider = "create")
	public void testDataProvider2(String usernmae, String passeword,String test) {
		System.out.println(usernmae+""+passeword+""+test);

	}
}
