package com.sameer.myapp.egen_be_challenge.resource;
import static spark.Spark.get;
import static spark.Spark.put;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.delete;
import static spark.Spark.post;

import com.sameer.myapp.egen_be_challenge.model.HelloWorldFreemarker;
import com.sameer.myapp.egen_be_challenge.service.UserService;
import com.sameer.myapp.egen_be_challenge.util.JsonTransformer;

import freemarker.template.Configuration;
import freemarker.template.Template;
import spark.Spark;
public class UserResource {
	public static void main(String [] args){
//		final Configuration conf= new Configuration();
//		conf.setClassForTemplateLoading(HelloWorldFreemarker.class, "/freemarker");
//		
//		
//		
//		
//		get("/", (request, response) -> {
//			StringWriter writer=new StringWriter();
//			try {
//				conf.setDirectoryForTemplateLoading(new File("C:/Users/Sameer/egen/egen-be-challenge/src/main/java/resources"));
//				Template helloTemplate = conf.getTemplate("home.ftl");
//				
//				Map<String,Object> map=new HashMap<String,Object>();
//				map.put("name", "hello freemarker");
//				helloTemplate.process(map, writer);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			return writer;
////			return user.getUser(id);
//		});
		
		UserService user=new UserService();
		get("/users/:id", "application/json", (request, response) -> {
			String id=request.params(":id");
			
			return user.getUser(id);
		}, new JsonTransformer());
		
		post("/users","application/json", (request, response) -> {
			return user.adduser(request.body()); 
		}); 
		
		
		put("/users","application/json", (request, response) -> {
			return user.updateUser(request.body()); 
		}); 
		get("/users", "application/json", (request, response) -> {
			return user.getAllUsers();
		});
		delete("/users/:id", (request, response) -> {
			String id=request.params(":id");
			return user.removeUser(id);
		});

	}

}
