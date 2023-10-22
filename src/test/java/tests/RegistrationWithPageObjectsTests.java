package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import pages.RegistrationPage;
import pages.components.ModalContentComponent;

public class RegistrationWithPageObjectsTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    ModalContentComponent modalContentComponent = new ModalContentComponent();


    @ParameterizedTest(name = "Заполнение всех полей в форме регистрации")
    @Tags({@Tag("SMOKE"), @Tag("WEB"), @Tag("POSITIVE"), @Tag("REGRESS")})
    @CsvFileSource(resources = "/userData.csv")
    void fillFormTest(String firstName, String lastName, String email, String gender, String phoneNumber, String day,
                  String  month, String year, String subject1, String subject2, String hobby1, String hobby2,
                  String hobby3, String image, String currentAddress, String state, String city) {

        registrationPage.openPage()
                .checkTitle()
                .deleteFooterAndAdd()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(email)
                .setGender(gender)
                .setUserNumber(phoneNumber)
                .setDateBirth(day, month, year)
                .setSubjectsInput(subject1)
                .setSubjectsInput(subject2)
                .setHobbies(hobby1)
                .setHobbies(hobby2)
                .setHobbies(hobby3)
                .setImage(image)
                .setCurrentAddress(currentAddress)
                .setState(state)
                .setCity(city)
                .submit();

        modalContentComponent.checkVisible()
                        .successFormSubmissionText()
                        .checkResult("Student Name", firstName + " " + lastName)
                        .checkResult("Student Email", email)
                        .checkResult("Gender", gender)
                        .checkResult("Mobile", phoneNumber)
                        .checkResult("Date of Birth", day + " " + month + "," + year)
                        .checkResult("Subjects", subject1 + ", " + subject2)
                        .checkResult("Hobbies", hobby1 + ", " + hobby2 + ", " + hobby3)
                        .checkResult("Picture", image)
                        .checkResult("Address", currentAddress)
                        .checkResult("State and City", state + " " + city);
    }

    @ParameterizedTest(name = "Заполнение обязательных полей в форме регистрации")
    @Tags({@Tag("WEB"),@Tag("POSITIVE")})
    @CsvSource(value = {"Bruce, Wayne, Male, 7999999999, 10, November, 1990",
                        "Barry, Allen, Female, 8945612345, 12, October, 1960"})
    void fillingRequiredFieldsTest(String firstName, String lastName, String gender,
                               String phoneNumber, String day, String month, String year){
        registrationPage.openPage()
                .checkTitle()
                .deleteFooterAndAdd()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setUserNumber(phoneNumber)
                .setDateBirth(day, month, year)
                .submit();

        modalContentComponent.checkVisible()
                        .successFormSubmissionText()
                        .checkResult("Student Name", firstName + " " + lastName)
                        .checkResult("Gender", gender)
                        .checkResult("Mobile", phoneNumber)
                        .checkResult("Date of Birth", day + " " + month + "," + year);
    }


    @Tags({@Tag("SMOKE"),@Tag("NEGATIVE")})
    @ParameterizedTest(name = "Проверка регистрации с именем {0}")
    @ValueSource(strings = {"Anna", "Maksim"})
    void blankFieldsFormTest(String firstName){
        registrationPage.openPage()
                .checkTitle()
                .deleteFooterAndAdd()
                .setFirstName(firstName)
                .submit();

        modalContentComponent.checkNotBeVisible()
                .notHaveFilledForm();
    }
}
