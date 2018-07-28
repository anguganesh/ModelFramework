package test.scripts;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utilities.functions.BrowserFactory;
import utilities.functions.Utilities;

public class TestScript1 {
	
	public WebDriver driver;
	public String url;

	@Test
	public void function()
	{
		String title = this.driver.getTitle();
		System.out.println("Title is " + title);
		String url = this.driver.getCurrentUrl();
		System.out.println("URL is " + url);
	}
	
	@Test
	public void function2()
	{
		Assert.assertEquals(true, false);		
	}
	
	
	@BeforeClass
	@Parameters({"browser","runmode"})
	public void LaunchBrowser(@Optional ("chrome") String brname, @Optional("local") String runmode) throws IOException
	{
		this.driver = BrowserFactory.GetBrowser(brname, runmode);
		this.url = Utilities.readPropertiesFile("config", "url");
		BrowserFactory.OpenApplicationUrl(this.url);
	}

}
