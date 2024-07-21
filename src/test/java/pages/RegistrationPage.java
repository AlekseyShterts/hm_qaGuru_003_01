package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {
    private SelenideElement firstNameInput = $("#firstName");
    private SelenideElement lastNameInput = $("#lastName");
    private SelenideElement userEmailInput = $("#userEmail");
    private SelenideElement genderWrapper = $("#genterWrapper");
    private SelenideElement userNumberInput = $("#userNumber");
    private SelenideElement calendarInput = $("#dateOfBirthInput");
    private SelenideElement selectSubjects = $("#subjectsInput");
    private SelenideElement selectHobbies = $("#hobbiesWrapper");
    private SelenideElement uploadPicture = $("#uploadPicture");
    private SelenideElement currentAdressInput = $("#currentAddress");
    private SelenideElement stateSelect =  $("#state");
    private SelenideElement citySelect = $("#city");
    private SelenideElement clickSubmitButton = $("#submit");

    CalendarComponent calendarComponent = new CalendarComponent();

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        return this;
    }

    public RegistrationPage removeBannerAndFooter() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);

        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(month, year, day);

        return this;
    }

    public RegistrationPage selectSubjects (String value) {
        selectSubjects.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage selectHobbies (String value) {
        selectHobbies.$(byText(value)).click();
        return this;
    }

    public RegistrationPage uploadPicture(String value) {
        uploadPicture.uploadFromClasspath(value);
        return this;
    }

    public RegistrationPage currentAdressInput(String value) {
        currentAdressInput.setValue(value);
        return this;
    }

    public RegistrationPage stateSelect(String value) {
        stateSelect.click();
        stateSelect.$(byText(value)).click();
        return this;
    }

    public RegistrationPage citySelect(String value) {
        citySelect.click();
        citySelect.$(byText(value)).click();
        return this;
    }

    public void clickSubmitButton() {
        clickSubmitButton.scrollIntoView(true).click();
    }

}
