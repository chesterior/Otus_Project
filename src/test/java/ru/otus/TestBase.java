package ru.otus;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class TestBase {

    protected WebDriver driver;

    public void setupImplicitWait() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    static final String PAGE_URL = "https://otus.ru/";


    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver", "/Users/a.safronov/Downloads/chromedriver-mac-arm64/chromedriver");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        setupImplicitWait();
        driver.manage().window().maximize();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
