package tvoe.tests.ui.PageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RegistrationObject {
    private SelenideElement
            loginButton = $(".header__profile a"),
            registrationButton = $(".register "),
            registrationConfirmationButton = $(".loyalty-button--reg"),
            nameField = $("#NAME"),
            phoneField = $("#PHONE"),
            emailField = $("#EMAIL"),
            birthdayField =  $(By.xpath("//label[@for='BIRTHDAY']")),
            genderChoose = $(By.xpath("//label[@for='GENDER_M']")),
            personalDataAgreement = $(By.xpath("//label[@for='PERSONAL_DATA']")),
            registrationSubmitButton = $(By.xpath("//label[@for='reg-submit']")),
            registrationCodePage = $(By.xpath("//label[@for='CONFIRM_CODE']"));

    public RegistrationObject clickToLoginButton (){
        loginButton.click();

        return this;
    }

    public RegistrationObject clickToRegistrationButtons(){
        registrationButton.click();
        registrationConfirmationButton.click();

        return this;
    }

    public RegistrationObject setName (String value) {
        nameField.setValue(value);

        return this;

    }

    public RegistrationObject setPhoneNumber (String value) {
        phoneField.setValue(value);

        return this;

    }

    public RegistrationObject setEmailField (String value) {
        emailField.setValue(value);

        return this;
    }

    public RegistrationObject setBirthdayField (){
        birthdayField.click();
        Selenide.executeJavaScript("arguments[0].value = '1990-03-03';", $("#BIRTHDAY"));

        return this;
    }

    public RegistrationObject chooseGender(){
        genderChoose.click();

        return this;
    }

    public RegistrationObject applyPersonalDataAgreement() {
        personalDataAgreement.click();

        return this;
    }

    public RegistrationObject clickRegistrationSubmitButton () {
        registrationSubmitButton.click();

        return this;
    }

    public RegistrationObject checkResults () {
        registrationCodePage.shouldBe(Condition.visible);
        assertThat(url()).isEqualTo(baseUrl+"tvoeloyalty/?register=yes&backurl=%2Fauth%2F#loyalty-reg");

        return this;
    }

}
