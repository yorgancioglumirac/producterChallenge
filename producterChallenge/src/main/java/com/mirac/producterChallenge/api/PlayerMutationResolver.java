package com.mirac.producterChallenge.api;

import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.mirac.producterChallenge.dto.PlayerDto;
import com.mirac.producterChallenge.entity.Player;
import com.mirac.producterChallenge.service.PlayerService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PlayerMutationResolver implements GraphQLMutationResolver{

	private final PlayerService playerService;
	
	
	public Player addPlayer(PlayerDto player) {
		return playerService.savePlayer(player);
	}
	
	public Long deletePlayer(Long id) {
		return playerService.deleteById(id);

	}



}