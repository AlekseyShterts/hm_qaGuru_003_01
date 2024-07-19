package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxResult {

    private SelenideElement inputName = $("#output #name"),
            inputEmail = $("#output #email"),
            currentAddress = $("#output #currentAddress"),
            permanentAddress = $("#output #permanentAddress");


    public TextBoxResult checkName(String value) {
        inputName.shouldHave(text(value));
        return this;
    }

    public TextBoxResult checkEmail(String value) {
        inputEmail.shouldHave(text(value));
        return this;
    }

    public TextBoxResult checkCurrentAddress(String value) {
        currentAddress.shouldHave(text(value));
        return this;
    }

    public TextBoxResult checkPermanentAddress(String value) {
        permanentAddress.shouldHave(text(value));
        return this;
    }
}
