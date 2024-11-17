package tests;

import manager.NGListener;
import manager.ProviderData;
import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(NGListener.class)
public class LoginTests extends TestBase {

//    @AfterMethod(alwaysRun = true)
//    public void postCondition() {
//        if (app.getHelperUser().isLogged()) {
//            app.getHelperUser().logout();
//        }
//    }

    @Test(groups = {"positive"})
    public void loginPositiveTest() {

        //open login form
//        wd.findElement(By.xpath("//*[.='LOGIN']")).click();
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().pause(3000);

        // fill login form
//        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
//        emailInput.click();
//        emailInput.clear();
//        emailInput.sendKeys("arino4ka89@list.ru");
//
//        WebElement passInput = wd.findElement(By.xpath("//input[2]"));
//        passInput.click();
//        passInput.clear();
//        passInput.sendKeys("$Abc12345");
        app.getHelperUser().fillLoginRegistrationForm("arino4ka89@list.ru", "$Abc12345");

        // click on button login
//        wd.findElement(By.xpath("//button[1]")).click();
        app.getHelperUser().submitLogin();

        //assert that we are logged in
        app.getHelperUser().pause(3000);
//        Assert.assertTrue(wd.findElements(By.tagName("button")).size() > 0);;
        Assert.assertTrue(app.getHelperUser().isElementPresent(By.tagName("button")));
    }

//    @Test
//    public void loginPositiveTestModel() {
//        User user = User.builder()
//                        .email("arino4ka89@list.ru")
//                                .password("$Abc12345")
//                                        .build();
//        app.getHelperUser().openLoginRegistrationForm();
//        app.getHelperUser().fillLoginRegistrationForm("arino4ka89@list.ru", "$Abc12345");
//        app.getHelperUser().submitLogin();
//        app.getHelperUser().pause(3000);
//        Assert.assertTrue(app.getHelperUser().isElementPresent(By.tagName("button")));
//    }

    @Test(groups = {"positive"}, dataProvider = "userDTO", dataProviderClass = ProviderData.class)
    public void loginPositiveUserDTO(User user) {
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("arino4ka89@list.ru", "$Abc12345");
        app.getHelperUser().submitLogin();
        app.getHelperUser().pause(3000);
        Assert.assertTrue(app.getHelperUser().isElementPresent(By.tagName("button")));
    }

    @Test(groups = {"negative", "smoke"})
    public void loginNegativeTestWrongEmail() {
        //open login form
        app.getHelperUser().openLoginRegistrationForm();

        // fill login form
        app.getHelperUser().fillLoginRegistrationForm("arino4ka89listru", "$Abc12345");

        // click on button login
        app.getHelperUser().submitLogin();

        //assert that we are logged in
        app.getHelperUser().pause(3000);
        Assert.assertTrue(app.getHelperUser().isAlertPresent());
    }

    @Test(groups = {"negative"})
    public void loginNegativeTestWrongPass() {
        //open login form
        app.getHelperUser().openLoginRegistrationForm();

        // fill login form
        app.getHelperUser().fillLoginRegistrationForm("arino4ka89@list.ru", "Abc12345");

        // click on button login
        app.getHelperUser().submitLogin();

        //assert that we are logged in
        app.getHelperUser().pause(3000);
        Assert.assertTrue(app.getHelperUser().isAlertPresent());
    }
}
