package com.skhola.bank_api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"qtn_question"}),
        }
)
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "qtn_id")
    private Long id;

    @NotBlank(message = "Invalid question")
    @Column(name = "qtn_question")
    private String question;

}
