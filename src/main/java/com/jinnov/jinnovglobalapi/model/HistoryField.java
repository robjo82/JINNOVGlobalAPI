package com.jinnov.jinnovglobalapi.model;

import com.google.cloud.Timestamp;
import com.google.cloud.firestore.annotation.ServerTimestamp;

public class HistoryField<T> {
    @ServerTimestamp
    private Timestamp timestamp;
    private T value;
}
