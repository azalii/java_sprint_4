package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmationStepPage {
    private final WebDriver driver;
    // Кнопка "Да"
    private final By yesButton = By.xpath("//*[@id=\"root\"]/div/div[2]/div[5]/div[2]/button[2]");

    public ConfirmationStepPage(WebDriver driver) {
        this.driver = driver;
    }

    public SuccessStepPage yes() {
        driver.findElement(yesButton).click();
        return new SuccessStepPage(driver);
    }
}
