package com.aegisai.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aegisai.base.BaseTest;
import com.aegisai.drivers.DriverFactory;
import com.aegisai.pages.LoginPage;

public class InvalidLoginTest extends BaseTest {

    @Test
    public void verifyInvalidLogin() {

        LoginPage loginPage =
                new LoginPage(
                        DriverFactory.getDriver());

        loginPage.invalidLogin(
                "wronguser",
                "wrongpass");

        String actualMessage =
                loginPage.getErrorMessage();

        String expectedMessage =
                "The username and password could not be verified.";

        Assert.assertEquals(
                actualMessage,
                expectedMessage);
    }
}