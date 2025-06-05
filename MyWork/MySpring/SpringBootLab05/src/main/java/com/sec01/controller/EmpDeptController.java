package com.sec01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sec01.dto.EmpDeptDto;
import com.sec01.entity.Dept;
import com.sec01.entity.Emp;
import com.sec01.service.EmpDeptService;

@Controller
public class EmpDeptController {
	@Autowired
	private EmpDeptService service;
	
	/*
	 * @GetMapping("/emp-info") // 1 : 페이지 요청 public String showEmpDeptInfo(Model
	 * model, // 2 : 뷰 리졸버 값 전달 객체
	 * 
	 * @RequestParam(defaultValue = "0") int page, // 3 http 요청 파라미터
	 * 
	 * @RequestParam(defaultValue = "5") int size) {//4 http 요청 파라미터
	 * Page<EmpDeptDto> empPage = service.getEmpDeptPage(PageRequest.of(page,
	 * size));//5 페이지 객체 값 전달 model.addAttribute("empPage", empPage);//6 페이지 객체 전달 후
	 * 리턴 값 적용 return "emp-info";//7 리졸버 뷰로 이동 }
	 */
	
	@GetMapping("/emp-info") 
	public String showEmpDeptInfo(Model model, 
	                              @RequestParam(defaultValue = "0") int page, 
	                              @RequestParam(defaultValue = "5") int size, 
	                              @RequestParam(defaultValue = "ename") String sortBy, 
	                              @RequestParam(defaultValue = "asc") String direction) { 
	    Sort sort = direction.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() 
	                                                   : Sort.by(sortBy).descending(); 
	   
	    Page<EmpDeptDto> empPage = service.getEmpDeptPage(PageRequest.of(page, size, sort)); 
	    model.addAttribute("empPage", empPage); 
	    return "emp-info"; 
	} 
		
	@GetMapping("/emps")
	public String showAllEmps(Model model) {
		List<Emp> emps = service.getAllEmps();
		model.addAttribute("emps", emps);
		return "emps";
	}
	
	@GetMapping("/depts")
	public String showAllDepts(Model model) {
		List<Dept> depts = service.getAllDepts();
		model.addAttribute("depts", depts);
		return "depts";
	}
		
}

