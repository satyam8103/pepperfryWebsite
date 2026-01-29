package org.automation.pepperfry.tests;

import org.automation.pepperfry.base.BaseClass;
import org.automation.pepperfry.pages.HomePage;
import org.automation.pepperfry.pages.SetteesBenchesPage;
import org.testng.annotations.Test;

public class TC03_Filter_Metal_Benches extends BaseClass {

    @Test
    public void filterMetal() {
        HomePage home = new HomePage(driver);
        home.goToSetteesAndBenches();

        SetteesBenchesPage page = new SetteesBenchesPage(driver);
        page.filterMetalBenches();

        System.out.println("Metal benches count: " + page.getVisibleProductsCount());
    }
}
