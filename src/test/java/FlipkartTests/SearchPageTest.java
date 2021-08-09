package FlipkartTests;

import java.io.IOException;
import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;
import pageObjects.FlipKartLandingPage;
import pageObjects.SearchResultPage;
import resources.base;

public class SearchPageTest extends base{
	public WebDriver driver;
	
	public static Logger log =LogManager.getLogger(base.class.getName());
	public void initialize() throws IOException
	{

		driver =initializeDriver();
		log.info("Driver is initialized");

		driver.get(prop.getProperty("url"));
		log.info("Navigated to FlipKart Home page");
	}

	@Test
	public void validateSort() throws IOException
	{

		//Adding the products and The prices to the list using findElements
		List<WebElement> list_of_products = driver.findElements(By.xpath("//*[@id='container']//following::div[@class='1YokD2 _3Mn1Gg'][2]"));
		List<WebElement> list_of_products_price = driver.findElements(By.xpath("//*[@id='container']//following::div[@class='_30jeq3']"));

		String product_name;
		String product_price;
		int int_product_price;

		//Converting String into Integer
		HashMap<Integer, String> map_final_products = new HashMap<Integer,String>();
		//Running for loop to get the product list size
		for(int i=0;i<list_of_products.size();i++) {
			product_name = list_of_products.get(i).getText();
			//Getting the Product and there price values
			product_price = list_of_products_price.get(i).getText();
			//Typecasting to integer
			product_price = product_price.replaceAll("[^0-9]", "");
			int_product_price = Integer.parseInt(product_price);
			map_final_products.put(int_product_price,product_name);
		}

		log.info( map_final_products.toString());

		//Using HashMap to get all the keys
		Set<Integer> allKeys = map_final_products.keySet();
		ArrayList<Integer> array_list_values_product_prices = new ArrayList<Integer>(allKeys);

		//using collections to sort by default ascending order lowest at top and then highest values
		Collections.sort(array_list_values_product_prices);

		//Storing all the highest prices and low prices
		int low_price = array_list_values_product_prices.get(0);
		int high_price = array_list_values_product_prices.get(array_list_values_product_prices.size()-1);

		log.info(low_price);
		log.info(high_price);
		}

	@Test
	public void validateSearchResultDisplay() throws IOException
	{

		SearchResultPage sr =new SearchResultPage(driver);
		Assert.assertEquals(sr.getSearchResultDisplay(), true);
		log.info("Successfully validated Search Box");
		System.out.println("Test completed");
	}

	@AfterTest
	public void teardown()
	{
		driver.close();
	}
	
}
