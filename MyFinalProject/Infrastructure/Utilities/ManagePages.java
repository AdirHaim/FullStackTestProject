package Utilities;

import org.openqa.selenium.support.PageFactory;

import PageObject_DesktopCalculator.MainPageDesktopCalculator;
import PageObjects_Calculator.MainPageCalculator;
import PageObjects_Electron.MainPageElectronApp;
import PageObjects_IMDB.MainPage;
import PageObjects_IMDB.ResultsFirstPage;
import PageObjects_IMDB.ResultsLastPage;

public class ManagePages extends Base
{
	
	public static void init()
	{
		  
		 imdbMain = PageFactory.initElements(driver, MainPage.class);
		 imdbResultsFirstPage = PageFactory.initElements(driver, ResultsFirstPage.class);
		 imdbResultsLastPage = PageFactory.initElements(driver, ResultsLastPage.class);
		 
		 calculatorMain = PageFactory.initElements(driver, MainPageCalculator.class);
		 
		 electronMain = PageFactory.initElements(driver, MainPageElectronApp.class);
		 mainPageDesktopCalculator = PageFactory.initElements(driver, MainPageDesktopCalculator.class);
	}

}
