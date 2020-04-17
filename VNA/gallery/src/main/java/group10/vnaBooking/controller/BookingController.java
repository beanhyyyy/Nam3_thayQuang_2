package group10.vnaBooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import group10.vnaBooking.entity.BookingEntity;

import java.util.List;

@RestController
@RequestMapping("/")
public class BookingController {
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private Environment env;
	
	//vja-gateway
	@RequestMapping("/")
	public String home() {
		// This is useful for debugging
		// When having multiple instance of gallery service running at different ports.
		// We load balance among them, and display which instance received the request.
		return "Hello from Gallery Service running at port: " + env.getProperty("local.server.port");
	} 
	
	@RequestMapping("/{id}/{hangbay}/{ngaydi}/{ngayve}/{noidi}/{noiden}/{nguoilon}/{treem}/{embe}") // booking qua // sua ten class,vja.booking. // sua boot VNA 9
	public BookingEntity getGallery(@PathVariable final int id, @PathVariable final String hangbay, @PathVariable final String ngaydi, @PathVariable final String ngayve, @PathVariable final String noidi, @PathVariable final String noiden, @PathVariable final int nguoilon, @PathVariable final int treem, @PathVariable final int embe) {
		// create gallery object
		BookingEntity bookingEntity = new BookingEntity();
		bookingEntity.setId(id);
		
		// get list of available images 
		List<Object> images = restTemplate.getForObject("http://image-service/images/", List.class);
		bookingEntity.setImages(images);
		
		
		return bookingEntity;
	}
	

	
	// -------- Admin Area --------
	// This method should only be accessed by users with role of 'admin'
	// We'll add the logic of role based auth later
	@RequestMapping("/admin")
	public String homeAdmin() {
		return "This is the admin area of Gallery service running at port: " + env.getProperty("local.server.port");
	}
	
	//
	@RequestMapping("/getAll")
	public BookingEntity getAll() {
		BookingEntity bookingEntity = new BookingEntity();

		// get list of available images 
		List<Object> images = restTemplate.getForObject("http://image-service/images/", List.class);
		bookingEntity.setImages(images);
		return bookingEntity;

	}
	
	
	
}