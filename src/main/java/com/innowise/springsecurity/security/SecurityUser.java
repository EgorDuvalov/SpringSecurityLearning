package com.innowise.springsecurity.security;

import com.innowise.springsecurity.model.Status;
import com.innowise.springsecurity.model.entity.User;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
public class SecurityUser implements UserDetails {

	private final String username;
	private final String password;
	private final List<SimpleGrantedAuthority> authorities;
	private final boolean isNonBlocked;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return isNonBlocked;
	}

	@Override
	public boolean isAccountNonLocked() {
		return isNonBlocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return isNonBlocked;
	}

	@Override
	public boolean isEnabled() {
		return isNonBlocked;
	}

	public static UserDetails mapToUserDetails(User user) {
		return new org.springframework.security.core.userdetails.User(
			user.getLogin(), user.getPassword(),
			user.getStatus().equals(Status.ACTIVE),
			user.getStatus().equals(Status.ACTIVE),
			user.getStatus().equals(Status.ACTIVE),
			user.getStatus().equals(Status.ACTIVE),
			user.getRole().getAuthorities());
	}
}
