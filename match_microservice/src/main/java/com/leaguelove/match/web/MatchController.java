package com.leaguelove.match.web;

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

import com.cloudant.client.api.ClientBuilder;
import com.cloudant.client.api.CloudantClient;
import com.leaguelove.match.service.MatchService;

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
public class MatchController {
	
   
   
    @Autowired
	private MatchService matchService;
    
    
    @CrossOrigin(origins = "http://localhost:8001")
    @RequestMapping("/lastmatch")
    public String lastmatch(
          @RequestParam(value = "name", required = false) String name) throws Exception {

//        Greeting greeting = new Greeting(String.format(TEMPLATE, name));
//        greeting.add(linkTo(methodOn(GreetingController.class).greeting(name)).withSelfRel());
      	
        return  matchService.getLastMatch(name).toString();
    }
  
    @CrossOrigin(origins = "http://localhost:8001")
    @RequestMapping("/votedata")
    public String voteData(
            @RequestParam(value = "data", required = false) String data) throws Exception {

//          Greeting greeting = new Greeting(String.format(TEMPLATE, name));
//          greeting.add(linkTo(methodOn(GreetingController.class).greeting(name)).withSelfRel());
        	
          return  matchService.voteData(data).toString();
      }

    
}
