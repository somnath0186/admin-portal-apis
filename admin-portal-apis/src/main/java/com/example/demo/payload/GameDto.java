package com.example.demo.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class GameDto {
	private int gameId;
	private String gameName;
	private String gameSubName;
	private String openTime;
	private String closeTime;
	private String status;

}
