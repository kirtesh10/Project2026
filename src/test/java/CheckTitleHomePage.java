import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import BasePackage.Base;
import PageObject.HomePageTitle;
import PageObject.LoginPage;

public class CheckTitleHomePage extends Base {
	public WebDriver driver;

	public static Logger log = LogManager.getLogger(Base.class.getName());

	// To check Home Page Title and Products Title after login

	@Test
	public void VerifyHomePageTitle() throws IOException, InterruptedException {
		log.info("=========Test Case: Home Page Title Verification Started=========");

		driver = initializerDriver();
		driver.get(prop.getProperty("url"));
		HomePageTitle hpt = new HomePageTitle(driver);
		LoginPage lp = new LoginPage(driver);

		Thread.sleep(2000);
		lp.enterusername();
		Thread.sleep(2000);
		lp.enterpassword();
		Thread.sleep(2000);
		lp.clicklogin();
		Thread.sleep(2000);
		driver.manage().window().maximize();

		AssertJUnit.assertEquals(hpt.getHomeTitle(), "Swag Labs");
		System.out.println("Title Verified Successfully i have 'Swag Labs' and i get=" + hpt.getHomeTitle());
		AssertJUnit.assertEquals(hpt.getProductsTitle(), "Products");
		System.out.println("Title Not Verified Successfully i have 'Products' and i get=" + hpt.getProductsTitle());
		driver.close();
		log.info("=========Test Case: Home Page Title Verification Completed=========");

	}

}
