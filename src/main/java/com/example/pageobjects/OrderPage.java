package com.example.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void enterName(String name) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(OrderPageLocators.NAME_INPUT)).sendKeys(name);
    }

    public void enterSurname(String surname) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(OrderPageLocators.SURNAME_INPUT)).sendKeys(surname);
    }

    public void enterAddress(String address) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(OrderPageLocators.ADDRESS_INPUT)).sendKeys(address);
    }

    public void enterMetroStation(String metroStation) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(OrderPageLocators.METRO_STATION_INPUT)).sendKeys(metroStation);
        // Выбор станции метро
        WebElement stationOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), '" + metroStation + "')]")));
        stationOption.click();
    }

    public void enterPhone(String phone) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(OrderPageLocators.PHONE_INPUT)).sendKeys(phone);
    }

    public void clickNextButton() {
        wait.until(ExpectedConditions.elementToBeClickable(OrderPageLocators.NEXT_BUTTON)).click();
    }

    public void enterDate(String date) {
        WebElement dateField = wait.until(ExpectedConditions.visibilityOfElementLocated(OrderPageLocators.DATE_INPUT));
        dateField.sendKeys(date);
    }

    public void selectRentalPeriod() {
        wait.until(ExpectedConditions.elementToBeClickable(OrderPageLocators.RENTAL_PERIOD_DROPDOWN)).click();
        wait.until(ExpectedConditions.elementToBeClickable(OrderPageLocators.RENTAL_PERIOD_OPTION)).click();
    }

    public void selectColor(String color) {
        if (color.equalsIgnoreCase("black")) {
            wait.until(ExpectedConditions.elementToBeClickable(OrderPageLocators.COLOR_BLACK_CHECKBOX)).click();
        } else if (color.equalsIgnoreCase("grey")) {
            wait.until(ExpectedConditions.elementToBeClickable(OrderPageLocators.COLOR_GREY_CHECKBOX)).click();
        }
    }

    public void confirmOrder() {
        wait.until(ExpectedConditions.elementToBeClickable(OrderPageLocators.ORDER_CONFIRM_BUTTON)).click();
    }

    public boolean isOrderSuccessPopupDisplayed() {
        return driver.findElements(OrderPageLocators.SUCCESS_POPUP).size() > 0;
    }
}