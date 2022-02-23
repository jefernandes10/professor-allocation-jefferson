package com.project.professor.alocation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.professor.alocation.entity.Allocation;

@Repository
public interface AllocationRepository extends JpaRepository<Allocation, Long>{

}
