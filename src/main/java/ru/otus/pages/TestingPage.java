package ru.otus.pages;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class TestingPage {
    private final WebDriver driver;

    public TestingPage(WebDriver driver) {
        this.driver = driver;
    }

    private static final By CARDS_COURSES = By.xpath(".//div[@class='sc-18q05a6-1 bwGwUO']//a");
    private static final By CARD_QA_ENGINEER = By.xpath(".//div[text()='QA Engineer. Basic']");

    @Step("Проверка количества карточек курсов")
    public TestingPage checkCountCards() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(CARDS_COURSES));

        List<WebElement> elements = driver.findElements(CARDS_COURSES);
        long visibleElementsCount = elements.stream()
                .filter(WebElement::isDisplayed)
                .count();
        Assertions.assertEquals(10, visibleElementsCount,
                "Количество видимых элементов не соответствует ожидаемому.");
        return this;
    }

    @Step("Клик по карточке курса 'QA Engineer. Basic'")
    public TestingPage clickCourseCard() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement testingButton = wait.until(ExpectedConditions.visibilityOfElementLocated(CARD_QA_ENGINEER));
        testingButton.click();
        return this;
    }
}
