package com.app.sports.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class SpoEntity {

    @Id
    private int EventId;
    private String EventName;
    private String EventDate;
    private String SportName;
    private String SportType;

    public SpoEntity(int eventId, String eventName, String eventDate, String sportName, String sportType) {
        super();
        EventId = eventId;
        EventName = eventName;
        EventDate = eventDate;
        SportName = sportName;
        SportType = sportType;
    }

    public SpoEntity() {
        super();
    }

    public int getEventId() {
        return EventId;
    }

    public void setEventId(int eventId) {
        EventId = eventId;
    }

    public String getEventName() {
        return EventName;
    }

    public void setEventName(String eventName) {
        EventName = eventName;
    }

    public String getEventDate() {
        return EventDate;
    }

    public void setEventDate(String eventDate) {
        EventDate = eventDate;
    }

    public String getSportName() {
        return SportName;
    }

    public void setSportName(String sportName) {
        SportName = sportName;
    }

    public String getSportType() {
        return SportType;
    }

    public void setSportType(String sportType) {
        SportType = sportType;
    }

    @Override
    public String toString() {
        return "SpoEntity [EventId=" + EventId + ", EventName=" + EventName + ", EventDate=" + EventDate
                + ", SportName=" + SportName + ", SportType=" + SportType + "]";
    }
}
