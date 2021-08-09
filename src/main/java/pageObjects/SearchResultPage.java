package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//rahulonlinetutor@gmail.com

public class SearchResultPage {

	
	public WebDriver driver;
	
	By sort=By.xpath("//*[@id='container']//following::div[text()='Price -- Low to High']");
	By ListofItems=By.xpath("//div[@class='_13oc-S']");
	By searchresultdisplay = By.xpath("//*[@id=container]//following::span[@class=_10Ermr]");


	public SearchResultPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

public SearchResultPage sortBy()
{
	 driver.findElement(sort).click();
	SearchResultPage s = new SearchResultPage(driver);
	return s;
}

	public String getTitle() {
		return driver.getTitle();
	}

	public WebElement getSearchResultDisplay() {
		return driver.findElement(searchresultdisplay);
	}

}
