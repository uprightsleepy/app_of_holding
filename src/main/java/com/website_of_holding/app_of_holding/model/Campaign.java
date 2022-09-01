package com.website_of_holding.app_of_holding.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "campaigns")
@AllArgsConstructor
@NoArgsConstructor
public class Campaign {
    @Id
    @SequenceGenerator(
            name = "campaign_sequence",
            sequenceName = "campaign_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "campaign_sequence"
    )
    private Long id;
    private String title;
    private LocalDate startDate;
    private boolean completed;

    @OneToOne(mappedBy = "campaign")
    private PlayerCharacter character;
    public Campaign(String title, LocalDate startDate, boolean completed) {
        this.title = title;
        this.startDate = startDate;
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "Campaign{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", startDate=" + startDate +
                ", completed=" + completed +
                '}';
    }
}