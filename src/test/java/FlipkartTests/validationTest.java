package FlipkartTests;

import java.io.IOException;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.FlipKartLandingPage;
import pageObjects.SearchResultPage;
import resources.base;

public class validationTest extends base{
	public WebDriver driver;
	FlipKartLandingPage f;
	 public static Logger log =LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initialize() throws IOException
	{
	
		 driver =initializeDriver();
		 log.info("Driver is initialized");
			
		driver.get(prop.getProperty("url"));
		 log.info("Navigated to FlipKart Home page");
	}
	@Test
	public void validateTitle() throws IOException
	{

		//one is inheritance
		// creating object to that class and invoke methods of it
		 f=new FlipKartLandingPage(driver);
		//compare the text from the browser with actual text.- Error..
		Assert.assertEquals(f.getTitle(), "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!");
		 log.info("Successfully validated Text message");
		 System.out.println("Test completed");
		}

	@Test
	public void validateSearchBox() throws IOException
	{

		 f=new FlipKartLandingPage(driver);
		Assert.assertEquals(f.getSearchBox(), true);
		log.info("Successfully validated Search Box");
		System.out.println("Test completed");
	}


	@AfterTest
	public void teardown()
	{
		driver.close();
	}

}
