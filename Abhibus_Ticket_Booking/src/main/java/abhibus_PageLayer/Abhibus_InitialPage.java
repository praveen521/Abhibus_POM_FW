package abhibus_PageLayer;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import abhibus_BaseClass.Abhibus_BaseClass;
import abhibus_utils.Abhibus_utils;

public class Abhibus_InitialPage extends Abhibus_BaseClass{
	public Abhibus_utils utils=new Abhibus_utils();
	
	//Declaring the page factories to the objects available in the page
	@FindBy(xpath="//a[@href=\"https://www.abhibus.com/\"]//img")
	WebElement Tooltip_Abhibus;
	
	@FindBy(id="source")
	WebElement Leaving_From;
	
	@FindBy(id="destination")
	WebElement Going_To;
	
	@FindBy(id="datepicker1")
	WebElement DateofJourney;
	
	@FindBy(id="datepicker2")
	WebElement DateofReturn;
	
	@FindBy(xpath="//a[@onclick=\"javascript:validateSearch();\"]")
	WebElement search;
	
	//Created Constructor to initialize the page factories
	public Abhibus_InitialPage() {
		PageFactory.initElements(driver, this);
	}
	
	// Validation of Tool tip 
	public void tooltip() {
		
		String Actual_tooltip=Tooltip_Abhibus.getAttribute("title");
		System.out.println("tool tip for abhibus logo is" + Actual_tooltip);
		String Expected_tooltip="abhibus.com - India's Fastest Online bus ticket booking site";
		Assert.assertEquals(Actual_tooltip, Expected_tooltip);
	
	}
	
	// Selecting the Source place from the property file
	
	public String Selction_Source() throws Throwable {	
		String Source=prop.getProperty("Leaving_From");
		Leaving_From.sendKeys(Source);
		Thread.sleep(3000);
		Leaving_From.sendKeys(Keys.RETURN);
		return Source;
	}
	
	//Selecting the Destination place from the property file
	public String Selection_Destination() throws Throwable {
		
		String destination=prop.getProperty("Going_to");
		Going_To.sendKeys(destination);
		Thread.sleep(3000);
		Going_To.sendKeys(Keys.RETURN);
		return new String();
		
	}
	
	//Selecting the onward and return dates
	public void DOJ_DOR_datepicker() {	
			DateofJourney.click();
			utils.datepicker1("20");
			utils.clickon(driver, DateofReturn, 20);
			DateofReturn.click();
			utils.datepicker1("24");
			}
	
	
	//Clicking on search button
	public void Search() {
		search.click();
	}
}
