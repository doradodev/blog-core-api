/**
 * 
 */
package com.prodigius.core.service.model.impl;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.google.common.collect.Lists;
import com.prodigius.core.commons.exception.CommonRuntimeException;
import com.prodigius.core.entity.model.festivitie.Festivity;
import com.prodigius.core.entity.model.festivitie.QFestivity;
import com.prodigius.core.repository.model.FestivityRepository;
import com.prodigius.core.service.model.FestivityService;
import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.Predicate;

/**
 * @author cristiandorado
 *
 */
@Service
public class DefaultFestivityService implements FestivityService {

	private final FestivityRepository repository;

	@Autowired
	public DefaultFestivityService(FestivityRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<Festivity> findAll() {

		return repository.findAll();
	}

	@Override
	public Optional<Festivity> findByid(Long id) {
		checkNotNull(id, "The Festivity Id is a required argument!");

		try {

			return Optional.ofNullable(repository.findOne(id));
		} catch (Exception ex) {

			throw new CommonRuntimeException("Error finding Festivity by Id [" + id + "]!", ex);
		}

	}

	@Override
	public void save(Festivity festivity) {

		repository.save(festivity);
	}

	@Override
	public void update(Festivity festivity) {

		repository.save(festivity);
	}

	@Override
	public void delete(Long id) {

		repository.delete(id);

	}

	@Override
	public void findByQuery(Festivity query) {
		checkNotNull(query, "The Festivity Query is a required argument!");
		try {

			QFestivity festivities = QFestivity.festivity;		
			

		} catch (Exception ex) {

			throw new CommonRuntimeException("Error getting Festivities by Query!", ex);

		}
	}
}
