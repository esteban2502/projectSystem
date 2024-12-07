package com.projectSystem.projectSystem.repository;

import com.projectSystem.projectSystem.model.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserEntityRepository extends CrudRepository<UserEntity, Integer> {


    Optional<UserEntity> findUserEntityByEmail(String email);
}
