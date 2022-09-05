package com.website_of_holding.app_of_holding.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Inventory {
    @Id
    @SequenceGenerator(
            name = "inventory_sequence",
            sequenceName = "inventory_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "inventory_sequence"
    )
    private Long id;

    private int copper;
    private int silver;
    private int electrum;
    private int gold;
    private int platinum;

    @Transient
    Map<String, String> rightHereMap = new HashMap<String, String>(){};

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "character_id", referencedColumnName = "id")
    PlayerCharacter character;
};
