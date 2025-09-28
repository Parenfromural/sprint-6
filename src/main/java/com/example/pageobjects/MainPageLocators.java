package com.example.pageobjects;

import org.openqa.selenium.By;

public class MainPageLocators {

    // Кнопка «Заказать» (верхняя)
    public static final By ORDER_BUTTON_TOP = By.xpath("//button[text()='Заказать']");

    // Кнопка «Заказать» (нижняя)
    public static final By ORDER_BUTTON_BOTTOM = By.xpath("//button[text()='Заказать'][last()]");

    // Кнопка вопроса в аккордеоне
    public static final By QUESTION_BUTTONS = By.className("accordion__button");

    // Панель ответа в аккордеоне
    public static final By QUESTION_PANELS = By.className("accordion__panel");
}