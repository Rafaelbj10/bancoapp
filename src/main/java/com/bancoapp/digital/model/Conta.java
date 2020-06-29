package com.bancoapp.digital.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data
public class Conta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int agencia;

    private int numeroConta;

    private double saldo;



}
