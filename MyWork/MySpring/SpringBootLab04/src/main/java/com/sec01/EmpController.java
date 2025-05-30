package com.sec01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/emp")
public class EmpController {

    @Autowired
    private EmpRepository empRepository;
    @Autowired
    private DeptRepository deptRepository;

    @GetMapping
    public String redirectToList()
    {
        return "redirect:/emp/list";
    }

    // 2 사원 목록 & 부서 목록 조회
    @GetMapping("/list")
    public String getAll(Model model)
    {
        List<Emp> emps = empRepository.findAll();
        List<Dept> depts = deptRepository.findAll();

        model.addAttribute("emps",emps);
        model.addAttribute("depts",depts);

        return "emp/list"; // templates/emp/list.html
    }

    //3 사원 등록 화면

    @GetMapping("/new")
    public String createForm(Model model)
    {
        model.addAttribute("emp",new Emp()); // 폼 입력 값을 채우고 제출할 빈 Emp() 객체 전달
        model.addAttribute("depts",deptRepository.findAll()); // 이너뷰용 -> 폼 바인딩 오류 방지
        return "emp/new";
    }

    //4 사원 등록 처리
    /*
    * POST/emp
    * @GetMapping("/new") -> 요청되면 빈 EMP 객체를 가지고 emp/new.html로 이동한 후 데이터를 채운 Emp 객체를
    *                        가지고 현재 메소드가 호출된다. <form action="/emp/new" method="post" class = "mt=3">

    *
    * */
    @PostMapping
    public String create(@ModelAttribute Emp emp)
    {
        empRepository.save(emp);
        return "redirect:/emp/list";
    }

/*
* 5. 사원 상세 보기
*   /emp/{empno}   <a th:href = "@{'/emp/'+${emp.empno}}" class = "btn btn=info btn-sm">상세 </a>
*
*
* */
    @GetMapping("/{empno}")
    public String getById(@PathVariable int empno, Model model)
    {
        Emp emp = empRepository.findById(empno).orElse(null);
        model.addAttribute("emp",emp);
        return "emp/detail";// templates/emp/detail.html
    }
/*
* 6 사원 수정 화면
*
* */

    @GetMapping("/{empno}/edit")
    public String editForm(@PathVariable int empno, Model model)
    {
        Emp emp = empRepository.findById(empno).orElse(null);
        model.addAttribute("emp",emp);
        model.addAttribute("depts",deptRepository.findAll());
        return "emp/edit";
    }

/*
7 사원 수정 처리
POST/emp/{empno}/edit


* */

    @PostMapping("/{empno}/edit")
    public String update(@PathVariable int empno, @ModelAttribute Emp empDetails)
    {
        Emp emp = empRepository.findById(empno).orElse(null);
        if(emp != null)
        {
            emp.setEname(empDetails.getEname());
            emp.setJob(empDetails.getJob());
            emp.setSal(empDetails.getSal());
            emp.setDept(empDetails.getDept());
            empRepository.save(emp);

        }
        return "redirect:/emp/list";
    }

    /*
    * 8. 사원 삭제 처리
    * */


    @PostMapping("/{empno}/delete")
    public String delete(@PathVariable int empno)
    {
        empRepository.deleteById(empno);
        return "redirect:/emp";
    }


}
