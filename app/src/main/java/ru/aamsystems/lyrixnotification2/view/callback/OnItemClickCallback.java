package ru.aamsystems.lyrixnotification2.view.callback;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import ru.aamsystems.lyrixnotification2.R;
import ru.aamsystems.lyrixnotification2.model.pojo.LyrixNotification;
import ru.aamsystems.lyrixnotification2.view.ui.activities.MainActivity;

/**
 * Created by k.kuznetsov on 02.07.2018
 */
public class OnItemClickCallback {

    // Анимация перехода к подробной информации по выбранному сообщению(новый фрагмент въезжает справа).
    NavOptions navOptionsListToDetails = new NavOptions
            .Builder()
            .setEnterAnim(R.anim.nav_custom_exit_anim).build();

    // Обработка клика по карточке оповещения в RecyclerView, смена фрагментов
    // в соответствии с типом сообщения.
    public void onClick(View view, LyrixNotification notificationItemData) {


        Context context = view.getContext();

        switch (notificationItemData.getMessageStatus()) {

            case "***":
            {
                // в зависимости от типа сообщения можно переходить на разные фрагменты,
                // например, показывать фотографию и что-то подробное по человеку,
                // другой фрагмент для сообщений о пожаре или проникновении и т.д
            }
            case "****":
            {

            }
            // переход в фрагменту с подробной информацией по выбранному сообщению
            default:
            {
                //todo: сделать Message parcelable и передавать его целиком
                Bundle selectedNotificationBundle = new Bundle();

                selectedNotificationBundle.putString("MessageCode", notificationItemData.getMessageCode());
                selectedNotificationBundle.putString("MessageCause", notificationItemData.getMessageCause());
                selectedNotificationBundle.putString("MessageSource", notificationItemData.getMessageSource());
                selectedNotificationBundle.putLong("MessageID", notificationItemData.getMessageID());
                selectedNotificationBundle.putLong("MessageTime", notificationItemData.getMessageTime());
                selectedNotificationBundle.putString("MessageStatus", notificationItemData.getMessageStatus());




                Navigation.findNavController(view).navigate(
                        R.id.notificationDetailsFragment,
                        selectedNotificationBundle,
                        navOptionsListToDetails);
            }
        }
    }
}
