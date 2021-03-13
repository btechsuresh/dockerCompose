package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationConfirmationPage {
	
	private WebDriver driver;
	public WebDriverWait wait;
	
	@FindBy(how=How.PARTIAL_LINK_TEXT,using="sign-in")
	private WebElement signinLink;
	
	@FindBy(how=How.LINK_TEXT,using="Flights")
	private WebElement flightsLink;
	
	public RegistrationConfirmationPage(WebDriver driver) {
		this.driver=driver;
		this.wait=new WebDriverWait(driver, 30);
		PageFactory.initElements(driver, this);	
		
	}
	
	public void goToFlightDetailsPage(){
		this.wait.until(ExpectedConditions.visibilityOf(this.signinLink));
		this.flightsLink.click();		
	}
	

}
