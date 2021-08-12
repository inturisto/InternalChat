package core;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static java.lang.System.setProperty;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class BaseFunc {
    private WebDriver driver;
    private WebDriverWait wait;
    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    public BaseFunc() {

        LOGGER.info("Setting up driver's path.");

        setProperty("webdriver.chrome.driver", "/home/kcelebijs/chromedriver/chromedriver");

        LOGGER.info("Opening new browser.");

        driver = new ChromeDriver();

        LOGGER.info("Maximizing window.");

        driver.manage().window().maximize();

        LOGGER.info("Setting up wait conditions.");

        wait = new WebDriverWait(driver, 10);

        LOGGER.info("WebDriver successfully set up for further work.");
    }

    public void openPage(String url) {
        LOGGER.info("Checking url before proceeding to web-page.");

        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            url = "http://" + url;

            LOGGER.info("URL was incorrect!");
        }
        else {
            LOGGER.info("URL was correct.");
        }

        driver.get(url);

        LOGGER.info("Proceeding to web-page.");
    }

    public void closeBrowser() {
        LOGGER.info("Executing closing browser.");

        driver.quit();

        LOGGER.info("Browser is closed successfully!");
    }

    public List<WebElement> findElements(By locator, String collectionName) {
        return driver.findElements(locator);
    }

    public WebElement findElement(By locator) {
        wait.until(visibilityOfElementLocated(locator));
        return driver.findElement(locator);
    }

    public void visibilityOfElement(By locator) {
        wait.until(visibilityOfElementLocated(locator));
    }

    public void signIn(WebElement login, String loginName, WebElement password, String passwordName, WebElement button) {
        login.sendKeys(loginName);
        password.sendKeys(passwordName);
        button.click();
    }
}
