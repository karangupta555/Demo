package com.qa.lms.mobile.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.util.HashMap;
import java.util.Map;

public class ExtentReport {
    final static String filePath = "reports/Extent.html";
    static ExtentReports extent;
    static Map<Integer, ExtentTest> extentTestMap = new HashMap();

    public synchronized static ExtentTest getTest() {
        return (ExtentTest) extentTestMap.get((int) (long) (Thread.currentThread().getId()));
    }

    public synchronized static ExtentTest startTest(String testName, String description) {
        ExtentTest test = getReporter().createTest(testName, description);
        extentTestMap.put((int) (long) (Thread.currentThread().getId()), test);
        return test;
    }

    public synchronized static ExtentReports getReporter() {
        if(extent == null) {
            ExtentSparkReporter spark = new ExtentSparkReporter(filePath);
            spark.config().setReportName("Auzmor Learn Mobile App");
            spark.config().setDocumentTitle("Test Suite Report");
            spark.config().setTheme(Theme.DARK);
            extent = new ExtentReports();
            extent.attachReporter(spark);
        }
        return extent;
    }
}
