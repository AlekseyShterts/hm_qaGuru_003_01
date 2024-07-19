package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.ModalWindow;

public class StudentRegistrationFormTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    ModalWindow modalWindow = new ModalWindow();

    @Test
    void fullFillFormsRegistrationTest() {
        registrationPage.openPage()
                .setFirstName("Dolly")
                .setLastName("Sheep")
                .setEmail("SheepDolly@example.com")
                .setGender("Other")
                .setUserNumber("7999555019")
                .setDateOfBirth("5", "February", "1996")
                .selectSubjects("Computer Science")
                .selectHobbies("Sports")
                .uploadPicture("picture.jpg")
                .currentAdressInput("Edinburgh")
                .stateSelect("Uttar Pradesh")
                .citySelect("Agra")
                .clickSubmitButton();

        modalWindow
                .checkModalHeader("Thanks for submitting the form")
                .checkResultTable("Student Name", "Dolly Sheep")
                .checkResultTable("Student Email", "SheepDolly@example.com")
                .checkResultTable("Gender", "Other")
                .checkResultTable("Mobile", "7999555019")
                .checkResultTable("Date of Birth", "05 February,1996")
                .checkResultTable("Subjects", "Computer Science")
                .checkResultTable("Hobbies", "Sports")
                .checkResultTable("Picture", "picture.jpg")
                .checkResultTable("Address", "Edinburgh")
                .checkResultTable("State and City", "Uttar Pradesh Agra");

    }

    @Test
    void fillOnlyRequiredFormRegistrationTest(){
        registrationPage.openPage()
                .setFirstName("Dolly")
                .setLastName("Sheep")
                .setGender("Other")
                .setUserNumber("79995550199")
                .clickSubmitButton();

        modalWindow
                .checkModalHeader("Thanks for submitting the form")
                .checkResultTable("Student Name", "Dolly Sheep")
                .checkResultTable("Gender", "Other")
                .checkResultTable("Mobile", "7999555019");


    }

    @Test
    void fillNotAllRequiredFormRegistrationTest(){
        registrationPage.openPage()
                .setLastName("Sheep")
                .setGender("Other")
                .setUserNumber("79995550199")
                .clickSubmitButton();

        modalWindow.modalWindowNotExist();
    }

}
