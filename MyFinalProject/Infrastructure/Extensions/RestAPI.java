package Extensions;

import static org.testng.Assert.fail;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.gargoylesoftware.htmlunit.javascript.host.fetch.Request;
import com.relevantcodes.extentreports.LogStatus;

import Utilities.CommonOps;
import io.restassured.response.Response;


public class RestAPI extends CommonOps
{
	
	@SuppressWarnings("unchecked")
	public static void pot(String [] params , List<String> courseList) throws ParserConfigurationException, SAXException, IOException
	{
		
		try
		{
		requestParams.put("firstName" , params[0]);
		requestParams.put("lastName" , params[1]);
		requestParams.put("email" , params[2]);
		requestParams.put("programme" , params[3]);
		requestParams.put("courses" , courseList);
		
		httpRequest.header("Content-Type" , "application/json");
		httpRequest.body(requestParams.toJSONString());	
		httpRequest.post(getData("API_Resourse"));
		
		test.log(LogStatus.PASS, "Post Succeeded");
		}
		catch (Exception e) 
		{
			test.log(LogStatus.FAIL, "Post has Failed , see details: " + e);
			fail("Post has Failed , see details: " + e);
		}	
	}
	
	public static Response get(String URL)
	{
		resp = httpRequest.get(URL);
		return resp;
	}
	

}
