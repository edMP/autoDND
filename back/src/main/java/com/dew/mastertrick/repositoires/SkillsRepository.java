package com.dew.mastertrick.repositoires;

import com.dew.mastertrick.model.Skills;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillsRepository extends CrudRepository<Skills, Long> {
}
