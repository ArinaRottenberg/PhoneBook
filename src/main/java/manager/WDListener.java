package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WDListener extends AbstractWebDriverEventListener {

    Logger logger = LoggerFactory.getLogger(WDListener.class);

    public WDListener() {
        super();
    }

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        super.beforeFindBy(by, element, driver);
        logger.info("Start looking for element by locator ---> " + by);
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        super.afterFindBy(by, element, driver);
        logger.info("Element with locator ---> " + by + " is found");
    }

    @Override
    public void onException(Throwable throwable, WebDriver driver) {
        super.onException(throwable, driver);
        logger.info("Something went wrong!!!");
        logger.info(throwable.getMessage());
        logger.info(throwable.getStackTrace().toString());
        int i = (int) System.currentTimeMillis() / 1000 % 3600;
        String link = "src/test/screens/screenshot-" + i + ".png";
        HelperBase helperBase = new HelperBase(driver);
        helperBase.takeScreenshot(link);
        logger.info("Here is the path to screenshot with error ---> " + link);
    }
}
