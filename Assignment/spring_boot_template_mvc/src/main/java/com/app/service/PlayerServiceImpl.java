package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.PlayerDao;
import com.app.pojos.Player;

@Service
@Transactional
public class PlayerServiceImpl implements PlayerService {
	@Autowired
	private PlayerDao playerdao;
	@Override
	public List<Player> getAllPlayerById(Integer team_id) {
		
		return playerdao.findAllById(team_id);
	}
	
}
