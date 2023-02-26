package com.greatlearning.tickettracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greatlearning.tickettracker.model.TicketTracker;

@Repository
public interface TicketRepository extends JpaRepository<TicketTracker, Long> {

}
