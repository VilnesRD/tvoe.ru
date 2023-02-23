package tvoe.tests.ui;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import tvoe.tests.TestBase;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RegistrationTest extends TestBase {

    @Test
    void successfulRegistration() {
        openPage(baseUrl);// Открываем главную
        $(".header__profile a").click(); // Нажимаем на кнопку "Войти"
        $(".register ").click(); // Нажимаем на кнопку "Регистрация"
        $(".loyalty-button--reg").click();// Нажимаем на кнопку "Зарегистрироваться"
        $("#NAME").setValue("Иван"); // Вводим имя
        $("#PHONE").setValue("+791363022886"); // Вводим телефон
        $("#EMAIL").setValue("tr@tr.eo"); // Вводим email
        $(By.xpath("//label[@for='BIRTHDAY']")).click(); // Встаем на поле выбора даты рождения
        Selenide.executeJavaScript("arguments[0].value = '1990-03-03';", $("#BIRTHDAY"));// Вводим дату рождения
        $(By.xpath("//label[@for='GENDER_M']")).click(); // Выбираем мужской пол
        $(By.xpath("//label[@for='PERSONAL_DATA']")).click(); //Соглашаемся с обработкой персональных данных
        $(By.xpath("//label[@for='reg-submit']")).click(); // Нажимаем на кнопку "Зарегистрироваться"
        assertThat(url()).isEqualTo("https://tvoe.ru/tvoeloyalty/?register=yes&backurl=%2Fauth%2F#loyalty-reg"); // Проверяем, что мы перешли на страницу с подтверждением регистрации

    }

}
