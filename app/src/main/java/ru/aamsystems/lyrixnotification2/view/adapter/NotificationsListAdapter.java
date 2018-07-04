package ru.aamsystems.lyrixnotification2.view.adapter;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import ru.aamsystems.lyrixnotification2.databinding.RecyclerNotificationsItemBinding;
import ru.aamsystems.lyrixnotification2.model.pojo.LyrixNotification;
import ru.aamsystems.lyrixnotification2.R;
import ru.aamsystems.lyrixnotification2.utils.TimeConverterUtil;
import ru.aamsystems.lyrixnotification2.view.callback.OnItemClickCallback;

/**
 * Created by k.kuznetsov on 28.06.2018
 */
public class NotificationsListAdapter extends RecyclerView.Adapter<NotificationsListAdapter.NotificationViewHolder>  {

    private List<? extends LyrixNotification> notificationArrayList = null;

    // Передаем/обновляем List с актуальными данными о сообщениях. Оповещаем список о вставке
    // определенных позиций для перерисовки ViewHolder'ов только вставленных объектов с DiffUtil.
    public void setOrUpdateDataset (@NonNull ArrayList<? extends LyrixNotification> notificationData) {
        if (this.notificationArrayList == null) {
            this.notificationArrayList = notificationData;
            notifyItemRangeInserted(0, notificationArrayList.size());
        } else {
            DiffUtil.DiffResult result = DiffUtil.calculateDiff(new DiffUtil.Callback() {
                @Override
                public int getOldListSize() {
                    return NotificationsListAdapter.this.notificationArrayList.size();
                }

                @Override
                public int getNewListSize() {
                    return notificationArrayList.size();
                }

                @Override
                public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
                    //todo переопределить
                    return notificationArrayList.get(oldItemPosition).getMessageID() == notificationArrayList.get(newItemPosition).getMessageID();
                }

                @Override
                public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
                    //todo переопределить hashcode
                    LyrixNotification newNotification = notificationArrayList.get(newItemPosition);
                    LyrixNotification oldNotification = notificationArrayList.get(oldItemPosition);
                    return newNotification.equals(oldNotification);
                }
            });

            this.notificationArrayList = notificationData;
            result.dispatchUpdatesTo(this);
        }
    }

    // создание "хранилица" для элемента с данными
    @NonNull
    @Override
    public NotificationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // Установка объекта для блока <data> макета
        // Биндер данных из объекта-сообщения в элементы ui
        RecyclerNotificationsItemBinding binding = DataBindingUtil
                .inflate(LayoutInflater.from(parent.getContext()), R.layout.recycler_notifications_item,
                        parent, false);

        binding.setCallback(new OnItemClickCallback());

        return new NotificationViewHolder(binding);
    }

    // Возвращает константу типа сообщения - информационное, ошибка и т.д.
    // Используется для подгрузки разных типов макетов для разных типов сообщений Lyrix.
    @Override
    public int getItemViewType(int position) {
        // todo переопределить в соответствии с имеющимися типами сообщений
        return super.getItemViewType(position);
    }

    @Override
    public void onBindViewHolder(NotificationViewHolder holder, int position) {
        if (position == 0 ||
                TimeConverterUtil.compareDates(
                        notificationArrayList.get(position - 1).getMessageTime(),
                        notificationArrayList.get(position).getMessageTime()) != 0) {
            holder.binding.setDateHeaderVisibility(true);
        } else {
            holder.binding.setDateHeader(false);
        }

        holder.binding.setDateHeaderVisibility(true);
        holder.binding.setNotificationItemData(notificationArrayList.get(position));
        holder.binding.executePendingBindings();

    }

    @Override
    public int getItemCount() {
        return notificationArrayList == null ? 0 : notificationArrayList.size();
    }

    // холдер реализует OnClickListener для отслеживания выбора конкретного элемента в списке
    static class NotificationViewHolder extends RecyclerView.ViewHolder {
        private final RecyclerNotificationsItemBinding binding;

        public NotificationViewHolder(RecyclerNotificationsItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
