package com.example.restservice.entity;

import lombok.Builder;

@Builder(toBuilder = true)
public record Product (

		long id,
		ProductCategory category,
		String description,
		long price

)
{

}
