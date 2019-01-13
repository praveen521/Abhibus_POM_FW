package abhibus_PageLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import abhibus_BaseClass.Abhibus_BaseClass;

public class Abhibus_Payment extends Abhibus_BaseClass{
	
	//Creating objects for homepage,initialpage and payment page
	Abhibus_HomePage homepage=new Abhibus_HomePage();
	Abhibus_InitialPage initialpage=new Abhibus_InitialPage();
	
	//Created Constructor to initialize the page factories
	@FindBy(xpath="//p[@id='NetAmountmsg']")
	WebElement NetPayable;
	
	@FindBy(xpath="//div[@class='op-info']//h3//strong[text() =' Hyderabad To  Vijayawada']")
	WebElement onward_Journeydetails;
	
	@FindBy(xpath="//div[@class='op-info']//h3//strong[text() =' Vijayawada To Hyderabad']")
	WebElement return_Journeydetails;
	
	@FindBy(xpath="//p[text()='GST']//parent::div//p[2]")
	static
	WebElement GST;
	
	@FindBy(xpath="//p[text()='Service Charge ']//parent::div//p[2]")
	static
	WebElement ServiceCharge;
	
	////Created Constructor to initialize the page factories
	public Abhibus_Payment() {
		PageFactory.initElements(driver, this);
		
	}
	
	//Validation of onward journey details
	public void onward_Journey() throws Throwable {
		String Expected = prop.getProperty("Leaving_From")+"To"+prop.getProperty("Going_to");
		String onward=onward_Journeydetails.getText();
		String actual=onward.replaceAll("\\s+", "");
		SoftAssert assertion=new SoftAssert();
			assertion.assertEquals(actual, Expected ,"Assertion failed for onwardjourney");
			System.out.println("Assertion for onward jouney is passed and the details are ---->" +actual);
			assertion.assertAll();
			}
	
//Validation of return journey details
	public void return_Journey() throws Throwable {
		String Expected = prop.getProperty("Going_to")+"To"+prop.getProperty("Leaving_From");
		String returnj=return_Journeydetails.getText();
		String actual=returnj.replaceAll("\\s+", "");
		SoftAssert assertion=new SoftAssert();
		assertion.assertEquals(actual, Expected ,"Assertion failed for return journey");
		System.out.println("Assertion for return jouney is passed and the details are ---->" +actual);
		assertion.assertAll();
	}
	
	//caturing the GST and Service Charge
		public static double capture_GST_ServiceCharge() {
			String oldest=GST.getText();
			//String gst1=oldest.replaceAll("//₹s?", "");
			double gst=Double.parseDouble(oldest);
			System.out.println("GST amount is " +gst);
			
			String service_charges= ServiceCharge.getText();
			String service_charge1=service_charges.replaceAll("[^A-Za-z0-9&&[^.]]","");
			//System.out.println(service_charge1);
			double service_charge=Double.parseDouble(service_charge1);
			System.out.println("Service Charge amount is "  +service_charge);
			
			double total_tax= gst+service_charge;
			System.out.println("total tax is" +total_tax);
			
			return total_tax;
			
		}
		
	//Validation of net payable amount
	public void netpayable_Validation() {
		String Actual1=NetPayable.getText();
		String Actual=Actual1.replaceAll("[^A-Za-z0-9&&[^.]]", "");
		double Actual_Amount=Double.parseDouble(Actual);
		System.out.println(Actual_Amount);
		//double Expected_Amount = homepage.amount(); 
		//System.err.println(Expected_Amount);
		double Expected_Amount=2915.64;
		SoftAssert assertion=new SoftAssert();
		try {
		assertion.assertEquals(Actual_Amount, Expected_Amount ,"Assertion failed for total amount");
		assertion.assertAll();
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
	}
}
