package Tests;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import Extensions.Veriffy;
import Utilities.CommonOps;
import WorkFlows.Electron_Screen;


public class ElectronDemo extends CommonOps
{
	
    @Test
    public void test01_getInfo() throws IOException, ParserConfigurationException, SAXException 
    {
    	Electron_Screen.getInfo();
    	Veriffy.textInElement(electronMain.field_screen_info, "Your screen is: 1280px x 720px");
    }

}
