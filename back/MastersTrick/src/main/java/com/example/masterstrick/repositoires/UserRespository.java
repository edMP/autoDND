package com.example.masterstrick.repositoires;

import com.example.masterstrick.model.Users;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRespository  extends CrudRepository<Users,Long> {

    @Query("SELECT u FROM Users u WHERE u.id=:id")
    List<Users> serarchUser(@Param("id")Long id);
}
