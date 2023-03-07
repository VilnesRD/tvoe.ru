package tvoe.tests.ui.PageObjects;


import tvoe.tests.helpers.PopupHandler;

import static com.codeborne.selenide.Selenide.*;


public class PopupCloser {

    public PopupCloser closePopup() {
        new PopupHandler().closeAllPopups();
        executeJavaScript("window.sessionStorage.clear();");
        return this;
    }

}
