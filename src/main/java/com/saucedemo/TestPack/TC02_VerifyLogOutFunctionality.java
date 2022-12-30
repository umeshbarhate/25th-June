package com.saucedemo.TestPack;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.saucedemo.POMPack.HomePOMClass;


public class TC02_VerifyLogOutFunctionality extends TestBaseClass
{
 
	@Test
	public void verifyLogOut()
	{
		HomePOMClass hp = new HomePOMClass(driver);
		hp.clickOnMenuButton();
		System.out.println("Clicked on menu Button");
		
		hp.clickOnLogOutButton();
        System.out.println("Clicked on logOut Button");
		
		//loginPage
		System.out.println("Went on LoginPage");
		
		//validation
		System.out.println("Apply validation");		
		String expectedTitle = "Swag Labs";   //BA/dev		
		String actaulTitle =driver.getTitle();	
		
		Assert.assertEquals(actaulTitle, expectedTitle);
				

	}

}
