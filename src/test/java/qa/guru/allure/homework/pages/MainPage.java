package qa.guru.allure.homework.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    SelenideElement searchInput = $(".header-search-input");
    @Step("Search Repository {repo}")
    public MainPage searchRepository(String repo) {
        searchInput.setValue(repo).pressEnter();

        return this;
    }
}
