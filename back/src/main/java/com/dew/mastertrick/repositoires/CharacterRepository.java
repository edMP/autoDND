package com.dew.mastertrick.repositoires;


import com.dew.mastertrick.model.Characters;
import org.springframework.data.repository.CrudRepository;

public interface CharacterRepository extends CrudRepository<Characters, Long> {
}
