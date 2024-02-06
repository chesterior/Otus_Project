package ru.otus;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.otus.pages.CourseQAEngineerPage;
import ru.otus.pages.MainPage;
import ru.otus.pages.TestingPage;

import static ru.otus.pages.MainPage.TESTING_BUTTON;

public class CheckDetailsCourseCardTest extends TestBase {
    private MainPage mainPage;
    private TestingPage testingPage;
    private CourseQAEngineerPage courseQAEngineerPage;
    String expectedName = "QA Engineer. Basic";
    String expectedDescription = "Ваш первый шаг в карьере тестировщика";
    String expectedDuration = "4 месяца";
    String expectedFormat = "Онлайн";

    @BeforeEach
    public void setUp() {
        super.setUp();
        mainPage = new MainPage(driver);
        testingPage = new TestingPage(driver);
        courseQAEngineerPage = new CourseQAEngineerPage(driver);
    }

    @Test
    public void checkDetailsCourseCardTest() {
        mainPage.open(PAGE_URL);
        mainPage.clickSection(TESTING_BUTTON);
        testingPage.clickCourseCard();
        courseQAEngineerPage.checkInformationAboutCourse(expectedName, expectedDescription, expectedDuration, expectedFormat);
    }
}
