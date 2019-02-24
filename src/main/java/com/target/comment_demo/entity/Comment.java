package com.target.comment_demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "Comment")
public class Comment {

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String comment;

	@Column(nullable = true)
	private String postedBy;

	@Column(nullable = true)
	private Date postedAt;

	public Comment() {
	}

	public Comment(String comment, String postedBy, Date postedAt) {
		this.comment = comment;
		this.postedAt = postedAt;
		this.postedBy = postedBy;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getPostedBy() {
		return postedBy;
	}

	public void setPostedBy(String postedBy) {
		this.postedBy = postedBy;
	}

	public Date getPostedAt() {
		return postedAt;
	}

	public void setPostedAt(Date postedAt) {
		this.postedAt = postedAt;
	}

	public Long getId() {
		return id;
	}



}
