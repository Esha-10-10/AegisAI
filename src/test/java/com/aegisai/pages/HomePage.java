package com.aegisai.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private By accountsOverview =
            By.linkText("Accounts Overview");

    public boolean isHomePageDisplayed() {

        return driver.findElement(accountsOverview)
                     .isDisplayed();
    }

    public String getCurrentUrl() {

        return driver.getCurrentUrl();
    }
}