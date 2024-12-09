package tests;

import pages.components.TextBoxResultModal;
import org.junit.jupiter.api.Test;

public class TextBoxTests extends TestBase{

    @Test
    void fillFormTest() {

        pages.TextBoxPage textBoxPage = new pages.TextBoxPage();
        TextBoxResultModal checkTextBox = new TextBoxResultModal();

        textBoxPage.openPage();
        textBoxPage
                .removeBannerAndFooter()
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
