package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.ModalContentComponent;

public class RegistrationWithPageObjectsTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    ModalContentComponent modalContentComponent = new ModalContentComponent();


    String title = "Student Registration Form";
    String firstName = "Bruce";
    String lastName = "Wayne";
    String email = "wayneinterprise@waine.com";
    String gender = "Male";
    String phoneNumber = "7999999999";
    String[] birthDay = {"10", "November", "1990"};
    String subject1 = "Physics";
    String subject2 = "Computer Science";
    String hobby1 = "Sports";
    String hobby2 = "Reading";
    String hobby3 = "Music";
    String nameImage = "bruce.jpeg";
    String pathImage = "img/" + nameImage;
    String currentAddress = "1007 Mountain Drive, Gotham";
    String state = "Haryana";
    String city = "Karnal";
    String successSubmissionText = "Thanks for submitting the form";



    @Tag("WEB")
    @Test
    void fillForm() {
        registrationPage.openPage()
                .checkTitle(title)
                .deleteFooterAndAdd()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(email)
                .setGender(gender)
                .setUserNumber(phoneNumber)
                .setDateBirth(birthDay[0], birthDay[1], birthDay[2])
                .setSubjectsInput(subject1)
                .setSubjectsInput(subject2)
                .setHobbies(hobby1)
                .setHobbies(hobby2)
                .setHobbies(hobby3)
                .setImage(pathImage)
                .setCurrentAddress(currentAddress)
                .setState(state)
                .setCity(city)
                .submit();

        modalContentComponent.checkVisible()
                        .successFormSubmissionText(successSubmissionText)
                        .checkResult("Student Name", firstName + " " + lastName)
                        .checkResult("Student Email", email)
                        .checkResult("Gender", gender)
                        .checkResult("Mobile", phoneNumber)
                        .checkResult("Date of Birth", birthDay[0] + " " + birthDay[1] + "," + birthDay[2])
                        .checkResult("Subjects", subject1 + ", " + subject2)
                        .checkResult("Hobbies", hobby1 + ", " + hobby2 + ", " + hobby3)
                        .checkResult("Picture", nameImage)
                        .checkResult("Address", currentAddress)
                        .checkResult("State and City", state + " " + city);
    }

    @Tag("WEB")
    @Test
    void fillingRequiredFields(){
        registrationPage.openPage()
                .checkTitle(title)
                .deleteFooterAndAdd()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setUserNumber(phoneNumber)
                .setDateBirth(birthDay[0], birthDay[1], birthDay[2])
                .submit();

        modalContentComponent.checkVisible()
                        .successFormSubmissionText(successSubmissionText)
                        .checkResult("Student Name", firstName + " " + lastName)
                        .checkResult("Gender", gender)
                        .checkResult("Mobile", phoneNumber)
                        .checkResult("Date of Birth", birthDay[0] + " " + birthDay[1] + "," + birthDay[2]);
    }

    @Tag("WEB")
    @Test
    void blankFieldsForm(){
        registrationPage.openPage()
                .checkTitle(title)
                .deleteFooterAndAdd()
                .setFirstName(firstName)
                .setLastName(lastName)
                .submit();

        modalContentComponent.checkNotBeVisible()
                .notHaveFilledForm(successSubmissionText);
    }
}
