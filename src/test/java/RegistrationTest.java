import com.github.javafaker.Faker;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;


public class RegistrationTest {
    static Faker faker = new Faker();
    MainPageStellarBurger mainPage = open(MainPageStellarBurger.MAIN_PAGE_URL, MainPageStellarBurger.class);
    SignInPage signInPage = page(SignInPage.class);
    RegistrationPage registrationPage = page(RegistrationPage.class);

    String name = faker.name().username();
    String email = RandomStringUtils.randomAlphabetic(3) + "@yandex.ru";
    String correctPassword = RandomStringUtils.randomAlphanumeric(6);
    String incorrectPassword = RandomStringUtils.randomAlphanumeric(5);

    @DisplayName("Регистрация с корректным паролем")
    @Test
    public void successRegistrationWithCorrectPasswordTest() {
        mainPage.clickAccountButtonInHeader()
                .clickRegistrationLink()
                .registration(name, email, correctPassword);
        Assert.assertTrue("Ошибка регистрации", signInPage.isEnterButtonVisible());
    }

    @DisplayName("Регистрация с коротким паролем меньше 6 символов")
    @Test
    public void failRegistrationWithIncorrectPasswordTest() {
        mainPage.clickAccountButtonInHeader()
                .clickRegistrationLink()
                .registration(name, email, incorrectPassword);
        Assert.assertTrue("Нотификация \"Некорректный пароль\" отсутствует", registrationPage.isErrorNotificationVisible());
    }
}