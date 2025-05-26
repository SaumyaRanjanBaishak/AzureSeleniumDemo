package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage extends BasePage {
	

	public RegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='d_name']")
	WebElement txtname;
	
	@FindBy(xpath="//input[@id='phone']")
	WebElement txtphone;
	
	@FindBy(xpath="//select[@id='d_catagory']")
	WebElement drpCategory;
	
	@FindBy(xpath="//select[@id='d_degree']")
	WebElement drpDegree;
	
	@FindBy(xpath="//select[@id='d_state']")
	WebElement drpState;
	
	@FindBy(xpath="//select[@id='d_district']")
	WebElement drpDist;
	
	@FindBy(xpath="//input[@id='city']")
	WebElement txtcity;
	
	@FindBy(xpath="//input[@type='checkbox']")
	WebElement chkBox;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement btnSubmit;
	
	@FindBy(xpath="//p[text()='Welcome to the Doctor login page. Please enter your mobile number and click on verify button to get otp.']")
	WebElement msgConfirmation;
	
	public void enterName(String fieldName) {
		txtname.sendKeys(fieldName);
	}
	
	public void enterPhone(String fieldPhone) {
		txtphone.sendKeys(fieldPhone);
	}
	
	public void category(String catValue) {
		Select catSelect=new Select(drpCategory);
		catSelect.selectByVisibleText(catValue);
	}
	
	public void degree(String degValue) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(drpDegree));
		Select degSelect=new Select(drpDegree);
		degSelect.selectByVisibleText(degValue);
	}
	
	public void state(String stateValue) {
		Select stateSelect=new Select(drpState);
		stateSelect.selectByVisibleText(stateValue);
	}
	
	public void district(String distValue) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(drpDist));
		Select degSelect=new Select(drpDist);
		degSelect.selectByVisibleText(distValue);
	}
	
	public void enterCity(String fieldCity) {
		txtcity.sendKeys(fieldCity);
	}
	
	public void checkBox() {
		chkBox.click();
	}
	
	public void submit() {
		btnSubmit.click();
	}
	
	public String getConfirmationMsg() {
		try {
			return (msgConfirmation.getText());
		}catch(Exception e) {
			return(e.getMessage());
		}
	}
	
}
