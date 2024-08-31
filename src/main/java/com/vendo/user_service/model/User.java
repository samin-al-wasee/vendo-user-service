package com.vendo.user_service.model;

import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import com.vendo.user_service.constant.ValidationConstants;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class User {
    @Id
    @UuidGenerator
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @NotBlank(message = "First name is mandatory")
    @Pattern(regexp = ValidationConstants.NAME_PATTERN, message = "First name must contain only letters, dots and hyphens")
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @NotBlank(message = "Last name is mandatory")
    @Pattern(regexp = ValidationConstants.NAME_PATTERN, message = "Last name must contain only letters, dots and hyphens")
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @NotBlank(message = "Email is mandatory")
    @Pattern(regexp = ValidationConstants.EMAIL_PATTERN, message = "Invalid email format")
    @Column(name = "email", nullable = false)
    private String email;
}
