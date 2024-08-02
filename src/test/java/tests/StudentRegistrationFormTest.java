package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.CalendarComponent;
import pages.components.SubmitFormModal;
import utils.TestData;

import java.util.List;


@Tag("smoke")
@DisplayName("Registration form tests")
public class StudentRegistrationFormTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    SubmitFormModal submitFormModal = new SubmitFormModal();
    CalendarComponent calendarComponent = new CalendarComponent();
    TestData testData = new TestData();

    @Test
    @Tag("smoke")
    @DisplayName("Check the registration form with all fields filled in")
    void fullFillFormsRegistrationTest() {

        List<String> usedData = List.of(
                testData.firstName + " " + testData.lastName,
                testData.email,
                testData.gender,
                testData.mobilePhone,
                testData.dateOfBirth,
                testData.subject,
                testData.hobbies,
                testData.uploadFile,
                testData.address,
                testData.state + " " + testData.city
        );

        registrationPage.openPage()
                .removeBannerAndFooter()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setEmail(testData.email)
                .setGender(testData.gender)
                .setUserNumber(testData.mobilePhone);
        calendarComponent.setDateOfBirthByFake(testData.dateOfBirth);
        registrationPage.selectSubjects(testData.subject)
                .selectHobbies(testData.hobbies)
                .uploadPicture(testData.uploadFile)
                .currentAdressInput(testData.address)
                .stateSelect(testData.state)
                .citySelect(testData.city)
                .clickSubmitButton();
        submitFormModal.checkFormIsFilledOutCorrectly(usedData);

    }

    @Test
    @Tag("regression")
    @DisplayName("Check the registration form for only required fields")
    void fillOnlyRequiredFormRegistrationTest() {
        List<String> usedData = List.of(
                testData.firstName + " " + testData.lastName,
                testData.gender,
                testData.mobilePhone
        );

        registrationPage.openPage()
                .removeBannerAndFooter()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setGender(testData.gender)
                .setUserNumber(testData.mobilePhone)
                .clickSubmitButton();
        submitFormModal.isFormFilledOutCorrectly(usedData);

    }

    @Test
    @Tag("negative")
    @DisplayName("Check the Registration Form without the Last Name")
    void fillNotAllRequiredFormRegistrationTest() {

        registrationPage.openPage()
                .removeBannerAndFooter()
                .setFirstName(testData.firstName)
                .setGender(testData.gender)
                .setUserNumber(testData.mobilePhone)
                .clickSubmitButton();
        registrationPage.checkVisibleSubmitFormModal();
    }

}
