import models.User;
import clients.UserClient;
import com.codeborne.selenide.Configuration;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pageObjects.AccountPage;
import pageObjects.MainPageStellarBurger;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class LogoutTest {

    MainPageStellarBurger mainPage = open(MainPageStellarBurger.MAIN_PAGE_URL, MainPageStellarBurger.class);
    AccountPage accountPage = page(AccountPage.class);
    User user;
    UserClient userClient;
    String accessToken;
    // авторизация перед тестом
    @Before
    public void authorizationBeforeTest() {
        Configuration.startMaximized = true;
        userClient = new UserClient();
        user = User.getRandom();
        accessToken = userClient.createUser(user);

        mainPage.clickAccountButtonInHeader()
                .authorization(user.getEmail(), user.getPassword())
                .clickAccountButtonInHeader();
    }

    @After
    public void tearDown() {
        if (accessToken != null) {
            userClient.deleteUser(accessToken);
        }
    }

    @DisplayName("Проверка логаута")
    @Test
    public void logoutTest() {
        Assert.assertTrue("Ошибка логаута", accountPage.clickExitButton()
                .isEnterButtonVisible());
    }
}