package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MercuryToursRegisterPage {
	
	WebDriver driver;
	
	@FindBy(how=How.ID,using="email")
	WebElement email;
	
	@FindBy(how=How.NAME,using="password")
	WebElement password;
	
	@FindBy(how=How.NAME,using="confirmPassword")
	WebElement confirmPassword;
	
	@FindBy(how=How.NAME,using="register")
	WebElement register;
	
	@FindBy(how=How.LINK_TEXT,using="SIGN-OFF")
	WebElement signoff;

	public MercuryToursRegisterPage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public void clickUserInfo()
	{
		email.sendKeys("mercury");
		password.sendKeys("mercury");
		confirmPassword.sendKeys("mercury");
		register.click();
	}

	public void clickSignOFF()
	{
		signoff.click();
	}
	
	
}
