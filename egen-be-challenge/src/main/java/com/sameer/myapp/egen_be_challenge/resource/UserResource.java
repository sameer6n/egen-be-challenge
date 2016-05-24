package com.sameer.myapp.egen_be_challenge.resource;
import static spark.Spark.get;
import static spark.Spark.post;

import com.sameer.myapp.egen_be_challenge.service.UserService;
import com.sameer.myapp.egen_be_challenge.util.JsonTransformer;
public class UserResource {
	public static void main(String [] args){
		UserService user=new UserService();
		get("/users/:id", "application/json", (request, response) -> {
			String id=request.params(":id");
			return user.getUser(id);
		}, new JsonTransformer());
		post("/users","application/json", (request, response) -> {
			return user.adduser(request.body()); 
		}); 
	}

}
