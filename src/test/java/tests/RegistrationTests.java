package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase {

    @Test(groups = {"positive"})
    public void registrationPositiveTest() {
        //open login form
        app.getHelperUser().openLoginRegistrationForm();

        // fill login form
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        String email = "abc_" + i + "@list.ru";
        String password = "$Abc12345";
        app.getHelperUser().fillLoginRegistrationForm(email, password);

        // click on button register
        app.getHelperUser().submitRegistration();

        //assert that we are logged in
        app.getHelperUser().pause(3000);
        logger.info("registrationPositiveTest starts with: " + email + " and" + password);
        Assert.assertTrue(app.getHelperUser().isElementPresent(By.tagName("button")));

    }

    @Test(groups = {"negative"})
    public void registrationNegativeTestWrongEmail() {
        // open login form
        app.getHelperUser().openLoginRegistrationForm();

        // fill login form
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        app.getHelperUser().fillLoginRegistrationForm("abc_" + i + "list.ru", "$Abc12345");

        // click on button register
        app.getHelperUser().submitRegistration();

        Assert.assertTrue(app.getHelperUser().isAlertPresent());
    }
}
