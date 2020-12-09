package com.lab6.repository;

import com.lab6.domain.implementation.CurrentInfoAboutThePlane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrentInfoAboutThePlaneRepository extends JpaRepository<CurrentInfoAboutThePlane, Integer> {

}