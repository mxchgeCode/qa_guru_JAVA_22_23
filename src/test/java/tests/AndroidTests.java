package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;

public class AndroidTests extends TestBase {

    @DisplayName("Проверка наличия элементов в результатах поиска")
    @Test
    @Tag("android")
    void verifyNumberOfSearchResultTest() {
        step("Ввести в строку поиска значение Appium", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Appium");
        });
        step("Проверить, что количество найденных элементов больше нуля", () ->
                $$(id("org.wikipedia.alpha:id/page_list_item_title"))
                        .shouldHave(sizeGreaterThan(0)));
    }

    @DisplayName("Проверка наличия в меню кнопки логина и её текста")
    @Test
    @Tag("android")
    void verifyLoginButtonTextTest() {
        step("Нажать на кнопку с тремя точками", () -> {
            $(id("org.wikipedia.alpha:id/menu_overflow_button")).click();
        });
        step("Проверить наличие кнопки логина", () ->
                $(id("org.wikipedia.alpha:id/explore_overflow_account_name"))
                        .should(exist)
                        .shouldHave(text("Log in to Wikipedia"))
        );
    }

    @DisplayName("Проверка открытия статьи в википедии")
    @Test
    @Tag("android")
    void verifyOpenArticleTest() {
        step("Нажать на кнопку поиска 1", () -> {
            $(id("android.widget.TextView")).click();
        });

        step("Нажать на кнопку поиска 2", () -> {
            $(id("android.widget.EditText")).click();
        });
    }

}
