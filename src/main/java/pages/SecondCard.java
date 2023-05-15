package pages;

import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ICheckBox;
import aquality.selenium.elements.interfaces.IElement;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import pages.data.Interest;
import utils.RandomUtils;
import utils.RobotUtils;

import java.io.File;
import java.util.List;

public class SecondCard extends Form {
    private static final By UNIQUE_ELEMENT_SECOND_CARD = By.className("avatar-and-interests__form");

    private static final String UNIQUE_ELEMENT_NAME_SECOND_CARD = "Unique element - Avatar and interests form";

    private final IButton UPLOAD_AVATAR_BUTTON = getElementFactory().getButton(By.className("avatar-and-interests__upload-button"), "Upload avatar");

    private final ICheckBox INTERESTS_CHECKBOX = getElementFactory().getCheckBox(By.className("avatar-and-interests__interests-list"), "Interests Checkbox");

    private final By INTERESTS_ITEMS = By.xpath(".//span[contains(@class,'checkbox small')]");

    private final By INTERESTS_ITEMS_TEXT = By.xpath(".//span[contains(@class,'checkbox small')]/../span[not(@*)]");

    private final ICheckBox UNSELECT_ALL_INTERESTS = getElementFactory().getCheckBox(By.xpath("//div[contains(.,'Unselect all')]/span[contains(@class,'checkbox')]"), "Checkbox Unselect All");

    private final IButton NEXT_BUTTON = getElementFactory().getButton(By.xpath("//button[contains(@class,'button--stroked button--white')]"), "Next Button");

    public SecondCard() {
        super(UNIQUE_ELEMENT_SECOND_CARD, UNIQUE_ELEMENT_NAME_SECOND_CARD);
    }

    public void clickUploadAvatarButton(String pathToFile) {
        String path = new File(pathToFile).getAbsolutePath();
        UPLOAD_AVATAR_BUTTON.click();
        RobotUtils.uploadFile(path);
    }

    public void choseInterests(int quantityOfInterests) {
        UNSELECT_ALL_INTERESTS.click();
        List<IElement> listCheckboxes = INTERESTS_CHECKBOX.findChildElements(INTERESTS_ITEMS, ElementType.CHECKBOX);
        List<IElement> listTexts = INTERESTS_CHECKBOX.findChildElements(INTERESTS_ITEMS_TEXT, ElementType.TEXTBOX);
        int i = 0;
        String firstNotSelected = "Select all";
        String secondNotSelected = "Unselect all";
        while (i != quantityOfInterests){
            int index = RandomUtils.getRandomIndex(listCheckboxes.size());
            if (!listTexts.get(index).getText().equals(firstNotSelected)
                    && !listTexts.get(index).getText().equals(secondNotSelected)){
                listCheckboxes.get(index).click();
                i++;
            }
        }
    }

    public void clickNextButton() {
        NEXT_BUTTON.click();
    }
}
