package qa.guru.allure.homework.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.linkText;

public class SearchRepositoryResultsPage {
    @Step("Click on repository link {repo}")
    public SearchRepositoryResultsPage clickOnRepositoryLink(String repo) {
        $(linkText(repo)).click();
        return this;
    }
}
