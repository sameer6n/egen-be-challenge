package com.sameer.myapp.egen_be_challenge.service;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.conversions.Bson;

import com.sameer.myapp.egen_be_challenge.util.Helpers;
import com.sameer.myapp.egen_be_challenge.util.JSONUtils;
import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;


import com.sameer.myapp.egen_be_challenge.model.*;
public class UserService {

	MongoClient client=new MongoClient();
	MongoDatabase db=client.getDatabase("new-test");
	MongoCollection<Document> coll=db.getCollection("things");
	Gson gson = new Gson();

	public List<User> getAllUsers(){
		List<User> users=new ArrayList<User>();
		return users;
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
	public User updateUser(String id){
		User user=new User(id);
		if(user.getId()==null){
			return null;
		}

		user.setId(id);
		return user;
	}
	public User removeUser(String id){
		User user=new User(id);
		return user;
	}
	public int adduser(String id){
		if(JSONUtils.isJSONValid(id)){
			//User user=gson.fromJson(id,User.class) ;
			Document user1=Document.parse(id) ;
			coll.insertOne(user1);
			return 200;
		}else{
			return 415;
		}
		
//		User user=new User(id);
		
	}

}
