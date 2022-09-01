package com.website_of_holding.app_of_holding.controller;

import com.website_of_holding.app_of_holding.exception.PlayerCharacterException;
import com.website_of_holding.app_of_holding.model.PlayerCharacter;
import com.website_of_holding.app_of_holding.service.PlayerCharacterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/characters")
@Slf4j
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

    @PostMapping
    public void createCharacter(@RequestBody PlayerCharacter character) throws PlayerCharacterException {
        playerCharacterService.addNewCharacter(character);
    }

    @DeleteMapping(path = "{playerCharacterId}")
    public void deleteCharacter(@PathVariable("playerCharacterId") Long playerCharacterId) throws PlayerCharacterException {
        playerCharacterService.deleteCharacter(playerCharacterId);
    }

    @PutMapping(path="{playerCharacterId}")
    public void updateCharacter(
            @PathVariable("playerCharacterId") Long playerCharacterId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) int level,
            @RequestParam(required = false) String race,
            @RequestParam(required = false) String characterClass,
            @RequestParam(required = false) String alignment,
            @RequestParam(required = false) int strength,
            @RequestParam(required = false) int dexterity,
            @RequestParam(required = false) int constitution,
            @RequestParam(required = false) int intelligence,
            @RequestParam(required = false) int wisdom,
            @RequestParam(required = false) int charisma
    ) throws PlayerCharacterException {
        playerCharacterService.updateCharacter(playerCharacterId, name, level, race,
                characterClass, alignment, strength, dexterity, constitution, intelligence, wisdom, charisma);
    }
}