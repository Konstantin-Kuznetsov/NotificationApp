package ru.aamsystems.lyrixnotification2.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import ru.aamsystems.lyrixnotification2.model.pojo.LyrixNotification;
import ru.aamsystems.lyrixnotification2.model.pojo.SimpleLyrixNotification;
import ru.aamsystems.lyrixnotification2.utils.TimeConverterUtil;

/**
 *  ViewModel для фрагмента со списком сообщений
 *
 * Created by k.kuznetsov on 17.08.2018
 */
public class NotificationListViewModel extends ViewModel {

    private MutableLiveData<ArrayList<? extends LyrixNotification>> notificationList = new MutableLiveData<>();
    private TimeConverterUtil timeConverterUtil  = new TimeConverterUtil();


    public LiveData<ArrayList<? extends LyrixNotification>> getNotificationsList() {
        notificationList.setValue(loadNotifications());
        return notificationList;
    }

    //todo loadNotifications должен делать запрос к БД или в сеть для получения данных, временно тестовый набор данных
    private ArrayList<? extends LyrixNotification> loadNotifications() {

        ArrayList<? extends LyrixNotification> lyrixNotificationsList
                = new ArrayList<>(Arrays.asList(
                new SimpleLyrixNotification("messageCode1", "messageSource1", "messageCause1", "messageStatus1", new Date().getTime(), 55665),
                new SimpleLyrixNotification("messageCode2", "messageSource2", "messageCause2", "messageStatus2", new Date().getTime(), 5437),
                new SimpleLyrixNotification("messageCode3", "messageSource3", "messageCause3", "messageStatus3", (new Date().getTime()) + 1000 * 60 * 60 * 24, 23556),
                new SimpleLyrixNotification("messageCode4", "messageSource4", "messageCause4", "messageStatus4", (new Date().getTime()) + 1000 * 60 * 60 * 24, 772447),
                new SimpleLyrixNotification("messageCode5", "messageSource5", "messageCause5", "messageStatus5", (new Date().getTime()) + 1000 * 60 * 60 * 24 *2, 34634),
                new SimpleLyrixNotification("messageCode6", "messageSource6", "messageCause6", "messageStatus6", (new Date().getTime()) + 1000 * 60 * 60 * 24 * 2, 77252),
                new SimpleLyrixNotification("messageCode7", "messageSource7", "messageCause7", "messageStatus7", (new Date().getTime()) + 1000 * 60 * 60 * 24 * 3, 457),
                new SimpleLyrixNotification("messageCode8", "messageSource8", "messageCause8", "messageStatus8", (new Date().getTime()) + 1000 * 60 * 60 * 24 * 3, 618),
                new SimpleLyrixNotification("messageCode9", "messageSource9", "messageCause9", "messageStatus9", (new Date().getTime()) + 1000 * 60 * 60 * 24 * 2, 8424),
                new SimpleLyrixNotification("messageCode10", "messageSource10", "messageCause10", "messageStatus10", (new Date().getTime()) + 1000 * 60 * 60 * 24 * 3, 3722),
                new SimpleLyrixNotification("messageCode11", "messageSource11", "messageCause11", "messageStatus11", (new Date().getTime()) + 1000 * 60 * 60 * 24 * 3, 6235),
                new SimpleLyrixNotification("messageCode12", "messageSource12", "messageCause12", "messageStatus12", (new Date().getTime()) + 1000 * 60 * 60 * 24 * 3, 1336),
                new SimpleLyrixNotification("messageCode13", "messageSource13", "messageCause13", "messageStatus13", (new Date().getTime()) + 1000 * 60 * 60 * 24 * 4, 347),
                new SimpleLyrixNotification("messageCode14", "messageSource14", "messageCause14", "messageStatus14", (new Date().getTime()) + 1000 * 60 * 60 * 24 * 5, 7245),
                new SimpleLyrixNotification("messageCode15", "messageSource15", "messageCause15", "messageStatus15", (new Date().getTime()) + 1000 * 60 * 60 * 24 * 5, 56134)
        ));

        return lyrixNotificationsList;
    }

}