import com.codeborne.selenide.Configuration;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class LogoutTest {

    MainPageStellarBurger mainPage = open(MainPageStellarBurger.MAIN_PAGE_URL, MainPageStellarBurger.class);
    AccountPage accountPage = page(AccountPage.class);
    String email = "psraisaih@yandex.ru";
    String password = "qwerty";

    // авторизация перед тестом
    @Before
    public void authorizationBeforeTest() {
        Configuration.startMaximized = true;
        mainPage.clickAccountButtonInHeader()
                .authorization(email, password)
                .clickAccountButtonInHeader();
    }

    @DisplayName("Проверка логаута")
    @Test
    public void logoutTest() {
        Assert.assertTrue("Ошибка логаута", accountPage.clickExitButton()
                .isEnterButtonVisible());
    }

}