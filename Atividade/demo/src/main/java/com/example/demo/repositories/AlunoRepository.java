package com.example.demo.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Aluno;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class AlunoRepository {

    @Autowired
    EntityManager entityManager;

    @Transactional
    public Aluno salvar(Aluno aluno) {
        return entityManager.merge(aluno);
    }

    public List<Aluno> obterTodos() {
        return entityManager.createQuery("FROM Aluno", Aluno.class).getResultList();
    }

    public Aluno obterPorId(Integer id) {
        return entityManager.find(Aluno.class, id);
    }

    @Transactional
    public void editar(Aluno aluno) {
        entityManager.merge(aluno);
    }

    @Transactional
    public void deletar(Integer id) {
        Aluno aluno = obterPorId(id);
        if (aluno != null) {
            entityManager.remove(aluno);
        }
    }
}


