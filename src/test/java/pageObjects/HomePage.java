package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="(//a[@class='search-btn'])[1]")
	WebElement mySignIn;
	
	@FindBy(xpath="(//a[@class='flex-column'])[2]")
	WebElement myPartner;
	
	//Action Method
	public void clickOnSignIn() {
		mySignIn.click();
	}
	
	public void clickOnPartner() {
		myPartner.click();
	}
	
	
}
