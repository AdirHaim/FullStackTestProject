package PageObject_DesktopCalculator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import Utilities.CommonOps;
import io.appium.java_client.windows.WindowsDriver;

public class MainPageDesktopCalculator extends CommonOps
{
	
	@FindBy(how = How.XPATH, using=("//Button[@Name='����']"))
	public WebElement num3Button;
	
 	@FindBy(how = How.XPATH, using="//Button[@Name='����']")
 	public WebElement plusButton;
	
 	@FindBy(how = How.XPATH, using="//Button[@Name='�����']")
 	public WebElement num2Button;
	
 	@FindBy(how = How.XPATH, using="//Button[@Name='����']")
	public WebElement equalButton;
 	
	
	public static String getCalculatorResultText()
	{
		// trim extra text and whitespace off of the display value
		return ((WindowsDriver) driver).findElementByAccessibilityId("CalculatorResults").getText().replace("������ ���", "").trim();
	}
	
}
