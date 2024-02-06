package ru.otus.pages;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TestingPage extends BasePage {
    public TestingPage(WebDriver driver) {
        super(driver);
    }

    private static final By CARDS_COURSES = By.xpath(".//div[contains(@class, 'bwGwUO')]//a");
    private static final By CARD_QA_ENGINEER = By.xpath(".//div[text()='QA Engineer. Basic']");

    @DisplayName("Проверка количества карточек курсов")
    public TestingPage checkCountCards() {
        waiter(CARDS_COURSES);

        List<WebElement> elements = driver.findElements(CARDS_COURSES);
        long visibleElementsCount = elements.stream()
                .filter(WebElement::isDisplayed)
                .count();
        Assertions.assertEquals(10, visibleElementsCount,
                "Количество видимых элементов не соответствует ожидаемому.");
        return this;
    }

    @DisplayName("Клик по карточке курса 'QA Engineer. Basic'")
    public TestingPage clickCourseCard() {
        WebElement testingButton = waiter(CARD_QA_ENGINEER);
        testingButton.click();
        return this;
    }
}
