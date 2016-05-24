package com.sameer.myapp.egen_be_challenge.util;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.*;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
public class ParseJson {
	public String getValue(String str,String key){

		JSONObject obj = new JSONObject(str);
		String value = obj.getString(key);
		return value;
	}
	public Boolean validate(String str,Set<String> db){
		JsonElement jelement = new JsonParser().parse(str);
		JsonObject  jobject = jelement.getAsJsonObject();
		Set<Map.Entry<String, JsonElement>> entrySet = jobject.entrySet();
		Set <String> st=new HashSet<>();
		for(Map.Entry<String, JsonElement> entry : entrySet) {
			st.add(entry.getKey());
		}
		for(String key:st){
			if(!db.contains(key)){
				return false;
			}
		}
		return true;
	}
}
