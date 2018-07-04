package ru.aamsystems.lyrixnotification2.view.callback;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import ru.aamsystems.lyrixnotification2.model.pojo.LyrixNotification;

/**
 * Created by k.kuznetsov on 02.07.2018
 */
public class OnItemClickCallback {

    // Обработка клика по карточке оповещения в RecyclerView, смена фрагментов
    // в соответствии с типом сообщения.
    public void onClick(View view, LyrixNotification notificationItemData) {


        Context context = view.getContext();

        switch (notificationItemData.getMessageStatus()) {

            case "***":
            {

            }
            case "****":
            {

            }
            default:
            {
                Toast.makeText(context, notificationItemData.getMessageStatus(), Toast.LENGTH_SHORT).show();
            }
        }
//        Intent i = new Intent(context, NewsDetailActivity.class);
//        i.putExtra("url", article.getUrl());
//        context.startActivity(i);
    }
}
