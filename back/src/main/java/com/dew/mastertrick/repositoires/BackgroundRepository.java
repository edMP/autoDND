package com.dew.mastertrick.repositoires;

import com.dew.mastertrick.model.Backgrounds;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BackgroundRepository extends CrudRepository<Backgrounds, Long> {
}
