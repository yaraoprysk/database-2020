package com.lab6.repository;

import com.lab6.domain.implementation.TravelClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TravelClassRepository extends JpaRepository<TravelClass, Integer> {

}