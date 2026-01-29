package org.automation.pepperfry.utils;

import org.openqa.selenium.*;
import java.io.File;
import java.nio.file.Files;

public class ScreenshotUtils {

    public static void takeScreenshot(WebDriver driver, String name) throws Exception {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File dest = new File("screenshots/" + name + ".png");
        Files.copy(src.toPath(), dest.toPath());
    }
}
