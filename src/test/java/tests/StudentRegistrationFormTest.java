package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.SubmitFormModal;

public class StudentRegistrationFormTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    SubmitFormModal submitFormModal = new SubmitFormModal();

    @Test
    void fullFillFormsRegistrationTest() {
        registrationPage.openPage()
                .removeBannerAndFooter()
                .setFirstName("Dolly")
                .setLastName("Sheep")
                .setEmail("SheepDolly@example.com")
                .setGender("Other")
                .setUserNumber("7999555019")
                .setDateOfBirth("30", "January", "1991")
                .selectSubjects("Computer Science")
                .selectHobbies("Sports")
                .uploadPicture("picture.jpg")
                .currentAdressInput("Edinburgh")
                .stateSelect("Uttar Pradesh")
                .citySelect("Agra")
                .clickSubmitButton();

        submitFormModal
                .checkSubmitModalHeader("Thanks for submitting the form")
                .checkSubmitFormModalTable("Student Name", "Dolly Sheep")
                .checkSubmitFormModalTable("Student Email", "SheepDolly@example.com")
                .checkSubmitFormModalTable("Gender", "Other")
                .checkSubmitFormModalTable("Mobile", "7999555019")
                .checkSubmitFormModalTable("Date of Birth", "30 January,1991")
                .checkSubmitFormModalTable("Subjects", "Computer Science")
                .checkSubmitFormModalTable("Hobbies", "Sports")
                .checkSubmitFormModalTable("Picture", "picture.jpg")
                .checkSubmitFormModalTable("Address", "Edinburgh")
                .checkSubmitFormModalTable("State and City", "Uttar Pradesh Agra");

    }

    @Test
    void fillOnlyRequiredFormRegistrationTest(){
        registrationPage.openPage()
                .removeBannerAndFooter()
                .setFirstName("Dolly")
                .setLastName("Sheep")
                .setGender("Other")
                .setUserNumber("79995550199")
                .clickSubmitButton();

        submitFormModal
                .checkSubmitModalHeader("Thanks for submitting the form")
                .checkSubmitFormModalTable("Student Name", "Dolly Sheep")
                .checkSubmitFormModalTable("Gender", "Other")
                .checkSubmitFormModalTable("Mobile", "7999555019");

    }

    @Test
    void fillNotAllRequiredFormRegistrationTest(){
        registrationPage.openPage()
                .removeBannerAndFooter()
                .setLastName("Sheep")
                .setGender("Other")
                .setUserNumber("79995550199")
                .clickSubmitButton();

        submitFormModal.submitFormModalNotExist();
    }

}
