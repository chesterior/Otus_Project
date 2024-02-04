package ru.otus.pages;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TestingPage {
    private final WebDriver driver;

    public TestingPage(WebDriver driver) {
        this.driver = driver;
    }


    private static final By CARDS_COURSES = By.xpath(".//div[@class='sc-18q05a6-1 bwGwUO']//a");



    @Step("Проверка количества карточек курсов")
    public TestingPage checkCountCards() {
        List<WebElement> elements = driver.findElements(CARDS_COURSES);
        long visibleElementsCount = elements.stream()
                .filter(WebElement::isDisplayed)
                .count();
        Assertions.assertEquals(10, visibleElementsCount,
                "Количество видимых элементов не соответствует ожидаемому.");
        return this;
    }

}
