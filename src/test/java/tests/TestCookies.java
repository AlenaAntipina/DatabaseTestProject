package tests;

import org.testng.annotations.Test;
import steps.Steps;
import steps.StepsAsserts;

public class TestCookies extends BaseTest {
    private Steps steps = new Steps();
    private StepsAsserts asserts = new StepsAsserts();

    @Test
    public void cookiesTest() {
        steps.openMainPage();
        asserts.isMainPageOpen();

        steps.goToTheNextPage();
        asserts.isFirstCardOpen();

        steps.acceptCookies();
        asserts.isCookiesFormClosed();
    }
}


