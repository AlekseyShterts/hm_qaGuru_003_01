package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class SubmitFormModal {
    private final SelenideElement submitFormModalHeader = $("#example-modal-sizes-title-lg"),
            submitFormModalTable = $(".table-responsive"),
            submitFormModal = $(".modal-dialog");

    public SubmitFormModal checkSubmitModalHeader(String value) {
        submitFormModalHeader.shouldHave(exactText(value));
        return this;
    }

    public SubmitFormModal checkSubmitFormModalTable(String key, String value) {
        submitFormModalTable.$(byText(key)).sibling(0).shouldHave(text(value));
        return this;
    }

    public SubmitFormModal submitFormModalNotExist() {
        submitFormModal.shouldNotBe(exist);
        return this;
    }

}
