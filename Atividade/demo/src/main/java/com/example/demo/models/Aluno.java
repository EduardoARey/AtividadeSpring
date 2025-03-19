package com.example.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_alunos")
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String nome;
    
    private Integer anoIngresso;
    
    @ManyToOne
    @JoinColumn(name = "idCurso")
    private Curso curso;
    
    public Aluno() {}
    
    public Aluno(Integer id, String nome, Integer anoIngresso, Curso curso) {
        this.id = id;
        this.nome = nome;
        this.anoIngresso = anoIngresso;
        this.curso = curso;
    }
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public Integer getAnoIngresso() {
        return anoIngresso;
    }
    
    public void setAnoIngresso(Integer anoIngresso) {
        this.anoIngresso = anoIngresso;
    }
    
    public Curso getCurso() {
        return curso;
    }
    
    public void setCurso(Curso curso) {
        this.curso = curso;
    }
    
    @Override
    public String toString() {
        return "Aluno [id=" + id + ", nome=" + nome + ", anoIngresso=" + anoIngresso + "]";
    }
}