package io.group10.booking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.group10.booking.entity.Booking;


@RestController
@RequestMapping("/")
public class HomeController {
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private Environment env;
	
	@RequestMapping("/")
	public String home() {
		// This is useful for debugging
		// When having multiple instance of gallery service running at different ports.
		// We load balance among them, and display which instance received the request.
		return "Hello from Booking Service running at port: " + env.getProperty("local.server.port");
	}
  
	@RequestMapping("/ticket/{fim}")
	public Booking getBooking(@PathVariable String fim) {
		
		Booking booking = new Booking();
		org.json.simple.JSONArray array = new org.json.simple.JSONArray();
		String[] hang = fim.split(",");
		for (int i = 0; i < hang.length; i++) {
			String result = restTemplate.getForObject("http://"+hang[i]+"-gateway/"+hang[i]+"/tickets", String.class);	
			try {
				Object obj = new org.json.simple.parser.JSONParser().parse(result);
				org.json.simple.JSONObject ob = (org.json.simple.JSONObject) obj;
				org.json.simple.JSONArray arr = (org.json.simple.JSONArray) ob.get("ticket");
				org.json.simple.JSONObject newObj = new org.json.simple.JSONObject();
				newObj.put(hang[i], arr);
				array.add(newObj);
			}catch (org.json.simple.parser.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		booking.setTicket((List<Object>) array);
		return booking;
	}
	
	/*new Ticket(1,50000000,"HCM","HAN","VJA","04052020",15),*/
	/*http://localhost:8762/ticket/vna,vja/HCM/HAN/04052020*/
	@RequestMapping("/ticket/{fim}/{flightFrom}/{flightTo}/{date}")
	public Booking getBooking(@PathVariable String fim, @PathVariable String flightFrom,@PathVariable String flightTo,@PathVariable String date) {
		
		Booking booking = new Booking();
		org.json.simple.JSONArray array = new org.json.simple.JSONArray();
		String[] hang = fim.split(",");
		for (int i = 0; i < hang.length; i++) {
			String result = restTemplate.getForObject("http://"+hang[i]+"-gateway/"+hang[i]+"/tickets", String.class);	
			try {
				Object obj = new org.json.simple.parser.JSONParser().parse(result);
				org.json.simple.JSONObject ob = (org.json.simple.JSONObject) obj;
				org.json.simple.JSONArray arr = (org.json.simple.JSONArray) ob.get("ticket");
				org.json.simple.JSONObject newObj = new org.json.simple.JSONObject();
				newObj.put(hang[i], arr);
				array.add(newObj);
			}catch (org.json.simple.parser.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		booking.setTicket((List<Object>) array);
		return booking;
	}

	
	
	// -------- Admin Area --------
	// This method should only be accessed by users with role of 'admin'
	// We'll add the logic of role based auth later
	@RequestMapping("/admin")
	public String homeAdmin() {
		return "This is the admin area of Gallery service running at port: " + env.getProperty("local.server.port");
	}
}