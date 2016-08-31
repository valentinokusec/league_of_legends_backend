package com.leaguelove.user.web;

import org.springframework.web.bind.annotation.RestController;

import com.leaguelove.user.service.UserService;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class UserController {
    	
		@Autowired
		private UserService userService;
	
	    @CrossOrigin(origins = "http://localhost:8001")
	    @RequestMapping("/signup")
	    public String GeneralData(
	          @RequestParam(value = "data", required = true) String data) throws Exception {
	    	
	    	JSONObject json_data=new JSONObject(data);
	      		        
			return  userService.signUp(json_data.getString("username"),json_data.getString("password"),json_data.getString("summonername")).toString();
	    }
    
	    @CrossOrigin(origins = "http://localhost:8001")
	    @RequestMapping("/signin")
	    public String getVotesForSummoner(
	          @RequestParam(value = "data", required = true) String data) throws Exception {

	        JSONObject json_data=new JSONObject(data);	
	        
			return  userService.signIn(json_data.getString("username"),json_data.getString("password")).toString();
	    }	
}
