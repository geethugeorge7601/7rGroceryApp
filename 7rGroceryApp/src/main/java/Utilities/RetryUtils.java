package Utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;


public class RetryUtils implements IRetryAnalyzer{
int intialCount =0;
int maxRetryCount =3;

	@Override
	public boolean retry(ITestResult result) {
		if(intialCount<maxRetryCount) {
			intialCount++;
			return true;
		}
		return false;
	}
}
