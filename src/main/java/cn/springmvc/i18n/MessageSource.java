package cn.springmvc.i18n;

import org.springframework.context.support.ResourceBundleMessageSource;

/**
 * Created by free on 17-2-11.
 */
public class MessageSource extends ResourceBundleMessageSource {
    private MessageSource() {
        messageSource = this;
    }

    public static MessageSource getInstance() {
        if(messageSource == null){
            messageSource = new MessageSource();
        }
        return messageSource;
    }

    private static MessageSource messageSource;

}
