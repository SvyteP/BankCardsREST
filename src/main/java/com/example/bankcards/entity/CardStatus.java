package com.example.bankcards.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "card_statuses")
public class CardStatus implements Statuses{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @Column(name = "name")
    private String name;

    @OneToMany(
            mappedBy = "cardStatus",
            cascade = {
            CascadeType.REFRESH,
            CascadeType.PERSIST,
            CascadeType.MERGE})
    private List<Card> cards;
}
