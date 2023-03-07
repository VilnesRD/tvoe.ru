package tvoe.tests.ui;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;
import tvoe.tests.ui.PageObjects.MainPageObject;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;


import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.testng.AssertJUnit.assertEquals;

public class LinksTests {
    private static Stream<Arguments> buttonProvider() {
        return Stream.of(
                Arguments.of("a[href='https://apps.apple.com/us/app/твое/id1624034458'", "https://apps.apple.com/us/app/твое/id1624034458"),
                Arguments.of("a[href='https://play.google.com/store/apps/details?id=ru.tvoe.android'", "https://play.google.com/store/apps/details?id=ru.tvoe.android")
        );
    }

    @ParameterizedTest
    @MethodSource("buttonProvider")
    @DisplayName("Проверка перехода в digital store")
    void checkThatLinksToDigitalStoreWorks(String buttonSelector, String expectedUrl) {
        new MainPageObject().openPage(baseUrl);
        $(buttonSelector).click();
        String actualUrl = url();
        assertEquals(expectedUrl, actualUrl);
    }

}
