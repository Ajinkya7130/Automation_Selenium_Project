package com.selenium.finalproject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class BaseClass {

	public WebDriver driver;

	@Test
	void setup() {

		driver = new ChromeDriver();
		driver.get("file:///C:/Users/AJINKYA/Downloads/Offline%20Website/index.html");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterClass
	void tearDown() {
		driver.quit();
	}

}
