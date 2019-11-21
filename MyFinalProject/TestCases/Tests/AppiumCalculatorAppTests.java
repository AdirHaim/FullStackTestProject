package Tests;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import Extensions.Veriffy;
import Utilities.CommonOps;
import WorkFlows.Mobile_Calculator;

public class AppiumCalculatorAppTests  extends CommonOps
{	
    @Test
    public void test01_veriffyCalculator() throws IOException, ParserConfigurationException, SAXException 
    {    	
    	Mobile_Calculator.calcultate();
    	Veriffy.textInElement(calculatorMain.resultButton, "5");
    }  
}
