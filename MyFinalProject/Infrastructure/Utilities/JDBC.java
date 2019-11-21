package Utilities;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;



public class JDBC extends CommonOps
{
	
	public static Connection con;
	public static Statement stmt;
	public static ResultSet rs;
	
	public static void initJDBC() throws ClassNotFoundException, SQLException, ParserConfigurationException, SAXException, IOException
	{
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(getData("DB_URL"),getData("DB_User"),getData("DB_Pass"));
		stmt = con.createStatement();
	}
	
	public static String parseData() throws SQLException 
	{
		String value = null;
		while(rs.next())
		{
			value = rs.getString("name");
		}
		return value;
	}
	
	public static void retrieveInfo(String query) throws SQLException 
	{
		rs = stmt.executeQuery(query);
	}

	public static void closeSBCon() throws SQLException
	{
		con.close();
	}
}

