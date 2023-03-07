package tvoe.tests.ui.PageObjects;

import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.assertj.core.api.Assertions.assertThat;

public class SearchOpject {
    private SelenideElement
    searchButton = $$("div.header__right-item").first(),
    searchField =  $("input.digi-search-form__input"),
    showAllResultsButtom = $(".digi-ac-find__button");

    public SearchOpject clickToSearchButton (){
        searchButton.click();

        return this;
    }

    public SearchOpject setItemName (String nameOfItem) {
        $(".digi-search-form__input-block").click();
        searchField.setValue(nameOfItem).pressEnter();
        $(".digi-ac-find__button").shouldBe(visible, Duration.ofSeconds(5)).click();

        return this;
    }

    public SearchOpject showAllResults () {
        showAllResultsButtom.shouldBe(visible, Duration.ofSeconds(5)).click();

        return this;
    }

    public SearchOpject checkResults (String nameOfItem) {
        assertThat($$(".searchResults .result").findBy(text(nameOfItem))).isNotNull();

        return this;
    }

}
