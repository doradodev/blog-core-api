/**
 * 
 */
package com.prodigius.core.api.service.domain.festivitie;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Data;

/**
 * @author cristiandorado
 *
 */
@Data
@ApiModel(value = "FestivitieQuery", description = "The Festivitie Query Representation")
public class FestivitieQueryDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5133105154344638154L;

	private String title;
	private String category;
	private String description;
	private String shortDescription;
	private String url;

	@Builder
	public static FestivitieQueryDTO target(String title, String category, String description, String shortDescription, String url) {

		FestivitieQueryDTO dto = new FestivitieQueryDTO();

		dto.setTitle(title);
		dto.setCategory(category);
		dto.setDescription(description);
		dto.setShortDescription(shortDescription);
		dto.setUrl(url);

		return dto;

	}

}
