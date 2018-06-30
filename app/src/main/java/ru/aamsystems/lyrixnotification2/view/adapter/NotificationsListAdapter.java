package ru.aamsystems.lyrixnotification2.Utils;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import ru.aamsystems.lyrixnotification2.POJO.LyrixNotification;
import ru.aamsystems.lyrixnotification2.R;

/**
 * Created by k.kuznetsov on 28.06.2018
 */
public class NotificationsListAdapter extends RecyclerView.Adapter<NotificationsListAdapter.ViewHolder>  {

    private List<? extends LyrixNotification> notificationArrayList = null;
    private OnItemClickListener listener;
    private TimeConverterUtil timeConverter = new TimeConverterUtil();

    public interface OnItemClickListener { // интерфейс листенера кликов по элементам списка
        void onItemClick(LyrixNotification item, View selectedView);
    }


    public NotificationsListAdapter(OnItemClickListener listener) { // в конструктор передаем listener
        this.listener = listener;
    }

    // Передаем/обновляем List с актуальными данными о сообщениях. Оповещаем список о вставке
    // определенных позиций для перерисовки ViewHolder'ов только вставленных объектов с DiffUtil.
    public void setOrUpdateDataset (@NonNull ArrayListList<? extends LyrixNotification> notificationData) {
        //this.notificationArrayList = notificationData;
        if (this.notificationArrayList == null) {
            this.notificationArrayList = notificationData;
            notifyItemRangeInserted(0, articleList.size());
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
//                    return NotificationsListAdapter.this.notificationArrayList.get(oldItemPosition).getUrl() ==
//                            NotificationsListAdapter.this.notificationArrayList.get(newItemPosition).getUrl();
                }

                @Override
                public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
                    //todo переопределить
//                    LyrixNotification newNotification = notificationArrayList.get(newItemPosition);
//                    LyrixNotification oldNotification = notificationArrayList.get(oldItemPosition);
//                    return newArticle.getUrl().equals(oldArticle.getUrl())
//                            && oldArticle.getAuthor().equals(newArticle.getAuthor());
                }
            });
            this.notificationArrayList = notificationData;
            result.dispatchUpdatesTo(this);
        }
    }

//    public LyrixNotification getFirstElementData() {
//        return notificationArrayList.get(0);
//    }

    // создание "хранилица" для элемента с данными
    @NonNull
    @Override
    public NotificationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        NotificationItemBinding binding = DataBindingUtil
                .inflate(LayoutInflater.from(parent.getContext()), R.recycler_notifications_item,
                        parent, false);

        binding.setCallback(new OnClickCallback());

        return new NotificationViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(NotificationsListAdapter.ViewHolder holder, int position) {

        holder.binding.setNotificationData(notificationArrayList.get(position));
        holder.binding.executePendingBindings();

        //holder.bind(notificationArrayList.get(position), listener, position);

//        // подгрузка иконки с фотографией по Url
//        Picasso.get()
//                .load(notificationArrayList.get(position).getPhotoUrl())
//                .into(holder.notificationStatusImage);


        // статус оповещения
//        int resID = context.getResources().getIdentifier(
//                notificationArrayList.get(position).getMessageStatus(),
//                "drawable",
//                context.getPackageName());
//
//        holder.notificationStatusImage.setImageResource(resID);
//
//        // время оповещения
//        holder.notificationMessageTime.setText(timeConverter
//                .convertTime(notificationArrayList
//                        .get(position)
//                        .getMessageTime(), "dd/MM/yyyy"));
//
//        // данные из оповещения
//        holder.notificationMessageCode.setText(notificationArrayList.get(position).getMessageCode());
//        holder.notificationMessageSource.setText(notificationArrayList.get(position).getMessageSource());
//        holder.notificationMessageCause.setText(notificationArrayList.get(position).getMessageCause());

    }

    @Override
    public int getItemCount() {
        return notificationArrayList.size();
    }

    // холдер реализует OnClickListener для отслеживания выбора конкретного элемента в списке
    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView notificationMessageCode;
        private TextView notificationMessageSource;
        private TextView notificationMessageCause;
        private TextView notificationMessageTime;
        private ImageView notificationStatusImage;


        public ViewHolder(View itemView) {
            super(itemView);

            notificationMessageCode = itemView.findViewById(R.id.messageCodeCardText);
            notificationMessageSource = itemView.findViewById(R.id.messageSourceCardText);
            notificationMessageCause = itemView.findViewById(R.id.messageCauseCardText);
            notificationMessageTime = itemView.findViewById(R.id.messageTimeCardText);
            notificationStatusImage = itemView.findViewById(R.id.NotificationStatusImage);
        }

        // обработка нажатия на элемент списка
        public void bind(final LyrixNotification item, final OnItemClickListener listener, final int position) {
            itemView.setOnClickListener(view -> {
                listener.onItemClick(item, view);
            });
        }
    }

    // ViewHolder
    static class NotificationViewHolder extends RecyclerView.ViewHolder {

        final NotificationItemBinding binding;

        public NotificationViewHolder(NotificationItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
