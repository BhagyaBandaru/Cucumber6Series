package Apphooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.Utilities.ConfigReader;
import com.qa.factory.DriverFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApllicationHooks {
	/**
	 * Here we are writing hooks for pre conditions
	 * Execution below in hooks:
	 * 
	 * -->before(order=0)
	 * -->before(order=1)
	 * -->After(order=1)
	 * -->After(order=0)
	 * 
	 */
	
	//we are using private beacause driverfactory and driver theses two specific to the Application hooks nly
	private DriverFactory driverFactory;//driverFatory is responsible for initialization thats y v r ctreated reference of driverfactory
	private WebDriver driver;
	private ConfigReader configReader;//we are creating reference of configreader to use properties
	Properties prop;
	

	@Before(order = 0)
	public void getProperty() {
		configReader = new ConfigReader();
		prop = configReader.init_prop();
	}

	@Before(order = 1)
	public void launchBrowser() {
		String browserName = prop.getProperty("browser");
		driverFactory = new DriverFactory();
		driver = driverFactory.init_driver(browserName);
		
	}

	@After(order = 0)
	public void quitBrowser() {
		//driver.quit();
	}

	@After(order = 1)
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			// take screenshot:
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenshotName);

		}
	}

	

}
