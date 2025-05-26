package com.skhola.bank_api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"anw_usr_id", "anw_qtn_id"}),
        }
)
public class AnswerUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "anw_id")
    private Long id;

    @NotBlank(message = "The answer is invalid")
    private String answer;

    // Relation --> Primary Key

    @NotNull(message = "Question cannot be null")
    @ManyToOne
    @JoinColumn(name = "anw_qtn_id", referencedColumnName = "qtn_id")
    private Question question;

    @NotNull(message = "User cannot be null")
    @ManyToOne
    @JoinColumn(name = "anw_usr_id", referencedColumnName = "usr_id")
    private User user;

}
