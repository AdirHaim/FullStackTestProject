package WorkFlows;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import Extensions.Click;
import PageObjects_Calculator.MainPageCalculator;
import Utilities.CommonOps;

public class Mobile_Calculator extends CommonOps
{
	
	public static void calcultate() throws IOException, ParserConfigurationException, SAXException 
	{
		Click.clickIt(calculatorMain.digit2Button);
		Click.clickIt(calculatorMain.addButton);
		Click.clickIt(calculatorMain.digit3Button);
		Click.clickIt(calculatorMain.equalsButton);
	}

}
