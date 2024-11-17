package tests;

import manager.ApplicationManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.lang.reflect.Method;

public class TestBase {

//    WebDriver wd;

    static ApplicationManager app = new ApplicationManager(
            System.getProperty("browser", "chrome")
    );

    Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeMethod(alwaysRun = true)
    public void startTest(Method method){
        logger.info("Started test ----> " + method.getName());
    }

    @AfterMethod(alwaysRun = true)
    public void stopTest(Method method){

        if (app.getHelperUser().isLogged()) { //добавлено доп разлогирование
            app.getHelperUser().logout();
        }

        logger.info("Finished test ----> " + method.getName());
        logger.info("================================================================");
    }



    @BeforeSuite(alwaysRun = true)
    public void setup() throws IOException {
        app.init();
    }

    @AfterSuite(alwaysRun = true)
    public void stop(){
        app.tearDown();
    }

}
