package com.leaguelove.submitvotes.service;

import java.util.List;

import org.json.JSONArray;


public interface SubmitVotesService {
	
	public JSONArray getVotes(String name);
	
	public JSONArray submitVotes(String[] votes);

}
