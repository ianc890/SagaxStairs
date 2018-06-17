package com.sagax.service.business;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.sagax.domain.StairsInfo;
import com.sagax.domain.StairsResult;
import com.sagax.util.JSONUtil;

public class StairsServiceImplTest {

	StairsServiceImpl stairsService = new StairsServiceImpl();
    StairsInfo stairsInfo;
	StairsResult stairsResult;
	JSONUtil util = new JSONUtil();
	String stairsData;

	@Before
	public void before() {
		stairsInfo = new StairsInfo(3, new Integer[] {17, 17});
		stairsData = util.getJSONForObject(stairsInfo);
	}

	@Test
	public void testOne() {
		Assert.assertEquals(stairsService.calculateNumOfStrides(stairsInfo), "{\"strideSteps\":3,\"stepsInFlight\":[17,17],\"totalStrides\":14}");
	}
	
	@Test
	public void testTwo() {
		System.out.println(stairsData);
		Assert.assertEquals(stairsService.calculateNumOfStrides(stairsData), "{\"strideSteps\":3,\"stepsInFlight\":[17,17],\"totalStrides\":14}");
	}

}
