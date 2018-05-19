package com.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewTest1 {
	
	@Test
	public void testHDFC()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://hdfcbank.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		Actions actions=new Actions(driver);
		
		actions.
		moveToElement(driver.findElement(By.xpath("//a[@href='/personal/products']"))).
		moveToElement(driver.findElement(By.xpath("//a[@href='/personal/products/demat']"))).
		moveToElement(driver.findElement(By.xpath("//a[@href='/personal/products/demat/demat-account']"))).
		click().perform();
		
		String title=driver.getTitle();
		
		Assert.assertTrue(title.startsWith("Demat Account"));
		
		
	}

}
