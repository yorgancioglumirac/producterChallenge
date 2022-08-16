package com.mirac.producterChallenge.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mirac.producterChallenge.dto.PlayerDto;
import com.mirac.producterChallenge.entity.Player;
import com.mirac.producterChallenge.repos.PlayerRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PlayerService {

	@Autowired
	private PlayerRepository playerRepository;
	
	
	public Player savePlayer(PlayerDto player) {
		Player playerToAdd = new Player();
		playerToAdd.setName(player.getName());
		playerToAdd.setSurname(player.getSurname());
		playerToAdd.setPosition(player.getPosition());
		playerToAdd.setCreatedAt(new Date());
		return playerRepository.save(playerToAdd);
	}
	
	public Long deleteById(Long id) {
		playerRepository.deleteById(id);
		return id;
	}
	
	public List<Player> getAllPlayers() {
		return playerRepository.findAll();
	}
	
	
	

}