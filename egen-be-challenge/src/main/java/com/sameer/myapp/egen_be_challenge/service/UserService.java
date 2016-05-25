package com.sameer.myapp.egen_be_challenge.service;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
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
		for(Document doc1:all){
			doc1.remove("_id");
		}
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(all);
		System.out.println(json);
		return json;
	}

	public String getUser(String id){
		Bson filter=new Document("id",id);
		Document obj=(Document) coll.find(filter).first();

		if(obj!=null){
			obj.remove("_id");
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			String json = gson.toJson(obj);
			System.out.println(json);
			return json;
		}
		else{
			return "404: UserId not present";	
		}
	}
	public String updateUser(String id){
		ParseJson parseJson=new ParseJson();
		if(parseJson.validate(id)){
			String uniqueid=parseJson.getValue(id, "id");
			Bson filter=new Document("id",uniqueid);
			Document doc=coll.find(filter).first();
			if(doc!=null){
				Map<String,String> map=parseJson.getKeys(id);
				for (String key : map.keySet()) {
					coll.updateOne(filter, new Document("$set",new Document(key,map.get(key))));
				}
				Gson gson = new GsonBuilder().setPrettyPrinting().create();
				Document docUpdated=coll.find(filter).first();	
				docUpdated.remove("_id");
				String json = gson.toJson(docUpdated);
				System.out.println(json);
				return json;
			}
			else{
				return "404: Userid not present";
			}

		}else{
			return "400: Bad input format";
		}

	}
	public String removeUser(String id){
		Bson filter=new Document("id",id);
		Document doc=coll.find(filter).first();
		if(doc!=null){
			coll.deleteOne(filter);
			return "Success";
		}
		else{
			return "404: Userid not present";
		}
	}
	public String adduser(String id){
		if(JSONUtils.isJSONValid(id)){
			ParseJson parseJson=new ParseJson();
			Document user1=Document.parse(id) ;
			String uniqueid=parseJson.getValue(id, "id");
			Bson filter=new Document("id",uniqueid);
			Document obj=(Document) coll.find(filter).first();
			if(obj==null){
				coll.insertOne(user1);	
				obj=(Document) coll.find(filter).first();
				obj.remove("_id");
				Gson gson = new GsonBuilder().setPrettyPrinting().create();
				String json = gson.toJson(obj);
				System.out.println(json);
				return json;
			}else{
				return "Record already present";
			}
		}else{
			return "Not a valid String";
		}
	}

}
