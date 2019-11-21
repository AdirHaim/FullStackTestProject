package PageObjects_IMDB;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ResultsLastPage 
{
	
	@FindBy(how = How.XPATH , using="//h1/span[@class='itemprop']")
	public WebElement resultName;

}
