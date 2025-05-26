package com.skhola.bank_api.model;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@Table(
        name = "usuario",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"usr_username"}),
                @UniqueConstraint(columnNames = {"usr_email"}),
        }
)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usr_id")
    private Long id;

    @NotNull(message = "The value cannot be null")
    @Size(min = 1, max = 100, message = "The length's size must be between 1 and 100 characters")
    @Column(name = "usr_fullname")
    private String full_name;

    @NotNull(message = "The value cannot be null")
    @Pattern(
            regexp = "^(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d]{8,20}$",
            message = "The user name must be between 8 and 20 characters, at least one capital letter and one number."
    )
    @Column(name = "usr_username")
    private String username;

    @Pattern(
            regexp = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
            message = "Must have at least 8 characters, a capital letter, a number and a special character (@$!%*?&)."
    )
    @NotNull(message = "Password is required")
    @Column(name = "usr_password")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @Email(message = "Invalid email")
    @NotNull(message = "Email is required")
    @Column(name = "usr_email")
    private String email;

    @Size(max = 15, message = "Number phone invalid")
    @Column(name = "usr_phone")
    private String phone;

    @Column(name = "usr_created_at", nullable = false, updatable = false)
    private LocalDateTime created_at;

    @PrePersist
    protected void onCreate() {
        this.created_at = LocalDateTime.now();
    }

}
