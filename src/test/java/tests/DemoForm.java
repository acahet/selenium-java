package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pageObject.GoogleSearch;
import pageObject.RequestDemo;
import selenium.driver.Browser;
import selenium.driver.WebDriverUtility;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DemoForm extends WebDriverUtility {

    private GoogleSearch lp;
    private RequestDemo form;
    WebDriver driver;

    @BeforeEach
    public void setupTest() throws InterruptedException {
        String URL = "https://www.google.com";

        driver = WebDriverUtility.getWebDriver(Browser.FIREFOX);
        driver.get(URL);
        lp = new GoogleSearch(driver);
        form = new RequestDemo(driver);
        lp.getToAODocsPage();
        Thread.sleep(3000);
        form.agreeToCookies().click();
        form.requestDemoBtn().click();
    }

    @Test
    @DisplayName("Fill Request Quote Form leaving Last name empty")
    public void fillFormWithoutLastName() {
        form.fillForm("Anderson", "", "jd45@gmail.com", "5-50 employees");
        assertEquals("Please complete this required field.",
                form.errorMessageVerification(form.getLastNameError()).getText());
    }

    @Test
    @DisplayName("Fill Request Quote with an Invalid email")
    public void fillFormWithInvalidEmail() {
        form.fillForm("Anderson", "Cahet", "emailtest.com", "5-50 employees");
        assertEquals("Email must be formatted correctly.",
                form.errorMessageVerification(form.getEmailError()).getText());
    }

    @AfterEach
    public void closeupTest() {
        driver.close();
    }
}
