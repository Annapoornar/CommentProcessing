package com.target.comment_demo.resource;

import java.net.URI;
import java.util.Optional;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.target.comment_demo.dto.CommentDto;
import com.target.comment_demo.entity.Comment;
import com.target.comment_demo.service.CommentService;
import com.target.comment_demo.validator.CommentValidator;

@Service
@Path("/comment")
public class CommentsResource {

	@Autowired
	CommentService commentService;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response getById (@PathParam("id") Long id) {
		Optional<Comment> comment = commentService.getCommentById(id);
		if (!comment.isPresent()) {
			return Response.status(404).entity("Entity not Found").build();
		}
		return Response.status(200).entity(comment.get()).build();

	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addComment (@Valid CommentDto commentDto) {
		try {
			if (!CommentValidator.isValidComment(commentDto.getComment())) {
				return Response.status(400).entity(" Comment has objectionable words").build();
			}
			
			Long commentID = commentService.addComment(commentDto);
			System.out.println("commentId " + commentID);
			return Response.created(URI.create("/comment/" + commentID)).build();
		} catch(Exception e) {
			return Response.status(500).entity(" Exception while posting the comment").build();
		}

	}

}