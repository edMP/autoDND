package com.dew.mastertrick.repositoires;

import com.dew.mastertrick.model.Users;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRespository extends CrudRepository<Users, Long> {

    @Query("SELECT u FROM Users u WHERE u.nick=:nick")
    List<Users> serarchUser(@Param("nick") String nick);

    /*@Query("DELETE FROM Users u WHERE u.nick=:nick")
    void deleteUsersByNick(String nick);*/
}