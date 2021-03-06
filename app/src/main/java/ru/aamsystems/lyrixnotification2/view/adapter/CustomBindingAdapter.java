package ru.aamsystems.lyrixnotification2.view.adapter;

import android.databinding.BindingAdapter;
import android.view.View;
import android.widget.TextView;

import ru.aamsystems.lyrixnotification2.R;
import ru.aamsystems.lyrixnotification2.utils.TimeConverterUtil;

/**
 *  Адаптер для биндинга данных во view, с применением каких-то методов или преобразований,
 *  то, что удобнее вынести в отдельный класс.
 *
 * Created by k.kuznetsov on 04.07.2018
 */
public class CustomBindingAdapter {

    @BindingAdapter("dateText")
    public static void convertToDate(TextView view, long dateUnix) {
        if (dateUnix != 0) {
            view.setText(TimeConverterUtil.convertTime(dateUnix, "dd/MM/yyyy"));
        } else {
            view.setText(view.getContext().getText(R.string.no_data_text));
        }

    }

    @BindingAdapter("timeText")
    public static void convertToTime(TextView view, long dateUnix) {
        if (dateUnix != 0) {
            view.setText(TimeConverterUtil.convertTime(dateUnix, "HH:mm:ss"));
        } else {
            view.setText(view.getContext().getText(R.string.no_data_text));
        }

    }
}
