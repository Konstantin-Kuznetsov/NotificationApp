package ru.aamsystems.lyrixnotification2.view.ui.fragments;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
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
import ru.aamsystems.lyrixnotification2.viewmodel.NotificationListViewModel;

public class NotificationListFragment extends Fragment {

    // Адаптер RecyclerView со списком сообщений
    private NotificationsListAdapter notificationsListAdapter;
    // Биндер fragment_notification_list.xml к элементам ui фрагмента со списком сообщений.
    // Биндер всегда должен называться так же как и xml, с приставкой Binder к названию.
    private FragmentNotificationListBinding binding;

    private NotificationListViewModel viewModel;

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
        viewModel = ViewModelProviders.of(this).get(NotificationListViewModel.class);

        // подписка на изменения списка сообщений
        subscribeToNotificationListChanges();

    }

    // подписка на изменение списка сообщений и обновление UI.
    private void subscribeToNotificationListChanges() {
        binding.setIsDataLoading(true);

        viewModel.getNotificationsList()
                .observe(this, new Observer<ArrayList<? extends LyrixNotification>>() {
                    @Override
                    public void onChanged(@Nullable ArrayList<? extends LyrixNotification> lyrixNotificationsList) {
                        notificationsListAdapter.setOrUpdateDataset(lyrixNotificationsList);
                    }
                });

        binding.setIsDataLoading(false);
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
