package com.algaworks.osworks.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.algaworks.osworks.api.model.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long>{

}