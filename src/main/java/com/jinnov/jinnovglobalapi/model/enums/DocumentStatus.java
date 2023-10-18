package com.jinnov.jinnovglobalapi.model.enums;

import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;

import java.util.Locale;

@AllArgsConstructor
public enum DocumentStatus {
    GENERATED("generated"),
    SENT("sent"),
    SIGNED("signed");

    private final String documentStatus;

    public String getLocalizedValue(Locale locale, MessageSource messageSource){
        return messageSource.getMessage(this.documentStatus, null, locale);
    }
}
