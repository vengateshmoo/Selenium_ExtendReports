package extentreport;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class ExtentReportExamples {

	WebDriver driver;
	ExtentReports extentreports;
	ExtentHtmlReporter htmlreporte;
	ExtentTest testcase;

	@BeforeSuite
	public void launchBrowser() {
		extentreports = new ExtentReports();
		htmlreporte=new ExtentHtmlReporter("ExtentReport.html");
		extentreports.attachReporter(htmlreporte);
		System.setProperty("WebDriver.gecko.driver", "C:\\Users\\ADMIN\\Desktop\\geckodriver.exe");
		driver = new FirefoxDriver();
	}
	@Test
	public void openGoogle() throws IOException {
		testcase=extentreports.createTest("verify open Google");
		testcase.log(Status.INFO, "Navigating to Google");
		driver.get("http://www.google.com");
		String googletitle=	driver.getTitle();
		testcase.log(Status.INFO, "Actuall title:"+googletitle);
		testcase.log(Status.INFO, "Actuall title:"+"Google");
		testcase.log(Status.INFO, "Verification of Actual and Expected title ");
		if(googletitle.equals("Google")) {
			testcase.log(Status.PASS, "Actual title and Expected title are Equal ");
		}else {
			testcase.log(Status.FAIL, "Actual title and Expected title  are Not Equal ");
			TakesScreenshot screenshot = (TakesScreenshot) driver;
			File sourceFile=screenshot.getScreenshotAs(OutputType.FILE);
			File destinationfile=new File("google.png");
			org.openqa.selenium.io.FileHandler.copy(sourceFile, destinationfile);
			testcase.addScreenCaptureFromPath("google.png");
		}
	}
	@Test
	public void openBing() throws IOException {
		testcase=extentreports.createTest("verify open Bing");
		testcase.log(Status.INFO, "Navigating to Bing");
		driver.get("http://www.bing.com");
		String title=	driver.getTitle();
		testcase.log(Status.INFO, "Actuall title:"+title);
		testcase.log(Status.INFO, "Actuall title:"+"Bing");
		testcase.log(Status.INFO, "Verification of Actual and Expected title ");
		if(title.equals("bing")) {
			testcase.log(Status.PASS, "Actual title and Expected title are Equal ");
		}else {
			testcase.log(Status.FAIL, "Actual title and Expected title  are Not Equal ");
			TakesScreenshot screenshot = (TakesScreenshot) driver;
			File sourceFile=screenshot.getScreenshotAs(OutputType.FILE);
			File destinationfile=new File("bing.png");
			org.openqa.selenium.io.FileHandler.copy(sourceFile, destinationfile);
			testcase.addScreenCaptureFromPath("bing.png");     
		}

	}
	@Test
	public void openBravebrowser() throws IOException {
		testcase=extentreports.createTest("verify open Brave");
		testcase.log(Status.INFO, "Navigating to Brave");
		driver.get("http://www.brave.com");
		String title=	driver.getTitle();
		testcase.log(Status.INFO, "Actuall title:"+title);
		testcase.log(Status.INFO, "Actuall title:"+"Brave");
		testcase.log(Status.INFO, "Verification of Actual and Expected title ");
		if(title.equals("Brave")) {
			testcase.log(Status.PASS, "Actual title and Expected title are Equal ");
		}else {
			testcase.log(Status.FAIL, "Actual title and Expected title  are Not Equal ");
			TakesScreenshot screenshot = (TakesScreenshot) driver;
			File sourceFile=screenshot.getScreenshotAs(OutputType.FILE);
			File destinationfile=new File("brave.png");
			org.openqa.selenium.io.FileHandler.copy(sourceFile, destinationfile);
			testcase.addScreenCaptureFromPath("brave.png");
		}

	}
	@AfterSuite
	public void quitBrowser() {
		driver.quit();
		extentreports.flush();

	}



}
