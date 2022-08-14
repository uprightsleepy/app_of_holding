package com.website_of_holding.app_of_holding.service;

import com.website_of_holding.app_of_holding.model.PlayerCharacter;
import com.website_of_holding.app_of_holding.repository.PlayerCharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class PlayerCharacterService {

    private final PlayerCharacterRepository playerCharacterRepository;
    private final List<String> availableClasses = Arrays.asList("Barbarian", "Fighter", "Rogue",
            "Bard", "Monk", "Sorcerer", "Cleric", "Paladin", "Warlock",
            "Druid", "Ranger", "Wizard", "Artificer");

    private final List<String> availableAlignments = Arrays.asList("Lawful Good", "Neutral Good", "Chaotic Good",
            "Lawful Neutral", "True Neutral", "Chaotic Neutral", "Lawful Evil", "Neutral Evil", "Chaotic Evil", "Unaligned");

    @Autowired
    public PlayerCharacterService(PlayerCharacterRepository playerCharacterRepository) {
        this.playerCharacterRepository = playerCharacterRepository;
    }

    public List<PlayerCharacter> getCharacters() {
        return playerCharacterRepository.findAll();
    }

    public void addNewCharacter(PlayerCharacter character) {
        Optional<PlayerCharacter> characterByName =
                playerCharacterRepository.findPlayerCharacterByName(character.getName());

        if(characterByName.isPresent()) {
            throw new IllegalStateException("Unable to create character {"
                    + character.getName() + "}. That character already exists!");
        }
        playerCharacterRepository.save(character);
    }

    public void deleteCharacter(Long playerCharacterId) {
        boolean exists = playerCharacterRepository.existsById(playerCharacterId);
        if(!exists) {
            throw new IllegalStateException("Character with id {" + playerCharacterId + "} does not exist.");
        }
        playerCharacterRepository.deleteById(playerCharacterId);
    }

    @Transactional
    public void updateCharacter(Long playerCharacterId, String name, String race,
                                String characterClass, String alignment, Long strength, Long dexterity,
                                Long constitution, Long intelligence, Long wisdom, Long charisma) {

        PlayerCharacter playerCharacter = playerCharacterRepository.findById(playerCharacterId)
                .orElseThrow(() -> new IllegalStateException("Character with id {" + playerCharacterId + "} does not exist..."));

        if(name != null && name.length() > 0) {
            playerCharacter.setName(name);
        } if(race != null && race.length() > 0) {
            playerCharacter.setRace(race);
        } else {
            throw new IllegalStateException("Race {" + race +"} is unable to be set to nothing.");
        } if(availableClasses.contains(characterClass)) {
            playerCharacter.setCharacterClass(characterClass);
        } else {
            throw new IllegalStateException("Character Class {" + characterClass +"} is not a known class.");
        } if(availableAlignments.contains(alignment)) {
            playerCharacter.setAlignment(alignment);
        } else {
            throw new IllegalStateException("Alignment {" + alignment +"} is not a known alignment.");
        } if(strength > 0) {
            playerCharacter.setStrength(strength);
        } else {
            throw new IllegalStateException("Strength level {" + strength+ "} unable to be negative...");
        } if(dexterity > 0) {
            playerCharacter.setDexterity(dexterity);
        } else {
            throw new IllegalStateException("Dex level {" + dexterity + "} unable to be negative...");
        } if(constitution > 0) {
            playerCharacter.setConstitution(constitution);
        } else {
            throw new IllegalStateException("Constitution level {" + constitution+ "} unable to be negative...");
        } if(intelligence > 0) {
            playerCharacter.setIntelligence(intelligence);
        } else {
            throw new IllegalStateException("Intelligence level {" + intelligence+ "} unable to be negative...");
        } if(wisdom > 0) {
            playerCharacter.setWisdom(wisdom);
        } else {
            throw new IllegalStateException("Wisdom level {" + wisdom+ "} unable to be negative...");
        } if(charisma > 0) {
            playerCharacter.setCharisma(charisma);
        } else {
            throw new IllegalStateException("Charisma level {" + charisma+ "} unable to be negative...");
        }
    }
}
