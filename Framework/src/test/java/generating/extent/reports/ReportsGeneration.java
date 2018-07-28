package generating.extent.reports;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import utilities.functions.Utilities;

public class ReportsGeneration implements ITestListener {

	private ExtentHtmlReporter htmlReporter;
	private ExtentReports extent;
	private ExtentTest test;
	
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("On Start Method");
		this.htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/extent-report/ExtentReport.html");
		this.extent = new ExtentReports();		
		this.extent.setSystemInfo("Host Name", "Localhost");
		this.extent.setSystemInfo("Environment", "QA");
		this.extent.setSystemInfo("Username", "Angu Ganesh M");
		this.extent.attachReporter(htmlReporter);		
	}
	
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println(result.getName() + " Execution is started");
		this.test = this.extent.createTest(result.getName());		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println(result.getName() + " is success");
		this.test.pass(MarkupHelper.createLabel(result.getName() + " is Passed", ExtentColor.GREEN));		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String screenshotpath;
		System.out.println(result.getName() + " is Failed");
		this.test.fail(MarkupHelper.createLabel(result.getName() + " is Failed", ExtentColor.RED));
		this.test.fail(result.getThrowable());
		try {
			screenshotpath = Utilities.screenshot(result.getName());
			this.test.addScreenCaptureFromPath(screenshotpath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println(result.getName() + " is Skipped");
		this.test.skip(MarkupHelper.createLabel(result.getName() + " is Skipped", ExtentColor.YELLOW));
		this.test.skip(result.getThrowable());		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("On TestFailedButWithinSuccessPercentage Method");
	}
	

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub		
		this.extent.flush();
		System.out.println("All Test Cases are Executed");
		System.out.println("-----------------------------");
	}

}
