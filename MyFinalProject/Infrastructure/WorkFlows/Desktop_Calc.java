package WorkFlows;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.openqa.selenium.WebElement;
import org.xml.sax.SAXException;

import Extensions.Click;
import Utilities.CommonOps;

public class Desktop_Calc extends CommonOps
{
	public static void add(WebElement first , WebElement second) throws IOException, ParserConfigurationException, SAXException
	{
		Click.clickIt(first);
		Click.clickIt(mainPageDesktopCalculator.plusButton);
		Click.clickIt(second);
		Click.clickIt(mainPageDesktopCalculator.equalButton);	
	}


}
