package com.saucedemo.TestPack;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.saucedemo.utilityPack.UtilityClass;


public class TC01_VerifyLoginFunctionality extends TestBaseClass
{
		
	@Test
	public void verifyLogin() throws IOException
	{
		//take screenshot
		UtilityClass.getScreenshot(driver, "homePage-22Oct");
		
		//validation
		System.out.println("Apply validation");		
		String expectedTitle = "Swag Labs";   //BA/dev		
		String actaulTitle =driver.getTitle();	
		
		//hard assertion
		Assert.assertEquals(actaulTitle, expectedTitle);
		
	}

			
		}
