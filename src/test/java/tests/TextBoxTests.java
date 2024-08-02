package tests;

import pages.TextBoxResultPage;
import org.junit.jupiter.api.Test;

public class TextBoxTests extends TestBase{

    @Test
    void fillFormTest() {

        pages.TextBoxPage textBoxPage = new pages.TextBoxPage();
        TextBoxResultPage checkTextBox = new TextBoxResultPage();

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
