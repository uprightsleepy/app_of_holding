package com.website_of_holding.app_of_holding.service;

import com.website_of_holding.app_of_holding.model.PlayerCharacter;
import com.website_of_holding.app_of_holding.repository.PlayerCharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerCharacterService {

    private final PlayerCharacterRepository playerCharacterRepository;

    @Autowired
    public PlayerCharacterService(PlayerCharacterRepository playerCharacterRepository) {
        this.playerCharacterRepository = playerCharacterRepository;
    }

    public List<PlayerCharacter> getCharacters() {
        return playerCharacterRepository.findAll();
    }
}
