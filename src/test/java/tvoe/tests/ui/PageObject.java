package tvoe.tests.ui;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class PageObject {
    private SelenideElement
    loginButton = $(".header__profile a"),
    registrationButton = $(".register "),
    registrationConfirmationButton = $(".loyalty-button--reg"),
    nameField = $("#NAME"),
    phoneField = $("#PHONE"),
    emailField = $("#EMAIL"),
    birthdayField = $("#BIRTHDAY"),
    genderChoose = $("#GENDER_M"),
    personalDataAgreement = $("#PERSONAL_DATA"),
    registrationSubmitButton = $("#reg-submit");

}

