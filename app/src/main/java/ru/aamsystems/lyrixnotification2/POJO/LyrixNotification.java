package ru.aamsystems.lyrixnotification2.POJO;

/**
 *  Общий интерфейс всех типов сообщений Lyrix.
 *  Содержит общие для всех типов сообщений поля.
 *
 * Created by k.kuznetsov on 28.06.2018
 */
public interface LyrixNotification {

    private String messageCode;
    private String messageSource;
    private String messageCause;
    private String messageStatus;
    private long messageTime;

    public SimpleNotification(String messageCode, String messageSource, String messageCause, String messageStatus, long messageTime) {
        this.messageCode = messageCode;
        this.messageSource = messageSource;
        this.messageCause = messageCause;
        this.messageStatus = messageStatus;
        this.messageTime = messageTime;
    }

    // Базовые строки для отображения содержимого сообщения.
    public String getMessageCode() {
        return messageCode;
    }

    public String getMessageSource() {
        return messageSource;
    }

    public String getMessageCause() {
        return messageCause;
    }

    // Статус сообщения для отображения соответствующей иконки
    // Константы message_error, message_warning, message_info
    public String getMessageStatus() {
        return messageStatus;
    }

    // Unix UTC
    public long getMessageTime() {
        return messageTime;
    }
}
