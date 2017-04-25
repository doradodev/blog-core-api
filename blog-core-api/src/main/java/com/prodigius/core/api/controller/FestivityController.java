package com.prodigius.core.api.controller;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.prodigius.core.api.service.domain.festivitie.FestivitieQueryDTO;
import com.prodigius.core.entity.model.festivitie.Festivity;
import com.prodigius.core.service.model.FestivityService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author cristiandorado
 *
 */
@CrossOrigin
@RestController
@Api(value = "api-blogs", description = "blogs Mvc Endpoint", produces = APPLICATION_JSON_VALUE)
@RequestMapping(value = "/api/blogs", produces = APPLICATION_JSON_VALUE)
public class FestivityController {

	FestivityService service;

	@Autowired
	public FestivityController(FestivityService service) {

		this.service = service;
	}

	@ApiOperation(value = "Get All blogs", notes = "Find all blogs according to a query search parameters", response = Festivity.class, produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
	@ApiResponses({ @ApiResponse(code = 200, message = "All blogs according to a query search parameters"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 401, message = "Unauthorized Request"),
			@ApiResponse(code = 404, message = "Festivity Not Found"),
			@ApiResponse(code = 500, message = "Unexpected Internal Server Error") })

	@RequestMapping(value = "/findAll", method = POST, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Festivity>> blogs(
			@ApiParam(value = "The Query object", required = false) @RequestBody(required = false) FestivitieQueryDTO query) {

		return new ResponseEntity<>(service.findAll(), OK);
	}

	@ApiOperation(value = "Create festivity", notes = "Create an festivity from given Id")
	@ApiResponses({ @ApiResponse(code = 200, message = "An Festivity from given Id"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 401, message = "Unauthorized Request"),
			@ApiResponse(code = 404, message = "Festivity Not Found"),
			@ApiResponse(code = 500, message = "Unexpected Internal Server Error") })

	@RequestMapping(value = "/{id}", method = POST, produces = APPLICATION_JSON_VALUE)
	public void insertFestivity(
			@ApiParam(value = "The Festivity Id", required = true) @RequestBody(required = true) FestivitieQueryDTO query) {
		Festivity festivity = Festivity.builder().title(query.getTitle()).category(query.getCategory()).description(query.getDescription())
												.shortDescription(query.getShortDescription()).url(query.getUrl()).build();	
		service.save(festivity);
	}


}
