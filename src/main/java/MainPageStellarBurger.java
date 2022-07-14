import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;

public class MainPageStellarBurger extends HeaderElements {

    public static final String MAIN_PAGE_URL = "https://stellarburgers.nomoreparties.site";
    public void startUp () {
        Configuration.startMaximized = true;
    }

    // кнопка Войти в аккаунт
    @FindBy(how = How.XPATH, using = ".//button[text()='Войти в аккаунт']")
    private SelenideElement accountButton;
    // кнопка Оформить заказ
    @FindBy(how = How.XPATH, using = ".//button[text()='Оформить заказ']")
    private SelenideElement makeOrderButton;
    // таб Булки
    @FindBy(how = How.XPATH, using = ".//span[text()='Булки']")
    private SelenideElement bunsButton;
    // таб Соусы
    @FindBy(how = How.XPATH, using = ".//span[text()='Соусы']")
    private SelenideElement sauceButton;
    // таб Начинки
    @FindBy(how = How.XPATH, using = ".//span[text()='Начинки']")
    private SelenideElement fillingsButton;
    // название раздела Булки
    @FindBy(how = How.XPATH, using = ".//span[text()='Булки']/..")
    private SelenideElement bunText;
    // название раздела Соусы
    @FindBy(how = How.XPATH, using = ".//span[text()='Соусы']/..")
    private SelenideElement sauceText;
    // название раздела Начинки
    @FindBy(how = How.XPATH, using = ".//span[text()='Начинки']/..")
    private SelenideElement fillingsText;

    @Step("Нажатие на кнопку \"Войти в аккаунт\"")
    public SignInPage clickAccountButton() {
        accountButton.click();
        return Selenide.page(SignInPage.class);
    }

    @Step("Нажатие на кнопку \"Оформить заказ\"")
    public MainPageStellarBurger clickMakeOrderButton() {
        makeOrderButton.click();
        return page(MainPageStellarBurger.class);
    }

    @Step("Проверка отображения кнопки \"Оформить заказ\"")
    public boolean isMakeOrderButtonVisible() {
        makeOrderButton.shouldBe(visible);
        return makeOrderButton.isDisplayed();
    }

    @Step("Переход в таб \"Булки\"")
    public MainPageStellarBurger clickBunsButton() {
        bunsButton.click();
        return page(MainPageStellarBurger.class);
    }

    @Step("Переход в таб \"Соусы\"")
    public MainPageStellarBurger clickSauceButton() {
        sauceButton.click();
        return page(MainPageStellarBurger.class);
    }

    @Step("Переход в таб \"Начинки\"")
    public MainPageStellarBurger clickFillingsButton() {
        fillingsButton.click();
        return page(MainPageStellarBurger.class);
    }

    @Step("Проверка выбора раздела \"Булки\"")
    public void isBunTabSelected() {
        bunText.shouldHave(cssClass("tab_tab_type_current__2BEPc"));
    }

    @Step("Проверка выбора раздела \"Соусы\"")
    public void isSauceTabSelected() {
        sauceText.shouldHave(cssClass("tab_tab_type_current__2BEPc"));
    }

    @Step("Проверка выбора раздела \"Начинки\"")
    public void isFillingsTabSelected() {
        fillingsText.shouldHave(cssClass("tab_tab_type_current__2BEPc"));
    }

}