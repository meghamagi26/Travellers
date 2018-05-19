package com.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
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
		to.sendKeys("ban");
		
		Thread.sleep(2000);
		
		WebElement ul=driver.findElement(By.id("ui-id-2"));
		List<WebElement> list=ul.findElements(By.tagName("li"));
		Assert.assertEquals(list.size(),10);
		
		for(WebElement e:list)
		{
			String city=e.getText();
			if(city.contains("BKK"))
			{
				e.click();
				break;
			}
		}
		
		/*Actions act2=new Actions(driver);
		act2.sendKeys(to,"ban").perform();
		Thread.sleep(2000);
		act2.sendKeys(Keys.ARROW_DOWN).perform();
		Thread.sleep(2000);
		act2.sendKeys(Keys.ENTER).perform();*/
	
	}

}
