package com.app.service;

import java.util.List;

import com.app.pojos.Player;

public interface PlayerService {

	List<Player> getAllPlayerById(Integer team_id);
	
}
