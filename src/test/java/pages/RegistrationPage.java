package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {
    private SelenideElement firstNameInput = $("#firstName");
    private SelenideElement lastNameInput = $("#lastName");
    private SelenideElement userEmailInput = $("#userEmail");
    private SelenideElement genderWrapper = $("#genterWrapper");
    private SelenideElement userNumberInput = $("#userNumber");
    private SelenideElement selectSubjects = $("#subjectsInput");
    private SelenideElement selectHobbies = $("#hobbiesWrapper");
    private SelenideElement uploadPicture = $("#uploadPicture");
    private SelenideElement currentAdressInput = $("#currentAddress");
    private SelenideElement stateSelect = $("#state");
    private SelenideElement citySelect = $("#city");
    private SelenideElement clickSubmitButton = $("#submit");
    private SelenideElement submitFormModal = $(".modal-content");

    CalendarComponent calendarComponent = new CalendarComponent();

    @Step("Open page /automation-practice-form")
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        return this;
    }

    @Step("Remove banner and footer")
    public RegistrationPage removeBannerAndFooter() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    @Step("Set FirstName")
    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    @Step("Set LastName")
    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    @Step("Set Email")
    public RegistrationPage setEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    @Step("Set Gender")
    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();

        return this;
    }

    @Step("Set UserNumber")
    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);

        return this;
    }

    @Step("Select Subjects")
    public RegistrationPage selectSubjects(String value) {
        selectSubjects.setValue(value).pressEnter();
        return this;
    }

    @Step("Select Hobbies")
    public RegistrationPage selectHobbies(String value) {
        selectHobbies.$(byText(value)).click();
        return this;
    }

    @Step("Upload Picture")
    public RegistrationPage uploadPicture(String value) {
        uploadPicture.uploadFromClasspath(value);
        return this;
    }

    @Step("Input Current Adress")
    public RegistrationPage currentAdressInput(String value) {
        currentAdressInput.setValue(value);
        return this;
    }

    @Step("Select state")
    public RegistrationPage stateSelect(String value) {
        stateSelect.click();
        stateSelect.$(byText(value)).click();
        return this;
    }

    @Step("Select city")
    public RegistrationPage citySelect(String value) {
        citySelect.click();
        citySelect.$(byText(value)).click();
        return this;
    }

    @Step("Click SubmitButton")
    public void clickSubmitButton() {
        clickSubmitButton.scrollIntoView(true).click();
    }

    @Step("Check Visible Submit Form Modal")
    public void checkVisibleSubmitFormModal() {
        submitFormModal.shouldNotBe(visible);
    }

}
