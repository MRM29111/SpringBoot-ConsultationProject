package com.zavada.entity.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum FuelType {

	DISEL("DISEL"),
	PETROL("PETROL"),
	GAS("GAS"),
	ELECTRO("ELECTRO"),
	PETROL_GAS("PETROL_GAS"), 
	PETROL_ELECTRO("PETROL_ELECTRO");
	
	private String type;
}
