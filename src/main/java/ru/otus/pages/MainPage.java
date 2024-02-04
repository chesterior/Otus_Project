package ru.otus.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private static final String PAGE_URL = "https://otus.ru/";
    private static final By TESTING_BUTTON =
            By.xpath(".//section[@class='sc-10izyea-0 kZwiYW']//div[text()='Тестирование']");
    private static final By EVENTS_BUTTON = By.xpath(".//div[text()='Мероприятия']");

    @Step("Открытие главной страницы")
    public MainPage open() {
        driver.get(PAGE_URL);
        return this;
    }

    @Step("Клик по разделу тестирование")
    public MainPage clickTesting() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement testingButton = wait.until(ExpectedConditions.visibilityOfElementLocated(TESTING_BUTTON));
        testingButton.click();
        return this;
    }
    @Step("Клик по разделу мероприятия")
    public MainPage clickEvents() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement testingButton = wait.until(ExpectedConditions.visibilityOfElementLocated(EVENTS_BUTTON));
        testingButton.click();
        return this;
    }

}
