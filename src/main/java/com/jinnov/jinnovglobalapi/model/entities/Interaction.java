package com.jinnov.jinnovglobalapi.model.entities;

import com.google.cloud.Timestamp;
import com.jinnov.jinnovglobalapi.model.BaseEntity;

import java.util.List;

public class Interaction extends BaseEntity {
    private String object;
    private String senderId; // There is a choice between stack only email, or an id to a user in the database -> Id allow to understand if this is a client, a contractor or a project manager, but it is more complicated to implement and obligates to create a user in the database for each sender or receiver
    private String receiverId;
    private Timestamp date;
    private String HTMLContent;
    private String textContent;
    private List<String> labels;
    private Integer numberOfAttachments;
    private String threadId; // Id of the thread in which this interaction is
}
