package com.jinnov.jinnovglobalapi.model.entities;

import com.jinnov.jinnovglobalapi.model.BaseEntity;
import com.jinnov.jinnovglobalapi.model.enums.Language;
import com.jinnov.jinnovglobalapi.model.enums.Theme;

public class Preference extends BaseEntity {
    private Language language;
    private Theme theme;
}
