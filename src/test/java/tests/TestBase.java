package tests;

import manager.ApplicationManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;

public class TestBase {

//    WebDriver wd;

    static ApplicationManager app = new ApplicationManager();

    Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeMethod
    public void startTest(Method method) {
    logger.info("Starting test ---> " + method.getName());
    }

    @AfterMethod
    public void stopTest(Method method) {
    logger.info("Finished test <--- " + method.getName());
    }


    @BeforeSuite
    public void setup() {
        app.init();
    }

    @AfterSuite
    public void stop() {
        app.tearDown();
    }

}
