package com.develop.gpp.domain.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "funcionalidades")
public class FuncionalidadesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFuncionalidade;

    private String nome;

    private Integer situacao;

    private String icone;

    @OneToMany(mappedBy = "funcionalidade", cascade = CascadeType.ALL)
    @JsonBackReference
    List<PerfilUsuarioFuncionalidades> perfilUsuarioFuncionalidades;

    @OneToMany(mappedBy = "funcionalidade", cascade = CascadeType.ALL)
    @JsonManagedReference
    List<SubFuncionalidadesModel> subFuncionalidades;
    
}
