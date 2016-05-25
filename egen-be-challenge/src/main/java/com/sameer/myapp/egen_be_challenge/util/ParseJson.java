package com.sameer.myapp.egen_be_challenge.util;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sameer.myapp.egen_be_challenge.model.Address;
import com.sameer.myapp.egen_be_challenge.model.User;
public class ParseJson {
	public String getValue(String str,String key){

		JSONObject obj = new JSONObject(str);
		String value = obj.getString(key);
		return value;
	}
	public Map<String,String> getKeys(String str){
		Field[] fields = User.class.getDeclaredFields();
		Field[] addressfields = Address.class.getDeclaredFields();
		Field[] companyfields = Address.class.getDeclaredFields();
		Set<String> user=new HashSet<>();
		Set<String> address=new HashSet<>();
		Set<String> company=new HashSet<>();

		for(Field field:fields){
			user.add(field.getName());
		}

		for(Field addressfield:addressfields){
			address.add(addressfield.getName());
		}
		for(Field companyfield:companyfields){
			company.add(companyfield.getName());
		}
		JsonElement jelement = new JsonParser().parse(str);
		JsonObject  jobject = jelement.getAsJsonObject();
		Map<String,String> map=new HashMap<>();
		if(jobject.get("company") != null){
			JsonObject  jobjectCompany = jobject.get("Company").getAsJsonObject();
			jobject.remove("company");
			Set<Entry<String, JsonElement>> entrySetcompany = jobjectCompany.entrySet();
			for(Map.Entry<String, JsonElement> entry : entrySetcompany) {
				map.put("company"+"."+entry.getKey(),entry.getValue().toString());
			}
		}


		if(jobject.get("address") != null){
			JsonObject  jobjectAddress = jobject.get("address").getAsJsonObject();
			jobject.remove("address");
			Set<Entry<String, JsonElement>> entrySetAddress = jobjectAddress.entrySet();
			for(Map.Entry<String, JsonElement> entry : entrySetAddress) {
				map.put("address"+"."+entry.getKey(),entry.getValue().toString());
			}
		}
		Set<Entry<String, JsonElement>> entrySet = jobject.entrySet();
		for(Map.Entry<String, JsonElement> entry : entrySet) {
			map.put(entry.getKey(),entry.getValue().toString());
		}
		return map;
	}
	public Boolean validate(String str){
		Field[] fields = User.class.getDeclaredFields();
		Field[] addressfields = Address.class.getDeclaredFields();
		Field[] companyfields = Address.class.getDeclaredFields();
		Set<String> user=new HashSet<>();
		Set<String> address=new HashSet<>();
		Set<String> company=new HashSet<>();

		for(Field field:fields){
			user.add(field.getName());
		}

		for(Field addressfield:addressfields){
			address.add(addressfield.getName());
		}
		for(Field companyfield:companyfields){
			company.add(companyfield.getName());
		}
		JsonElement jelement = new JsonParser().parse(str);
		JsonObject  jobject = jelement.getAsJsonObject();
		if(jobject.get("company") != null){
			JsonObject  jobjectCompany = jobject.get("company").getAsJsonObject();
			Set<Entry<String, JsonElement>> entrySetcompany = jobjectCompany.entrySet();
			jobject.remove("company");
			for(Map.Entry<String, JsonElement> entry : entrySetcompany) {
				if(!company.contains(entry.getKey())){
					return false;
				}
			}
		}

		if(jobject.get("address") != null){
			JsonObject  jobjectAddress = jobject.get("address").getAsJsonObject();
			Set<Entry<String, JsonElement>> entrySetcompany = jobjectAddress.entrySet();
			jobject.remove("address");
			for(Map.Entry<String, JsonElement> entry : entrySetcompany) {
				if(!address.contains(entry.getKey())){
					return false;
				}
			}
		}
		Set<Entry<String, JsonElement>> entrySet = jobject.entrySet();
		for(Map.Entry<String, JsonElement> entry : entrySet) {
			if(!user.contains(entry.getKey()) ){
				return false;
			}
		}
		return true;
	}
}
