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
	public Abhibus_utils utils=new Abhibus_utils();
	
	@FindBy(xpath="//div[@class='f-bus-type']//following-sibling::div[@class=\"f-operator-type f-operator-type-onward\"]//div//span[@class='f-left']")
	WebElement operator_filter_onward;
	
	@FindBy(xpath="//div[@class='f-bus-type']//following-sibling::div[@class=\"f-operator-type f-operator-type-return\"]//div//span[@class='f-left']")
	WebElement operator_filter_return;
	
	@FindBy(xpath="//div[@class='col2']//a//span[contains(text(),'Select Seat')]")
	WebElement select_seat;
	
	//@FindBy(xpath="//p[@class='lower-new']//following-sibling::ul//li[1]//a")
	@FindBy(xpath="//div[@class='seats']/ul/li//a[contains(@class,'tooltip tooltipstered')]")
	WebElement Bed_Selection;
	
	@FindBy(xpath="//span[@id='totalfare']")
	WebElement total_amount;
	
	@FindBy(xpath="//input[@id='btnEnable1']")
	WebElement Bookreturn;
	
	@FindBy(xpath="//select[@class='dropdown_custom']")
	WebElement Boarding_point;
	
	@FindBy(xpath="//select[@id='boardingpoint_id2']")
	WebElement Boarding_point2;
	
	@FindBy(xpath="//input[@id='btnEnable1']")
	WebElement c_payment;
	
	public Abhibus_HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void Clicking_Operator_onward() throws Throwable{
		Actions ac=new Actions(driver);
		boolean flag = operator_filter_onward.isDisplayed();
		System.out.println(flag);
		ac.moveToElement(operator_filter_onward).click().build().perform();	
	}
	
	
	public void Clicking_Operator_return() throws Throwable {
		Actions ac=new Actions(driver);
		boolean flag = operator_filter_return.isDisplayed();
		System.out.println(flag);
		ac.moveToElement(operator_filter_return).click().build().perform();
		
	}
	//div[@class='f-operator-type f-operator-type-onward']//div[3]//form//ul//li
	public void selection_Travels() {
		List<WebElement> names=driver.findElements(By.xpath("//div[contains(@class,'f-operator-type f-operator-type')]//div[3]//form//ul//li"));
		System.out.println(names.size());
		for(int i=0;i<names.size();i++) {
			String values=names.get(i).getText();
			System.out.println(values);
			if(values.equalsIgnoreCase("Orange Tours & Travels")) {
				names.get(i).click();
				break;
			}
		}
	}
	
	public void Select_Seat() {
		List<WebElement> ele=driver.findElements(By.xpath("//div[@class='col2']//a//span[contains(text(),'Select Seat')]"));
		int values=ele.size();
		utils.hidden_elements(values, ele);
		/*for(int i=0;i<values; i++) {
			int x=ele.get(i).getLocation().getX();
			if(x!=0) {
				ele.get(i).click();
				break;
			}
		}*/
	}
	
	public void Bed_selection() {
		
		Actions ac=new Actions(driver);
		ac.moveToElement(Bed_Selection).build().perform();
		List<WebElement> ele=driver.findElements(By.xpath("//div[@class='seats']/ul/li//a[contains(@class,'tooltip tooltipstered')]"));
		int values=ele.size();
		utils.hidden_elements(values, ele);
	}
	
	public String Captur_Totalamount() {
		List<WebElement> ele = driver.findElements(By.xpath("//span[@id='totalfare']"));
		int values=ele.size();
		for(int i=0;i<values; i++) {
			int x=ele.get(i).getLocation().getX();
			if(x!=0) {
				String total_amount=ele.get(i).getText();
				System.out.println("Total amount is" +total_amount);
				break;
	}
		}
		
		return new String();
	
	}
	
	public void Boardingpoint(int text) {
		Actions ac= new Actions(driver);
		ac.moveToElement(Boarding_point).build().perform();
		Select s= new Select(Boarding_point);
		s.selectByIndex(text);
		WebElement text2=driver.findElement(By.xpath("//div[@class='red-landmark']"));
		String t1=text2.getText();
		System.out.println(t1);
			}
	
	public void Boardingpoint2() {
		utils.scrollview(Boarding_point2);
		Select s= new Select(Boarding_point2);
		List<WebElement> drop = s.getOptions();
		int size = drop.size();
		System.out.println("bp2 is"  + size);
		s.selectByVisibleText("NTR Circle-04:00");
		WebElement text2=driver.findElement(By.xpath("//div[@class='red-landmark']"));
		String t2=text2.getText();
		System.out.println(t2);
		
	}
	
	public void book_Return() {
		Bookreturn.click();
	}
	
	public void Continue_payment() {
		List<WebElement> ele = driver.findElements(By.xpath("//input[@id='btnEnable1']"));
		int values=ele.size();
		utils.hidden_elements(values, ele);
				
	}
}
