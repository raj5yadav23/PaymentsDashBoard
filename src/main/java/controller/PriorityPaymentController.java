package main.java.controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import main.java.pojo.Country;
import main.java.pojo.PaymentAmount;
import main.java.service.PaymentService;
import main.java.util.Path;
import main.java.util.ViewUtil;
import spark.Request;
import spark.Response;
import spark.Route;

public class PriorityPaymentController implements PaymentService {
	
	static PriorityPaymentController controller=new PriorityPaymentController();
	
	public static Route priorityPaymentPage = (Request request,Response response) -> {
		LinkedHashMap<String,Integer> paymentStatusMap=controller.fetchPaymentStatus();
		model.put("paymentStatusMap", paymentStatusMap);
		return ViewUtil.render(request, model, Path.Templates.PRIORITY_PAYMENT_PAGE);
	};
	
	public static Route continentDataPage=(Request request,Response response) -> {
		Map<String,Object> model=new HashMap<String,Object>();
		Map<String,Object> countryMap=controller.fetchCountryList();
		Map<String,Object> paymentAmountMap=controller.fetchInFlowOutFlowList();
		LinkedHashMap<String,Integer> paymentStatusMap=controller.fetchPaymentStatus();
		model.put("countryMap", countryMap);
		model.put("paymentAmountMap", paymentAmountMap);
		model.put("paymentStatusMap", paymentStatusMap);
		return ViewUtil.render(request, model, Path.Templates.PRIORITY_PAYMENT_PAGE);
	}

	@Override
	public Map<String, Object> fetchCountryList() {
		Map<String,Object> countryMap=new HashMap<String,Object>();
		Country country=new Country();
		country.continentId="AS";
		country.countryId="CH";
		country.countryName="China";
		
		Country country1=new Country();
		country1.continentId="AS";
		country1.countryId="IN";
		country1.countryName="India";
		
		countryMap.put(country.countryId,country);
		countryMap.put(country1.countryId,country1);
		return countryMap;
	}

	@Override
	public Map<String, Object> fetchInFlowOutFlowList() {
		Map<String,Object> paymentAmountMap=new HashMap<String,Object>();
		PaymentAmount paymentAmount=new PaymentAmount();
		paymentAmount.amount=6000;
		paymentAmount.continentId="AS";
		paymentAmount.continentName="Asia";
		paymentAmount.countryFrom="India";
		paymentAmount.countryTo="China";
		
		PaymentAmount paymentAmount2=new PaymentAmount();
		paymentAmount2.amount=6000;
		paymentAmount2.continentId="AS";
		paymentAmount2.continentName="Asia";
		paymentAmount2.countryFrom="India";
		paymentAmount2.countryTo="Mexico";
		
		List<Object> indiaList=new ArrayList<Object>();
		indiaList.add(paymentAmount);
		indiaList.add(paymentAmount2);
		
		PaymentAmount paymentAmount1=new PaymentAmount();
		paymentAmount1.amount=2000;
		paymentAmount1.continentId="AS";
		paymentAmount1.continentName="Asia";
		paymentAmount1.countryFrom="China";
		paymentAmount1.countryTo="India";
		
		PaymentAmount paymentAmount3=new PaymentAmount();
		paymentAmount3.amount=2000;
		paymentAmount3.continentId="AS";
		paymentAmount3.continentName="Asia";
		paymentAmount3.countryFrom="China";
		paymentAmount3.countryTo="Japan";
		
		List<Object> chinaList=new ArrayList<Object>();
		chinaList.add(paymentAmount1);
		chinaList.add(paymentAmount3);
		
		paymentAmountMap.put(paymentAmount.countryFrom, indiaList);
		paymentAmountMap.put(paymentAmount1.countryFrom, chinaList);
		
		return paymentAmountMap;
	}
	
	public LinkedHashMap<String,Integer> fetchPaymentStatus(){
		LinkedHashMap<String,Integer> paymentStatusMap=new LinkedHashMap<String,Integer>();
		paymentStatusMap.put("Payment Created", 1234567);
		paymentStatusMap.put("Payment Authorised", 1243);
		paymentStatusMap.put("Payment Pending", 21375);
		paymentStatusMap.put("Payment Rejected", 2315);
		return paymentStatusMap;
	}
	

}
