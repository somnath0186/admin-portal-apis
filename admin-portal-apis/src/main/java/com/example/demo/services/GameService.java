package com.example.demo.services;

import java.util.List;

import com.example.demo.payload.ApiResponse;
import com.example.demo.payload.GameDto;

public interface GameService {
	GameDto createGame(GameDto gameDto);
	GameDto update(GameDto gameDto,Integer gameId);
	ApiResponse deleteGame(Integer gameId);
List<GameDto> getAllGames();
GameDto getGameById(Integer gameId);

}
