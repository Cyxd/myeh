package com.cyxd.demo.demo2;

import java.util.List;

import org.json.JSONObject;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JSONDemo {
	
	public static void main(String[] args) {
		
		JSONDto jsond1 = new JSONDto("1", "Tom", 12, 24, "12124.4");
		JSONDto jsond2 = new JSONDto("2", "Jettry", 13, 14, "14124.4");
		JSONDto jsond3 = new JSONDto("3", "Jackson", 15, 13, "1124.4");
		
		List<JSONDto> jsonList = null; 
		
		System.out.println("Ali Begin="+System.currentTimeMillis());
		//Alibba的Jar包
		String jsonAfter = JSON.toJSONString(jsond1);
		System.out.println("Ali End="+System.currentTimeMillis());
		System.out.println(jsonAfter);
		
		System.out.println("Google Begin 1="+System.currentTimeMillis());
		//Google的Jar包
		String jsonAfter2 = new GsonBuilder().create().toJson(jsond2, JSONDto.class);
		System.out.println("Google End 1="+System.currentTimeMillis());
		System.out.println(jsonAfter2);
		
		System.out.println("Google Begin 2="+System.currentTimeMillis());
		String jsonAfter3 = new GsonBuilder().create().toJson(jsond3, JSONDto.class);
		System.out.println("Google End 2="+System.currentTimeMillis());
		System.out.println(jsonAfter3);
		
		
		System.out.println("Google Begin 3="+System.currentTimeMillis());
		//Google的Jar包
		String jsonAfter4 = new Gson().toJson(jsond1, JSONDto.class);
		System.out.println("Google End 3="+System.currentTimeMillis());
		System.out.println(jsonAfter4);
		
		System.out.println("JSON Begin 1="+System.currentTimeMillis());
		//JSON的Jar包
		JSONObject json = new JSONObject(jsond3);
		System.out.println("JSON End 1="+System.currentTimeMillis());
		System.out.println(json.toString());
		
		
		System.out.println("JSON Begin 2="+System.currentTimeMillis());
		//JSON的Jar包
		
		System.out.println("JSON End 2="+System.currentTimeMillis());
		System.out.println(json.toString());
		
	}

}
