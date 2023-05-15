package tests;

import org.testng.annotations.Test;
import steps.Steps;
import steps.StepsAsserts;

public class TestHelpForm extends BaseTest {
    private Steps steps = new Steps();
    private StepsAsserts asserts = new StepsAsserts();

    @Test
    public void helpFormTest() {
        steps.openMainPage();
        asserts.isMainPageOpen();

        steps.goToTheNextPage();
        asserts.isFirstCardOpen();

        steps.hideHelpForm();
        asserts.isHelpFormHide();
    }

}