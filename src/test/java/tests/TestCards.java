package tests;

import data.LoginFormData;
import data.PathToFile;
import org.testng.annotations.Test;
import steps.Steps;
import steps.StepsAsserts;

public class TestCards extends BaseTest {
    private static Steps steps = new Steps();
    private static StepsAsserts asserts = new StepsAsserts();

    @Test
    public void cardsTest() {
        steps.openMainPage();
        asserts.isMainPageOpen();

        steps.goToTheNextPage();
        asserts.isFirstCardOpen();

        String password = LoginFormData.password();
        String email = password.charAt(0) + LoginFormData.email();
        String domain = LoginFormData.domain();
        steps.enterDataInLoginForm(password, email, domain);
        asserts.isSecondCardOpen();

        int quantityOfInterests = 2;
        steps.uploadAvatarChoseInterests(PathToFile.PATH_TO_AVATAR.getPath(), quantityOfInterests);
        asserts.isThirdCardNotOpen();
    }
}