package com.lab6.repository;

import com.lab6.domain.implementation.InfoClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfoClientRepository extends JpaRepository<InfoClient, Integer> {

}
