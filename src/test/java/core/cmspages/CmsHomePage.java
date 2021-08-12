package core.cmspages;

import core.BaseFunc;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

public class CmsHomePage {
    private final By TRCC = By.xpath(".//div[@class='trcc-plugin-sidenav']");

    private BaseFunc baseFunc;

    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    public CmsHomePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;

        LOGGER.info("Starting checking if CMS home page opened up.");

        baseFunc.visibilityOfElement(TRCC);

        LOGGER.info("New CMS home page opened up.");
    }
}
