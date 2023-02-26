package com.greatlearning.tickettracker.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.tickettracker.model.TicketTracker;
import com.greatlearning.tickettracker.repository.TicketRepository;
import com.greatlearning.tickettracker.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService{

	@Autowired
	TicketRepository ticketrepo;
	
	@Override
	public void addNewTicket (TicketTracker ticket){
		ticketrepo.save(ticket);
	}
	
	@Override
	public List<TicketTracker> getAllTickets() {
		return ticketrepo.findAll();
	}


	@Override
	public TicketTracker getTicketById(long id) {
		return ticketrepo.findById(id).get();
	}

	@Override
	public void deleteTicketById(long id) {
		ticketrepo.deleteById(id);
	}
}
