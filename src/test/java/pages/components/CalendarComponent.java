package pages.components;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


public class CalendarComponent {
    private final SelenideElement cMonth = $(".react-datepicker__month-select"),
            cYear = $(".react-datepicker__year-select");
    private final ElementsCollection cDay = $$(".react-datepicker__day:not(.react-datepicker__day--outside-month)");

    public void setDate(String month, String year, String day) {
        cMonth.selectOption(month);
        cYear.selectOption(year);
        cDay.findBy(text(day)).click();
    }
}
