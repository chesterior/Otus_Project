package ru.otus.pages;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.MonthDay;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

public class EventsPage extends BasePage {
    public EventsPage(WebDriver driver) {
        super(driver);
    }

    private static final By EVENT_BUTTON = By.xpath("(.//span[text()='Все мероприятия'])[1]");
    private static final By FILTER_OPEN_WEBINAR =
            By.xpath(".//div[@class='dod_new-events__header-left']//a[text()='Открытый вебинар']");
    private static final By TYPE_CARDS_ON_PAGE = By.xpath(".//div[@class='dod_new-type__text']");
    private static final By DATE_EVENTS =
            By.xpath(".//span[contains(@class, 'time-item')][.//span[contains(@class, 'calendar-icon')]]");

    @DisplayName("Выбор фильтра Открытый вебинар")
    public EventsPage selectWebinarOpeningFilter() {
        WebElement testingButton = waiter(EVENT_BUTTON);
        testingButton.click();
        WebElement testingFilterButton = waiter(FILTER_OPEN_WEBINAR);
        testingFilterButton.click();
        return this;
    }

    @DisplayName("Отображаются только карточки с типом Открытый вебинар")
    public EventsPage cardsWithTypeOpenWebinar() {
        List<WebElement> typeCards = driver.findElements(TYPE_CARDS_ON_PAGE);
        for (WebElement card : typeCards) {
            Assertions.assertEquals("Открытый вебинар", card.getText().trim(),
                    "Один из типов карточек не соответствует 'Открытый вебинар'");
        }
        return this;
    }

    @DisplayName("Дата проведения мероприятий больше или равна текущей")
    public EventsPage eventVerificationDateGreaterOrEqualCurrentOne() {
        List<WebElement> dateElements = driver.findElements(DATE_EVENTS);
        MonthDay currentMonthDay = MonthDay.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM", new Locale("ru"));

        System.out.println("Текущая дата (день и месяц): " + currentMonthDay);

        for (WebElement dateElement : dateElements) {
            String dateText = dateElement.getText().trim();
            System.out.println("Найденная дата на сайте: " + dateText);

            MonthDay eventMonthDay;
            try {
                eventMonthDay = MonthDay.parse(dateText, formatter);
                System.out.println("Преобразованная дата для сравнения: " + eventMonthDay);
            } catch (Exception e) {
                throw new RuntimeException("Невозможно разобрать дату: " + dateText, e);
            }

            Assertions.assertFalse(eventMonthDay.isBefore(currentMonthDay),
                    "Дата мероприятия " + eventMonthDay.format(formatter) + " меньше текущей даты.");
        }
        return this;
    }
}
