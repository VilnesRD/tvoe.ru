package tvoe.tests.ui.PageObjects;


import tvoe.tests.helpers.PopupHandler;

import static com.codeborne.selenide.Selenide.*;


public class MainPageObject {

    public MainPageObject openPage(String url) {
        open(url);
        new PopupHandler().closeAllPopups();
        executeJavaScript("window.sessionStorage.clear();");
        return this;
    }

}
