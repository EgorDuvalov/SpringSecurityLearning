package com.innowise.springsecurity.model.entity;

import com.innowise.springsecurity.model.Role;
import com.innowise.springsecurity.model.Status;
import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name="users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String login;

	private String password;

	private String email;

	@Enumerated(value = EnumType.STRING)
	private Role role;

	@Enumerated(value = EnumType.STRING)
	private Status status;
}
