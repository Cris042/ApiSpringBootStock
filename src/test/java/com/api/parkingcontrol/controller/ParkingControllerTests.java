package com.api.parkingcontrol.controller;

import com.api.parkingcontrol.modules.parking.controllers.ParkingSpotController;
import com.api.parkingcontrol.modules.parking.entities.ParkingSpotEntities;
import com.api.parkingcontrol.modules.parking.services.ParkingSpotService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = ParkingControllerTests.class)
public class ParkingControllerTests {

	@InjectMocks
	ParkingSpotController parkingSpotController;

	@Mock
	ParkingSpotService parkingSpotService;

	@Test
	public void testBasicScenario() 
	{
		Page<ParkingSpotEntities> pages = parkingSpotService.findAll(null); 
		Mockito.when( parkingSpotController.getAllParkingSpots( (Pageable) pages ))
		.thenReturn( null );
	}

    
	
}