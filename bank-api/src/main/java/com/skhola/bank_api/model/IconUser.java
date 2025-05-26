package com.skhola.bank_api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"isr_icn_id", "isr_usr_id"})
        }
)
public class IconUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "isr")
    private Long id;

    // Relation --> Primary Key

    @NotNull(message = "Icon cannot be null")
    @ManyToOne
    @JoinColumn(name = "isr_icn_id", referencedColumnName = "icn_id")
    private Icon icon;

    @NotNull(message = "User cannot be null")
    @ManyToOne
    @JoinColumn(name = "isr_usr_id", referencedColumnName = "usr_id")
    private User user;
}