package com.sameer.myapp.egen_be_challenge;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sameer.myapp.egen_be_challenge.service.UserService;
public class UserServicetest {
	@Test
	public void adduserTest(){
		JsonObject innerObject = new JsonObject();
		innerObject.addProperty("street", "193 Talon Valley");
		innerObject.addProperty("city", "South Tate furt");
		innerObject.addProperty("zip", "47069");
		innerObject.addProperty("state", "IA");
		innerObject.addProperty("country", "US");
		JsonObject company = new JsonObject();
		company.addProperty("name", "Denesik Group");
		company.addProperty("website","http://jodie.org");
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("id", "1630215c-2608-44b9-aad4-9d56d8aafd4klwxyz2");
		jsonObject.addProperty( "firstName", "Sameer");
		jsonObject.addProperty(  "lastName", "Nadgouda");
		jsonObject.addProperty("email", "Darby_Leffler68@gmail.com");
		jsonObject.add("address", innerObject);
		jsonObject.addProperty("dateCreated", "2016-03-15T07:02:40.896Z");
		jsonObject.add("company", company);
		jsonObject.addProperty("profilePic", "http://lorempixel.com/640/480/people");
		UserService userservice=new UserService();
		String result=userservice.adduser(jsonObject.toString());
		
		JsonObject result1 = (new JsonParser()).parse(result).getAsJsonObject();
		assertEquals(result1, jsonObject);
		
		String user=userservice.getUser("1630215c-2608-44b9-aad4-9d56d8aafd4klwxyz2");
		JsonObject user1 = (new JsonParser()).parse(user).getAsJsonObject();
		assertEquals(user1, jsonObject);
		
		result=userservice.adduser(jsonObject.toString());
		assertEquals(result, "Record already present");
		jsonObject.remove("address");
		result=userservice.adduser(jsonObject.toString());
//		JsonObject result2 = (new JsonParser()).parse(result).getAsJsonObject();
		assertEquals(result, "Not a valid String");
	}
	@Test
	public void updateUser(){
		JsonObject innerObject = new JsonObject();
		innerObject.addProperty("street", "valley");
		innerObject.addProperty("city", "north");
		innerObject.addProperty("zip", "47069");
		innerObject.addProperty("state", "IA");
		innerObject.addProperty("country", "US");
		JsonObject company = new JsonObject();
		company.addProperty("name", "Denesik Group");
		company.addProperty("website","http://jodie.org");
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("id", "1630215c-2608-44b9-aad4-9d56d8aafd4klwxyz");
		jsonObject.addProperty( "firstName", "Sameer");
		jsonObject.addProperty(  "lastName", "Nadgouda1");
		jsonObject.addProperty("email", "Darby_Leffler68@gmail.com");
		jsonObject.add("address", innerObject);
		jsonObject.addProperty("dateCreated", "2016-03-15T07:02:40.896Z");
		jsonObject.add("company", company);
		jsonObject.addProperty("profilePic", "http://lorempixel.com/640/480/people");
		UserService userservice=new UserService();
		JsonObject innerObject1 = new JsonObject();
		innerObject1.addProperty("street", "valley");
		innerObject1.addProperty("city", "north");
		JsonObject jsonObject1 = new JsonObject();
		jsonObject1.addProperty("id", "1630215c-2608-44b9-aad4-9d56d8aafd4klwxyz");
		jsonObject1.add("address", innerObject1);
		jsonObject1.addProperty(  "lastName", "Nadgouda1");
		String result=userservice.updateUser(jsonObject1.toString());
		JsonObject result1 = (new JsonParser()).parse(result).getAsJsonObject();
		assertEquals(result1, jsonObject);
	}
	@Test
	public void getUsertest(){
		JsonObject innerObject = new JsonObject();
		innerObject.addProperty("street", "193 Talon Valley");
		innerObject.addProperty("city", "South Tate furt");
		innerObject.addProperty("zip", "47069");
		innerObject.addProperty("state", "IA");
		innerObject.addProperty("country", "US");
		JsonObject company = new JsonObject();
		company.addProperty("name", "Denesik Group");
		company.addProperty("website","http://jodie.org");
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("id", "1630215c-2608-44b9-aad4-9d56d8aafd4klwxyz2");
		jsonObject.addProperty( "firstName", "Sameer");
		jsonObject.addProperty(  "lastName", "Nadgouda");
		jsonObject.addProperty("email", "Darby_Leffler68@gmail.com");
		jsonObject.add("address", innerObject);
		jsonObject.addProperty("dateCreated", "2016-03-15T07:02:40.896Z");
		jsonObject.add("company", company);
		jsonObject.addProperty("profilePic", "http://lorempixel.com/640/480/people");
		UserService userservice=new UserService();
		String result=userservice.adduser(jsonObject.toString());
		JsonObject result1 = (new JsonParser()).parse(result).getAsJsonObject();
		assertEquals(result1, jsonObject);
		String user=userservice.getUser("1630215c-2608-44b9-aad4-9d56d8aafd4klwxyz2");
		JsonObject user1 = (new JsonParser()).parse(user).getAsJsonObject();
		assertEquals(user1, jsonObject);
	}
	@Test
	public void removeUser(){
		JsonObject innerObject = new JsonObject();
		innerObject.addProperty("street", "193 Talon Valley");
		innerObject.addProperty("city", "South Tate furt");
		innerObject.addProperty("zip", "47069");
		innerObject.addProperty("state", "IA");
		innerObject.addProperty("country", "US");
		JsonObject company = new JsonObject();
		company.addProperty("name", "Denesik Group");
		company.addProperty("website","http://jodie.org");
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("id", "1630215c-2608-44b9-aad4-9d56d8aafd4klwxyz2");
		jsonObject.addProperty( "firstName", "Sameer");
		jsonObject.addProperty(  "lastName", "Nadgouda");
		jsonObject.addProperty("email", "Darby_Leffler68@gmail.com");
		jsonObject.add("address", innerObject);
		jsonObject.addProperty("dateCreated", "2016-03-15T07:02:40.896Z");
		jsonObject.add("company", company);
		jsonObject.addProperty("profilePic", "http://lorempixel.com/640/480/people");
		UserService userservice=new UserService();
		String result=userservice.adduser(jsonObject.toString());
		JsonObject result1 = (new JsonParser()).parse(result).getAsJsonObject();
		assertEquals(result1, jsonObject);
		String remove=userservice.removeUser("1630215c-2608-44b9-aad4-9d56d8aafd4klwxyz2");
		assertEquals(remove, "Success");
		String user=userservice.getUser("1630215c-2608-44b9-aad4-9d56d8aafd4klwxyz2");
		assertEquals(user, "404: UserId not present");
	}
	@Test
	public void getAllusertest(){
		UserService userservice=new UserService();
		String result=userservice.getAllUsers();
		JsonParser parser = new JsonParser();
		JsonElement jsonElement = parser.parse(result);
		JsonArray noOfDocuments = jsonElement.getAsJsonArray();
		//put the no of elements present in the collections
		assertEquals(noOfDocuments.size(), 16);
	}
}
