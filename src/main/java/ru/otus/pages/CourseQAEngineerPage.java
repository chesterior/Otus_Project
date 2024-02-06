package ru.otus.pages;

import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.junit.jupiter.api.Assertions;

public class CourseQAEngineerPage extends BasePage {
    public CourseQAEngineerPage(WebDriver driver) {
        super(driver);
    }

    private By getNameCourseLocator(String courseName) {
        return By.xpath(".//h1[text()='" + courseName + "']");
    }

    private By getDescriptionCourseLocator(String description) {
        return By.xpath(".//p[text()='" + description + "']");
    }

    private By getDurationCourseLocator(String duration) {
        return By.xpath(".//p[text()='" + duration + "']");
    }

    private By getFormatCourseLocator(String format) {
        return By.xpath(".//p[text()='" + format + "']");
    }

    @DisplayName("Проверка информации о курсе")
    public CourseQAEngineerPage checkInformationAboutCourse(String expectedName, String expectedDescription, String expectedDuration, String expectedFormat) {
        WebElement nameCourseElement = driver.findElement(getNameCourseLocator(expectedName));
        WebElement descriptionCourseElement = driver.findElement(getDescriptionCourseLocator(expectedDescription));
        WebElement durationCourseElement = driver.findElement(getDurationCourseLocator(expectedDuration));
        WebElement formatCourseElement = driver.findElement(getFormatCourseLocator(expectedFormat));

        Assertions.assertTrue(nameCourseElement.isDisplayed(), "Имя курса не отображается");
        Assertions.assertEquals(expectedName, nameCourseElement.getText(), "Текст имени курса не соответствует ожидаемому");

        Assertions.assertTrue(descriptionCourseElement.isDisplayed(), "Описание курса не отображается");
        Assertions.assertEquals(expectedDescription, descriptionCourseElement.getText(), "Текст описания курса не соответствует ожидаемому");

        Assertions.assertTrue(durationCourseElement.isDisplayed(), "Длительность курса не отображается");
        Assertions.assertEquals(expectedDuration, durationCourseElement.getText(), "Текст длительности курса не соответствует ожидаемому");

        Assertions.assertTrue(formatCourseElement.isDisplayed(), "Формат курса не отображается");
        Assertions.assertEquals(expectedFormat, formatCourseElement.getText(), "Текст формата курса не соответствует ожидаемому");

        return this;
    }
}

