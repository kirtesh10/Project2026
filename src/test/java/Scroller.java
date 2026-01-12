import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import BasePackage.Base;
import PageObject.LoginPage;

public class Scroller extends Base {
	@Test
	public void Scroller() throws IOException, InterruptedException, AWTException {
		System.out.println("i am come from local branch");
		driver = initializerDriver();
		driver.get(prop.getProperty("url"));
		LoginPage lp = new LoginPage(driver);
	System.out.println("i am come from local branch");
	Thread.sleep(2000);
	lp.enterusername();
	Thread.sleep(2000);
	lp.enterpassword();
	Thread.sleep(2000);
	lp.clicklogin();
	Thread.sleep(2000);
	driver.manage().window().maximize();
	Thread.sleep(2000);
	System.out.println("Login Successful");
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,500)");
	Thread.sleep(2000);
	js.executeScript("window.scrollBy(00,-500)");
	Thread.sleep(2000);
	}

}
