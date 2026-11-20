package com.aegisai.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import com.aegisai.drivers.DriverFactory;
import com.aegisai.listeners.TestListener;
import com.aegisai.utils.ConfigReader;
import com.aegisai.utils.LoggerUtil;

@Listeners(TestListener.class)
public class BaseTest {

    protected ConfigReader config;

    @BeforeMethod
    public void setup() {

        LoggerUtil.logger.info(
                "Initializing Configuration");

        config = new ConfigReader();

        LoggerUtil.logger.info(
                "Launching Browser");

        DriverFactory.initDriver();

        LoggerUtil.logger.info(
                "Navigating To URL : "
                        + config.getUrl());

        DriverFactory.getDriver()
                .get(config.getUrl());
    }

    @AfterMethod
    public void tearDown() {

        LoggerUtil.logger.info(
                "Closing Browser");

        DriverFactory.quitDriver();
    }
}