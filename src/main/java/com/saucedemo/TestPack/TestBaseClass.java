package com.saucedemo.TestPack;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.beust.jcommander.Parameters;
import com.saucedemo.POMPack.LoginPOMClass;
import com.saucedemo.utilityPack.UtilityClass;

public class TestBaseClass
{
	WebDriver driver;
    
	   Logger log= Logger.getLogger("SauceDemo25thJuneProject");
		
	    @Parameters("browserName")
	    
		@BeforeMethod
		public void setUp(String browserName) throws IOException
		{
			if(browserName.equals("chrome"))
			{
				System.setProperty("webdriver.chrome.driver", 
						"./DriverFiles/chromedriver.exe");	
			    driver = new ChromeDriver();
			}
			else
			{	    
			    System.setProperty("webdriver.gecko.driver", 
						"./DriverFiles/geckodriver.exe");	
			    driver = new FirefoxDriver();
			}	    
		    
			PropertyConfigurator.configure("log4j.properties");
			
			log.info("Browser is opened");
			
			driver.manage().window().maximize();
			log.info("Browser is maximzed");
			
			driver.get("https://www.saucedemo.com/");
			log.info("Url is opened");
			log.info("Went on LoginPage");
			
			//take screenshot
			UtilityClass.getScreenshot(driver, "loginPage-22Oct");
			
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			
			//loginActivity
			LoginPOMClass lp = new LoginPOMClass(driver);
			lp.sendUsername();
			log.info("Username is entered");
			
			lp.sendPassword();
			log.info("Password is entered");
			
			lp.clickLoginButton();
			log.info("Clicked on login Button");
			
			//homePage
			log.info("Went on HomePage");
		}
		
		@AfterMethod
		public void tearDown()
		{	
			driver.quit();
			log.info("browser is closed");
		}



}
