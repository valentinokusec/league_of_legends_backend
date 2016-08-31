package com.leaguelove.leadboard.web;

import org.springframework.web.bind.annotation.RestController;

import com.leaguelove.leadboard.service.LeadBoardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class LeadboardController {
    	
		@Autowired
		private LeadBoardService leadBoardService;
	
	    @CrossOrigin(origins = "http://localhost:8001")
	    @RequestMapping("/getvotes")
	    public String GeneralData(
	          @RequestParam(value = "pagination", required = true) int pagination) throws Exception {

	      		        
			return  leadBoardService.getVotes(pagination).toString();
	    }
    
	    @CrossOrigin(origins = "http://localhost:8001")
	    @RequestMapping("/getvotesforsummoner")
	    public String getVotesForSummoner(
	          @RequestParam(value = "name", required = true) String name) throws Exception {

	      		        
			return  leadBoardService.getVotesForSummoner(name).toString();
	    }	
}
