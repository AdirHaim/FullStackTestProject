package WorkFlows;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import Extensions.Click;
import Extensions.Update;
import Utilities.CommonOps;

public class Web_Search extends CommonOps
{
	
	public static void search(String searchvalue, String searchOption) throws IOException, ParserConfigurationException, SAXException
	{
		Update.updateText(imdbMain.searchField, searchvalue);
		Update.dropDownOptions(imdbMain.selectSearchOption , searchOption);
		Click.clickIt(imdbMain.searchButton);
		Click.clickIt(imdbResultsFirstPage.ResultLink);
	}
	
	

}
