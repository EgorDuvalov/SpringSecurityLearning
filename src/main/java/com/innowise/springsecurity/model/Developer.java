package com.innowise.springsecurity.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Developer {
	private Long id;
	private String login;
	private String password;
}
