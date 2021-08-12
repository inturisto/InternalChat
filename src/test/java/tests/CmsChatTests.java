package tests;

import core.BaseFunc;
import core.cmspages.CmsHomePage;
import core.cmspages.CmsLogInPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CmsChatTests {

    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    private BaseFunc baseFunc;

    @BeforeEach
    public void preconditions() {
        baseFunc = new BaseFunc();
    }

    @Test

    public void cmsLoginTest() {

        LOGGER.info("Starting CMS login test");

        CmsLogInPage logInPage = new CmsLogInPage(baseFunc);
        logInPage.openCmsLoginPage();

        CmsHomePage cmsHomePage = logInPage.login("ss101", "qwerty");

    }

    @AfterEach
    public void closeBrowser() {
        baseFunc.closeBrowser();
    }
}
