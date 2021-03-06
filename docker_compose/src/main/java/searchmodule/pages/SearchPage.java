package searchmodule.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(name="q")
	private WebElement searchTxt;
	
	@FindBy(id="search_button_homepage")
	private WebElement searchBtn;
	@FindBy(linkText="Videos")
	private WebElement videosLink;
	
	@FindBy(how=How.CLASS_NAME,using="tile--vid")
	private List<WebElement> allVideos;
	
	public SearchPage(WebDriver driver) {
		this.driver=driver;
		this.wait=new WebDriverWait(driver, 30);
		PageFactory.initElements(driver, this);		
	}
	
	public void goTo(){
		WebDriverManager.chromedriver().setup();
		this.driver.get("https://duckduckgo.com/");
	}

	public void doSearch(String keyword){
		this.wait.until(ExpectedConditions.visibilityOf(this.searchTxt));
		this.searchTxt.sendKeys(keyword);
		this.searchBtn.click();
		
	}
	
	public void goToVideos(){
		this.wait.until(ExpectedConditions.visibilityOf(this.videosLink));
		this.videosLink.click();
	}
	
	public int getResult(){
		By by=By.className("tile--vid");
		this.wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(by, 0));
		System.out.println("Result "+allVideos.size());
		return this.allVideos.size();
	}
	
	
}
