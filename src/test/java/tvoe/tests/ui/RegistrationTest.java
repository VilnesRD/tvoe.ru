package tvoe.tests.ui;


import com.github.javafaker.Faker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import tvoe.tests.TestBase;
import tvoe.tests.ui.PageObjects.MainPageObject;
import tvoe.tests.ui.PageObjects.RegistrationObject;

import java.util.Locale;

import static com.codeborne.selenide.Configuration.baseUrl;
import static io.qameta.allure.Allure.step;


public class RegistrationTest extends TestBase {

    Faker faker = new Faker(new Locale("ru"));
    String name = faker.name().firstName(),
            number = faker.phoneNumber().cellPhone().replaceAll("8", ""),
            email = "test_test@test.ru";


    @Test
    @DisplayName("Проверка регистрации")
    void successfulRegistration() {
        step("Открываем главную страницу", () -> {
            new MainPageObject()
                    .openPage(baseUrl);
        });
        step("Вводин данные нового пользователя", () -> {
            new RegistrationObject().clickToLoginButton()
                    .clickToRegistrationButtons()
                    .setName(name)
                    .setPhoneNumber(number)
                    .setEmailField(email)
                    .setBirthdayField()
                    .chooseGender()
                    .applyPersonalDataAgreement()
                    .clickRegistrationSubmitButton();
        });
        step("Проверяем что пользователя перенаправили на правильную страницу", () -> {
            new RegistrationObject().checkResults();
        });
    }
}

