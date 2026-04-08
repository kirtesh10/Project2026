import java.io.IOException;
import java.util.logging.LogManager;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import java.awt.AWTException;
import BasePackage.Base;
import PageObject.LoginPage;

public class buyproduct extends Base {

    public WebDriver driver;

    @Test
    public void basePageNavigation() throws IOException, InterruptedException, AWTException {

        driver = initializerDriver();
        driver.get(prop.getProperty("url"));
        LoginPage lp = new LoginPage(driver);

    }
}
