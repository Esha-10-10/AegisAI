package com.aegisai.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aegisai.base.BaseTest;
import com.aegisai.drivers.DriverFactory;
import com.aegisai.pages.HomePage;
import com.aegisai.pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void verifyLogin() {

        LoginPage loginPage =
                new LoginPage(
                        DriverFactory.getDriver());

        HomePage homePage =
                loginPage.login(
                        config.getUsername(),
                        config.getPassword());

        Assert.assertTrue(
                homePage.isHomePageDisplayed());
        
    }
}
