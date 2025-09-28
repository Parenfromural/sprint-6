import com.example.pageobjects.MainPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainPageTest {
    private WebDriver driver;
    private MainPage mainPage;

    @BeforeEach
    public void setUp(String browser) {
        if (browser.equals("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equals("firefox")) {
            driver = new FirefoxDriver();
        }
        driver.get("https://qa-scooter.praktikum-services.ru");
        mainPage = new MainPage(driver);
    }

    @ParameterizedTest
    @CsvSource({
            "chrome",
            "firefox"
    })
    public void testSetup(String browser) {
        setUp(browser);
    }

    @ParameterizedTest
    @CsvSource({
            "0, 'Сутки — 400 рублей. Оплата курьеру — наличными или картой.'",
            "1, 'Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.'",
            "2, 'Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.'",
            "3, 'Только начиная с завтрашнего дня. Но скоро станем расторопнее.'",
            "4, 'Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.'",
            "5, 'Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.'",
            "6, 'Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.'",
            "7, 'Да, обязательно. Всем самокатов! И Москве, и Московской области.'"
    })
    public void testDropdownFunctionality(int questionIndex, String expectedAnswer) {
        mainPage.clickQuestion(questionIndex);
        String actualText = mainPage.getQuestionAnswer(questionIndex);
        assertEquals(expectedAnswer, actualText);
    }

    @ParameterizedTest
    @CsvSource({
            "chrome",
            "firefox"
    })
    public void testOrderButtonNavigation(String browser) {
        setUp(browser);
        mainPage.clickOrderButtonTop();
        String expectedHeader = "Для кого самокат";
        String actualHeader = driver.findElement(By.className("Order_Header__BZXOb")).getText();
        assertEquals(expectedHeader, actualHeader);
    }


    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}