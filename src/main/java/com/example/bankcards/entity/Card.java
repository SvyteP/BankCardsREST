package com.example.bankcards.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "cards")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "number")
    private String number;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "owner_id")
    private AccountUser owner;

    @Column(name = "validity_period")
    private Date validityPeriod;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "card_status_id")
    private CardStatus cardStatus;

    @Column(name = "balance")
    private BigDecimal balance;
}
