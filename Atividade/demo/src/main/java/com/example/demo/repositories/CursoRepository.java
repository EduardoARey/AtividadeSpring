package com.example.demo.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Curso;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class CursoRepository {
    @Autowired
    private EntityManager entityManager;

    @Transactional
    public Curso salvar(Curso curso) {
        return entityManager.merge(curso);
    }

    public List<Curso> obterTodos() {
        return entityManager
                .createQuery("from Curso", Curso.class).getResultList();
    }
    @Transactional
    public Curso obterPorId(Integer id) {
        return entityManager.find(Curso.class, id);
    }

    @Transactional
    public void editar(Curso curso) {
        entityManager.merge(curso);
    }

    @Transactional
    public void excluir(Integer id) {
        Curso curso = obterPorId(id);
        if (curso != null) {
            entityManager.remove(curso);
        }
    }
}
