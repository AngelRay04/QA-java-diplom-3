import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pageObjects.MainPageStellarBurger;

import static com.codeborne.selenide.Selenide.open;

public class ConstructorTest {

    MainPageStellarBurger mainPage = open(MainPageStellarBurger.MAIN_PAGE_URL, MainPageStellarBurger.class);

    @Before
    public void setUp() {
        Configuration.startMaximized = true;
    }

    @After
    public void tearDown() {
        Selenide.closeWebDriver();
    }

    @DisplayName("Проверка перехода в таб \"Булки\"")
    @Test
    public void openBunsTabTest() {
        mainPage.clickSauceButton()
                .clickBunsButton()
                .isBunTabSelected();
    }

    @DisplayName("Проверка перехода в таб \"Соусы\"")
    @Test
    public void openSauceTabTest() {
        mainPage.clickSauceButton()
                .isSauceTabSelected();
    }

    @DisplayName("Проверка перехода в таб \"Начинки\"")
    @Test
    public void openFillingsTabTest() {
        mainPage.clickFillingsButton()
                .isFillingsTabSelected();
    }

}