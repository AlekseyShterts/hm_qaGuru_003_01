package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxResultPage {

    private SelenideElement inputName = $("#output #name"),
            inputEmail = $("#output #email"),
            currentAddress = $("#output #currentAddress"),
            permanentAddress = $("#output #permanentAddress");


    public TextBoxResultPage checkName(String value) {
        inputName.shouldHave(text(value));
        return this;
    }

    public TextBoxResultPage checkEmail(String value) {
        inputEmail.shouldHave(text(value));
        return this;
    }

    public TextBoxResultPage checkCurrentAddress(String value) {
        currentAddress.shouldHave(text(value));
        return this;
    }

    public TextBoxResultPage checkPermanentAddress(String value) {
        permanentAddress.shouldHave(text(value));
        return this;
    }
}
