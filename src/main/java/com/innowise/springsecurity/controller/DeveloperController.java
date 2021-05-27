package com.innowise.springsecurity.controller;

import com.innowise.springsecurity.model.Developer;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/developers")
public class DeveloperController {

	private List<Developer> DEVELOPERS = List
		.of(new Developer(1L, "Smith", "1234"), new Developer(2L, "Levin", "4321"), new Developer(3L, "Price", "qwer"));

	@GetMapping
	public List<Developer> getAll() {
		return DEVELOPERS;
	}

	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('developers:read')")
	public Developer getById(@PathVariable Long id) {
		return DEVELOPERS.stream().filter(developer -> developer.getId().equals(id)).findFirst().orElse(null);
	}

	@PostMapping
	@PreAuthorize("hasAuthority('developers:write')")
	public Developer create(@RequestBody Developer developer) {
		this.DEVELOPERS.add(developer);
		return developer;
	}

	@DeleteMapping("/{id}")
	@PreAuthorize("hasAuthority('developers:write')")
	public void deleteById(@PathVariable Long id) {
		this.DEVELOPERS.removeIf(developer -> developer.getId().equals(id));
	}
}
