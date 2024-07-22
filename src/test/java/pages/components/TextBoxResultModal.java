package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxResultModal {

    private SelenideElement inputName = $("#output #name"),
            inputEmail = $("#output #email"),
            currentAddress = $("#output #currentAddress"),
            permanentAddress = $("#output #permanentAddress");


    public TextBoxResultModal checkName(String value) {
        inputName.shouldHave(text(value));
        return this;
    }

    public TextBoxResultModal checkEmail(String value) {
        inputEmail.shouldHave(text(value));
        return this;
    }

    public TextBoxResultModal checkCurrentAddress(String value) {
        currentAddress.shouldHave(text(value));
        return this;
    }

    public TextBoxResultModal checkPermanentAddress(String value) {
        permanentAddress.shouldHave(text(value));
        return this;
    }
}
