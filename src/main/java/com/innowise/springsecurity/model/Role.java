package com.innowise.springsecurity.model;

import lombok.Getter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

public enum Role {
	USER(Set.of(Permission.DEVELOPERS_READ)),
	ADMIN(Set.of(Permission.DEVELOPERS_READ, Permission.DEVELOPERS_WRITE));

	@Getter
	private final Set<Permission> permissions;

	Role(Set<Permission> permissions) {
		this.permissions=permissions;
	}

	public Set<SimpleGrantedAuthority> getAuthorities(){
		return getPermissions().stream().map(permission
			-> new SimpleGrantedAuthority(permission.getPermission())).collect(Collectors.toSet());
	}
}
