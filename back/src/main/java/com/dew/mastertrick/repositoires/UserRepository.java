package com.dew.mastertrick.repositoires;

import com.dew.mastertrick.model.Users;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<Users, Long> {
    @Query("SELECT u FROM Users u WHERE u.nick=:nick")
    Optional<Users> findUserByNick(@Param("nick")String nick);

    @Query("SELECT u FROM Users u WHERE u.nick=:nick")
    List<Users> serarchUser(@Param("nick") String nick);

    @Query("SELECT u FROM Users u WHERE u.nick=:nick")
    public Boolean existsUsers(@Param("nick") String nick);

    /*@Query("DELETE FROM Users u WHERE u.nick=:nick")
    void deleteUsersByNick(String nick);*/
}
