package com.apap.tutorial5.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apap.tutorial5.model.FlightModel;
import com.apap.tutorial5.repository.FlightDb;

@Service
@Transactional
public class FlightServiceImpl implements FlightService{

	@Autowired
	private FlightDb flightDb;
	
	@Override
    public FlightModel getFlightById(Long id) {
        return flightDb.getOne(id);
    }

    @Override
    public Boolean addFlight(FlightModel flight) {
        flightDb.save(flight);
        return true;
    }

    @Override
    public Boolean deleteFlightById(long id) {
        flightDb.deleteById(id);
        return true;
    }

    @Override
    public FlightModel updateFlight(FlightModel flightModel) {
        FlightModel flightToUpdate = flightDb.getOne(flightModel.getId());
        flightToUpdate.setDestination(flightModel.getDestination());
        flightToUpdate.setFlightNumber(flightModel.getFlightNumber());
        flightToUpdate.setOrigin(flightModel.getOrigin());
        flightToUpdate.setTime(flightModel.getTime());

        flightDb.save(flightToUpdate);
        return flightToUpdate;
    }

}
