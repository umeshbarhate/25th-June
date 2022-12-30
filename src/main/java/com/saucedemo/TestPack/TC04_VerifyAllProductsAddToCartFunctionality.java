package com.saucedemo.TestPack;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.saucedemo.POMPack.HomePOMClass;

public class TC04_VerifyAllProductsAddToCartFunctionality extends TestBaseClass
{
	
   
	@Test
	public void verifyAllProductsAddToCart()
	{
		//all products select
		HomePOMClass hp = new HomePOMClass(driver);
		hp.clickAllProducts();
		System.out.println("All products will be get selected");
		
		//validation
		System.out.println("Apply Validation");
				
		String exepctedProductCount = "6";	
		String actualProductCount = hp.getTextOfAddToCartButton();
		System.out.println("total products selected are->"+actualProductCount);
		
		Assert.assertEquals(actualProductCount, exepctedProductCount);
		
	}
	

	}
