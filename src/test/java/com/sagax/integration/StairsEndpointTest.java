package com.sagax.integration;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.sagax.domain.StairsInfo;
import com.sagax.util.JSONUtil;

public class StairsEndpointTest {

	StairsEndpoint stairsEndpoint = new StairsEndpoint();
    StairsInfo stairsInfo;
	JSONUtil util = new JSONUtil();
	String stairsData;

	@Before
	public void before() {
		stairsInfo = new StairsInfo(3, new Integer[] {17});
		stairsData = util.getJSONForObject(stairsInfo);
	}

	
	@Test
	public void postTest() {
		System.out.println(stairsData);
		Assert.assertEquals(stairsEndpoint.calculateNumOfStrides(stairsData), "{\"strideSteps\":3,\"stepsInFlight\":[17],\"totalStrides\":6}");
	}
	
	@Test
	public void getTest() {
		Assert.assertEquals(stairsEndpoint.countNumOfStrides(stairsInfo.getStrideSteps(), stairsInfo.getStepsInFlight()), "{\"strideSteps\":3,\"stepsInFlight\":[17],\"totalStrides\":6}");
	}

}
