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
	public void insertRecords (TicketTracker tkt){
		ticketrepo.save(tkt);
	}
	
	@Override
	public List<TicketTracker> getAllTickets() {
		return ticketrepo.findAll();
	}


	@Override
	public TicketTracker getTicketById(Long id) {
		return ticketrepo.findById(id).get();
	}

	@Override
	public void deleteTicketById(Long id) {
		ticketrepo.deleteById(id);
	}
}
