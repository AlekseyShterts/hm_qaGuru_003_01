package pages.components;

import com.codeborne.selenide.SelenideElement;

import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    private final SelenideElement
            cMonth = $(".react-datepicker__month-select"),
            cYear = $(".react-datepicker__year-select");
    private final SelenideElement dateOfBirthInput = $("#dateOfBirthInput");

    public void setDateOfBirthByFake(String date) {
        List<String> splitDate = Arrays.asList(date.split("\\s|,"));
        dateOfBirthInput.click();
        cMonth.selectOption(splitDate.get(1));
        cYear.selectOption(splitDate.get(2));
        $(String.format(".react-datepicker__day--0%s:not(.react-datepicker__day--outside-month)", splitDate.get(0)))
                .click();
    }
}