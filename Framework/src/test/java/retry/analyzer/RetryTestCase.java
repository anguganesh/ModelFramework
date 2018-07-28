package retry.analyzer;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryTestCase implements IRetryAnalyzer {

	int min_retry;
	int max_retry;

	public RetryTestCase() {
		this.min_retry = 0;
		this.max_retry = 3;
	}

	public boolean retry(ITestResult result) {

		if (this.min_retry < this.max_retry) 
		{
			this.min_retry++;
			return true;
		}

		return false;
	}

}
