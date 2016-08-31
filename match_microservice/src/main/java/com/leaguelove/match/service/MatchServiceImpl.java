package com.leaguelove.match.service;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.cloudant.client.api.ClientBuilder;
import com.cloudant.client.api.CloudantClient;
import com.cloudant.client.api.Database;
import com.leaguelove.match.domain.LeadBoardModel;
import com.leaguelove.match.domain.VoteModel;
import com.robrua.orianna.api.core.RiotAPI;
import com.robrua.orianna.type.core.common.Region;
import com.robrua.orianna.type.core.match.Participant;
import com.robrua.orianna.type.core.matchlist.MatchReference;
import com.robrua.orianna.type.core.summoner.Summoner;

@Service
public class MatchServiceImpl implements MatchService{

	private static final String API_KEY="172d9054-b070-449d-bb68-cbbe94f29e7c";
	 
	CloudantClient client;
	Database db;
	Database votes_db;
    public MatchServiceImpl()
    {
    	RiotAPI.setRegion(Region.EUW);
        RiotAPI.setAPIKey(API_KEY);
        
        client= ClientBuilder.account("tino")
                .username("tino")
                .password("ireliaftw1")
                .build();

		//Note: for Cloudant Local or Apache CouchDB use:
		//ClientBuilder.url(new URL("yourCloudantLocalAddress.example"))
		//.username("exampleUser")
		//.password("examplePassword")
		//.build();
		
		//Show the server version
		System.out.println("Server Version: " + client.serverVersion());
		db = client.database("league_of_legends", false);
		votes_db = client.database("league_of_legends_votes", false);
		//Get a List of all the databases this Cloudant account
		
	}
    
	@Override
	public JSONArray getLastMatch(String name) {
		// TODO Auto-generated method stub
		Summoner summoner = RiotAPI.getSummonerByName(name);
	  	
	  	List<MatchReference> listmatch=summoner.getMatchList();
        JSONArray last_match=new JSONArray();
        for (int i = 0; i < 1; i++) {
        	
        	for (Participant users:RiotAPI.getMatch(listmatch.get(i).getID()).getParticipants()) {	        													
										
        			JSONObject data=new JSONObject();
        			data.put("name", users.getSummonerName());
        			if (users.getChampion().toString().replace(" ", "").contains("LeBlanc")) {
        				data.put("champ", "Leblanc");
					}
        			else
        			{
        			data.put("champ", users.getChampion().toString().replace(" ", ""));
        			
        			}
					last_match.put(data);
				
			}
			
		}
        last_match.put(new JSONObject().put("match_id", listmatch.get(0).getID()));
		return last_match;
	}

	@Override
	public JSONArray voteData(String data) {
		// TODO Auto-generated method stub
		JSONObject data_object=new JSONObject(data);
		
		try {
			JSONArray votes=data_object.getJSONArray("votes");
			for (int i = 0; i < votes.length(); i++) {
				Summoner summoner = RiotAPI.getSummonerByName(votes.getJSONObject(i).getString("name"));
				
//				db.save(new LeadBoardModel(votes.getJSONObject(i).getString("name"),1,summoner.getProfileIconID()));
				try {
					LeadBoardModel lm=votes_db.find(LeadBoardModel.class, votes.getJSONObject(i).getString("name"));
					int votes_count=lm.getVotes()+1;
					
					lm.setVotes(votes_count);
					
					votes_db.update(lm);
				} catch (Exception e) {
					votes_db.save(new LeadBoardModel(votes.getJSONObject(i).getString("name"),1,summoner.getProfileIconID(),"votes"));
				}
				
				
			
				db.save(new VoteModel(votes.getJSONObject(i).getString("name"),data_object.getString("from"),votes.getJSONObject(i).getString("data"),data_object.getLong("match_id"),summoner.getProfileIconID(),false));
			}
			
		} catch (Exception e) {
			return new JSONArray().put("Something went wrong");
		}

		
		
		return new JSONArray().put("OK");
	}

}
