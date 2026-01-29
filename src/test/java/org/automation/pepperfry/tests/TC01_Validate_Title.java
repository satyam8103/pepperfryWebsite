package org.automation.pepperfry.tests;

import org.automation.pepperfry.base.BaseClass;
import org.automation.pepperfry.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC01_Validate_Title extends BaseClass {

    @Test
    public void validateTitle() {
        HomePage home = new HomePage(driver);
        Assert.assertTrue(
                home.getTitle().contains("Furniture"),
                "Title validation failed"
        );
    }
}
