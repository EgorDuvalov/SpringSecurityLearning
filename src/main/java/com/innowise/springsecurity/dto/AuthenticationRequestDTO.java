package com.innowise.springsecurity.dto;

import lombok.Data;
import lombok.Getter;

@Data
public class AuthenticationRequestDTO {
	private String login;
	private String password;
}
