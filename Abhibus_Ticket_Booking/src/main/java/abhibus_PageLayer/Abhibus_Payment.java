package abhibus_PageLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import abhibus_BaseClass.Abhibus_BaseClass;

public class Abhibus_Payment extends Abhibus_BaseClass{
	Abhibus_HomePage homepage=new Abhibus_HomePage();
	
	@FindBy(xpath="//p[@id='NetAmountmsg']")
	WebElement NetPayable;
	
	
	
	
	public Abhibus_Payment() {
		PageFactory.initElements(driver, this);
	}

	
	public void netpayable_Validation() {
		String Actual=NetPayable.getText();
		String Expected = homepage.Captur_Totalamount();
		SoftAssert assertion=new SoftAssert();
		try {
		assertion.assertEquals(Actual, Expected ,"Assertion failed because Expected contains the amount without GST");
		assertion.assertAll();
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
	}
}
