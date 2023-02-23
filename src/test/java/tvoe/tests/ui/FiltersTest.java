package tvoe.tests.ui;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import tvoe.tests.TestBase;
import tvoe.tests.helpers.PopupHandler;

import java.time.Duration;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FiltersTest extends TestBase {

    @Test
    void testFilters() {
        openPage(baseUrl+"catalog/mujchinam/odejda/");
        $(".filters").shouldBe(Condition.visible).click();
        $$(".price-range__value-block input").first().setValue("1000");
        $$(".price-range__value-block input").last().setValue("2000");
        $(By.xpath("//label[@for='chk-47-3']")).click();
        $(By.xpath("//label[@for='chk-49-2231']")).click();
        $(".filters__buttons-block").shouldBe(Condition.visible, Duration.ofSeconds(7));
        $$("div.filters__footer button.filters__button--apply").first().shouldBe(Condition.visible,Duration.ofSeconds(5)).doubleClick();
        new PopupHandler().closeAllPopups();
        assertThat(url()).isEqualTo(baseUrl+"catalog/mujchinam/odejda/?price_from=1000&price_to=2000&size=3&size=2231");
    }
}





