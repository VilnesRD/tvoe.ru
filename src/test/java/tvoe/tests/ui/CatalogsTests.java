package tvoe.tests.ui;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import tvoe.tests.TestBase;
import tvoe.tests.ui.PageObjects.MainPageObject;

import static com.codeborne.selenide.Condition.text;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;

public class CatalogsTests extends TestBase {
    @CsvFileSource (resources = "/womanGeneralCatalog.csv")
    @ParameterizedTest
    void testWomanGeneralCatalog(String categoryName, String categoryTitle) {
        new MainPageObject().openPage(baseUrl);
        $$("li.menu__item--open a").filterBy(text(categoryName)).first().click();
        $(".top-block__page-title").shouldHave(text(categoryTitle));

    }

}
