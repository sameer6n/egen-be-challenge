package com.sameer.myapp.egen_be_challenge.service;
import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.sameer.myapp.egen_be_challenge.model.User;
import com.sameer.myapp.egen_be_challenge.util.JSONUtils;
import com.sameer.myapp.egen_be_challenge.util.ParseJson;
public class UserService {


	MongoClient client=new MongoClient();
	MongoDatabase db=client.getDatabase("new-test");
	MongoCollection<Document> coll=db.getCollection("things");
	Gson gson = new Gson();

	public String getAllUsers(){
		List<Document> all=coll.find().into(new ArrayList<Document>());
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(all);
		System.out.println(json);
		return json;
	}
	
	public User getUser(String id){
		Bson filter=new Document("id",id);
		Document obj=(Document) coll.find(filter).first();
		if(obj!=null){
			User user=gson.fromJson(obj.toJson(),User.class);
			return user;
		}
		else{
			return null;	
		}
	}
	public int updateUser(String id){
		if(JSONUtils.isJSONValid(id)){
			ParseJson parseJson=new ParseJson();
			String uniqueid=parseJson.getValue(id, "id");
			Bson filter=new Document("id",uniqueid);
			Document doc=coll.find(filter).first();
			if(doc!=null){
				coll.deleteOne(filter);
				Document user1=Document.parse(id) ;
				coll.insertOne(user1);
				return 200;
			}
			else{
				return 404;
			}
		}
		return 415;
	}
	public int removeUser(String id){
		Bson filter=new Document("id",id);
		Document doc=coll.find(filter).first();
		if(doc!=null){
			coll.deleteOne(filter);
			return 200;
		}
		else{
			return 404;
		}
	}
	public int adduser(String id){
		if(JSONUtils.isJSONValid(id)){
			Document user1=Document.parse(id) ;
			coll.insertOne(user1);
			return 200;
		}else{
			return 415;
		}
	}

}
