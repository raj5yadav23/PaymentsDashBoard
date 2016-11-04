package main.java.service;

import java.util.Map;

public interface PaymentService {
	
	public  Map<String,Object> fetchCountryList();
	
	public  Map<String,Object> fetchInFlowOutFlowList();

}
