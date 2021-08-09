package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import resources.base;

public class FlipKartLandingPage extends base {

	
	public WebDriver driver;

	By search=By.xpath("//*[@id='container']//following::input[@type='text']");
	By enter = By.xpath("//*[@id='container']//following::button[@type='submit']");


	public FlipKartLandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;

	}

	public FlipKartLandingPage getSearch()
	{
		driver.get(prop.getProperty("url"));
		 driver.findElement(search).sendKeys("coffee");
		 driver.findElement(enter).click();
		 // to input from keyboard we can write following code
			//driver.findElement(enter).sendKeys(Keys.ENTER);
		FlipKartLandingPage f=new FlipKartLandingPage(driver);
		 return f;

	}

	public String getTitle() {
		return driver.getTitle();
	}

	public WebElement getSearchBox() {
		return driver.findElement(search);
	}
	
	
	
}
