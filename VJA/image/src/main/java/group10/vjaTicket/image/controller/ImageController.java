package group10.vjaTicket.image.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import group10.vjaTicket.image.entity.ImageEntity;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/")
public class ImageController {
	@Autowired
	private Environment env;

	@RequestMapping("/")
	public String home() {
		// This is useful for debugging
		// When having multiple instance of image service running at different ports.
		// We load balance among them, and display which instance received the request.
		return "Hello from Image Service running at port: " + env.getProperty("local.server.port");
	}
	
	//{	    
	// id
	//		"hangbay": VJA
	//      "ngaydi": "10/4/2020",
	//      "ngayve": "15/4/2020",
	//     "noidi": "SGN",
	//      "noiden": "HAN",
	//      "nguoilon": 2,
	//      "treem": 2,
	//      "embe": 1
	//}
	// Nhap dai du~ lieu..tam` 15 20 dong`..j cung dc..
	@RequestMapping("/imagesVJA")
	public List<ImageEntity> getImages() {
		List<ImageEntity> imageEntitiesVJA = Arrays.asList(
			new ImageEntity(1,"VJA" ,"10/4/2020", "15/4/2020", "SGN", "HAN", 2, 2, 1),
			new ImageEntity(2,"VJA","10/4/2020", "15/4/2020", "SGN1", "HAN", 2, 2, 1),
			new ImageEntity(3,"VJA","10/4/2020", "15/4/2020", "SGN1", "HAN", 2, 2, 1));
		return imageEntitiesVJA;
	}
}