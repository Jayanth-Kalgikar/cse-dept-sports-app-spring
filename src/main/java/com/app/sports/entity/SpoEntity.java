package com.app.sports.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class SpoEntity {

    @Id
    private int eventId;
    private String eventName;
    private String eventDate;
    private String sportName;
    private String sportType;
	public SpoEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SpoEntity(int eventId, String eventName, String eventDate, String sportName, String sportType) {
		super();
		this.eventId = eventId;
		this.eventName = eventName;
		this.eventDate = eventDate;
		this.sportName = sportName;
		this.sportType = sportType;
	}
	public int getEventId() {
		return eventId;
	}
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getEventDate() {
		return eventDate;
	}
	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}
	public String getSportName() {
		return sportName;
	}
	public void setSportName(String sportName) {
		this.sportName = sportName;
	}
	public String getSportType() {
		return sportType;
	}
	public void setSportType(String sportType) {
		this.sportType = sportType;
	}
	@Override
	public String toString() {
		return "SpoEntity [eventId=" + eventId + ", eventName=" + eventName + ", eventDate=" + eventDate
				+ ", sportName=" + sportName + ", sportType=" + sportType + "]";
	}
    
    
    
    

   
}
