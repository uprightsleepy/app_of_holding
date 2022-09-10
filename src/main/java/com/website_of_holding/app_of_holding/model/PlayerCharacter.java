package com.website_of_holding.app_of_holding.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "player_characters")
public class PlayerCharacter {
    @Id
    @SequenceGenerator(
            name = "character_sequence",
            sequenceName = "character_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "character_sequence"
    )
    private Long id;
    private int level;
    private String name;
    private String race;
    private String characterClass;
    private String alignment;

    private int strength;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int charisma;

    private boolean alive;

    @Column(name = "created_datetime")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss.SSSSSS")
    private LocalDateTime createdDate = LocalDateTime.now();


    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "campaign_id", referencedColumnName = "id")
    private Campaign campaign;

    public PlayerCharacter(String name, int level, String race, String characterClass, String alignment, int strength,
                           int dexterity, int constitution, int intelligence, int wisdom, int charisma, LocalDateTime createdDate) {
        this.name = name;
        this.level = level;
        this.race = race;
        this.characterClass = characterClass;
        this.alignment = alignment;
        this.strength = strength;
        this.dexterity = dexterity;
        this.constitution = constitution;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.charisma = charisma;
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "PlayerCharacter{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", level='" + level + '\'' +
                ", race='" + race + '\'' +
                ", characterClass='" + characterClass + '\'' +
                ", alignment='" + alignment + '\'' +
                ", strength=" + strength +
                ", dexterity=" + dexterity +
                ", constitution=" + constitution +
                ", intelligence=" + intelligence +
                ", wisdom=" + wisdom +
                ", charisma=" + charisma +
                '}';
    }
}
