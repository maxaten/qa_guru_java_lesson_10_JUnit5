package pages.components;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ModalContentComponent {

    String successSubmissionText = "Thanks for submitting the form";

    SelenideElement modal = $(".modal-content"),
            closeButton = $("#closeLargeModal"),
            Text = $("#example-modal-sizes-title-lg"),
            infoUserBody = $(".table-responsive"),
            bodyPage = $(".body-height");

    public ModalContentComponent checkVisible() {
        modal.should(visible);
        return this;
    }

    public ModalContentComponent successFormSubmissionText(){
        Text.shouldHave(text(successSubmissionText));
        return this;
    }

    public ModalContentComponent checkResult(String key, String value){
        infoUserBody.$(byText(key)).parent().shouldHave(text(value));
        return this;
    }

    public void notHaveFilledForm(){
        bodyPage.shouldNotHave(text(successSubmissionText));
    }

    public ModalContentComponent clickCloseButton(){
        closeButton.click();
        return this;
    }

    public ModalContentComponent checkNotBeVisible() {
        modal.should(hidden);
        return this;
    }
}
