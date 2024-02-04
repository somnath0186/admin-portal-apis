package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.payload.ApiResponse;
import com.example.demo.payload.GameDto;
import com.example.demo.services.GameService;


@RequestMapping("/api/gameManagement")
@RestController
@CrossOrigin("*")
public class GameController {
	
	@Autowired
	private GameService gameService;

	@PostMapping("/create")
	public ResponseEntity<GameDto> createGame(@RequestBody GameDto GameDto) {
		GameDto saveGame = this.gameService.createGame(GameDto);

		return new ResponseEntity<GameDto>(saveGame, HttpStatus.CREATED);
	}

	@PutMapping("/update_game/{gameId}")
	private ResponseEntity<GameDto> updateGame(@RequestBody GameDto GameDto, @PathVariable Integer gameId) {
		GameDto upateGame = this.gameService.update(GameDto, gameId);
		return new ResponseEntity<GameDto>(upateGame, HttpStatus.OK);
	}

	@GetMapping("/{gameId}")
	private ResponseEntity<GameDto> getSingleGame(@PathVariable Integer gameId) {
		GameDto foundGame = this.gameService.getGameById(gameId);
		return new ResponseEntity<GameDto>(foundGame, HttpStatus.OK);
	}

	@GetMapping("/all")
	private ResponseEntity<List<GameDto>> getAllGames() {
		List<GameDto> gameDtoList = this.gameService.getAllGames();
		return new ResponseEntity<List<GameDto>>(gameDtoList, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete_game/{gameId}")
	private ResponseEntity<ApiResponse> deleteGame(@PathVariable Integer gameId){
		ApiResponse apiResponse=this.gameService.deleteGame(gameId);
		return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.OK);
	}
}
