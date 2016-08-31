package com.leaguelove.leadboard.service;

import java.util.List;

import org.json.JSONArray;

import com.leaguelove.leadboard.domain.LeadBoardModel;

public interface LeadBoardService {
	
	public JSONArray getVotes(int pagination);
	
	public JSONArray getVotesForSummoner(String name);

}
