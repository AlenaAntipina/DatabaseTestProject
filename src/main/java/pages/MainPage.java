package pages;

import aquality.selenium.elements.interfaces.ILink;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class MainPage extends Form {
    private static final By UNIQUE_ELEMENT_ON_MAIN_PAGE = By.xpath("//*[contains(@class,'start view')]");

    private static final String UNIQUE_ELEMENT_NAME_ON_MAIN_PAGE = "Unique element on Main page";

    private final ILink LINK_NEXT_PAGE = getElementFactory().getLink(By.className("start__link"), "LINK - Please click HERE to GO to the next page");

    public MainPage() {
        super(UNIQUE_ELEMENT_ON_MAIN_PAGE, UNIQUE_ELEMENT_NAME_ON_MAIN_PAGE);
    }

    public void clickNextPageLink() {
        LINK_NEXT_PAGE.click();
    }
}