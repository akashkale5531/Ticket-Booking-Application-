package com.nareshit.ticketbooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nareshit.ticketbooking.model.Ticket;
import com.nareshit.ticketbooking.service.TicketService;

@RestController
@RequestMapping(value="/ticket")

//http://localhost:8080/ticket ==> DispatcherServlet will Instantiate the TicketController

//TicketController obj=ioc.getTicketController();
public class TicketController {
	
	
	
	@Autowired
	private TicketService ticketService; //TicketService ticketService=ioc.getTicketService();
	
	
	/*
	 * 
	 * REST PROTOCOL ==> WEB SERVICE CALL===> HETERO GENIOUS COMMUNICATION
	 * 
	 * JSON ==> Java Script Object
	 * 
	 * Key and Value Pair Object
	 * 
	 * products JSON ==> {
	 * 
	 * 						"productid":1,
	 * 						"productName":"TV",
	 * 						"price":"50000",
	 *   					"Warranty":"5years"
	 * 
	 * 					 }
	 * 
	 * Employee JSON ==> {
	 * 						"EmpId":1,
	 * 						"empName":"Vijay",
	 * 						"salaray":"200000",
	 * 						"designation":"Software Developer"
	 * 					}
	 * 
	 * VERRBS ==> 
	 * 
	 *      GET VERB ==> GET THE DATA  ==> @Get
	 *      POST VERB ==> CREATE THE DATA  ==> @Post
	 *      PUT VERB ==> UPDATE THE DATA ==> @Put
	 *      DELETE VERB ==> DELETE THE DATA ==> @Delete
	 *      
	 *      
	 *     @Get+@RequestMapping ==> @GetMapping
	 *     @Post+@RequstMapping ==> @PostMapping
	 *     @Put+@RequestMapping ==> @PutMapping
	 *     @Delete+@RequestMapping ==> @DeleteMapping
	 *      
	 *      
	 *      
	 *      
	 *      
	 * 
	 * 
	 */
	
	
	//Get All Tickets
	
	@GetMapping(value = "/all")
	//http://localhost:8080/ticket/all ==> obj.getAllTickets();
	public Iterable<Ticket> getAllTickets(){
		
		return ticketService.getAllTickets();
		
	}
	
	//Get Individual Ticket
	//http://localhost:8080/ticket/1 ==> 1st Ticket
	//http://localhost:8080/ticket/2 ==> 2nd Ticket
	//http://localhost:8080/ticket/100 ==> 100th Ticket
	@GetMapping(value="/{ticketId}")
	public Ticket getTicket(@PathVariable("ticketId") Integer ticketId) {
		
		return ticketService.getTicket(ticketId);
		
	}
	
	
	
	
	
	
	//Create Ticket
	
	//http://localhost:8080/ticket/create ==> obj.createTicket();
	
	/*
	 * ticketobj=> {
	 * 				   "passengerName":"vijay",
	 *                  "sourceStation":"Hyderabad",
	 *                   "desgtination::"Goa",
	 *                   "email":"vijay@gmail.com"
	 *               }
	 * 
	 * JACKSON Libaray by default avaialble and it will convert JAVA TO JSON and JSON to JAVA
	 * 
	 * 
	 * Every REST REQUEST WILL HAVE BODY SECTION ==> it will read the JSON in the BODY SECTION and
	 *                     CONVERT INTO JAVA AND CALLS THE BELOW API
	 */
	@PostMapping(value="/create")
	public Ticket createTicket(@RequestBody Ticket ticketobj) {
		return ticketService.createTicket(ticketobj);
	}
	
	
	//Update Ticket
	@PutMapping(value="/{ticketId}/{newEmail}")
	//http://localhost:8080/ticket/1/a@b.com ==> update ticket set email=a@b.com where ticketid=1
	
	public Ticket updateTicket(@PathVariable("ticketId") Integer ticketId,
								@PathVariable("newEmail") String newEmail) {
		return ticketService.updateTicket(ticketId, newEmail);
	}
	
	//Update Ticket
	@PutMapping(value="/{ticketId}/{newPassengerName}")
	//http://localhost:8080/ticket/1/a@b.com ==> update ticket set email=a@b.com where ticketid=1
	
	public Ticket updatePassengerName(@PathVariable("ticketId") Integer ticketId,
								@PathVariable("newPassengerName") String newPassengerName) {
		return ticketService.updateTicket(ticketId, newPassengerName);
	}
	
	
	//Delete Ticket
	//http://localhost:8080/ticket/1 ==> Delete 1st Ticket
	//http://localhost:8080/ticket/100 ==> Delete 100th Ticket
	//http://localhost:8080/ticket/2 ==> Delete 2nd Ticket
	
	@DeleteMapping(value="/{ticketId}")
	
	public void deleteTicket(@PathVariable("ticketId") Integer ticketId) {
		ticketService.deleteTicket(ticketId);
	}
	

}
