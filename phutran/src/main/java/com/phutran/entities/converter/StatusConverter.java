package com.phutran.entities.converter;

import javax.persistence.AttributeConverter;
/*Example 2:  Convert a basic attribute*/
public class StatusConverter implements AttributeConverter<Boolean, Integer> {

	@Override
	public Integer convertToDatabaseColumn(Boolean attribute) {
		return attribute.equals(true) ? 1 : 0;
	}

	@Override
	public Boolean convertToEntityAttribute(Integer dbData) {
		return dbData.equals(1) ? true : false;
	}

}
