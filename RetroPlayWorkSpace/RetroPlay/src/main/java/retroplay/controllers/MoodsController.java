package retroplay.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import retroplay.models.Moods;
import retroplay.services.MoodsService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/moods")
public class MoodsController {
	
	
	@Autowired
	private MoodsService moodsService;
	
	// Returns Moods List
	// I/P  -->  none
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<Moods> getAllMoods() {
		List<Moods> moodlist = new ArrayList<Moods>();
		try {
			moodlist = moodsService.getAllMoods();
			// TO DO Logging
		} catch (Throwable e) {
			// TO DO Logging
			return null;
		}
		return moodlist;
	}

}
