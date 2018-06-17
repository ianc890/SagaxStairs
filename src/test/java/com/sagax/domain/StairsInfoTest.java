package com.sagax.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.sagax.util.JSONUtil;

public class StairsInfoTest {

    StairsInfo stairsInfo;
	JSONUtil util = new JSONUtil();
	String stairsData;

	@Before
	public void before() {
		stairsInfo = new StairsInfo(3, new Integer[] {17});
		stairsData = util.getJSONForObject(stairsInfo);
	}

	
	@Test
	public void checkStepsInStrideTest() {
		Assert.assertEquals(stairsInfo.getStrideSteps(), 3);
	}
	
	@Test
	public void checkFlightsInStairWellTest() {
		Assert.assertEquals(stairsInfo.getStepsInFlight(), new Integer[] {17});
	}


}
