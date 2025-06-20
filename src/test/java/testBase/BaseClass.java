package testBase;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.text.RandomStringGenerator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	public WebDriver driver;
	//public WebDriverWait wait;
	public Logger logger;
	public Properties p;
	
	@BeforeClass
	@Parameters({"os","browser"})
	
	public void setUp(String os, String br) throws IOException {
		
		//Loading config.properties file
		FileReader file=new FileReader("./src//test//resources//config.properties");
		p=new Properties();
		p.load(file);
		
		logger=LogManager.getLogger(this.getClass());
		
		switch(br.toLowerCase()) {
		case "chrome" : driver=new ChromeDriver(); break;
		case "edge" : driver=new EdgeDriver(); break;
		case "firefox" : driver=new FirefoxDriver(); break;
		default : System.out.println("Invalid browser name.."); return;
		}
		
		//driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//driver.get(p.getProperty("appURL"));
		driver.get("https://ambreilla.com/");
		driver.manage().window().maximize();
		//wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
		
	}
	
	public String randomString() {
		RandomStringGenerator generator=new RandomStringGenerator.Builder().withinRange('a', 'z').build();
		//String generatedString=generator.generate(5);
		return generator.generate(5);
	}
	
	public String randomNumber() {
		RandomStringGenerator generator=new RandomStringGenerator.Builder().withinRange('0', '9').build();
		//String generatedString=generator.generate(5);
		return generator.generate(10);
	}
	

}
