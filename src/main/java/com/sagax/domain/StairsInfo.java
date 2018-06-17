package com.sagax.domain;

import javax.validation.constraints.Size;

public class StairsInfo {
	
	private final int minStrideSteps = 1;
	private final int maxStrideSteps = 4;
	
	private final int minFlightSteps = 1;
	private final int maxFlightSteps = 20;
	
	private final int minFlights = 1;
	private final int maxFlights = 30;
		
	@Size(min = minStrideSteps, max = maxStrideSteps)
	private int strideSteps;
	@Size(min = minFlights, max = maxFlights)
	private Integer[] stepsInFlight;
	
	public StairsInfo() {
		
	}
	
	public StairsInfo(int strideSteps, Integer[] stepsInFlight) {
		this.strideSteps = strideSteps;
		this.stepsInFlight = stepsInFlight;
	}

	public int getStrideSteps() {
		return strideSteps;
	}

	public void setStrideSteps(int strideSteps) {
		this.strideSteps = strideSteps;
	}

	public Integer[] getStepsInFlight() {
		return stepsInFlight;
	}

	public void setStepsInFlight(Integer[] stepsInFlight) {
		this.stepsInFlight = stepsInFlight;
	}

	public void validateConstraints(Integer stepsInStride, Integer[] stepsPerFlight) {
	     checkStepsInStride(stepsInStride);
		 checkFlightsInStairWell(stepsPerFlight);
	}
	
	public void checkStepsInStride(Integer stepsInStride) throws IllegalArgumentException {
		if(!(stepsInStride >= 1) && !(stepsInStride <= 4)) {
			throw new IllegalArgumentException("Invalid number of steps entered for a stride!");
		}	
	}

	public void checkFlightsInStairWell(Integer[] stepsPerFlight) throws IllegalArgumentException {
        if(!(stepsPerFlight.length >= 1) && !(stepsPerFlight.length <= 30)) {
            throw new IllegalArgumentException("Invalid flight size!");
        }

        checkStepsPerFlight(stepsPerFlight);
	}
	
	private void checkStepsPerFlight(Integer[] stepsPerFlight) throws NullPointerException, IllegalArgumentException {

        for(Integer flight : stepsPerFlight) {
            if(flight == null) {
                throw new NullPointerException("Invalid null value entered for flight value");
            }
            if(flight > 20) {
                throw new IllegalArgumentException("Invalid value entered for flight value");
            }
        }
    }

}
