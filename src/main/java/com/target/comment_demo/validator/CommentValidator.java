package com.target.comment_demo.validator;

import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;

@Component
public class CommentValidator {
	
	static ConcurrentHashMap<String, String> objectionalContent ;
	static {
		objectionalContent = new ConcurrentHashMap<>();
		objectionalContent.put("ANAL", "anal");
		objectionalContent.put("ANUS", "anus");
		objectionalContent.put("BITCH", "bitch");
		objectionalContent.put("CRAP", "crap");
		objectionalContent.put("NEGRO", "negro");
		objectionalContent.put("SEXY", "sexy");	
	}
	
	public static boolean isValidComment(String comment) {
		String[] words = comment.split(" ");
		for (int i = 0; i < words.length; i++) {
			if (objectionalContent.containsKey(words[i].toUpperCase())) {
				return false;
			}
		}
		
		return true;
	}
}
