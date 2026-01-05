package BasePackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Base {
	public WebDriver driver;
	public Properties prop;
	public WebDriver initializerDriver() throws IOException {
		
		//to disable save password pop up
		ChromeOptions options = new ChromeOptions();	
		Map<String, Object> prefs = new HashMap<>();
		prefs.put("profile.password_manager_leak_detection", false);
		prefs.put("profile.credentials_enable_service", false);
		options.setExperimentalOption("prefs", prefs); 
		//to disable save password pop up

		prop=new Properties();  
		FileInputStream fis=new FileInputStream("C:\\Users\\ujjwa\\Project2026\\src\\main\\java\\Resources\\Data.properties");
		prop.load(fis);
		String browserName=prop.getProperty("browser");
		String urlName=prop.getProperty("url");
		
		if(browserName.equals("chrome")) {
			//code to launch chrome
			System.setProperty("webdriver.chrome.driver", "C://Users//ujjwa//Project2026//chromedriver-win64//chromedriver.exe");
			 driver = new ChromeDriver(options);
			 
		}
		else if(browserName.equals("firefox")) {
			//code to launch firefox
		}
		else if(browserName.equals("IE")) {
			//code to launch IE
		}
	  	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}

}
