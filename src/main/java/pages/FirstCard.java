package pages;

import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ICheckBox;
import aquality.selenium.elements.interfaces.IComboBox;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

import java.util.List;

public class FirstCard extends Form {
    private static final By UNIQUE_ELEMENT_FIRST_CARD = By.className("login-form__container");

    private static final String UNIQUE_ELEMENT_NAME_FIRST_CARD = "Unique element - Login form";

    private final ITextBox INPUT_PASSWORD = getElementFactory().getTextBox(By.xpath("//input[contains(@placeholder,'Password')]"), "Password");

    private final ITextBox INPUT_EMAIL = getElementFactory().getTextBox(By.xpath("//input[contains(@placeholder,'email')]"), "Email");

    private final ITextBox INPUT_DOMAIN = getElementFactory().getTextBox(By.xpath("//input[@placeholder='Domain']"), "Domain");

    private final IButton OPEN_DOMAIN_LIST = getElementFactory().getButton(By.xpath("//span[contains(@class,'icon-chevron-down')]"), "Open list");

    private final IComboBox DROPDOWN_DOMAIN = getElementFactory().getComboBox(By.xpath("//div[@class='dropdown__list-item']"), "Dropdown domain");

    private final ICheckBox CHECKBOX_TERMS_CONDITIONS = getElementFactory().getCheckBox(By.xpath("//span[@class='checkbox__box']/span"), "Checkbox Accept Terms and Conditions");

    private final IButton NEXT_BUTTON = getElementFactory().getButton(By.className("button--secondary"), "Button Next");

    private final IButton HELP_FORM_HIDE_BUTTON = getElementFactory().getButton(By.className("discrete"), "Button to hide help form");

    private final By HELP_FORM_HIDE_LOCATOR = By.xpath("//div[contains(@class,'help-form is-hidden')]");

    private final IButton ACCEPT_COOKIES_BUTTON = getElementFactory().getButton(By.xpath("//button[contains(@class,'button--transparent')]"), "Accept cookies");

    private final By COOKIES_FORM_LOCATOR = By.xpath("//button[contains(@class,'button--transparent')]");

    private final ITextBox TIMER = getElementFactory().getTextBox(By.xpath("//div[contains(@class,'timer')]"), "Timer");


    public FirstCard() {
        super(UNIQUE_ELEMENT_FIRST_CARD, UNIQUE_ELEMENT_NAME_FIRST_CARD);
    }

    public void inputDataInLoginForm(String password, String email, String domain) {
        INPUT_PASSWORD.clearAndType(password);
        INPUT_EMAIL.clearAndType(email);
        INPUT_DOMAIN.clearAndType(domain);
    }

    public void choseDomainFromDropdownList() {
        OPEN_DOMAIN_LIST.click();
        DROPDOWN_DOMAIN.click();
    }

    public void acceptTermsAndConditions() {
        CHECKBOX_TERMS_CONDITIONS.click();
    }

    public void clickNextButton() {
        NEXT_BUTTON.click();
    }


    public void clickHelpFormHideButton() {
        HELP_FORM_HIDE_BUTTON.click();
    }

    public boolean isHelpFormHide() {
        List<ITextBox> helpFormHide = getElementFactory().findElements(HELP_FORM_HIDE_LOCATOR, ElementType.TEXTBOX);
        return !helpFormHide.isEmpty();
    }


    public void clickAcceptCookiesButton() {
        ACCEPT_COOKIES_BUTTON.click();
    }

    public boolean isCookiesFormClosed() {
        List<ITextBox> helpFormHide = getElementFactory().findElements(COOKIES_FORM_LOCATOR, ElementType.TEXTBOX);
        return helpFormHide.isEmpty();
    }

    public String getTime() {
        return TIMER.getText();
    }
}