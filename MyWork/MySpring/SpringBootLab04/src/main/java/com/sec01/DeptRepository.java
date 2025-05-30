package com.sec01;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeptRepository extends JpaRepository<Dept, Integer> {
}