package ru.otus.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.junit.jupiter.api.Assertions;

public class CourseQAEngineerPage {
    private final WebDriver driver;

    public CourseQAEngineerPage(WebDriver driver) {
        this.driver = driver;
    }

    private static final By NAME_COURSE = By.xpath(".//h1[text()='QA Engineer. Basic']");
    private static final By DESCRIPTION_COURSE = By.xpath(".//p[text()='Ваш первый шаг в карьере тестировщика']");
    private static final By DURATION_COURSE = By.xpath(".//p[text()='4 месяца']");
    private static final By FORMAT_COURSE = By.xpath(".//p[text()='Онлайн']");

    @Step("Проверка информации о курсе 'QA Engineer. Basic'")
    public CourseQAEngineerPage checkInformationAboutCourse() {
        WebElement nameCourseElement = driver.findElement(NAME_COURSE);
        WebElement descriptionCourseElement = driver.findElement(DESCRIPTION_COURSE);
        WebElement durationCourseElement = driver.findElement(DURATION_COURSE);
        WebElement formatCourseElement = driver.findElement(FORMAT_COURSE);

        Assertions.assertTrue(nameCourseElement.isDisplayed(), "Имя курса не отображается");
        Assertions.assertEquals("QA Engineer. Basic", nameCourseElement.getText(), "Текст имени курса не соответствует ожидаемому");

        Assertions.assertTrue(descriptionCourseElement.isDisplayed(), "Описание курса не отображается");
        Assertions.assertEquals("Ваш первый шаг в карьере тестировщика", descriptionCourseElement.getText(), "Текст описания курса не соответствует ожидаемому");

        Assertions.assertTrue(durationCourseElement.isDisplayed(), "Длительность курса не отображается");
        Assertions.assertEquals("4 месяца", durationCourseElement.getText(), "Текст длительности курса не соответствует ожидаемому");

        Assertions.assertTrue(formatCourseElement.isDisplayed(), "Формат курса не отображается");
        Assertions.assertEquals("Онлайн", formatCourseElement.getText(), "Текст формата курса не соответствует ожидаемому");

        return this;
    }
}
