package Utilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.sikuli.script.Screen;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.relevantcodes.extentreports.ExtentReports;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.windows.WindowsDriver;
import io.restassured.RestAssured;


public class CommonOps extends Base
{
	
	  public static String getData (String nodeName) throws ParserConfigurationException, SAXException, IOException
	  {
	  File fXmlFile = new File("./Configuration/DataConfig.xml");
	  DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	  DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	  Document doc = dBuilder.parse(fXmlFile); 
	  doc.getDocumentElement().normalize();
	  return doc.getElementsByTagName(nodeName).item(0).getTextContent();
	  }
	  
	  
	  public static void initBrowser(String browserType) throws ParserConfigurationException, SAXException, IOException
	  {
		  switch(browserType.toLowerCase())
		  {  
		  	case "chrome":
		  		driver = initChromeDriver();
		  		break;
		  	case "ie":
		  		driver = initIEDriver();
		  		break;
		  	case "firefox":
		  		driver = initFireFoxDriver();
		  		break;
		  }
		  
	      driver.manage().window().maximize(); 
	      driver.get(getData("URL"));
	      driver.manage().timeouts().implicitlyWait(10 , TimeUnit.SECONDS);
	      screen = new Screen();
	  }
	  
	  
	  
	  
	  
		  
	  public static WebDriver initChromeDriver() throws ParserConfigurationException, SAXException, IOException
	  {  
	     System.setProperty("webdriver.chrome.driver", getData("ChromeDriverPath"));
		 WebDriver  driver = new ChromeDriver();
	     return driver;   
	  }
		  
	  public static WebDriver initIEDriver() throws ParserConfigurationException, SAXException, IOException
	  {  
	  	 System.setProperty("webdriver.ie.driver", getData("IEDriverPath"));
	   	 WebDriver  driver = new ChromeDriver();
	   	 return driver;   
	  }
	  
	  public static WebDriver initFireFoxDriver() throws ParserConfigurationException, SAXException, IOException
	  {  
	  	 System.setProperty("webdriver.gecko.driver", getData("FireFoxDriverPath"));
	   	 WebDriver  driver = new ChromeDriver();
	   	 return driver;   
	  }
	  
	  
	  public static void initDesktopDriver() throws MalformedURLException
	  {	
			capabilities = new DesiredCapabilities();
			capabilities.setCapability("app", "Microsoft.WindowsCalculator_8wekyb3d8bbwe!App");
			driver = new WindowsDriver(new URL("http://127.0.0.1:4723"), capabilities);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  }
	  
	  public static void initMobile() throws ParserConfigurationException, SAXException, IOException
	  {
	        dc.setCapability(MobileCapabilityType.UDID, getData("UDID"));
	        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, getData("App_Package"));
	        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, getData("App_Acrivity"));
	        driver = new AndroidDriver<>(new URL(getData("Appium_Server_Address")), dc);

	        driver.manage().timeouts().implicitlyWait(10 , TimeUnit.SECONDS);
	  }
	  
	  public static void initAPI() throws ParserConfigurationException, SAXException, IOException
	  {
		  RestAssured.baseURI = getData("API_URL");
		  httpRequest = RestAssured.given();
		  
	  }
	  
	  public static void initElectronDriver(String ElectronAppPath) throws ParserConfigurationException, SAXException, IOException
	  {
		  System.setProperty("webdriver.chrome.driver" , getData("ChromeDriverPathElectron"));
		  ChromeOptions opt = new ChromeOptions();
	      opt.setBinary(ElectronAppPath);
	      DesiredCapabilities capabilities = new DesiredCapabilities();
	      capabilities.setCapability("chromeOptions", opt);
	      capabilities.setBrowserName("chrome");
	      driver = new ChromeDriver(capabilities);
	      driver.manage().timeouts().implicitlyWait(10 , TimeUnit.SECONDS);
	  }
	  	  
	  public static void instanceReport() throws ParserConfigurationException, SAXException, IOException
	  {
		  extent = new ExtentReports(getData("ReportFilePath")+ "Execution_" + timeStamp + "/" + getData("ReportFileName") + timeStamp + ".html");
	  }
	  
	  
	  public static void initReportTest(String testName , String testDescription)  
	  {
		  test = extent.startTest(testName , testDescription);
	  }
	  
	  public static void finalizeReportTest()  
	  {
		  extent.endTest(test);		  
	  }
	  
	  public static void finalizeExtentReportTest()  
	  {
		  extent.flush();
		  extent.close();
	  }
	  
	  public static String tekeScreenShot() throws IOException, ParserConfigurationException, SAXException
	  {
		  	String SSPath = getData("ReportFilePath") + "Execution_" + timeStamp + "/" + "Screenshot" + timeStamp + ".png";
	    	File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    	FileUtils.copyFile(scrFile, new File(SSPath));
	    	return SSPath;
	  }
	  
	  
	  	@BeforeSuite
	  	public static void startSuite() throws ParserConfigurationException, SAXException, IOException
	  	{
	        instanceReport();
	  	}
	  
	  	@AfterSuite
	  	public static void afterSuite()
	  	{
	    	finalizeExtentReportTest();
	  	}
	  
	    
	    @BeforeTest(groups = {"HardCoded" , "DataBased"})
	    @Parameters({"platform"})
	    public void beforeClass(String platform) throws ParserConfigurationException, SAXException, IOException 
	    {
	    	myPlatform = platform;
	    	
	    	if(myPlatform.equals("Web"))
	    	{
	    		initBrowser(getData("BrowserType"));
	    	}
	        else if(myPlatform.equals("Electron"))
	        {
	    	    initElectronDriver(getData("ElectronAppPath"));   	
	        }
	        else if(myPlatform.equals("Mobile"))
	        {
	    	    initMobile();   	
	        }
	        else if(myPlatform.equals("Desktop"))
	        {
	        	initDesktopDriver(); 
	        }
	        else if(myPlatform.equals("API"))
	        {
	    	    initAPI();   	
	        }

	    	
	    	
	    	
	    	
	    	
	    	
//	    	if(getData("AutomationType").equals("Web"))
//	    	{
//	    		initBrowser(getData("BrowserType"));
//	    	}
//	        else if(getData("AutomationType").equals("Mobile"))
//	        {
//	    	    initMobile();   	
//	        }
//	        else if(getData("AutomationType").equals("API"))
//	        {
//	    	    initAPI();   	
//	        }
//	        else if(getData("AutomationType").equals("Electron"))
//	        {
//	    	    initElectronDriver(getData("ElectronAppPath"));   	
//	        }
//	        else if(getData("AutomationType").equals("Desktop"))
//	        {
//	    	    initDesktopDriver();  	
//	        }

	    	    	
	        ManagePages.init();
	    }

	    



	    
	    
	    
	    @AfterTest (groups = {"HardCoded" , "DataBased"})
	    public void afterClass() throws ParserConfigurationException, SAXException, IOException 
	    {
	    	if(!myPlatform.equals("API"))
	    	{
	    		driver.quit();
	    	}
	    	if(!myPlatform.equals("Desktop"))
	    	{
	    		driver.quit();
				Runtime rt = Runtime.getRuntime();
	    	}	    	
	    }
	    	    
	    @BeforeMethod (groups = {"HardCoded" , "DataBased"})
	    public void dobeforetest(Method method) 
	    {
	    	initReportTest(method.getName(), method.getName().split("_")[1]);
	    }

	    @AfterMethod (groups = {"HardCoded" , "DataBased"})
	    public void doaftertest() 
	    {
	    	finalizeReportTest();
	    }	  
}
