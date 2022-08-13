package com.website_of_holding.app_of_holding.controller;

import com.website_of_holding.app_of_holding.model.PlayerCharacter;
import com.website_of_holding.app_of_holding.service.PlayerCharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/characters")
public class PlayerCharacterController {

    private final PlayerCharacterService playerCharacterService;

    @Autowired
    public PlayerCharacterController(PlayerCharacterService service) {
        this.playerCharacterService = service;
    }

    @GetMapping
    public List<PlayerCharacter> getCharacters() {
        return playerCharacterService.getCharacters();
    }
}