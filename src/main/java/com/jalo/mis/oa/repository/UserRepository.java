package com.jalo.mis.oa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.jalo.mis.oa.entity.UserEntity;

/**
 * Repository : user
 * @author Jalo
 */
public interface UserRepository extends JpaRepository<UserEntity, Long>, JpaSpecificationExecutor<UserEntity> {

}
