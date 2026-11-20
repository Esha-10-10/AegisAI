package com.aegisai.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aegisai.drivers.DriverFactory;
import com.aegisai.reports.ExtentManager;
import com.aegisai.utils.LoggerUtil;
import com.aegisai.utils.ScreenshotUtil;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class TestListener implements ITestListener {

    private ExtentReports extent =
            ExtentManager.getInstance();

    private ExtentTest test;

    @Override
    public void onTestStart(
            ITestResult result) {

        LoggerUtil.logger.info(
                "Starting Test : "
                        + result.getMethod()
                                .getMethodName());

        test = extent.createTest(
                result.getMethod()
                        .getMethodName());
    }

    @Override
    public void onTestSuccess(
            ITestResult result) {

        LoggerUtil.logger.info(
                "Test Passed : "
                        + result.getMethod()
                                .getMethodName());

        test.pass("Test Passed");
    }

    @Override
    public void onTestFailure(
            ITestResult result) {

        LoggerUtil.logger.error(
                "Test Failed : "
                        + result.getMethod()
                                .getMethodName());

        try {

            String screenshotPath =
                    ScreenshotUtil.captureScreenshot(
                            DriverFactory.getDriver(),
                            result.getMethod()
                                    .getMethodName());

            test.fail(result.getThrowable());

            test.addScreenCaptureFromPath(
                    screenshotPath);

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(
            ITestResult result) {

        LoggerUtil.logger.info(
                "Test Skipped : "
                        + result.getMethod()
                                .getMethodName());

        test.skip("Test Skipped");
    }

    @Override
    public void onFinish(
            ITestContext context) {

        extent.flush();
    }
}