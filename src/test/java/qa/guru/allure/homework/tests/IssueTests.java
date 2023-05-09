package qa.guru.allure.homework.tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import qa.guru.allure.homework.pages.MainPage;
import qa.guru.allure.homework.pages.RepositoryPage;
import qa.guru.allure.homework.pages.SearchRepositoryResultsPage;


import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

@Feature("Issue in repository")
@Story("Displaying an Issue in the Issue Tab")
@Owner("MargaritaMalakhova")
@Severity(SeverityLevel.BLOCKER)
@Link(value = "Testing", url = "https://github.com")
@DisplayName("Check Issue Number on Issue Page")

public class IssueTests extends TestBase {

    MainPage mainPage = new MainPage();
    SearchRepositoryResultsPage searchRepositoryResultsPage = new SearchRepositoryResultsPage();
    RepositoryPage repositoryPage = new RepositoryPage();
    private static final String REPOSITORY = "MargaritaMalakhova/qa_guru_files";
    private static final int ISSUE = 1;

    @BeforeEach
    public void beforeEach() {
        open("");
    }
    @Test
    public void checkIssueNumberTest() {
        $(".header-search-input").setValue(REPOSITORY).pressEnter();
        $(linkText(REPOSITORY)).click();
        $("#issues-tab").click();
        $(withText("#" + ISSUE)).should(Condition.exist);
    }

    @Test
    public void checkIssueNumberTestWithLambdaStep() {
        step("Search Repository " + REPOSITORY, () -> {
            $(".header-search-input").setValue(REPOSITORY).pressEnter();
        });
        step("Click on repository link " + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
        });
        step("Open tab Issues", () -> {
            $("#issues-tab").click();
        });
        step("Check on page Issue with number " + ISSUE, () -> {
            $(withText("#" + ISSUE)).should(Condition.exist);
        });
    }
    @Test
    public void checkIssueNumberTestWithAnnotatedSteps() {
        mainPage.searchRepository(REPOSITORY);
        searchRepositoryResultsPage.clickOnRepositoryLink(REPOSITORY);
        repositoryPage.openIssuesTab();
        repositoryPage.shouldSeeIssueWithNumber(ISSUE);
    }
}
