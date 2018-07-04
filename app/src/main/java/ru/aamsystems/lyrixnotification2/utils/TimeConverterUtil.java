package ru.aamsystems.lyrixnotification2.utils;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 *  Утилита преобразования времени Unix в строку определенного вида.
 *
 * Created by k.kuznetsov on 29.06.2018
 */
public class TimeConverterUtil {
    // Принимает время в Unix, UTC формате и паттерн преобразования, возвращает строку.
    public static String convertTime(long dateUtc, String pattern){
        Date date = new Date(dateUtc);
        Format sdf = new SimpleDateFormat(pattern, Locale.getDefault());
        return sdf.format(date);
    }

    public static int compareDates(long dateUtc1, long dateUtc2) {
        Calendar calendar1 = Calendar.getInstance(Locale.getDefault());
        Calendar calendar2 = Calendar.getInstance(Locale.getDefault());
        calendar1.setTimeInMillis(dateUtc1);
        calendar2.setTimeInMillis(dateUtc2);

        return calendar1.get(Calendar.DAY_OF_YEAR) - calendar2.get(Calendar.DAY_OF_YEAR);
    }
}
