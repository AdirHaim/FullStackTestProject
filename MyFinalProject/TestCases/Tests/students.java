package Tests;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import Extensions.Veriffy;
import Utilities.CommonOps;
import WorkFlows.Api_Actions;
import WorkFlows.Web_Search;

public class students extends CommonOps 
{
	
    @Test
    public void test01_VeriffyStudentCreated() throws IOException, ParserConfigurationException, SAXException 
    {
    	Api_Actions.postNewStudent();
    	Veriffy.contains(Api_Actions.getDetails().getBody().asString(), "adir@gmail.com");
    }

}
