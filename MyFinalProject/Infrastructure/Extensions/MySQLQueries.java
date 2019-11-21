package Extensions;

import com.relevantcodes.extentreports.LogStatus;

import Utilities.JDBC;

public class MySQLQueries extends JDBC
{
	
	public static String queries(String query)
	{
		String value = null;
		
		try 
		{
			initJDBC();
			retrieveInfo(query);
			value = parseData();
			closeSBCon();
			test.log(LogStatus.PASS, "query successesfully created");
		} 
		catch (Exception e) 
		{
			test.log(LogStatus.FAIL, "query to DB fail" + e);
		}
		
		return value;
	}

}
