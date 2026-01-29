package org.automation.pepperfry.tests;

import org.automation.pepperfry.base.BaseClass;
import org.automation.pepperfry.pages.HomePage;
import org.automation.pepperfry.pages.SetteesBenchesPage;
import org.testng.annotations.Test;

public class TC02_Count_Furniture extends BaseClass {

    @Test
    public void countFurniture() {
        HomePage home = new HomePage(driver);
        home.goToSetteesAndBenches();

        SetteesBenchesPage page = new SetteesBenchesPage(driver);

        System.out.println("Benches: " + page.getBenchesCount());
        System.out.println("Settees: " + page.getSetteesCount());
        System.out.println("Recamiers: " + page.getRecamiersCount());
    }
}
