package com.djd2000.domain;

import java.util.Set;

import javax.persistence.*;

/**
 * 
 * @author david
 *
 */
@Entity
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String description;

	@ManyToMany(mappedBy = "categories")
	private Set<Recipe> recipies;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Recipe> getRecipies() {
		return recipies;
	}

	public void setRecipies(Set<Recipe> recipies) {
		this.recipies = recipies;
	}

}
