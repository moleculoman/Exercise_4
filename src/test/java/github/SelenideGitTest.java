package github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class SelenideGitTest {
    @BeforeAll
    static void settingsForBrowser() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://github.com/";
        Configuration.pageLoadStrategy = "eager";
    }

        @Test
        @DisplayName("Тест на наличие кода на странице Soft assertions")
        public void findCodeForJUnitInSoftAssertionsTest() {
            open("selenide/selenide");
            $("#wiki-tab").shouldBe(visible).click(); //самый быстрый и точный вариант поиска
            //$("div").$$("a").findBy(text("Wiki")).click(); //поиск по всем тегам А - медленный и зависимый от обстоятельств (доп. вариант)
            $$("a.internal.present").findBy(text("Soft assertions")).shouldBe(visible).click(); //проверка на наличие вкладки
            $("div").shouldHave(partialTextCaseSensitive("Using JUnit5 extend test class:")); // проверка содержимого вкладки

    }
}