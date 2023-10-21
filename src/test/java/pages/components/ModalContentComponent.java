package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ModalContentComponent {

    SelenideElement modal = $(".modal-content"),
            closeButton = $("#closeLargeModal"),
            Text = $("#example-modal-sizes-title-lg"),
            infoUserBody = $(".table-responsive"),
            bodyPage = $(".body-height");

    public ModalContentComponent checkVisible() {
        modal.should(visible);
        return this;
    }

    public ModalContentComponent successFormSubmissionText(String value){
        Text.shouldHave(text(value));
        return this;
    }

    public ModalContentComponent checkResult(String key, String value){
        infoUserBody.$(byText(key)).parent().shouldHave(text(value));
        return this;
    }

    public ModalContentComponent notHaveFilledForm(String value){
        bodyPage.shouldNotHave(text(value));
        return this;
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
