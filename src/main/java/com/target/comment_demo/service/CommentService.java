package com.target.comment_demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.target.comment_demo.dto.CommentDto;
import com.target.comment_demo.entity.Comment;
import com.target.comment_demo.repository.CommentRepository;

@Service
public class CommentService {

	@Autowired
	CommentRepository commentRepository;

	public Optional<Comment> getCommentById (Long id) {
		return commentRepository.findById(id);
	}

	public Long addComment(CommentDto commentDto) {
		Comment comment = new Comment(commentDto.getComment(), commentDto.getPostedBy(), commentDto.getPostedAt());
		commentRepository.save(comment);
		return comment.getId();
	}

}


