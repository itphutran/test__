package com.phutran.entities.converter;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.AttributeConverter;

import com.phutran.entities.Tag;

/*Example 1:  Convert a basic attribute : List to String*/
public class TagConverter implements AttributeConverter<List<Tag>, String> {

	@Override
	public String convertToDatabaseColumn(List<Tag> tags) {
		String result = "";
		for (int i = 0; i < tags.size(); i++) {
			result += tags.get(i).getName() + (i != (tags.size() - 1) ? "," : "");
		}
		return result;
	}

	@Override
	public List<Tag> convertToEntityAttribute(String strDB) {
		List<Tag> listTag = new ArrayList<>();
		String[] data = strDB.split(",");
		for (String item : data) {
			Tag tag = new Tag(0, item);
			listTag.add(tag);
		}
		return listTag;
	}

}
