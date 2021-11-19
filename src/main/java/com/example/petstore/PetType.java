package com.example.petstore;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import com.fasterxml.jackson.annotation.JsonProperty;

@Schema(name = "PetType")
public class PetType {

	@Schema(required = true, description = "Pet Type id")
	@JsonProperty("pettype_id")
	private Integer pettypeId;

	@Schema(required = true, description = "Pet type")
	@JsonProperty("pet_type")
	private String petType;

	public Integer getPetTypeId() {
		return pettypeId;
	}

	public void setPetTypeId(Integer pettypeId) {
		this.pettypeId = pettypeId;
	}

	public String getPetType() {
		return petType;
	}

	public void setPetType(String petType) {
		this.petType = petType;
	}
}
