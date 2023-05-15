package pages;

import aquality.selenium.forms.Form;
import org.openqa.selenium.By;


public class ThirdCard extends Form {
    private static final By UNIQUE_ELEMENT_THIRD_CARD = By.className("personal-details");

    private static final String UNIQUE_ELEMENT_NAME_THIRD_CARD = "Unique element - Personal details";

    public ThirdCard() {
        super(UNIQUE_ELEMENT_THIRD_CARD, UNIQUE_ELEMENT_NAME_THIRD_CARD);
    }
}