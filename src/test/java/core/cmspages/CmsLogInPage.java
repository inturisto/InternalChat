package core.cmspages;

import core.BaseFunc;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import static org.openqa.selenium.By.*;

public class CmsLogInPage {
    private final By LOGIN_FORM = className("login-form");
    private final By LOGIN = id("auth-username");
    private final By PASSWORD = id("auth-password");
    private final By SIGN_IN_BUTTON = tagName("button");

    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    private String cmsPageUrl = "https://cms.stage-travel.com/";

    private BaseFunc baseFunc;

    public CmsLogInPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;

    }

    public void openCmsLoginPage() {
        LOGGER.info("Starting to open new CMS Login page: " + cmsPageUrl);

        baseFunc.openPage(cmsPageUrl);

        LOGGER.info("Starting checking if CMS Login page opened up.");

        baseFunc.visibilityOfElement(LOGIN_FORM);

        LOGGER.info("New CMS Login page opened up.");
    }

    public CmsHomePage login(String login, String password) {

        LOGGER.info("Starting to open new CMS Home page opened.");

        baseFunc.signIn(baseFunc.findElement(LOGIN), login, baseFunc.findElement(PASSWORD), password, baseFunc.findElement(SIGN_IN_BUTTON));

        return new CmsHomePage(baseFunc);
    }
}
