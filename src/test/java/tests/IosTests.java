package tests;

import com.codeborne.selenide.Condition;
import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class IosTests extends TestBase {
    @Test
    @Tag("ios")
    void verifyMainPageElementsExistingTest() {
        step("Проверка отображения элементов на главной странице", () -> {
            $(AppiumBy.className("XCUIElementTypeStaticText")).$(AppiumBy.name("UI Elements")).should(exist);
            $(AppiumBy.name("Text Button")).shouldBe(Condition.visible);
            $(AppiumBy.name("Text")).shouldBe(Condition.visible);
            $(AppiumBy.name("Tab Bar")).should(exist);
            $(AppiumBy.name("Web View")).should(exist);
            $(AppiumBy.name("Local Testing")).should(exist);
        });
    }
}
