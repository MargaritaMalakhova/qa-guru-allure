package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

public class RepositoryPage {
    private SelenideElement issueTab = $("#issues-tab");

    @Step("Open tab Issues")
    public RepositoryPage openIssuesTab() {
        issueTab.click();
        return this;
    }

    @Step("Check on page Issue with number {issue}")
    public RepositoryPage shouldSeeIssueWithNumber(int issue) {
        $(withText("#" + issue)).should(Condition.exist);
        return this;
    }
}
