package com.website_of_holding.app_of_holding.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.website_of_holding.app_of_holding.repository.PlayerCharacterRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

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
    @Column(name = "created_datetime")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss.SSSSSS")
    private LocalDateTime createdDate = LocalDateTime.now();

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "character_id", referencedColumnName = "id")
    private PlayerCharacter character;
    public Campaign(String title, LocalDate startDate, boolean completed, LocalDateTime createdDate) {
        this.title = title;
        this.startDate = startDate;
        this.completed = completed;
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "Campaign{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", startDate=" + startDate +
                ", completed=" + completed +
                ", createdDate=" + createdDate +
                '}';
    }
}