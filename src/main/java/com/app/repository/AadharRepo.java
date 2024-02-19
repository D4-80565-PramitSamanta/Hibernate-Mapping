package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.AadharCard;

public interface AadharRepo extends JpaRepository<AadharCard, Integer>{

}
