package Utilities;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.sikuli.script.Screen;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import PageObject_DesktopCalculator.MainPageDesktopCalculator;
import PageObjects_Calculator.MainPageCalculator;
import PageObjects_Electron.MainPageElectronApp;
import PageObjects_IMDB.MainPage;
import PageObjects_IMDB.ResultsFirstPage;
import PageObjects_IMDB.ResultsLastPage;
import io.appium.java_client.windows.WindowsDriver;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Base 
{
	
	public static WebDriver driver;
	public static Screen screen;
	public static DesiredCapabilities dc = new DesiredCapabilities();
	
	
	public static WebElement CalculatorResult;
	public static DesiredCapabilities capabilities;
	
	
	public static MainPage imdbMain;
	public static ResultsFirstPage imdbResultsFirstPage;
	public static ResultsLastPage imdbResultsLastPage;
	
	public static MainPageCalculator calculatorMain;
	public static MainPageElectronApp electronMain;
	public static MainPageDesktopCalculator mainPageDesktopCalculator;

	
	public static RequestSpecification httpRequest;
	public static JSONObject requestParams = new JSONObject();
	public static Response resp;
	
	
	public static ExtentReports extent;
	public static ExtentTest test;
	
	public static String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(Calendar.getInstance().getTime());
	public static String myPlatform;
}
