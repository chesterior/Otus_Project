package ru.otus.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

// Elements & locators

    private static final String PAGE_URL = "https://otus.ru/";
    private static final By TESTING_BUTTON = By.xpath(".//section[@class='sc-10izyea-0 kZwiYW']//div[text()='Тестирование']");


    // actions
    @Step("Открытие главной страницы")
    public MainPage open() {
        driver.get(PAGE_URL);
        return this;
    }

    @Step("Клик по разделу тестирование")
    public MainPage clickTesting() {
        driver.findElement(TESTING_BUTTON).isDisplayed();
        driver.findElement(TESTING_BUTTON).click();
        return this;
    }

}
