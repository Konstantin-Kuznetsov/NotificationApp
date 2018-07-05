package ru.aamsystems.lyrixnotification2.view.ui.fragments;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;


import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import ru.aamsystems.lyrixnotification2.R;
import ru.aamsystems.lyrixnotification2.databinding.FragmentNotificationListBinding;
import ru.aamsystems.lyrixnotification2.model.pojo.LyrixNotification;
import ru.aamsystems.lyrixnotification2.model.pojo.SimpleLyrixNotification;
import ru.aamsystems.lyrixnotification2.view.adapter.NotificationsListAdapter;

public class NotificationListFragment extends Fragment {

    // Адаптер RecyclerView со списком сообщений
    private NotificationsListAdapter notificationsListAdapter;
    // Биндер fragment_notification_list.xml к элементам ui фрагмента со списком сообщений.
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
        binding.notificationsRecyclerView.setAdapter(notificationsListAdapter);
        binding.notificationsRecyclerView.setHasFixedSize(true);
        binding.notificationsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        // Флаг начала процесса загрузки данных в список (обновление из БД, запрос в сеть и т.д.. )
        // После окончания подгрузки - снимается, на этот флаг можно повесить изменение ui.
        binding.setIsDataLoading(true);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //todo тут подключение к источнику данных и обновление списка (устанавливается адаптеру), сделать с LiveData
        ArrayList<? extends LyrixNotification> lyrixNotificationsList
                = new ArrayList<>(Arrays.asList(
                        new SimpleLyrixNotification("messageCode1", "messageSource1", "messageCause1", "messageStatus1", new Date().getTime()),
                        new SimpleLyrixNotification("messageCode2", "messageSource2", "messageCause2", "messageStatus2", new Date().getTime()),
                        new SimpleLyrixNotification("messageCode3", "messageSource3", "messageCause3", "messageStatus3", (new Date().getTime()) + 1000 * 60 * 60 * 24),
                        new SimpleLyrixNotification("messageCode4", "messageSource4", "messageCause4", "messageStatus4", (new Date().getTime()) + 1000 * 60 * 60 * 24),
                        new SimpleLyrixNotification("messageCode5", "messageSource5", "messageCause5", "messageStatus5", (new Date().getTime()) + 1000 * 60 * 60 * 24 *2),
                        new SimpleLyrixNotification("messageCode6", "messageSource6", "messageCause6", "messageStatus6", (new Date().getTime()) + 1000 * 60 * 60 * 24 * 2),
                        new SimpleLyrixNotification("messageCode7", "messageSource7", "messageCause7", "messageStatus7", (new Date().getTime()) + 1000 * 60 * 60 * 24 * 3),
                        new SimpleLyrixNotification("messageCode8", "messageSource8", "messageCause8", "messageStatus8", (new Date().getTime()) + 1000 * 60 * 60 * 24 * 3),
                        new SimpleLyrixNotification("messageCode9", "messageSource9", "messageCause9", "messageStatus9", (new Date().getTime()) + 1000 * 60 * 60 * 24 * 2),
                        new SimpleLyrixNotification("messageCode10", "messageSource10", "messageCause10", "messageStatus10", (new Date().getTime()) + 1000 * 60 * 60 * 24 * 3),
                        new SimpleLyrixNotification("messageCode11", "messageSource11", "messageCause11", "messageStatus11", (new Date().getTime()) + 1000 * 60 * 60 * 24 * 3),
                        new SimpleLyrixNotification("messageCode12", "messageSource12", "messageCause12", "messageStatus12", (new Date().getTime()) + 1000 * 60 * 60 * 24 * 3),
                        new SimpleLyrixNotification("messageCode13", "messageSource13", "messageCause13", "messageStatus13", (new Date().getTime()) + 1000 * 60 * 60 * 24 * 4),
                        new SimpleLyrixNotification("messageCode14", "messageSource14", "messageCause14", "messageStatus14", (new Date().getTime()) + 1000 * 60 * 60 * 24 * 5),
                        new SimpleLyrixNotification("messageCode15", "messageSource15", "messageCause15", "messageStatus15", (new Date().getTime()) + 1000 * 60 * 60 * 24 * 5)
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
