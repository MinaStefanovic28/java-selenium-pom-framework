package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    private By markaDropdown = By.xpath("//*[@id='brand']//input | //*[contains(@id, 'brand')]//input");
    private By modelDropdown = By.xpath("//*[@id='model']//input | //*[contains(@id, 'model')]//input");
    private By btnPretraga = By.id("searchButton");
    private By cookieAcceptBtn = By.xpath("//button[contains(text(),'U redu')]");
    private By loginBtn = By.cssSelector("span[data-testid=\"headerSignIn\"]");
    private By priceInput = By.id("priceTo");
    private By fuelDropdown = By.id("fuel");
    private By logoHeader = By.id("headerPolovniAutomobiliLogo");
    private By promoCreditBtn = By.cssSelector("button[data-testid=\"creditPromoOk\"]");



    public void acceptCookies() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
            By cookieBtn = By.id("didomi-notice-agree-button");

            WebElement button = wait.until(ExpectedConditions.presenceOfElementLocated(cookieBtn));

            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
        } catch (Exception e) {
            try {
                ((JavascriptExecutor) driver).executeScript(
                        "var elem = document.getElementById('didomi-host'); if(elem) elem.remove();"
                );
            } catch (Exception ignored) {}
            System.out.println("Kolačići nisu pronađeni ili su uklonjeni iz DOM-a.");
        }
    }

    public void selectModel(String model) {
        click(modelDropdown);
        sendKeys(modelDropdown, model);
        driver.findElement(modelDropdown).sendKeys(Keys.ENTER);
    }

    public void selectMarku(String marka) {
        click(markaDropdown);
        sendKeys(markaDropdown, marka);
        driver.findElement(markaDropdown).sendKeys(Keys.ENTER);

    }

    public void clickSearchBtn() {
        click(logoHeader);
        click(btnPretraga);
    }
    public void open() {
        try {
            driver.get("https://www.polovniautomobili.com/");
        } catch (Exception e) {
            System.out.println("Stranica se nije učitala do kraja u predviđenom roku, nastavljam sa testom.");
        }
    }

    public boolean isLogoDisplayed() {
        return isDisplayed(logoHeader);
    }

    public void clickLoginButton() {
        click(loginBtn);
    }

    public boolean isBrandDropdownDisplayed() {
        return isDisplayed(markaDropdown);
    }

    public boolean isModelDropdownDisplayed() {
        return isDisplayed(modelDropdown);
    }

    public void enterPrice(String price) {
        click(priceInput);
        sendKeys(priceInput, price);
    }

    public void selectFuel(String fuel) {
        selectReactOption(fuelDropdown, fuel);
    }

    public void acceptPromoCredit() {
        click(promoCreditBtn);
    }


}

