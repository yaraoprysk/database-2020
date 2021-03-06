package com.lab6.repository;

import com.lab6.domain.implementation.PlaneInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaneInfoRepository extends JpaRepository<PlaneInfo, Integer> {

}