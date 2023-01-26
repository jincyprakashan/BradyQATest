package com.brd.qa.Analyzer;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.brd.qa.base.TestBase;

public class RetryAnalyzer extends TestBase implements IRetryAnalyzer {
	
	int counter = 0;
	int retryLimit=3;

	public boolean retry(ITestResult result) {
		if(counter<retryLimit) {
			counter++;
			return true;
		}
		return false;
	}

}
