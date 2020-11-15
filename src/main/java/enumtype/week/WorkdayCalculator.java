package enumtype.week;

import debug.employees.Employee;

import java.util.ArrayList;
import java.util.List;

public class WorkdayCalculator {

    private Day nextday(Day day) {
        if (day.ordinal() == Day.values().length - 1) {
            return Day.values()[0];
        } else {
            return Day.values()[day.ordinal() + 1];
        }
    }

    public List<DayType> dayTypes(Day firstDay, int numberOfDays) {
        List<DayType> types = new ArrayList<>();
        Day d = firstDay;
        for (int i = 0; i < numberOfDays; i++) {
            types.add(d.getDayType());
            d = nextday(d);
        }
        return types;
    }
}