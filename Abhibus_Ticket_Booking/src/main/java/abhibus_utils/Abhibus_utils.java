package abhibus_utils;
	import java.util.List;

	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.StaleElementReferenceException;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.Select;
	import org.openqa.selenium.support.ui.WebDriverWait;

//import abhibus.BaseClass.BaseClass;
import abhibus_BaseClass.Abhibus_BaseClass;

	public class Abhibus_utils extends Abhibus_BaseClass{
		
		//Created re-usable method to datepicker
		public void datepicker1(String text) {
			List<WebElement> Dayvals=driver.findElements(By.xpath("//div[@class=\"ui-datepicker-group ui-datepicker-group-first\"]//table//tbody//tr//td"));
			int dayval=Dayvals.size();
			System.out.println(dayval);
			for(int i=1; i<dayval;i++) {
				String date=Dayvals.get(i).getText();
				if(date.equalsIgnoreCase(text)) {
					Dayvals.get(i).click();
					break;
				}
			}
		}
		
		
		
		//Explicit wait method 
		public void clickon(WebDriver driver,WebElement locator, int timeout) {
			new WebDriverWait(driver,timeout).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(locator));
			
		}
		
		//scroll down method to the certain webelement  
		public void scrollview(WebElement element) {
					JavascriptExecutor js=(JavascriptExecutor)driver;
						js.executeScript("arguments[0].scrollIntoView(true);", element);
			}
		
		//Selecting the value from dropdown
			public void dropdown(WebElement locator,int i) {
					Select S=new Select(locator);
					S.selectByIndex(i);		
			}
			
			//handling the hidden elements
			public void hidden_elements(int size,List<WebElement> element) {
				for(int i=0;i<size; i++) {
					int x=element.get(i).getLocation().getX();
					if(x!=0) {

						element.get(i).click();
						break;
			}
			}
			
			
	}
			
	}
