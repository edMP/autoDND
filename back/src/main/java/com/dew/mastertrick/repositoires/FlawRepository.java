package com.dew.mastertrick.repositoires;

import com.dew.mastertrick.model.Flaws;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlawRepository extends CrudRepository<Flaws, Long> {
}
