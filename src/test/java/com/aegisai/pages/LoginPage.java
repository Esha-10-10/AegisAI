package com.aegisai.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aegisai.agents.selfhealing.LocatorInfo;
import com.aegisai.agents.selfhealing.SmartElementFinder;
import com.aegisai.utils.LoggerUtil;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {

        this.driver = driver;
    }

    // Locators

    private By username =
            By.name("username");

    private By password =
            By.name("password");

    private By loginBtn =
            By.xpath("//input[@value='Log In']");

    private By errorMessage =
            By.className("error");

    // Positive Login

    public HomePage login(
            String user,
            String pass) {

        LoggerUtil.logger.info(
                "Entering Username");

        driver.findElement(username)
                .sendKeys(user);

        LoggerUtil.logger.info(
                "Entering Password");

        driver.findElement(password)
                .sendKeys(pass);

        // Backup Locators For Self Healing

        LocatorInfo loginButtonBackup =
                new LocatorInfo(

                        null,

                        null,

                        "input.button",

                        "//input[@value='Log In']");

        LoggerUtil.logger.info(
                "Clicking Login Button");

        SmartElementFinder.find(

                driver,

                loginBtn,

                loginButtonBackup)

                .click();

        LoggerUtil.logger.info(
                "Login Attempt Completed");

        return new HomePage(driver);
    }

    // Negative Login

    public void invalidLogin(
            String user,
            String pass) {

        LoggerUtil.logger.info(
                "Starting Invalid Login");

        driver.findElement(username)
                .sendKeys(user);

        driver.findElement(password)
                .sendKeys(pass);

        LocatorInfo loginButtonBackup =
                new LocatorInfo(

                        null,

                        null,

                        "input.button",

                        "//input[@value='Log In']");

        SmartElementFinder.find(

                driver,

                loginBtn,

                loginButtonBackup)

                .click();

        LoggerUtil.logger.info(
                "Invalid Login Attempt Executed");
    }

    public String getErrorMessage() {

        return driver.findElement(
                errorMessage)
                .getText();
    }
}s