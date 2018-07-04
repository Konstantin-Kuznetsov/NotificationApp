package ru.aamsystems.lyrixnotification2.view.adapter;

import android.databinding.BindingAdapter;
import android.view.View;
import android.widget.TextView;

import ru.aamsystems.lyrixnotification2.utils.TimeConverterUtil;

/**
 *  Адаптер для биндинга данных во view, с применением каких-то методов или преобразований,
 *  то, что удобнее вынести в отдельный класс.
 *
 * Created by k.kuznetsov on 04.07.2018
 */
public class CustomBindingAdapter {
    @BindingAdapter("visibleHeader")
    public static void showHide(View view, boolean show) {
        view.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    @BindingAdapter("dateText")
    public static void convertToDate(TextView view, long dateUnix) {
        view.setText(TimeConverterUtil.convertTime(dateUnix, "dd/MM/yyyy"));
    }

    @BindingAdapter("timeText")
    public static void convertToTime(TextView view, long dateUnix) {
        view.setText(TimeConverterUtil.convertTime(dateUnix, "HH:mm:ss"));
    }
}
