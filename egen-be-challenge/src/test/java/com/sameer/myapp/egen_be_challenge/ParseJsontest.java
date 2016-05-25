package com.sameer.myapp.egen_be_challenge;
import org.junit.Test;

import com.google.gson.JsonObject;
import com.sameer.myapp.egen_be_challenge.util.ParseJson;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;
public class ParseJsontest {
	@Test
	public void testgetKeys(){
		ParseJson parsejson=new ParseJson();
		JsonObject innerObject = new JsonObject();
		innerObject.addProperty("street", "john");

		JsonObject jsonObject = new JsonObject();
		jsonObject.add("address", innerObject);
		jsonObject.addProperty("firstName", "Maclean");
		Map<String,String> map=parsejson.getKeys(jsonObject.toString());
		Map<String,String> expectedMap=new HashMap<>();
		expectedMap.put("address.street", "john");
		expectedMap.put("firstName", "Maclean");		
		assertTrue(expectedMap.equals(map));
		expectedMap.remove("firstName");
		expectedMap.put("secondName","John");
		assertFalse(expectedMap.equals(map));
		
		
	}
}
