package com.greatlearning.tickettracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.tickettracker.model.TicketTracker;
import com.greatlearning.tickettracker.service.TicketService;

@Controller
public class TicketTrackerController {
	
	@Autowired	
	TicketService tkservice;	
	@RequestMapping("/tickets")	//RequestMapping
	public String listTickets(Model model) {	
		List<TicketTracker> ticketList = tkservice.getAllTickets();	
		model.addAttribute("ticket",ticketList);	
		return "listoftickets";	
	}
	@RequestMapping("/tickets/new")	//RequestMapping
	public String addNewTicket(Model model){	
		TicketTracker result = new TicketTracker();	
		model.addAttribute("ticket",result);	
		return "createticket";
	}
	@RequestMapping("/tickets/edit/{id}")
	public String UpdateTicket(Model model, @PathVariable("id") long id){
		TicketTracker result = tkservice.getTicketById(id);
		model.addAttribute("ticket",result);
		return "editticket";
	}
	@RequestMapping("/tickets/delete/{id}")	//RequestMapping
	public String deleteTicket(@PathVariable("id") long id){	
		tkservice.deleteTicketById(id);	
		return "redirect:/tickets";
	}
	@PostMapping("/tickets/save")
	public String saveNewTicket(@RequestParam("id") long id, @RequestParam("ticketTitle") String ticketTitle,
			@RequestParam("ticketShortDes") String ticketShortDes, @RequestParam("ticketCreatedOn") String ticketCreatedOn){
		TicketTracker ticket = new TicketTracker();
		ticket.setId(id);
		ticket.setTicketTitle(ticketTitle);
		ticket.setTicketShortDes(ticketShortDes);
		ticket.setTicketCreatedOn(ticketCreatedOn);
		tkservice.insertRecords(ticket);
		return "redirect:/tickets";
	}
	@PostMapping("/tickets/{id}")
	public String updateTicket(@ModelAttribute("ticket") TicketTracker ticket, @PathVariable("id") long id){
		TicketTracker existingTicket = tkservice.getTicketById(id);
		existingTicket.setTicketTitle(ticket.getTicketTitle());
		existingTicket.setTicketShortDes(ticket.getTicketShortDes());
		existingTicket.setTicketCreatedOn(ticket.getTicketCreatedOn());
		tkservice.insertRecords(ticket);
		return "redirect:/tickets";
	}

}
