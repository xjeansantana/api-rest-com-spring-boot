package com.example.bitmax.domain;

import lombok.*;
import sun.util.calendar.BaseCalendar;

import javax.persistence.*;
import java.text.DateFormat;
import java.util.Date;

@Entity(name = "releases")
@Data
public class Release {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;
    private Date data;
    private String urlFoto;
    private String tipo;


}
