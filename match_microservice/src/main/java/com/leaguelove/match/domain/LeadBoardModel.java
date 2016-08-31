package com.leaguelove.match.domain;

public class LeadBoardModel {

	
private String _id;
	
	private String _rev;
	
	private int votes;
	
	private Integer profile_icon;
	
	private String type;
	
	public LeadBoardModel(String _id, int votes, int profile_icon, String type)
	{
		this._id=_id;
		
		this.votes=votes;
		
		this.type=type;
		
		this.profile_icon=profile_icon;
		
	}
	
	
	 public int getVotes() {
		return votes;
	}


	public void setVotes(int votes) {
		this.votes = votes;
	}


	public String toString() {
		 return "{ \"_id\": \"" + _id + "\",\"_rev\":\"" +_rev+ "\",\"votes\":\"" + votes + "\",\"type\":\"" + type+ "\",\"profile_icon\":\"" + profile_icon +"\"}";
		  }
	 
}
