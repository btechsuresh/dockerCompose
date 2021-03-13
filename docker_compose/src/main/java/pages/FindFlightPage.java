package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FindFlightPage {
	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(how=How.XPATH,using="//input[@id='reserveFlights']")
	private WebElement firstSubmit;
	@FindBy(name="buyFlights")
	private WebElement secondSubmitBtn;
	
	public FindFlightPage(WebDriver driver) {
		this.driver=driver;
		this.wait=new WebDriverWait(driver, 30);
		PageFactory.initElements(driver, this);
		
	}
	
	public void submitFindFlightPage (){
		
		this.wait.until(ExpectedConditions.elementToBeClickable(this.firstSubmit));
		this.firstSubmit.click();				
	}
	
	public void goToFlightConfirmationPage(){
		this.wait.until(ExpectedConditions.elementToBeClickable(secondSubmitBtn));
		this.secondSubmitBtn.click();
	}
	
	

}
