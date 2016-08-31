package com.leaguelove.votes.web;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.RestController;


import com.leaguelove.votes.service.VotesService;
import com.robrua.orianna.api.core.RiotAPI;
import com.robrua.orianna.type.core.common.Region;
import com.robrua.orianna.type.core.common.Season;
import com.robrua.orianna.type.core.match.Participant;
import com.robrua.orianna.type.core.matchlist.MatchReference;
import com.robrua.orianna.type.core.staticdata.Champion;
import com.robrua.orianna.type.core.stats.ChampionStats;
import com.robrua.orianna.type.core.summoner.Summoner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class VotesController {
	
    private static final String API_KEY="172d9054-b070-449d-bb68-cbbe94f29e7c";
   
    @Autowired
	private VotesService votesService;
    
    public VotesController()
    {
    	RiotAPI.setRegion(Region.EUW);
        RiotAPI.setAPIKey(API_KEY);
    }
    

    @CrossOrigin(origins = "http://localhost:8001")
    @RequestMapping("/getvotes")
    public String getVotes(
          @RequestParam(value = "data", required = false) String data) throws Exception {

    	  JSONObject data_json=new JSONObject(data);
      	
        return  votesService.getVotes(data_json.getString("name"),data_json.getInt("pagination")).toString();
    }
    @CrossOrigin(origins = "http://localhost:8001")
    @RequestMapping("/getlastvotes")
    public String getLastVotes(
          @RequestParam(value = "data", required = false) String data) throws Exception {

    	  JSONObject data_json=new JSONObject(data);
      	
        return  votesService.getLastVotes(data_json.getString("name"),data_json.getLong("match_id")).toString();
    }
    
    @CrossOrigin(origins = "http://localhost:8001")
    @RequestMapping("/getvotesbyid")
    public String getVotesById(
          @RequestParam(value = "data", required = false) String data) throws Exception {

    	  JSONObject data_json=new JSONObject(data);
      	
        return  votesService.getVotesById(data_json.getString("name"),data_json.getLong("match_id")).toString();
    }

	

    
}
