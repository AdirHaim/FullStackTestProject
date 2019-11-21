package PageObjects_Calculator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MainPageCalculator 
{
	
	@FindBy(how = How.XPATH, using="//*[@id='digit_2']")
	public WebElement digit2Button;
	
	@FindBy(how = How.XPATH, using="//*[@id='digit_3']")
	public WebElement digit3Button;
	
	@FindBy(how = How.XPATH, using="//*[@id='op_add']")
	public WebElement addButton;
	
	@FindBy(how = How.XPATH, using="//*[@id='eq']")
	public WebElement equalsButton;
	
	@FindBy(how = How.XPATH, using="//*[@id='result']")
	public WebElement resultButton;

}
