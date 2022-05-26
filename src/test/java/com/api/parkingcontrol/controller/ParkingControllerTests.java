package com.api.parkingcontrol.controller;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.standaloneSetup;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;


import com.api.parkingcontrol.modules.parking.controllers.ParkingSpotController;
import com.api.parkingcontrol.modules.parking.services.ParkingSpotService;

@WebMvcTest
public class ParkingControllerTests {

    @Autowired
	private ParkingSpotController parkingSpotController;

	@MockBean
	private ParkingSpotService parkingSpotService;

    @BeforeEach
	public void setup() 
    {
		standaloneSetup( this.parkingSpotController );
	}

    @Test
	public void listAllParkingSpots() {

		// // when(this.parkingSpotService.findAll(null)).thenReturn( null);
		
		// given()
		// 	.accept(ContentType.JSON)
		// .when()
		// 	.get("/parking-spot/")
		// .then()
		// 	.statusCode(HttpStatus.OK.value());
	}

    // @Test
	// public void listParkingSpots() {

    //     UUID id = UUID.randomUUID();

	// 	when(this.parkingSpotService.findById( id )).thenReturn(null);
	// 	given()
	// 		.accept(ContentType.JSON)
	// 	.when()
	// 		.get("/parking-spot/{id}", id)
	// 	.then()
	// 		.statusCode(HttpStatus.OK.value());
	// }
	
	
}