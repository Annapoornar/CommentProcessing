package com.target.comment_demo.dto;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommentDto {
	
	@JsonProperty
	@NotEmpty
	String comment;
	@JsonProperty
	@NotEmpty
	String postedBy;
	@JsonProperty
	Date postedAt = new Date();
	
	@JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	
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
}
