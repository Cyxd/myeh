package com.cyxd.demo.json;

import org.json.JSONArray;
import org.json.JSONObject;

public class JsonConverTest {
    
    public static void main(String[] args) {
	
	String normalStr = "e01086f4fd6a408ab07be09a85ce43d7,03adee33b11a4f06b267740939895e6e,7053fc58afaf46e7aa12f52f75716fcd";
	String advancedStr = "[{key:'44badcf5fc7c4564b9a27a0354d522e5',value:'美国投资者移民'},]".replace("},]", "}]");
	System.out.println(advancedStr);
	
	String advancedStr2 = "{val:[{key:'44badcf5fc7c4564b9a27a0354d522e5',value:'美国投资者移民'},{key:'ssss',value:'美国投资者移民'}]}";
	
	JSONObject json = new JSONObject(advancedStr2);
//	JSONObject json2 = new JSONObject(json.getString("val"));
	
	JSONArray jarr = new JSONArray(advancedStr);
	
	System.out.println(json.get("val"));
//	System.out.println(json2.get("key"));
	
	
	
	System.out.println(jarr.get(0));
	System.out.println(jarr.getJSONObject(0).get("key"));
	
	
	
    }

}
