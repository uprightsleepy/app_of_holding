package com.website_of_holding.app_of_holding.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
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
    private String name;
    private String race;
    private String characterClass;
    private String alignment;

    // TODO: OVERRIDE THE GET METHODS FOR EACH OF THESE STATS AND RECALCULATE THE VALUES BASED ON THE VARIOUS MODIFIERS I.E. RACE, CLASS, ETC.
    private int strength;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int charisma;

    public PlayerCharacter(String name, String race, String characterClass, String alignment, int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma) {
        this.name = name;
        this.race = race;
        this.characterClass = characterClass;
        this.alignment = alignment;
        this.strength = strength;
        this.dexterity = dexterity;
        this.constitution = constitution;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.charisma = charisma;
    }

    @Override
    public String toString() {
        return "PlayerCharacter{" +
                "id=" + id +
                ", name='" + name + '\'' +
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