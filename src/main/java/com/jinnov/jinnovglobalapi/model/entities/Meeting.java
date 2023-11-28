package com.jinnov.jinnovglobalapi.model.entities;

import com.google.cloud.Timestamp;
import com.jinnov.jinnovglobalapi.model.BaseEntity;

import java.util.List;

public class Meeting extends BaseEntity {
    private String object;
    private List<GuestMeeting> guests;
    private Boolean isRemote;
    private String organizerId;
    private Timestamp date;
    private Integer duration; // In minutes
    private String googleCalendarEventId; // Id of the event in the Google calendar
    private String reportURL; // URL of the report of the meeting
}
