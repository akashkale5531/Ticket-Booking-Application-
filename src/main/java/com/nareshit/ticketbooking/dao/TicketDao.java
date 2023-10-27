package com.nareshit.ticketbooking.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nareshit.ticketbooking.model.Ticket;

/*
 * 
 * DAO ==> Data Access object ==> Wrapper Layer to work with Database 
 * ==> Any operations to the database we will go with DAO
 * 
 * @Repository ==> Which will make a connection to the database
 * 
 * CRUD Operations  ==> Creating,Reading , Updating and Deleting
 * 
 * CrudRepository ==> Is created to automate CRUD Operations where
 * 					 developer no need to write any Database code
 * 
 * 			2 Inputs ==>
 * 						i) ClassName 
 * 						ii) Datatype of the Primary Key
 */

@Repository
public interface TicketDao extends CrudRepository<Ticket, Integer> {
	
	
	/*
	 * 
	 * save ==> Insert the data or Update the data
	 * findById ==> Retrieve the Data 
	 * findAll ==> Retrieve All the data
	 * deleteById ==> delete the specific record
	 * 
	 */

}
