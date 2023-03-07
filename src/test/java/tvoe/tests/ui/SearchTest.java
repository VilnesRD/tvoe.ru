package tvoe.tests.ui;

import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tvoe.tests.TestBase;
import tvoe.tests.ui.PageObjects.PopupCloser;
import tvoe.tests.ui.PageObjects.SearchOpject;

import java.util.Random;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class SearchTest extends TestBase {

    private final String[] keywords = {"Футболка", "Джинсы", "Шапка"};
    @Test
    @DisplayName("Проверка корректности работы поиска по сайту")
    @Step
    void searchTest () {
        Random rand = new Random();
        String keyword = keywords[rand.nextInt(keywords.length)];
        step("Открываем главную страницу", () -> {
            open(baseUrl);
            new PopupCloser().closePopup();
        });
        step("Вводим в поле поиска одно из keywords", () -> {
            new SearchOpject()
                .clickToSearchButton()
                .setItemName(keyword)
                .showAllResults();});
        step("Проверяем, что все результаты поиска содержат keyword", () -> {new SearchOpject()
                .checkResults(keyword);});

    }
}
