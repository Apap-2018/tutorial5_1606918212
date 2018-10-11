package com.apap.tutorial5.service;

import com.apap.tutorial5.model.FlightModel;

public interface FlightService {
	
	Boolean addFlight(FlightModel flight);

    FlightModel getFlightById(Long id);

    Boolean deleteFlightById(long id);

    FlightModel updateFlight(FlightModel flightModel);
	
}
