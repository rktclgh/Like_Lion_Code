package com.mydb.core;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class EmpService {
    private final EmpDao empDao;

  @Autowired
    public EmpService(EmpDao empDao) {
        this.empDao = empDao;
    }

    public List<Emp> getAll() {
        return empDao.findAll();
    }

    public void insertEmpwithFail(Emp emp) {
      empDao.insert(emp);
      if(true)
      {
          throw new RuntimeException("강제 예외 발생!");
      }
    }
}
