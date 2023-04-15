package genral;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Report;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListnerImpleClass implements ITestListener {

	ExtentReports report;
	ExtentTest test;
	
	@Override
	public void onTestStart(ITestResult result) {
		
		String MrthodName = result.getMethod().getMethodName();
		test = report.createTest(MrthodName);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.PASS, MethodName+" pass ");
		
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		EventFiringWebDriver edriver = new EventFiringWebDriver(Normal.sdriver);
		File src = edriver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./Screenshot/screen.png");
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String path = dest.getAbsolutePath();
		test.addScreenCaptureFromPath(path);
		test.log(Status.FAIL, result.getThrowable());
		
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.SKIP, MethodName+" skip ");
		test.log(Status.SKIP, result.getThrowable());	
	}

	@Override
	public void onStart(ITestContext context) {
		
		ExtentSparkReporter htmlreport = new ExtentSparkReporter("./ExtentReport/report.html");
		htmlreport.config().setDocumentTitle("General report");
		htmlreport.config().setTheme(Theme.DARK);
		htmlreport.config().setReportName("waris");
		
		report = new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("base browser", "chrome");
		report.setSystemInfo("os", "windows");
		report.setSystemInfo("base url", "https://www.cricbuzz.com/");
		report.setSystemInfo("reporter", "waris");
		
	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
	}
}
