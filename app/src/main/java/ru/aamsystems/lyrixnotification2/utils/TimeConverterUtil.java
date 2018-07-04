package ru.aamsystems.lyrixnotification2.utils;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 *  Утилита преобразования времени Unix в строку определенного вида.
 *
 * Created by k.kuznetsov on 29.06.2018
 */
public class TimeConverterUtil {
    // Принимает время в Unix, UTC формате и паттерн преобразования, возвращает строку.
    public static String convertTime(long time, String pattern){
        Date date = new Date(time);
        Format sdf = new SimpleDateFormat(pattern, Locale.getDefault());
        return sdf.format(date);
    }
}
