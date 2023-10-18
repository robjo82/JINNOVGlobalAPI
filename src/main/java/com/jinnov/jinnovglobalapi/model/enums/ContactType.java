package com.jinnov.jinnovglobalapi.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.context.MessageSource;

import java.util.Locale;

@Getter
@AllArgsConstructor
public enum ContactType {
    ACTIVE_MEMBER("activeMember"),
    CONTRACTOR("contractor"),
    STUDENT("student"),
    ALUMNI("alumni"),
    TEACHER("teacher"),
    SCHOOL_ADMIN("schoolAdmin"),
    EXTERNAL("external");

    private final String contactType;

    public String getLocalizedValue(Locale locale, MessageSource messageSource){
        return messageSource.getMessage(this.contactType, null, locale);
    }
}
