package org.automation.pepperfry.pages;

import org.openqa.selenium.*;
import java.util.List;

public class SetteesBenchesPage {

    private WebDriver driver;

    public SetteesBenchesPage(WebDriver driver) {
        this.driver = driver;
    }

    private int extractCount(String text) {
        return Integer.parseInt(text.replaceAll("\\D", ""));
    }

    public int getBenchesCount() {
        return extractCount(driver.findElement(
                By.xpath("(//div[contains(text(),'Benches')]/following::div)[1]")).getText());
    }

    public int getSetteesCount() {
        return extractCount(driver.findElement(
                By.xpath("(//div[contains(text(),'Settees')]/following::div)[1]")).getText());
    }

    public int getRecamiersCount() {
        return extractCount(driver.findElement(
                By.xpath("(//div[contains(text(),'Recamiers')]/following::div)[1]")).getText());
    }

    public void filterMetalBenches() {
        driver.findElement(By.xpath("//span[contains(text(),'Material')]")).click();
        driver.findElement(By.xpath("//label[contains(text(),'Metal')]")).click();
        driver.findElement(By.xpath("//span[normalize-space()='APPLY']")).click();
    }

    public int getVisibleProductsCount() {
        List<WebElement> products =
                driver.findElements(By.xpath("//a[contains(@href,'/product')]"));
        return products.size();
    }
}
