package com.jinnov.jinnovglobalapi.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.context.MessageSource;

import java.util.Locale;

@Getter
@AllArgsConstructor
public enum AcquisitionStep {
    CONTACT_DATABASE("contactDatabase"),
    CONTACTED("contacted"), // message received
    MESSAGE_READ("messageRead"),
    PROSPECT("prospect"),
    QUALIFIED_PROSPECT("qualifiedProspect"),
    INTERESTED_PROSPECT("interestedProspect"),
    FOLLOW_UP("followUp"), // additional information requested, reminders
    LEAD("lead"), // quotation sent
    NEGOTIATION("negotiation"),
    SIGNING("signing"),
    CUSTOMER("customer");

    private final String acquisitionStep;

    public String getLocalizedValue(Locale locale, MessageSource messageSource){
        return messageSource.getMessage(this.acquisitionStep, null, locale);
    }
}
