package com.edutech.cursos.repository;

import com.edutech.cursos.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository  extends JpaRepository <Curso, Long>  {

}
