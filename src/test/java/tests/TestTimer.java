package tests;

import org.testng.annotations.Test;
import steps.Steps;
import steps.StepsAsserts;

public class TestTimer extends BaseTest {
    private Steps steps = new Steps();
    private StepsAsserts asserts = new StepsAsserts();

    @Test
    public void timerTest() {
        steps.openMainPage();
        asserts.isMainPageOpen();

        steps.goToTheNextPage();
        asserts.isTimerNull();
    }
}
