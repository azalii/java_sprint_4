package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class SecondStepPage {
    private final WebDriver driver;
    // Поле для ввода даты
    private final By dateInput = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div[1]/div/input");
    // Поле для выбора периода
    private final By periodInput = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[1]");
    // Поле для ввода комментария
    private final By commentInput = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[4]/input");
    // Кнопка "Заказать"
    private final By finishButton = By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/button[2]");

    public SecondStepPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setDate(String date) {
        driver.findElement(dateInput).sendKeys(date);
        driver.findElement(dateInput).sendKeys(Keys.ENTER);
    }

    public void setPeriod(String period) {
        driver.findElement(periodInput).click();
        driver.findElement(By.xpath("//div[text()='" + period + "']")).click();
    }

    public void setColor(String color) {
        driver.findElement(By.id(color)).click();
    }

    public void setComment(String comment) {
        driver.findElement(commentInput).sendKeys(comment);
    }

    public ConfirmationStepPage finish() {
        driver.findElement(finishButton).click();
        return new ConfirmationStepPage(driver);
    }
}
