import com.example.pageobjects.MainPage;
import com.example.pageobjects.OrderPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class OrderPageTest {
    private WebDriver driver;
    private MainPage mainPage;
    private OrderPage orderPage;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru");
        mainPage = new MainPage(driver);
        orderPage = new OrderPage(driver);
    }

    @ParameterizedTest
    @MethodSource("provideOrderData")
    public void testOrderFlow(String name, String surname, String address, String metroStation, String phone, String rentalDate, String color, String entryPoint) {
        if (entryPoint.equals("top")) {
            mainPage.clickOrderButtonTop();
        } else {
            mainPage.clickOrderButtonBottom();
        }

        orderPage.enterName(name);
        orderPage.enterSurname(surname);
        orderPage.enterAddress(address);
        orderPage.enterMetroStation(metroStation);
        orderPage.enterPhone(phone);
        orderPage.clickNextButton();
        orderPage.selectRentalPeriod();
        orderPage.enterDate(rentalDate);
        orderPage.selectColor(color);
        orderPage.confirmOrder();

        assertTrue(orderPage.isOrderSuccessPopupDisplayed());
    }

    static Stream<Arguments> provideOrderData() {
        return Stream.of(
                Arguments.of("Иван", "Иванов", "Москва, ул. Пушкина, д. 1", "Сокольники", "+79000000000", "02.09.2025", "black", "top"),
                Arguments.of("Петр", "Петров", "Санкт-Петербург, Невский пр., д. 2", "Сокольники", "+79000000001", "02.09.2025", "grey", "bottom")
        );
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}