package ru.otus;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.otus.pages.MainPage;
import ru.otus.pages.TestingPage;

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
    public void test() {
        mainPage.open();
        mainPage.clickTesting();
        testingPage.checkCountCards();
    }
}
