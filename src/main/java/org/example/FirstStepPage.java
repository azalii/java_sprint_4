package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FirstStepPage {
    private final WebDriver driver;
    // Поле для ввода имени
    private final By nameInput = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/input");
    // Поле для ввода фамилии
    private final By lastnameInput = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/input");
    // Поле для ввода адреса
    private final By addressInput = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[3]/input");
    // Поле для выбора метро
    private final By metroInput = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[4]/div/div/input");
    // Поле для ввода телефона
    private final By phoneInput = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[5]/input");
    // Кнопка "Далее"
    private final By nextButton = By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/button");

    public FirstStepPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setName(String name) {
        driver.findElement(nameInput).sendKeys(name);
    }

    public void setLastname(String lastname) {
        driver.findElement(lastnameInput).sendKeys(lastname);
    }

    public void setAddress(String address) {
        driver.findElement(addressInput).sendKeys(address);
    }

    public void setMetro(String metro) {
        driver.findElement(metroInput).click();
        driver.findElement(By.xpath("//div[text()='" + metro + "']")).click();
    }

    public void setPhone(String phone) {
        driver.findElement(phoneInput).sendKeys(phone);
    }

    public SecondStepPage next() {
        driver.findElement(nextButton).click();
        return new SecondStepPage(driver);
    }
}
