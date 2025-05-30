package com.sec01;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptService {

    @Autowired
    private DeptRepository deptRepository;

    //부서 전체 조회

    public List<Dept> findAll()
    {
        return deptRepository.findAll();
    }


    public Dept findById(int deptno)
    {
        return deptRepository.findById(deptno).orElse(null);
    }
}
