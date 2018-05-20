package com.tests;

import org.testng.annotations.Test;

import com.pages.MercuryToursRegisterPage;
import com.pages.MercuryToursWelcomePage;

import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class NewTest {
	
 WebDriver driver;
 MercuryToursWelcomePage mtwp;
 MercuryToursRegisterPage mtrp;
 
  @Test(priority=1)
  public void testMercuryToursWelcome()
  {
	  driver.get("http://newtours.demoaut.com/");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
  }
	
  @Test(priority=3)
  public void testMercuryToursLogin() {
	  
	String title=  mtwp.clickLogin();
	Assert.assertTrue(title.contains("Find a Flight"));
	  
  }
  @Test(priority=2)
  public void testMercuryToursRegister() {
	  
	  String url=mtwp.clickRegister();
	  Assert.assertTrue(url.contains("register"));
	  mtrp.clickUserInfo();
	  mtrp.clickSignOFF();
	  
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver","C:\\Selenium\\Drivers\\chromedriver.exe");
	  driver=new ChromeDriver();
	  mtwp=PageFactory.initElements(driver,MercuryToursWelcomePage.class);
	  mtrp=PageFactory.initElements(driver,MercuryToursRegisterPage.class);
	  
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
	  mtwp=null;
	  mtrp=null;
  }

  
  
}
