package com.aegisai.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {

    public static String captureScreenshot(
            WebDriver driver,
            String testName) {

        // Create screenshots folder if it doesn't exist

        File folder = new File("screenshots");

        if (!folder.exists()) {
            folder.mkdirs();
        }

        // Take Screenshot

        File source = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.FILE);

        // Generate unique screenshot name

        String path = "screenshots/"
                + testName
                + "_"
                + System.currentTimeMillis()
                + ".png";

        File destination = new File(path);

        try {

            Files.copy(
                    source.toPath(),
                    destination.toPath(),
                    StandardCopyOption.REPLACE_EXISTING);

        } catch (IOException e) {

            e.printStackTrace();
        }

        return path;
    }
}