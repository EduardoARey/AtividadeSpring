package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Aluno;
import com.example.demo.repositories.AlunoRepository;


@RestController
@RequestMapping("/alunos")
public class AlunoController {
    @Autowired
    private AlunoRepository alunoRepository;
    
    @GetMapping
    public List<Aluno> mostrarTodos() {
        return alunoRepository.obterTodos();
    }
    
    @PostMapping
    public Aluno inserir(@RequestBody Aluno aluno) {
        return alunoRepository.salvar(aluno);
    }
}