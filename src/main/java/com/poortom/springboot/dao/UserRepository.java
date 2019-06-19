package com.poortom.springboot.dao;

import com.poortom.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by 13620 on 2019/6/11.
 */

@Repository
public interface UserRepository extends JpaRepository<User, String> {


}
