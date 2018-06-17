package com.sagax.service.business;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import com.sagax.domain.StairsInfo;
import com.sagax.domain.StairsResult;
import com.sagax.util.JSONUtil;

public class StairsServiceImpl implements StairsService {
	
	@Inject
	private JSONUtil util = new JSONUtil();
	
	private static int STEPS_BETWEEN_FLIGHTS = 2;

	public String calculateNumOfStrides(String stairsData) {
		StairsInfo stairsInfo = util.getObjectForJSON(stairsData, StairsInfo.class);		

		return calculateNumOfStrides(stairsInfo);
	}

	public String calculateNumOfStrides(StairsInfo stairsInfo) {
		stairsInfo.validateConstraints(stairsInfo.getStrideSteps(), stairsInfo.getStepsInFlight());

        Integer stridesCounter = 0;

		List<Integer> l = Arrays.asList(stairsInfo.getStepsInFlight());
		Iterator<Integer> flightsIterator = l.iterator();
		while (flightsIterator.hasNext()) {

			Integer flight = flightsIterator.next();

			int stepsInFlight = flight / stairsInfo.getStrideSteps();
			int stridesToFinishFlight = flight % stairsInfo.getStrideSteps() == 0 ? 0 : 1;

			stridesCounter += stepsInFlight + stridesToFinishFlight;

			if (flightsIterator.hasNext()) {
				stridesCounter += STEPS_BETWEEN_FLIGHTS;
			}
		}

		 StairsResult stairsResult = new StairsResult(stairsInfo.getStrideSteps(), stairsInfo.getStepsInFlight(), stridesCounter);

		 return util.getJSONForObject(stairsResult);
		//return Integer.toString(stridesCounter);
	}

}
