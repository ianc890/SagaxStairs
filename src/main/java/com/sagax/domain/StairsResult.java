package com.sagax.domain;

import java.util.List;

import javax.validation.constraints.Size;

public class StairsResult {
	
	private Integer strideSteps;
	private Integer[] stepsInFlight;
	private Integer totalStrides;
	
	public StairsResult() {
		
	}
	
	public StairsResult(Integer strideSteps, Integer[] stepsInFlight, Integer totalStrides) {
		this.strideSteps = strideSteps;
		this.stepsInFlight = stepsInFlight;
		this.totalStrides = totalStrides;
	}

	public Integer getStrideSteps() {
		return strideSteps;
	}

	public void setStrideSteps(Integer strideSteps) {
		this.strideSteps = strideSteps;
	}

	public Integer[] getStepsInFlight() {
		return stepsInFlight;
	}

	public void setStepsInFlight(Integer[] stepsInFlight) {
		this.stepsInFlight = stepsInFlight;
	}

	public Integer getTotalStrides() {
		return totalStrides;
	}

	public void setTotalStrides(Integer totalStrides) {
		this.totalStrides = totalStrides;
	}
	
}
