package tvoe.tests.ui;

import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import tvoe.tests.TestBase;
import tvoe.tests.ui.PageObjects.MainPageObject;

import static com.codeborne.selenide.Condition.text;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class CatalogsTests extends TestBase {
    @CsvFileSource (resources = "/csvFiles/womanGeneralCatalog.csv")
    @ParameterizedTest
    @DisplayName("Проверка содержания разделов в категориях")
    @Step
    void testWomanGeneralCatalog(String categoryName, String categoryTitle) {
        step("Открываем главную страницу", () -> {new MainPageObject()
                .openPage(baseUrl);});
        step("Выбираем categoryName", () -> {
            $$("li.menu__item--open a").filterBy(text(categoryName)).first().click();});
        step("Проверяем что в выбранной категории есть categoryTitle", () -> {
        $(".top-block__page-title").shouldHave(text(categoryTitle));});

    }

}
