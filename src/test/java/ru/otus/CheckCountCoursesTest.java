package ru.otus;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.otus.pages.MainPage;
import ru.otus.pages.TestingPage;

import static ru.otus.pages.MainPage.TESTING_BUTTON;

public class CheckCountCoursesTest extends TestBase {
    private MainPage mainPage;
    private TestingPage testingPage;

    @BeforeEach
    public void setUp() {
        super.setUp();
        mainPage = new MainPage(driver);
        testingPage = new TestingPage(driver);
    }

    @Test
    public void checkCountCoursesTest() {
        mainPage.open(PAGE_URL);
        mainPage.clickSection(TESTING_BUTTON);
        testingPage.checkCountCards();
    }
}
