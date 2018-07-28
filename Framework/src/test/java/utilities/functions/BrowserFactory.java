package utilities.functions;

import java.io.IOException;
import java.net.URL;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BrowserFactory {

	public static WebDriver driver;

	public static WebDriver GetBrowser(String brname, String runmode) throws IOException {
		if (runmode.equalsIgnoreCase("local")) {
			if (brname.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "../Drivers/chromedriver.exe");
				BrowserFactory.driver = new ChromeDriver();
			} else if (brname.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", "../Drivers/geckodriver.exe");
				BrowserFactory.driver = new FirefoxDriver();
			}
		} else {
			if (brname.equalsIgnoreCase("chrome")) {
				ChromeOptions options = new ChromeOptions();
				options.setCapability(CapabilityType.BROWSER_NAME, brname);
				options.setCapability(CapabilityType.PLATFORM_NAME, Platform.WINDOWS);
				String hubURL = Utilities.readPropertiesFile("config", "huburl");
				options.setHeadless(false);				
				BrowserFactory.driver = new RemoteWebDriver(new URL(hubURL), options);
			} else if (brname.equalsIgnoreCase("firefox")) {
				System.out.println("Firefox Remote");
				FirefoxOptions options = new FirefoxOptions();
				options.setCapability(CapabilityType.BROWSER_NAME, brname);
				options.setCapability(CapabilityType.PLATFORM_NAME, Platform.WINDOWS);
				String hubURL = Utilities.readPropertiesFile("config", "huburl");
				options.setHeadless(false);
				BrowserFactory.driver = new RemoteWebDriver(new URL(hubURL), options);
			}
		}

		return BrowserFactory.driver;
	}

	public static void OpenApplicationUrl(String url) {
		BrowserFactory.driver.get(url);
	}

}


// We can use below cmd to make the browser as Headless
// options.addArguments("--headless");