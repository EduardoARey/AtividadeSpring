package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.models.Aluno;
import com.example.demo.models.Curso;
import com.example.demo.repositories.AlunoRepository;
import com.example.demo.repositories.CursoRepository;

@SpringBootApplication
public class Escola {
    public static void main(String[] args) {
        SpringApplication.run(Escola.class, args);
    }
    
    @Bean
    public CommandLineRunner init(
        @Autowired CursoRepository cursoRepository,
        @Autowired AlunoRepository alunoRepository) {
        return args -> {
            System.out.println("---- Inserindo Cursos ----");
            cursoRepository.salvar(new Curso(null, "Engenharia de Software"));
            cursoRepository.salvar(new Curso(null, "Sistemas de Informação"));
            
            System.out.println("---- Listando Cursos ----");
            List<Curso> listaCursos = cursoRepository.obterTodos();
            listaCursos.forEach(System.out::println);
            
            Curso c1 = cursoRepository.obterTodos().get(0);
            c1.setAlunos(null);
            cursoRepository.salvar(c1);
            
            System.out.println("*** Criar pessoa ***");
            Aluno aluno1 = alunoRepository.salvar(new Aluno(null, "João", 2008, c1));
            
            System.out.println("*** Criar pessoa ***");
            Aluno aluno2 = alunoRepository.salvar(new Aluno(null, "Maria", 2009, c1));
            
            System.out.println("*** Vincular pessoa ao curso ***");
            c1.addAluno(aluno1);
            c1.addAluno(aluno2);
            cursoRepository.salvar(c1);
            
        };
    }
}