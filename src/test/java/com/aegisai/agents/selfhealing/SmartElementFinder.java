package com.aegisai.agents.selfhealing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SmartElementFinder {

    public static WebElement find(

            WebDriver driver,

            By originalLocator,

            LocatorInfo backupLocators) {

        try {

            return driver.findElement(
                    originalLocator);

        } catch (Exception e) {

            System.out.println(
                    "Original Locator Failed");

            if (backupLocators.getId() != null) {

                try {

                    WebElement element =
                            driver.findElement(

                                    By.id(
                                            backupLocators.getId()));

                    RecoveryReport.recovered(
                            "ID");

                    return element;

                } catch (Exception ex) {
                }

            }

            if (backupLocators.getName() != null) {

                try {

                    WebElement element =
                            driver.findElement(

                                    By.name(
                                            backupLocators.getName()));

                    RecoveryReport.recovered(
                            "NAME");

                    return element;

                } catch (Exception ex) {
                }

            }

            if (backupLocators.getCss() != null) {

                try {

                    WebElement element =
                            driver.findElement(

                                    By.cssSelector(
                                            backupLocators.getCss()));

                    RecoveryReport.recovered(
                            "CSS");

                    return element;

                } catch (Exception ex) {
                }

            }

            if (backupLocators.getXpath() != null) {

                try {

                    WebElement element =
                            driver.findElement(

                                    By.xpath(
                                            backupLocators.getXpath()));

                    RecoveryReport.recovered(
                            "XPATH");

                    return element;

                } catch (Exception ex) {
                }

            }

            throw new RuntimeException(
                    "Element Not Found");
        }
    }
}
