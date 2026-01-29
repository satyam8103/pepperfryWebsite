package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class TC_04_SingleFileCode {
    @Test
    public void benches_material_filter_flow() throws Exception {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();

        // 1) Open site
        driver.get("https://www.pepperfry.com/");
        Thread.sleep(5000);

        // Close newsletter/modal if present (simple)
        List<WebElement> modalClose = driver.findElements(By.xpath("//a[@class='close-modal']"));
        if (!modalClose.isEmpty()) {
            modalClose.get(0).click();
        }

        String actualTitle = driver.getTitle();

        String expectedText = "Buy Furniture & Home Decor Online – Up to 70% Off at Best Prices in India | Pepperfry";


        if (actualTitle.contains(expectedText)) {
            System.out.println("Title Validation Passed!");
        } else {
            System.out.println("Title Validation Failed!");
        }

//        driver.close();
        // Hover Furniture → click Settees & Benches
        WebElement furnitureMenu = driver.findElement(By.xpath("//a[normalize-space()='Furniture']"));
        new Actions(driver).moveToElement(furnitureMenu).pause(Duration.ofMillis(300)).perform();
        Thread.sleep(1500);

        WebElement setteesBenches = driver.findElement(
                By.xpath("//a[contains(text(),'Settees') and contains(text(),'Benches')] | //a[normalize-space()='Settees & Benches']")
        );
        setteesBenches.click();
        Thread.sleep(4000);

        // JS scroll (as asked)
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 500);");
        Thread.sleep(1500);

        // ===== Read counts (landing strip) =====
        String benchesText   = driver.findElement(By.xpath("(//div[contains(text(),'Benches')]/following::div[contains(.,'option')])[1]")).getText();
        String setteesText   = driver.findElement(By.xpath("(//div[contains(text(),'Settees')]/following::div[contains(.,'option')])[1]")).getText();
        String recamiersText = driver.findElement(By.xpath("(//div[contains(text(),'Recamiers')]/following::div[contains(.,'option')])[1]")).getText();

        int benchesCount   = Integer.parseInt(benchesText.replaceAll("\\D", ""));
        int setteesCount   = Integer.parseInt(setteesText.replaceAll("\\D", ""));
        int recamiersCount = Integer.parseInt(recamiersText.replaceAll("\\D", ""));

        System.out.println("=== Subcategory Counts (from landing page) ===");
        System.out.println("Benches   : " + benchesCount);
        System.out.println("Settees   : " + setteesCount);
        System.out.println("Recamiers : " + recamiersCount);
        Thread.sleep(4000);



        WebElement moreFiltersContainer = driver.findElement(
                By.xpath("/html/body/app-root/main/app-category/pf-clip/div/div[1]/div[3]/pf-clip-filter/div[1]/div/div/div/div[1]/span[5]/span[3]")
        );
        moreFiltersContainer.click();
        System.out.println("working");
        Thread.sleep(3000);


        WebElement materialHeader = driver.findElement(By.xpath(
                "(//div[normalize-space()='Material'] | //span[normalize-space()='Material'] | //button[normalize-space()='Material'])[1]"
        ));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", materialHeader);
        materialHeader.click();
        Thread.sleep(1200);

        // Drawer ke andar "Metal" option select karo.
        // Tumhare screenshot me input id="Metal" aur label .checkbox-label me "Metal" dikh raha hai.
        WebElement metalOption = driver.findElement(By.xpath(
                "//label[@for='Metal'] | //label[contains(.,'Metal')] | //span[normalize-space()='Metal']"
        ));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", metalOption);
        metalOption.click();
        Thread.sleep(1000);

        // APPLY button (drawer ke bottom me span 'APPLY')
        WebElement applyBtn = driver.findElement(By.xpath(
                "//button[.//span[normalize-space()='APPLY']] | //span[normalize-space()='APPLY']"
        ));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", applyBtn);
        applyBtn.click();
        Thread.sleep(4000); // grid refresh wait
        // ✅ IMPORTANT CHANGE ENDS HERE

        // Products list anchors (broad, simple)
        List<WebElement> productAnchors = driver.findElements(By.xpath(
                "//a[contains(@href,'/product') and normalize-space()] | //div[contains(@class,'product') or contains(@class,'card')]//a[normalize-space()]"
        ));
        int visibleCount = productAnchors.size();

        System.out.println("=== After Filter: Material = Metal ===");
        System.out.println("Visible Benches Count: " + visibleCount);

        driver.quit();

//        int printLimit = Math.min(10, visibleCount);
//        for (int i = 0; i < printLimit; i++) {
//            String t = productAnchors.get(i).getText().trim();
//            if (!t.isEmpty()) {
//                System.out.println((i + 1) + ". " + t);
//            }
//        }


//        // Screenshot
//        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//        File dest = new File("metal_benches_after_filter.png");
//        Files.copy(src.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
//        System.out.println("Screenshot saved at: " + dest.getAbsolutePath());

        driver.quit();
    }
}

