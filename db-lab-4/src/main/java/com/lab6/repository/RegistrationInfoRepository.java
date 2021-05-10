package com.lab6.repository;

import com.lab6.domain.implementation.RegistrationInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationInfoRepository extends JpaRepository<RegistrationInfo, Integer> {

}