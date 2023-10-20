package com.jinnov.jinnovglobalapi.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Theme {
    LIGHT("light"),
    DARK("dark"),
    SYSTEM("system");

    private final String code;
}
