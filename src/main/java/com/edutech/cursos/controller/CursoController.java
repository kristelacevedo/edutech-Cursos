package com.edutech.cursos.controller;

import com.edutech.cursos.model.Curso;
import com.edutech.cursos.service.CursoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    private final CursoService service;

    public CursoController(CursoService service) {
        this.service=service;

    }

    @GetMapping
    public List<Curso> listar() {
        return service.listar();
    }
    @PostMapping
    public Curso crear(@RequestBody Curso c) {
        return service.crear(c);
    }

    @GetMapping("/{id}")
    public Curso obtener(@PathVariable Long id) {
        return service.buscar(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Curso actualizar(@PathVariable Long id, @RequestBody Curso c) {
        return service.actualizar(id, c);
    }

    @PutMapping("/{id}/desactivar")
    public void desactivar(@PathVariable Long id) {
        service.desactivar(id);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}

