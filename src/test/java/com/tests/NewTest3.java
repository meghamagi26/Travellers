package com.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class NewTest3 {
	
	@Test
	public void testClearTrip() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","C:\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://www.cleartrip.com/");
		driver.manage().window().maximize();
		
		WebElement from=driver.findElement(By.id("FromTag"));
		
		Actions act1=new Actions(driver);
		act1.keyDown(from,Keys.SHIFT).perform();
		Thread.sleep(2000);
		act1.sendKeys("h").perform();;
		Thread.sleep(2000);
		act1.keyUp(Keys.SHIFT).perform();
		Thread.sleep(2000);
		act1.sendKeys("yd").perform();
		Thread.sleep(2000);
		act1.sendKeys(Keys.ENTER).perform();
		
		
		WebElement to=driver.findElement(By.id("ToTag"));
		Actions act2=new Actions(driver);
		act2.sendKeys(to,"ban").perform();
		Thread.sleep(2000);
		act2.sendKeys(Keys.ARROW_DOWN).perform();
		Thread.sleep(2000);
		act2.sendKeys(Keys.ENTER).perform();
	
	}

}
