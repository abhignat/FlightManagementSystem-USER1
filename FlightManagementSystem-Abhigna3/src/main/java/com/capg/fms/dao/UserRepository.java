package com.capg.fms.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.capg.fms.entity.UserBean;

@Repository
public interface UserRepository extends JpaRepository<UserBean, Integer> {

}
