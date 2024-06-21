package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SuccessStepPage {
    private final WebDriver driver;
    // Кнопка "Показать информацию"
    private final By infoButton = By.xpath("/html/body/div/div/div[2]/div[5]/div[2]/button");

    public SuccessStepPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isDisplayed() {
        return driver.findElement(infoButton).isDisplayed();
    }

    public CheckStatusStepPage showStatusInfo() {
        driver.findElement(infoButton).click();
        return new CheckStatusStepPage(driver);
    }
}
