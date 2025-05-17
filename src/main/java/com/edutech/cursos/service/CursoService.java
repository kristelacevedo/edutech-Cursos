package com.edutech.cursos.service;

import com.edutech.cursos.entity.Curso;
import com.edutech.cursos.repository.CursoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    private final CursoRepository repo;

    public CursoService(CursoRepository repo) {
        this.repo=repo;
    }

    public List<Curso> listar(){
        return repo.findAll();
    }
    public Curso crear(Curso c){
        return repo.save(c);
    }
    public Optional<Curso> buscar(Long id){
        return repo.findById(id);
    }

    public Curso actualizar(Long id,Curso c){
        c.setId(id);
        return repo.save(c);
    }
    public void desactivar(Long id) {
        repo.findById(id).ifPresent(curso -> {
            curso.setActivo(false);
            repo.save(curso);
        });
    }
        public void eliminar(Long id){
            repo.deleteById(id);
        }
    }

