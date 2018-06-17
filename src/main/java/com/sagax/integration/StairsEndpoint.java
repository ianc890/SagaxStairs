package com.sagax.integration;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.sagax.domain.StairsInfo;
import com.sagax.service.business.StairsService;
import com.sagax.service.business.StairsServiceImpl;

@Path("/stairs")
public class StairsEndpoint {
	
	@Inject
	private StairsService service = new StairsServiceImpl();
	
	// example POST request - localhost:8080/ClimbingStairs/rest/stairs/info
	// body - { 
	//			"strideSteps": 2,
	//			"stepsInFlight":[4, 9, 8, 11, 7, 20, 14]
	//		  }
	
	@POST
	@Path("/info")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String calculateNumOfStrides(String stairsData) {
		return service.calculateNumOfStrides(stairsData);
	}
	
	
	// example GET request - localhost:8080/ClimbingStairs/rest/stairs/info?stepsInStride=2&stepsPerFlight=4&stepsPerFlight=9&stepsPerFlight=8&stepsPerFlight=11&stepsPerFlight=7&stepsPerFlight=20&stepsPerFlight=14
	
	@GET
	@Path("/info")
	@Produces(MediaType.APPLICATION_JSON)
	public String countNumOfStrides(@QueryParam("stepsInStride") Integer stepsInStride, @QueryParam("stepsPerFlight") Integer[] stepsPerFlight) {	
		StairsInfo stairsInfo = new StairsInfo(stepsInStride, stepsPerFlight);
		return service.calculateNumOfStrides(stairsInfo);
	}
	
}
