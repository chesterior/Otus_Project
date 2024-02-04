package ru.otus;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.otus.pages.CourseQAEngineerPage;
import ru.otus.pages.MainPage;
import ru.otus.pages.TestingPage;

public class CheckDetailsCourseCardTest extends TestBase {
    private MainPage mainPage;
    private TestingPage testingPage;
    private CourseQAEngineerPage courseQAEngineerPage;

    @BeforeEach
    public void setUp() {
        super.setUp();
        mainPage = new MainPage(driver);
        testingPage = new TestingPage(driver);
        courseQAEngineerPage = new CourseQAEngineerPage(driver);
    }

    @Test
    public void test() {
        mainPage.open();
        mainPage.clickTesting();
        testingPage.clickCourseCard();
        courseQAEngineerPage.checkInformationAboutCourse();
    }
}
