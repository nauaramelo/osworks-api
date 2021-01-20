package com.algaworks.osworks.api.model;

import java.time.OffsetDateTime;

public class CommentModel {

	private Long id;
	private String description;
	private OffsetDateTime shippindDate;
	
	
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
	public OffsetDateTime getShippindDate() {
		return shippindDate;
	}
	public void setShippindDate(OffsetDateTime shippindDate) {
		this.shippindDate = shippindDate;
	} 
	
	
}
