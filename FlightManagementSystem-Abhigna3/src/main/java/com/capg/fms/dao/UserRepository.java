package com.capg.fms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.capg.fms.entity.UserBean;

@Repository
public interface UserRepository extends JpaRepository<UserBean, Integer> {

}
