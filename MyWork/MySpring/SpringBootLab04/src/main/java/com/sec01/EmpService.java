package com.sec01;


import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpService {
    @Autowired
    private EmpRepository empRepository;
    //사원 전체 조회

    public List<Emp> findAll()
    {
        return empRepository.findAll();
    }

    //사원 상세 조회
    public Emp findById(int empno)
    {
        return empRepository.findById(empno).orElse(null);
    }

    @Transactional
    public void save(Emp emp)
    {
        empRepository.save(emp);
    }

    @Transactional
    public void delete(int empno)
    {
        empRepository.deleteById(empno);
    }


}
