package ru.aamsystems.lyrixnotification2.view.UI.fragments;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;


import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Arrays;

import ru.aamsystems.lyrixnotification2.R;
import ru.aamsystems.lyrixnotification2.databinding.FragmentNotificationListBinding;
import ru.aamsystems.lyrixnotification2.model.pojo.LyrixNotification;
import ru.aamsystems.lyrixnotification2.model.pojo.SimpleLyrixNotification;
import ru.aamsystems.lyrixnotification2.view.adapter.NotificationsListAdapter;

public class NotificationListFragment extends Fragment {

    // Адаптер RecyclerView со списком сообщений
    private NotificationsListAdapter notificationsListAdapter;
    // Биндер fragment_notification_list.xml к элементам UI фрагмента со списком сообщений.
    // Биндер всегда должен называться так же как и xml, с приставкой Binder к названию.
    private FragmentNotificationListBinding binding;

    public NotificationListFragment() {
        // Required empty public constructor
    }

    public static NotificationListFragment newInstance() {
        return new NotificationListFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_notification_list, container, false);
        notificationsListAdapter = new NotificationsListAdapter();
        binding.notoficationsRecyclerView.setAdapter(notificationsListAdapter);
        // Флаг начала процесса загрузки данных в список (обновление из БД, запрос в сеть и т.д.. )
        // После окончания подгрузки - снимается, на этот флаг можно повесить изменение UI.
        binding.setIsDataLoading(true);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //todo тут подключение к источнику данных и обновление списка (устанавливается адаптеру), сделать с LiveData
        ArrayList<? extends LyrixNotification> lyrixNotificationsList
                = new ArrayList<>(Arrays.asList(
                        new SimpleLyrixNotification("messageCode1", "messageSource1", "messageCause1", "messageStatus1", System.currentTimeMillis()),
                        new SimpleLyrixNotification("messageCode2", "messageSource2", "messageCause2", "messageStatus2", System.currentTimeMillis()),
                        new SimpleLyrixNotification("messageCode3", "messageSource3", "messageCause3", "messageStatus3", System.currentTimeMillis()),
                        new SimpleLyrixNotification("messageCode4", "messageSource4", "messageCause4", "messageStatus4", System.currentTimeMillis()),
                        new SimpleLyrixNotification("messageCode5", "messageSource5", "messageCause5", "messageStatus5", System.currentTimeMillis()),
                        new SimpleLyrixNotification("messageCode6", "messageSource6", "messageCause6", "messageStatus6", System.currentTimeMillis()),
                        new SimpleLyrixNotification("messageCode7", "messageSource7", "messageCause7", "messageStatus7", System.currentTimeMillis()),
                        new SimpleLyrixNotification("messageCode8", "messageSource8", "messageCause8", "messageStatus8", System.currentTimeMillis()),
                        new SimpleLyrixNotification("messageCode9", "messageSource9", "messageCause9", "messageStatus9", System.currentTimeMillis()),
                        new SimpleLyrixNotification("messageCode10", "messageSource10", "messageCause10", "messageStatus10", System.currentTimeMillis()),
                        new SimpleLyrixNotification("messageCode11", "messageSource11", "messageCause11", "messageStatus11", System.currentTimeMillis()),
                        new SimpleLyrixNotification("messageCode12", "messageSource12", "messageCause12", "messageStatus12", System.currentTimeMillis()),
                        new SimpleLyrixNotification("messageCode13", "messageSource13", "messageCause13", "messageStatus13", System.currentTimeMillis()),
                        new SimpleLyrixNotification("messageCode14", "messageSource14", "messageCause14", "messageStatus14", System.currentTimeMillis()),
                        new SimpleLyrixNotification("messageCode15", "messageSource15", "messageCause15", "messageStatus15", System.currentTimeMillis())
        ));

        notificationsListAdapter.setOrUpdateDataset(lyrixNotificationsList);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
