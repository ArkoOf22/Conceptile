package com.Conceptile.Conceptile_Project.repository;

import com.Conceptile.Conceptile_Project.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {}