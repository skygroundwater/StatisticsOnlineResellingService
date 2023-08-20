package com.example.kafkaconsumer.statics;

import com.example.kafkaconsumer.model.User;
import com.example.kafkaconsumer.model.activity.DailyActivity;
import com.example.kafkaconsumer.model.activity.MonthlyActivity;

public final class Activities {

    private static volatile DailyActivity dailyActivity = new DailyActivity();

    private static volatile MonthlyActivity monthlyActivity = new MonthlyActivity();

    private static MonthlyActivity intermediateMonthly;

    private static DailyActivity intermediateDaily;


    public static DailyActivity getInstanceAndRefreshDaily() {
        intermediateDaily = dailyActivity;
        dailyActivity = new DailyActivity();
        return intermediateDaily;
    }

    public static MonthlyActivity getInstanceAndRefreshMonthly() {
        intermediateMonthly = monthlyActivity;
        monthlyActivity = new MonthlyActivity();
        return intermediateMonthly;
    }

    public static boolean addUserToDaily(User user) {
        return dailyActivity.getUsers().add(user);
    }

    public static boolean addUserToMonthly(User user) {
        return monthlyActivity.getUsers().add(user);
    }



}
