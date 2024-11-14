package tests;

import models.Contact;
import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewContactTests extends TestBase {

    @BeforeMethod(alwaysRun = true)
    public void precondition() {
        if (!app.getHelperUser().isLogged()) app.getHelperUser().login();
        User.builder()
                .email("arino4ka89@list.ru")
                .password("$Abc12345")
                .build();
    }

//    @Test(invocationCount = 5)
@Test(groups = {"positive", "smoke"})
    public void addNewContactPositiveTest() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        Contact contact = Contact.builder()
                .name("John")
                .lastName("Doe")
                .phone("12345678" + i)
                .email("john_" + i + "@example.com")
                .address("Rehovot, Israel")
                .description("Pirate")
                .build();

        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().submitContactForm();

        Assert.assertTrue(app.getHelperContact().isContactCreated(contact));
    }

}
