import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HeaderElements {

    // кнопка "Личный кабиент"
    @FindBy(how = How.XPATH, using = ".//a[@href='/account']")
    private SelenideElement accountButtonInHeader;
    // кнопка Конструктор
    @FindBy(how = How.XPATH, using = ".//p[text()='Конструктор']")
    private SelenideElement constructorButton;
    // логотип Stellar Burger
    @FindBy(how = How.CLASS_NAME, using = "AppHeader_header__logo__2D0X2")
    private SelenideElement stellarBurgerLogo;

    @Step("Нажатие на кнопку \"Личный кабинет\" в хедере страницы")
    public SignInPage clickAccountButtonInHeader() {
        accountButtonInHeader.click();
        return Selenide.page(SignInPage.class);
    }

    @Step("Проверка отображения кнопки \"Личный кабинет\" в хедере страницы")
    public Boolean checkVisibilityAccountButton() {
        return accountButtonInHeader.isDisplayed();
    }

    @Step("Нажатие на логотип Stellar Burger")
    public MainPageStellarBurger clickStellarBurgerLogo() {
        stellarBurgerLogo.shouldBe(Condition.visible);
        stellarBurgerLogo.click();
        return Selenide.page(MainPageStellarBurger.class);
    }

    @Step("Нажатие на кнопку \"Конструктор\"")
    public MainPageStellarBurger clickConstructorButton() {
        constructorButton.click();
        return Selenide.page(MainPageStellarBurger.class);
    }
}