package com.example.demo.services.impl;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.model.Game;
import com.example.demo.payload.ApiResponse;
import com.example.demo.payload.GameDto;
import com.example.demo.repository.GameRepo;
import com.example.demo.services.GameService;

@Service
public class GameServiceImpl implements GameService {

	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private GameRepo gameRepo;

	
	@Override
	public GameDto createGame(GameDto gameDto) {
		
	Game saveGame	=this.gameRepo.save(this.dtoToGame(gameDto));
		return this.gameToDto(saveGame);
	}

	@Override
	public GameDto update(GameDto gameDto,Integer gameId) {
	Game game	=this.gameRepo.findById(gameId).orElseThrow(()-> new ResourceNotFoundException("Game Not found with this id", gameId));
	
	game.setGameName(gameDto.getGameName());
	game.setGameSubName(gameDto.getGameSubName());
	game.setOpenTime(gameDto.getOpenTime());
	game.setCloseTime(gameDto.getCloseTime());
	game.setStatus(gameDto.getStatus());
	Game saveGame=this.gameRepo.save(game);
		return this.gameToDto(saveGame);
	}

	@Override
	public ApiResponse deleteGame(Integer gameId) {
	Game game=this.gameRepo.findById(gameId).orElseThrow(()-> new ResourceNotFoundException("Game not found with id:-",gameId ));
		this.gameRepo.delete(game);
		return new ApiResponse("Game Deleted succesfully",true);
	}

	@Override
	public List<GameDto> getAllGames() {
	List<Game>games=	this.gameRepo.findAll();
	List<GameDto>listGameDtos=games.stream().map(game->this.gameToDto(game)).collect(Collectors.toList());
		return listGameDtos;
	}
	
	@Override
	public GameDto getGameById(Integer gameId) {
		Game game=this.gameRepo.findById(gameId).orElseThrow(()-> new ResourceNotFoundException("Game not found with id:-",gameId));
		return this.gameToDto(game);
	}
	
	public GameDto gameToDto(Game game) {
		return this.modelMapper.map(game, GameDto.class);
		
	}
	public Game dtoToGame(GameDto gameDto) {
		return this.modelMapper.map(gameDto, Game.class);
	}

	

}
