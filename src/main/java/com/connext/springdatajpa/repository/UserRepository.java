package com.connext.springdatajpa.repository;

import com.connext.springdatajpa.model.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {
    Integer countByPhone(String phone);
    User findAllByPhone(String phone);

    @Modifying
    @Query(value = "update User u set u.user_type=?1 where u.id=?2",nativeQuery = true)
    void updateRole(Integer usertype,Integer id);
}
