import models.User;
import io.qameta.allure.junit4.DisplayName;
import org.junit.*;
import pageObjects.*;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;


public class RegistrationTest {
    MainPageStellarBurger mainPage = open(MainPageStellarBurger.MAIN_PAGE_URL, MainPageStellarBurger.class);
    SignInPage signInPage = page(SignInPage.class);
    RegistrationPage registrationPage = page(RegistrationPage.class);
    User user;

    @Before
    public void setUp() {
        user = User.getRandom();
    }

    @DisplayName("Регистрация с корректным паролем")
    @Test
    public void successRegistrationWithCorrectPasswordTest() {
        mainPage.clickAccountButtonInHeader().clickRegistrationLink().registration(user.getName(), user.getEmail(), user.getPassword());
        Assert.assertTrue("Ошибка регистрации", signInPage.isEnterButtonVisible());
    }

    @DisplayName("Регистрация с коротким паролем меньше 6 символов")
    @Test
    public void failRegistrationWithIncorrectPasswordTest() {
        mainPage.clickAccountButtonInHeader().clickRegistrationLink().registration(user.getName(), user.getEmail(), user.getIncorrectPassword());
        Assert.assertTrue("Нотификация \"Некорректный пароль\" отсутствует", registrationPage.isErrorNotificationVisible());
    }
}