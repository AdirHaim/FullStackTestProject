package WorkFlows;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.aspectj.weaver.GeneratedReferenceTypeDelegate;
import org.xml.sax.SAXException;

import Extensions.RestAPI;
import Utilities.CommonOps;
import io.restassured.response.Response;

public class Api_Actions extends CommonOps 
{
	
	private static String[] details = {"adir" , "haim" , "adir@gmail.com" , "QA"};
	private static List<String> subjects = new ArrayList<String>();
	
	public static void postNewStudent() throws ParserConfigurationException, SAXException, IOException
	{
		subjects.add("Math");
		subjects.add("Math");
		subjects.add("Math");

		RestAPI.pot(details, subjects);
	}
	
	public static Response getDetails() throws ParserConfigurationException, SAXException, IOException
	{	
		return RestAPI.get(getData("API_URL") + getData("API_Resourse") + "/list");
	}
	
}
