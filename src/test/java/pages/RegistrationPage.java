package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import utils.cutom.FooterAndAdd;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {

    String uri = "/automation-practice-form";
    String title = "Student Registration Form";
    String pathImage = "img/";

    CalendarComponent calendar = new CalendarComponent();
    FooterAndAdd footerAndAdd = new FooterAndAdd();

    SelenideElement titleLabel = $(".practice-form-wrapper"),
                    firstNameInput = $("#firstName"),
                    lastNameInput = $("#lastName"),
                    userEmailInput = $("#userEmail"),
                    genderWrapper = $("#genterWrapper"),
                    userNumberInput = $("#userNumber"),
                    dateBirth = $("#dateOfBirthInput"),
                    subjectsInput =$("#subjectsInput"),
                    hobbies = $("#hobbiesWrapper"),
                    image = $("#uploadPicture"),
                    currentAddress = $("#currentAddress"),
                    state = $("#stateCity-wrapper"),
                    city = $("#stateCity-wrapper"),
                    submitButton = $("#submit");

    public RegistrationPage openPage(){
        open(uri);
        return this;
    }

    public RegistrationPage checkTitle(){
        titleLabel.shouldHave(text(title));
        return this;
    }

    public RegistrationPage deleteFooterAndAdd(){
        footerAndAdd.deleteFooterAndAdd();
        return this;
    }

    public RegistrationPage setFirstName(String value){
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value){
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setUserEmail(String value){
        userEmailInput.setValue(value);
        return this;
    }

    public RegistrationPage setGender(String value){
        genderWrapper.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setUserNumber(String value){
        userNumberInput.setValue(value);
        return this;
    }

    public RegistrationPage setDateBirth(String day, String month, String year){
        dateBirth.click();
        calendar.setDate(day, month, year);
        return this;
    }

    public RegistrationPage setSubjectsInput(String value){
        subjectsInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage setHobbies(String value){
        hobbies.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setImage(String value){
        image.uploadFromClasspath(pathImage + value);
        return this;
    }

    public RegistrationPage setCurrentAddress(String value){
        currentAddress.setValue(value);
        return this;
    }

    public RegistrationPage setState(String value){
        $("#state").click();
        state.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setCity(String value){
        $("#city").click();
        city.$(byText(value)).click();
        return this;
    }

    public void submit(){
        submitButton.click();
    }
}
