package abhibus_Execution;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import abhibus_BaseClass.Abhibus_BaseClass;
import abhibus_PageLayer.Abhibus_HomePage;
import abhibus_PageLayer.Abhibus_InitialPage;
import abhibus_PageLayer.Abhibus_Payment;

public class Abhibus_ExecutionValidation extends Abhibus_BaseClass {

	public Abhibus_ExecutionValidation() {
		super();
	}
	
	@BeforeMethod
	
	public static void OpenBrowser() {
		
		initialise();
	}
	
	@Test
	
	public static void abhibus_Execution() throws Throwable {
		Abhibus_InitialPage abhibus_InitialPage = new Abhibus_InitialPage();
		abhibus_InitialPage.tooltip();
		abhibus_InitialPage.Selction_Source_Destination();
		abhibus_InitialPage.DOJ_DOR_datepicker();
		abhibus_InitialPage.Search();
		Thread.sleep(3000);
		Abhibus_HomePage abhibus_HomePage=new Abhibus_HomePage();
		abhibus_HomePage.Clicking_Operator_onward();
		abhibus_HomePage.selection_Travels();
		abhibus_HomePage.Select_Seat();
		abhibus_HomePage.Bed_selection();
		abhibus_HomePage.Captur_Totalamount();
		abhibus_HomePage.Boardingpoint(3);
		abhibus_HomePage.book_Return();
		abhibus_HomePage.Clicking_Operator_return();
		abhibus_HomePage.selection_Travels();
		abhibus_HomePage.Select_Seat();
		Thread.sleep(3000);
		abhibus_HomePage.Bed_selection();
		abhibus_HomePage.Captur_Totalamount();
		abhibus_HomePage.Boardingpoint2();
		abhibus_HomePage.Continue_payment();
		Abhibus_Payment payment = new Abhibus_Payment();
		payment.netpayable_Validation();
		
		
		
	}
}
