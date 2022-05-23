package com.api.parkingcontrol.controller;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.standaloneSetup;
import io.restassured.http.ContentType;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

import com.api.parkingcontrol.modules.parking.controllers.ParkingSpotController;
import com.api.parkingcontrol.modules.parking.services.ParkingSpotService;
import com.api.parkingcontrol.modules.user.controllers.UserController;
import com.api.parkingcontrol.modules.user.services.UserService;

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
		
		given()
			.accept(ContentType.JSON)
		.when()
			.get("/parking-spot/")
		.then()
			.statusCode(HttpStatus.OK.value());
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