package com.unitedway.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.unitedway.dto.LatLong;
import com.unitedway.model.Relationship;
import com.unitedway.repository.LocationRepository;

@RestController
@RequestMapping("api/")
public class Controller {
	
	@Autowired
	private LocationRepository locationRepository;
	
	@GetMapping("locationsWithinRadius")
	public @ResponseBody List<LatLong> getLocationsWithinRadius(@RequestParam int radius,
			@RequestParam double latitude,
			@RequestParam double longitude,
			@RequestParam int relationshipCode) {
		
		return locationRepository
				.findLocationsWithinRadius(radius, latitude, longitude, relationshipCode);
	}
}
