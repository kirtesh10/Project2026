import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import java.io.IOException;

import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import BasePackage.Base;

public class HomePage extends Base {
	public WebDriver driver;

	public static Logger log = LogManager.getLogger(HomePage.class.getName());

	@Test
	public void basePageNavigation() throws IOException {
		log.info("=========Test Case: Home Page Navigation Started=========");
		driver = initializerDriver();
		driver.get(prop.getProperty("url"));
		log.info("=========Test Case: Home Page Navigation Completed=========");
	}

	@AfterTest
	public void teardown() {
	
		driver.close();
		
	}

}
