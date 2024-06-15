package ui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class OrderTest {
    public WebDriver driver;
    private final String name;
    private final String lastname;
    private final String address;
    private final String metro;
    private final String phone;
    private final String date;
    private final String period;
    private final String color;
    private final String comment;

    public OrderTest(String name, String lastname, String address, String metro, String phone, String date, String period, String color, String comment) {
        this.name = name;
        this.lastname = lastname;
        this.address = address;
        this.metro = metro;
        this.phone = phone;
        this.date = date;
        this.period = period;
        this.color = color;
        this.comment = comment;
    }

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Parameterized.Parameters
    public static Object[][] getCredentials() {
        return new Object[][]{
                {
                        "Джакс",
                        "Юнит",
                        "Москва",
                        "Бульвар Рокоссовского",
                        "+7999999999",
                        "20.10.1992",
                        "сутки",
                        "black",
                        "я дома"
                },
                {
                        "Боб",
                        "Марли",
                        "Белград",
                        "Черкизовская",
                        "+381999999999",
                        "20.10.1994",
                        "двое суток",
                        "black",
                        "я дома"
                },
        };
    }

    @Test
    public void topOrderButton() {
        driver.get("https://qa-scooter.praktikum-services.ru");

        MainPage mainPage = new MainPage(driver);
        mainPage.cookieConsent();
        mainPage.waitToLoadTopOrderButton();
        mainPage.scrollToTopOrderButton();
        FirstStepPage firstStep = mainPage.clickTopOrderButton();
        firstStep.setName(name);
        firstStep.setLastname(lastname);
        firstStep.setAddress(address);
        firstStep.setMetro(metro);
        firstStep.setPhone(phone);
        SecondStepPage secondStep = firstStep.next();
        secondStep.setDate(date);
        secondStep.setPeriod(period);
        secondStep.setColor(color);
        secondStep.setComment(comment);
        ConfirmationStepPage confirmationPage = secondStep.finish();
        SuccessStepPage successPage = confirmationPage.yes();
        assertTrue(successPage.isDisplayed());
    }

    @Test
    public void bottomOrderButton() {
        driver.get("https://qa-scooter.praktikum-services.ru");

        MainPage mainPage = new MainPage(driver);
        mainPage.cookieConsent();
        mainPage.waitToLoadBottomOrderButton();
        mainPage.scrollToBottomOrderButton();
        FirstStepPage firstStep = mainPage.clickBottomOrderButton();
        firstStep.setName(name);
        firstStep.setLastname(lastname);
        firstStep.setAddress(address);
        firstStep.setMetro(metro);
        firstStep.setPhone(phone);
        SecondStepPage secondStep = firstStep.next();
        secondStep.setDate(date);
        secondStep.setPeriod(period);
        secondStep.setColor(color);
        secondStep.setComment(comment);
        ConfirmationStepPage confirmationPage = secondStep.finish();
        SuccessStepPage successPage = confirmationPage.yes();
        assertTrue(successPage.isDisplayed());

        CheckStatusStepPage checkStatusStepPage = successPage.showStatusInfo();
        assertEquals(name, checkStatusStepPage.getName());
        assertEquals(lastname, checkStatusStepPage.getLastname());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
