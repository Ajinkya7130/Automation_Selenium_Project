package com.selenium.finalproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

@Test
public class LoginPage {

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "email")
	WebElement txtEmail;
	@FindBy(id = "password")
	WebElement txtPassword;
	@FindBy(xpath = "//*[@id=\"form\"]/div[3]/div/button")
	WebElement txtSignIn;
	@FindBy(xpath = "/html/body/div/div[2]/a")
	WebElement txtNewMember;

	@Test
	public void email(String EnterEmail) {
		txtEmail.sendKeys(EnterEmail);
	}

	@Test
	public void password(String EnterPassword) {
		txtPassword.sendKeys(EnterPassword);
	}

	@Test
	public void singIn() {
		txtSignIn.click();
	}

	public void NewMember() {
		txtNewMember.click();
	}

	public boolean email() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean password() {
		// TODO Auto-generated method stub
		return false;
	}

}
