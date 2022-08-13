package com.website_of_holding.app_of_holding.repository;

import com.website_of_holding.app_of_holding.model.PlayerCharacter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayerCharacterRepository extends JpaRepository<PlayerCharacter, Long> {
    Optional<PlayerCharacter> findPlayerCharacterByName(String name);
}
