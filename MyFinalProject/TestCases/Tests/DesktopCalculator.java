package Tests;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import Extensions.Veriffy;
import PageObject_DesktopCalculator.MainPageDesktopCalculator;
import Utilities.CommonOps;
import WorkFlows.Desktop_Calc;


public class DesktopCalculator extends CommonOps
{
    @Test
    public void test01_veriffyPlus2Numbers() throws IOException, ParserConfigurationException, SAXException 
    {
    	Desktop_Calc.add(mainPageDesktopCalculator.num2Button, mainPageDesktopCalculator.num3Button);
		assertEquals("5", MainPageDesktopCalculator.getCalculatorResultText());
    }
}
