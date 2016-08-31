package com.leaguelove.livestats.service;

import org.json.JSONArray;
import org.springframework.stereotype.Service;

@Service
public interface LiveStatsService {
	public JSONArray getLiveStats(String name);
} 
