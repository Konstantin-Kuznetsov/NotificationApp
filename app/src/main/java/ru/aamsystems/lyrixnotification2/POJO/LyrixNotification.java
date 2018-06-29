package ru.aamsystems.lyrixnotification2.POJO;

/**
 *  Общий интерфейс всех типов сообщений Lyrix.
 *
 * Created by k.kuznetsov on 28.06.2018
 */
public interface LyrixNotification {

    // Строки для отображения содержимого сообщения.
    String getMessageCode();
    String getMessageSource();
    String getMessageCause();

    // Статус сообщения для отображения соответствующей иконки
    String getMessageStatus(); // константы message_error, message_warning, message_info

    // Unix UTC
    long getMessageTime();



}
