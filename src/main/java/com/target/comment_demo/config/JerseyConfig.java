package com.target.comment_demo.config;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.target.comment_demo.resource.CommentsResource;

@Component
public class JerseyConfig extends ResourceConfig{

	public JerseyConfig() {
		register(CommentsResource.class);
	}
}


