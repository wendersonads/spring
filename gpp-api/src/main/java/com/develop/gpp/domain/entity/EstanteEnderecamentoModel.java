package com.develop.gpp.domain.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "estante_enderecamento")
public class EstanteEnderecamentoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEstante;

    private String desEstante;



}
