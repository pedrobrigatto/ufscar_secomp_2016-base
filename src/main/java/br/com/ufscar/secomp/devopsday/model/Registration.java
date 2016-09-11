package br.com.ufscar.secomp.devopsday.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;

@Entity
public class Registration extends DomainObject {

	private static final long serialVersionUID = -5140906509138484515L;
	
	private LocalDateTime date;
	private Attendee attendee;
	private Session session;
	
	public Registration() {
		super();
	}
	
	public Registration(LocalDateTime date, Attendee attendee, Session session) {
		this();
		this.date = date;
		this.attendee = attendee;
		this.session = session;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public Attendee getAttendee() {
		return attendee;
	}

	public void setAttendee(Attendee attendee) {
		this.attendee = attendee;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}
}
