package com.nareshit.ticketbooking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nareshit.ticketbooking.dao.TicketDao;
import com.nareshit.ticketbooking.model.Ticket;

@Service

/*
 * 
 * Where we will write our business Logic
 * Also It has implemented Transaction Managment capability
 * 
 * WE will interact with TICKETDAO 
 */
public class TicketService {
	
	//TicketDao obj=new TicketDao();
	@Autowired
	private TicketDao ticketDao;
	
	
	//Retrieve All Tickets
	
	public Iterable<Ticket> getAllTickets(){
		
		return ticketDao.findAll();
		//findAll ==> select * from tbl_ticket;
		//ResultSet will converted into Iterable<Ticket>
		
	}
	
	
	
	//Retrieve Individual Ticket
	
	public Ticket getTicket(Integer ticketId) {
		
		return ticketDao.findById(ticketId).
				orElse(new Ticket());
		
		//findById ==> select * from tbl_ticket where ticket_id=ticketId
		//Resultset will converted into Ticket Java Object
		
	}
	
	
	
	//Create Ticket
	
	
	public Ticket createTicket(Ticket ticketObj) {
		
		//ticketObj.setTicketId(100);
		//insert into tbl_ticket values(100,....);
		return ticketDao.save(ticketObj);
		
		//save  ==> insert into tbl_ticket values(ticketObj.passenger.......);
		
	}
	
	//Update Ticket
	
	public Ticket updateTicket(Integer ticketId,String newEmail) {
		
		//save Method ==> Both Insert and Update
		
		//if ticketObj.ticketId is null ==> Insert the data
		//if ticketObj.ticketId is not null and ticketid is not there in the database ==> Insert
		
		//if ticketObj.ticketObj is not null and ticketId is there in the database ==> Update
		
		
		Ticket dbTicketObj=getTicket(ticketId);
		dbTicketObj.setEmail(newEmail);
		
		//IN this case dbTicketObj.ticketid ==> is there in the database hence it will udpate
		
		return ticketDao.save(dbTicketObj);
		
		//save ==> update tbl_ticket set email=newEmail where ticket_id=ticketId;
		
	}
	
	public Ticket updatePassenger(Integer ticketId,String newpassengerName) {
		Ticket dbTicketObj=getTicket(ticketId);
		dbTicketObj.setPassengerName(newpassengerName);
		return ticketDao.save(dbTicketObj);
		
	}
		
	//Delete Ticket
	
	public void deleteTicket(Integer ticketId) {
		ticketDao.deleteById(ticketId);
		//deleteById ==> delete from tbl_ticket where ticket_id=ticketId;
		
	}
	
	
	
	
	
	

}
