package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.CalendarComponent;
import pages.components.SubmitFormModal;

import java.util.List;

import static utils.TestData.*;

public class StudentRegistrationFormTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    SubmitFormModal submitFormModal = new SubmitFormModal();
    CalendarComponent calendarComponent = new CalendarComponent();

    @Test
    void fullFillFormsRegistrationTest() {

        String firstName = getFirstName();
        String lastName = getLastName();
        String email = getEmail();
        String gender = getGender();
        String mobile = getMobile();
        String dateOfBirth = getDateOfBirth();
        String subject = getSubject();
        String hobby = getHobby();
        String fileName = getFile();
        String address = getAddress();
        String state = getState();
        String city = getCity(state);


        List<String> usedData = List.of(
                firstName + " " + lastName,
                email,
                gender,
                mobile,
                dateOfBirth,
                subject,
                hobby,
                fileName,
                address,
                state + " " + city
        );

        registrationPage.openPage()
                .removeBannerAndFooter()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setUserNumber(mobile);
        calendarComponent.setDateOfBirthByFake(dateOfBirth);
        registrationPage.selectSubjects(subject)
                .selectHobbies(hobby)
                .uploadPicture(fileName)
                .currentAdressInput(address)
                .stateSelect(state)
                .citySelect(city)
                .clickSubmitButton();
        submitFormModal.checkFormIsFilledOutCorrectly(usedData);

    }

    @Test
    void fillOnlyRequiredFormRegistrationTest() {
        String firstName = getFirstName();
        String lastName = getLastName();
        String gender = getGender();
        String mobile = getMobile();

        List<String> usedData = List.of(
                firstName + " " + lastName,
                gender,
                mobile
        );

        registrationPage.openPage()
                .removeBannerAndFooter()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setUserNumber(mobile)
                .clickSubmitButton();
        submitFormModal.isFormFilledOutCorrectly(usedData);

    }

    @Test
    void fillNotAllRequiredFormRegistrationTest() {
        String firstName = getFirstName();
        String gender = getGender();
        String mobile = getMobile();

        registrationPage.openPage()
                .removeBannerAndFooter()
                .setFirstName(firstName)
                .setGender(gender)
                .setUserNumber(mobile)
                .clickSubmitButton();
        registrationPage.checkVisibleSubmitFormModal();
    }

}
