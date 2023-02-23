package tvoe.tests.ui.PageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import tvoe.tests.helpers.PopupHandler;

import java.time.Duration;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FiltersObject {

    private SelenideElement
    filterButton = $(".filters"),
    lowPrice = $$(".price-range__value-block input").first(),
    maxPrice = $$(".price-range__value-block input").last(),
    itemSize =  $(By.xpath("//label[@for='chk-47-3']")),
    itemColor =  $(By.xpath("//label[@for='chk-49-2231']")),
    submitButton = $$("div.filters__footer button.filters__button--apply").first();

    public FiltersObject clickToFilterButton (){
        filterButton.shouldBe(Condition.visible).click();

        return this;
    }

    public FiltersObject setMinAndMaxPrice (String value_1, String value_2) {
        lowPrice.setValue(value_1);
        maxPrice.setValue(value_2);

        return this;
    }

    public FiltersObject chooseItemSize (){
        itemSize.click();

        return this;
    }

    public FiltersObject chooseItemColor (){
        itemColor.click();

        return this;
    }

    public FiltersObject clickToSubmitButton () {
        $(".filters__buttons-block").shouldBe(Condition.visible, Duration.ofSeconds(7));
        submitButton.click();
        new PopupHandler().closeAllPopups();

        return this;
    }

    public FiltersObject checkResults () {
        assertThat(url()).isEqualTo(baseUrl+"catalog/mujchinam/odejda/?price_from=1000&price_to=2000&size=3&size=2231");

        return this;
    }
}
