package com.leaguelove.user.service;

import java.util.List;

import org.json.JSONArray;


public interface UserService {
	
	public JSONArray signUp(String name,String password,String summonername);
	
	public JSONArray signIn(String name,String password);

}
