package io.group10.ticket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.group10.ticket.entity.Ticket;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/")
public class HomeController {
	@Autowired
	private Environment env;

	@RequestMapping("/")
	public String home() {
		// This is useful for debugging
		// When having multiple instance of image service running at different ports.
		// We load balance among them, and display which instance received the request.
		return "Hello from Image Service running at port: " + env.getProperty("local.server.port");
	}
		
	/*this.id = id;
	this.price = price;
	this.flightFrom = flightFrom;
	this.flightTo = flightTo;
	this.type = type;
	this.date = date;
	this.available = available;
	this.level = level;
	*/
	
	@RequestMapping("/tickets")
	public List<Ticket> getTickets() {
		List<Ticket> ticket = Arrays.asList(
			new Ticket(1,50000000,"HCM","HAN","VJA","04052020",15),
			new Ticket(2,75000000,"HAN","HCM","VJA","05052020",20),
			new Ticket(3,25000000,"DAN","HCM","VJA","06052020",25)
			);
		return ticket;
	}
}