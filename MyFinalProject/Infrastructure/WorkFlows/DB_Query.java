package WorkFlows;

import Extensions.MySQLQueries;
import Utilities.CommonOps;

public class DB_Query extends CommonOps
{
	
	public static String getMassage()
	{
		return MySQLQueries.queries("SELECT name FROM projecttest.category WHERE category_id = '1'");
	}

}
