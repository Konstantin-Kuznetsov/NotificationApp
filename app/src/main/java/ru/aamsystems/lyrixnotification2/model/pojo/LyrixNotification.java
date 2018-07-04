package ru.aamsystems.lyrixnotification2.model.pojo;

/**
 *  Общий интерфейс всех типов сообщений Lyrix.
 *  Содержит общие для всех типов сообщений поля.
 *
 * Created by k.kuznetsov on 28.06.2018
 */
public interface LyrixNotification {

    // Базовые строки для отображения содержимого сообщения.
    String getMessageCode();

    String getMessageSource();

    String getMessageCause();

    // Статус сообщения для отображения соответствующей иконки
    // Константы message_error, message_warning, message_info
    String getMessageStatus();

    // Уникальный ID сообщения.
    long getMessageID();

    // Unix UTC
    long getMessageTime();
}
