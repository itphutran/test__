package com.phutran.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.phutran.entities.converter.StatusConverter;
import com.phutran.entities.converter.TagConverter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "categories")
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	@Convert(converter = TagConverter.class)
	@Column(name = "tags")
	private List<Tag> tags;

	@Convert(converter = StatusConverter.class)
	@Column(length = 1)
	private Boolean status;
}
