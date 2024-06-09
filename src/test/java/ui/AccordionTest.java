package ui;

import org.example.MainPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(Parameterized.class)
public class AccordionTest {
     public WebDriver driver;
     private final Integer accordionIndex;
     private final String text;

    public AccordionTest(Integer accordionIndex, String text) {
        this.accordionIndex = accordionIndex;
        this.text = text;
    }

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Parameterized.Parameters
    public static Object[][] getCredentials() {
        return new Object[][] {
                { 0, "Сутки — 400 рублей. Оплата курьеру — наличными или картой." },
                { 1, "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим." },
                { 2, "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30." },
        };
    }

    @Test
    public void test() {
        driver.get("https://qa-scooter.praktikum-services.ru");

        MainPage mainPage = new MainPage(driver);
        mainPage.waitToLoadAccordionItemByIndex(accordionIndex);
        mainPage.scrollToAccordionItemByIndex(accordionIndex);
        String answer = mainPage.clickToAccordionItemByIndex(accordionIndex);
        assertEquals(text, answer);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
