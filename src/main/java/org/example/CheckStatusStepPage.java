package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class CheckStatusStepPage {
    private final WebDriver driver;
    //  Имя заказчика
    private final By nameText = By.xpath("/html/body/div/div/div[2]/div[2]/div[1]/div[1]/div[2]");
    // Фамилия заказчика
    private final By lastnameText = By.xpath("/html/body/div/div/div[2]/div[2]/div[1]/div[2]/div[2]");

    public CheckStatusStepPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getName() {
        return driver.findElement(nameText).getText();
    }

    public String getLastname() {
        return driver.findElement(lastnameText).getText();
    }
}
