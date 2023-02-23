package tvoe.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import tvoe.tests.helpers.PopupHandler;

import static com.codeborne.selenide.Selenide.*;

public class TestBase {
    @BeforeAll
    static void setUpAll() {
        Configuration.holdBrowserOpen = true;
        Configuration.browser = "chrome";
    }

    @BeforeEach
    void setUp() {
        Configuration.baseUrl = "https://tvoe.ru/";
        Configuration.pageLoadTimeout = 60000;
    }


}