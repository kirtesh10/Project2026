import org.testng.annotations.Test;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import BasePackage.Base;
import PageObject.LoginPage;

public class Login extends Base {
	public WebDriver driver;

	public static Logger log = LogManager.getLogger(Login.class.getName());

	@BeforeTest
	public void setupLogger() {
		log.info("Logger initialized successfully.");
	}

	@Test
	public void basePageNavigation() throws IOException, InterruptedException, AWTException {
		log.info("=========Test Case: Login Page Navigation Started=========");

		driver = initializerDriver();
		driver.get(prop.getProperty("url"));
		LoginPage lp = new LoginPage(driver);

		Thread.sleep(2000);
		lp.enterusername();
		Thread.sleep(2000);
		lp.enterpassword();
		Thread.sleep(2000);
		lp.clicklogin();
		Thread.sleep(2000);
		driver.manage().window().maximize();
		log.info("Login Successful");
		log.info("=========Test Case: Login Page Navigation Completed=========");
	}

	@AfterTest
	public void teardown() {
		log.info("Closing the browser");
		driver.close();
		log.info("Browser closed");
	}

}