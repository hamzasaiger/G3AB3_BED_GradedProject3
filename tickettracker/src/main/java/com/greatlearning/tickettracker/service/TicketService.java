package com.greatlearning.tickettracker.service;

import java.util.List;

import com.greatlearning.tickettracker.model.TicketTracker;

public interface TicketService {
	//INSERT NEW RECORDS
		public void insertRecords(TicketTracker ticket);
		
		//PRINT ALL RECORDS
		public List<TicketTracker> getAllTickets();

		public TicketTracker getTicketById(long id);

		public void deleteTicketById(long id);

}
