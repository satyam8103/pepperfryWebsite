package org.automation.pepperfry.tests;

import org.automation.pepperfry.base.BaseClass;
import org.automation.pepperfry.pages.HomePage;
import org.automation.pepperfry.pages.SetteesBenchesPage;
import org.automation.pepperfry.utils.ScreenshotUtils;
import org.testng.annotations.Test;

public class TC04_Screenshot_And_Count extends BaseClass {

    @Test
    public void screenshotAndCount() throws Exception {
        HomePage home = new HomePage(driver);
        home.goToSetteesAndBenches();

        SetteesBenchesPage page = new SetteesBenchesPage(driver);
        page.filterMetalBenches();

        int count = page.getVisibleProductsCount();
        System.out.println("Final Count: " + count);

        ScreenshotUtils.takeScreenshot(driver, "Metal_Benches");
    }
}
