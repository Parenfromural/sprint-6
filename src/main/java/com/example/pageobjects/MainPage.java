package com.example.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOrderButtonTop() {
        driver.findElement(MainPageLocators.ORDER_BUTTON_TOP).click();
    }

    public void clickOrderButtonBottom() {
        driver.findElement(MainPageLocators.ORDER_BUTTON_BOTTOM).click();
    }

    public void clickQuestion(int index) {
        WebElement questionButton = driver.findElements(MainPageLocators.QUESTION_BUTTONS).get(index);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", questionButton);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(questionButton));
        questionButton.click();
    }

    public String getQuestionAnswer(int index) {
        return driver.findElements(MainPageLocators.QUESTION_PANELS).get(index).getText();
    }
}