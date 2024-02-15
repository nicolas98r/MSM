package com.store.msm.repository;

import com.store.msm.model.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserTypeRepository extends JpaRepository<UserType, Integer> {
    Optional<UserType> findByName(String name);
}
