package com.zavada.domain;


import java.math.BigDecimal;

import org.springframework.web.multipart.MultipartFile;

import com.zavada.entity.UserEntity;
import com.zavada.entity.enumeration.Bodytype;
import com.zavada.entity.enumeration.Color;
import com.zavada.entity.enumeration.FuelType;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@NoArgsConstructor
@Getter
@Setter
public class CreateAdvRequest {
	
	 
	
	private String make;
	private String model;
	private BigDecimal price;
	private String modelYear;
	private Color color;
	private FuelType fuelType;
	private BigDecimal engineCapasity;
	private Bodytype bodyType;
	private UserEntity entity;
	private MultipartFile carImage;
	
	
}
