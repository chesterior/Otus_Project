package ru.otus.pages;

import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public static final By TESTING_BUTTON =
            By.xpath(".//section[@class='sc-10izyea-0 kZwiYW']//div[text()='Тестирование']");
    public static final By EVENTS_BUTTON = By.xpath(".//div[text()='Мероприятия']");

    @DisplayName("Клик по разделу")
    public MainPage clickSection(By section) {
        WebElement testingButton = waiter(section);
        testingButton.click();
        return this;
    }
}
