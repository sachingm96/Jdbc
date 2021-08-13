package com.sachin.webseries.dao;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;

import com.sachin.webseries.dto.WebSeriesDTO;

public interface WebSeriesDAO {

	int save(WebSeriesDTO dto);

	Collection<WebSeriesDTO> saveAll(Collection<WebSeriesDTO> collection);

	Collection<WebSeriesDTO> findAll();

	Collection<WebSeriesDTO> findAll(Predicate<WebSeriesDTO> predicate);

	int total();

	int findMaxSeason();

	int findMinSeason();

	Collection<WebSeriesDTO> findAllSortNameDesc();

	Optional<WebSeriesDTO> findOne(Predicate<WebSeriesDTO> predicate);

}
