package PageObjects_IMDB;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MainPage 
{
	
	@FindBy(how = How.CSS , using="input[id='navbar-query']")
	public WebElement searchField;
	
	@FindBy(how = How.CSS , using="select[id='quicksearch']")
	public WebElement selectSearchOption;
	
	@FindBy(how = How.CSS , using="button[id='navbar-submit-button']")
	public WebElement searchButton;

}
