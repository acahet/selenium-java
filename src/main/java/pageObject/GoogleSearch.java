package pageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleSearch {
    public WebDriver driver;

    By agreeToTermsSelector = By.cssSelector("#zV9nZe");
    By searchFieldSelector = By.cssSelector("input[title='Search']");
    By linkToAODocsSelector = By.cssSelector("#rso > div:nth-child(1) > div > div > div > div > div > div:nth-child(1)");

    public GoogleSearch(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement agreeToTerms() {
        return driver.findElement(agreeToTermsSelector);
    }

    private WebElement searchField() {
        return driver.findElement(searchFieldSelector);
    }

    private WebElement goToAODocsPage() {
        return driver.findElement(linkToAODocsSelector);
    }

    public void getToAODocsPage() throws InterruptedException {
        String searchKey = "AODocs";
        this.agreeToTerms().click();
        this.searchField().sendKeys(searchKey);
        this.searchField().sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        this.goToAODocsPage().click();
    }
}




