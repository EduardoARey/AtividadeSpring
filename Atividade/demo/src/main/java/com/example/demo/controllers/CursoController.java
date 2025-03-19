package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Curso;
import com.example.demo.repositories.CursoRepository;

@RestController
@RequestMapping("/cursos")
public class CursoController {
    @Autowired
    private CursoRepository cursoRepository;
    
    @GetMapping
    public List<Curso> mostrarTodos() {
        return cursoRepository.obterTodos();
    }
    
    @PostMapping
    public Curso inserir(@RequestBody Curso curso) {
        return cursoRepository.salvar(curso);
    }
}