package tvoe.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.aeonbits.owner.ConfigFactory;

import tvoe.tests.config.WebDriverProvider;
import tvoe.tests.config.WebDriverConfig;
import tvoe.tests.helpers.Attach;



public class TestBase {

    private static WebDriverConfig config;
    private static WebDriverProvider configuration;

    @BeforeAll
    static void setUp() {

        config = ConfigFactory.create(WebDriverConfig.class, System.getProperties());
        configuration = new WebDriverProvider();
        configuration.webDriverConfig(config);

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        Configuration.pageLoadTimeout = 60000;
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        Selenide.closeWebDriver();
    }
}