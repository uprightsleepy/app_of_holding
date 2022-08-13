package com.website_of_holding.app_of_holding.repository;

import com.website_of_holding.app_of_holding.model.PlayerCharacter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerCharacterRepository extends JpaRepository<PlayerCharacter, Long> {

}
