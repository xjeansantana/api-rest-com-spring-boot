package com.example.bitmax.domain;

import lombok.*;

import javax.persistence.*;

@Entity(name = "releases")
@Data
public class Release {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String tipo;




}
