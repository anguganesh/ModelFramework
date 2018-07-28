package utilities.functions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.utils.FileUtil;

public class Utilities {

	public static String readPropertiesFile(String filename, String key) throws IOException
	{
		FileInputStream fis = new FileInputStream("./properties/" + filename + ".properties");
		Properties p = new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;		
	}
	
	public static String screenshot(String filename) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) BrowserFactory.driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/FailedTCScreenshots/" + filename + ".png"; 
		File dest = new File(destination);
		FileUtils.copyFile(source, dest);
		return destination;
	}
	
}
