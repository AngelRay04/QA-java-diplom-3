package pageObjects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class RegistrationPage extends HeaderElements {
    // поле Имя
    @FindBy(how = How.XPATH, using = "//fieldset[1]//input")
    private SelenideElement nameField;
    // поле email
    @FindBy(how = How.XPATH, using = "//fieldset[2]//input")
    private SelenideElement emailField;
    // поле Пароль
    @FindBy(how = How.XPATH, using = ".//input[@name='Пароль']")
    private SelenideElement passwordField;
    // кнопка Зарегистрироваться
    @FindBy(how = How.XPATH, using = ".//button[text()='Зарегистрироваться']")
    private SelenideElement registrationButton;
    // нотификация Некорректный пароль
    @FindBy(how = How.XPATH, using = ".//p[text()='Некорректный пароль']")
    private SelenideElement errorNotification;
    // кнопка Войти
    @FindBy(how = How.XPATH, using = ".//a[text()='Войти']")
    private SelenideElement loginLink;

    @Step("Проверка отображения нотификации \"Некорректный пароль\"")
    public boolean isErrorNotificationVisible() {
        return errorNotification.isDisplayed();
    }

    @Step("Нажатие кнопки \"Войти\" на странице регистрации")
    public SignInPage clickLoginLink() {
        loginLink.click();
        return page(SignInPage.class);
    }

    @Step("Регистрация пользователя")
    public void registration(String name, String email, String password) {
        nameField.setValue(name);
        emailField.setValue(email);
        passwordField.setValue(password);
        registrationButton.click();
    }
}