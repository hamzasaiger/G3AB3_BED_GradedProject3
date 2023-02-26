package com.greatlearning.tickettracker.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "tickets")
public class TicketTracker {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="ticket_id")
	private long id;
	@Column(name ="ticket_title")
	private String ticketTitle;
	@Column(name ="ticket_shortdes")
	private String ticketShortDes;
	@Column(name ="ticket_create")
	private String ticketCreatedOn;
	
	public TicketTracker() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTicketTitle() {
		return ticketTitle;
	}

	public void setTicketTitle(String ticketTitle) {
		this.ticketTitle = ticketTitle;
	}

	public String getTicketShortDes() {
		return ticketShortDes;
	}

	public void setTicketShortDes(String ticketShortDes) {
		this.ticketShortDes = ticketShortDes;
	}

	public String getTicketCreatedOn() {
		return ticketCreatedOn;
	}

	public void setTicketCreatedOn(String ticketCreatedOn) {
		this.ticketCreatedOn = ticketCreatedOn;
	}
	
	
}
