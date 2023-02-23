package tvoe.tests.ui;

import org.junit.jupiter.api.Test;
import tvoe.tests.TestBase;
import tvoe.tests.ui.PageObjects.FiltersObject;
import tvoe.tests.ui.PageObjects.MainPageObject;

import static com.codeborne.selenide.Configuration.baseUrl;


public class FiltersTest extends TestBase {

    @Test
    void testFilters() {
        new MainPageObject().openPage(baseUrl);
        new FiltersObject()
                .clickToFilterButton()
                .setMinAndMaxPrice("1000","2000")
                .chooseItemSize()
                .chooseItemColor()
                .clickToSubmitButton()
                .checkResults();

    }
}





