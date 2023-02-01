package com.greatlearning.tickettracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.greatlearning.tickettracker.model.TicketTracker;
import com.greatlearning.tickettracker.service.TicketService;

@Controller
public class TicketTrackerController {
	
	@Autowired
	TicketService tkservice;
	@GetMapping("/tickets")
	public String listTickets(Model model) {
		List<TicketTracker> ticketList = tkservice.getAllTickets();
		model.addAttribute("ticket",ticketList);
		return "listoftickets";
	}
	@GetMapping("/tickets/new")
	public String addNewTicket(Model model){
		TicketTracker result = new TicketTracker();
		model.addAttribute("ticket",result);
		return "createticket";
	}
	@GetMapping("/tickets/edit/{id}")
	public String UpdateTicket(Model model, @PathVariable("id") long id){
		TicketTracker result = tkservice.getTicketById(id);
		model.addAttribute("ticket",result);
		return "editticket";
	}
	@GetMapping("/tickets/delete/{id}")
	public String deleteTicket(@PathVariable("id") long id){
		tkservice.deleteTicketById(id);
		return "redirect: /tickets";
	}
	@PostMapping("/tickets")
	public String saveNewTicket(@ModelAttribute("ticket") TicketTracker tkt){
		tkservice.insertRecords(tkt);
		return "redirect: /tickets";
	}
	
	@PostMapping("/tickets/{id}")
	public String updateTicket(@ModelAttribute("ticket") TicketTracker tkt, @PathVariable("id") long id){
		TicketTracker existingTicket = tkservice.getTicketById(id);
		existingTicket.setTicketTitle(tkt.getTicketTitle());
		existingTicket.setTicketShortDes(tkt.getTicketShortDes());
		existingTicket.setTicketCreatedOn(tkt.getTicketCreatedOn());
		tkservice.insertRecords(tkt);
		return "redirect: /tickets";
	}

}
