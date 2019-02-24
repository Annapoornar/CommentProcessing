package com.target.comment_demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.target.comment_demo.entity.Comment;

@Component
public interface CommentRepository extends CrudRepository<Comment, Long> {
	
}
