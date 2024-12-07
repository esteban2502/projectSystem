package com.projectSystem.projectSystem.repository;

import com.projectSystem.projectSystem.model.RoleEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RoleRepository extends CrudRepository<RoleEntity, Integer> {

    List<RoleEntity> findRoleEntitiesByRoleEnumIn(List<String> rolesNames);

}
