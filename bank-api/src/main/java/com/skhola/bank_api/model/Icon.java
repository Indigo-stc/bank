package com.skhola.bank_api.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Icon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "icn_id")
    private Long id;

    @Lob
    @Column(name = "icn_data")
    private byte[] data;

}