package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;


public class CalendarComponent {
    private final SelenideElement cMonth = $(".react-datepicker__month-select"),
            cYear = $(".react-datepicker__year-select"),
            cDay = $("#dateOfBirth").$(".react-datepicker__month");

    public void setDate(String month, String year, String day) {
        cMonth.selectOption(month);
        cYear.selectOption(year);
        cDay.find(byText(day)).click();
    }

}
