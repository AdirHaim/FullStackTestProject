package WorkFlows;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import Extensions.Click;
import Utilities.CommonOps;

public class Electron_Screen extends CommonOps
{
	
	public static void getInfo() throws IOException, ParserConfigurationException, SAXException
	{
		Click.clickIt(electronMain.btn_create_windows);
		Click.clickIt(electronMain.btn_info);
		Click.clickIt(electronMain.btn_demo_toggle);
		Click.clickIt(electronMain.btn_demo_toggle);
		Click.clickIt(electronMain.btn_screen_info);
	}

}
