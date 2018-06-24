package com.example.demo;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSon {

	public static void main(String[] args) throws JSONException {
		// TODO Auto-generated method stub
		Map <String,String> list = new HashMap<String, String> ();
		list.put("amit", "kumar");
		list.put("samrat","rai");
		list.put("Deepak","Singh");
		JSONObject array = new JSONObject();
		for ( Map.Entry<String, String> entry : list.entrySet()) {
		        array.put(entry.getKey(),entry.getValue());
		}
		System.out.println(array);
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^66666");
		JSONObject obj = new JSONObject();
		try {
		    obj.put("result", array);
		} catch (JSONException e) {
		 // TODO Auto-generated catch block
		e.printStackTrace();
		}
		System.out.println(obj);

	}

}
