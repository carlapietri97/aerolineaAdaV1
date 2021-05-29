package com.ada.aerolinea.aerolineaAdaV1.repository;

import com.ada.aerolinea.aerolineaAdaV1.model.Base;
import com.ada.aerolinea.aerolineaAdaV1.model.Role;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface RoleRepository extends CrudRepository<Role, Integer> {


    @Query(value = "select id_role from user_role where id_user = userId", nativeQuery = true)
    Collection<Integer> getRolesByUserId(@Param("userId") int userId);
}
