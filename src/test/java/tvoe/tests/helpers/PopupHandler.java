package tvoe.tests.helpers;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class PopupHandler {
    public void closePopup(SelenideElement popup) {
        if (popup.isDisplayed()) {
            popup.click();
        }
    }

    public void closeAllPopups() {
        closePopup($(".popup__close"));
        closePopup($(By.id("digi-shield")));
        closePopup($(By.id("digi-search")));
        closePopup($(By.className("filters__popup--active")));
        closePopup($(By.className("popmechanic-snippet")));
        closePopup($(By.className("popmechanic-css-56584")));
    }
}