package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    private final WebDriver driver;
    private final By topOrderButton = By.xpath("//*[@id=\"root\"]/div/div/div[1]/div[2]/button[1]");
    private final By bottomOrderButton = By.xpath("//*[@id=\"root\"]/div/div/div[4]/div[2]/div[5]/button");
    private final By cookieConsentButton = By.id("rcc-confirm-button");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public FirstStepPage topOrderButton() {
        driver.findElement(topOrderButton).click();
        return new FirstStepPage(driver);
    }

    public void cookieConsent() {
        driver.findElement(cookieConsentButton).click();
    }

    public void waitToLoadAccordionItemByIndex(Integer index) {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("accordion__heading-" + index)));
    }

    public void scrollToAccordionItemByIndex(Integer index) {
        WebElement element = driver.findElement(By.id("accordion__heading-" + index));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public String clickToAccordionItemByIndex(Integer index) {
        WebElement element = driver.findElement(By.id("accordion__heading-" + index));
        element.click();
        WebElement panel = driver.findElement(By.id("accordion__panel-" + index));
        return panel.findElement(By.tagName("p")).getText();
    }

    public FirstStepPage bottomOrderButton() {
        driver.findElement(bottomOrderButton).click();
        return new FirstStepPage(driver);
    }
}