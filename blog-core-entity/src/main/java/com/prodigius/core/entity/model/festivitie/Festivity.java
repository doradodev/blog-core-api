/**
 * 
 */
package com.prodigius.core.entity.model.festivitie;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author cristiandorado
 *
 */
@Getter
@Setter
@Entity
@Table(name = "ARTICLE")
public class Festivity {

	@Id
	@Column(name = "ID")
	@GeneratedValue
	private Long id;

	@Column(name = "TITLE")
	private String title;

	@Column(name = "CATEGORY")
	private String category;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "SHORTDESCRIPTION")
	private String shortDescription;

	@Column(name = "URL")
	private String url;

	@Builder
	public static Festivity target(Long id, String title, String category, String description, String shortDescription, String url) {

		Festivity festivity = new Festivity();
		festivity.setId(id);
		festivity.setTitle(title);
		festivity.setCategory(category);
		festivity.setDescription(description);
		festivity.setShortDescription(shortDescription);
		festivity.setUrl(url);

		return festivity;
	}

}
