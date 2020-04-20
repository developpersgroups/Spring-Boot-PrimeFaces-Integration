package net.najiboulhouch.spring.boot.controllers;

import javax.annotation.PostConstruct;
import javax.faces.event.PhaseListener;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * 
 * @author NAJIB
 * @version 1.0
 * @see PhaseListener
 */

@Named
@Scope("view")
public class PageController {
	
	private String userName;

	public String getUserName() {
		return userName;
	}
	
	@PostConstruct
	private void init() {
		userName =  SecurityContextHolder.getContext().getAuthentication().getName();

	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
