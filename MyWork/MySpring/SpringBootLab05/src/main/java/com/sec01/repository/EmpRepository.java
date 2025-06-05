package com.sec01.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sec01.entity.Emp;

@Repository 
public interface EmpRepository extends JpaRepository<Emp, Integer> {  }