package com.jinnov.jinnovglobalapi.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.context.MessageSource;

import java.util.Locale;

@AllArgsConstructor
@Getter
public enum ServiceStatus {
    UNDER_STUDY("underStudy"),
    ACTIVE("active"),
    SUSPENDED("suspended");

    private final String value;

    public String getLocalizedValue(Locale locale, MessageSource messageSource){
        return messageSource.getMessage(this.value, null, locale);
    }
}
