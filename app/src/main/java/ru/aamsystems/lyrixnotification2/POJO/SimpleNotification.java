package ru.aamsystems.lyrixnotification2.POJO;

/**
 *  Сообщение Lyrix, содержащее данные для отображения
 *
 * Created by k.kuznetsov on 28.06.2018
 */
public class SimpleNotification implements LyrixNotification {

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

    @Override
    public String getMessageCode() {
        return messageCode;
    }

    @Override
    public String getMessageSource() {
        return messageSource;
    }

    @Override
    public String getMessageCause() {
        return messageCause;
    }

    @Override
    public String getMessageStatus() {
        return messageStatus;
    }

    @Override
    public long getMessageTime() {
        return messageTime;
    }
}
