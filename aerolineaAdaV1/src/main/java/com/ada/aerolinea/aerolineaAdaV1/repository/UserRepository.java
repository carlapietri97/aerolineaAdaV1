package com.ada.aerolinea.aerolineaAdaV1.repository;

import com.ada.aerolinea.aerolineaAdaV1.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
