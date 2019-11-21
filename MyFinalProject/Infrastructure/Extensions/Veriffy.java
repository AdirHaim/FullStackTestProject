package Extensions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.openqa.selenium.WebElement;
import org.xml.sax.SAXException;
import com.relevantcodes.extentreports.LogStatus;
import Utilities.CommonOps;

public class Veriffy extends CommonOps
{
	
	public static void textInElement(WebElement element , String value) throws IOException, ParserConfigurationException, SAXException
	{
			try
			{
				assertEquals(element.getText(), value);
				test.log(LogStatus.PASS, "text found in element (Assertion)");
			}
			catch(Exception e)
			{
				test.log(LogStatus.FAIL, "Error with finding text, see details: " + e + "see screenshot" + test.addScreenCapture(tekeScreenShot()));
				fail("Error with finding text");
			}
			catch(AssertionError e)
			{
				test.log(LogStatus.FAIL, "text not fuond in elemnt, see details: " + e + "see screenshot" + test.addScreenCapture(tekeScreenShot()));
				fail("text not fuond in elemnt, see details: " + e);
			}
	}
	
	public static void compareImage(String imagePath) throws IOException, ParserConfigurationException, SAXException
	{
		try 
		{
			screen.find(imagePath);
			test.log(LogStatus.PASS, "Image found successesfully");

		}
		catch (Exception e) 
		{
			test.log(LogStatus.FAIL, "Fail to finding Image, see details: " + e + "see screenshot" + test.addScreenCapture(tekeScreenShot()));
			fail("Fail to find Image");
		}
		
	}

	public static void contains(String response , String text)
	{
		try
		{
			assertTrue(response.contains(text));
			test.log(LogStatus.PASS, "Contains Passed successesfully");
		}
		catch (AssertionError e) 
		{
			test.log(LogStatus.FAIL,text +  " Fail to be contained, See details: " + e);
			fail(text +  " Fail to be contained, See details: " + e);
		}
 
	}
	
}
