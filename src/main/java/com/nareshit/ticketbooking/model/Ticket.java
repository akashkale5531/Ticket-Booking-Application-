package com.nareshit.ticketbooking.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * 
 * Every Java Class is table
 * 
 * @Entity ==> This will create a sql statment with "create table..."
 *         ==> Java class name is the table name
 * @Table ==> Optional ==> Customizes the table name
 * 
 * Every Java Property will table column
 * By default Java property name will be column name
 * 
 * @Column is also optional which will customizes the column
 * 
 * @Id ==> It will create primary Key
 * 
 * Primary Key Auto Population can be done both at JPA and Database Level
 * 
 * JPA will create a database sequence and it will use this sequence for populating primary key ==> AUTO
 * 
 */


@Entity
@Table(name = "tbl_ticket")
public class Ticket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ticket_id")
	private Integer ticketId;
	
	@Column(name = "passenger_name")
	private String passengerName;
	
	
	@Column(name="source_station")
	private String sourceStation;
	
	@Column(name="destination_station")
	private String destinationStation;
	
	@Column(name="travel_date")
	private Date travelDate;
	
	private String email;

	public Integer getTicketId() {
		return ticketId;
	}

	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public String getSourceStation() {
		return sourceStation;
	}

	public void setSourceStation(String sourceStation) {
		this.sourceStation = sourceStation;
	}

	public String getDestinationStation() {
		return destinationStation;
	}

	public void setDestinationStation(String destinationStation) {
		this.destinationStation = destinationStation;
	}

	public Date getTravelDate() {
		return travelDate;
	}

	public void setTravelDate(Date travelDate) {
		this.travelDate = travelDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	public Ticket() {}
	public Ticket( String passengerName, String sourceStation, String destinationStation,
			 String email) {
		super();
		
		this.passengerName = passengerName;
		this.sourceStation = sourceStation;
		this.destinationStation = destinationStation;
		this.travelDate = new Date();
		this.email = email;
	}

	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", passengerName=" + passengerName + ", sourceStation=" + sourceStation
				+ ", destinationStation=" + destinationStation + ", travelDate=" + travelDate + ", email=" + email
				+ "]";
	}
	
	
	
	
	
	
	

}
