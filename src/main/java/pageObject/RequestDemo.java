package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RequestDemo {

    public WebDriver driver;

    By requestDemoSelector = By.cssSelector("#DND_banner-module-1 > div > div > div.hs-col-md-6.hs-d-flex > div > div > a");
    By firstNameSelector = By.cssSelector("[name='firstname']");
    By lastNameSelector = By.cssSelector("[name='lastname']");
    By emailSelector = By.cssSelector("[name='email']");
    By companySizeSelector = By.cssSelector("[name='company_size__c']");
    By cookies = By.id("ccc-notify-accept");


    // error message selector
    String lastNameErrorMessageSelector = "lastname";
    String emailErrorMessageSelector = "email";

    public RequestDemo(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement requestDemoBtn() {
        return driver.findElement(requestDemoSelector);
    }

    public WebElement agreeToCookies() {
        return driver.findElement(cookies);
    }

    public WebElement firstNameField() {
        return driver.findElement(firstNameSelector);
    }

    public WebElement lastNameField() {
        return driver.findElement(lastNameSelector);
    }

    public WebElement emailField() {
        return driver.findElement(emailSelector);
    }

    public WebElement companySizeDropdown() {
        return driver.findElement(companySizeSelector);
    }

    public String getLastNameError() {
        return lastNameErrorMessageSelector;
    }

    public String getEmailError() {
        return emailErrorMessageSelector;
    }


    public void selectCompanySize(String value) {
        Select dropdown = new Select(companySizeDropdown());
        dropdown.selectByValue(value);
    }

    public WebElement errorMessageVerification(String selector) {
        String sel = String.format("label[class='hs-error-msg'][data-reactid*='%s']",selector);
        return driver.findElement(By.cssSelector(sel));
    }

    public void fillForm(String firstName, String lastName, String email, String companySize) {
        firstNameField().sendKeys(firstName);
        lastNameField().sendKeys(lastName);
        emailField().sendKeys(email);
        selectCompanySize(companySize);

    }
}
