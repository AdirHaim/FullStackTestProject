package Extensions;

import static org.testng.Assert.fail;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.xml.sax.SAXException;

import com.relevantcodes.extentreports.LogStatus;

import Utilities.CommonOps;

public class Update extends CommonOps
{
	
	public static void updateText(WebElement element , String value) throws IOException, ParserConfigurationException, SAXException
	{
		
		try 
		{
			element.sendKeys(value);	
			test.log(LogStatus.PASS, "text field updated successesfully");


		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "fail to update text field, see details: " + e + "see screenshot" + test.addScreenCapture(tekeScreenShot()));
			fail("fail to update text field");
		}
	}
	
	public static void dropDownOptions(WebElement element , String option) throws IOException, ParserConfigurationException, SAXException
	{
		
		try 
		{
			Select dropDownOption = new Select(element);
			dropDownOption.selectByVisibleText(option);
			test.log(LogStatus.PASS, "Drop Down updated successesfully");

		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "fail to update Drop Down, see details: " + e + "see screenshot" + test.addScreenCapture(tekeScreenShot()));
			fail("fail to update Drop Down");
		}
	}


}
