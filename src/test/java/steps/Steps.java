package steps;

import aquality.selenium.core.logging.Logger;
import data.DataForTables;
import database.dao.TestDAOImpl;
import database.table.models.TestModel;
import org.testng.ITestResult;
import pages.FirstCard;
import pages.MainPage;
import pages.SecondCard;

import java.util.List;

public class Steps {
    private MainPage mainPage = new MainPage();
    private FirstCard firstCard = new FirstCard();
    private SecondCard secondCard = new SecondCard();

    public void openMainPage() {
        Logger.getInstance().info("Step: open main page");
    }

    public void goToTheNextPage() {
        Logger.getInstance().info("Step: go to the next page");
        mainPage.clickNextPageLink();
    }

    public void enterDataInLoginForm(String password, String email, String domain) {
        Logger.getInstance().info("Step: fill the login form, accept Terms&Conditions and go to the next card");
        firstCard.inputDataInLoginForm(password, email, domain);
        firstCard.choseDomainFromDropdownList();
        firstCard.acceptTermsAndConditions();
        firstCard.clickNextButton();
    }

    public void uploadAvatarChoseInterests(String path, int quantityOfInterests) {
        Logger.getInstance().info("Step: upload avatar, chose interests and go to the next card");
        secondCard.clickUploadAvatarButton(path);
        secondCard.choseInterests(quantityOfInterests);
        secondCard.clickNextButton();
    }

    public void hideHelpForm() {
        Logger.getInstance().info("Step: hide help form");
        firstCard.clickHelpFormHideButton();
    }

    public void acceptCookies() {
        Logger.getInstance().info("Step: accept cookies");
        firstCard.clickAcceptCookiesButton();
    }

    public void updateTestsInTestTable(List<TestModel> testsForUpdate) {
        TestDAOImpl testDAO = new TestDAOImpl();
        for (TestModel test : testsForUpdate) {
            test.setStatusId(ITestResult.FAILURE);
            test.setName(DataForTables.getNameTestForTest());
            test.setMethodName(DataForTables.getMethodNameForTest());
            testDAO.update(test);
        }
    }
}