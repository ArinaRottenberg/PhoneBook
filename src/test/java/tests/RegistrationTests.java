package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase {

//    @Test
//    public void registrationPositiveTest() {
//        //open login form
//        wd.findElement(By.xpath("//*[.='LOGIN']")).click();
//
//        // fill login form
//        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
//        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
//        emailInput.click();
//        emailInput.clear();
//        emailInput.sendKeys("abc_" + i + "@list.ru");
//
//        WebElement passInput = wd.findElement(By.xpath("//input[2]"));
//        passInput.click();
//        passInput.clear();
//        passInput.sendKeys("$Abc12345");
//
//        // click on button register
//        wd.findElement(By.xpath("//button[2]")).click();
//
//        //assert that we are logged in
//        //        pause(3000);
//        Assert.assertTrue(wd.findElements(By.tagName("button")).size() > 0);
//        ;
//    }
//
//    @Test
//    public void registrationNegativeTestWrongEmail() {
//        // open login form
//        wd.findElement(By.xpath("//*[.='LOGIN']")).click();
//
//        // fill login form
//        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
//        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
//        emailInput.click();
//        emailInput.clear();
//        emailInput.sendKeys("abc_" + i + "list.ru");
//
//        WebElement passInput = wd.findElement(By.xpath("//input[2]"));
//        passInput.click();
//        passInput.clear();
//        passInput.sendKeys("$Abc12345");
//
//        // click on button register
//        wd.findElement(By.xpath("//button[2]")).click();
//
//        Assert.assertTrue(isAlertPresent());
//    }
}
