package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//button[text()='Register']")
	WebElement moveToRegister;
	
	public void clickOnRegister() {
		moveToRegister.click();
	}
}
