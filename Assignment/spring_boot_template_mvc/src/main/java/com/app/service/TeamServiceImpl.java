package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.TeamDao;
import com.app.pojos.Team;
@Service
@Transactional
public class TeamServiceImpl implements TeamService {
	@Autowired
	private TeamDao tdao;
	@Override
	public List<Team> getAllTeam() {
		// TODO Auto-generated method stub
		
		return tdao.findAll();
	}

}
