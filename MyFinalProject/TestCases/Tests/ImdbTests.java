package Tests;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import Extensions.MySQLQueries;
import Extensions.Veriffy;
import Utilities.CommonOps;
import WorkFlows.DB_Query;
import WorkFlows.Web_Search;

public class ImdbTests extends CommonOps
{	
	   
    @Test (groups = {"HardCoded"})
    public void test01_searchValue() throws IOException, ParserConfigurationException, SAXException 
    {
	  Web_Search.search("Hugh Jackman", "All");
	  Veriffy.textInElement(imdbResultsLastPage.resultName, "Hugh Jackman");
	  Veriffy.compareImage("./ImageRepository/hughJackman.PNG");
    }
    
    @Test (groups = {"DataBased"})
    public void test02_DB() throws IOException, ParserConfigurationException, SAXException 
    {
    	Veriffy.contains(DB_Query.getMassage() , "adir");
    }
    
}
