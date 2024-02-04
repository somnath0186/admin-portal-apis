package com.example.demo.model;

import org.modelmapper.internal.bytebuddy.dynamic.loading.ClassReloadingStrategy.Strategy;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="GameManagement")
@Entity
public class Game {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int gameId;
	private String gameName;
	private String gameSubName;
	private String openTime;
	private String closeTime;
	private String status;

}
