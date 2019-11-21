package PageObjects_IMDB;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ResultsFirstPage
{
	
	@FindBy(how = How.CSS , using="img[src='https://m.media-amazon.com/images/M/MV5BNDExMzIzNjk3Nl5BMl5BanBnXkFtZTcwOTE4NDU5OA@@._V1_UX32_CR0,0,32,44_AL_.jpg']")
	public WebElement ResultLink;


}
