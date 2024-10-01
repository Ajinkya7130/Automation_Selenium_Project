package com.selenium.finalproject;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTestCase extends BaseClass {
	LoginPage lp;

	@Test(dataProvider = "LoginData")
	public void validTestCase(String EnterEmail, String EnterPassword) {
		System.out.println(EnterEmail);
		System.out.println(EnterPassword);

		LoginPage dt = new LoginPage(driver);
		dt.email(EnterEmail);
		dt.password(EnterPassword);
		dt.singIn();

		if (driver.getTitle().equals("JavaByKiran | Dashboard")) {
			Assert.assertTrue(true);

			LoginPage dpage = new LoginPage(driver);
			dpage.singIn();
		} else if (dt.email() == true || dt.password() == true) {
			driver.navigate().refresh();
			Assert.assertTrue(true);
		}

		else {
			Assert.fail();
		}

	}

	@DataProvider(name = "LoginData")
	public Object[][] dataprovider() throws IOException {

		LoginTestData dpp = new LoginTestData();
		Object data[][] = dpp.getData();
		System.out.println(dpp.getData());
		return data;

	}

}
//