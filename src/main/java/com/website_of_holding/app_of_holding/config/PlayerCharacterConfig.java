package com.website_of_holding.app_of_holding.config;

import com.website_of_holding.app_of_holding.model.PlayerCharacter;
import com.website_of_holding.app_of_holding.repository.PlayerCharacterRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.List;

@Configuration
public class PlayerCharacterConfig {

    @Bean
    CommandLineRunner commandLineRunner(PlayerCharacterRepository repository) {
        return args -> {
            PlayerCharacter eithunran = new PlayerCharacter(
                    "Eithunran",
                    "Elf",
                    "Ranger",
                    "Chaotic-Good",
                    12,
                    12,
                    12,
                    10,
                    8,
                    7
            );

            PlayerCharacter ronnoc = new PlayerCharacter(
                    "Ronnoc",
                    "Blood Elf",
                    "Priest",
                    "Chaotic-Evil",
                    9,
                    13,
                    10,
                    15,
                    13,
                    12
            );

            repository.saveAll(
                    List.of(eithunran, ronnoc)
            );
        };
    }
}
