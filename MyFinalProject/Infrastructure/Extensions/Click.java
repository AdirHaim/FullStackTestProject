package Extensions;

import static org.testng.Assert.fail;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.xml.sax.SAXException;

import com.relevantcodes.extentreports.LogStatus;

import Utilities.CommonOps;

public class Click extends CommonOps
{
	
	public static void clickIt(WebElement element) throws IOException, ParserConfigurationException, SAXException
	{
		try
		{
			element.click();
			test.log(LogStatus.PASS, "element clicked successesfully");
		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "failed to click on element, see details: " + e + "see screenshot" + test.addScreenCapture(tekeScreenShot()));
			fail("failed to click on element");
		}
	}

}
