package com.jinnov.jinnovglobalapi.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.context.MessageSource;

import java.util.Locale;

@AllArgsConstructor
@Getter
public enum AcquisitionMethod {
    INCOMING_REQUEST("incomingRequest"),
    PROSPECTING("prospecting"),
    PUBLIC_TENDER("publicTender"),
    PRIVATE_TENDER("privateTender");

    private final String acquisitionMethod;

    public String getLocalizedValue(Locale locale, MessageSource messageSource){
        return messageSource.getMessage(this.acquisitionMethod, null, locale);
    }
}
