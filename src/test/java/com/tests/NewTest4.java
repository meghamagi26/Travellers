package com.tests;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewTest4 {
	
	
	@Test
	public void testHDFC()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.hdfcbank.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		
		driver.findElement(By.id("loginsubmit")).click();
		
		String home= driver.getWindowHandle();
		
		Set<String> windows=driver.getWindowHandles();
		Assert.assertEquals(windows.size(),2);
		
		for(String s:windows)
		{
			System.out.println(s);
			driver.switchTo().window(s);
		}
		
		
		driver.findElement(By.xpath("/html/body/div[4]/div[2]/div[1]/a")).click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.switchTo().frame(driver.findElement(By.name("login_page")));
		driver.findElement(By.xpath("//img[@alt='continue']")).click();
		if(ExpectedConditions.alertIsPresent()!=null)
		{
		Alert al=driver.switchTo().alert();
		System.out.println(al.getText());
		al.accept();
		}
		
		driver.findElement(By.name("fldLoginUserId")).sendKeys("5454554");
		
		driver.switchTo().window(home);
		//driver.close();
		driver.quit();
	}

}
