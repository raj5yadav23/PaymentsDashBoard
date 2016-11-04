package main.java.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.java.util.Path;
import main.java.util.ViewUtil;
import spark.Request;
import spark.Response;
import spark.Route;

public class EntryController {
	
	public static Route indexPage=(Request request,Response response)-> {
		Map<String,Object> model=new HashMap<>();
		return ViewUtil.render(request,model,Path.Templates.INDEX_PAGE);
	};
	
	public static Route testPage= (Request request,Response response) -> {
		
		Map<String,Object> model=new HashMap<String,Object>();
		List<String> dataPoints=new ArrayList<String>();
		dataPoints.add("20");
		dataPoints.add("30");
		dataPoints.add("40");
		dataPoints.add("50");
		model.put("dataPoints", dataPoints);
		return ViewUtil.render(request, model, Path.Templates.TEST_PAGE);
	};

}
