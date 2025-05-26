package testCases;

import org.apache.commons.text.RandomStringGenerator;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.RegistrationPage;
import testBase.BaseClass;

public class TC001_RegistrationTest extends BaseClass {
	
	
	@Test
	public void verify_registration() {
		
		logger.info("***Starting TC001_RegistrationTest***");
		
		try {
		HomePage hp=new HomePage(driver);
		
		hp.clickOnSignIn();
		hp.clickOnPartner();
		
		LoginPage lp=new LoginPage(driver);
		lp.clickOnRegister();
		logger.info("***Clicked on Register Link***");
		
		RegistrationPage rp=new RegistrationPage(driver);
		logger.info("Providing Customer details");
		rp.enterName(randomString().toUpperCase());
		rp.enterPhone(randomNumber());
		rp.category("Surgeon");
		//wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		rp.degree("M.D(General Medicine)");
		rp.state("Odisha");
		//wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		rp.district("Ganjam");
		rp.enterCity("Berhampur");
		rp.checkBox();
		rp.submit();
		String confmsg=rp.getConfirmationMsg();
		Assert.assertEquals(confmsg, "Welcome to the Doctor login page. Please enter your mobile number and click on verify button to get otp.");
		
		}
		catch(Exception e) {
			logger.error("Test Failed");
			logger.debug("Debug logs..");
			Assert.fail();
		}
		
		
	}
	
	

}
