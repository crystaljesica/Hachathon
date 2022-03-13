package com.unitedway.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.unitedway.dto.LatLong;
import com.unitedway.model.Location;
import com.unitedway.model.Relationship;

public interface LocationRepository extends CrudRepository<Location, Long>{
	Location findByAddress(String address);
	
	@Query(value = "select address, latitude, longitude, "
			+ "(3959 * acos(cos(radians(:targetLatitude)) * "
			+ "cos(radians(latitude)) * "
			+ "cos(radians(longitude) - "
			+ "radians(:targetLongitude)) + sin(radians(:targetLatitude)) "
			+ "* sin(radians(latitude)))) "
			+ "as distance from Location where relationship = :relationship "
			+ "having distance < :radius order by distance ",
//			+ "limit 1", 
			nativeQuery = true)
	List<LatLong> findLocationsWithinRadius(@Param("radius") int radius,
			@Param("targetLatitude") double targetLatitude, 
			@Param("targetLongitude") double targetLongitude,
			@Param("relationship") int relationship);
}
