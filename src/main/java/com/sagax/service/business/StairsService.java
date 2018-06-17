package com.sagax.service.business;

import com.sagax.domain.StairsInfo;

public interface StairsService {
	
	String calculateNumOfStrides(String stairsData);
	
	String calculateNumOfStrides(StairsInfo stairsInfo);
	
}
