package ru.aamsystems.lyrixnotification2.model.pojo;

import ru.aamsystems.lyrixnotification2.utils.TimeConverterUtil;

/**
 *  Сообщение Lyrix, содержащее данные для отображения
 *
 * Created by k.kuznetsov on 28.06.2018
 */
public class SimpleLyrixNotification implements LyrixNotification {

    private String messageCode;
    private String messageSource;
    private String messageCause;
    private String messageStatus;
    private long messageTime;
    private long messageID;

    public SimpleLyrixNotification(String messageCode, String messageSource, String messageCause, String messageStatus, long messageTime) {
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
    public String getMessageTime() {
        return TimeConverterUtil.convertTime(messageTime, "dd/MM/yyyy") ;
    }

    @Override
    public long getMessageID() {
        return messageID;
    }
}
