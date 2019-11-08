package com.example.demo.entity;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity
@Table(name = "accounts")
@Data
@EqualsAndHashCode(callSuper = false)
public class Account extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max=200)
    private String accountName;
    
    @NotNull
    @Size(max = 100)
    @Column(unique = true)
    private String accountType;

    @NotNull
    @Size(max=200)
    private String email;
    
}