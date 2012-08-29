package jp.itacademy.samples.web.mvc.week;

import java.util.Calendar;

public class DayOfWeek {

    private Calendar cal;

    public DayOfWeek(int year, int month, int date) {
        cal = Calendar.getInstance();
        cal.set(year, month, date);
    }

    public String getDayOfWeek() {
        switch (cal.get(Calendar.DAY_OF_WEEK)) {
        case 1:
            return "��";
        case 2:
            return "��";
        case 3:
            return "��";
        case 4:
            return "��";
        case 5:
            return "��";
        case 6:
            return "��";
        case 7:
            return "�y";
        default:
            throw new InternalError();
        }
    }

}
