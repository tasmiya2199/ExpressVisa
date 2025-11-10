package com.crm.Expressvisa.GenericLibrary;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.io.Files;

public class ListenerImplementation extends Baseclass implements ITestListener {
public ExtentReports report;
    public ExtentTest test;
	@Override
	public void onTestStart(ITestResult result) {
		String methodname = result.getName();
		test=report.createTest(methodname);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodname = result.getName();
	test.log(Status.PASS, methodname+"-->"+"Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodname = result.getName();
		String name = result.getName();
		TakesScreenshot t=(TakesScreenshot) driver;
		File src = t.getScreenshotAs(OutputType.FILE);
		File dest = new File("./Screenshot/"+name+".png");
	try {
		Files.copy(src, dest);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	test.log(Status.FAIL, methodname+"-->"+"failed");
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		String methodname = result.getName();
		test.log(Status.SKIP, methodname+"-->"+"skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		JavaUtility jutil=new JavaUtility();
		String timestamp = jutil.dataAndTime("dd-MM-yyyy hh-mm-ss");
		System.out.println(timestamp);
	ExtentSparkReporter reporter=new ExtentSparkReporter("./ExtentReports/report"+timestamp+".html");
	reporter.config().setDocumentTitle("ExpressVisa Report");
	reporter.config().setReportName("Expressvisa Execution report");
	reporter.config().setTheme(Theme.STANDARD);
	
	 report=new ExtentReports();
	report.attachReporter(reporter);
	report.setSystemInfo("url", "http://localhost:8888");
	report.setSystemInfo("OS", "Windows");
	report.setSystemInfo("browser", "chrome");
	report.setSystemInfo("TestEngineer", "Ali");
	
	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
	}
	
	
	

}
