package com.leaguelove.match.service;

import org.json.JSONArray;

public interface MatchService {
	
	public JSONArray getLastMatch(String name);
	
	public JSONArray voteData(String data);
} 
