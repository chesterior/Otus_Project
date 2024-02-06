package ru.otus;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.otus.pages.EventsPage;
import ru.otus.pages.MainPage;

import static ru.otus.pages.MainPage.EVENTS_BUTTON;

public class CheckingDateOfFutureEventsTest extends TestBase {
    private MainPage mainPage;
    private EventsPage eventsPage;

    @BeforeEach
    public void setUp() {
        super.setUp();
        mainPage = new MainPage(driver);
        eventsPage = new EventsPage(driver);
    }

    @Test
    public void eventsSortingTest() {
        mainPage.open(PAGE_URL);
        mainPage.clickSection(EVENTS_BUTTON);
        eventsPage.eventVerificationDateGreaterOrEqualCurrentOne();
    }
}