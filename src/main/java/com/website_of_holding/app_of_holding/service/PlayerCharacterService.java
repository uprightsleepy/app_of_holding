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
    private final List<String> availableClasses = Arrays.asList("Cleric", "Fighter", "Magic User", "Thief");

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
                    + character.getName() + "}. Name is already taken...");
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

        if(name != null && name.length() > 0 && !Objects.equals(playerCharacter.getName(), name)) {
            Optional<PlayerCharacter> playerCharacterOptional = playerCharacterRepository.findPlayerCharacterByName(name);
            if(playerCharacterOptional.isPresent()) {
                throw new IllegalStateException("Character name {" + name + "} is already taken...");
            }
            playerCharacter.setName(name);
        } if(race != null && race.length() > 0 && !Objects.equals(playerCharacter.getRace(), race)) {
            playerCharacter.setRace(race);
        } else {
            throw new IllegalStateException("Race {" + race +"} unable to be set...");
        } if(availableClasses.contains(characterClass) && !Objects.equals(playerCharacter.getCharacterClass(), characterClass)) {
            playerCharacter.setCharacterClass(characterClass);
        } else {
            throw new IllegalStateException("Character Class {" + characterClass +"} unable to be set...");
        } if(availableAlignments.contains(alignment) && !Objects.equals(playerCharacter.getAlignment(), alignment)) {
            playerCharacter.setAlignment(alignment);
        } else {
            throw new IllegalStateException("Alignment {" + alignment +"} unable to be set...");
        }
        // TODO: CONTINUE ERROR CHECKING FOR REMAINING STATS
        playerCharacter.setStrength(strength);
        playerCharacter.setDexterity(dexterity);
        playerCharacter.setConstitution(constitution);
        playerCharacter.setIntelligence(intelligence);
        playerCharacter.setWisdom(wisdom);
        playerCharacter.setCharisma(charisma);
    }
}
