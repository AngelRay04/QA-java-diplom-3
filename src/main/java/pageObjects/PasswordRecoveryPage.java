package pageObjects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class PasswordRecoveryPage extends HeaderElements {
    // ссылка Войти
    @FindBy(how = How.XPATH, using = ".//a[text()='Войти']")
    private SelenideElement enterButtonOnRecoveryPage;

    @Step("Нажатие на кнопку \"Войти\" на странице восстановления пароля")
    public SignInPage clickEnterButtonOnRecoveryPage() {
        enterButtonOnRecoveryPage.click();
        return page(SignInPage.class);
    }
}