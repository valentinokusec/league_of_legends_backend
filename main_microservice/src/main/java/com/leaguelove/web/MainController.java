package com.leaguelove.web;

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

import com.leaguelove.services.MainService;
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
public class MainController {
	
    private static final String API_KEY="172d9054-b070-449d-bb68-cbbe94f29e7c";
   
    @Autowired
	private MainService mainService;
       
    @CrossOrigin(origins = "http://localhost:8001")
    @RequestMapping("/getgeneraldata")
    public String GeneralData(
          @RequestParam(value = "name", required = true) String name) throws Exception {


      	
        return  mainService.getGeneralData(name).toString();
    }
    @CrossOrigin(origins = "http://localhost:8001")
    @RequestMapping("/getrandommessage")
    public String GetRandomMessage() throws Exception {


      	
        return  mainService.getRandomMessage().toString();
    }
    @CrossOrigin(origins = "http://localhost:8001")
    @RequestMapping("/getrecenthistory")
    public String RecentHistory(
          @RequestParam(value = "name", required = true) String name) throws Exception {


      	
        return  mainService.getRecentHistory(name).toString();
    }
   

	@CrossOrigin(origins = "http://localhost:8001")
    @RequestMapping("/getmatch")
    public String GetMatch(
          @RequestParam(value = "matchid", required = false) long matchid) throws Exception {
    	

      	
        return  mainService.getMatch(matchid).toString();
    }
    

	@CrossOrigin(origins = "http://localhost:8001")
    @RequestMapping("/getgeneralhistory")
    public String getgeneralhistory(
          @RequestParam(value = "data", required = true) String data) throws Exception {
          JSONObject json_data=new JSONObject(data);

      	
        return  mainService.getGeneralHistory(json_data.getString("name"),json_data.getInt("pagination"),json_data.getString("champion")).toString();
    }
    @CrossOrigin(origins = "http://localhost:8001")
    @RequestMapping("/getchampionhistory")
    public String getchampionhistory(
          @RequestParam(value = "data", required = true) String data) throws Exception {
    	  JSONObject json_data=new JSONObject(data);

      	
        return  mainService.getChampionHistory(json_data.getString("name"),json_data.getString("champion")).toString();
    }


    
}
