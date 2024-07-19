package tests;

import pages.TextBoxResult;
import org.junit.jupiter.api.Test;

public class TextBoxTests extends TestBase{

    @Test
    void fillFormTest() {

        pages.TextBoxPage textBoxPage = new pages.TextBoxPage();
        TextBoxResult checkTextBox = new TextBoxResult();

        textBoxPage.openPage();
        textBoxPage
                .setUserName("Dolly")
                .setUserEmail("SheepDolly@example.com")
                .setCurrentAddress("Edinburgh")
                .setPermanentAddress("London")
                .submitForm();

        checkTextBox
                .checkName("Dolly")
                .checkEmail("SheepDolly@example.com")
                .checkCurrentAddress("Edinburgh")
                .checkPermanentAddress("London");

    }
}
