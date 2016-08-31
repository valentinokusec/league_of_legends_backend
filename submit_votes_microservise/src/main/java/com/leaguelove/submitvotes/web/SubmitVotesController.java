package com.leaguelove.submitvotes.web;

import org.springframework.web.bind.annotation.RestController;

import com.leaguelove.submitvotes.service.SubmitVotesService;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class SubmitVotesController {
    	
		@Autowired
		private SubmitVotesService submitvotesService;
	
	    @CrossOrigin(origins = "http://localhost:8001")
	    @RequestMapping("/getvotes")
	    public String GeneralData(
	          @RequestParam(value = "name", required = true) String name) throws Exception {
	    	
	    	
	      		        
			return  submitvotesService.getVotes(name).toString();
	    }
    
	    @CrossOrigin(origins = "http://localhost:8001")
	    @RequestMapping("/submitvotes")
	    public String getVotesForSummoner(
	          @RequestParam(value = "data", required = true) String data) throws Exception {

	    	 String[] votes1=data.split(",");
	       
			return  submitvotesService.submitVotes(votes1).toString();
	    }	
}
