package com.sameer.myapp.egen_be_challenge;
import static spark.Spark.*;

import java.util.Arrays;

import org.bson.Document;
import com.sameer.myapp.egen_be_challenge.util.Helpers;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main(String[] args) {
//		get("/userManagement/:name", (request, response) -> {
//		    return "Hello: " + request.params(":name");
//		});
//		get("/userManagement", (req, res) -> "Main Page");
//		
		MongoClient client=new MongoClient();
		MongoDatabase db=client.getDatabase("test");
		MongoCollection<Document> coll=db.getCollection("test");
		Document smith=new Document().append("name", "sameer")
				.append("age", 42)
				.append("profession", "programmer");
					//Helpers.printJson(document);
		coll.insertOne(smith);	
		
	}
}
