package com.github.shuntak.generator.example.hello.entity;

import lombok.*;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.ZonedDateTime;

/**
 * User entity base class.
 * Auto generated by JPA code generator.
 */
@javax.annotation.Generated(value = "JPACodeGenerator")
@NoArgsConstructor
@AllArgsConstructor
@Data
@MappedSuperclass
public abstract class AbstractUser implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @NotNull
    @Size(max = 255)
    private String name;

    @Column(name = "created_at")
    @Generated(value = GenerationTime.INSERT)
    private ZonedDateTime createdAt;

    @Column(name = "updated_at")
    @Generated(value = GenerationTime.ALWAYS)
    private ZonedDateTime updatedAt;

}
