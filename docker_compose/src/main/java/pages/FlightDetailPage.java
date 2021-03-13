package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightDetailPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(name="passCount")
	private WebElement passengers;
	
	@FindBy(how=How.NAME,using="findFlights")
	private WebElement submitBtn;
	
	public FlightDetailPage(WebDriver driver) {
		this.driver=driver;
		this.wait=new WebDriverWait(driver, 30);
		PageFactory.initElements(driver, this);
	}
	
	public void selectPassengers(String noOfPassengers){
	this.wait.until(ExpectedConditions.elementToBeClickable(passengers));
	Select select=new Select(passengers);
	select.selectByValue(noOfPassengers);
		
	}
	
	public void goToFindFlightsPage(){
		this.submitBtn.click();
	}
	

}
