package ru.aamsystems.lyrixnotification2.view.ui.fragments;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;


import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.aamsystems.lyrixnotification2.R;
import ru.aamsystems.lyrixnotification2.databinding.FragmentNotificationDetailsBinding;
import ru.aamsystems.lyrixnotification2.model.pojo.SimpleLyrixNotification;

public class NotificationDetailsFragment extends Fragment {

    private FragmentNotificationDetailsBinding binding;

    public NotificationDetailsFragment() {
        // Required empty public constructor
    }

    public static NotificationDetailsFragment newInstance() {
        return new NotificationDetailsFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_notification_details, container, false);

        binding.setNotificationItemData(
                new SimpleLyrixNotification(
                        getArguments().getString("MessageCode"),
                        getArguments().getString("MessageSource"),
                        getArguments().getString("MessageCause"),
                        getArguments().getString("MessageStatus"),
                        getArguments().getLong("MessageTime"),
                        getArguments().getLong("MessageID")));

        return binding.getRoot();
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
