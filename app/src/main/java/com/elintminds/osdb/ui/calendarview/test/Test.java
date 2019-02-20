package com.elintminds.osdb.ui.calendarview.test;

import com.elintminds.osdb.ui.calendarview.data.Week;
import com.elintminds.osdb.ui.calendarview.data.WeekManager;

import java.util.Arrays;


/**
 * Created by joaotrindade on 09/09/16.
 */
public class Test {
    public static void main (String[] args) {
        WeekManager manager = new WeekManager();



        int weeDay = manager.getWeekDay(10,2,2019);

        Week[] weeks = manager.getWeeks(2, 2019);

        for (Week wk : weeks) {
            System.out.println(Arrays.toString(wk.days));
        }

        System.out.println("WeekDay = "+weeDay);
    }
}
