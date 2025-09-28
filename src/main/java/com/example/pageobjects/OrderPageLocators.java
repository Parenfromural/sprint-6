package com.example.pageobjects;

import org.openqa.selenium.By;

public class OrderPageLocators {

    // Заголовок страницы заказа
    public static final By HEADER = By.className("Order_Header__BZXOb");

    // Поле ввода имени
    public static final By NAME_INPUT = By.xpath("//input[@placeholder='* Имя']");

    // Поле ввода фамилии
    public static final By SURNAME_INPUT = By.xpath("//input[@placeholder='* Фамилия']");

    // Поле ввода адреса
    public static final By ADDRESS_INPUT = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");

    // Поле ввода станции метро
    public static final By METRO_STATION_INPUT = By.className("select-search__input");

    // Поле ввода телефона
    public static final By PHONE_INPUT = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");

    // Кнопка "Далее"
    public static final By NEXT_BUTTON = By.xpath("//div[contains(@class, 'Order_NextButton__1_rCA')]//button[contains(text(), 'Далее')]");

    // Попап успешного заказа
    public static final By SUCCESS_POPUP = By.xpath("//div[contains(text(), 'Заказ оформлен')]");

    // Выпадающий список периода аренды
    public static final By RENTAL_PERIOD_DROPDOWN = By.className("Dropdown-control");

    // Опция "сутки" в периоде аренды
    public static final By RENTAL_PERIOD_OPTION = By.xpath("//div[contains(text(), 'сутки')]");

    // Поле ввода даты
    public static final By DATE_INPUT = By.xpath("//input[@placeholder='* Когда привезти самокат']");

    // Чекбокс черного цвета
    public static final By COLOR_BLACK_CHECKBOX = By.id("black");

    // Чекбокс серого цвета
    public static final By COLOR_GREY_CHECKBOX = By.id("grey");

    // Кнопка подтверждения заказа
    public static final By ORDER_CONFIRM_BUTTON = By.xpath("//button[contains(text(), 'Да')]");
}