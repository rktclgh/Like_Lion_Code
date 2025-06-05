package com.sec01.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sec01.dto.EmpDeptDto;
import com.sec01.entity.Dept;
import com.sec01.entity.Emp;
import com.sec01.repository.DeptRepository;
import com.sec01.repository.EmpDeptRepository;
import com.sec01.repository.EmpRepository;

@Service
public class EmpDeptService {
	@Autowired
	private EmpRepository empRepository;
	@Autowired
	private DeptRepository deptRepository;
	@Autowired
	private EmpDeptRepository empDeptRepository;
	
	public List<EmpDeptDto> getEmpDeptDtos(){
		return empDeptRepository.findEmpDeptInfo();
	}
	
	public List<Emp> getAllEmps(){
		
		return empRepository.findAll();
	}
	
	public List<Dept> getAllDepts(){
		return deptRepository.findAll();
	}
	
	public Page<EmpDeptDto> getEmpDeptPage(Pageable pageable){
		return empDeptRepository.findEmpDeptPage(pageable);
	}
}
