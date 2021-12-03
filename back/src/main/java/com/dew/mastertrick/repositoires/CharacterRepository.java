package com.dew.mastertrick.repositoires;


import com.dew.mastertrick.model.Characters;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CharacterRepository extends CrudRepository<Characters, Long> {
    @Query("SELECT c FROM Characters c WHERE c.alter.nick=:nick")
    List<Characters>userCharacters(@Param("nick")String nick);

}
