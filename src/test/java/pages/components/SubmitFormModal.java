package pages.components;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;

import java.util.List;

import static com.codeborne.selenide.Selenide.$$;

public class SubmitFormModal {
    private final ElementsCollection submitFormModaleData = $$("tbody tr td:last-child");

    @Step("Check form is filled Correctly")
    public boolean isFormFilledOutCorrectly(List<String> expectedData) {
        List<String> data = submitFormModaleData
                .texts().stream()
                .filter(e -> e.length() > 2).toList();
        return expectedData.equals(data);
    }

}
