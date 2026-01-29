package org.automation.pepperfry.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void goToSetteesAndBenches() {
        WebElement furniture = driver.findElement(By.xpath("//a[normalize-space()='Furniture']"));
        new Actions(driver).moveToElement(furniture).perform();

        driver.findElement(By.xpath("//a[normalize-space()='Settees & Benches']")).click();
    }
}
