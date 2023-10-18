package com.jinnov.jinnovglobalapi.util;

import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
@AllArgsConstructor
public class LocalizationUtil {

    private MessageSource messageSource;

    public String getLocalizedMessage(String key, Locale locale){
        return messageSource.getMessage(key, null, locale);
    }
}
