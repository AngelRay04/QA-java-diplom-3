import clients.UserClient;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import models.User;
import org.junit.*;
import pageObjects.MainPageStellarBurger;

import static com.codeborne.selenide.Selenide.open;

public class LoginTest {
    MainPageStellarBurger mainPage = open(MainPageStellarBurger.MAIN_PAGE_URL, MainPageStellarBurger.class);
    User user;
    UserClient userClient;
    String accessToken;

    @Before
    public void setUp() {
        Configuration.startMaximized = true;
        userClient = new UserClient();
        user = User.getRandom();
        accessToken = userClient.createUser(user);
    }

    @After
    public void tearDown() {
        if (accessToken != null) {
            userClient.deleteUser(accessToken);
        }
        Selenide.closeWebDriver();
    }

    @DisplayName("Логин через кнопку в хедере")
    @Test
    public void successLoginWithButtonInHeader() {
        Assert.assertTrue("Авторизация через кнопку в хедере не выполнена", mainPage.clickAccountButtonInHeader()
                .authorization(user.getEmail(), user.getPassword())
                .isMakeOrderButtonVisible());
    }

    @DisplayName("Логин через кнопку на главной странице")
    @Test
    public void successLoginWithAccountButtonOnMainPage() {
        Assert.assertTrue("Авторизация через кнопку на главной не выполнена", mainPage.clickAccountButton()
                .authorization(user.getEmail(), user.getPassword())
                .isMakeOrderButtonVisible());
    }

    @DisplayName("Логин через кнопку на странице регистрации")
    @Test
    public void successLoginWithButtonOnRegistrationPage() {
        Assert.assertTrue("Авторизация через страницу регистрации не выполнена", mainPage.clickAccountButtonInHeader()
                .clickRegistrationLink()
                .clickLoginLink()
                .authorization(user.getEmail(), user.getPassword())
                .isMakeOrderButtonVisible());
    }

    @DisplayName("Логин через кнопку на странице восстановления пароля")
    @Test
    public void successLoginWithButtonOnRecoveryPage() {
        Assert.assertTrue("Авторизация через страницу восстановления пароля не выполнена", mainPage.clickAccountButtonInHeader()
                .clickPasswordRecoveryLink()
                .clickEnterButtonOnRecoveryPage()
                .authorization(user.getEmail(), user.getPassword())
                .isMakeOrderButtonVisible());
    }

}