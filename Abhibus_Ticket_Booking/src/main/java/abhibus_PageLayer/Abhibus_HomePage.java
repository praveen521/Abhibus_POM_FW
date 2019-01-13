package abhibus_PageLayer;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import abhibus_BaseClass.Abhibus_BaseClass;
import abhibus_utils.Abhibus_utils;

public class Abhibus_HomePage extends Abhibus_BaseClass{
	//Creation of object for utils class
	public Abhibus_utils utils=new Abhibus_utils();
	
	//Declaring the page factories to the objects available in the page
	
	@FindBy(xpath="//div[@class='f-bus-type']//following-sibling::div[@class=\"f-operator-type f-operator-type-onward\"]//div//span[@class='f-left']")
	WebElement operator_filter_onward;
	
	@FindBy(xpath="//div[@class='f-bus-type']//following-sibling::div[@class=\"f-operator-type f-operator-type-return\"]//div//span[@class='f-left']")
	WebElement operator_filter_return;
	
	@FindBy(xpath="//div[@class='col2']//a//span[contains(text(),'Select Seat')]")
	WebElement select_seat;
	
	@FindBy(xpath="//div[@class='seats']/ul/li//a[contains(@class,'tooltip tooltipstered')]")
	WebElement Bed_Selection;
	
	@FindBy(xpath="//span[@id='totalfare']")
	WebElement total_amount;
	
	@FindBy(xpath="//input[@id='btnEnable1']")
	WebElement Bookreturn;
	
	@FindBy(xpath="//select[@class='dropdown_custom']")
	WebElement Boarding_point_onward;
	
	@FindBy(xpath="//select[@id='boardingpoint_id2']")
	WebElement Boarding_point_return;
	
	@FindBy(xpath="//input[@id='btnEnable1']")
	WebElement c_payment;
	
	@FindBy(xpath="//h3[text()='Return    Journey ']//parent::form//following-sibling::div[5]//p[2]")
	WebElement return_total;
	
	@FindBy(xpath="//h3[text()='  Journey ']//parent::form//following-sibling::div[5]//p[2]")
	WebElement onward_total;
	
	//Created Constructor to initialize the page factories
	public Abhibus_HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	//Clicking on "Operator filter" button for onward journey
	public void Clicking_Operator_onward() throws Throwable{
		Actions ac=new Actions(driver);
		boolean flag = operator_filter_onward.isDisplayed();
		//System.out.println(flag);
		ac.moveToElement(operator_filter_onward).click().build().perform();	
	}
	
	//Clicking on "Operator filter" button for return journey
	public void Clicking_Operator_return() throws Throwable {
		Actions ac=new Actions(driver);
		boolean flag = operator_filter_return.isDisplayed();
		//System.out.println(flag);
		ac.moveToElement(operator_filter_return).click().build().perform();
		
	}
	
	//Filtering the travels 
	public void selection_Travels() {
		List<WebElement> names=driver.findElements(By.xpath("//div[contains(@class,'f-operator-type f-operator-type')]//div[3]//form//ul//li"));
		System.out.println(names.size());
		for(int i=0;i<names.size();i++) {
			String values=names.get(i).getText();
			//System.out.println(values);
			if(values.equalsIgnoreCase("Orange Tours & Travels")) {
				names.get(i).click();
				System.out.println("selected travels is " +names.get(i).getText());
				break;
			}
		}
	}
	
	public void Select_Seat() {
		List<WebElement> ele=driver.findElements(By.xpath("//div[@class='col2']//a//span[contains(text(),'Select Seat')]"));
		int values=ele.size();
		utils.hidden_elements(values, ele);
	}
	
	
	//Selection of available bed from travels
	public void Bed_selection() {
		Actions ac=new Actions(driver);
		ac.moveToElement(Bed_Selection).build().perform();
		List<WebElement> ele=driver.findElements(By.xpath("//div[@class='seats']/ul/li//a[contains(@class,'tooltip tooltipstered')]"));
		int values=ele.size();
		utils.hidden_elements(values, ele);
	}
	
	//Capturing the total payable amount for both onward and return
	public double Capture_Totalamount_Onward() {
		double totalamount_onward;
		WebElement Onward_fare = onward_total;
		String total_amount=Onward_fare.getText();
		String total_amount1=total_amount.replaceAll("[^A-Za-z0-9&&[^.]]", "");
		totalamount_onward=Double.parseDouble(total_amount1);
		System.out.println("Total amount onward is" +totalamount_onward);
		return totalamount_onward;
	
	}
	
	public double amount () {
		
		double t =Capture_Totalamount_Onward()+Capture_Totalamount_return();
		System.out.println("Total actual amount is" +t);
		return t;
	}
	
	//
	public double Capture_Totalamount_return() {
		double totalamount_return;
		WebElement return_fare = return_total;
		String total_amount=return_fare.getText();
		String total_amount1=total_amount.replaceAll("[^A-Za-z0-9&&[^.]]", "");
		totalamount_return=Double.parseDouble(total_amount1);
		System.out.println("Total return amount is" +totalamount_return);
		return totalamount_return;
	
	}
	
	
	//Selecting the boarding point for onward journey
	public void Boardingpoint_Onward(int text) {
		Actions ac= new Actions(driver);
		ac.moveToElement(Boarding_point_onward).build().perform();
		Select s= new Select(Boarding_point_onward);
		s.selectByIndex(text);
		WebElement text2=driver.findElement(By.xpath("//div[@class='red-landmark']"));
		String t1=text2.getText();
		System.out.println(t1);
			}
	
	//Selecting the boarding point for return journey
	public void Boardingpoint_Return() {
		utils.scrollview(Boarding_point_return);
		Select s= new Select(Boarding_point_return);
		List<WebElement> drop = s.getOptions();
		int size = drop.size();
		System.out.println("bp2 is"  + size);
		s.selectByVisibleText("NTR Circle-04:00");
		WebElement text2=driver.findElement(By.xpath("//div[@class='red-landmark']"));
		String t2=text2.getText();
		System.out.println(t2);
		
	}
	
	//Clicking on "Book return" button
	public void book_Return() {
		Bookreturn.click();
	}
	
	//Clicking on "continue payment"
	public void Continue_payment() {
		List<WebElement> ele = driver.findElements(By.xpath("//input[@id='btnEnable1']"));
		int values=ele.size();
		utils.hidden_elements(values, ele);
				
	}
}
