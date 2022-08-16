package com.mirac.producterChallenge.api;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.assertj.core.api.Assertions.assertThat;
import java.io.IOException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.graphql.spring.boot.test.GraphQLResponse;
import com.graphql.spring.boot.test.GraphQLTest;
import com.graphql.spring.boot.test.GraphQLTestTemplate;
import com.mirac.producterChallenge.dto.PlayerDto;

import com.mirac.producterChallenge.entity.Position;
import com.mirac.producterChallenge.service.PlayerService;

@GraphQLTest
class PlayerMutationResolverTest {
	
	
	private static final String TEST_NAME = "Producter";
	private static final String TEST_SURNAME = "Producter";
	private static final Position TEST_POSITION = Position.PowerForward;

	@Autowired
	private GraphQLTestTemplate graphQLTestTemplate;
	
	@MockBean
	PlayerService playerServiceMock;
	
	static PlayerDto player = new PlayerDto();
	
	@BeforeAll
	static void setUp() {
		player.setName(TEST_NAME);
		player.setSurname(TEST_SURNAME);
		player.setPosition(TEST_POSITION);
	}
	
	
	@Test
	public void addPlayer() throws IOException{
		doReturn(player).when(playerServiceMock).savePlayer(player);
		GraphQLResponse response = graphQLTestTemplate.postForResource("graphql/add-player.graphql");
		assertThat(response.isOk()).isTrue();
		assertThat(response.get("$.data.addPlayer.id")).isNotNull();
		assertThat(response.get("$.data.addPlayer.name")).isEqualTo(TEST_NAME);
	}

}
