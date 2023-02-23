package tvoe.tests.ui;


import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import tvoe.tests.TestBase;
import tvoe.tests.ui.PageObjects.MainPageObject;
import tvoe.tests.ui.PageObjects.RegistrationObject;

import java.util.Locale;

import static com.codeborne.selenide.Configuration.baseUrl;


public class RegistrationTest extends TestBase {

    Faker faker = new Faker(new Locale("ru"));
    String name = faker.name().firstName(),
            number = faker.phoneNumber().cellPhone(),
            email = "test_test@test.ru";


    @Test
    void successfulRegistration() {
        new MainPageObject().openPage(baseUrl);
        new RegistrationObject().clickToLoginButton()
                .clickToRegistrationButtons()
                .setName(name)
                .setPhoneNumber(number)
                .setEmailField(email)
                .setBirthdayField()
                .chooseGender()
                .applyPersonalDataAgreement()
                .clickRegistrationSubmitButton();
        new RegistrationObject().checkResults();

    }

}
