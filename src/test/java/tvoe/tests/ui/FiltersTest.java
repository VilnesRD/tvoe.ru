package tvoe.tests.ui;

import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tvoe.tests.TestBase;
import tvoe.tests.ui.PageObjects.FiltersObject;
import tvoe.tests.ui.PageObjects.PopupCloser;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;


public class FiltersTest extends TestBase {

    @Test
    @DisplayName("Проверка работы фильтров на сайте")
    @Step
    void testFilters() {
        step("Открываем главную страницу", () -> {
            open(baseUrl);
            new PopupCloser().closePopup();});
        step("Выбираем необходимые фильтры", () -> {new FiltersObject()
                .clickToFilterButton()
                .setMinAndMaxPrice("1000","2000")
                .chooseItemSize()
                .chooseItemColor()
                .clickToSubmitButton();});
        step("Проверяем что на странице отображаются товары только соответствующие поиску", () -> {
            new FiltersObject().checkResults();});

    }
}





